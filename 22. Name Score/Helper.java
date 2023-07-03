import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class Helper {
    private String filename, out_file;

    public Helper(String filename){
        this.filename = filename;
        this.out_file = "output.txt";
        
    }

    public void sortFile() {
        BufferedReader reader = null;
        BufferedWriter writer = null;

        ArrayList<String> lines = new ArrayList<String>();

        try {
            reader = new BufferedReader(new FileReader(filename));

            String currentLine = reader.readLine();

            while (currentLine != null) {
                lines.add(currentLine);
                currentLine = reader.readLine();
            }

            Collections.sort(lines);
            // System.out.println(lines.get(0));

            writer = new BufferedWriter(new FileWriter(this.out_file));


            for (String line : lines) {
                writer.write(line);

                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }

                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Integer getNameScore(String name, Integer lineNo){
        Integer score = 0, chValue;
        for(Character c : name.toCharArray()){
            if(c != '"'){
                chValue = (int)c;
                // System.out.println("CH "+   c + " " + chValue);
                if(chValue > 96 && chValue < 124){
                    score += (chValue - 96);
                } else if(chValue > 64 && chValue < 92){
                    score += (chValue - 64);
                }

                // System.out.println("score "+ score);
            }
        }
        return score*lineNo;
    }

    public long countScore(){
        long count =0;
        Integer lineNo=0;

        try{
            BufferedReader br = new BufferedReader(new FileReader(this.out_file));
            String line = br.readLine();

            while (line != null){
                lineNo++;
                count += getNameScore(line, lineNo);
                line = br.readLine();
                // System.out.println("Sum " + count);
            }
        }catch(IOException e){
            System.out.println(e.getStackTrace());
        }

        return count;
    }

}