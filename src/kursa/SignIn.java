package kursa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SignIn {

    private static final String DIRECTORY = "D:\\";

    public boolean signInSystem(String login, String password) {
        int q=0;
        boolean b=false;
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
                System.out.println(st.login+" "+st.password);
                if (login.equals(st.login) && password.equals(st.password)) {
                    b=true;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("IO Excaption | ClassNotFoundException" + ex);
        }
        if(b){
            File f1=new File("User.txt");
            if(f1.exists()){
                f1.delete();
            }
            try {
                FileWriter writer = new FileWriter("User.txt", true);
                BufferedWriter bufferWriter = new BufferedWriter(writer);
                bufferWriter.write(login);
                bufferWriter.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        return b;
    }
}
