import org.xml.sax.SAXException;

        import javax.xml.parsers.ParserConfigurationException;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;

public class main1 {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        tryOut n = new tryOut();
        List<String> s = new ArrayList<String>();
        s.add("Amitriptyline");
        n.scrapper(s);
    }
}
