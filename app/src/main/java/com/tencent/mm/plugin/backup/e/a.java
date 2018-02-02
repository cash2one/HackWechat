package com.tencent.mm.plugin.backup.e;

import android.graphics.Bitmap.CompressFormat;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.mc;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.backup.g.c;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.er;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.l;
import com.tencent.mm.y.m;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class a implements l {

    private static class a {
        public static String kmR = "]]>";
        public static String kmS = "<msg>";
        public static String kmT = "</msg>";

        public static String vr(String str) {
            l vL = ((com.tencent.mm.plugin.biz.a.a) g.h(com.tencent.mm.plugin.biz.a.a.class)).vL(str);
            a aVar = new a(str);
            if (aVar.kmV) {
                String str2;
                String str3;
                String str4;
                b bVar = new b();
                List list = vL.hdX;
                Map hashMap = new HashMap();
                bVar.vs("msg");
                hashMap.put("appid", (String) aVar.kmU.get(".msg.appmsg.$appid"));
                hashMap.put("sdkver", (String) aVar.kmU.get(".msg.appmsg.$sdkver"));
                bVar.g("appmsg", hashMap);
                if (list == null) {
                    list = new LinkedList();
                }
                if (list.size() == 0) {
                    str2 = "";
                    str3 = "";
                    str4 = "";
                } else {
                    str3 = ((m) list.get(0)).title;
                    str4 = ((m) list.get(0)).url;
                    str2 = ((m) list.get(0)).hed;
                    str2 = str3;
                    str3 = str4;
                    str4 = ((m) list.get(0)).hef;
                }
                bVar.bG("title", str2);
                bVar.bG("des", (String) aVar.kmU.get(".msg.appmsg.des"));
                bVar.bG("action", (String) aVar.kmU.get(".msg.appmsg.action"));
                bVar.aS(DownloadSettingTable$Columns.TYPE, aVar.getInt(".msg.appmsg.type"));
                bVar.aS("showtype", aVar.getInt(".msg.appmsg.showtype"));
                bVar.bG("content", (String) aVar.kmU.get(".msg.appmsg.content"));
                bVar.bG(SlookSmartClipMetaTag.TAG_TYPE_URL, str3);
                bVar.bG("lowurl", (String) aVar.kmU.get(".msg.appmsg.lowurl"));
                bVar.vs("appattach");
                bVar.aS("totallen", aVar.getInt(".msg.appmsg.appattach.totallen"));
                bVar.bG("attachid", (String) aVar.kmU.get(".msg.appmsg.appattach.attachid"));
                bVar.bG("fileext", (String) aVar.kmU.get(".msg.appmsg.appattach.fileext"));
                bVar.vt("appattach");
                bVar.vs("mmreader");
                hashMap.put(DownloadSettingTable$Columns.TYPE, vL.type);
                hashMap.put("convMsgCount", list.size());
                bVar.g("category", hashMap);
                bVar.bG("name", vL.fGA);
                bVar.vs("topnew");
                bVar.bG("cover", (String) aVar.kmU.get(".msg.appmsg.mmreader.category.topnew.cover"));
                bVar.bG("width", (String) aVar.kmU.get(".msg.appmsg.mmreader.category.topnew.width"));
                bVar.bG("height", (String) aVar.kmU.get(".msg.appmsg.mmreader.category.topnew.height"));
                bVar.bG("digest", str4);
                bVar.vt("topnew");
                int i = 0;
                while (i < list.size()) {
                    bVar.vs("item");
                    if (list.get(i) != null) {
                        str3 = ((m) list.get(i)).title;
                        String str5 = ((m) list.get(i)).url;
                        String str6 = ((m) list.get(i)).heb;
                        String str7 = ((m) list.get(i)).hec;
                        String str8 = ((m) list.get(i)).time;
                        String str9 = ((m) list.get(i)).hed;
                        String str10 = ((m) list.get(i)).hee;
                        str2 = ((m) list.get(i)).hef;
                        bVar.bG("title", str3);
                        bVar.bG(SlookSmartClipMetaTag.TAG_TYPE_URL, str5);
                        bVar.bG("shorturl", str6);
                        bVar.bG("longurl", str7);
                        bVar.bG("pub_time", str8);
                        bVar.bG("cover", str9);
                        bVar.bG("tweetid", str10);
                        bVar.bG("digest", str2);
                        bVar.bG("fileid", (String) aVar.kmU.get((".msg.appmsg.mmreader.category.item" + (i == 0 ? "" : String.valueOf(i))) + ".fileid"));
                        bVar.vs("source");
                        bVar.vs("source");
                        bVar.bG("name", vL.fGA);
                        bVar.vt("source");
                        bVar.vt("source");
                        bVar.vt("item");
                    }
                    i++;
                }
                bVar.vt("category");
                bVar.vs(FFmpegMetadataRetriever.METADATA_KEY_PUBLISHER);
                bVar.bG("convName", vL.fGz);
                bVar.bG("nickname", vL.fGA);
                bVar.vt(FFmpegMetadataRetriever.METADATA_KEY_PUBLISHER);
                bVar.vt("mmreader");
                bVar.vt("appmsg");
                bVar.bG("fromusername", vL.fGz);
                bVar.aS("scene", aVar.getInt(".msg.scene"));
                bVar.vs("appinfo");
                bVar.bG("version", (String) aVar.kmU.get(".msg.appinfo.appname"));
                bVar.bG("appname", (String) aVar.kmU.get(".msg.appinfo.version"));
                bVar.vt("appinfo");
                bVar.bG("commenturl", vL.gjD);
                bVar.vt("msg");
                x.d("MicroMsg.AppmsgConvert", "xml " + bVar.kmW.toString());
                return bVar.kmW.toString();
            }
            x.e("MicroMsg.AppmsgConvert", "buffer error");
            return "";
        }
    }

    public final int a(er erVar, boolean z, au auVar, String str, LinkedList<u> linkedList, HashMap<Long, h$a> hashMap, boolean z2, long j) {
        int length;
        String trim;
        bdo com_tencent_mm_protocal_c_bdo;
        switch (auVar.getType()) {
            case 1048625:
                length = bh.ov(auVar.field_content) ? 0 : auVar.field_content.getBytes().length;
                if (auVar.field_content == null) {
                    return -1;
                }
                trim = aj.Xp(auVar.field_content).xyA.trim();
                if (!com.tencent.mm.plugin.backup.a.g.vp(trim)) {
                    trim = auVar.field_content;
                    if (!com.tencent.mm.plugin.backup.a.g.vp(trim)) {
                        x.e("MicroMsg.BackupItemAppMsg", "get xml error " + trim);
                        return 0;
                    }
                }
                if (bh.ov(trim)) {
                    return length;
                }
                com_tencent_mm_protocal_c_bdo = new bdo();
                com_tencent_mm_protocal_c_bdo.UA(bh.az(trim, ""));
                erVar.vGZ = com_tencent_mm_protocal_c_bdo;
                com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(trim);
                String Fp = d.aqe().aqf().Fp();
                String B = d.aqe().aqf().aqb().B(auVar.field_imgPath, true);
                String str2 = Fp + fT.hbd;
                if (e.bN(B) <= 0) {
                    return -1;
                }
                return (length + i.a(new com.tencent.mm.plugin.backup.e.i.a(B, erVar, linkedList, 6, z, "_thumb", z2))) + i.a(new com.tencent.mm.plugin.backup.e.i.a(str2, erVar, linkedList, 5, z, z2, null));
            case 285212721:
            case 486539313:
                length = bh.ov(auVar.field_content) ? 0 : auVar.field_content.getBytes().length;
                if (z) {
                    return length;
                }
                trim = a.vr(auVar.field_content);
                if (bh.ov(trim)) {
                    return 0;
                }
                com_tencent_mm_protocal_c_bdo = new bdo();
                com_tencent_mm_protocal_c_bdo.UA(bh.az(trim, ""));
                erVar.vGZ = com_tencent_mm_protocal_c_bdo;
                return length;
            default:
                return b(erVar, z, auVar, str, linkedList, hashMap, z2, j);
        }
    }

    private static int b(er erVar, boolean z, au auVar, String str, LinkedList<u> linkedList, HashMap<Long, h$a> hashMap, boolean z2, long j) {
        int i;
        com.tencent.mm.y.g.a fT;
        if (bh.ov(auVar.field_content)) {
            i = 0;
        } else {
            i = auVar.field_content.getBytes().length;
        }
        String str2 = auVar.field_content;
        if (auVar.field_isSend != 1 && c.eV(auVar.field_talker)) {
            int indexOf = auVar.field_content.indexOf(58);
            if (indexOf != -1) {
                str2 = auVar.field_content.substring(indexOf + 1);
            }
        }
        str2 = bh.VH(str2);
        if (str2 != null) {
            fT = com.tencent.mm.y.g.a.fT(str2);
        } else {
            fT = null;
        }
        if (fT == null) {
            x.e("MicroMsg.BackupItemAppMsg", "content is null");
            return 0;
        }
        x.d("MicroMsg.BackupItemAppMsg", "content type " + fT.type);
        String B = d.aqe().aqf().aqb().B(auVar.field_imgPath, true);
        if (e.bO(B)) {
            i += i.a(new com.tencent.mm.plugin.backup.e.i.a(B, erVar, linkedList, 6, z, "_thumb", z2));
        } else if (fT.type == 2) {
            return -1;
        }
        b Rz;
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
                b Rz2 = d.aqe().aqf().aqd().Rz(fT.fny);
                if ((Rz2 == null || !Rz2.aOC()) && (auVar.field_isSend != 1 || Rz2 == null || !Rz2.field_isUpload)) {
                    return i;
                }
                B = Rz2.field_fileFullPath;
                if (!e.bO(B)) {
                    return i;
                }
                x.d("MicroMsg.BackupItemAppMsg", "image " + B);
                return i + i.a(new com.tencent.mm.plugin.backup.e.i.a(B, erVar, linkedList, 8, z, z2, null));
            case 6:
                Rz = d.aqe().aqf().aqd().Rz(fT.fny);
                if ((Rz == null || !Rz.aOC()) && (auVar.field_isSend != 1 || Rz == null || !Rz.field_isUpload)) {
                    return i;
                }
                x.d("MicroMsg.BackupItemAppMsg", "full path " + Rz.field_fileFullPath);
                if (!e.bO(Rz.field_fileFullPath)) {
                    return i;
                }
                if (z) {
                    return i + i.a(new com.tencent.mm.plugin.backup.e.i.a(Rz.field_fileFullPath, erVar, linkedList, 7, z, z2, null));
                }
                if (com.tencent.mm.plugin.backup.a.d.aoo() != 1 || ((long) (fT.hbb / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) < j || fT.filemd5 == null) {
                    return i + i.a(new com.tencent.mm.plugin.backup.e.i.a(Rz.field_fileFullPath, erVar, linkedList, 7, z, z2, null));
                }
                String str3;
                if (auVar.field_isSend == 1) {
                    str3 = auVar.field_talker;
                } else {
                    str3 = str;
                    str = auVar.field_talker;
                }
                u uVar = new u();
                i += i.a(new com.tencent.mm.plugin.backup.e.i.a(Rz.field_fileFullPath, erVar, linkedList, 7, z, true, uVar));
                if (hashMap == null) {
                    return i;
                }
                h$a com_tencent_mm_plugin_backup_e_h_a = new h$a();
                com_tencent_mm_plugin_backup_e_h_a.knb = uVar;
                com_tencent_mm_plugin_backup_e_h_a.fqR = fT.filemd5;
                com_tencent_mm_plugin_backup_e_h_a.knd = str + "_" + str3 + "_" + auVar.field_msgSvrId + "_backup";
                com_tencent_mm_plugin_backup_e_h_a.knc = auVar.field_msgSvrId;
                hashMap.put(Long.valueOf(auVar.field_msgSvrId), com_tencent_mm_plugin_backup_e_h_a);
                return i;
            case 7:
                Rz = d.aqe().aqf().aqd().Rz(fT.fny);
                if ((Rz == null || !Rz.aOC()) && (auVar.field_isSend != 1 || Rz == null || !Rz.field_isUpload)) {
                    return i;
                }
                x.d("MicroMsg.BackupItemAppMsg", "full path " + Rz.field_fileFullPath);
                if (e.bO(Rz.field_fileFullPath)) {
                    return i + i.a(new com.tencent.mm.plugin.backup.e.i.a(Rz.field_fileFullPath, erVar, linkedList, 7, z, z2, null));
                }
                return i;
            case 19:
            case 24:
                com.tencent.mm.sdk.b.b mcVar = new mc();
                mcVar.fDK.fCs = fT.hbB;
                mcVar.fDK.fpG = auVar.field_msgId;
                com.tencent.mm.sdk.b.a.xef.m(mcVar);
                x.i("MicroMsg.BackupItemAppMsg", "pathList:%s", new Object[]{mcVar.fDL.fDM});
                String[] split = mcVar.fDL.fDM.split(":");
                int i2 = i;
                i = 0;
                while (i < split.length) {
                    int a;
                    if (e.bO(split[i])) {
                        x.i("MicroMsg.BackupItemAppMsg", "record file exit:%s, index:%d", new Object[]{split[i], Integer.valueOf(i)});
                        a = i2 + i.a(new com.tencent.mm.plugin.backup.e.i.a(split[i], erVar, linkedList, 7, z, "_fav." + i, z2));
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
        if (auVar.field_isSend != 1 && c.eV(str2)) {
            hO = c.hO(erVar.vGZ.wJF);
            if (hO != -1) {
                str3 = (erVar.vGZ.wJF + " ").substring(hO + 2).trim();
            }
        }
        String VH = bh.VH(str3);
        com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(VH);
        if (fT == null) {
            x.e("MicroMsg.BackupItemAppMsg", "parse app message failed, insert failed");
            return 0;
        } else if (fT.type == MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
            auVar.setType(419430449);
            c.i(auVar);
            return 0;
        } else if (fT.type == 19 || fT.type == 24) {
            auVar.setType(com.tencent.mm.pluginsdk.model.app.l.d(fT));
            c.i(auVar);
            com.tencent.mm.sdk.b.b mcVar = new mc();
            mcVar.fDK.fCs = fT.hbB;
            mcVar.fDK.fpG = auVar.field_msgId;
            com.tencent.mm.sdk.b.a.xef.m(mcVar);
            x.i("MicroMsg.BackupItemAppMsg", "pathList:%s", new Object[]{mcVar.fDL.fDM});
            String[] split = mcVar.fDL.fDM.split(":");
            for (r2 = 0; r2 < split.length; r2++) {
                VH = com.tencent.mm.plugin.backup.a.g.a(erVar, 7, "." + r2);
                if (!bh.ov(VH)) {
                    x.i("MicroMsg.BackupItemAppMsg", "record media exit:%s, index:%d", new Object[]{VH, Integer.valueOf(r2)});
                    k.q(com.tencent.mm.plugin.backup.a.g.vm(VH) + VH, split[r2], false);
                }
            }
            return 0;
        } else {
            com.tencent.mm.sdk.e.c fVar = new f();
            fVar.field_appId = fT.appId;
            com.tencent.mm.plugin.backup.g.b aqf = d.aqe().aqf();
            if (aqf.uin == 0) {
                throw new com.tencent.mm.z.b();
            }
            if (aqf.kpU.b(fVar, new String[0]) && fVar.field_appVersion < fT.fIm) {
                d.aqe().aqg().e(1, fT.appId);
            }
            auVar.setType(com.tencent.mm.pluginsdk.model.app.l.d(fT));
            byte[] b = com.tencent.mm.plugin.backup.a.g.b(erVar, 6);
            if (b != null && auVar.field_msgId == 0) {
                str3 = d.aqe().aqf().aqb().a(b, fT.type == 2, CompressFormat.PNG);
                x.d("MicroMsg.BackupItemAppMsg", com.tencent.mm.compatible.util.g.zh() + " thumbData MsgInfo path:" + str3);
                if (!bh.ov(str3)) {
                    auVar.dT(str3);
                    x.d("MicroMsg.BackupItemAppMsg", "new thumbnail saved, path:" + str3);
                }
            }
            str2 = com.tencent.mm.plugin.backup.a.g.a(erVar, 8);
            r2 = com.tencent.mm.plugin.backup.a.g.c(erVar, 8);
            if (bh.ov(str2)) {
                str2 = com.tencent.mm.plugin.backup.a.g.a(erVar, 7);
                r2 = com.tencent.mm.plugin.backup.a.g.c(erVar, 7);
            }
            String str4 = com.tencent.mm.plugin.backup.a.g.vm(str2) + str2;
            c.i(auVar);
            com.tencent.mm.sdk.e.c gVar = new com.tencent.mm.y.g();
            fT.a(gVar);
            gVar.field_msgId = auVar.field_msgId;
            com.tencent.mm.plugin.backup.g.b aqf2 = d.aqe().aqf();
            if (aqf2.uin == 0) {
                throw new com.tencent.mm.z.b();
            }
            aqf2.kpT.b(gVar);
            if (!bh.ov(str2)) {
                com.tencent.mm.plugin.messenger.foundation.a.a.c Fa = d.aqe().aqf().Fa();
                if (str.equals(erVar.vGX.wJF)) {
                    str2 = erVar.vGY.wJF;
                } else {
                    str2 = erVar.vGX.wJF;
                }
                cf F = Fa.F(str2, erVar.vHe);
                com.tencent.mm.sdk.e.c Rz = d.aqe().aqf().aqd().Rz(fT.fny);
                if (Rz == null) {
                    x.i("MicroMsg.BackupItemAppMsg", "recover AppAttachInfo is null.");
                    long j = F.field_msgId;
                    com.tencent.mm.y.g.a fT2 = com.tencent.mm.y.g.a.fT(VH);
                    if (fT2 != null) {
                        VH = com.tencent.mm.pluginsdk.model.app.l.ac(com.tencent.mm.compatible.util.e.gHs, fT2.title, fT2.hbc);
                        int i = fT2.sdkVer;
                        String str5 = fT2.appId;
                        String str6 = fT2.fny;
                        hO = fT2.hbb;
                        com.tencent.mm.sdk.e.c bVar = new b();
                        bVar.field_fileFullPath = VH;
                        bVar.field_appId = str5;
                        bVar.field_sdkVer = (long) i;
                        bVar.field_mediaSvrId = str6;
                        bVar.field_totalLen = (long) hO;
                        bVar.field_status = 101;
                        bVar.field_isUpload = false;
                        bVar.field_createTime = bh.Wp();
                        bVar.field_lastModifyTime = bh.Wo();
                        bVar.field_msgInfoId = j;
                        bVar.field_netTimes = 0;
                        if (!d.aqe().aqf().aqd().b(bVar)) {
                            x.e("MicroMsg.BackupStorageLogic", "initDownloadAttach insert error, msgLocalId[%d]", new Object[]{Long.valueOf(j)});
                        }
                    }
                    Rz = d.aqe().aqf().aqd().Rz(fT.fny);
                    if (Rz == null) {
                        x.e("MicroMsg.BackupItemAppMsg", "getAppAttachInfoStg().getByMediaId is null! attachid[%s]", new Object[]{fT.fny});
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
                k.q(str4, Rz.field_fileFullPath, false);
                d.aqe().aqf().aqd().c(Rz, new String[0]);
            }
            return 0;
        }
    }
}
