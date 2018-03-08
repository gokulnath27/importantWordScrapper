import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;


public class wikiPedia {
    public  void wikiMessage(String wikiWord) throws IOException, ParserConfigurationException, SAXException {
        URL url = new URL("https://en.wikipedia.org/w/api.php?action=opensearch&search="+wikiWord+"&limit=3&format=xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(url.openStream());
        System.out.println(document.getElementsByTagName("Description").item(0).getTextContent());
    }
}

