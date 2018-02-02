package com.tencent.xweb.xwalk.a;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.xweb.util.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xwalk.core.XWalkInitializer;

public final class a {

    public static class a {
        public String Atu;
        public String Atv;
        public c[] Atw;
        public com.tencent.xweb.c.a.a[] Atx;
    }

    public static class b {
        public boolean AtA;
        public String Atu;
        public int Aty;
        public String Atz;
        public boolean bUseCdn;
    }

    public static class c {
        com.tencent.xweb.c.a.b AqK = new com.tencent.xweb.c.a.b();
        public boolean AtA;
        public int AtB;
        public int AtC;
        public b[] AtD;
        public d AtE = new d();
        public String Atu;
        public String Atz;
        public boolean bUseCdn;
    }

    public static class d {
        public String AtF = "";
    }

    static String h(File file, int i) {
        String str = null;
        try {
            byte[] bArr = new byte[i];
            int read = new FileInputStream(file).read(bArr, 0, bArr.length);
            if (read == bArr.length) {
                String str2 = new String(bArr, 0, read);
                int indexOf = str2.indexOf("<Versions>");
                if (indexOf >= 0) {
                    bArr = MessageDigest.getInstance("MD5").digest(str2.substring(indexOf).getBytes());
                    if (!(bArr == null || bArr.length == 0)) {
                        StringBuilder stringBuilder = new StringBuilder(bArr.length);
                        for (byte b : bArr) {
                            String toHexString = Integer.toHexString(b & 255);
                            if (toHexString.length() == 1) {
                                stringBuilder.append(0);
                            }
                            stringBuilder.append(toHexString);
                        }
                        str = stringBuilder.toString().toUpperCase();
                    }
                }
            }
        } catch (Exception e) {
        }
        return str;
    }

    private static int a(Element element, String str) {
        if (element == null) {
            return 0;
        }
        String attribute = element.getAttribute(str);
        if (attribute == null || attribute.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(attribute);
    }

    private static boolean b(Element element, String str) {
        if (element == null) {
            return false;
        }
        String attribute = element.getAttribute(str);
        if (attribute == null || attribute.isEmpty()) {
            return false;
        }
        return Boolean.parseBoolean(attribute);
    }

    private static b[] a(Element element) {
        NodeList elementsByTagName = element.getElementsByTagName("Patch");
        if (elementsByTagName == null || elementsByTagName.getLength() == 0) {
            return null;
        }
        b[] bVarArr = new b[elementsByTagName.getLength()];
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            b bVar = new b();
            Element element2 = (Element) elementsByTagName.item(i);
            bVar.Atz = element2.getAttribute(SlookSmartClipMetaTag.TAG_TYPE_URL);
            bVar.Aty = a(element2, "targetVersion");
            bVar.Atu = element2.getAttribute("md5");
            bVar.AtA = b(element2, "useCellular");
            bVar.bUseCdn = b(element2, "useCdn");
            bVarArr[i] = bVar;
        }
        return bVarArr;
    }

    private static void a(a aVar, Element element) {
        if (element != null) {
            try {
                NodeList elementsByTagName = element.getElementsByTagName("command");
                if (elementsByTagName != null && elementsByTagName.getLength() != 0) {
                    aVar.Atx = new com.tencent.xweb.c.a.a[elementsByTagName.getLength()];
                    for (int i = 0; i < elementsByTagName.getLength(); i++) {
                        com.tencent.xweb.c.a.a aVar2 = new com.tencent.xweb.c.a.a();
                        Element element2 = (Element) elementsByTagName.item(i);
                        aVar2.AqK.AqQ = a(element2, "apkMin");
                        aVar2.AqK.AqR = a(element2, "apkMax");
                        aVar2.AqK.AqO = a(element2, "sdkMin");
                        aVar2.AqK.AqP = a(element2, "sdkMax");
                        aVar2.AqK.AqS = a(element2, "apiMin");
                        aVar2.AqK.AqT = a(element2, "apiMax");
                        aVar2.AqK.AqU = element2.getAttribute("forbidDeviceRegex");
                        aVar2.AqK.AqV = a(element2, "grayMin");
                        aVar2.AqK.AqW = a(element2, "grayMax");
                        aVar2.AqL = element2.getAttribute("optype");
                        aVar2.AqM = element2.getAttribute("opvalue");
                        aVar2.AqN = element2.getAttribute("module");
                        aVar.Atx[i] = aVar2;
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public static a i(File file, String str) {
        a aVar = null;
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        try {
            InputStream fileInputStream = new FileInputStream(file);
            a aVar2 = new a();
            try {
                Element documentElement = newInstance.newDocumentBuilder().parse(fileInputStream).getDocumentElement();
                if (documentElement == null) {
                    XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
                    return null;
                }
                aVar2.Atu = documentElement.getAttribute("checkvalue");
                if (aVar2.Atu == null || !aVar2.Atu.equalsIgnoreCase(str)) {
                    e.gB(34);
                    XWalkInitializer.addXWalkInitializeLog("parse config failed , md5 not match");
                    return null;
                }
                aVar2.Atv = documentElement.getAttribute("configVer");
                a(aVar2, documentElement);
                NodeList elementsByTagName = documentElement.getElementsByTagName("VersionInfo");
                if (!(elementsByTagName == null || elementsByTagName.getLength() == 0)) {
                    aVar2.Atw = new c[elementsByTagName.getLength()];
                    for (int i = 0; i < elementsByTagName.getLength(); i++) {
                        c cVar = new c();
                        Element element = (Element) elementsByTagName.item(i);
                        cVar.Atz = element.getAttribute("fullurl");
                        cVar.Atu = element.getAttribute("md5");
                        cVar.AqK.AqU = element.getAttribute("forbidDeviceRegex");
                        cVar.AqK.AqO = a(element, "sdkMin");
                        cVar.AqK.AqP = a(element, "sdkMax");
                        cVar.AqK.AqS = a(element, "apiMin");
                        cVar.AqK.AqT = a(element, "apiMax");
                        cVar.AtC = a(element, "period");
                        cVar.AtB = a(element, "version");
                        cVar.AtA = b(element, "useCellular");
                        cVar.AqK.AqV = a(element, "grayMin");
                        cVar.AqK.AqW = a(element, "grayMax");
                        cVar.bUseCdn = b(element, "useCdn");
                        d dVar = cVar.AtE;
                        if (dVar != null) {
                            NodeList elementsByTagName2 = element.getElementsByTagName("Description");
                            if (!(elementsByTagName2 == null || elementsByTagName2.getLength() == 0)) {
                                dVar.AtF = ((Element) elementsByTagName2.item(0)).getAttribute("versionStr");
                            }
                        }
                        cVar.AtD = a(element);
                        aVar2.Atw[i] = cVar;
                    }
                }
                return aVar2;
            } catch (ParserConfigurationException e) {
                aVar = aVar2;
                XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
                return aVar;
            } catch (SAXException e2) {
                aVar = aVar2;
                XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
                return aVar;
            } catch (IOException e3) {
                aVar = aVar2;
                XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
                return aVar;
            }
        } catch (ParserConfigurationException e4) {
            XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
            return aVar;
        } catch (SAXException e5) {
            XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
            return aVar;
        } catch (IOException e6) {
            XWalkInitializer.addXWalkInitializeLog("xml is cruppted");
            return aVar;
        }
    }
}
