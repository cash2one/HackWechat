package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.mm.modelvideo.p;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.backup.bakoldlogic.b.i.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
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

public final class g implements k {
    public final int a(er erVar, boolean z, au auVar, String str, LinkedList<u> linkedList, HashMap<Long, a> hashMap, boolean z2, long j) {
        Object obj;
        b.aqJ().aqK().TU();
        String nt = s.nt(auVar.field_imgPath);
        r vx = d.vx(auVar.field_imgPath);
        if (vx == null || vx.status == 199) {
            obj = 1;
        } else {
            obj = null;
        }
        File file = new File(nt);
        int i;
        if (obj == null || !file.exists()) {
            i = 0;
        } else {
            i = (int) file.length();
        }
        int i2 = 0;
        b.aqJ().aqK().TU();
        String nu = s.nu(auVar.field_imgPath);
        File file2 = new File(nu);
        if (file2.exists()) {
            i2 = (int) file2.length();
        }
        int i3 = 0;
        if (i2 != 0) {
            if (auVar.getType() == 62) {
                i3 = j.a(new j.a(nu, erVar, linkedList, 13, false, "_thumb", false)) + 0;
            } else {
                i3 = j.a(new j.a(nu, erVar, linkedList, 11, false, "_thumb", false)) + 0;
            }
        }
        if (obj == null || r9 == 0) {
            i2 = i3;
        } else if (auVar.getType() == 62) {
            i2 = j.a(new j.a(nt, erVar, linkedList, 12, false, false, null)) + i3;
        } else {
            i2 = j.a(new j.a(nt, erVar, linkedList, 10, false, false, null)) + i3;
        }
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
        x.d("MicroMsg.BakOldItemVideo", "parseVideoMsgXML content:" + str2);
        Map y = bi.y(str2, "msg");
        if (y != null) {
            try {
                rVar.hlp = com.tencent.mm.plugin.backup.bakoldlogic.a.a.aQ((String) y.get(".msg.videomsg.$length"), 0);
                rVar.hVH = com.tencent.mm.plugin.backup.bakoldlogic.a.a.aQ((String) y.get(".msg.videomsg.$playlength"), 0);
                rVar.hVz = (String) y.get(".msg.videomsg.$fromusername");
                int aQ = com.tencent.mm.plugin.backup.bakoldlogic.a.a.aQ((String) y.get(".msg.videomsg.$type"), 0);
                x.d("MicroMsg.BakOldItemVideo", "video msg exportType :" + aQ);
                if (aQ == 44) {
                    aQ = 1;
                } else {
                    aQ = 0;
                }
                rVar.hVL = aQ;
            } catch (Throwable e) {
                x.e("MicroMsg.BakOldItemVideo", "parsing voice msg xml failed");
                x.printErrStackTrace("MicroMsg.BakOldItemVideo", e, "", new Object[0]);
            }
        } else {
            x.e("MicroMsg.BakOldItemVideo", "videomsg paseXml failed:%s", new Object[]{erVar.vGZ.wJF});
            auVar.setContent(erVar.vGZ.wJF);
        }
        if (com.tencent.mm.plugin.backup.bakoldlogic.a.a.d(erVar, 10) || com.tencent.mm.plugin.backup.bakoldlogic.a.a.d(erVar, 12)) {
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
        rVar.hVI = (int) d.i(auVar);
        rVar.hVF = bh.Wo();
        rVar.hVJ = 0;
        x.d("MicroMsg.BakOldItemVideo", "Insert fileName[" + rVar.getFileName() + "] size:" + rVar.hlp + " svrid:" + rVar.fFo + " timelen:" + rVar.hVH + " user:" + rVar.Ud() + " human:" + rVar.Ue());
        b.aqJ().aqK().TU().a(rVar);
        b.aqJ().aqK().TU();
        str2 = s.nu(ns);
        if (auVar.getType() == 62) {
            com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(erVar, 13, str2);
            str2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(erVar, 12);
        } else {
            com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(erVar, 11, str2);
            str2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(erVar, 10);
        }
        if (str2 != null) {
            str2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.vA(str2);
            b.aqJ().aqK().TU();
            k.q(str2, s.nt(ns), false);
        }
        return 0;
    }

    private static String a(er erVar, au auVar) {
        r vx = d.vx(auVar.field_imgPath);
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
        if (d.eV(auVar.field_talker)) {
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
            x.d("MicroMsg.BakOldItemVideo", "parseContent xml:" + stringBuffer);
            return stringBuffer;
        } catch (Exception e) {
            x.e("MicroMsg.BakOldItemVideo", "packetVoice xml error: " + e.toString());
            return null;
        }
    }
}
