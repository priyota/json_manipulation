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



public class json_read {
    public static void main(String[] args) throws IOException, ParseException {
        //jsonWrite();
        //jsonRead();
        //jsonList();
        //jsonlistread();
        //updatejson("name","rakhi");
       // updatestudentlist("name","riya");
        deletestudent(0);
    }
    private  static void jsonWrite() throws IOException {
        JSONObject empobj=new JSONObject();
        empobj.put("name","Mr Shajib");
        empobj.put("Department","IT");
        empobj.put("Designation","software engineer");
        JSONObject addressobj=new JSONObject();
        addressobj.put("present address","Badda Gulshan-1");
        addressobj.put("po","gulshan");
        addressobj.put("area","gulshan-1");
        empobj.put("Address",addressobj);
        System.out.println(empobj);
        FileWriter fw=new FileWriter("./src/main/resources/employee.json");
        fw.write(empobj.toJSONString());
        fw.flush();



    }
    private static void jsonRead() throws IOException, ParseException {
        JSONParser jsonparser=new JSONParser();
        Object obj= jsonparser.parse(new FileReader("./src/main/resources/employee.json"));
        JSONObject empobj=(JSONObject)obj;
        System.out.println(empobj);
        String name=(String)empobj.get("name");
        System.out.println(name);
        String designation=(String)empobj.get("Designation");
        System.out.println(designation);
        String department=(String)empobj.get("Department");
        System.out.println(department);
        JSONObject addressobj=(JSONObject) empobj.get("Address");
        String area=(String)addressobj.get("area");
        System.out.println(area);
        String present_address=(String)addressobj.get("present address");
        System.out.println(present_address);
        String po=(String)addressobj.get("po");
        System.out.println(po);



    }
    private static void jsonList() throws ParseException, IOException {
        char ch='y';
        String filename="./src/main/resources/student.json";
        do {

            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(filename));
            JSONObject studentObj = new JSONObject();
            Scanner input = new Scanner(System.in);
            System.out.println("Input student ID: ");
            studentObj.put("id", input.next());
            System.out.println("Input student name: ");
            studentObj.put("name", input.next());
            System.out.println("Input Department ");
            studentObj.put("department", input.next());

            JSONArray jsonStudentArray = (JSONArray) obj;
            jsonStudentArray.add(studentObj);

            System.out.print(jsonStudentArray);
            FileWriter file = new FileWriter(filename);
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
private static void jsonlistread() throws IOException, ParseException {
    int pos = 0;
    String filename = "./src/main/resources/student.json";
    JSONParser jsonParser = new JSONParser();
    Object obj = jsonParser.parse(new FileReader(filename));
    JSONArray jsonArray = (JSONArray) obj;
    System.out.println(jsonArray);
    JSONObject jsonobject = (JSONObject) jsonArray.get(pos);
    String name = (String) jsonobject.get("name");
    System.out.println(name);
    String id = (String) jsonobject.get("id");
    System.out.println(id);
    String dept = (String) jsonobject.get("department");
    System.out.println(dept);
}

private static void updatejson(String key,String value) throws IOException, ParseException {
    String filename = "./src/main/resources/employee.json";
    JSONParser jsonparser = new JSONParser();
    Object obj = jsonparser.parse(new FileReader(filename));
    JSONObject jsonobject = (JSONObject) obj;
    jsonobject.put(key,value);

    FileWriter fw = new FileWriter(filename);
    fw.write(jsonobject.toJSONString());
    fw.close();
    System.out.println("updated");
    System.out.println(jsonobject);
}
private static void updatestudentlist(String key,String value) throws IOException, ParseException {
    int pos=0;
    String filename="./src/main/resources/student.json";
    JSONParser jsonparser=new JSONParser();
    Object obj=jsonparser.parse(new FileReader(filename));
    JSONArray jsonarray=(JSONArray)obj;
    JSONObject stuobject=(JSONObject) jsonarray.get(pos);
    stuobject.put(key,value);
    FileWriter fw=new FileWriter(filename);
    fw.write(stuobject.toJSONString());
    fw.flush();
    fw.close();
    System.out.println("updated");
    System.out.println(stuobject);



}
private static void deletestudent( int index) throws IOException, ParseException {
    String fileName="./src/main/resources/student.json";
    JSONParser jsonParser = new JSONParser();
    Object obj = jsonParser.parse(new FileReader(fileName));
    JSONArray jsonArray = (JSONArray) obj;
    jsonArray.remove(index);
    FileWriter file = new FileWriter(fileName);
    file.write(jsonArray.toJSONString());
    file.flush();
    file.close();
    System.out.println("Deleted!");
    System.out.print(jsonArray);


    }


}



