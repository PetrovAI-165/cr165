
package kursa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Control {

    String answers[];
    public String setQuestions(int i,String num) {
    String message="";
    boolean flag=true;
        try {
            int j=0;
            BufferedReader reader = new BufferedReader(new FileReader("Questions"+num+".txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                if(i==j){
                    message+=line+="\r\n";
                    flag=false;
                }
                j++;
            }
            if(flag){
                JOptionPane.showMessageDialog(null, "Вопросов больше нет.", "Вопросы", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return message;
    }
      
    public int getAnswers(String k, int number,String num) {
        int j=1;
        k=k.toLowerCase();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Answers"+num+".txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                if(number==j && line.equals(k))
                  return 1;  
                  j++;
            }
            return 0;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void getAnswers1(String num) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Answers"+num+".txt"));
            String line;
            List<String> lines = new ArrayList<String>();
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            answers = new String[lines.size()];
            answers = lines.toArray(answers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
