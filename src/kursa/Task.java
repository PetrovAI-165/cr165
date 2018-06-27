package kursa;

import java.io.*;

public class Task {

    public boolean addMaterial(String material, String number) {
        String filePath = "Lesson"+number+".txt";
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            File file = new File("Lesson"+number+".txt");
            if (file.length()==0) {
                bufferWriter.write(material);                
            }else{
                bufferWriter.write("\r\n" + material);            
            }
            bufferWriter.close();
            return true;
        } catch (IOException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean addQuestion(String question,String num) {
        String filePath = "Questions"+num+".txt";
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            File file = new File("Questions"+num+".txt");
            if (file.length()==0) {
                bufferWriter.write(question);                
            }else{
                bufferWriter.write("\r\n" + question);            
            }
            bufferWriter.close();
            return true;
        } catch (IOException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean addAnswer(String answer,String num) {
        String filePath = "Answers"+num+".txt";
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            File file = new File("Answers"+num+".txt");
            if (file.length()==0) {
                bufferWriter.write(answer);                
            }else{
                bufferWriter.write("\r\n" + answer);
            }
            bufferWriter.close();
            return true;
        } catch (IOException e) {
            System.out.println(e);
        }
        return false;
    }
}
