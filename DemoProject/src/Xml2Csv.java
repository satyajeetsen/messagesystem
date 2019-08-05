import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotSupportedException;

class Xml2Csv {

    public static void main(String args[]) throws IOException, ParserConfigurationException,
            SAXException,TransformerException {
        // Path of folder where files are located
        String folder_path = "C:\\Users\\files";
        // creating new folder
        File flir = new File(folder_path);
        File[] file_array = flir.listFiles();
        for (int i = 0; i < file_array.length; i++)
        {
            if (file_array[i].isFile())
            {
                //xsl stylesheet
                File stylesheet = new File("C:\\Users\\Satyajeet Sen\\Desktop\\xmlfiles.xsl");
                File xmlSource = new File(""+file_array[i]);
                String file_name = file_array[i].getName().substring(0,9);
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(xmlSource);
                StreamSource stylesource = new StreamSource(stylesheet);
                Transformer transformer = TransformerFactory.newInstance()
                        .newTransformer(stylesource);
                Source source = new DOMSource(document);
                Result outputTarget = new StreamResult(new File(file_name + ".csv"));
                transformer.transform(source, outputTarget);
            }
        }
    }
}