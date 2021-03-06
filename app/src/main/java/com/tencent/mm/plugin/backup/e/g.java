package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.a.e;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.plugin.backup.e.h.a;
import com.tencent.mm.plugin.backup.g.c;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.er;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class g implements l {
    byte[] kmZ = new byte[]{(byte) 35, (byte) 33, (byte) 65, (byte) 77, (byte) 82, (byte) 10, (byte) 2, (byte) 35, (byte) 33};
    byte[] kna = new byte[]{(byte) 35, (byte) 33, (byte) 65, (byte) 77, (byte) 82, (byte) 10, (byte) 35, (byte) 33};

    public final int a(er erVar, boolean z, au auVar, String str, LinkedList<u> linkedList, HashMap<Long, a> hashMap, boolean z2, long j) {
        String vy = c.vy(auVar.field_imgPath);
        if (bh.ov(vy)) {
            return 0;
        }
        File file = new File(vy);
        if (!file.exists()) {
            return 0;
        }
        int length = (int) file.length();
        if (z) {
            return length;
        }
        int a = i.a(new i.a(vy, erVar, linkedList, 9, z2, z2, null));
        vy = d(auVar, length);
        if (vy == null) {
            return 0;
        }
        erVar.vGZ = new bdo().UA(vy);
        a += vy.length();
        return length == 0 ? a : a;
    }

    public final int a(String str, er erVar, au auVar) {
        String str2 = erVar.vGZ.wJF;
        if (c.eV(erVar.vGX.wJF)) {
            int hO = c.hO(str2);
            if (hO != -1 && hO + 2 < str2.length()) {
                str2 = str2.substring(hO + 2);
            }
            x.v("MicroMsg.BackupItemVoice", "recover, voiceContentXml:%s", str2);
        }
        Map y = bi.y(str2, "msg");
        if (y != null) {
            try {
                auVar.setContent(n.b((String) y.get(".msg.voicemsg.$fromusername"), (long) com.tencent.mm.plugin.backup.a.g.aQ((String) y.get(".msg.voicemsg.$voicelength"), 0), com.tencent.mm.plugin.backup.a.g.aQ((String) y.get(".msg.voicemsg.$isPlayed"), 1) == 1));
            } catch (Throwable e) {
                x.e("MicroMsg.BackupItemVoice", "parsing voice msg xml failed");
                x.printErrStackTrace("MicroMsg.BackupItemVoice", e, "", new Object[0]);
            }
        } else {
            x.e("MicroMsg.BackupItemVoice", "voicemsg paseXml failed:%s", erVar.vGZ.wJF);
            auVar.setContent(erVar.vGZ.wJF);
        }
        str2 = com.tencent.mm.modelvoice.u.oe(erVar.vGX.wJF);
        auVar.dT(str2);
        c.i(auVar);
        str2 = c.vy(str2);
        String a = com.tencent.mm.plugin.backup.a.g.a(erVar, 9);
        if (!bh.ov(a)) {
            a = com.tencent.mm.plugin.backup.a.g.vm(a) + a;
            if (e.bO(a)) {
                byte[] e2 = e.e(a, 0, 9);
                if (d(this.kmZ, e2)) {
                    e2 = e.e(a, 6, -1);
                    b.deleteFile(a);
                    e.b(a, e2, e2.length);
                } else if (d(this.kna, e2)) {
                    e2 = e.e(a, 6, -1);
                    b.deleteFile(a);
                    e.b(a, e2, e2.length);
                }
            }
        }
        if (!(str2 == null || com.tencent.mm.plugin.backup.a.g.b(erVar, 9, str2))) {
            a = com.tencent.mm.plugin.backup.a.g.a(erVar, 9);
            if (a != null) {
                x.d("MicroMsg.BackupItemVoice", "recover from path:%s", com.tencent.mm.plugin.backup.a.g.vm(a) + a);
                k.q(a, str2, false);
            }
        }
        return 0;
    }

    private static boolean d(byte[] bArr, byte[] bArr2) {
        if (bh.bw(bArr2)) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static String d(au auVar, int i) {
        String str = null;
        if (!bh.ov(auVar.field_content)) {
            n nVar = new n(auVar.field_content);
            Writer stringWriter = new StringWriter();
            try {
                XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
                newSerializer.setOutput(stringWriter);
                newSerializer.startTag(null, "msg");
                newSerializer.startTag(null, "voicemsg");
                newSerializer.attribute(null, "length", String.valueOf(i));
                newSerializer.attribute(null, "endflag", "1");
                newSerializer.attribute(null, "cancelflag", "0");
                newSerializer.attribute(null, "voicelength", nVar.time);
                if (!bh.ov(nVar.hVz)) {
                    newSerializer.attribute(null, "fromusername", nVar.hVz);
                }
                newSerializer.attribute(null, "isPlayed", nVar.hVA ? "1" : "0");
                newSerializer.endTag(null, "voicemsg");
                newSerializer.endTag(null, "msg");
                newSerializer.endDocument();
                stringWriter.flush();
                stringWriter.close();
                str = stringWriter.getBuffer().toString();
                if (c.eV(auVar.field_talker)) {
                    str = nVar.hVz + ":\n" + str;
                }
                x.i("MicroMsg.BackupItemVoice", "parseContent xml:%s", str);
            } catch (Exception e) {
                x.e("MicroMsg.BackupItemVoice", "packetVoice xml error: " + e.toString());
            }
        }
        return str;
    }
}
