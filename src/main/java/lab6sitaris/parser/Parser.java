package lab6sitaris.parser;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parser {

    public static Catalog parseCatalog(){
        Catalog catalog = null;
        String path = new File("D:\\sitaris\\lab6\\src\\main\\resources\\products.xml").getAbsolutePath();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            ProductXMLHandler handler = new ProductXMLHandler();
            parser.parse(new File(path), handler);
            catalog = handler.getMyCatalog();

        } catch (IOException e){
            System.err.println(e);
        } catch (ParserConfigurationException | SAXException e){
            e.printStackTrace();
        }

        return catalog;
    }
}
