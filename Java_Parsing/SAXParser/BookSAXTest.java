package SAXParser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class BookSAXTest {

	public static void main(String[] args) throws Exception{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		parser.parse("src/SAXParser/book.xml", new BookSAXParserHandler());
	}

}
