import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        Parse parcer = new Parse();
        ArrayList<String> BMW = parcer.ParserFromWeb();
        System.out.println(BMW);
        new Excel(BMW);
        BMW.clear();
    }
}
