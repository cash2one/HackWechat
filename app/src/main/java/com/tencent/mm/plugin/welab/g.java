package com.tencent.mm.plugin.welab;

import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.welab.c.a.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class g {
    private static DocumentBuilder hiu = null;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static a Qy(String str) {
        x.v("MicroMsg.Welabparser", "ABTest msg content: %s", new Object[]{str});
        String replaceAll = str.replaceAll(">\n+\\s*<", "><");
        a aVar = new a();
        Element io = io(replaceAll);
        if (io == null) {
            x.e("MicroMsg.Welabparser", "Msg parsing failed, msg: %s", new Object[]{replaceAll});
            return aVar;
        }
        NamedNodeMap attributes = io.getAttributes();
        if (attributes == null) {
            return null;
        }
        Node namedItem = attributes.getNamedItem(DownloadSettingTable$Columns.TYPE);
        int i = 1;
        if (namedItem == null || !"newabtestlabs".equals(namedItem.getNodeValue())) {
            x.i("MicroMsg.Welabparser", "recv illegal type msg");
            return aVar;
        }
        NodeList elementsByTagName = io.getElementsByTagName("prioritylevel");
        if (elementsByTagName.getLength() > 0) {
            i = bh.getInt(elementsByTagName.item(0).getTextContent(), 1);
        }
        elementsByTagName = io.getElementsByTagName(DownloadInfo.STATUS);
        if (elementsByTagName.getLength() > 0) {
            aVar.field_status = bh.getInt(elementsByTagName.item(0).getTextContent(), 1);
        }
        aVar.field_prioritylevel = i;
        NodeList childNodes = io.getChildNodes();
        for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
            Node item = childNodes.item(i2);
            if (item != null && item.getNodeType() == (short) 1 && item.getNodeName().equals("expinfo")) {
                Element element = (Element) item;
                NamedNodeMap attributes2 = element.getAttributes();
                if (attributes2 != null) {
                    Node namedItem2 = attributes2.getNamedItem(SlookAirButtonFrequentContactAdapter.ID);
                    if (namedItem2 != null) {
                        aVar.field_expId = namedItem2.getNodeValue();
                        NodeList elementsByTagName2 = element.getElementsByTagName("sequence");
                        if (elementsByTagName2.getLength() != 0) {
                            long j;
                            long currentTimeMillis;
                            long j2;
                            HashMap hashMap;
                            NodeList elementsByTagName3;
                            NodeList childNodes2;
                            int i3;
                            long j3 = bh.getLong(elementsByTagName2.item(0).getTextContent(), 0);
                            elementsByTagName2 = element.getElementsByTagName("starttime");
                            if (elementsByTagName2.getLength() > 0) {
                                j = bh.getLong(elementsByTagName2.item(0).getTextContent(), 0);
                                if (j == 0) {
                                    currentTimeMillis = System.currentTimeMillis() / 1000;
                                } else {
                                    currentTimeMillis = j;
                                }
                            } else {
                                currentTimeMillis = System.currentTimeMillis() / 1000;
                            }
                            try {
                                aVar.field_idkey = bh.getInt(element.getElementsByTagName("monitor").item(0).getChildNodes().item(0).getChildNodes().item(0).getTextContent(), -1);
                                aVar.field_idkeyValue = bh.getInt(element.getElementsByTagName("monitor").item(0).getChildNodes().item(0).getChildNodes().item(1).getTextContent(), -1);
                            } catch (Throwable e) {
                                x.e("MicroMsg.Welabparser", bh.i(e));
                            }
                            elementsByTagName2 = element.getElementsByTagName("endtime");
                            if (elementsByTagName2.getLength() > 0) {
                                j = bh.getLong(elementsByTagName2.item(0).getTextContent(), 0);
                                if (j != 0) {
                                    j2 = j;
                                    hashMap = new HashMap();
                                    elementsByTagName3 = element.getElementsByTagName("args");
                                    if (elementsByTagName3.getLength() > 0) {
                                        childNodes2 = elementsByTagName3.item(0).getChildNodes();
                                        for (i3 = 0; i3 < childNodes2.getLength(); i3++) {
                                            namedItem2 = childNodes2.item(i3);
                                            if (namedItem2.getNodeType() == (short) 1 && namedItem2.getNodeName().equals("arg")) {
                                                elementsByTagName3 = ((Element) namedItem2).getElementsByTagName("key");
                                                elementsByTagName2 = ((Element) namedItem2).getElementsByTagName(DownloadSettingTable$Columns.VALUE);
                                                if (!(elementsByTagName3.getLength() == 0 || elementsByTagName2.getLength() == 0)) {
                                                    hashMap.put(elementsByTagName3.item(0).getTextContent(), elementsByTagName2.item(0).getTextContent());
                                                }
                                            }
                                        }
                                    }
                                    aVar.field_sequence = j3;
                                    aVar.field_starttime = currentTimeMillis;
                                    aVar.field_endtime = j2;
                                    aVar.field_AllVer = bh.VI((String) hashMap.get("AllVer"));
                                    aVar.field_BizType = bh.VI((String) hashMap.get("BizType"));
                                    aVar.field_Desc_cn = (String) hashMap.get("Desc_cn");
                                    aVar.field_Desc_en = (String) hashMap.get("Desc_en");
                                    aVar.field_Desc_hk = (String) hashMap.get("Desc_hk");
                                    aVar.field_Desc_tw = (String) hashMap.get("Desc_tw");
                                    aVar.field_DetailURL = (String) hashMap.get("DetailURL");
                                    aVar.field_Introduce_cn = (String) hashMap.get("Introduce_cn");
                                    aVar.field_Introduce_en = (String) hashMap.get("Introduce_en");
                                    aVar.field_Introduce_hk = (String) hashMap.get("Introduce_hk");
                                    aVar.field_Introduce_tw = (String) hashMap.get("Introduce_tw");
                                    aVar.field_Pos = bh.VI((String) hashMap.get("Pos"));
                                    aVar.field_Type = bh.VI((String) hashMap.get("Type"));
                                    aVar.field_Switch = bh.VI((String) hashMap.get("Switch"));
                                    aVar.field_WeAppPath = (String) hashMap.get("WeAppPath");
                                    aVar.field_WeAppUser = (String) hashMap.get("WeAppUser");
                                    aVar.field_LabsAppId = (String) hashMap.get("LabsAppId");
                                    aVar.field_TitleKey_android = (String) hashMap.get("TitleKey_android");
                                    aVar.field_Title_cn = (String) hashMap.get("Title_cn");
                                    aVar.field_Title_en = (String) hashMap.get("Title_en");
                                    aVar.field_Title_hk = (String) hashMap.get("Title_hk");
                                    aVar.field_Title_tw = (String) hashMap.get("Title_tw");
                                    aVar.field_ThumbUrl_cn = (String) hashMap.get("ThumbUrl_cn");
                                    aVar.field_ThumbUrl_en = (String) hashMap.get("ThumbUrl_en");
                                    aVar.field_ThumbUrl_hk = (String) hashMap.get("ThumbUrl_hk");
                                    aVar.field_ThumbUrl_tw = (String) hashMap.get("ThumbUrl_tw");
                                    aVar.field_ImgUrl_android_cn = a(hashMap, "ImgUrl_android_cn");
                                    aVar.field_ImgUrl_android_tw = a(hashMap, "ImgUrl_android_tw");
                                    aVar.field_ImgUrl_android_en = a(hashMap, "ImgUrl_android_en");
                                    aVar.field_ImgUrl_android_hk = a(hashMap, "ImgUrl_android_hk");
                                    if (TextUtils.isEmpty(aVar.field_ImgUrl_android_cn)) {
                                        aVar.field_ImgUrl_android_cn = (String) hashMap.get("ImgUrl_cn");
                                    }
                                    if (TextUtils.isEmpty(aVar.field_ImgUrl_android_en)) {
                                        aVar.field_ImgUrl_android_en = (String) hashMap.get("ImgUrl_en");
                                    }
                                    if (TextUtils.isEmpty(aVar.field_ImgUrl_android_hk)) {
                                        aVar.field_ImgUrl_android_hk = (String) hashMap.get("ImgUrl_hk");
                                    }
                                    if (TextUtils.isEmpty(aVar.field_ImgUrl_android_tw)) {
                                        aVar.field_ImgUrl_android_tw = (String) hashMap.get("ImgUrl_tw");
                                    }
                                    aVar.field_RedPoint = bh.VI((String) hashMap.get("RedPoint"));
                                    aVar.field_WeAppDebugMode = bh.VI((String) hashMap.get("WeAppDebugMode"));
                                    aVar.field_TitleKey_android = (String) hashMap.get("TitleKey_android");
                                    aVar.field_Icon = (String) hashMap.get("Icon");
                                }
                            }
                            j2 = Long.MAX_VALUE;
                            hashMap = new HashMap();
                            elementsByTagName3 = element.getElementsByTagName("args");
                            if (elementsByTagName3.getLength() > 0) {
                                childNodes2 = elementsByTagName3.item(0).getChildNodes();
                                for (i3 = 0; i3 < childNodes2.getLength(); i3++) {
                                    namedItem2 = childNodes2.item(i3);
                                    elementsByTagName3 = ((Element) namedItem2).getElementsByTagName("key");
                                    elementsByTagName2 = ((Element) namedItem2).getElementsByTagName(DownloadSettingTable$Columns.VALUE);
                                    hashMap.put(elementsByTagName3.item(0).getTextContent(), elementsByTagName2.item(0).getTextContent());
                                }
                            }
                            aVar.field_sequence = j3;
                            aVar.field_starttime = currentTimeMillis;
                            aVar.field_endtime = j2;
                            aVar.field_AllVer = bh.VI((String) hashMap.get("AllVer"));
                            aVar.field_BizType = bh.VI((String) hashMap.get("BizType"));
                            aVar.field_Desc_cn = (String) hashMap.get("Desc_cn");
                            aVar.field_Desc_en = (String) hashMap.get("Desc_en");
                            aVar.field_Desc_hk = (String) hashMap.get("Desc_hk");
                            aVar.field_Desc_tw = (String) hashMap.get("Desc_tw");
                            aVar.field_DetailURL = (String) hashMap.get("DetailURL");
                            aVar.field_Introduce_cn = (String) hashMap.get("Introduce_cn");
                            aVar.field_Introduce_en = (String) hashMap.get("Introduce_en");
                            aVar.field_Introduce_hk = (String) hashMap.get("Introduce_hk");
                            aVar.field_Introduce_tw = (String) hashMap.get("Introduce_tw");
                            aVar.field_Pos = bh.VI((String) hashMap.get("Pos"));
                            aVar.field_Type = bh.VI((String) hashMap.get("Type"));
                            aVar.field_Switch = bh.VI((String) hashMap.get("Switch"));
                            aVar.field_WeAppPath = (String) hashMap.get("WeAppPath");
                            aVar.field_WeAppUser = (String) hashMap.get("WeAppUser");
                            aVar.field_LabsAppId = (String) hashMap.get("LabsAppId");
                            aVar.field_TitleKey_android = (String) hashMap.get("TitleKey_android");
                            aVar.field_Title_cn = (String) hashMap.get("Title_cn");
                            aVar.field_Title_en = (String) hashMap.get("Title_en");
                            aVar.field_Title_hk = (String) hashMap.get("Title_hk");
                            aVar.field_Title_tw = (String) hashMap.get("Title_tw");
                            aVar.field_ThumbUrl_cn = (String) hashMap.get("ThumbUrl_cn");
                            aVar.field_ThumbUrl_en = (String) hashMap.get("ThumbUrl_en");
                            aVar.field_ThumbUrl_hk = (String) hashMap.get("ThumbUrl_hk");
                            aVar.field_ThumbUrl_tw = (String) hashMap.get("ThumbUrl_tw");
                            aVar.field_ImgUrl_android_cn = a(hashMap, "ImgUrl_android_cn");
                            aVar.field_ImgUrl_android_tw = a(hashMap, "ImgUrl_android_tw");
                            aVar.field_ImgUrl_android_en = a(hashMap, "ImgUrl_android_en");
                            aVar.field_ImgUrl_android_hk = a(hashMap, "ImgUrl_android_hk");
                            if (TextUtils.isEmpty(aVar.field_ImgUrl_android_cn)) {
                                aVar.field_ImgUrl_android_cn = (String) hashMap.get("ImgUrl_cn");
                            }
                            if (TextUtils.isEmpty(aVar.field_ImgUrl_android_en)) {
                                aVar.field_ImgUrl_android_en = (String) hashMap.get("ImgUrl_en");
                            }
                            if (TextUtils.isEmpty(aVar.field_ImgUrl_android_hk)) {
                                aVar.field_ImgUrl_android_hk = (String) hashMap.get("ImgUrl_hk");
                            }
                            if (TextUtils.isEmpty(aVar.field_ImgUrl_android_tw)) {
                                aVar.field_ImgUrl_android_tw = (String) hashMap.get("ImgUrl_tw");
                            }
                            aVar.field_RedPoint = bh.VI((String) hashMap.get("RedPoint"));
                            aVar.field_WeAppDebugMode = bh.VI((String) hashMap.get("WeAppDebugMode"));
                            aVar.field_TitleKey_android = (String) hashMap.get("TitleKey_android");
                            aVar.field_Icon = (String) hashMap.get("Icon");
                        }
                    }
                }
            }
        }
        return aVar;
    }

    private static String a(HashMap<String, String> hashMap, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!hashMap.containsKey(str)) {
            return stringBuilder.toString();
        }
        stringBuilder.append((String) hashMap.get(str)).append(";");
        int i = 1;
        while (true) {
            String str2 = str + "_" + i;
            if (!hashMap.containsKey(str2)) {
                return stringBuilder.toString();
            }
            stringBuilder.append((String) hashMap.get(str2)).append(";");
            i++;
        }
    }

    public static List<String> Qz(String str) {
        if (TextUtils.isEmpty(str)) {
            return Collections.EMPTY_LIST;
        }
        return Arrays.asList(str.split(";"));
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
            x.e("MicroMsg.Welabparser", e.toString());
            return null;
        }
    }
}
