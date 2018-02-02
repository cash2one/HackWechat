package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.az.d;
import com.tencent.mm.az.f;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.q;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class i {
    private static String lvM = "";
    private static String lvN = "temp";
    private static String lvO = "newemoji";
    private static String lvP = "panel";
    public static String lvQ = "suggest";
    public static String lvR = "egg";
    private static String lvS = "search";
    private static String lvT = "config.conf";
    private static String lvU = "emojipanel.zip";
    private static String lvV = "newemoji.zip";
    private static String lvW = "emoji_template.zip";
    private static String lvX = "emojisuggest.zip";
    private static String lvY = "egg.zip";
    private static String lvZ = "newemoji-config.xml";
    private static String lwa = "emojipanel-config.xml";
    public static String lwb = "emojisuggest-config.xml";
    public static String lwc = "egg.xml";
    private static int lwd = 0;
    private static int lwe = 0;
    private static int lwf = 0;
    private static int lwg = 0;
    private static i lwh;
    public f lwi;

    public static i aBg() {
        if (lwh == null) {
            synchronized (i.class) {
                lwh = new i();
            }
        }
        return lwh;
    }

    public static String aBh() {
        if (bh.ov(lvM)) {
            lvM = e.gZL.replace("/data/user/0", "/data/data");
            lvM += "/emoji";
        }
        return lvM;
    }

    public static boolean a(bc bcVar, a aVar, String str) {
        File file = new File(bcVar.fpl.filePath);
        if (!file.exists() || file.length() <= 0) {
            x.i("MicroMsg.emoji.EmojiResUpdateMgr", "copyAndUnzipFile update file don't exist.");
            return false;
        }
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "copyAndUnzipFile start. type:%s filePath:%s", new Object[]{String.valueOf(aVar), file.getAbsolutePath()});
        File file2 = new File(aBh(), str);
        if (file2.exists()) {
            com.tencent.mm.a.e.g(file2);
        }
        switch (1.lwj[aVar.ordinal()]) {
            case 1:
                str2 = lvV;
                break;
            case 2:
                str2 = lvU;
                break;
            case 3:
                str2 = lvW;
                break;
            case 4:
                str2 = lvX;
                break;
            case 5:
                str2 = lvY;
                break;
            default:
                x.w("MicroMsg.emoji.EmojiResUpdateMgr", "unknown type. type:%s", new Object[]{String.valueOf(aVar)});
                str2 = "";
                break;
        }
        File file3 = new File(file2, str2);
        file2.mkdirs();
        com.tencent.mm.a.e.x(file.getAbsolutePath(), file3.getAbsolutePath());
        int ft = bh.ft(file3.getAbsolutePath(), file2.getAbsolutePath());
        b.deleteFile(file3.getPath());
        x.d("MicroMsg.emoji.EmojiResUpdateMgr", "copyAndUnzipFile done. user time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        if (ft >= 0) {
            return true;
        }
        return false;
    }

    private static int y(File file) {
        InputStream fileInputStream;
        Throwable e;
        Reader reader;
        InputStream inputStream;
        Throwable th;
        Reader reader2 = null;
        long currentTimeMillis = System.currentTimeMillis();
        int i = -1;
        if (file.exists()) {
            Reader inputStreamReader;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream);
                } catch (Exception e2) {
                    e = e2;
                    reader = null;
                    inputStream = fileInputStream;
                    try {
                        x.e("MicroMsg.emoji.EmojiResUpdateMgr", bh.i(e));
                        com.tencent.mm.a.e.c(inputStream);
                        com.tencent.mm.a.e.a(reader2);
                        com.tencent.mm.a.e.a(reader);
                        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        return i;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = inputStream;
                        inputStreamReader = reader2;
                        com.tencent.mm.a.e.c(fileInputStream);
                        com.tencent.mm.a.e.a(inputStreamReader);
                        com.tencent.mm.a.e.a(reader);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    reader = null;
                    inputStreamReader = null;
                    com.tencent.mm.a.e.c(fileInputStream);
                    com.tencent.mm.a.e.a(inputStreamReader);
                    com.tencent.mm.a.e.a(reader);
                    throw th;
                }
                try {
                    reader = new BufferedReader(inputStreamReader);
                    try {
                        String str = "";
                        while (true) {
                            String readLine = reader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            str = str + readLine;
                        }
                        i = new JSONObject(str).getInt("version");
                        x.d("MicroMsg.emoji.EmojiResUpdateMgr", "readVersionCode config file content:%s version:%d", new Object[]{str, Integer.valueOf(i)});
                        com.tencent.mm.a.e.c(fileInputStream);
                        com.tencent.mm.a.e.a(inputStreamReader);
                        com.tencent.mm.a.e.a(reader);
                    } catch (Exception e3) {
                        e = e3;
                        reader2 = inputStreamReader;
                        inputStream = fileInputStream;
                        x.e("MicroMsg.emoji.EmojiResUpdateMgr", bh.i(e));
                        com.tencent.mm.a.e.c(inputStream);
                        com.tencent.mm.a.e.a(reader2);
                        com.tencent.mm.a.e.a(reader);
                        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        return i;
                    } catch (Throwable th4) {
                        th = th4;
                        com.tencent.mm.a.e.c(fileInputStream);
                        com.tencent.mm.a.e.a(inputStreamReader);
                        com.tencent.mm.a.e.a(reader);
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    reader = null;
                    reader2 = inputStreamReader;
                    inputStream = fileInputStream;
                    x.e("MicroMsg.emoji.EmojiResUpdateMgr", bh.i(e));
                    com.tencent.mm.a.e.c(inputStream);
                    com.tencent.mm.a.e.a(reader2);
                    com.tencent.mm.a.e.a(reader);
                    x.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    return i;
                } catch (Throwable th5) {
                    th = th5;
                    reader = null;
                    com.tencent.mm.a.e.c(fileInputStream);
                    com.tencent.mm.a.e.a(inputStreamReader);
                    com.tencent.mm.a.e.a(reader);
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                reader = null;
                inputStream = null;
                x.e("MicroMsg.emoji.EmojiResUpdateMgr", bh.i(e));
                com.tencent.mm.a.e.c(inputStream);
                com.tencent.mm.a.e.a(reader2);
                com.tencent.mm.a.e.a(reader);
                x.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                return i;
            } catch (Throwable th6) {
                th = th6;
                reader = null;
                inputStreamReader = null;
                fileInputStream = null;
                com.tencent.mm.a.e.c(fileInputStream);
                com.tencent.mm.a.e.a(inputStreamReader);
                com.tencent.mm.a.e.a(reader);
                throw th;
            }
        }
        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion file don't exist. path:%s", new Object[]{file.getAbsolutePath()});
        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return i;
    }

    public final boolean a(bc bcVar, a aVar) {
        int y;
        int intValue;
        if (a(bcVar, aVar, lvN)) {
            File file = new File(aBh(), lvN);
            x.d("MicroMsg.emoji.EmojiResUpdateMgr", "readVersionCode unzip file done.");
            y = y(new File(file, lvT));
        } else {
            x.i("MicroMsg.emoji.EmojiResUpdateMgr", "unzip file failed. type:%s", new Object[]{String.valueOf(aVar)});
            y = -1;
        }
        switch (1.lwj[aVar.ordinal()]) {
            case 1:
                ar.Hg();
                intValue = ((Integer) c.CU().get(a.xny, Integer.valueOf(0))).intValue();
                lwd = intValue;
                break;
            case 2:
                ar.Hg();
                intValue = ((Integer) c.CU().get(a.xnz, Integer.valueOf(0))).intValue();
                lwe = intValue;
                break;
            case 3:
                intValue = com.tencent.mm.ak.a.huR;
                break;
            case 4:
                ar.Hg();
                intValue = ((Integer) c.CU().get(a.xnA, Integer.valueOf(0))).intValue();
                lwf = intValue;
                break;
            case 5:
                ar.Hg();
                intValue = ((Integer) c.CU().get(a.xnB, Integer.valueOf(0))).intValue();
                lwg = intValue;
                break;
            default:
                intValue = -1;
                break;
        }
        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "file version:%d, current version:%d", new Object[]{Integer.valueOf(y), Integer.valueOf(intValue)});
        if (y == -1 || intValue >= y) {
            return false;
        }
        return true;
    }

    private static void z(File file) {
        Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        parse.normalize();
        NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("emoji");
        if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
            ArrayList arrayList = new ArrayList();
            int length = elementsByTagName.getLength();
            for (int i = 0; i < length; i++) {
                NodeList childNodes = elementsByTagName.item(i).getChildNodes();
                if (childNodes != null && childNodes.getLength() > 0) {
                    q qVar = new q();
                    for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
                        Node item = childNodes.item(i2);
                        String nodeName = item.getNodeName();
                        if (nodeName.equalsIgnoreCase("key")) {
                            qVar.field_key = item.getTextContent();
                        } else if (nodeName.equalsIgnoreCase("cn-value")) {
                            if (bh.ov(item.getTextContent()) || "null".equalsIgnoreCase(item.getTextContent())) {
                                qVar.field_cnValue = qVar.field_key;
                            } else {
                                try {
                                    qVar.field_cnValue = item.getTextContent();
                                } catch (Exception e) {
                                    x.e("MicroMsg.emoji.EmojiResUpdateMgr", "parserNewEmojiConfig parseXML exception:%s", new Object[]{e.toString()});
                                    return;
                                }
                            }
                        } else if (nodeName.equalsIgnoreCase("qq-value")) {
                            if (bh.ov(item.getTextContent()) || "null".equalsIgnoreCase(item.getTextContent())) {
                                qVar.field_qqValue = qVar.field_key;
                            } else {
                                qVar.field_qqValue = item.getTextContent();
                            }
                        } else if (nodeName.equalsIgnoreCase("en-value")) {
                            if (bh.ov(item.getTextContent()) || "null".equalsIgnoreCase(item.getTextContent())) {
                                qVar.field_enValue = qVar.field_key;
                            } else {
                                qVar.field_enValue = item.getTextContent();
                            }
                        } else if (nodeName.equalsIgnoreCase("tw-value")) {
                            if (bh.ov(item.getTextContent()) || "null".equalsIgnoreCase(item.getTextContent())) {
                                qVar.field_twValue = qVar.field_key;
                            } else {
                                qVar.field_twValue = item.getTextContent();
                            }
                        } else if (nodeName.equalsIgnoreCase("th-value")) {
                            if (bh.ov(item.getTextContent()) || "null".equalsIgnoreCase(item.getTextContent())) {
                                qVar.field_thValue = qVar.field_key;
                            } else {
                                qVar.field_thValue = item.getTextContent();
                            }
                        } else if (nodeName.equalsIgnoreCase(DownloadInfo.FILENAME)) {
                            qVar.field_fileName = item.getTextContent();
                        } else if (nodeName.equalsIgnoreCase("eggIndex")) {
                            int intValue;
                            try {
                                intValue = Integer.valueOf(item.getTextContent()).intValue();
                            } catch (Throwable e2) {
                                x.e("MicroMsg.emoji.EmojiResUpdateMgr", bh.i(e2));
                                intValue = -1;
                            }
                            qVar.field_eggIndex = intValue;
                        } else {
                            continue;
                        }
                    }
                    qVar.field_position = -1;
                    x.d("MicroMsg.emoji.EmojiResUpdateMgr", qVar.toString());
                    if (bh.ov(qVar.field_key)) {
                        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "key is empty");
                    } else {
                        arrayList.add(qVar);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                x.i("MicroMsg.emoji.EmojiResUpdateMgr", "parserNewEmojiConfig smiley list is null.");
            } else if (((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().p(arrayList)) {
                com.tencent.mm.sdk.b.b cmVar = new cm();
                cmVar.fqK.fpn = 1;
                com.tencent.mm.sdk.b.a.xef.m(cmVar);
                lwd = y(new File(aBh() + File.separator + lvO, lvT));
                ar.Hg();
                c.CU().a(a.xny, Integer.valueOf(lwd));
            }
        }
    }

    private static void A(File file) {
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("item");
            if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                ArrayList arrayList = new ArrayList();
                int length = elementsByTagName.getLength();
                for (int i = 0; i < length; i++) {
                    Node item = elementsByTagName.item(i);
                    if (!(item == null || bh.ov(item.getTextContent()))) {
                        String replaceAll = item.getTextContent().replaceAll("\"", "");
                        if (replaceAll.startsWith("\\\\u")) {
                            char[] toChars = Character.toChars(Integer.parseInt(replaceAll.substring(3), 16));
                            replaceAll = "";
                            int i2 = 0;
                            while (i2 < toChars.length) {
                                String str = replaceAll + String.valueOf(toChars[i2]);
                                i2++;
                                replaceAll = str;
                            }
                        }
                        s sVar = new s(i, replaceAll);
                        if (bh.ov(sVar.field_key)) {
                            x.i("MicroMsg.emoji.EmojiResUpdateMgr", "key is null.");
                        } else {
                            arrayList.add(sVar);
                        }
                        x.d("MicroMsg.emoji.EmojiResUpdateMgr", sVar.toString());
                    }
                }
                if (arrayList.isEmpty()) {
                    x.i("MicroMsg.emoji.EmojiResUpdateMgr", "parserEmojiPanelConfig smiley panel list is null.");
                } else if (((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().q(arrayList)) {
                    com.tencent.mm.sdk.b.b cmVar = new cm();
                    cmVar.fqK.fpn = 2;
                    com.tencent.mm.sdk.b.a.xef.m(cmVar);
                    lwe = y(new File(aBh() + File.separator + lvP, lvT));
                    ar.Hg();
                    c.CU().a(a.xnz, Integer.valueOf(lwe));
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiResUpdateMgr", "parserEmojiPanelConfig parseXML exception:%s", new Object[]{e.toString()});
        }
    }

    public static void B(File file) {
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("group");
            if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                int length = elementsByTagName.getLength();
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < length; i++) {
                    NodeList childNodes = elementsByTagName.item(i).getChildNodes();
                    if (childNodes != null && childNodes.getLength() > 0) {
                        int length2 = childNodes.getLength();
                        ArrayList arrayList2 = new ArrayList();
                        for (int i2 = 0; i2 < length2; i2++) {
                            Node item = childNodes.item(i2);
                            if (item.getNodeName().equals("word")) {
                                String textContent = item.getTextContent();
                                if (!bh.ov(textContent)) {
                                    x.d("MicroMsg.emoji.EmojiResUpdateMgr", "word:%s", new Object[]{textContent});
                                    arrayList2.add(textContent.trim());
                                }
                            }
                        }
                        arrayList.add(arrayList2);
                    }
                }
                com.tencent.mm.plugin.emoji.model.i.aBE().lwV.ag(arrayList);
                lwf = y(new File(aBh() + File.separator + lvQ, lvT));
                ar.Hg();
                c.CU().a(a.xnA, Integer.valueOf(lwf));
            }
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiResUpdateMgr", "parserEmojiDescConfig parseXML exception:%s", new Object[]{e.toString()});
        }
    }

    public static void C(File file) {
        try {
            String bT = com.tencent.mm.a.e.bT(file.getAbsolutePath());
            Map y = bi.y(bT, "EasterEgg");
            x.i("MicroMsg.emoji.EmojiResUpdateMgr", "eggXml:" + bT);
            if (y == null) {
                x.e("MicroMsg.emoji.EmojiResUpdateMgr", "Exception in parseXml EasterEgg, please check the xml");
                return;
            }
            f fVar = new f();
            fVar.hJA = (double) bh.VI((String) y.get(".EasterEgg.$version"));
            int i = 0;
            while (true) {
                String str = ".EasterEgg.Item" + (i == 0 ? "" : Integer.valueOf(i));
                if (y.get(str + ".$name") != null) {
                    d dVar = new d();
                    dVar.name = bh.ou((String) y.get(str + ".$name"));
                    dVar.hJt = bh.ou((String) y.get(str + ".$langs"));
                    dVar.hJq = bh.VI((String) y.get(str + ".$reportType"));
                    dVar.hJr = bh.Vz((String) y.get(str + ".$BeginDate"));
                    dVar.hJs = bh.Vz((String) y.get(str + ".$EndDate"));
                    dVar.hJu = bh.ou((String) y.get(str + ".FileName"));
                    dVar.hJv = bh.VI((String) y.get(str + ".AnimType"));
                    dVar.hJw = bh.VI((String) y.get(str + ".AnimType.$viewcount"));
                    dVar.hJx = bh.VI((String) y.get(str + ".AnimType.$minSize"));
                    dVar.maxSize = bh.VI((String) y.get(str + ".AnimType.$maxSize"));
                    int i2 = 0;
                    while (true) {
                        bT = str + ".KeyWord" + (i2 == 0 ? "" : Integer.valueOf(i2));
                        String str2 = bT + ".$lang";
                        if (y.get(bT) == null) {
                            break;
                        }
                        com.tencent.mm.az.e eVar = new com.tencent.mm.az.e();
                        eVar.hJy = bh.ou((String) y.get(bT));
                        eVar.lang = bh.ou((String) y.get(str2));
                        dVar.hJo.add(eVar);
                        i2++;
                    }
                    fVar.hJz.add(dVar);
                    i++;
                } else {
                    byte[] toByteArray = fVar.toByteArray();
                    StringBuilder stringBuilder = new StringBuilder();
                    ar.Hg();
                    com.tencent.mm.a.e.b(stringBuilder.append(c.FB()).append("eggingfo.ini").toString(), toByteArray, toByteArray.length);
                    lwg = y(new File(aBh() + File.separator + lvR, lvT));
                    ar.Hg();
                    c.CU().a(a.xnB, Integer.valueOf(lwg));
                    return;
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", e, "", new Object[0]);
        }
    }

    public final void a(bc bcVar, boolean z) {
        if (!z && !a(bcVar, a.lwk)) {
            x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmoji need no update.");
        } else if (z || a(bcVar, a.lwk, lvO)) {
            File file = new File(new File(aBh(), lvO), lvZ);
            if (file.exists()) {
                z(file);
            } else {
                x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmoji config don't exist.");
            }
        } else {
            x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmoji unzip file failed.");
        }
    }

    public final void b(bc bcVar, boolean z) {
        if (!(z || a(bcVar, a.lwl))) {
            ar.Hg();
            String str = (String) c.CU().get(a.xnC, lwa);
            String aBp = n.aBp();
            int i = (bh.ov(aBp) || str.equalsIgnoreCase(aBp)) ? 0 : 1;
            if (i == 0) {
                x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiPanel need no update.");
                return;
            }
        }
        if (z || a(bcVar, a.lwl, lvP)) {
            File file = new File(aBh(), lvP);
            str = n.aBp();
            if (bh.ov(str)) {
                str = lwa;
                x.i("MicroMsg.emoji.EmojiResUpdateMgr", "no dynamic config panel file name. use default.");
            } else {
                if (!new File(file, str).exists()) {
                    str = lwa;
                }
                x.i("MicroMsg.emoji.EmojiResUpdateMgr", "dynamic config panel file name :%s", new Object[]{str});
            }
            File file2 = new File(file, str);
            if (file2.exists()) {
                A(file2);
                ar.Hg();
                c.CU().a(a.xnC, str);
                return;
            }
            x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiPanel config don't exist.");
            return;
        }
        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiPanel unzip file failed.");
    }

    public static boolean b(bc bcVar) {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.bx.b.cgX();
        com.tencent.mm.bx.b.cha();
        long j = com.tencent.mm.bx.b.cgX().xkx;
        com.tencent.mm.bx.b.cgX();
        int Wh = com.tencent.mm.bx.b.Wh(bcVar.fpl.filePath);
        com.tencent.mm.bx.b.cgX();
        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "currentSupportVersion:%d current version:%d supportVersion:%d file version:%d use time:%d", new Object[]{Integer.valueOf(1), Long.valueOf(j), Integer.valueOf(Wh), Long.valueOf(com.tencent.mm.bx.b.Wg(bcVar.fpl.filePath)), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        if (Wh == 1 && r6 > j) {
            return true;
        }
        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "need not update color emoji");
        return false;
    }

    public final f aAY() {
        try {
            if (this.lwi == null) {
                StringBuilder stringBuilder = new StringBuilder();
                ar.Hg();
                byte[] e = com.tencent.mm.a.e.e(stringBuilder.append(c.FB()).append("eggingfo.ini").toString(), 0, -1);
                if (e == null) {
                    x.d("MicroMsg.emoji.EmojiResUpdateMgr", "data is null, parse EggList from config file fail");
                } else {
                    this.lwi = (f) new f().aF(e);
                }
            }
        } catch (Throwable e2) {
            x.w("MicroMsg.emoji.EmojiResUpdateMgr", "init crash : %s, try delete egg file", new Object[]{e2.getLocalizedMessage()});
            x.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", e2, "", new Object[0]);
        }
        return this.lwi;
    }
}
