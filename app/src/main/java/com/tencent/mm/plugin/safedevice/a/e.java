package com.tencent.mm.plugin.safedevice.a;

import android.content.Context;
import android.os.Build;
import com.tencent.mm.R;
import com.tencent.mm.bq.a;
import com.tencent.mm.protocal.c.bdq;
import com.tencent.mm.protocal.c.bdr;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import java.util.List;

public final class e {
    public static void x(boolean z, boolean z2) {
        if (ar.Hj()) {
            int FY = q.FY();
            if (z) {
                FY |= 16384;
            } else {
                FY &= -16385;
            }
            ar.Hg();
            c.CU().set(40, Integer.valueOf(FY));
            if (z2) {
                a wlVar = new wl();
                wlVar.wgL = 28;
                wlVar.wgM = z ? 1 : 2;
                ar.Hg();
                c.EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(23, wlVar));
                com.tencent.mm.plugin.c.a.ift.um();
            }
        }
    }

    static void a(bdr com_tencent_mm_protocal_c_bdr) {
        if (com_tencent_mm_protocal_c_bdr != null && com_tencent_mm_protocal_c_bdr.ksP != null) {
            List<bdq> list = com_tencent_mm_protocal_c_bdr.ksP;
            if (list != null && list.size() >= 0) {
                f.bos().fx("SafeDeviceInfo", "delete from SafeDeviceInfo");
                for (bdq cVar : list) {
                    f.bos().a(new c(cVar));
                }
            }
        }
    }

    public static String dq(Context context) {
        return context == null ? f.xeD ? ac.getContext().getString(R.l.eGF) : ac.getContext().getString(R.l.eGE) : f.xeD ? context.getString(R.l.eGF) : context.getString(R.l.eGE);
    }

    public static String boq() {
        return Build.MANUFACTURER + "-" + Build.MODEL;
    }
}
