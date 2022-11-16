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

public class assignment {
    public static void main(String[] args) throws IOException, ParseException {
        int ch;
        Scanner sc=new Scanner(System.in);
        System.out.println("choose option");
        System.out.println("1.Add quiz");
        System.out.println("2.start quiz");
        ch=sc.nextInt();
        switch(ch) {
            case 1:
            writejson();
                break;
            case 2:
            jsonread();
            break;
        }

    }
    private static void writejson() throws IOException, ParseException {
         char ch='y';
         String filename="./src/main/resources/student.json";
         do {
             JSONParser jsonparser = new JSONParser();
             Object ob = jsonparser.parse(new FileReader(filename));
             JSONObject questionobj = new JSONObject();
             Scanner sc=new Scanner(System.in);
             System.out.println("Please add a ques here");

             questionobj.put("Question:",sc.nextLine());
             System.out.println("option a");
             questionobj.put("option a:",sc.nextLine());
             System.out.println("option b");
             questionobj.put("option b:",sc.nextLine());
             System.out.println("option c");
             questionobj.put("option c:",sc.nextLine());
             System.out.println("option d");
             questionobj.put("option d:",sc.nextLine());
             System.out.println("Answer");
             questionobj.put("answer:",sc.nextLine());

             JSONArray questionarray=(JSONArray)ob;
             questionarray.add(questionobj);
             FileWriter fw=new FileWriter(filename);
             fw.write(questionarray.toJSONString());
             fw.flush();
             fw.close();
             System.out.println("saved");
             System.out.println(questionarray);
             System.out.println("want to add more y/n");
             ch=sc.next().charAt(0);

         }
         while(ch!='n');

    }
private static void jsonread() throws IOException, ParseException {

    String filename = "./src/main/resources/student.json";
    JSONParser jsonParser = new JSONParser();
    Object obj = jsonParser.parse(new FileReader(filename));
    JSONArray jsonArray = (JSONArray) obj;
    int len=jsonArray.size();
    System.out.println(jsonArray);
    for(int pos=0;pos<len;pos++) {
        JSONObject jsonobject = (JSONObject) jsonArray.get(pos);
        String question = (String) jsonobject.get("Question:");
        System.out.println(question);
        String optiona = (String) jsonobject.get("option a:");
        System.out.println(optiona);
        String optionb = (String) jsonobject.get("option b:");
        System.out.println(optionb);
        String optionc = (String) jsonobject.get("option c:");
        System.out.println(optionc);
        String optiond = (String) jsonobject.get("option d:");
        System.out.println(optiond);
        String answer = (String) jsonobject.get("answer:");
        System.out.println(answer);
        System.out.println("enter your answer");
        Scanner sc=new Scanner(System.in);
        String ans=sc.nextLine();
        if(answer.equals(ans))
        {
            System.out.println("correct");
        }
        else
        {
            System.out.println(" not correct");
        }
    }

}
}
