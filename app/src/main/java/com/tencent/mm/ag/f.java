package com.tencent.mm.ag;

import com.tencent.mm.bq.a;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.ari;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ba.5;
import com.tencent.wcdb.FileUtils;
import java.util.List;

public final class f {
    public static d jS(String str) {
        d jK = y.Mf().jK(str);
        return jK.field_updateTime > 0 ? jK : null;
    }

    public static boolean jT(String str) {
        d jS = jS(str);
        if (jS != null && jS.Lb()) {
            return true;
        }
        return false;
    }

    public static boolean jU(String str) {
        d jS = jS(str);
        if (jS == null) {
            return false;
        }
        return jS.Lc();
    }

    public static boolean jV(String str) {
        d jS = jS(str);
        if (jS != null && jS.Ld()) {
            return true;
        }
        return false;
    }

    public static boolean jW(String str) {
        d jS = jS(str);
        if (jS != null && jS.Lf()) {
            return true;
        }
        return false;
    }

    public static boolean jX(String str) {
        if (str == null) {
            return false;
        }
        d jS = jS(str);
        if (jS == null || !jS.Le()) {
            return false;
        }
        return true;
    }

    public static boolean eE(String str) {
        d jS = jS(str);
        if (jS != null && jS.Lg()) {
            return true;
        }
        return false;
    }

    public static boolean jY(String str) {
        d jS = jS(str);
        if (jS != null && jS.Lh()) {
            return true;
        }
        return false;
    }

    public static boolean jZ(String str) {
        d jS = jS(str);
        if (jS == null) {
            return false;
        }
        return jS.KW();
    }

    public static void f(d dVar) {
        if (dVar == null) {
            x.e("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession bizInfo is Null");
            return;
        }
        a com_tencent_mm_protocal_c_ari = new ari();
        com_tencent_mm_protocal_c_ari.hvH = dVar.field_brandFlag;
        com_tencent_mm_protocal_c_ari.ksU = dVar.field_username;
        af WN = ((h) g.h(h.class)).EY().WN(dVar.field_username);
        if (WN == null || !com.tencent.mm.l.a.fZ(WN.field_type)) {
            ((h) g.h(h.class)).EX().b(new e.a(58, com_tencent_mm_protocal_c_ari));
        } else {
            ((h) g.h(h.class)).EX().b(new e.a(47, com_tencent_mm_protocal_c_ari));
        }
        boolean c = y.Mf().c(dVar, new String[0]);
        x.i("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession ret = %b, BrandFlag = %b", new Object[]{Boolean.valueOf(c), Integer.valueOf(dVar.field_brandFlag)});
    }

    public static void g(d dVar) {
        if (dVar != null) {
            a com_tencent_mm_protocal_c_ari = new ari();
            com_tencent_mm_protocal_c_ari.hvH = dVar.field_brandFlag;
            com_tencent_mm_protocal_c_ari.ksU = dVar.field_username;
            ((h) g.h(h.class)).EX().b(new e.a(47, com_tencent_mm_protocal_c_ari));
            y.Mf().c(dVar, new String[0]);
        }
    }

    public static boolean LL() {
        return y.Mf().hr(1) > 0;
    }

    public static List<String> LM() {
        return y.Mf().hq(2);
    }

    public static boolean LN() {
        return y.Mf().hr(4) > 0;
    }

    public static boolean LO() {
        return y.Mf().hr(8) > 0;
    }

    public static List<String> LP() {
        return y.Mf().hq(16);
    }

    public static boolean LQ() {
        return y.Mf().hr(16) > 0;
    }

    public static List<String> LR() {
        return y.Mf().hq(32);
    }

    public static boolean LS() {
        return y.Mf().hr(64) > 0;
    }

    public static List<String> LT() {
        return y.Mf().hq(FileUtils.S_IWUSR);
    }

    public static boolean LU() {
        return y.Mf().hr(FileUtils.S_IWUSR) > 0;
    }

    public static boolean LV() {
        return y.Mf().hr(256) > 0;
    }

    public static boolean LW() {
        return y.Mf().hr(WXMediaMessage.TITLE_LENGTH_LIMIT) > 0;
    }

    public static void ka(String str) {
        int i = 0;
        y.Mf();
        String jO = e.jO(str);
        if (jO != null) {
            ((o) g.h(o.class)).Fb().ED(jO);
        }
        ((h) g.h(h.class)).Fd().WX(str);
        d jS = jS(str);
        if (jS == null) {
            y.Mm().iF(str);
            return;
        }
        if (jS.Le()) {
            ((h) g.h(h.class)).Fd().Xn(str);
            y.Mf();
            List jN = e.jN(str);
            if (jN == null || jN.size() <= 0) {
                x.d("MicroMsg.MsgInfoStorageLogic", "deleteMsgByTalkers, empty talkers");
            } else {
                x.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalkers stack[%s]", new Object[]{bh.cgy()});
                com.tencent.mm.sdk.f.e.post(new 5(jN), "deleteMsgByTalkers");
            }
            while (i < jN.size()) {
                String str2 = (String) jN.get(i);
                if (eE(str2)) {
                    com.tencent.mm.ag.a.e.A(str2, true);
                }
                y.Mf().jL(str2);
                i++;
            }
        }
        if (jS.Lg()) {
            com.tencent.mm.ag.a.e.A(str, true);
        }
        y.Mf().c(jS);
        y.Mm().iF(str);
    }
}
