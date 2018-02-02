package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.modelvideo.p;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.e.h.a;
import com.tencent.mm.plugin.backup.g.c;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.er;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class f implements l {
    public final int a(er erVar, boolean z, au auVar, String str, LinkedList<u> linkedList, HashMap<Long, a> hashMap, boolean z2, long j) {
        Object obj;
        int i;
        d.aqe().aqf().TU();
        String nt = s.nt(auVar.field_imgPath);
        r vx = c.vx(auVar.field_imgPath);
        if (vx == null || vx.status == 199) {
            obj = 1;
        } else {
            obj = null;
        }
        File file = new File(nt);
        if (obj == null || !file.exists()) {
            i = 0;
        } else {
            i = (int) file.length();
        }
        int i2 = 0;
        d.aqe().aqf().TU();
        String nu = s.nu(auVar.field_imgPath);
        File file2 = new File(nu);
        if (file2.exists()) {
            i2 = (int) file2.length();
        }
        if (z) {
            return i2 + i;
        }
        int i3 = 0;
        if (i2 != 0) {
            if (auVar.getType() == 62) {
                i3 = i.a(new i$a(nu, erVar, (LinkedList) linkedList, 13, z, "_thumb", z2)) + 0;
            } else {
                i3 = i.a(new i$a(nu, erVar, (LinkedList) linkedList, 11, z, "_thumb", z2)) + 0;
            }
        }
        i2 = (obj == null || i == 0) ? i3 : auVar.getType() == 62 ? i.a(new i$a(nt, erVar, (LinkedList) linkedList, 12, z, z2, null)) + i3 : i.a(new i$a(nt, erVar, (LinkedList) linkedList, 10, z, z2, null)) + i3;
        nu = a(erVar, auVar);
        if (nu == null) {
            return i2;
        }
        erVar.vGZ = new bdo().UA(nu);
        return i2 + nu.length();
    }

    public final int a(String str, er erVar, au auVar) {
        r rVar = new r();
        rVar.fDC = erVar.vGX.wJF;
        rVar.hVE = auVar.field_createTime;
        rVar.fFo = erVar.vHe;
        String str2 = erVar.vGZ.wJF;
        x.d("MicroMsg.BackupItemVideo", "parseVideoMsgXML content:" + str2);
        Map y = bi.y(str2, "msg");
        if (y != null) {
            try {
                rVar.hlp = g.aQ((String) y.get(".msg.videomsg.$length"), 0);
                rVar.hVH = g.aQ((String) y.get(".msg.videomsg.$playlength"), 0);
                rVar.hVz = (String) y.get(".msg.videomsg.$fromusername");
                int aQ = g.aQ((String) y.get(".msg.videomsg.$type"), 0);
                x.d("MicroMsg.BackupItemVideo", "video msg exportType :" + aQ);
                if (aQ == 44) {
                    aQ = 1;
                } else {
                    aQ = 0;
                }
                rVar.hVL = aQ;
            } catch (Throwable e) {
                x.e("MicroMsg.BackupItemVideo", "parsing voice msg xml failed");
                x.printErrStackTrace("MicroMsg.BackupItemVideo", e, "", new Object[0]);
            }
        } else {
            x.e("MicroMsg.BackupItemVideo", "videomsg paseXml failed:%s", new Object[]{erVar.vGZ.wJF});
            auVar.setContent(erVar.vGZ.wJF);
        }
        if (g.d(erVar, 10) || g.d(erVar, 12)) {
            rVar.status = 199;
        } else {
            rVar.status = 111;
        }
        String ns = s.ns(rVar.Ue());
        auVar.dT(ns);
        rVar.fileName = ns;
        if (auVar.getType() != 62) {
            auVar.setType(43);
        }
        auVar.setContent(p.b(rVar.Ue(), rVar.hVG, false));
        rVar.hVI = (int) c.i(auVar);
        rVar.hVF = bh.Wo();
        rVar.hVJ = 0;
        x.d("MicroMsg.BackupItemVideo", "Insert fileName[" + rVar.getFileName() + "] size:" + rVar.hlp + " svrid:" + rVar.fFo + " timelen:" + rVar.hVH + " user:" + rVar.Ud() + " human:" + rVar.Ue());
        d.aqe().aqf().TU().a(rVar);
        d.aqe().aqf().TU();
        str2 = s.nu(ns);
        if (auVar.getType() == 62) {
            g.b(erVar, 13, str2);
            str2 = g.a(erVar, 12);
        } else {
            g.b(erVar, 11, str2);
            str2 = g.a(erVar, 10);
        }
        if (str2 != null) {
            str2 = g.vm(str2) + str2;
            d.aqe().aqf().TU();
            k.q(str2, s.nt(ns), false);
        }
        return 0;
    }

    private static String a(er erVar, au auVar) {
        r vx = c.vx(auVar.field_imgPath);
        if (vx == null) {
            return null;
        }
        int i;
        if (auVar.getType() == 62) {
            i = 62;
        } else {
            i = 43;
        }
        erVar.ktN = i;
        if (bh.ov(auVar.field_content)) {
            return null;
        }
        String Ue;
        if (c.eV(auVar.field_talker)) {
            Ue = vx.Ue();
        } else {
            Ue = erVar.vGX.wJF;
        }
        Writer stringWriter = new StringWriter();
        try {
            XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
            newSerializer.setOutput(stringWriter);
            newSerializer.startTag(null, "msg");
            newSerializer.startTag(null, "videomsg");
            Map y = bi.y(vx.Ug(), "msg");
            if (y != null) {
                newSerializer.attribute(null, "aeskey", ((String) y.get(".msg.videomsg.$aeskey")));
                newSerializer.attribute(null, "cdnthumbaeskey", ((String) y.get(".msg.videomsg.$cdnthumbaeskey")));
                newSerializer.attribute(null, "cdnvideourl", ((String) y.get(".msg.videomsg.$cdnvideourl")));
                newSerializer.attribute(null, "cdnthumburl", ((String) y.get(".msg.videomsg.$cdnthumburl")));
                newSerializer.attribute(null, "cdnthumblength", ((String) y.get(".msg.videomsg.$cdnthumblength")));
            }
            newSerializer.attribute(null, "playlength", vx.hVH);
            newSerializer.attribute(null, "length", vx.hlp);
            newSerializer.attribute(null, DownloadSettingTable$Columns.TYPE, String.valueOf(i));
            if (!bh.ov(Ue)) {
                newSerializer.attribute(null, "fromusername", Ue);
            }
            newSerializer.attribute(null, "md5", vx.fHk);
            newSerializer.endTag(null, "videomsg");
            newSerializer.endTag(null, "msg");
            newSerializer.endDocument();
            stringWriter.flush();
            stringWriter.close();
            String stringBuffer = stringWriter.getBuffer().toString();
            x.d("MicroMsg.BackupItemVideo", "parseContent xml:" + stringBuffer);
            return stringBuffer;
        } catch (Exception e) {
            x.e("MicroMsg.BackupItemVideo", "packetVoice xml error: " + e.toString());
            return null;
        }
    }
}
