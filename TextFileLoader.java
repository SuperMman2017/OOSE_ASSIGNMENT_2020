import java.util.LinkedList;
import java.io.*;

/*Text file reader class thta  */
public class TextFileLoader extends Loader{
    public static final String LOADER_TYPE = "Text File";
    public TextFileLoader() {

    }

    /*This method reads a file and returns a list of strings for each line in the file*/
    @Override public LinkedList<String> Load(String file) {
        LinkedList<String> lines = new LinkedList<>();

        try (BufferedReader bfr = new BufferedReader(new FileReader(file)) ) {
            String currentLine = bfr.readLine();
            while(currentLine != null) {
                lines.add(currentLine);
                currentLine = bfr.readLine();
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    @Override public String toString() {
        return LOADER_TYPE;
    }
}