package com.tencent.mm.c;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public final class f {
    private static boolean feg = false;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Map<String, String> y(String str, String str2) {
        int indexOf = str == null ? -1 : str.indexOf(60);
        if (indexOf < 0) {
            System.err.println("text not in xml format");
            return null;
        }
        if (indexOf > 0) {
            System.err.println("fix xml header from " + indexOf);
            str = str.substring(indexOf);
        }
        if (str == null || str.length() <= 0) {
            return null;
        }
        Map<String, String> hashMap = new HashMap();
        try {
            DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            if (newDocumentBuilder == null) {
                System.err.println("new Document Builder failed");
                return null;
            }
            Document parse;
            try {
                parse = newDocumentBuilder.parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
                parse.normalize();
            } catch (DOMException e) {
                parse = null;
            } catch (SAXException e2) {
                return null;
            } catch (IOException e3) {
                return null;
            } catch (Exception e4) {
                return null;
            }
            if (parse == null) {
                System.err.println("new Document failed");
                return null;
            }
            Object documentElement = parse.getDocumentElement();
            if (documentElement == null) {
                System.err.println("getDocumentElement failed");
                return null;
            }
            if (str2 == null || !str2.equals(documentElement.getNodeName())) {
                NodeList elementsByTagName = documentElement.getElementsByTagName(str2);
                if (elementsByTagName.getLength() <= 0) {
                    System.err.println("parse item null");
                    return null;
                }
                if (elementsByTagName.getLength() > 1) {
                    System.err.println("parse items more than one");
                }
                a(hashMap, "", "", elementsByTagName.item(0), 0);
            } else {
                a(hashMap, "", "", documentElement, 0);
            }
            if (feg) {
                h(hashMap);
            }
            return hashMap;
        } catch (ParserConfigurationException e5) {
            return null;
        }
    }

    private static void a(Map<String, String> map, String str, String str2, Node node, int i) {
        if (node.getNodeName().equals("#text")) {
            map.put(str, node.getNodeValue());
            map.put(str2, node.getNodeValue());
        } else if (node.getNodeName().equals("#cdata-section")) {
            map.put(str, node.getNodeValue());
            map.put(str2, node.getNodeValue());
        } else {
            String str3;
            int i2;
            String stringBuilder = new StringBuilder(String.valueOf(str)).append(".").append(node.getNodeName()).toString();
            String stringBuilder2 = new StringBuilder(String.valueOf(str2)).append(".").append(node.getNodeName()).toString();
            if (i > 0) {
                stringBuilder = new StringBuilder(String.valueOf(stringBuilder)).append(i).toString();
                map.put(stringBuilder, node.getNodeValue());
                stringBuilder2 = new StringBuilder(String.valueOf(stringBuilder2)).append("#").append(i).toString();
                map.put(stringBuilder2, node.getNodeValue());
                str3 = stringBuilder;
                stringBuilder = stringBuilder2;
            } else {
                map.put(stringBuilder, node.getNodeValue());
                map.put(stringBuilder2, node.getNodeValue());
                str3 = stringBuilder;
                stringBuilder = stringBuilder2;
            }
            NamedNodeMap attributes = node.getAttributes();
            if (attributes != null) {
                for (i2 = 0; i2 < attributes.getLength(); i2++) {
                    Node item = attributes.item(i2);
                    map.put(new StringBuilder(String.valueOf(str3)).append(".$").append(item.getNodeName()).toString(), item.getNodeValue());
                    map.put(new StringBuilder(String.valueOf(stringBuilder)).append(".$").append(item.getNodeName()).toString(), item.getNodeValue());
                }
            }
            HashMap hashMap = new HashMap();
            NodeList childNodes = node.getChildNodes();
            for (int i3 = 0; i3 < childNodes.getLength(); i3++) {
                Node item2 = childNodes.item(i3);
                Integer num = (Integer) hashMap.get(item2.getNodeName());
                i2 = num == null ? 0 : num.intValue();
                a(map, str3, stringBuilder, item2, i2);
                hashMap.put(item2.getNodeName(), Integer.valueOf(i2 + 1));
            }
        }
    }

    private static void h(Map<String, String> map) {
        if (map.size() <= 0) {
            System.err.println("empty values");
            return;
        }
        for (Entry entry : map.entrySet()) {
            System.err.println("key=" + ((String) entry.getKey()) + " value=" + ((String) entry.getValue()));
        }
    }
}
