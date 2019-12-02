import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemMaker {

    private Parser parser = new Parser();

    ArrayList<String> list = parser.fullParser();

    public String trash(String full, String throwAway) {
        Pattern p = Pattern.compile(throwAway);
        Matcher m = p.matcher(full);

        return m.replaceAll("");
    }

    public String correctSpellingAndCaps(String str) {
        Pattern p = Pattern.compile("0");
        Matcher m = p.matcher(str);

        str = m.replaceAll("o");
        str = str.toLowerCase();
        String c = str.substring(0, 1);

        return c + str.substring(1);
    }

    public String extractName(String str) {
        Pattern p = Pattern.compile("Name:.*;?");
        Matcher m = p.matcher(str);
        if (m.find()) {
            str = m.group();
        }
        str = correctSpellingAndCaps(str);
        return trash(str, "Name:");
    }

    public String extractPrice(String str) {
        Pattern p = Pattern.compile("Price:.*;?");
        Matcher m = p.matcher(str);
        if (m.find()) {
            str = m.group();
        }
        return trash(str, "Price:");
    }

    public String extractType(String str) {
        Pattern p = Pattern.compile("Type:.*;?");
        Matcher m = p.matcher(str);
        if (m.find()) {
            str = m.group();
        }
        str = correctSpellingAndCaps(str);
        return trash(str, "Type:");
    }

    public String extractExpiration(String str) {
        Pattern p = Pattern.compile("Expiration:.*;?");
        Matcher m = p.matcher(str);
        if (m.find()) {
            str = m.group();
        }
        return trash(str, "Expiration:");
    }

    public Item spliter(Integer num) {
        String str = list.get(num);

        String name = extractName(str);
        String price = extractPrice(str);
        String type = extractType(str);
        String expiration = extractExpiration(str);

        return new Item(name, price, type, expiration);
    }


}
