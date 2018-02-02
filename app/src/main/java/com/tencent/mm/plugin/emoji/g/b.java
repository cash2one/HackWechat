package com.tencent.mm.plugin.emoji.g;

import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class b {
    public static ArrayList<rw> yz(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.emoji.EmojiBackupXMLParser", "[backup emotion parser] parse xml faild. xml is null.");
            return null;
        }
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("EmojiMd5");
            if (elementsByTagName == null || elementsByTagName.getLength() <= 0) {
                return null;
            }
            ArrayList<rw> arrayList = new ArrayList();
            int length = elementsByTagName.getLength();
            for (int i = 0; i < length; i++) {
                Node item = elementsByTagName.item(i);
                rw rwVar = new rw();
                String toLowerCase = item.getTextContent().toLowerCase();
                NamedNodeMap attributes = item.getAttributes();
                Node namedItem = attributes.getNamedItem("thumburl");
                if (namedItem != null) {
                    rwVar.pbP = namedItem.getNodeValue();
                }
                namedItem = attributes.getNamedItem("cdnurl");
                if (namedItem != null) {
                    rwVar.nfX = namedItem.getNodeValue();
                }
                namedItem = attributes.getNamedItem("productid");
                if (namedItem != null) {
                    rwVar.vIR = namedItem.getNodeValue();
                }
                namedItem = attributes.getNamedItem("designerid");
                if (namedItem != null) {
                    rwVar.vZM = namedItem.getNodeValue();
                }
                namedItem = attributes.getNamedItem("aeskey");
                if (namedItem != null) {
                    rwVar.vZO = namedItem.getNodeValue();
                }
                namedItem = attributes.getNamedItem("encrypturl");
                if (namedItem != null) {
                    rwVar.vZN = namedItem.getNodeValue();
                }
                item = attributes.getNamedItem("activityid");
                if (item != null) {
                    rwVar.vZR = item.getNodeValue();
                }
                rwVar.vZL = toLowerCase;
                arrayList.add(rwVar);
            }
            return arrayList;
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiBackupXMLParser", "[parser] parseXML exception:%s", new Object[]{e.toString()});
            return null;
        }
    }

    public static ArrayList<String> yA(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.emoji.EmojiBackupXMLParser", "[backup emotion parser] parse xml faild. xml is null.");
            return null;
        }
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("ProductID");
            if (elementsByTagName == null || elementsByTagName.getLength() <= 0) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList();
            int length = elementsByTagName.getLength();
            for (int i = 0; i < length; i++) {
                arrayList.add(elementsByTagName.item(i).getTextContent());
            }
            return arrayList;
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiBackupXMLParser", "[parser] parseXML exception:%s", new Object[]{e.toString()});
            return null;
        }
    }
}
