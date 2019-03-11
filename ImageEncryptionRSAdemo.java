import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
/**
 * A CipherInputStream is composed of an InputStream and a cipher so that read() methods return data
 * that are read in from the underlying InputStream but have been additionally processed by the
 * Cipher. The cipher must be fully initialized before being used by a CipherInputStream.
 * Cipher is the primary class of java cryptography, it provides encryption and decryption functionality. Cipher class provides below static method to get a Cipher object.
 * 
 * For example, if the Cipher is initialized for decryption, the
 * CipherInputStream will attempt to read in data and decrypt them,
 * before returning the decrypted data.
 */
public class ImageEncryptionRSAdemo
{
    public static void main(String[] args) {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            Cipher cipher = Cipher.getInstance("RSA");

            kpg.initialize(2048);
            KeyPair kp = kpg.generateKeyPair();
            PrivateKey prKey = kp.getPrivate();
            PublicKey puKey = kp.getPublic();

            cipher.init(Cipher.ENCRYPT_MODE, puKey);
            FileInputStream fis = new FileInputStream(new File("/Users/kushal/Downloads/Citizen-1.jpg"));  //reads  streams of raw bytes such as image data.
            FileOutputStream fos = new FileOutputStream(new File("/Users/kushal/Downloads/EncryptedUnknown.txt"), true);  //Writes data or streams of raw bytes such as image data. It’s good to use with bytes of data that can’t be represented as text such as PDF, excel documents, image files etc to a path specified file or FileDescriptor.
            CipherInputStream cipher1 = new CipherInputStream(fis, cipher);
            int i;
            while((i = cipher1.read()) != -1)
            {
                fos.write(i);
            }
            System.out.println("Successfully encrypted !!!!!!");
            fos.close();
            fis.close();
            cipher1.close();
        } catch (Exception e) {
            //TODO: handle exception
            e.getStackTrace();
        }
    }
}