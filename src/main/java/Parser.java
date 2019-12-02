import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static String file;

    public Parser() {
        file = loadFile();
    }

    private String loadFile(){
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            return IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        }catch(IOException e){
            return "File could not be found.";
        }
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        Parser.file = file;
    }

    //  General format for finding patterns to replace with appropriate String
    public void pattern(String original, String replacement) {
        Pattern p = Pattern.compile(original, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(getFile());

        setFile(m.replaceAll(replacement));
    }

    //  Inserting indents for readability
    public void indent() {
        pattern("##", ";\n");
    }

    //  Reformatting "key" names to all program to read text consistently
    public void keys() {
        pattern("NAME.", "Name:");
        pattern(".PRICE.", ";Price:");
        pattern(".TYPE.", ";Type:");
        pattern(".EXPIRATION.", ";Expiration:");
    }


    public ArrayList<String> fullParser() {

        ArrayList<String> list = new ArrayList<>();

        indent();
        keys();

        Pattern p = Pattern.compile("Name:.+");
        Matcher m = p.matcher(getFile());

        while(m.find()) {
            list.add(m.group());
        }

        return list;
    }
}
