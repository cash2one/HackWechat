package com.tencent.mm.plugin.emoji.g;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class d {
    public static ArrayList<EmojiGroupInfo> yB(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] parse xml faild. xml is null.");
            return null;
        }
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("Emotion");
            if (elementsByTagName == null || elementsByTagName.getLength() <= 0) {
                return null;
            }
            ArrayList<EmojiGroupInfo> arrayList = new ArrayList();
            for (int i = 0; i < elementsByTagName.getLength(); i++) {
                EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
                NodeList childNodes = elementsByTagName.item(i).getChildNodes();
                int length = childNodes.getLength();
                for (int i2 = 0; i2 < length; i2++) {
                    Node item = childNodes.item(i2);
                    if (item != null && item.getNodeName() != null && item.getNodeName().equals("ProductID")) {
                        x.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] productId:%s", new Object[]{item.getTextContent()});
                        emojiGroupInfo.field_productID = r9;
                    } else if (item == null || item.getNodeName() == null || !item.getNodeName().equals("RecType")) {
                        if (item != null) {
                            if (item.getNodeName() != null && item.getNodeName().equals("RecWord")) {
                                x.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] recWord:%s", new Object[]{item.getTextContent()});
                                emojiGroupInfo.field_recommandWord = r9;
                            }
                        }
                        if (item != null && item.getNodeName() != null && item.getNodeName().equals("Name")) {
                            x.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] Name:%s", new Object[]{item.getTextContent()});
                            emojiGroupInfo.field_packName = r9;
                        } else if (item != null && item.getNodeName() != null && item.getNodeName().equals("Panel")) {
                            x.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] iconUrl:%s", new Object[]{item.getTextContent()});
                            emojiGroupInfo.field_packGrayIconUrl = r9;
                        } else if (item != null && item.getNodeName() != null && item.getNodeName().equals("Icon")) {
                            x.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] BigIconUrl:%s", new Object[]{item.getTextContent()});
                            emojiGroupInfo.field_BigIconUrl = r9;
                        } else if (!(item == null || item.getNodeName() == null || !item.getNodeName().equals("ButtonType"))) {
                            x.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] buttonType:%s", new Object[]{item.getTextContent()});
                            emojiGroupInfo.field_buttonType = Integer.valueOf(r9).intValue();
                        }
                    } else {
                        x.d("MicroMsg.emoji.EmojiRecommendXMLParser", "[recommend emotion parser] RecType:%s", new Object[]{item.getTextContent()});
                        emojiGroupInfo.field_recommandType = Integer.valueOf(r9).intValue();
                    }
                }
                if (!bh.ov(emojiGroupInfo.field_productID)) {
                    emojiGroupInfo.field_recommand = 1;
                    emojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
                    emojiGroupInfo.field_sort = 0;
                    g.pQN.h(12068, new Object[]{Integer.valueOf(1), emojiGroupInfo.field_productID, Integer.valueOf(emojiGroupInfo.field_recommandType)});
                    arrayList.add(emojiGroupInfo);
                }
            }
            return arrayList;
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiRecommendXMLParser", "[parser] parseXML exception:%s", new Object[]{e.toString()});
            return null;
        }
    }
}
