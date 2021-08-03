package SAXParser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class BookSAXParserHandler extends DefaultHandler {

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equals("title")) {
			System.out.print("제목: ");
		} else if (qName.equals("isbn")) {
			System.out.print("isbn: ");
		} else if (qName.equals("author")) {
			System.out.print("저자: ");
		} else if (qName.equals("publisher")) {
			System.out.print("출판사: ");
		} else if (qName.equals("price")) {
			System.out.print("가격: ");
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("title")) {
			System.out.print(",");
		} else if (qName.equals("isbn")) {
			System.out.print(",");
		} else if (qName.equals("author")) {
			System.out.print(",");
		} else if (qName.equals("publisher")) {
			System.out.print(",");
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String content = new String(ch, start, length);
		System.out.print(content);
	}

}
