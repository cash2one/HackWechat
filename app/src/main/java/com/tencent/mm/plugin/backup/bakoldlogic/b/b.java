package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.mc;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.er;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.g$a;
import java.util.HashMap;
import java.util.LinkedList;

public final class b implements k {
    public final int a(er erVar, boolean z, au auVar, String str, LinkedList<u> linkedList, HashMap<Long, i$a> hashMap, boolean z2, long j) {
        String B;
        switch (auVar.getType()) {
            case 1048625:
                int length = bh.ov(auVar.field_content) ? 0 : auVar.field_content.getBytes().length;
                if (auVar.field_content == null) {
                    return -1;
                }
                String trim = aj.Xp(auVar.field_content).xyA.trim();
                if (!a.vp(trim)) {
                    trim = auVar.field_content;
                    if (!a.vp(trim)) {
                        x.e("MicroMsg.BakOldItemAppMsg", "get xml error " + trim);
                        return 0;
                    }
                }
                if (!bh.ov(trim)) {
                    bdo com_tencent_mm_protocal_c_bdo = new bdo();
                    com_tencent_mm_protocal_c_bdo.UA(bh.az(trim, ""));
                    erVar.vGZ = com_tencent_mm_protocal_c_bdo;
                    g$a fT = g$a.fT(trim);
                    String Fp = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aqJ().aqK().Fp();
                    B = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aqJ().aqK().aqb().B(auVar.field_imgPath, true);
                    String str2 = Fp + fT.hbd;
                    if (e.bN(B) <= 0) {
                        return -1;
                    }
                    length = (length + j.a(new j.a(B, erVar, linkedList, 6, false, "_thumb", false))) + j.a(new j.a(str2, erVar, linkedList, false, false, com.tencent.mm.plugin.backup.bakoldlogic.d.b.aqJ().aqK().aqc().XU(aj.Xp(n.a(erVar.vGZ)).fqR)));
                }
                return length;
            case 285212721:
                int length2 = bh.ov(auVar.field_content) ? 0 : auVar.field_content.getBytes().length;
                B = a.vr(auVar.field_content);
                if (bh.ov(B)) {
                    return 0;
                }
                bdo com_tencent_mm_protocal_c_bdo2 = new bdo();
                com_tencent_mm_protocal_c_bdo2.UA(bh.az(B, ""));
                erVar.vGZ = com_tencent_mm_protocal_c_bdo2;
                return length2;
            default:
                return b(erVar, false, auVar, str, linkedList, null, false, 0);
        }
    }

    private static int b(er erVar, boolean z, au auVar, String str, LinkedList<u> linkedList, HashMap<Long, i$a> hashMap, boolean z2, long j) {
        int i;
        g$a fT;
        if (bh.ov(auVar.field_content)) {
            i = 0;
        } else {
            i = auVar.field_content.getBytes().length;
        }
        String str2 = auVar.field_content;
        if (auVar.field_isSend != 1 && d.eV(auVar.field_talker)) {
            int indexOf = auVar.field_content.indexOf(58);
            if (indexOf != -1) {
                str2 = auVar.field_content.substring(indexOf + 1);
            }
        }
        str2 = bh.VH(str2);
        if (str2 != null) {
            fT = g$a.fT(str2);
        } else {
            fT = null;
        }
        if (fT == null) {
            x.e("MicroMsg.BakOldItemAppMsg", "content is null");
            return 0;
        }
        x.d("MicroMsg.BakOldItemAppMsg", "content type " + fT.type);
        String B = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aqJ().aqK().aqb().B(auVar.field_imgPath, true);
        if (e.bO(B)) {
            i += j.a(new j.a(B, erVar, linkedList, 6, z, "_thumb", z2));
        } else if (fT.type == 2) {
            return -1;
        }
        com.tencent.mm.pluginsdk.model.app.b Rz;
        switch (fT.type) {
            case 0:
            case 1:
            case 3:
            case 4:
            case 5:
            case 8:
                return i;
            case 2:
                if (bh.ov(fT.fny)) {
                    return i;
                }
                com.tencent.mm.pluginsdk.model.app.b Rz2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aqJ().aqK().aqd().Rz(fT.fny);
                if ((Rz2 == null || !Rz2.aOC()) && (auVar.field_isSend != 1 || Rz2 == null || !Rz2.field_isUpload)) {
                    return i;
                }
                B = Rz2.field_fileFullPath;
                if (!e.bO(B)) {
                    return i;
                }
                x.d("MicroMsg.BakOldItemAppMsg", "image " + B);
                return i + j.a(new j.a(B, erVar, linkedList, 8, z, z2, null));
            case 6:
                Rz = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aqJ().aqK().aqd().Rz(fT.fny);
                if ((Rz == null || !Rz.aOC()) && (auVar.field_isSend != 1 || Rz == null || !Rz.field_isUpload)) {
                    return i;
                }
                x.d("MicroMsg.BakOldItemAppMsg", "full path " + Rz.field_fileFullPath);
                if (!e.bO(Rz.field_fileFullPath)) {
                    return i;
                }
                if (z) {
                    return i + j.a(new j.a(Rz.field_fileFullPath, erVar, linkedList, 7, z, z2, null));
                }
                if (com.tencent.mm.plugin.backup.a.d.aoo() != 1 || ((long) (fT.hbb / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) < j || fT.filemd5 == null) {
                    return i + j.a(new j.a(Rz.field_fileFullPath, erVar, linkedList, 7, z, z2, null));
                }
                String str3;
                if (auVar.field_isSend == 1) {
                    str3 = auVar.field_talker;
                } else {
                    str3 = str;
                    str = auVar.field_talker;
                }
                u uVar = new u();
                i += j.a(new j.a(Rz.field_fileFullPath, erVar, linkedList, 7, z, true, uVar));
                if (hashMap == null) {
                    return i;
                }
                i$a com_tencent_mm_plugin_backup_bakoldlogic_b_i_a = new i$a();
                com_tencent_mm_plugin_backup_bakoldlogic_b_i_a.knb = uVar;
                com_tencent_mm_plugin_backup_bakoldlogic_b_i_a.fqR = fT.filemd5;
                com_tencent_mm_plugin_backup_bakoldlogic_b_i_a.knd = str + "_" + str3 + "_" + auVar.field_msgSvrId + "_backup";
                com_tencent_mm_plugin_backup_bakoldlogic_b_i_a.knc = auVar.field_msgSvrId;
                hashMap.put(Long.valueOf(auVar.field_msgSvrId), com_tencent_mm_plugin_backup_bakoldlogic_b_i_a);
                return i;
            case 7:
                Rz = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aqJ().aqK().aqd().Rz(fT.fny);
                if ((Rz == null || !Rz.aOC()) && (auVar.field_isSend != 1 || Rz == null || !Rz.field_isUpload)) {
                    return i;
                }
                x.d("MicroMsg.BakOldItemAppMsg", "full path " + Rz.field_fileFullPath);
                if (e.bO(Rz.field_fileFullPath)) {
                    return i + j.a(new j.a(Rz.field_fileFullPath, erVar, linkedList, 7, z, z2, null));
                }
                return i;
            case 19:
            case 24:
                com.tencent.mm.sdk.b.b mcVar = new mc();
                mcVar.fDK.fCs = fT.hbB;
                mcVar.fDK.fpG = auVar.field_msgId;
                com.tencent.mm.sdk.b.a.xef.m(mcVar);
                x.i("MicroMsg.BakOldItemAppMsg", "pathList:%s", new Object[]{mcVar.fDL.fDM});
                String[] split = mcVar.fDL.fDM.split(":");
                int i2 = i;
                i = 0;
                while (i < split.length) {
                    int a;
                    if (e.bO(split[i])) {
                        x.i("MicroMsg.BakOldItemAppMsg", "record file exit:%s, index:%d", new Object[]{split[i], Integer.valueOf(i)});
                        a = i2 + j.a(new j.a(split[i], erVar, linkedList, 7, z, "_fav." + i, z2));
                    } else {
                        a = i2;
                    }
                    i++;
                    i2 = a;
                }
                return i2;
            default:
                return i;
        }
    }

    public final int a(String str, er erVar, au auVar) {
        String str2 = erVar.vGX.wJF;
        String str3 = erVar.vGZ.wJF;
        if (str3 == null) {
            return 0;
        }
        int hO;
        auVar.setContent(str3);
        if (auVar.field_isSend != 1 && d.eV(str2)) {
            hO = d.hO(erVar.vGZ.wJF);
            if (hO != -1) {
                str3 = (erVar.vGZ.wJF + " ").substring(hO + 2).trim();
            }
        }
        String VH = bh.VH(str3);
        g$a fT = g$a.fT(VH);
        if (fT == null) {
            x.e("MicroMsg.BakOldItemAppMsg", "parse app message failed, insert failed");
            return 0;
        } else if (fT.type == MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
            auVar.setType(419430449);
            d.i(auVar);
            return 0;
        } else if (fT.type == 19 || fT.type == 24) {
            auVar.setType(l.d(fT));
            d.i(auVar);
            com.tencent.mm.sdk.b.b mcVar = new mc();
            mcVar.fDK.fCs = fT.hbB;
            mcVar.fDK.fpG = auVar.field_msgId;
            com.tencent.mm.sdk.b.a.xef.m(mcVar);
            x.i("MicroMsg.BakOldItemAppMsg", "pathList:%s", new Object[]{mcVar.fDL.fDM});
            String[] split = mcVar.fDL.fDM.split(":");
            for (r2 = 0; r2 < split.length; r2++) {
                VH = a.a(erVar, 7, "." + r2);
                if (!bh.ov(VH)) {
                    x.i("MicroMsg.BakOldItemAppMsg", "record media exit:%s, index:%d", new Object[]{VH, Integer.valueOf(r2)});
                    k.q(a.vA(VH), split[r2], false);
                }
            }
            return 0;
        } else {
            c fVar = new f();
            fVar.field_appId = fT.appId;
            com.tencent.mm.plugin.backup.bakoldlogic.d.c aqK = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aqJ().aqK();
            if (aqK.uin == 0) {
                throw new com.tencent.mm.z.b();
            }
            if (aqK.kpU.b(fVar, new String[0]) && fVar.field_appVersion < fT.fIm) {
                com.tencent.mm.plugin.backup.bakoldlogic.d.b.aqJ().aqL().e(1, fT.appId);
            }
            auVar.setType(l.d(fT));
            byte[] b = a.b(erVar, 6);
            if (b != null && auVar.field_msgId == 0) {
                str3 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aqJ().aqK().aqb().a(b, fT.type == 2, CompressFormat.PNG);
                x.d("MicroMsg.BakOldItemAppMsg", g.zh() + " thumbData MsgInfo path:" + str3);
                if (!bh.ov(str3)) {
                    auVar.dT(str3);
                    x.d("MicroMsg.BakOldItemAppMsg", "new thumbnail saved, path:" + str3);
                }
            }
            str2 = a.a(erVar, 8);
            r2 = a.c(erVar, 8);
            if (bh.ov(str2)) {
                str2 = a.a(erVar, 7);
                r2 = a.c(erVar, 7);
            }
            String vA = a.vA(str2);
            d.i(auVar);
            com.tencent.mm.y.g gVar = new com.tencent.mm.y.g();
            fT.a(gVar);
            gVar.field_msgId = auVar.field_msgId;
            com.tencent.mm.plugin.backup.bakoldlogic.d.c aqK2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aqJ().aqK();
            if (aqK2.uin == 0) {
                throw new com.tencent.mm.z.b();
            }
            aqK2.kpT.b(gVar);
            if (!bh.ov(str2)) {
                com.tencent.mm.plugin.messenger.foundation.a.a.c Fa = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aqJ().aqK().Fa();
                if (str.equals(erVar.vGX.wJF)) {
                    str2 = erVar.vGY.wJF;
                } else {
                    str2 = erVar.vGX.wJF;
                }
                cf F = Fa.F(str2, erVar.vHe);
                c Rz = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aqJ().aqK().aqd().Rz(fT.fny);
                if (Rz == null) {
                    x.i("MicroMsg.BakOldItemAppMsg", "recover AppAttachInfo is null.");
                    long j = F.field_msgId;
                    g$a fT2 = g$a.fT(VH);
                    if (fT2 != null) {
                        VH = l.ac(com.tencent.mm.compatible.util.e.gHs, fT2.title, fT2.hbc);
                        int i = fT2.sdkVer;
                        String str4 = fT2.appId;
                        String str5 = fT2.fny;
                        hO = fT2.hbb;
                        c bVar = new com.tencent.mm.pluginsdk.model.app.b();
                        bVar.field_fileFullPath = VH;
                        bVar.field_appId = str4;
                        bVar.field_sdkVer = (long) i;
                        bVar.field_mediaSvrId = str5;
                        bVar.field_totalLen = (long) hO;
                        bVar.field_status = 101;
                        bVar.field_isUpload = false;
                        bVar.field_createTime = bh.Wp();
                        bVar.field_lastModifyTime = bh.Wo();
                        bVar.field_msgInfoId = j;
                        bVar.field_netTimes = 0;
                        if (!com.tencent.mm.plugin.backup.bakoldlogic.d.b.aqJ().aqK().aqd().b(bVar)) {
                            x.e("MicroMsg.BakOldTempStorageLogic", "initDownloadAttach insert error, msgLocalId[%d]", new Object[]{Long.valueOf(j)});
                        }
                    }
                    Rz = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aqJ().aqK().aqd().Rz(fT.fny);
                    if (Rz == null) {
                        x.e("MicroMsg.BakOldItemAppMsg", "getAppAttachInfoStg().getByMediaId is null! attachid[%s]", new Object[]{fT.fny});
                        return 0;
                    } else if (!(fT.hbb == 0 || r2 == 0)) {
                        if (r2 >= fT.hbb) {
                            Rz.field_status = 199;
                        } else if (auVar.field_isSend == 1) {
                            Rz.field_status = 105;
                        } else {
                            Rz.field_status = 102;
                        }
                    }
                }
                long j2 = (long) r2;
                Rz.field_offset = j2;
                Rz.field_totalLen = j2;
                k.q(vA, Rz.field_fileFullPath, false);
                com.tencent.mm.plugin.backup.bakoldlogic.d.b.aqJ().aqK().aqd().c(Rz, new String[0]);
            }
            return 0;
        }
    }
}
