import org.apache.commons.io.IOUtils;

public class Main {

    private static Parser parser = new Parser();

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();

        parser.fullParser();

        String result = parser.getFile();
        System.out.println(output);
        System.out.println(result);
    }
}
