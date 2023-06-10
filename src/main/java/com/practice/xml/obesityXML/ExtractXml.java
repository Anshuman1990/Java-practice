package com.practice.xml.obesityXML;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExtractXml extends DefaultHandler {
    private StringBuilder stringBuilder;
    Map<Integer, String> map = new HashMap<>();
    String classifier;
    String name;
    String value;

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        String path = System.getProperty("user.dir");
        path = path+"\\dataset\\obesity_patient_records_training.xml";
        File f = new File(path);
        ExtractXml extractXml = new ExtractXml();
        extractXml.extact(f.getAbsolutePath());
        Map map = extractXml.getMap();
        System.out.println(map.keySet());
    }

    public void extact(String path) throws SAXException, IOException, ParserConfigurationException {
        stringBuilder = new StringBuilder();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(new File(path), this);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("doc")) {
            if (attributes.getLength() == 1) {
                name = attributes.getQName(0);
                if (name.equalsIgnoreCase("id")) {
                    value = attributes.getValue(0);
                }
            }

        }
        else if(qName.equalsIgnoreCase("text")){
            classifier = "text";
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (classifier != null) {
            if (classifier.equalsIgnoreCase("text") && !stringBuilder.toString().isEmpty()) {
                map.put(Integer.valueOf(value), stringBuilder.toString());
                stringBuilder.setLength(0);
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch, start, length);
        data = data.trim();
        if(!data.isEmpty())
        stringBuilder.append(data);
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    public Map<Integer, String> getMap() {
        return map;
    }
}
