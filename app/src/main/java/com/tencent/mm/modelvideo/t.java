package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.media.MediaMetadataRetriever;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelvideo.m.3;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.aqc;
import com.tencent.mm.protocal.c.bmf;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ba;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class t {
    public static boolean nx(String str) {
        if (str == null) {
            return false;
        }
        r nF = nF(str);
        if (nF == null || nF.hVJ >= 2500) {
            return false;
        }
        nF.hVJ++;
        nF.fDt = 16384;
        return e(nF);
    }

    public static boolean ny(String str) {
        g.pQN.a(111, 218, 1, false);
        x.w("MicroMsg.VideoLogic", "setError file:%s stack:[%s]", new Object[]{str, bh.cgy()});
        o.TZ().flP.remove(str);
        if (str == null) {
            return false;
        }
        r nF = nF(str);
        if (nF == null) {
            x.e("MicroMsg.VideoLogic", "Set error failed file:" + str);
            return false;
        }
        nF.status = bc.CTRL_INDEX;
        nF.hVF = System.currentTimeMillis() / 1000;
        nF.fDt = 1280;
        aqc com_tencent_mm_protocal_c_aqc = nF.hVR;
        com_tencent_mm_protocal_c_aqc.wwQ = 0;
        nF.hVR = com_tencent_mm_protocal_c_aqc;
        boolean e = e(nF);
        x.d("MicroMsg.VideoLogic", "setError file:" + str + " msgid:" + nF.hVI + " old stat:" + nF.status);
        if (nF == null || nF.hVI == 0) {
            return e;
        }
        cf dH = ((h) com.tencent.mm.kernel.g.h(h.class)).aZi().dH((long) nF.hVI);
        int type = dH.getType();
        x.i("MicroMsg.VideoLogic", "set error, msg type %d", new Object[]{Integer.valueOf(type)});
        if (43 != type && 62 != type) {
            return e;
        }
        d.pPH.a(111, 32, 1, true);
        dH.dS(nF.Ud());
        dH.setContent(p.b(nF.Ue(), -1, true));
        x.d("MicroMsg.VideoLogic", "[oneliang][setError]");
        ((h) com.tencent.mm.kernel.g.h(h.class)).aZi().a(dH.field_msgId, dH);
        return e;
    }

    public static boolean nz(String str) {
        r nF = nF(str);
        if (nF == null || nF.hVI == 0) {
            return false;
        }
        au dH = ((h) com.tencent.mm.kernel.g.h(h.class)).aZi().dH((long) nF.hVI);
        int type = dH.getType();
        x.i("MicroMsg.VideoLogic", "ashutest::setBlack, msg type %d", new Object[]{Integer.valueOf(type)});
        if (43 != type && 62 != type) {
            return false;
        }
        dH.setContent(p.b(nF.Ue(), (long) nF.hVH, false));
        dH.eQ(2);
        ((h) com.tencent.mm.kernel.g.h(h.class)).aZi().a((long) nF.hVI, dH);
        nF.status = 197;
        nF.hVF = bh.Wo();
        nF.fDt = 1280;
        x.d("MicroMsg.VideoLogic", "[oneliang][setBlack]");
        return e(nF);
    }

    public static boolean b(String str, int i, String str2, String str3) {
        return a(str, i, str2, str3, 0, "", 43);
    }

    public static boolean a(String str, int i, String str2, String str3, int i2, String str4, int i3) {
        return a(str, i, str2, str3, i2, str4, i3, null, "");
    }

    public static boolean a(String str, int i, String str2, String str3, int i2, String str4, int i3, bmf com_tencent_mm_protocal_c_bmf, String str5) {
        r rVar = new r();
        rVar.fileName = str;
        rVar.hVH = i;
        rVar.fDC = str2;
        rVar.hVz = (String) com.tencent.mm.kernel.g.Dj().CU().get(2, "");
        rVar.hVE = bh.Wo();
        rVar.hVF = bh.Wo();
        rVar.hVN = str4;
        rVar.hTp = str3;
        rVar.hVQ = com_tencent_mm_protocal_c_bmf;
        rVar.fGG = str5;
        if (!bh.ov(str3)) {
            rVar.hVL = 1;
        }
        if (i2 > 0) {
            rVar.hVL = 1;
        }
        if (62 == i3) {
            rVar.hVO = 3;
        } else if (i2 > 0) {
            rVar.hVO = 2;
        } else {
            rVar.hVO = 1;
        }
        o.TU();
        int nv = s.nv(s.nt(str));
        if (nv <= 0) {
            x.e("MicroMsg.VideoLogic", "get Video size failed :" + str);
            return false;
        }
        rVar.hlp = nv;
        o.TU();
        String nu = s.nu(str);
        int nv2 = s.nv(nu);
        if (nv2 <= 0) {
            x.e("MicroMsg.VideoLogic", "get Thumb size failed :" + nu + " size:" + nv2);
            return false;
        }
        rVar.hVD = nv2;
        x.i("MicroMsg.VideoLogic", "init record file:" + str + " thumbsize:" + rVar.hVD + " videosize:" + rVar.hlp + " msgType:" + i3);
        rVar.status = 102;
        au auVar = new au();
        auVar.dS(rVar.Ud());
        auVar.setType(i3);
        auVar.eR(1);
        auVar.dT(str);
        auVar.eQ(1);
        auVar.aq(ba.hR(rVar.Ud()));
        rVar.hVI = (int) ba.i(auVar);
        return o.TU().a(rVar);
    }

    public static long a(String str, int i, String str2, String str3, int i2) {
        if (bh.ov(str)) {
            x.w("MicroMsg.VideoLogic", "do prepare, but file name is null, type %d", new Object[]{Integer.valueOf(i2)});
            return -1;
        } else if (bh.ov(str2)) {
            x.w("MicroMsg.VideoLogic", "do prepare, but toUser is null, type %d", new Object[]{Integer.valueOf(i2)});
            return -1;
        } else {
            int i3;
            r rVar;
            r rVar2 = new r();
            rVar2.fileName = str;
            rVar2.hVH = 1;
            rVar2.fDC = str2;
            rVar2.hVz = (String) com.tencent.mm.kernel.g.Dj().CU().get(2, "");
            rVar2.hVE = bh.Wo();
            rVar2.hVF = bh.Wo();
            rVar2.hVN = null;
            rVar2.hTp = str3;
            if (!bh.ov(str3)) {
                rVar2.hVL = 1;
            }
            if (62 == i2) {
                rVar2.hVL = 0;
                i3 = 3;
                rVar = rVar2;
            } else if (rVar2.hVL == 0) {
                i3 = 1;
                rVar = rVar2;
            } else {
                i3 = -1;
                rVar = rVar2;
            }
            rVar.hVO = i3;
            rVar2.hlp = 0;
            rVar2.status = 106;
            au auVar = new au();
            auVar.dS(rVar2.Ud());
            auVar.setType(i2);
            auVar.eR(1);
            auVar.dT(str);
            auVar.eQ(8);
            auVar.aq(ba.hR(rVar2.Ud()));
            long i4 = ba.i(auVar);
            rVar2.hVI = (int) i4;
            if (o.TU().a(rVar2)) {
                return i4;
            }
            return -1;
        }
    }

    public static void j(String str, int i, int i2) {
        r nF = nF(str);
        if (nF == null) {
            x.w("MicroMsg.VideoLogic", "update, but video info is null, fileName %s, msgType %d", new Object[]{str, Integer.valueOf(i2)});
            return;
        }
        o.TU();
        x.i("MicroMsg.VideoLogic", "update, video size %d, msgType %d", new Object[]{Integer.valueOf(s.nv(s.nt(str))), Integer.valueOf(i2)});
        nF.hlp = r0;
        nF.hVH = i;
        aqc com_tencent_mm_protocal_c_aqc = nF.hVR;
        com_tencent_mm_protocal_c_aqc.wwO = false;
        nF.hVR = com_tencent_mm_protocal_c_aqc;
        nF.status = 102;
        o.TU();
        nF.hVD = s.nv(s.nu(str));
        x.i("MicroMsg.VideoLogic", "update prepare:" + str + " thumbsize:" + nF.hVD);
        nF.fDt = 4512;
        x.i("MicroMsg.VideoLogic", "update to db, result %B, msgType %d", new Object[]{Boolean.valueOf(e(nF)), Integer.valueOf(i2)});
        cf dH = ((h) com.tencent.mm.kernel.g.h(h.class)).aZi().dH((long) nF.hVI);
        x.i("MicroMsg.VideoLogic", "before update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[]{Long.valueOf(dH.field_msgId), Long.valueOf(dH.field_msgSvrId), dH.field_talker, Integer.valueOf(dH.getType()), Integer.valueOf(dH.field_isSend), dH.field_imgPath, Integer.valueOf(dH.field_status), Long.valueOf(dH.field_createTime)});
        dH.dS(nF.Ud());
        dH.setType(i2);
        dH.eR(1);
        dH.dT(str);
        dH.eQ(1);
        x.i("MicroMsg.VideoLogic", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[]{Long.valueOf(dH.field_msgId), Long.valueOf(dH.field_msgSvrId), dH.field_talker, Integer.valueOf(dH.getType()), Integer.valueOf(dH.field_isSend), dH.field_imgPath, Integer.valueOf(dH.field_status), Long.valueOf(dH.field_createTime)});
        ((h) com.tencent.mm.kernel.g.h(h.class)).aZi().a((long) nF.hVI, dH);
    }

    public static int nA(String str) {
        r nF = nF(str);
        if (nF == null) {
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zh() + " getinfo failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        } else if (nF.status == 102 || nF.status == 105) {
            int i = nF.status;
            if (nF.status == 102 || nF.hVD != nF.hVC) {
                nF.status = 103;
            } else {
                nF.status = 104;
            }
            x.d("MicroMsg.VideoLogic", com.tencent.mm.compatible.util.g.zh() + "startSend file:" + str + " status:[" + i + "->" + nF.status + "]");
            nF.hVG = bh.Wo();
            nF.hVF = bh.Wo();
            nF.fDt = 3328;
            if (e(nF)) {
                o.TZ().run();
                return 0;
            }
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zh() + " update failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        } else {
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zh() + " get status failed: " + str + " status:" + nF.status);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        }
    }

    public static int bu(long j) {
        for (r rVar : o.TU().bt(j)) {
            int i = rVar.status;
            rVar.status = 200;
            x.d("MicroMsg.VideoLogic", com.tencent.mm.compatible.util.g.zh() + "startSend file:" + rVar.getFileName() + " status:[" + i + "->" + rVar.status + "]");
            rVar.hVG = bh.Wo();
            rVar.hVF = bh.Wo();
            rVar.fDt = 3328;
            if (!e(rVar)) {
                x.e("MicroMsg.VideoLogic", "ERR on start MassSend:" + com.tencent.mm.compatible.util.g.zh() + " update failed: " + rVar.getFileName());
                return 0 - com.tencent.mm.compatible.util.g.getLine();
            }
        }
        com.tencent.mm.kernel.g.Dm().F(new 3(o.Ua()));
        return 0;
    }

    public static void c(r rVar) {
        if (rVar == null) {
            x.e("MicroMsg.VideoLogic", "video info is null");
            return;
        }
        cf dH = ((h) com.tencent.mm.kernel.g.h(h.class)).aZi().dH((long) rVar.hVI);
        int type = dH.getType();
        x.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMsgInfo, msg type %d", new Object[]{Integer.valueOf(type)});
        if (43 == type || 62 == type) {
            dH.eR(1);
            dH.dS(rVar.Ud());
            dH.ap(rVar.fFo);
            dH.eQ(2);
            dH.setContent(p.b(rVar.Ue(), (long) rVar.hVH, false));
            ((h) com.tencent.mm.kernel.g.h(h.class)).aZi().a((long) rVar.hVI, dH);
            x.d("MicroMsg.VideoLogic", "[oneliang][updateWriteFinMsgInfo], msgId:%d", new Object[]{Long.valueOf(dH.field_msgId)});
        }
    }

    static boolean d(r rVar) {
        cf dH = ((h) com.tencent.mm.kernel.g.h(h.class)).aZi().dH((long) rVar.hVI);
        int type = dH.getType();
        x.i("MicroMsg.VideoLogic", "ashutest::update read fin msg info, msg type %d", new Object[]{Integer.valueOf(type)});
        if (43 != type && 62 != type) {
            return false;
        }
        dH.ap(rVar.fFo);
        dH.setContent(p.b(rVar.Ue(), (long) rVar.hVH, false));
        dH.dS(rVar.Ud());
        x.d("MicroMsg.VideoLogic", "set msg content :" + dH.field_content);
        ((h) com.tencent.mm.kernel.g.h(h.class)).aZi().b(rVar.fFo, dH);
        x.d("MicroMsg.VideoLogic", "[oneliang][updateReadFinMsgInfo], msgId:%d", new Object[]{Long.valueOf(dH.field_msgId)});
        if (dH.cji()) {
            x.i("MicroMsg.VideoLogic", "on receive sight, sightFileSize %d bytes", new Object[]{Integer.valueOf(rVar.hlp)});
        }
        return true;
    }

    public static int nB(String str) {
        r nF = nF(str);
        if (nF == null) {
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zh() + " getinfo failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        } else if (nF.status == 111 || nF.status == 113 || nF.status == 121 || nF.status == 122 || nF.status == 123) {
            nF.status = MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
            nF.hVG = bh.Wo();
            nF.hVF = bh.Wo();
            nF.fDt = 3328;
            if (e(nF)) {
                o.TZ().Us();
                o.TZ().run();
                return 0;
            }
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zh() + " update failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        } else {
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zh() + " get status failed: " + str + " status:" + nF.status);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        }
    }

    public static int nC(String str) {
        r nF = nF(str);
        if (nF == null) {
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zh() + " getinfo failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        } else if (nF.status == MMGIFException.D_GIF_ERR_IMAGE_DEFECT || nF.status == 120 || nF.status == 122 || nF.status == 123) {
            nF.status = 113;
            nF.hVF = bh.Wo();
            nF.fDt = 1280;
            if (e(nF)) {
                return 0;
            }
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zh() + " update failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        } else {
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zh() + " get status failed: " + str + " status:" + nF.status);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        }
    }

    public static boolean X(String str, int i) {
        int i2 = 0;
        r nF = nF(str);
        if (nF == null) {
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zh() + " getinfo failed: " + str);
            return false;
        }
        if (i != nF.hlp) {
            x.w("MicroMsg.VideoLogic", "download video finish, but file size is not equals db size[%d, %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(nF.hlp)});
            nF.hlp = i;
            i2 = 32;
        }
        nF.hVB = i;
        nF.hVF = bh.Wo();
        d(nF);
        nF.status = 199;
        nF.fDt = i2 | 1296;
        boolean e = e(nF);
        x.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + str + " newsize:" + i + " total:" + nF.hlp + " status:" + nF.status + " netTimes:" + nF.hVJ + " update ret: " + e);
        return e;
    }

    public static boolean nD(String str) {
        x.i("MicroMsg.VideoLogic", "resetMsgRecv fileName : " + str);
        r rVar = new r();
        rVar.status = MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
        rVar.hVF = bh.Wo();
        rVar.hVG = bh.Wo();
        rVar.fileName = str;
        rVar.fDt = 3328;
        if (!e(rVar)) {
            return false;
        }
        o.TZ().run();
        return true;
    }

    public static boolean nE(String str) {
        r nF = nF(str);
        if (nF == null) {
            return false;
        }
        x.i("MicroMsg.VideoLogic", "rsetMsgSend %s", new Object[]{str});
        aqc com_tencent_mm_protocal_c_aqc = nF.hVR;
        if (com_tencent_mm_protocal_c_aqc != null) {
            com_tencent_mm_protocal_c_aqc.wwQ = 0;
            nF.hVR = com_tencent_mm_protocal_c_aqc;
        }
        if (nF.hVC < nF.hVD) {
            nF.status = 103;
        } else {
            nF.status = 104;
        }
        nF.hVE = bh.Wo();
        nF.hVF = bh.Wo();
        nF.hVG = bh.Wo();
        nF.fDt = 536874752;
        if (!e(nF)) {
            return false;
        }
        o.TZ().run();
        return true;
    }

    public static r nF(String str) {
        if (bh.ov(str)) {
            return null;
        }
        return o.TU().nr(str);
    }

    public static boolean e(r rVar) {
        if (rVar == null) {
            return false;
        }
        if ((rVar.getFileName() == null || rVar.getFileName().length() <= 0) && rVar.fDt == -1) {
            return false;
        }
        return o.TU().b(rVar);
    }

    public static String nG(String str) {
        String str2 = e.gHu + bh.Wp() + ".mp4";
        if (k.fp(str, str2)) {
            return str2;
        }
        return null;
    }

    public static int f(r rVar) {
        if (rVar.hlp == 0) {
            return 0;
        }
        x.d("MicroMsg.VideoLogic", "cdntra getDownloadProgress :" + rVar.hVB + " " + rVar.hlp);
        return (rVar.hVB * 100) / rVar.hlp;
    }

    public static int g(r rVar) {
        if (rVar.hlp == 0) {
            return 0;
        }
        x.d("MicroMsg.VideoLogic", "cdntra getUploadProgress :" + rVar.hUp + " " + rVar.hlp);
        return (rVar.hUp * 100) / rVar.hlp;
    }

    public static boolean nH(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.VideoLogic", "check short video was replaced, but filename is null.");
            return false;
        }
        x.d("MicroMsg.VideoLogic", "checkShortVideoWasReplaced filename: " + str);
        r nF = nF(str);
        if (nF == null || nF.status != 199) {
            return false;
        }
        int i = nF.hlp;
        o.TU();
        int bN = com.tencent.mm.a.e.bN(s.nt(str));
        x.d("MicroMsg.VideoLogic", "it short video file size[%d] infoLen[%d]", new Object[]{Integer.valueOf(bN), Integer.valueOf(i)});
        if (bN <= 0 || Math.abs(bN - i) <= 16) {
            return false;
        }
        x.w("MicroMsg.VideoLogic", "it error short video can not retransmit. file size[%d], video info size[%d]", new Object[]{Integer.valueOf(bN), Integer.valueOf(i)});
        String fileName = nF.getFileName();
        g.pQN.a(111, 217, 1, false);
        r nF2 = nF(fileName);
        if (nF2 != null) {
            au dH = ((h) com.tencent.mm.kernel.g.h(h.class)).aZi().dH((long) nF2.hVI);
            int type = dH.getType();
            x.i("MicroMsg.VideoLogic", "ashutest::setBroken, msg type %d", new Object[]{Integer.valueOf(type)});
            if (43 == type || 62 == type) {
                dH.setContent(p.b(nF2.Ue(), (long) nF2.hVH, false));
                dH.eQ(2);
                ((h) com.tencent.mm.kernel.g.h(h.class)).aZi().a((long) nF2.hVI, dH);
                nF2.status = 196;
                nF2.hVF = bh.Wo();
                nF2.fDt = 1280;
                x.d("MicroMsg.VideoLogic", "[oneliang][setBroken]");
                e(nF2);
            }
        }
        return true;
    }

    public static int y(int i, String str) {
        int i2;
        long Wq = bh.Wq();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        if (!o.TX().b(str, pInt, pInt2) || bh.by((long) pInt.value) >= 300) {
            i2 = 0;
        } else {
            i2 = pInt2.value;
        }
        if (i2 < 0 || i2 >= i - 1) {
            i2 = 0;
        }
        x.d("MicroMsg.VideoLogic", "check last play duration result[%d] startTime[%d] filename[%s] cost %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(pInt.value), str, Long.valueOf(bh.bA(Wq))});
        return i2;
    }

    public static void d(String str, int i, boolean z) {
        if (bh.ov(str)) {
            x.w("MicroMsg.VideoLogic", "noteVideoPlayHistory error filename[%s]", new Object[]{str});
            return;
        }
        boolean z2;
        if (i < 0) {
            i = 0;
        }
        int i2 = i / 1000;
        long Wq = bh.Wq();
        long update;
        if (o.TX().nL(str)) {
            w TX = o.TX();
            int Wp = (int) (bh.Wp() / 1000);
            if (!bh.ov(str)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("starttime", Integer.valueOf(Wp));
                contentValues.put("playduration", Integer.valueOf(i2));
                update = (long) TX.gJP.update("VideoPlayHistory", contentValues, "filename=?", new String[]{str});
                x.i("MicroMsg.VideoPlayHistoryStorage", "update video play history ret : " + update);
                if (update > 0) {
                    z2 = true;
                }
            }
            z2 = false;
        } else {
            w TX2 = o.TX();
            int Wp2 = (int) (bh.Wp() / 1000);
            int i3 = z ? 1 : 0;
            if (!bh.ov(str)) {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put(FFmpegMetadataRetriever.METADATA_KEY_FILENAME, str);
                contentValues2.put("starttime", Integer.valueOf(Wp2));
                contentValues2.put("playduration", Integer.valueOf(i2));
                contentValues2.put("downloadway", Integer.valueOf(i3));
                update = TX2.gJP.insert("VideoPlayHistory", FFmpegMetadataRetriever.METADATA_KEY_FILENAME, contentValues2);
                x.i("MicroMsg.VideoPlayHistoryStorage", "insert video play history ret : " + update);
                if (update > 0) {
                    z2 = true;
                }
            }
            z2 = false;
        }
        x.d("MicroMsg.VideoLogic", "noteVideoPlayHistory ret %b filename %s playDuration %d isOnlinePlay %b cost %d", new Object[]{Boolean.valueOf(z2), str, Integer.valueOf(i2), Boolean.valueOf(z), Long.valueOf(bh.bA(Wq))});
    }

    public static void nI(String str) {
        boolean z = true;
        if (!bh.ov(str)) {
            if (o.TX().gJP.delete("VideoPlayHistory", "filename= ?", new String[]{str}) <= 0) {
                z = false;
            }
            x.d("MicroMsg.VideoLogic", "delete video play history ret : " + z + " filename : " + str);
        }
    }

    public static String d(long j, int i) {
        return j + "_" + i;
    }

    public static int f(long j, String str) {
        int i = -1;
        if (!bh.ov(str)) {
            try {
                String[] split = str.split("_");
                if (split != null && split.length == 2 && bh.getLong(split[0], 0) == j) {
                    i = bh.getInt(split[1], 0);
                }
            } catch (Exception e) {
                x.e("MicroMsg.VideoLogic", "parseEnterVideoOpTips error: " + e.toString());
            }
        }
        return i;
    }

    public static void Y(String str, int i) {
        r nF = nF(str);
        if (nF != null) {
            nF.status = 122;
            nF.hVG = bh.Wo();
            nF.hVF = bh.Wo();
            nF.htL = i;
            nF.fDt = 268438784;
            x.i("MicroMsg.VideoLogic", "set online video Completion ret: " + o.TU().b(nF) + " status: " + nF.status);
        }
    }

    public static int nJ(String str) {
        r nF = nF(str);
        if (nF == null) {
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zh() + " getinfo failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        } else if (nF.status == 111 || nF.status == 113 || nF.status == 121 || nF.status == 122 || nF.status == 123) {
            int i = 256;
            com.tencent.mm.modelcontrol.d.MU();
            if (com.tencent.mm.modelcontrol.d.MZ()) {
                nF.status = 122;
            } else {
                x.w("MicroMsg.VideoLogic", "start complete online video, but can not stream video now!");
                nF.status = MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
                nF.hVB = 0;
                i = com.tencent.mm.plugin.appbrand.jsapi.f.e.CTRL_INDEX;
            }
            nF.hVG = bh.Wo();
            nF.hVF = bh.Wo();
            nF.fDt = (i | 2048) | WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
            if (e(nF)) {
                o.TZ().Us();
                o.TZ().run();
                return 0;
            }
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zh() + " update failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        } else {
            x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zh() + " get status failed: " + str + " status:" + nF.status);
            return 0 - com.tencent.mm.compatible.util.g.getLine();
        }
    }

    public static boolean Z(String str, int i) {
        return b(nF(str), i);
    }

    public static boolean b(r rVar, int i) {
        if (rVar == null) {
            return false;
        }
        rVar.htL = i;
        rVar.fDt = SQLiteDatabase.CREATE_IF_NECESSARY;
        return e(rVar);
    }

    public static boolean a(String str, PInt pInt, PInt pInt2) {
        MediaMetadataRetriever mediaMetadataRetriever;
        Throwable e;
        Throwable th;
        if (bh.ov(str)) {
            x.w("MicroMsg.VideoLogic", "get media info but path is null");
            return false;
        }
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                pInt.value = bh.fM((long) bh.getInt(mediaMetadataRetriever.extractMetadata(9), 0));
                pInt2.value = bh.getInt(mediaMetadataRetriever.extractMetadata(20), 0) / 1000;
                mediaMetadataRetriever.release();
            } catch (Exception e2) {
                e = e2;
                try {
                    x.printErrStackTrace("MicroMsg.VideoLogic", e, "get video bitrate error. path %s", new Object[]{str});
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                    x.d("MicroMsg.VideoLogic", "video bitrate %d kbps duration %d path %s", new Object[]{Integer.valueOf(pInt2.value), Integer.valueOf(pInt.value), str});
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            mediaMetadataRetriever = null;
            x.printErrStackTrace("MicroMsg.VideoLogic", e, "get video bitrate error. path %s", new Object[]{str});
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            x.d("MicroMsg.VideoLogic", "video bitrate %d kbps duration %d path %s", new Object[]{Integer.valueOf(pInt2.value), Integer.valueOf(pInt.value), str});
            return true;
        } catch (Throwable th3) {
            th = th3;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            throw th;
        }
        x.d("MicroMsg.VideoLogic", "video bitrate %d kbps duration %d path %s", new Object[]{Integer.valueOf(pInt2.value), Integer.valueOf(pInt.value), str});
        return true;
    }
}
