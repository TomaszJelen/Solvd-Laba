package solvd.laba.library.xml;

import org.xml.sax.SAXException;
import solvd.laba.library.model.Room;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.XMLConstants;
import java.io.File;
import java.io.IOException;

public class Parsing {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        Schema schema = null;
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory schemaFactory = SchemaFactory.newInstance(language);
        schema = schemaFactory.newSchema(new File("src/main/resources/librarySchema.xml"));
        factory.setSchema(schema);

        SAXParser saxParser = factory.newSAXParser();
        RoomHandler roomHandler = new RoomHandler();
        saxParser.parse("src/main/resources/library.xml", roomHandler);
        Room result = roomHandler.getRoom();
        System.out.println(result);
    }


}
