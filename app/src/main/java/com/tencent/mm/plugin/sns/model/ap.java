package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.a.e;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class ap {
    public static String aF(int i, String str) {
        String a = d.a("snsvideo", (long) i, "sns", str);
        if (bh.ov(a)) {
            return null;
        }
        return a;
    }

    public static String ns(String str) {
        if (bh.ov(str)) {
            return "";
        }
        x.d("MicroMsg.SnsVideoLogic", "gen sns[%s] video file name [%s]", new Object[]{str, "SNS_" + str});
        return "SNS_" + str;
    }

    public static String Ks(String str) {
        if (bh.ov(str)) {
            return "";
        }
        int indexOf = str.indexOf("SNS_");
        if (indexOf < 0) {
            return "";
        }
        String str2 = "";
        try {
            return str.substring(indexOf + 4);
        } catch (Exception e) {
            return str2;
        }
    }

    public static String Kt(String str) {
        if (bh.ov(str)) {
            return null;
        }
        x.i("MicroMsg.SnsVideoLogic", "get sns video dir %s mediaId %s", new Object[]{am.r(ae.getAccSnsPath(), str), str});
        return am.r(ae.getAccSnsPath(), str);
    }

    public static String D(aqr com_tencent_mm_protocal_c_aqr) {
        if (com_tencent_mm_protocal_c_aqr == null) {
            return null;
        }
        x.i("MicroMsg.SnsVideoLogic", "get sns video path %s", new Object[]{am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ) + i.j(com_tencent_mm_protocal_c_aqr)});
        return am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ) + i.j(com_tencent_mm_protocal_c_aqr);
    }

    public static String a(String str, aqr com_tencent_mm_protocal_c_aqr) {
        String str2;
        if (com_tencent_mm_protocal_c_aqr == null) {
            str2 = null;
        } else {
            str2 = am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ) + i.p(com_tencent_mm_protocal_c_aqr);
            x.i("MicroMsg.SnsVideoLogic", "get sns video tmp path %s", new Object[]{str2});
        }
        if (e.bO(str2)) {
            x.i("MicroMsg.SnsVideoLogic", "it needn't download video[%s] because of the video is self. %s", new Object[]{str, str2});
            return str2;
        }
        str2 = D(com_tencent_mm_protocal_c_aqr);
        boolean bO = e.bO(str2);
        r Ku = Ku(str);
        if (Ku == null) {
            if (bO) {
                x.i("MicroMsg.SnsVideoLogic", "it old version already download video[%s]. path :%s", new Object[]{str, str2});
                return str2;
            }
            x.i("MicroMsg.SnsVideoLogic", "video info is null and file is no exists, return null.[%s]", new Object[]{str});
            return null;
        } else if (bO && Ku.Uj()) {
            x.i("MicroMsg.SnsVideoLogic", "it had download sns video[%s] finish. %s", new Object[]{str, str2});
            return str2;
        } else {
            x.i("MicroMsg.SnsVideoLogic", "it don't download video[%s] finish. file[%b] status[%d], return null.", new Object[]{str, Boolean.valueOf(bO), Integer.valueOf(Ku.status)});
            return null;
        }
    }

    public static boolean ce(String str, int i) {
        if (bh.ov(str)) {
            x.w("MicroMsg.SnsVideoLogic", "init sns record, but snsLocalId is null");
            return false;
        }
        String ns = ns(str);
        r rVar = new r();
        rVar.fileName = ns;
        rVar.hVE = bh.Wo();
        rVar.status = 130;
        rVar.htL = i;
        x.i("MicroMsg.SnsVideoLogic", "init sns Record filename %s, insert %b", new Object[]{ns, Boolean.valueOf(o.TU().a(rVar))});
        return o.TU().a(rVar);
    }

    public static boolean c(r rVar, int i) {
        rVar.status = 130;
        rVar.htL = i;
        rVar.fDt = 268435712;
        x.i("MicroMsg.SnsVideoLogic", "update sns Record filename %s, update %b", new Object[]{rVar.getFileName(), Boolean.valueOf(o.TU().b(rVar))});
        return o.TU().b(rVar);
    }

    public static boolean ec(String str, String str2) {
        int i;
        boolean a;
        r Ku = Ku(str);
        if (Ku == null) {
            Ku = new r();
            Ku.fileName = ns(str);
            i = 1;
        } else {
            i = 0;
        }
        Ku.hVE = bh.Wo();
        Ku.fHk = str2;
        Ku.status = 199;
        if (i != 0) {
            a = o.TU().a(Ku);
        } else {
            Ku.fDt = 33555200;
            a = o.TU().b(Ku);
        }
        x.i("MicroMsg.SnsVideoLogic", "post sns video snsLocalId %s, md5 %s ret %b", new Object[]{str, str2, Boolean.valueOf(a)});
        return a;
    }

    public static r Ku(String str) {
        if (bh.ov(str)) {
            return null;
        }
        return t.nF(ns(str));
    }
}
