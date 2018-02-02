package com.tencent.mm.z.a;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class c {
    b hig = null;
    b hih = null;

    final void if(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.abtest.AbTestManager", "[Abtest] parse xml faild. xml is null.");
            return;
        }
        x.i("MicroMsg.abtest.AbTestManager", "[Abtest] parseXML content:%s", new Object[]{str});
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("testcase");
            if (elementsByTagName != null) {
                for (int i = 0; i < elementsByTagName.getLength(); i++) {
                    b bVar = new b();
                    NodeList childNodes = elementsByTagName.item(i).getChildNodes();
                    int length = childNodes.getLength();
                    for (int i2 = 0; i2 < length; i2++) {
                        Node item = childNodes.item(i2);
                        if (item != null && item.getNodeName() != null && item.getNodeName().equals("testpoint")) {
                            NamedNodeMap attributes = item.getAttributes();
                            e eVar = new e();
                            if (attributes != null) {
                                Node namedItem = attributes.getNamedItem(SlookAirButtonFrequentContactAdapter.ID);
                                if (namedItem != null) {
                                    x.d("MicroMsg.abtest.AbTestManager", "[Abtest] idValue:%s", new Object[]{namedItem.getNodeValue()});
                                    eVar.id = r9;
                                }
                                Node namedItem2 = attributes.getNamedItem("reportid");
                                if (namedItem2 != null) {
                                    x.d("MicroMsg.abtest.AbTestManager", "[Abtest] reportIdValue:%s", new Object[]{namedItem2.getNodeValue()});
                                    eVar.hii = r7;
                                }
                            }
                            x.d("MicroMsg.abtest.AbTestManager", "[Abtest] casePointContent:%s", new Object[]{item.getTextContent()});
                            eVar.value = r6;
                            bVar.hif.put(eVar.id, eVar);
                        } else if (item == null || item.getNodeName() == null || !item.getNodeName().equals("verifymd5")) {
                            if (item != null) {
                                if (item.getNodeName() != null && item.getNodeName().equals("testcaseid")) {
                                    x.d("MicroMsg.abtest.AbTestManager", "[Abtest] testcaseidContent:%s", new Object[]{item.getTextContent()});
                                    bVar.hic = r6;
                                }
                            }
                            if (item != null && item.getNodeName() != null && item.getNodeName().equals("starttime")) {
                                x.d("MicroMsg.abtest.AbTestManager", "[Abtest] starttimeContent:%s", new Object[]{item.getTextContent()});
                                bVar.hid = r6;
                            } else if (!(item == null || item.getNodeName() == null || !item.getNodeName().equals("endtime"))) {
                                x.d("MicroMsg.abtest.AbTestManager", "[Abtest] endtimeContent:%s", new Object[]{item.getTextContent()});
                                bVar.hie = r6;
                            }
                        } else {
                            x.d("MicroMsg.abtest.AbTestManager", "[Abtest] verifymd5Content:%s", new Object[]{item.getTextContent()});
                            bVar.hib = r6;
                        }
                    }
                    if (bh.ov(bVar.hic) || !"0".equals(bVar.hic)) {
                        this.hig = bVar;
                    } else {
                        this.hih = bVar;
                    }
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.abtest.AbTestManager", "[Abtest] parseXML exception:%s", new Object[]{e.toString()});
        }
    }

    public final boolean Ih() {
        if (this.hig == null) {
            return false;
        }
        return true;
    }

    public final e ie(String str) {
        e eVar = null;
        if (this.hig != null) {
            eVar = this.hig.ie(str);
        }
        if (eVar != null || this.hih == null) {
            return eVar;
        }
        return this.hih.ie(str);
    }
}
