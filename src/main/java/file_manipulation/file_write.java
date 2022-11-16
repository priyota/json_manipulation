package file_manipulation;

import java.io.FileWriter;
import java.io.IOException;

public class file_write {
    public static void main(String[] args) throws IOException {
        FileWriter fw=new FileWriter("./src/main/resources/test.txt",true);
        fw.write("hello world");
        fw.write("\n");
        fw.write("hello world");
        fw.close();
    }
}
