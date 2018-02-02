package com.tencent.mm.z.c;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class a {
    private static DocumentBuilder hiu = null;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static a im(String str) {
        a aVar = new a();
        x.d("MicroMsg.ABTestParser", "ABTest msg content: %s", str);
        Element io = io(str);
        if (io == null) {
            x.e("MicroMsg.ABTestParser", "Msg parsing failed, msg: %s", str);
            return aVar;
        }
        NamedNodeMap attributes = io.getAttributes();
        if (attributes == null) {
            return null;
        }
        int i;
        NodeList childNodes;
        int i2;
        Node item;
        Element element;
        c cVar;
        NamedNodeMap attributes2;
        Object obj;
        Node namedItem;
        Node namedItem2;
        NodeList elementsByTagName;
        List linkedList;
        Collection collection;
        Node namedItem3;
        String nodeValue;
        NodeList elementsByTagName2;
        long j;
        long j2;
        long j3;
        long j4;
        boolean z;
        HashMap hashMap;
        NodeList childNodes2;
        int i3;
        NodeList elementsByTagName3;
        com.tencent.mm.storage.a aVar2;
        Node namedItem4 = attributes.getNamedItem(DownloadSettingTable$Columns.TYPE);
        if (namedItem4 != null && "newabtestinfo".equals(namedItem4.getNodeValue())) {
            NodeList elementsByTagName4 = io.getElementsByTagName("prioritylevel");
            if (elementsByTagName4.getLength() > 0) {
                i = bh.getInt(elementsByTagName4.item(0).getTextContent(), 1);
                childNodes = io.getChildNodes();
                for (i2 = 0; i2 < childNodes.getLength(); i2++) {
                    item = childNodes.item(i2);
                    if (item == null) {
                        if (item.getNodeType() == (short) 1 && item.getNodeName().equals("exp")) {
                            try {
                                element = (Element) item;
                                cVar = new c();
                                attributes2 = element.getAttributes();
                                if (attributes2 != null) {
                                    obj = null;
                                } else {
                                    namedItem = attributes2.getNamedItem("layerid");
                                    if (namedItem != null) {
                                        obj = null;
                                    } else {
                                        cVar.field_layerId = namedItem.getNodeValue();
                                        namedItem = attributes2.getNamedItem(SlookAirButtonFrequentContactAdapter.ID);
                                        if (namedItem != null) {
                                            obj = null;
                                        } else {
                                            cVar.field_expId = namedItem.getNodeValue();
                                            namedItem2 = attributes2.getNamedItem("business");
                                            if (namedItem2 != null) {
                                                cVar.field_business = "";
                                            } else {
                                                cVar.field_business = namedItem2.getNodeValue();
                                            }
                                            elementsByTagName = element.getElementsByTagName("sequence");
                                            if (elementsByTagName.getLength() != 0) {
                                                obj = null;
                                            } else {
                                                cVar.field_sequence = bh.getLong(elementsByTagName.item(0).getTextContent(), 0);
                                                elementsByTagName = element.getElementsByTagName("prioritylevel");
                                                if (elementsByTagName.getLength() <= 0) {
                                                    cVar.field_prioritylevel = bh.getInt(elementsByTagName.item(0).getTextContent(), 0);
                                                } else {
                                                    cVar.field_prioritylevel = 0;
                                                }
                                                elementsByTagName = element.getElementsByTagName("starttime");
                                                if (elementsByTagName.getLength() > 0) {
                                                    cVar.field_startTime = bh.getLong(elementsByTagName.item(0).getTextContent(), 0);
                                                }
                                                cVar.field_startTime = System.currentTimeMillis() / 1000;
                                                elementsByTagName = element.getElementsByTagName("endtime");
                                                if (elementsByTagName.getLength() > 0) {
                                                    cVar.field_endTime = bh.getLong(elementsByTagName.item(0).getTextContent(), 0);
                                                }
                                                cVar.field_endTime = Long.MAX_VALUE;
                                                elementsByTagName = element.getElementsByTagName("noreport");
                                                if (elementsByTagName.getLength() > 0) {
                                                    cVar.field_needReport = bh.getInt(elementsByTagName.item(0).getTextContent(), 0) != 0;
                                                }
                                                cVar.field_rawXML = a(element);
                                                c cVar2 = cVar;
                                            }
                                        }
                                    }
                                }
                                aVar.hiv.add(obj);
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.ABTestParser", e, "parseExp", new Object[0]);
                            }
                        }
                        if (item.getNodeType() == (short) 1 && item.getNodeName().equals("expinfo")) {
                            try {
                                io = (Element) item;
                                linkedList = new LinkedList();
                                attributes = io.getAttributes();
                                if (attributes != null) {
                                    collection = null;
                                } else {
                                    namedItem3 = attributes.getNamedItem(SlookAirButtonFrequentContactAdapter.ID);
                                    if (namedItem3 != null) {
                                        collection = null;
                                    } else {
                                        nodeValue = namedItem3.getNodeValue();
                                        elementsByTagName2 = io.getElementsByTagName("sequence");
                                        if (elementsByTagName2.getLength() != 0) {
                                            collection = null;
                                        } else {
                                            j = bh.getLong(elementsByTagName2.item(0).getTextContent(), 0);
                                            elementsByTagName2 = io.getElementsByTagName("starttime");
                                            if (elementsByTagName2.getLength() > 0) {
                                                j2 = bh.getLong(elementsByTagName2.item(0).getTextContent(), 0);
                                                if (j2 != 0) {
                                                    j3 = j2;
                                                    elementsByTagName2 = io.getElementsByTagName("endtime");
                                                    if (elementsByTagName2.getLength() > 0) {
                                                        j2 = bh.getLong(elementsByTagName2.item(0).getTextContent(), 0);
                                                        if (j2 != 0) {
                                                            j4 = j2;
                                                            elementsByTagName = io.getElementsByTagName("noreport");
                                                            if (elementsByTagName.getLength() <= 0) {
                                                                z = bh.getInt(elementsByTagName.item(0).getTextContent(), 0) != 1;
                                                            } else {
                                                                z = false;
                                                            }
                                                            hashMap = new HashMap();
                                                            elementsByTagName2 = io.getElementsByTagName("args");
                                                            if (elementsByTagName2.getLength() > 0) {
                                                                childNodes2 = elementsByTagName2.item(0).getChildNodes();
                                                                for (i3 = 0; i3 < childNodes2.getLength(); i3++) {
                                                                    item = childNodes2.item(i3);
                                                                    if (item.getNodeType() == (short) 1 && item.getNodeName().equals("arg")) {
                                                                        elementsByTagName2 = ((Element) item).getElementsByTagName("key");
                                                                        elementsByTagName3 = ((Element) item).getElementsByTagName(DownloadSettingTable$Columns.VALUE);
                                                                        if (!(elementsByTagName2.getLength() == 0 || elementsByTagName3.getLength() == 0)) {
                                                                            hashMap.put(elementsByTagName2.item(0).getTextContent(), elementsByTagName3.item(0).getTextContent());
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            for (String str2 : hashMap.keySet()) {
                                                                aVar2 = new com.tencent.mm.storage.a();
                                                                aVar2.field_abtestkey = str2;
                                                                aVar2.field_value = (String) hashMap.get(str2);
                                                                aVar2.field_expId = nodeValue;
                                                                aVar2.field_sequence = j;
                                                                aVar2.field_prioritylevel = i;
                                                                aVar2.field_startTime = j3;
                                                                aVar2.field_endTime = j4;
                                                                aVar2.field_noReport = z;
                                                                linkedList.add(aVar2);
                                                            }
                                                            obj = linkedList;
                                                        }
                                                    }
                                                    j4 = Long.MAX_VALUE;
                                                    elementsByTagName = io.getElementsByTagName("noreport");
                                                    if (elementsByTagName.getLength() <= 0) {
                                                        z = false;
                                                    } else {
                                                        if (bh.getInt(elementsByTagName.item(0).getTextContent(), 0) != 1) {
                                                        }
                                                        z = bh.getInt(elementsByTagName.item(0).getTextContent(), 0) != 1;
                                                    }
                                                    hashMap = new HashMap();
                                                    elementsByTagName2 = io.getElementsByTagName("args");
                                                    if (elementsByTagName2.getLength() > 0) {
                                                        childNodes2 = elementsByTagName2.item(0).getChildNodes();
                                                        for (i3 = 0; i3 < childNodes2.getLength(); i3++) {
                                                            item = childNodes2.item(i3);
                                                            elementsByTagName2 = ((Element) item).getElementsByTagName("key");
                                                            elementsByTagName3 = ((Element) item).getElementsByTagName(DownloadSettingTable$Columns.VALUE);
                                                            hashMap.put(elementsByTagName2.item(0).getTextContent(), elementsByTagName3.item(0).getTextContent());
                                                        }
                                                    }
                                                    for (String str22 : hashMap.keySet()) {
                                                        aVar2 = new com.tencent.mm.storage.a();
                                                        aVar2.field_abtestkey = str22;
                                                        aVar2.field_value = (String) hashMap.get(str22);
                                                        aVar2.field_expId = nodeValue;
                                                        aVar2.field_sequence = j;
                                                        aVar2.field_prioritylevel = i;
                                                        aVar2.field_startTime = j3;
                                                        aVar2.field_endTime = j4;
                                                        aVar2.field_noReport = z;
                                                        linkedList.add(aVar2);
                                                    }
                                                    obj = linkedList;
                                                }
                                            }
                                            j3 = System.currentTimeMillis() / 1000;
                                            elementsByTagName2 = io.getElementsByTagName("endtime");
                                            if (elementsByTagName2.getLength() > 0) {
                                                j2 = bh.getLong(elementsByTagName2.item(0).getTextContent(), 0);
                                                if (j2 != 0) {
                                                    j4 = j2;
                                                    elementsByTagName = io.getElementsByTagName("noreport");
                                                    if (elementsByTagName.getLength() <= 0) {
                                                        if (bh.getInt(elementsByTagName.item(0).getTextContent(), 0) != 1) {
                                                        }
                                                        z = bh.getInt(elementsByTagName.item(0).getTextContent(), 0) != 1;
                                                    } else {
                                                        z = false;
                                                    }
                                                    hashMap = new HashMap();
                                                    elementsByTagName2 = io.getElementsByTagName("args");
                                                    if (elementsByTagName2.getLength() > 0) {
                                                        childNodes2 = elementsByTagName2.item(0).getChildNodes();
                                                        for (i3 = 0; i3 < childNodes2.getLength(); i3++) {
                                                            item = childNodes2.item(i3);
                                                            elementsByTagName2 = ((Element) item).getElementsByTagName("key");
                                                            elementsByTagName3 = ((Element) item).getElementsByTagName(DownloadSettingTable$Columns.VALUE);
                                                            hashMap.put(elementsByTagName2.item(0).getTextContent(), elementsByTagName3.item(0).getTextContent());
                                                        }
                                                    }
                                                    for (String str222 : hashMap.keySet()) {
                                                        aVar2 = new com.tencent.mm.storage.a();
                                                        aVar2.field_abtestkey = str222;
                                                        aVar2.field_value = (String) hashMap.get(str222);
                                                        aVar2.field_expId = nodeValue;
                                                        aVar2.field_sequence = j;
                                                        aVar2.field_prioritylevel = i;
                                                        aVar2.field_startTime = j3;
                                                        aVar2.field_endTime = j4;
                                                        aVar2.field_noReport = z;
                                                        linkedList.add(aVar2);
                                                    }
                                                    obj = linkedList;
                                                }
                                            }
                                            j4 = Long.MAX_VALUE;
                                            elementsByTagName = io.getElementsByTagName("noreport");
                                            if (elementsByTagName.getLength() <= 0) {
                                                z = false;
                                            } else {
                                                if (bh.getInt(elementsByTagName.item(0).getTextContent(), 0) != 1) {
                                                }
                                                z = bh.getInt(elementsByTagName.item(0).getTextContent(), 0) != 1;
                                            }
                                            hashMap = new HashMap();
                                            elementsByTagName2 = io.getElementsByTagName("args");
                                            if (elementsByTagName2.getLength() > 0) {
                                                childNodes2 = elementsByTagName2.item(0).getChildNodes();
                                                for (i3 = 0; i3 < childNodes2.getLength(); i3++) {
                                                    item = childNodes2.item(i3);
                                                    elementsByTagName2 = ((Element) item).getElementsByTagName("key");
                                                    elementsByTagName3 = ((Element) item).getElementsByTagName(DownloadSettingTable$Columns.VALUE);
                                                    hashMap.put(elementsByTagName2.item(0).getTextContent(), elementsByTagName3.item(0).getTextContent());
                                                }
                                            }
                                            for (String str2222 : hashMap.keySet()) {
                                                aVar2 = new com.tencent.mm.storage.a();
                                                aVar2.field_abtestkey = str2222;
                                                aVar2.field_value = (String) hashMap.get(str2222);
                                                aVar2.field_expId = nodeValue;
                                                aVar2.field_sequence = j;
                                                aVar2.field_prioritylevel = i;
                                                aVar2.field_startTime = j3;
                                                aVar2.field_endTime = j4;
                                                aVar2.field_noReport = z;
                                                linkedList.add(aVar2);
                                            }
                                            obj = linkedList;
                                        }
                                    }
                                }
                                aVar.hiw.addAll(collection);
                            } catch (Exception e2) {
                                x.e("MicroMsg.ABTestParser", e2.getMessage());
                            }
                        }
                    }
                }
                return aVar;
            }
        }
        i = 1;
        childNodes = io.getChildNodes();
        for (i2 = 0; i2 < childNodes.getLength(); i2++) {
            item = childNodes.item(i2);
            if (item == null) {
                element = (Element) item;
                cVar = new c();
                attributes2 = element.getAttributes();
                if (attributes2 != null) {
                    namedItem = attributes2.getNamedItem("layerid");
                    if (namedItem != null) {
                        cVar.field_layerId = namedItem.getNodeValue();
                        namedItem = attributes2.getNamedItem(SlookAirButtonFrequentContactAdapter.ID);
                        if (namedItem != null) {
                            cVar.field_expId = namedItem.getNodeValue();
                            namedItem2 = attributes2.getNamedItem("business");
                            if (namedItem2 != null) {
                                cVar.field_business = namedItem2.getNodeValue();
                            } else {
                                cVar.field_business = "";
                            }
                            elementsByTagName = element.getElementsByTagName("sequence");
                            if (elementsByTagName.getLength() != 0) {
                                cVar.field_sequence = bh.getLong(elementsByTagName.item(0).getTextContent(), 0);
                                elementsByTagName = element.getElementsByTagName("prioritylevel");
                                if (elementsByTagName.getLength() <= 0) {
                                    cVar.field_prioritylevel = 0;
                                } else {
                                    cVar.field_prioritylevel = bh.getInt(elementsByTagName.item(0).getTextContent(), 0);
                                }
                                elementsByTagName = element.getElementsByTagName("starttime");
                                if (elementsByTagName.getLength() > 0) {
                                    cVar.field_startTime = bh.getLong(elementsByTagName.item(0).getTextContent(), 0);
                                }
                                cVar.field_startTime = System.currentTimeMillis() / 1000;
                                elementsByTagName = element.getElementsByTagName("endtime");
                                if (elementsByTagName.getLength() > 0) {
                                    cVar.field_endTime = bh.getLong(elementsByTagName.item(0).getTextContent(), 0);
                                }
                                cVar.field_endTime = Long.MAX_VALUE;
                                elementsByTagName = element.getElementsByTagName("noreport");
                                if (elementsByTagName.getLength() > 0) {
                                    if (bh.getInt(elementsByTagName.item(0).getTextContent(), 0) != 0) {
                                    }
                                    cVar.field_needReport = bh.getInt(elementsByTagName.item(0).getTextContent(), 0) != 0;
                                }
                                cVar.field_rawXML = a(element);
                                c cVar22 = cVar;
                            } else {
                                obj = null;
                            }
                        } else {
                            obj = null;
                        }
                    } else {
                        obj = null;
                    }
                } else {
                    obj = null;
                }
                aVar.hiv.add(obj);
                io = (Element) item;
                linkedList = new LinkedList();
                attributes = io.getAttributes();
                if (attributes != null) {
                    namedItem3 = attributes.getNamedItem(SlookAirButtonFrequentContactAdapter.ID);
                    if (namedItem3 != null) {
                        nodeValue = namedItem3.getNodeValue();
                        elementsByTagName2 = io.getElementsByTagName("sequence");
                        if (elementsByTagName2.getLength() != 0) {
                            j = bh.getLong(elementsByTagName2.item(0).getTextContent(), 0);
                            elementsByTagName2 = io.getElementsByTagName("starttime");
                            if (elementsByTagName2.getLength() > 0) {
                                j2 = bh.getLong(elementsByTagName2.item(0).getTextContent(), 0);
                                if (j2 != 0) {
                                    j3 = j2;
                                    elementsByTagName2 = io.getElementsByTagName("endtime");
                                    if (elementsByTagName2.getLength() > 0) {
                                        j2 = bh.getLong(elementsByTagName2.item(0).getTextContent(), 0);
                                        if (j2 != 0) {
                                            j4 = j2;
                                            elementsByTagName = io.getElementsByTagName("noreport");
                                            if (elementsByTagName.getLength() <= 0) {
                                                if (bh.getInt(elementsByTagName.item(0).getTextContent(), 0) != 1) {
                                                }
                                                z = bh.getInt(elementsByTagName.item(0).getTextContent(), 0) != 1;
                                            } else {
                                                z = false;
                                            }
                                            hashMap = new HashMap();
                                            elementsByTagName2 = io.getElementsByTagName("args");
                                            if (elementsByTagName2.getLength() > 0) {
                                                childNodes2 = elementsByTagName2.item(0).getChildNodes();
                                                for (i3 = 0; i3 < childNodes2.getLength(); i3++) {
                                                    item = childNodes2.item(i3);
                                                    elementsByTagName2 = ((Element) item).getElementsByTagName("key");
                                                    elementsByTagName3 = ((Element) item).getElementsByTagName(DownloadSettingTable$Columns.VALUE);
                                                    hashMap.put(elementsByTagName2.item(0).getTextContent(), elementsByTagName3.item(0).getTextContent());
                                                }
                                            }
                                            for (String str22222 : hashMap.keySet()) {
                                                aVar2 = new com.tencent.mm.storage.a();
                                                aVar2.field_abtestkey = str22222;
                                                aVar2.field_value = (String) hashMap.get(str22222);
                                                aVar2.field_expId = nodeValue;
                                                aVar2.field_sequence = j;
                                                aVar2.field_prioritylevel = i;
                                                aVar2.field_startTime = j3;
                                                aVar2.field_endTime = j4;
                                                aVar2.field_noReport = z;
                                                linkedList.add(aVar2);
                                            }
                                            obj = linkedList;
                                        }
                                    }
                                    j4 = Long.MAX_VALUE;
                                    elementsByTagName = io.getElementsByTagName("noreport");
                                    if (elementsByTagName.getLength() <= 0) {
                                        z = false;
                                    } else {
                                        if (bh.getInt(elementsByTagName.item(0).getTextContent(), 0) != 1) {
                                        }
                                        z = bh.getInt(elementsByTagName.item(0).getTextContent(), 0) != 1;
                                    }
                                    hashMap = new HashMap();
                                    elementsByTagName2 = io.getElementsByTagName("args");
                                    if (elementsByTagName2.getLength() > 0) {
                                        childNodes2 = elementsByTagName2.item(0).getChildNodes();
                                        for (i3 = 0; i3 < childNodes2.getLength(); i3++) {
                                            item = childNodes2.item(i3);
                                            elementsByTagName2 = ((Element) item).getElementsByTagName("key");
                                            elementsByTagName3 = ((Element) item).getElementsByTagName(DownloadSettingTable$Columns.VALUE);
                                            hashMap.put(elementsByTagName2.item(0).getTextContent(), elementsByTagName3.item(0).getTextContent());
                                        }
                                    }
                                    for (String str222222 : hashMap.keySet()) {
                                        aVar2 = new com.tencent.mm.storage.a();
                                        aVar2.field_abtestkey = str222222;
                                        aVar2.field_value = (String) hashMap.get(str222222);
                                        aVar2.field_expId = nodeValue;
                                        aVar2.field_sequence = j;
                                        aVar2.field_prioritylevel = i;
                                        aVar2.field_startTime = j3;
                                        aVar2.field_endTime = j4;
                                        aVar2.field_noReport = z;
                                        linkedList.add(aVar2);
                                    }
                                    obj = linkedList;
                                }
                            }
                            j3 = System.currentTimeMillis() / 1000;
                            elementsByTagName2 = io.getElementsByTagName("endtime");
                            if (elementsByTagName2.getLength() > 0) {
                                j2 = bh.getLong(elementsByTagName2.item(0).getTextContent(), 0);
                                if (j2 != 0) {
                                    j4 = j2;
                                    elementsByTagName = io.getElementsByTagName("noreport");
                                    if (elementsByTagName.getLength() <= 0) {
                                        if (bh.getInt(elementsByTagName.item(0).getTextContent(), 0) != 1) {
                                        }
                                        z = bh.getInt(elementsByTagName.item(0).getTextContent(), 0) != 1;
                                    } else {
                                        z = false;
                                    }
                                    hashMap = new HashMap();
                                    elementsByTagName2 = io.getElementsByTagName("args");
                                    if (elementsByTagName2.getLength() > 0) {
                                        childNodes2 = elementsByTagName2.item(0).getChildNodes();
                                        for (i3 = 0; i3 < childNodes2.getLength(); i3++) {
                                            item = childNodes2.item(i3);
                                            elementsByTagName2 = ((Element) item).getElementsByTagName("key");
                                            elementsByTagName3 = ((Element) item).getElementsByTagName(DownloadSettingTable$Columns.VALUE);
                                            hashMap.put(elementsByTagName2.item(0).getTextContent(), elementsByTagName3.item(0).getTextContent());
                                        }
                                    }
                                    for (String str2222222 : hashMap.keySet()) {
                                        aVar2 = new com.tencent.mm.storage.a();
                                        aVar2.field_abtestkey = str2222222;
                                        aVar2.field_value = (String) hashMap.get(str2222222);
                                        aVar2.field_expId = nodeValue;
                                        aVar2.field_sequence = j;
                                        aVar2.field_prioritylevel = i;
                                        aVar2.field_startTime = j3;
                                        aVar2.field_endTime = j4;
                                        aVar2.field_noReport = z;
                                        linkedList.add(aVar2);
                                    }
                                    obj = linkedList;
                                }
                            }
                            j4 = Long.MAX_VALUE;
                            elementsByTagName = io.getElementsByTagName("noreport");
                            if (elementsByTagName.getLength() <= 0) {
                                z = false;
                            } else {
                                if (bh.getInt(elementsByTagName.item(0).getTextContent(), 0) != 1) {
                                }
                                z = bh.getInt(elementsByTagName.item(0).getTextContent(), 0) != 1;
                            }
                            hashMap = new HashMap();
                            elementsByTagName2 = io.getElementsByTagName("args");
                            if (elementsByTagName2.getLength() > 0) {
                                childNodes2 = elementsByTagName2.item(0).getChildNodes();
                                for (i3 = 0; i3 < childNodes2.getLength(); i3++) {
                                    item = childNodes2.item(i3);
                                    elementsByTagName2 = ((Element) item).getElementsByTagName("key");
                                    elementsByTagName3 = ((Element) item).getElementsByTagName(DownloadSettingTable$Columns.VALUE);
                                    hashMap.put(elementsByTagName2.item(0).getTextContent(), elementsByTagName3.item(0).getTextContent());
                                }
                            }
                            for (String str22222222 : hashMap.keySet()) {
                                aVar2 = new com.tencent.mm.storage.a();
                                aVar2.field_abtestkey = str22222222;
                                aVar2.field_value = (String) hashMap.get(str22222222);
                                aVar2.field_expId = nodeValue;
                                aVar2.field_sequence = j;
                                aVar2.field_prioritylevel = i;
                                aVar2.field_startTime = j3;
                                aVar2.field_endTime = j4;
                                aVar2.field_noReport = z;
                                linkedList.add(aVar2);
                            }
                            obj = linkedList;
                        } else {
                            collection = null;
                        }
                    } else {
                        collection = null;
                    }
                } else {
                    collection = null;
                }
                aVar.hiw.addAll(collection);
            }
        }
        return aVar;
    }

    public static Map<String, String> in(String str) {
        HashMap hashMap = new HashMap();
        Element io = io(str);
        if (io == null) {
            x.e("MicroMsg.ABTestParser", "Raw XML string parsing failed, xml: %s", str);
            return hashMap;
        }
        NodeList elementsByTagName = io.getElementsByTagName("args");
        if (elementsByTagName.getLength() > 0) {
            NodeList childNodes = elementsByTagName.item(0).getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node item = childNodes.item(i);
                if (item.getNodeType() == (short) 1 && item.getNodeName().equals("arg")) {
                    elementsByTagName = ((Element) item).getElementsByTagName("key");
                    NodeList elementsByTagName2 = ((Element) item).getElementsByTagName(DownloadSettingTable$Columns.VALUE);
                    if (!(elementsByTagName.getLength() == 0 || elementsByTagName2.getLength() == 0)) {
                        hashMap.put(elementsByTagName.item(0).getTextContent(), elementsByTagName2.item(0).getTextContent());
                    }
                }
            }
        }
        return hashMap;
    }

    private static Element io(String str) {
        try {
            DocumentBuilder documentBuilder;
            InputSource inputSource = new InputSource(new ByteArrayInputStream(str.getBytes()));
            if (hiu != null) {
                documentBuilder = hiu;
            } else {
                documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                hiu = documentBuilder;
            }
            Document parse = documentBuilder.parse(inputSource);
            parse.normalize();
            return parse.getDocumentElement();
        } catch (Exception e) {
            x.e("MicroMsg.ABTestParser", e.toString());
            return null;
        }
    }

    private static String a(Node node) {
        Writer stringWriter = new StringWriter();
        try {
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("omit-xml-declaration", "yes");
            newTransformer.transform(new DOMSource(node), new StreamResult(stringWriter));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ABTestParser", e, "nodeToString", new Object[0]);
        }
        return stringWriter.toString();
    }
}
