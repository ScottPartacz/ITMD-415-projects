package lab2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXDemo extends DefaultHandler
{
	@Override
	public void startDocument() throws SAXException
	{
		System.out.println("START OH NO");
		super.startDocument();
	}

	@Override
	public void endDocument() throws SAXException
	{
		System.out.println("END OH NO");
		super.endDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
	{
		System.out.printf("WHO BE STARTIN ME, '%s'?\n", qName);
		super.startElement(uri, localName, qName, attributes);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException
	{
		System.out.printf("WHO BE ENDIN ME, '%s'?\n", qName);
		super.endElement(uri, localName, qName);
	}
	
	public static void main(String[] args)
	{
		SAXDemo s = new SAXDemo();
		
		
	}
}
