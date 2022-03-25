public class Hacker {

    private final CbcCoder coder;

    public Hacker(CbcCoder coder) {
        this.coder = coder;
    }

    public byte[] replace(String code) {
        byte[] encodedBytes = coder.encode(code);
        byte[] substitutedBytes = coder.encode("alert(\"You are pwned!\");//");
        byte[] result = new byte[substitutedBytes.length + encodedBytes.length];
        System.arraycopy(substitutedBytes, 0, result, 0, substitutedBytes.length);
        System.arraycopy(encodedBytes, 0, result, substitutedBytes.length, encodedBytes.length);
        return result;
    }

}
