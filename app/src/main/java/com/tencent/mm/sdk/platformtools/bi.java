package com.tencent.mm.sdk.platformtools;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Node;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public final class bi {
    private static ThreadLocal<XmlPullParser> xiL = new ThreadLocal();

    private static class a {
        private XmlPullParser xiM;
        private String xiN;
        private StringBuilder xiO = new StringBuilder();
        private Map<String, String> xiP;
        private Map<Integer, Integer> xiQ;

        public a(String str, String str2) {
            this.xiN = str2;
            XmlPullParser xmlPullParser = (XmlPullParser) bi.xiL.get();
            this.xiM = xmlPullParser;
            if (xmlPullParser == null) {
                ThreadLocal cgE = bi.xiL;
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                this.xiM = newPullParser;
                cgE.set(newPullParser);
            }
            this.xiM.setInput(new StringReader(str));
            this.xiQ = new HashMap();
            this.xiP = new HashMap();
        }

        public final Map<String, String> cgF() {
            int eventType = this.xiM.getEventType();
            while (eventType != 1) {
                int next = this.xiM.next();
                String str;
                if (next == 2) {
                    this.xiO.append('.').append(this.xiM.getName());
                    String stringBuilder = this.xiO.toString();
                    int hashCode = stringBuilder.hashCode();
                    Integer num = (Integer) this.xiQ.get(Integer.valueOf(hashCode));
                    if (num != null) {
                        num = Integer.valueOf(num.intValue() + 1);
                        this.xiO.append(num);
                        this.xiQ.put(Integer.valueOf(hashCode), num);
                        str = stringBuilder + num;
                    } else {
                        this.xiQ.put(Integer.valueOf(hashCode), Integer.valueOf(0));
                        str = stringBuilder;
                    }
                    this.xiP.put(str, "");
                    for (int i = 0; i < this.xiM.getAttributeCount(); i++) {
                        this.xiP.put(str + ".$" + this.xiM.getAttributeName(i), this.xiM.getAttributeValue(i));
                    }
                    eventType = next;
                } else if (next == 4) {
                    str = this.xiM.getText();
                    if (str != null) {
                        this.xiP.put(this.xiO.toString(), str);
                    }
                    eventType = next;
                } else {
                    if (next == 3) {
                        this.xiO = this.xiO.delete(this.xiO.lastIndexOf("."), this.xiO.length());
                        if (this.xiO.length() == 0) {
                            break;
                        }
                    }
                    eventType = next;
                }
            }
            return this.xiP;
        }
    }

    public static Map<String, String> y(String str, String str2) {
        Map<String, String> map = null;
        int indexOf = str == null ? -1 : str.indexOf("<" + str2);
        if (indexOf < 0) {
            x.e("MicroMsg.SDK.XmlParser", "can not find the tag <%s>", str2);
        } else {
            if (indexOf > 0) {
                str = str.substring(indexOf);
            }
            try {
                map = new a(str, str2).cgF();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SDK.XmlParser", e, "[ %s ]", str);
            }
        }
        return map;
    }

    public static String b(Node node) {
        Writer stringWriter = new StringWriter();
        try {
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("omit-xml-declaration", "yes");
            newTransformer.transform(new DOMSource(node), new StreamResult(stringWriter));
        } catch (TransformerException e) {
            x.e("MicroMsg.SDK.XmlParser", "nodeToString: %s", e.getMessage());
        }
        return stringWriter.toString();
    }
}
