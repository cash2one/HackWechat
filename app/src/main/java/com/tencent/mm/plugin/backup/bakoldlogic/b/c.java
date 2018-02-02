package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.er;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class c implements k {

    private static class a {
        public static String kmS = "<msg>";
        public static String kmT = "</msg>";

        public static String vu(String str) {
            com.tencent.mm.plugin.backup.bakoldlogic.b.a.a vB = a.vB(str);
            return vB == null ? null : vB.knq;
        }

        public static String a(au auVar, er erVar) {
            EmojiInfo XU = b.aqJ().aqK().aqc().XU(auVar.field_imgPath);
            if (XU == null) {
                return null;
            }
            com.tencent.mm.plugin.backup.bakoldlogic.b.a.a vC = a.vC(XU.Nr());
            if (vC == null) {
                vC = new com.tencent.mm.plugin.backup.bakoldlogic.b.a.a(XU.Nr(), XU.Nr(), XU.Nr(), XU.Nr());
            }
            Writer stringWriter = new StringWriter();
            try {
                String az;
                XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
                newSerializer.setOutput(stringWriter);
                newSerializer.startDocument("UTF-8", Boolean.valueOf(true));
                newSerializer.startTag(null, "msg");
                newSerializer.startTag(null, "emoji");
                newSerializer.attribute(null, "fromusername", erVar.vGX.wJF);
                newSerializer.attribute(null, "tousername", erVar.vGY.wJF);
                newSerializer.attribute(null, DownloadSettingTable$Columns.TYPE, XU.field_type);
                newSerializer.attribute(null, "idbuffer", XU.ckz());
                newSerializer.attribute(null, "md5", vC.knr);
                newSerializer.attribute(null, "len", "1024");
                newSerializer.attribute(null, "androidmd5", vC.knq);
                newSerializer.attribute(null, "androidlen", "1024");
                newSerializer.attribute(null, "productid", XU.field_groupId);
                newSerializer.endTag(null, "emoji");
                if (XU.Yz()) {
                    newSerializer.startTag(null, "gameext");
                    Map y = bi.y(XU.we(), "gameext");
                    String az2 = bh.az((String) y.get(".gameext.$type"), "");
                    az = bh.az((String) y.get(".gameext.$content"), "");
                    if (az2.equals("") || az.equals("")) {
                        stringWriter.close();
                        return "";
                    }
                    newSerializer.attribute(null, DownloadSettingTable$Columns.TYPE, az2);
                    newSerializer.attribute(null, "content", az);
                    newSerializer.endTag(null, "gameext");
                }
                newSerializer.endTag(null, "msg");
                newSerializer.endDocument();
                stringWriter.flush();
                stringWriter.close();
                az = stringWriter.getBuffer().toString();
                try {
                    az = az.substring(az.indexOf(kmS), az.indexOf(kmT) + kmT.length());
                    x.d("MicroMsg.EmojiConvert", "xml " + az);
                    return az;
                } catch (Exception e) {
                    return "";
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.EmojiConvert", e2, "", new Object[0]);
                return "";
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.EmojiConvert", e22, "", new Object[0]);
                return "";
            } catch (Throwable e222) {
                x.printErrStackTrace("MicroMsg.EmojiConvert", e222, "", new Object[0]);
                return "";
            } catch (Throwable e2222) {
                x.printErrStackTrace("MicroMsg.EmojiConvert", e2222, "", new Object[0]);
                return "";
            }
        }
    }

    private static boolean vp(String str) {
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        return bi.y(str, "msg") != null;
    }

    public final int a(er erVar, boolean z, au auVar, String str, LinkedList<u> linkedList, HashMap<Long, com.tencent.mm.plugin.backup.bakoldlogic.b.i.a> hashMap, boolean z2, long j) {
        int i;
        if (bh.ov(auVar.field_content)) {
            i = 0;
        } else {
            i = auVar.field_content.getBytes().length;
        }
        String trim = aj.Xp(auVar.field_content).xyA.trim();
        if (!vp(trim)) {
            trim = auVar.field_content;
            if (!vp(trim)) {
                trim = a.a(auVar, erVar);
                if (auVar.field_isSend != 1 && d.eV(auVar.field_talker)) {
                    trim = auVar.field_talker + " :\n " + trim;
                }
            }
        }
        if (trim == null || !vp(trim)) {
            x.d("MicroMsg.BakOldItemEmoji", "emoji error" + trim);
            return -1;
        }
        bdo com_tencent_mm_protocal_c_bdo = new bdo();
        com_tencent_mm_protocal_c_bdo.UA(bh.az(trim, ""));
        erVar.vGZ = com_tencent_mm_protocal_c_bdo;
        EmojiInfo XU = b.aqJ().aqK().aqc().XU(auVar.field_imgPath);
        if (XU != null && XU.ckv()) {
            return i;
        }
        int a;
        if (XU != null) {
            String str2;
            if (TextUtils.isEmpty(XU.field_groupId)) {
                str2 = b.aqJ().aqK().Fp() + XU.Nr() + "_thumb";
                if (e.bN(str2) < 0) {
                    x.e("MicroMsg.BakOldItemEmoji", "thumbPath error");
                    return -1;
                }
                a = j.a(new j$a(str2, erVar, (LinkedList) linkedList, 4, false, "_thumb", false)) + i;
            } else {
                str2 = b.aqJ().aqK().Fp() + XU.field_groupId + File.separator + XU.Nr() + "_cover";
                if (e.bN(str2) < 0) {
                    x.e("MicroMsg.BakOldItemEmoji", "thumbPath error");
                    return -1;
                }
                a = j.a(new j$a(str2, erVar, (LinkedList) linkedList, 4, false, "_thumb", false)) + i;
            }
            if (TextUtils.isEmpty(XU.field_groupId) && XU.cks()) {
                a += j.a(new j$a(b.aqJ().aqK().Fp() + XU.Nr(), erVar, linkedList, false, false, b.aqJ().aqK().aqc().XU(aj.Xp(n.a(erVar.vGZ)).fqR)));
            } else if (XU.cku()) {
                a += j.a(new j$a(b.aqJ().aqK().Fp() + XU.field_groupId + File.separator + XU.Nr(), erVar, linkedList, false, false, b.aqJ().aqK().aqc().XU(aj.Xp(n.a(erVar.vGZ)).fqR)));
            }
        } else {
            a = i;
        }
        return a;
    }

    public final int a(String str, er erVar, au auVar) {
        boolean z = true;
        auVar.setContent(erVar.vGZ.wJF);
        String str2 = erVar.vGX.wJF;
        String str3 = erVar.vGY.wJF;
        if (!((String) b.aqJ().aqK().CU().get(2, null)).equals(str2)) {
            str3 = str2;
        }
        str2 = erVar.vGZ.wJF;
        Map y = bi.y(str2, "msg");
        al cj = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().cj(str2, str3);
        if (cj == null) {
            x.w("MicroMsg.BakOldItemEmoji", "EmojiMsgInfo is null");
            return -1;
        }
        EmojiInfo yc = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yc(cj.fqR);
        if (yc == null) {
            x.w("MicroMsg.BakOldItemEmoji", "EmojiInfo is null");
            return -1;
        }
        String vu;
        if (y.get(".msg.emoji.$androidmd5") == null) {
            vu = a.vu(cj.fqR);
            if (!bh.ov(vu)) {
                cj.fqR = vu;
                x.d("MicroMsg.BakOldItemEmoji", "convert ip to android md5 %s", vu);
            }
        }
        vu = (String) y.get(".msg.emoji.$productid");
        if (!TextUtils.isEmpty(vu)) {
            cj.fqV = vu;
        }
        auVar.setType(47);
        auVar.dT(cj.fqR);
        str3 = cj.hVz;
        if (yc.Yz() || yc.isGif()) {
            z = false;
        }
        auVar.setContent(aj.a(str3, 0, z, cj.fqR, false, ""));
        if (!yc.cks()) {
            str3 = b.aqJ().aqK().Fp();
            if (TextUtils.isEmpty(vu)) {
                com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(erVar, 4, str3 + cj.fqR + "_thumb");
                com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(erVar, 5, str3 + cj.fqR);
            } else {
                File file = new File(str3 + vu);
                if (!file.exists()) {
                    file.mkdirs();
                }
                com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(erVar, 4, str3 + vu + File.separator + cj.fqR + "_cover");
                com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(erVar, 5, str3 + vu + File.separator + cj.fqR);
            }
            com.tencent.mm.sdk.e.c emojiInfo = new EmojiInfo(str3);
            emojiInfo.field_md5 = cj.fqR;
            emojiInfo.field_svrid = cj.id;
            emojiInfo.field_catalog = EmojiInfo.xAe;
            emojiInfo.field_type = cj.xyG;
            emojiInfo.field_size = cj.xyH;
            emojiInfo.field_state = EmojiInfo.xAq;
            if (!TextUtils.isEmpty(vu)) {
                emojiInfo.field_groupId = vu;
            }
            if (!bh.ov(cj.xyP)) {
                emojiInfo.field_activityid = cj.xyP;
            }
            b.aqJ().aqK().aqc().a(emojiInfo);
        }
        x.d("MicroMsg.BakOldItemEmoji", "id " + d.i(auVar));
        return 0;
    }
}
