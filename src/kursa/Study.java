package kursa;

import java.util.*;
import java.io.*;

public class Study {

    public String getMaterial(String number) {
        String message="";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Lesson"+number+".txt"));
            String line;
            List<String> lines = new ArrayList<String>();
            while ((line = reader.readLine()) != null) {
                lines.add(line);
                message+=line+="\r\n";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return message;
    }
}
