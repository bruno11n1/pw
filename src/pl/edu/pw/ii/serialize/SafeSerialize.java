package pl.edu.pw.ii.serialize;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.SignedObject;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.HashSet;
import java.util.Set;

/*
keytool -genseckey -keystore keystore.jck -storetype jceks -storepass mypass -keyalg AES -keysize 128 -alias encryption
keytool -genkeypair -keystore keystore.jck -storetype jceks -storepass mypass -keyalg RSA -keysize 2048 -alias signature
*/

public class SafeSerialize {
    public static void main(String[] args) throws IOException, ClassNotFoundException, CertificateException,
            NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, InvalidKeyException,
            NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, SignatureException {
        String keystoreFile = "keystore.jck";
        String password = "mypass";
        String encAlias = "encryption";
        String sigAlias = "signature";

	    // wczytanie repozytorium kluczy
        InputStream keystoreStream = new FileInputStream(keystoreFile);

        KeyStore keystore = KeyStore.getInstance("JCEKS");
        keystore.load(keystoreStream, password.toCharArray());

        if (!keystore.containsAlias(encAlias) || !keystore.containsAlias(sigAlias)) {
            throw new RuntimeException("Nie znaleziono klucza");
        }

        Key encKey = keystore.getKey(encAlias, password.toCharArray());
        Key sigKey = keystore.getKey(sigAlias, password.toCharArray());

        String filename = "dane.dat";

	    // kolekcja i jej serializacja
        Set<String> someStrings = new HashSet<String>();
        someStrings.add("moje");
        someStrings.add("dane");

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, encKey);
        SealedObject sealed = new SealedObject((Serializable) someStrings, cipher);

        Signature signature = Signature.getInstance("SHA256withRSA");
        SignedObject signed = new SignedObject(sealed, (PrivateKey) sigKey, signature);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
        oos.writeObject(signed);

        Certificate sigVer = keystore.getCertificate(sigAlias);

	    // deserializacja
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
        signed =(SignedObject) ois.readObject();
        System.out.println(signed.verify(sigVer.getPublicKey(), signature));
        sealed = (SealedObject) signed.getObject();
        cipher.init(Cipher.DECRYPT_MODE, encKey);
        Set<String> aNewSet = (HashSet<String>) sealed.getObject(cipher);
        System.out.println(aNewSet);
    }
}
