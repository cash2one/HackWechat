package com.tencent.mm.plugin.sns.a.b;

import android.util.Base64;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.blt;
import com.tencent.mm.protocal.c.blu;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public final class f {
    public static void a(String str, d dVar) {
        m Ll = ae.bvv().Ll(str);
        if (Ll != null) {
            bnp bxV = Ll.bxV();
            if (bxV != null) {
                p.a(bxV.rtA, dVar);
                return;
            }
            x.v("SnsAdExtUtil", "timeLineObject null, snsId %s", new Object[]{str});
            return;
        }
        x.v("SnsAdExtUtil", "snsInfo null, snsId %s", new Object[]{str});
    }

    public static String a(long j, Object... objArr) {
        ae.bvp();
        StringBuilder stringBuilder = new StringBuilder(i.l(objArr));
        a(j, stringBuilder);
        return stringBuilder.toString();
    }

    public static void a(long j, StringBuilder stringBuilder) {
        e eK = ae.bvy().eK(j);
        if (eK != null) {
            bnp bxV = eK.bxV();
            if (bxV != null) {
                blu mN = p.mN(bxV.rtA);
                stringBuilder.append(",").append(mN == null ? -1 : mN.cOY);
                stringBuilder.append(",").append(p.a(mN));
                return;
            }
            x.v("SnsAdExtUtil", "l timeLineObject null, snsId %d", new Object[]{Long.valueOf(j)});
            stringBuilder.append(",,");
            return;
        }
        x.v("SnsAdExtUtil", "l snsInfo null, snsId %d", new Object[]{Long.valueOf(j)});
        stringBuilder.append(",,");
    }

    public static String a(bnp com_tencent_mm_protocal_c_bnp) {
        if (com_tencent_mm_protocal_c_bnp != null) {
            return Jy(com_tencent_mm_protocal_c_bnp.rtA);
        }
        x.v("SnsAdExtUtil", "getSnsStatExt timeLineObject null");
        return null;
    }

    private static String Jy(String str) {
        if (bh.ov(str)) {
            return "";
        }
        byte[] decode = Base64.decode(str, 0);
        blt com_tencent_mm_protocal_c_blt = new blt();
        try {
            com_tencent_mm_protocal_c_blt.aF(decode);
            return p.a(com_tencent_mm_protocal_c_blt.wPl);
        } catch (IOException e) {
            x.e("SnsAdExtUtil", "", new Object[]{e});
            return "";
        }
    }
}
