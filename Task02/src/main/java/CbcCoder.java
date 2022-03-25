import lombok.SneakyThrows;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class CbcCoder {

    private final Cipher cipher;
    private final SecretKey key;
    private final IvParameterSpec initializationVector;

    @SneakyThrows
    public CbcCoder(String key, String initializationVector) {
        cipher = Cipher.getInstance("AES/CBC/NoPADDING");
        this.key = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
        this.initializationVector = new IvParameterSpec(initializationVector.getBytes(StandardCharsets.UTF_8));
    }

    @SneakyThrows
    public byte[] encode(String message) {
        int numberOfSpaces = (message.length() / 16 + 1) * 16 - message.length();
        cipher.init(Cipher.ENCRYPT_MODE, key, initializationVector);
        return cipher.doFinal((message + " ".repeat(numberOfSpaces)).getBytes(StandardCharsets.UTF_8));
    }

    @SneakyThrows
    public byte[] decode(byte[] bytes) {
        cipher.init(Cipher.DECRYPT_MODE, key, initializationVector);
        return cipher.doFinal(bytes);
    }

}
