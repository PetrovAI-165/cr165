package kursa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Registration {

    private static final String DIRECTORY = "D:\\";

    public void signUpFileWrite() {
        Student st1 = new Student("Alexandr", "Tyshchenko", "AI-152","Alex76", "1352");
        Student st2 = new Student("Ivan", "Duma", "AI-152","Ivan76", "2326");
        Student st3 = new Student("Ira", "Efimenko", "AI-152","Ira76", "3523");
        Student st4 = new Student("Maxim", "Duma", "AI-152","Maxim76", "4316");
        Student st5 = new Student("Oleg", "Ivanov", "AI-152","Oleg76", "5123");
        Student st6 = new Student("Vadim", "Miroshnichenko", "AI-152","Vadim76", "6316");
        try {
            final FileOutputStream fos = new FileOutputStream("address.ser");
            final ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(st1);
            oos.writeObject(st2);
            oos.writeObject(st3);
            oos.writeObject(st4);
            oos.writeObject(st5);
            oos.writeObject(st6);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("IO Excaption" + ex);
        }
    }

    public void register(String n,String sn,String g,String l, String p) {
        int q=0;
        boolean b=true;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("amount.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                    q=Integer.parseInt(line);
                    System.out.println(line);
            }
            System.out.println(q);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<Student> students = new ArrayList<Student>();
        try (FileInputStream fin = new FileInputStream("address.ser")) {
            ObjectInputStream ois = new ObjectInputStream(fin);
            for (int i = 0; i < q; i++) {
                Student st = (Student) ois.readObject();
                students.add(st);
                if (sn.equals(st.surname)&& n.equals(st.name) && g.equals(st.group)) {
                    JOptionPane.showMessageDialog(null, "Студент с такими данными уже зарегестрирован.", "Регистрация", JOptionPane.WARNING_MESSAGE);
                    b=false;
                }
            }
            if(b){
                    Student k=new Student(n,sn,g,l,p);
                    students.add(k);
                }
        }
        catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("IO Excaption | ClassNotFoundException" + ex);
        }
        try{ 
            final FileOutputStream fos = new FileOutputStream("address.ser");
            final ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Student x : students) {
                    oos.writeObject(x);
                }
            
        }catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("IO Excaption" + ex);
        }
        if(b){
            try {
                FileWriter writer = new FileWriter("amount.txt", true);
                BufferedWriter bufferWriter = new BufferedWriter(writer);
                int t=q+1;
                bufferWriter.write("\r\n" + t);
                System.out.println(t);
                bufferWriter.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
    public void getList(String g){
        int q=0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("amount.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                    q=Integer.parseInt(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String message="";
        try (FileInputStream fin = new FileInputStream("address.ser")) {
            ObjectInputStream ois = new ObjectInputStream(fin);
            int h=0;
            for (int i = 0; i < q; i++) {
                Student st = (Student) ois.readObject();
                if(g.equals(st.group)){
                h++;    
                message+=h+") ";
                message+=st.name+=" ";
                message+=st.surname+="\r\n";
                }
            }
            if(message==""){
                message+="Студенты данной группы еще не зарегестрированы в системе.";
            }
            JOptionPane.showMessageDialog(null, message, "Список студентов", JOptionPane.DEFAULT_OPTION);    
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("IO Excaption | ClassNotFoundException " + ex);
        }
    }
    public void getDocument(String login){
        String message;
        message=login+"\r\n";
        File f1=new File(login+".txt");
        if(f1.exists()){
            try {
                BufferedReader reader = new BufferedReader(new FileReader(login+".txt"));
                String line;
                List<String> lines = new ArrayList<String>();
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
                for(String x:lines){
                    message+=x+="\r\n";
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            JOptionPane.showMessageDialog(null, message, "Document", JOptionPane.DEFAULT_OPTION);
        }else{
            JOptionPane.showMessageDialog(null, "Вы еще не отвечали на вопросы.", "Document", JOptionPane.DEFAULT_OPTION);
        }
        
       
    }
    public String getMark(String name, String surname){
        int q=0;
        String login="";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("amount.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                    q=Integer.parseInt(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (FileInputStream fin = new FileInputStream("address.ser")) {
            ObjectInputStream ois = new ObjectInputStream(fin);
            for (int i = 0; i < q; i++) {
                Student st = (Student) ois.readObject();
                if (surname.equals(st.surname)&& name.equals(st.name)) {
                    login=st.login;
                }
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("IO Excaption | ClassNotFoundException" + ex);
        }
        return login;
      }
}
