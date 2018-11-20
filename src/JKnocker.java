import java.io.IOException;

public class JKnocker {

    private String host;

    public static void main(String[] args) {
        new JKnocker().start(args);
    }

    private void start(String... args) {
        // test
        if (args.length < 1) {
            System.out.println("Usage: jknocker hostname");
            return;
        }
        host = args[0];
        System.out.println(ping(77));
    }

    private boolean ping(int size) {
        StringBuilder sb = new StringBuilder();

        if (System.getProperty("os.name").startsWith("Windows")) {
            sb.append("ping -n 1 -l ").append(size).append(" ").append(host);
        } else {
            sb.append("ping -c 1 -s ").append(size).append(" ").append(host);
        }
        try {
            Process pingProc = Runtime.getRuntime().exec(sb.toString());
            pingProc.waitFor();
            return pingProc.exitValue() == 0;
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean udp(int port, byte[] data) {
        return false;
    }
}
