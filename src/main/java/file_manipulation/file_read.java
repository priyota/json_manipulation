package file_manipulation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class file_read


{
    public static void main(String[] args) throws IOException {
        FileReader fw=new FileReader("./src/main/resources/test.txt");
        int character;
        while((character=fw.read())!=-1)
        {
            System.out.println((char)character);
        }
        fw.close();

    }
}
