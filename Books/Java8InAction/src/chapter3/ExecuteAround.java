package chapter3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAround {
    private static final String FILE = ExecuteAround.class.getResource("./data.txt").getFile();

    public static void main(String arg[]) throws IOException {
// method we want to refactor to make more flexible
        String result = processFileLimited();
        System.out.println(result);

        result = processFile(b -> b.readLine() + " : " + b.readLine());
        System.out.println(result);
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("src/chapter3/data.txt"))) {
            return p.process(br);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String processFileLimited() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("src/chapter3/data.txt"))) {
            return br.readLine();
        }
    }

    public interface BufferedReaderProcessor {
        public String process(BufferedReader b) throws IOException;

    }
}
