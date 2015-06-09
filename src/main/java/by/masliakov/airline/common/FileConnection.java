package by.masliakov.airline.common;

import by.masliakov.airline.exception.TechnicalException;
import by.masliakov.airline.exception.WrongConfigurationException;
import by.masliakov.airline.message.TypeExceptionMessage;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by mrstark on 9.6.15.
 */
public class FileConnection {
    private String filePath;
    private Document document;

    public FileConnection(String filePath) {
        this.filePath = filePath;
    }

    public Document connect() throws TechnicalException, WrongConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(filePath);
        } catch (ParserConfigurationException e) {
            throw new WrongConfigurationException(TypeExceptionMessage.WRONG_CONFIGURE);
        } catch (SAXException e) {
            throw new WrongConfigurationException(TypeExceptionMessage.WRONG_CONFIGURE);
        } catch (IOException e) {
            throw new TechnicalException(TypeExceptionMessage.FILE_NOT_FOUND);
        }
        return document;
    }
}
