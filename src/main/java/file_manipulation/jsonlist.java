package file_manipulation;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class jsonlist {
    public static void main(String[] args) throws IOException, ParseException {
          jsonlist();
    }
    private static void jsonlist() throws IOException, ParseException {
        char ch='y';
        String filename="./src/main/resources/student.json";
        do {


            JSONParser jsonparser = new JSONParser();
            Object obj=jsonparser.parse(new FileReader(filename));
            JSONObject studentobj=new JSONObject();
            Scanner input=new Scanner(System.in);
            System.out.println("Input student ID: ");
            studentobj.put("id", input.next());
            System.out.println("Input student name: ");
            studentobj.put("name", input.next());
            System.out.println("Input Department ");
            studentobj.put("department", input.next());
            JSONArray jsonStudentArray = (JSONArray) obj;
            jsonStudentArray.add(studentobj);
            System.out.print(jsonStudentArray);
            FileWriter file=new FileWriter(filename);
            file.write(jsonStudentArray.toJSONString());
            file.flush();
            file.close();
            System.out.println("Saved!");
            System.out.print(jsonStudentArray);
            System.out.println("\nDo you want to add more?[y/n]");
            ch=input.next().charAt(0);



        }
        while(ch!='n');
    }
}
