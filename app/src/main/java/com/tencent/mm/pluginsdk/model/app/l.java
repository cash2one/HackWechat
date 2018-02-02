package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.ae.f;
import com.tencent.mm.ae.k;
import com.tencent.mm.aq.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.rw;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXDesignerSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiPageSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.q;
import java.io.File;

public final class l {
    private static ab vex;

    public static boolean RG(String str) {
        if (bh.ov(str) || str.equals("0:0")) {
            return false;
        }
        return true;
    }

    public static void fq(long j) {
        c fo = an.aqd().fo(j);
        if (fo != null) {
            boolean deleteFile = b.deleteFile(fo.field_fileFullPath);
            boolean a = an.aqd().a(fo, new String[]{"msgInfoId"});
            x.i("MicroMsg.AppMsgLogic", "summerapp deleteAttachInfoAndFile deleteFile[%b] deleteInfo[%b] msgInfoId[%d] mediaSvrId[%s] path[%s] stack[%s]", Boolean.valueOf(deleteFile), Boolean.valueOf(a), Long.valueOf(fo.field_msgInfoId), fo.field_mediaSvrId, fo.field_fileFullPath, bh.cgy());
        }
    }

    public static void fr(long j) {
        c aqd = an.aqd();
        aqd.gJP.fx("appattach", " update appattach set status = 198" + " , lastModifyTime = " + bh.Wo() + " where rowid = " + j);
        aqd.doNotify();
        c bVar = new b();
        an.aqd().b(j, bVar);
        if (bVar.field_msgInfoId > 0) {
            ar.Hg();
            au dH = com.tencent.mm.z.c.Fa().dH(bVar.field_msgInfoId);
            if (dH.field_msgId == bVar.field_msgInfoId) {
                dH.eQ(5);
                ar.Hg();
                com.tencent.mm.z.c.Fa().a(dH.field_msgId, dH);
            }
        }
    }

    public static int RH(String str) {
        a fT = a.fT(str);
        if (fT == null) {
            return -1;
        }
        if (!RG(fT.fny)) {
            return -1;
        }
        b bVar = new b();
        long j = bh.getLong(fT.fny, -1);
        if (j != -1) {
            an.aqd().b(j, bVar);
            if (bVar.xjy != j) {
                bVar = an.aqd().Rz(fT.fny);
                if (bVar == null || !bVar.field_mediaSvrId.equals(fT.fny)) {
                    return -1;
                }
            }
        }
        bVar = an.aqd().Rz(fT.fny);
        if (bVar == null || !bVar.field_mediaSvrId.equals(fT.fny)) {
            return -1;
        }
        if (bVar.field_totalLen == 0) {
            return -1;
        }
        return (int) ((bVar.field_offset * 100) / bVar.field_totalLen);
    }

    public static String c(long j, String str, String str2) {
        x.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach msgLocalId[%d], msgXml[%s], downloadPath[%s]", Long.valueOf(j), str, str2);
        a fT = a.fT(str);
        if (fT == null) {
            return null;
        }
        String str3;
        if (str2 != null) {
            str3 = str2;
        } else {
            str3 = ac(e.gHs, fT.title, fT.hbc);
        }
        if (bh.ov(fT.fny) && !bh.ov(fT.hbi)) {
            fT.fny = fT.hbi.hashCode();
        }
        int i = fT.sdkVer;
        String str4 = fT.appId;
        String str5 = fT.fny;
        int i2 = fT.hbb;
        int i3 = fT.type;
        String str6 = fT.hbp;
        return a(str3, j, i, str4, str5, i2, i3, fT.hbf);
    }

    public static void a(au auVar, final a aVar) {
        a fT = a.fT(auVar.field_content);
        if (fT == null) {
            x.e("MicroMsg.AppMsgLogic", "parse msgContent error, %s", auVar.field_content);
            return;
        }
        if (bh.ov(fT.fny) && !bh.ov(fT.hbi)) {
            x.e("MicroMsg.AppMsgLogic", "msgContent format error, %s", auVar.field_content);
            fT.fny = fT.hbi.hashCode();
        }
        String str = fT.fny;
        if (!a(auVar, af(str, auVar.field_msgId)) && e(str, auVar)) {
            vex = new ab(auVar.field_msgId, str, new f() {
                public final void a(int i, int i2, k kVar) {
                    if (aVar != null) {
                        aVar.ev(i, i2);
                    }
                }
            });
            ar.CG().a(vex, 0);
        }
    }

    public static boolean a(au auVar, b bVar) {
        if (bVar == null || !new File(bVar.field_fileFullPath).exists()) {
            return false;
        }
        if (bVar.aOC() || (auVar.field_isSend == 1 && bVar.field_isUpload)) {
            return true;
        }
        return false;
    }

    public static boolean e(String str, au auVar) {
        if (auVar == null) {
            return false;
        }
        boolean z = true;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        b af = af(str, auVar.field_msgId);
        a fT = a.fT(auVar.field_content);
        if (af != null) {
            String str7 = af.field_fileFullPath;
        }
        if (fT != null) {
            str2 = t.ou(fT.title);
            str3 = t.ou(fT.hbc).toLowerCase();
            str4 = t.ou(fT.filemd5);
            str5 = t.ou(fT.fzO);
            str6 = t.ou(fT.hbp);
        }
        String str8;
        if (af == null) {
            c(auVar.field_msgId, auVar.field_content, null);
            af = af(str, auVar.field_msgId);
            if (af != null) {
                str8 = "MicroMsg.AppMsgLogic";
                String str9 = "summerbig tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]";
                Object[] objArr = new Object[8];
                objArr[0] = Long.valueOf(af.xjy);
                objArr[1] = Long.valueOf(af.field_totalLen);
                objArr[2] = af.field_fileFullPath;
                objArr[3] = Long.valueOf(af.field_type);
                objArr[4] = af.field_mediaId;
                objArr[5] = Long.valueOf(af.field_msgInfoId);
                objArr[6] = Boolean.valueOf(af.field_isUpload);
                objArr[7] = Integer.valueOf(af.field_signature == null ? -1 : af.field_signature.length());
                x.i(str8, str9, objArr);
                if (fT != null && (fT.hbf != 0 || fT.hbb > 26214400)) {
                    boolean z2;
                    if (t.ov(af.field_signature)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    z = z2;
                }
            }
        } else {
            File file = new File(af.field_fileFullPath);
            if (af.field_status == 199 && !file.exists()) {
                x.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist but file not!");
                c(auVar.field_msgId, auVar.field_content, null);
            }
            String str10 = "MicroMsg.AppMsgLogic";
            str8 = "summerbig tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]";
            Object[] objArr2 = new Object[10];
            objArr2[0] = Long.valueOf(af.xjy);
            objArr2[1] = Long.valueOf(af.field_totalLen);
            objArr2[2] = af.field_fileFullPath;
            objArr2[3] = Long.valueOf(af.field_type);
            objArr2[4] = af.field_mediaId;
            objArr2[5] = Long.valueOf(af.field_msgInfoId);
            objArr2[6] = Boolean.valueOf(af.field_isUpload);
            objArr2[7] = Boolean.valueOf(file.exists());
            objArr2[8] = Long.valueOf(af.field_status);
            objArr2[9] = Integer.valueOf(af.field_signature == null ? -1 : af.field_signature.length());
            x.i(str10, str8, objArr2);
        }
        if (!z) {
            ar.CG().a(new y(af, str6, str4, str2, str3, str5), 0);
        }
        return z;
    }

    public static b af(String str, long j) {
        b RI = RI(str);
        if (RI == null) {
            RI = an.aqd().fo(j);
        }
        if (RI != null) {
            x.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo info[%s], rowid[%d], isUpload[%b], fullpath[%s], totallen[%d], offset[%d], mediaSvrId[%s], mediaid[%s], msgid[%d], type[%d], stack[%s]", RI, Long.valueOf(RI.xjy), Boolean.valueOf(RI.field_isUpload), RI.field_fileFullPath, Long.valueOf(RI.field_totalLen), Long.valueOf(RI.field_offset), RI.field_mediaSvrId, RI.field_mediaId, Long.valueOf(RI.field_msgInfoId), Long.valueOf(RI.field_type), t.Ws());
        } else {
            x.w("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo is null stack[%s]", t.Ws());
        }
        return RI;
    }

    public static String a(String str, long j, int i, String str2, String str3, int i2, int i3, int i4) {
        c bVar = new b();
        bVar.field_fileFullPath = str;
        bVar.field_appId = str2;
        bVar.field_sdkVer = (long) i;
        bVar.field_mediaSvrId = str3;
        bVar.field_totalLen = (long) i2;
        bVar.field_status = 101;
        bVar.field_isUpload = false;
        bVar.field_createTime = bh.Wp();
        bVar.field_lastModifyTime = bh.Wo();
        bVar.field_msgInfoId = j;
        bVar.field_netTimes = 0;
        bVar.field_type = (long) i3;
        x.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach ret[%b], rowid[%d], field_totalLen[%d], type[%d], isLargeFile[%d], destFile[%s], stack[%s]", Boolean.valueOf(an.aqd().b(bVar)), Long.valueOf(bVar.xjy), Long.valueOf(bVar.field_totalLen), Long.valueOf(bVar.field_type), Integer.valueOf(i4), str, bh.cgy());
        return str3;
    }

    public static b a(String str, long j, int i, String str2, String str3, int i2) {
        b bVar = new b();
        bVar.field_fileFullPath = str;
        bVar.field_appId = str2;
        bVar.field_sdkVer = (long) i;
        bVar.field_mediaSvrId = str3;
        bVar.field_totalLen = (long) i2;
        bVar.field_status = 101;
        bVar.field_isUpload = false;
        bVar.field_createTime = bh.Wp();
        bVar.field_lastModifyTime = bh.Wo();
        bVar.field_msgInfoId = j;
        bVar.field_netTimes = 0;
        return bVar;
    }

    public static b a(String str, a aVar, String str2) {
        x.i("MicroMsg.AppMsgLogic", g.zh() + " summerbig buildUploadAttachInfo clientAppDataId:" + str + " attach file :" + str2);
        if (str2.replace("//", "/").startsWith(e.gZJ)) {
            x.e("MicroMsg.AppMsgLogic", "summerbig Error attach path:%s", str2.replace("//", "/"));
            return null;
        }
        c bVar = new b();
        bVar.field_totalLen = (long) aVar.hbb;
        bVar.field_fileFullPath = str2;
        bVar.field_sdkVer = (long) aVar.sdkVer;
        bVar.field_appId = aVar.appId;
        bVar.field_clientAppDataId = str;
        bVar.field_type = (long) aVar.type;
        bVar.field_status = 200;
        bVar.field_isUpload = true;
        bVar.field_createTime = bh.Wp();
        bVar.field_lastModifyTime = bh.Wo();
        bVar.field_mediaSvrId = bh.Wp();
        an.aqd().b(bVar);
        x.d("MicroMsg.AppMsgLogic", g.zh() + " summerbig buildUploadAttachInfo file:" + bVar.field_fileFullPath + " rowid:" + bVar.xjy + " clientAppDataId:" + bVar.field_clientAppDataId);
        if (bVar.xjy >= 0) {
            return bVar;
        }
        x.e("MicroMsg.AppMsgLogic", g.zh() + " summerbig uploadAttach insert appattach info failed :" + bVar.xjy);
        return null;
    }

    public static int a(long j, String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        ar.Hg();
        au dH = com.tencent.mm.z.c.Fa().dH(j);
        if (dH.field_msgId != j) {
            x.e("MicroMsg.AppMsgLogic", g.zh() + " getmsgFailed id:" + j);
            return 0 - g.getLine();
        }
        a fT = a.fT(dH.field_content);
        if (fT == null) {
            x.e("MicroMsg.AppMsgLogic", g.zh() + " getmsgFailed id:" + j);
            return 0 - g.getLine();
        }
        fT.fny = str;
        dH.setContent(a.a(fT, fT.fny, com_tencent_mm_modelcdntran_keep_SceneResult));
        ar.Hg();
        com.tencent.mm.z.c.Fa().a(dH.field_msgId, dH);
        c fp = an.bYS().fp(j);
        if (fp != null) {
            fp.field_xml = dH.field_content;
            an.bYS().c(fp, new String[]{"msgId"});
        }
        c fo = an.aqd().fo(j);
        fo.field_mediaSvrId = str;
        fo.field_offset = fo.field_totalLen;
        an.aqd().c(fo, new String[0]);
        return 0;
    }

    public static int a(a aVar, String str, String str2, String str3, String str4, byte[] bArr) {
        return a(aVar, str, str2, str3, str4, bArr, null);
    }

    public static int a(a aVar, String str, String str2, String str3, String str4, byte[] bArr, String str5) {
        return a(aVar, str, str2, str3, str4, bArr, str5, "");
    }

    public static String ac(String str, String str2, String str3) {
        String str4;
        if (bh.ov(str2)) {
            str4 = str + "da_" + bh.Wp();
        } else {
            str4 = str + str2;
            if (com.tencent.mm.a.e.bO(str4)) {
                File file = new File(str + "/" + bh.Wp());
                if (!(file.exists() && file.isDirectory())) {
                    file.mkdirs();
                }
                str4 = file.getAbsolutePath() + "/" + str2;
            }
        }
        if (bh.ov(str3) || str4.endsWith(str3)) {
            return str4;
        }
        return str4 + "." + str3;
    }

    public static int a(a aVar, String str, String str2, String str3, String str4, byte[] bArr, String str5, String str6) {
        x.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg attachFilePath[%s], content[%s]", str4, aVar);
        c cVar = null;
        String str7 = System.currentTimeMillis();
        if (!bh.ov(str4)) {
            cVar = a(str7, aVar, str4);
            if (cVar == null) {
                return 0 - g.getLine();
            }
        }
        cf auVar = new au();
        if (bArr != null && bArr.length > 0) {
            if (aVar.type == 33 || aVar.type == 36) {
                str7 = o.Pw().a(bArr, CompressFormat.JPEG, (int) (d.ceP().density * 215.0f), (int) (d.ceP().density * 215.0f));
            } else {
                str7 = o.Pw().a(6, bArr, aVar.type == 2, CompressFormat.PNG);
            }
            x.d("MicroMsg.AppMsgLogic", g.zh() + " thumbData MsgInfo path:" + str7);
            if (!bh.ov(str7)) {
                auVar.dT(str7);
                x.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path" + str7);
            }
        }
        if (cVar != null) {
            aVar.fny = cVar.xjy;
        }
        auVar.setContent(a.a(aVar, null, null));
        auVar.eQ(1);
        auVar.dS(str3);
        auVar.aq(ba.hR(str3));
        auVar.eR(1);
        auVar.setType(d(aVar));
        if (com.tencent.mm.ag.f.eE(auVar.field_talker)) {
            auVar.dY(com.tencent.mm.ag.a.e.HD());
            x.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", auVar.gjF);
        }
        ar.Hg();
        long Q = com.tencent.mm.z.c.Fa().Q(auVar);
        x.d("MicroMsg.AppMsgLogic", g.zh() + " msginfo insert id: " + Q);
        if (Q < 0) {
            x.e("MicroMsg.AppMsgLogic", g.zh() + "insert msg failed :" + Q);
            return 0 - g.getLine();
        }
        x.i("MicroMsg.AppMsgLogic", g.getLine() + " new msg inserted to db , local id = " + Q);
        auVar.ao(Q);
        c gVar = new com.tencent.mm.y.g();
        gVar.field_xml = auVar.field_content;
        gVar.field_appId = str;
        gVar.field_title = aVar.title;
        gVar.field_type = aVar.type;
        gVar.field_description = aVar.description;
        gVar.field_msgId = Q;
        gVar.field_source = str2;
        an.bYS().b(gVar);
        String str8 = "MicroMsg.AppMsgLogic";
        String str9 = "summerbig sendAppMsg attInfo is null[%b]";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(cVar == null);
        x.i(str8, str9, objArr);
        if (cVar != null) {
            cVar.field_msgInfoId = Q;
            cVar.field_status = 101;
            an.aqd().c(cVar, new String[0]);
            if (aVar.type == 2 || !bh.ov(str5)) {
                an.bYU().t(Q, str5);
            }
            an.bYU().run();
        } else {
            an.bYU();
            am.a.d(Q, str5, str6);
        }
        return 0;
    }

    public static int a(WXMediaMessage wXMediaMessage, String str, String str2, String str3, int i, String str4) {
        return a(wXMediaMessage, str, str2, str3, i, str4, null);
    }

    public static int a(WXMediaMessage wXMediaMessage, String str, String str2, String str3, int i, String str4, String str5) {
        a aVar = new a();
        aVar.appId = str;
        aVar.appName = str2;
        aVar.hbe = i;
        return a(aVar, wXMediaMessage, str3, str4, str5);
    }

    public static int a(a aVar, WXMediaMessage wXMediaMessage, String str) {
        return a(aVar, wXMediaMessage, str, null, null);
    }

    private static int a(a aVar, WXMediaMessage wXMediaMessage, String str, String str2, String str3) {
        c cVar;
        c a;
        String b = b(aVar, wXMediaMessage, str2);
        x.d("MicroMsg.AppMsgLogic", g.zh() + "summerbig content url:" + aVar.url + " lowUrl:" + aVar.hba + " attachlen:" + aVar.hbb + " attachid:" + aVar.fny + " attach file:" + b);
        String str4 = System.currentTimeMillis();
        if (bh.ov(b)) {
            cVar = null;
        } else {
            a = a(str4, aVar, b);
            if (a == null) {
                return 0 - g.getLine();
            }
            Options UL = d.UL(b);
            if (UL != null) {
                aVar.hbo = UL.outWidth;
                aVar.hbn = UL.outHeight;
            }
            cVar = a;
        }
        cf auVar = new au();
        if (wXMediaMessage.thumbData != null && wXMediaMessage.thumbData.length > 0) {
            String f;
            if (wXMediaMessage.thumbData.length <= WXMediaMessage.THUMB_LENGTH_LIMIT || wXMediaMessage.getType() == 36) {
                f = o.Pw().f(6, wXMediaMessage.thumbData);
            } else {
                f = o.Pw().a(6, wXMediaMessage.thumbData, aVar.type == 2, CompressFormat.JPEG);
            }
            x.d("MicroMsg.AppMsgLogic", g.zh() + " summerbig thumbData MsgInfo path:" + f);
            if (!bh.ov(f)) {
                auVar.dT(f);
            }
        }
        if (cVar != null) {
            aVar.fny = cVar.xjy;
        }
        for (String f2 : bh.F(str.split(","))) {
            aVar.hbd = str2;
            auVar.setContent(a.a(aVar, null, null));
            auVar.eQ(1);
            auVar.dS(f2);
            auVar.aq(ba.hR(f2));
            auVar.eR(1);
            auVar.setType(d(aVar));
            if (com.tencent.mm.ag.f.eE(auVar.field_talker)) {
                auVar.dY(com.tencent.mm.ag.a.e.HD());
            }
            ar.Hg();
            long Q = com.tencent.mm.z.c.Fa().Q(auVar);
            if (Q < 0) {
                x.e("MicroMsg.AppMsgLogic", g.zh() + " summerbig insert msg failed :" + Q);
                return 0 - g.getLine();
            }
            x.i("MicroMsg.AppMsgLogic", g.getLine() + " summerbig new msg inserted to db , local id = " + Q);
            auVar.ao(Q);
            a = new com.tencent.mm.y.g();
            a.field_xml = auVar.field_content;
            a.field_title = wXMediaMessage.title;
            a.field_type = wXMediaMessage.mediaObject.type();
            a.field_description = wXMediaMessage.description;
            a.field_msgId = Q;
            a.field_source = aVar.appName;
            an.bYS().b(a);
            if (cVar != null) {
                cVar.field_msgInfoId = Q;
                cVar.field_status = 101;
                x.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg update attInfo field_msgInfoId[%d], field_status[%d], systemRowid[%d], type[%d]", Long.valueOf(cVar.field_msgInfoId), Long.valueOf(cVar.field_status), Long.valueOf(cVar.xjy), Integer.valueOf(a.field_type));
                an.aqd().c(cVar, new String[0]);
                if (!bh.ov(str3)) {
                    an.bYU().t(cVar.field_msgInfoId, str3);
                }
                an.bYU().run();
            } else {
                x.i("MicroMsg.AppMsgLogic", "summerbig sendAppMsg dosceneSendAppMsg attInfo[%s], msgId[%d], sessionId[%s], type[%d]", cVar, Long.valueOf(Q), str3, Integer.valueOf(a.field_type));
                an.bYU();
                am.a.u(Q, str3);
            }
        }
        return 0;
    }

    public static String bb(byte[] bArr) {
        if (bh.bw(bArr)) {
            x.e("MicroMsg.AppMsgLogic", g.zh() + " attachBuf is null");
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        String stringBuilder2 = stringBuilder.append(com.tencent.mm.z.c.Fu()).append("ua_").append(bh.Wp()).toString();
        x.d("MicroMsg.AppMsgLogic", g.zh() + " buildUploadAttachInfo file:" + stringBuilder2);
        if (com.tencent.mm.a.e.b(stringBuilder2, bArr, bArr.length) == 0) {
            return stringBuilder2;
        }
        x.e("MicroMsg.AppMsgLogic", g.zh() + " writeFile error file:" + stringBuilder2);
        return null;
    }

    public static String b(a aVar, WXMediaMessage wXMediaMessage, String str) {
        x.d("MicroMsg.AppMsgLogic", g.zh() + "mediaMessageToContent sdkver:" + wXMediaMessage.sdkVer + " title:" + wXMediaMessage.title + " desc:" + wXMediaMessage.description + " type:" + wXMediaMessage.mediaObject.type());
        aVar.sdkVer = wXMediaMessage.sdkVer;
        aVar.title = wXMediaMessage.title;
        aVar.description = wXMediaMessage.description;
        aVar.mediaTagName = wXMediaMessage.mediaTagName;
        aVar.messageAction = wXMediaMessage.messageAction;
        aVar.messageExt = wXMediaMessage.messageExt;
        IMediaObject iMediaObject = wXMediaMessage.mediaObject;
        aVar.type = iMediaObject.type();
        if (aVar.type == 7) {
            WXAppExtendObject wXAppExtendObject = (WXAppExtendObject) iMediaObject;
            aVar.extInfo = wXAppExtendObject.extInfo;
            if (bh.bw(wXAppExtendObject.fileData)) {
                aVar.hbb = com.tencent.mm.a.e.bN(wXAppExtendObject.filePath);
                x.d("MicroMsg.AppMsgLogic", g.zh() + " read file:" + wXAppExtendObject.filePath + " len:" + aVar.hbb);
                if (aVar.hbb <= 0) {
                    return null;
                }
                aVar.hbc = com.tencent.mm.a.e.bQ(wXAppExtendObject.filePath);
                return wXAppExtendObject.filePath;
            }
            x.d("MicroMsg.AppMsgLogic", g.zh() + " fileData:" + wXAppExtendObject.fileData.length);
            aVar.hbb = wXAppExtendObject.fileData.length;
            return bb(wXAppExtendObject.fileData);
        } else if (aVar.type == 6) {
            WXFileObject wXFileObject = (WXFileObject) iMediaObject;
            if (bh.bw(wXFileObject.fileData)) {
                aVar.hbb = com.tencent.mm.a.e.bN(wXFileObject.filePath);
                x.d("MicroMsg.AppMsgLogic", g.zh() + " read file:" + wXFileObject.filePath + " len:" + aVar.hbb);
                if (aVar.hbb <= 0) {
                    return null;
                }
                aVar.hbc = com.tencent.mm.a.e.bQ(wXFileObject.filePath);
                return wXFileObject.filePath;
            }
            x.d("MicroMsg.AppMsgLogic", g.zh() + " fileData:" + wXFileObject.fileData.length);
            aVar.hbb = wXFileObject.fileData.length;
            return bb(wXFileObject.fileData);
        } else if (aVar.type == 2) {
            WXImageObject wXImageObject = (WXImageObject) iMediaObject;
            if (!bh.bw(wXImageObject.imageData)) {
                x.d("MicroMsg.AppMsgLogic", g.zh() + " fileData:" + wXImageObject.imageData.length);
                aVar.hbb = wXImageObject.imageData.length;
                return bb(wXImageObject.imageData);
            } else if (bh.ov(wXImageObject.imagePath)) {
                return null;
            } else {
                aVar.hbb = com.tencent.mm.a.e.bN(wXImageObject.imagePath);
                x.d("MicroMsg.AppMsgLogic", g.zh() + " read file:" + wXImageObject.imagePath + " len:" + aVar.hbb);
                if (aVar.hbb <= 0) {
                    return null;
                }
                aVar.hbc = com.tencent.mm.a.e.bQ(wXImageObject.imagePath);
                ar.Hg();
                String absolutePath = new File(com.tencent.mm.z.c.Fu(), "appmsg_img_" + System.currentTimeMillis()).getAbsolutePath();
                Options UL = d.UL(wXImageObject.imagePath);
                if (UL == null || UL.outWidth <= 0 || UL.outHeight <= 0) {
                    boolean z;
                    String str2 = "MicroMsg.AppMsgLogic";
                    String str3 = "options is null! %B, bitmapWidth = %d, bitmapHeight = %d";
                    Object[] objArr = new Object[3];
                    if (UL == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[0] = Boolean.valueOf(z);
                    objArr[1] = Integer.valueOf(UL == null ? -1 : UL.outWidth);
                    objArr[2] = Integer.valueOf(UL == null ? -1 : UL.outHeight);
                    x.e(str2, str3, objArr);
                    return null;
                } else if (q.a(wXImageObject.imagePath, "", true)) {
                    x.i("MicroMsg.AppMsgLogic", "this picture can send raw image but must copy [%s] to [%s]", wXImageObject.imagePath, absolutePath);
                    if (com.tencent.mm.a.e.x(wXImageObject.imagePath, absolutePath) >= 0) {
                        return absolutePath;
                    }
                    x.w("MicroMsg.AppMsgLogic", "copy file error path[%s, %s]", wXImageObject.imagePath, absolutePath);
                    return null;
                } else {
                    if (UL.outWidth > 960 || UL.outHeight > 960) {
                        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                        Bitmap a = d.a(wXImageObject.imagePath, 960, 960, false, decodeResultLogger, 0);
                        if (a != null) {
                            try {
                                d.a(a, 100, CompressFormat.JPEG, absolutePath, true);
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.AppMsgLogic", e, "", new Object[0]);
                                return null;
                            }
                        }
                        if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                            com.tencent.mm.plugin.report.service.g.pQN.k(12712, KVStatHelper.getKVStatString(wXImageObject.imagePath, 6, decodeResultLogger));
                        }
                        return null;
                    } else if (com.tencent.mm.a.e.x(wXImageObject.imagePath, absolutePath) < 0) {
                        return null;
                    }
                    return absolutePath;
                }
            }
        } else if (aVar.type == 3) {
            WXMusicObject wXMusicObject = (WXMusicObject) iMediaObject;
            aVar.url = wXMusicObject.musicUrl;
            aVar.hba = wXMusicObject.musicLowBandUrl;
            aVar.hbs = wXMusicObject.musicDataUrl;
            aVar.hbt = wXMusicObject.musicLowBandDataUrl;
            return null;
        } else if (aVar.type == 4) {
            WXVideoObject wXVideoObject = (WXVideoObject) iMediaObject;
            aVar.url = wXVideoObject.videoUrl;
            aVar.hba = wXVideoObject.videoLowBandUrl;
            return null;
        } else if (aVar.type == 5) {
            WXWebpageObject wXWebpageObject = (WXWebpageObject) iMediaObject;
            aVar.url = wXWebpageObject.webpageUrl;
            if (!bh.ov(wXWebpageObject.extInfo)) {
                aVar.extInfo = wXWebpageObject.extInfo;
            }
            if (!bh.ov(wXWebpageObject.canvasPageXml)) {
                aVar.canvasPageXml = wXWebpageObject.canvasPageXml;
            }
            return null;
        } else {
            if (aVar.type == 36) {
                WXMiniProgramObject wXMiniProgramObject = (WXMiniProgramObject) iMediaObject;
                aVar.hdx = wXMiniProgramObject.userName;
                aVar.hdw = wXMiniProgramObject.path;
                aVar.url = wXMiniProgramObject.webpageUrl;
                WxaAttributes qK = ((com.tencent.mm.plugin.appbrand.m.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.m.b.class)).qK(wXMiniProgramObject.userName);
                if (qK != null) {
                    if (qK.acb() != null) {
                        aVar.hdF = qK.acb().fIm;
                    }
                    aVar.hdG = qK.field_brandIconURL;
                    x.i("MicroMsg.AppMsgLogic", "add appbrand version and appbrand icon url : %d, %s", Integer.valueOf(aVar.hdF), aVar.hdG);
                }
            } else if (aVar.type == 1) {
                aVar.title = ((WXTextObject) iMediaObject).text;
                return null;
            } else if (aVar.type == 8) {
                WXEmojiObject wXEmojiObject = (WXEmojiObject) iMediaObject;
                if (!bh.bw(wXEmojiObject.emojiData)) {
                    x.d("MicroMsg.AppMsgLogic", g.zh() + " fileData:" + wXEmojiObject.emojiData.length);
                    aVar.hbb = wXEmojiObject.emojiData.length;
                    return bb(wXEmojiObject.emojiData);
                } else if (bh.ov(wXEmojiObject.emojiPath)) {
                    aVar.hbd = str;
                } else {
                    aVar.hbb = com.tencent.mm.a.e.bN(wXEmojiObject.emojiPath);
                    x.d("MicroMsg.AppMsgLogic", g.zh() + " read file:" + wXEmojiObject.emojiPath + " len:" + aVar.hbb);
                    if (aVar.hbb <= 0) {
                        return null;
                    }
                    aVar.hbc = com.tencent.mm.a.e.bQ(wXEmojiObject.emojiPath);
                    return wXEmojiObject.emojiPath;
                }
            } else if (aVar.type == 15) {
                r0 = (WXEmojiSharedObject) iMediaObject;
                aVar.thumburl = r0.thumburl;
                aVar.hbF = r0.packageflag;
                aVar.hbE = r0.packageid;
                aVar.showType = 8;
                aVar.url = r0.url;
                return null;
            } else if (aVar.type == 13) {
                r0 = (WXEmojiSharedObject) iMediaObject;
                aVar.thumburl = r0.thumburl;
                aVar.hbF = r0.packageflag;
                aVar.hbE = r0.packageid;
                aVar.showType = 8;
                aVar.url = r0.url;
                return null;
            } else if (aVar.type == 25) {
                WXDesignerSharedObject wXDesignerSharedObject = (WXDesignerSharedObject) iMediaObject;
                aVar.thumburl = wXDesignerSharedObject.thumburl;
                aVar.url = wXDesignerSharedObject.url;
                aVar.hdl = wXDesignerSharedObject.designerUIN;
                aVar.designerName = wXDesignerSharedObject.designerName;
                aVar.designerRediretctUrl = wXDesignerSharedObject.designerRediretctUrl;
                aVar.showType = 18;
                return null;
            } else if (aVar.type == 27 || aVar.type == 26) {
                WXEmojiPageSharedObject wXEmojiPageSharedObject = (WXEmojiPageSharedObject) iMediaObject;
                aVar.thumburl = wXEmojiPageSharedObject.iconUrl;
                aVar.url = wXEmojiPageSharedObject.url;
                aVar.tid = wXEmojiPageSharedObject.tid;
                aVar.hdm = wXEmojiPageSharedObject.title;
                aVar.desc = wXEmojiPageSharedObject.desc;
                aVar.iconUrl = wXEmojiPageSharedObject.iconUrl;
                aVar.secondUrl = wXEmojiPageSharedObject.secondUrl;
                aVar.pageType = wXEmojiPageSharedObject.pageType;
                aVar.showType = 20;
                return null;
            }
            return null;
        }
    }

    public static b RI(String str) {
        c bVar = new b();
        if (bh.ov(str)) {
            return null;
        }
        x.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s", str);
        long j = bh.getLong(str, -1);
        if (j != -1) {
            an.aqd().b(j, bVar);
            if (bVar.xjy != j) {
                bVar = an.aqd().Rz(str);
                if (bVar == null || !bVar.field_mediaSvrId.equals(str)) {
                    x.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 1");
                    bVar = null;
                }
            }
        } else {
            bVar = an.aqd().Rz(str);
            if (bVar == null || !bVar.field_mediaSvrId.equals(str)) {
                x.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 2");
                bVar = null;
            }
        }
        x.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s id %s", str, Long.valueOf(j));
        return bVar;
    }

    public static void aa(au auVar) {
        a fT = a.fT(auVar.field_content);
        if (fT == null) {
            x.e("MicroMsg.AppMsgLogic", "resend app message error: app content null");
            return;
        }
        String B;
        byte[] d;
        a a;
        String str;
        String str2;
        c a2;
        cf auVar2;
        long Q;
        b RI = RI(fT.fny);
        String str3 = "";
        if (!(RI == null || RI.field_fileFullPath == null || RI.field_fileFullPath.equals(""))) {
            ar.Hg();
            str3 = ac(com.tencent.mm.z.c.Fu(), fT.title, fT.hbc);
            com.tencent.mm.sdk.platformtools.k.q(RI.field_fileFullPath, str3, false);
        }
        if (!(auVar.field_imgPath == null || auVar.field_imgPath.equals(""))) {
            B = o.Pw().B(auVar.field_imgPath, true);
            try {
                d = com.tencent.mm.a.e.d(B, 0, com.tencent.mm.a.e.bN(B));
            } catch (Exception e) {
            }
            a = a.a(fT);
            str = fT.appId;
            str = fT.appName;
            str2 = System.currentTimeMillis();
            if (bh.ov(str3)) {
                a2 = a(str2, a, str3);
                if (a2 == null) {
                    g.getLine();
                    return;
                }
            }
            a2 = null;
            auVar2 = new au();
            if (d != null && d.length > 0) {
                B = o.Pw().a(6, d, a.type != 2, CompressFormat.PNG);
                x.d("MicroMsg.AppMsgLogic", g.zh() + " thumbData MsgInfo path:" + B);
                if (!bh.ov(B)) {
                    auVar2.dT(B);
                    x.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path" + B);
                }
            }
            if (a2 != null) {
                a.fny = a2.xjy;
            }
            auVar2.setContent(a.a(a, null, null));
            auVar2.eQ(1);
            auVar2.dS(auVar.field_talker);
            auVar2.aq(ba.hR(auVar.field_talker));
            auVar2.eR(1);
            auVar2.setType(d(a));
            if (com.tencent.mm.ag.f.eE(auVar2.field_talker)) {
                auVar2.dY(com.tencent.mm.ag.a.e.HD());
                x.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", auVar2.gjF);
            }
            ar.Hg();
            Q = com.tencent.mm.z.c.Fa().Q(auVar2);
            x.d("MicroMsg.AppMsgLogic", g.zh() + " msginfo insert id: " + Q);
            if (Q >= 0) {
                x.e("MicroMsg.AppMsgLogic", g.zh() + "insert msg failed :" + Q);
                g.getLine();
            }
            x.i("MicroMsg.AppMsgLogic", g.getLine() + " new msg inserted to db , local id = " + Q);
            auVar2.ao(Q);
            com.tencent.mm.sdk.b.b rwVar = new rw();
            rwVar.fJD.fJE = auVar.field_msgId;
            rwVar.fJD.fJF = Q;
            com.tencent.mm.sdk.b.a.xef.m(rwVar);
            c gVar = new com.tencent.mm.y.g();
            gVar.field_xml = auVar2.field_content;
            gVar.field_title = a.title;
            gVar.field_type = a.type;
            gVar.field_description = a.description;
            gVar.field_msgId = Q;
            gVar.field_source = str;
            an.bYS().b(gVar);
            if (a2 == null) {
                a2.field_msgInfoId = Q;
                a2.field_status = 101;
                an.aqd().c(a2, new String[0]);
                an.bYU().run();
                return;
            }
            an.bYU();
            am.a.ft(Q);
            return;
        }
        d = null;
        a = a.a(fT);
        str = fT.appId;
        str = fT.appName;
        str2 = System.currentTimeMillis();
        if (bh.ov(str3)) {
            a2 = null;
        } else {
            a2 = a(str2, a, str3);
            if (a2 == null) {
                g.getLine();
                return;
            }
        }
        auVar2 = new au();
        if (a.type != 2) {
        }
        B = o.Pw().a(6, d, a.type != 2, CompressFormat.PNG);
        x.d("MicroMsg.AppMsgLogic", g.zh() + " thumbData MsgInfo path:" + B);
        if (bh.ov(B)) {
            auVar2.dT(B);
            x.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path" + B);
        }
        if (a2 != null) {
            a.fny = a2.xjy;
        }
        auVar2.setContent(a.a(a, null, null));
        auVar2.eQ(1);
        auVar2.dS(auVar.field_talker);
        auVar2.aq(ba.hR(auVar.field_talker));
        auVar2.eR(1);
        auVar2.setType(d(a));
        if (com.tencent.mm.ag.f.eE(auVar2.field_talker)) {
            auVar2.dY(com.tencent.mm.ag.a.e.HD());
            x.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", auVar2.gjF);
        }
        ar.Hg();
        Q = com.tencent.mm.z.c.Fa().Q(auVar2);
        x.d("MicroMsg.AppMsgLogic", g.zh() + " msginfo insert id: " + Q);
        if (Q >= 0) {
            x.i("MicroMsg.AppMsgLogic", g.getLine() + " new msg inserted to db , local id = " + Q);
            auVar2.ao(Q);
            com.tencent.mm.sdk.b.b rwVar2 = new rw();
            rwVar2.fJD.fJE = auVar.field_msgId;
            rwVar2.fJD.fJF = Q;
            com.tencent.mm.sdk.b.a.xef.m(rwVar2);
            c gVar2 = new com.tencent.mm.y.g();
            gVar2.field_xml = auVar2.field_content;
            gVar2.field_title = a.title;
            gVar2.field_type = a.type;
            gVar2.field_description = a.description;
            gVar2.field_msgId = Q;
            gVar2.field_source = str;
            an.bYS().b(gVar2);
            if (a2 == null) {
                an.bYU();
                am.a.ft(Q);
                return;
            }
            a2.field_msgInfoId = Q;
            a2.field_status = 101;
            an.aqd().c(a2, new String[0]);
            an.bYU().run();
            return;
        }
        x.e("MicroMsg.AppMsgLogic", g.zh() + "insert msg failed :" + Q);
        g.getLine();
    }

    public static int d(a aVar) {
        if (aVar == null) {
            return 49;
        }
        int i = aVar.type;
        int i2 = aVar.showType;
        int i3 = aVar.hbu;
        int i4 = aVar.hbv;
        int i5 = aVar.hcQ;
        x.d("MicroMsg.AppMsgLogic", "getLocalAppMsgType showType " + i2 + " atype " + i + ", itemShowType = " + i3 + ", c2cNewAAType = " + i5);
        if (i3 == 4 || i4 != 0) {
            return 318767153;
        }
        if (i != 2001) {
            switch (i2) {
                case 1:
                    if (i == 21) {
                        return -1879048185;
                    }
                    return 285212721;
                case 2:
                    if (i != 21) {
                        return 301989937;
                    }
                    return -1879048183;
                case 3:
                    if (i == 21) {
                        return -1879048176;
                    }
                    return -1879048189;
                case 4:
                    if (i != 21) {
                        return -1879048190;
                    }
                    return -1879048183;
                case 5:
                    return -1879048191;
                case 17:
                    return -1879048186;
                default:
                    switch (i) {
                        case 1:
                            return 16777265;
                        case 2:
                            return 268435505;
                        case 8:
                            return 1048625;
                        case 10:
                            return 335544369;
                        case 13:
                            return 369098801;
                        case 16:
                            return 452984881;
                        case 17:
                            return -1879048186;
                        case 20:
                            return 402653233;
                        case 33:
                            com.tencent.mm.y.a aVar2 = (com.tencent.mm.y.a) aVar.r(com.tencent.mm.y.a.class);
                            if (aVar2 != null && aVar2.haz && (aVar.hdz == 2 || aVar.hdz == 3)) {
                                return 553648177;
                            }
                        case 34:
                            return 520093745;
                        case MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN /*2000*/:
                            return 419430449;
                    }
                    return 49;
            }
        } else if (i2 == 1) {
            return 469762097;
        } else {
            if (i5 == 4) {
                return 503316529;
            }
            return 436207665;
        }
    }

    public static int BG(int i) {
        switch (i) {
            case -1879048191:
            case -1879048190:
            case -1879048189:
            case -1879048186:
            case -1879048185:
            case -1879048183:
            case -1879048176:
            case 1048625:
            case 16777265:
            case 268435505:
            case 285212721:
            case 301989937:
            case 335544369:
            case 402653233:
            case 419430449:
            case 553648177:
                return 49;
            default:
                return i;
        }
    }
}
