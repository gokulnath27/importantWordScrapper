import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.ArrayCoreMap;
import edu.stanford.nlp.util.CoreMap;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class tryOut<C extends ArrayCoreMap> {

    public void scrapper(List<String> derivedWords) throws IOException, ParserConfigurationException, SAXException {
        Properties stanfordCoreNLPProperties = new Properties();
        stanfordCoreNLPProperties.setProperty("annotators", "tokenize, ssplit, pos");
        stanfordCoreNLPProperties.setProperty("tokenize.language", "en");
        wikiPedia message = new wikiPedia();
        StanfordCoreNLP pipeline = new StanfordCoreNLP(stanfordCoreNLPProperties);
        for (String eachWord : derivedWords) {
            Annotation document = new Annotation(eachWord);
            pipeline.annotate(document);
            CoreLabel example = CoreLabel.wordFromString(eachWord);
            example.get(CoreAnnotations.PartOfSpeechAnnotation.class);
            List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
            for (CoreMap sentence : sentences) {
                for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                    String word = token.get(CoreAnnotations.TextAnnotation.class);
                    String posTag = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                    if(posTag.trim().equals("NNP")){
                        message.wikiMessage(word.trim());
                    }
                }
            }
        }
    }
}