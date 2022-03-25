import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        CbcCoder coder = new CbcCoder("YELLOW SUBMARINE", "0".repeat(16));
        Hacker hacker = new Hacker(coder);
        String alert = "alert(\"Hello world!\");";
        byte[] oldBytes = coder.encode(alert);
        byte[] newBytes = hacker.replace(alert);
        System.out.println(new String(oldBytes, StandardCharsets.UTF_8));
        System.out.println(new String(coder.decode(oldBytes), StandardCharsets.UTF_8));
        System.out.println(new String(newBytes, StandardCharsets.UTF_8));
        System.out.println(new String(coder.decode(newBytes), StandardCharsets.UTF_8));
    }

}
