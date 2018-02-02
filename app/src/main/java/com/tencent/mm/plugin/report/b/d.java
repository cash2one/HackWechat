package com.tencent.mm.plugin.report.b;

import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.b.a.a.i;
import com.tencent.b.a.a.i.1;
import com.tencent.b.a.a.n;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    private static i pPU = i.X(ac.getContext());
    private static int pPV = 2;

    static /* synthetic */ int vD() {
        int i = pPV;
        pPV = i - 1;
        return i;
    }

    public static String boc() {
        try {
            i.a(new 1());
            x.i("MicroMsg.MidHelper", "QueryMid try Get Now getMid:%s getLocalMid:%s", pPU.sK(), pPU.sL());
            return pPU.sK();
        } catch (Throwable e) {
            x.e("MicroMsg.MidHelper", "QueryMid Error e:%s", bh.i(e));
            return "";
        }
    }

    public static void Iw(String str) {
        try {
            i iVar = pPU;
            if (i.mContext != null) {
                i.bpv = System.currentTimeMillis();
                n.bpG = -1;
                try {
                    Editor edit = PreferenceManager.getDefaultSharedPreferences(i.mContext).edit();
                    edit.putLong("__MID_LAST_CHECK_TIME__", i.bpv);
                    edit.commit();
                } catch (Exception e) {
                }
                if (i.mHandler != null) {
                    i.mHandler.post(new 1(iVar, str));
                }
            }
            x.i("MicroMsg.MidHelper", "QueryMid local:%s", pPU.sL());
        } catch (Throwable e2) {
            x.e("MicroMsg.MidHelper", "procReturnData Error e:%s", bh.i(e2));
        }
    }

    public static int n(int i, int i2, String str) {
        if (g.Dh().Cy()) {
            long Wo = bh.Wo();
            if (i == 3 && bh.a((Long) g.Dj().CU().get(331778, null), 0) >= Wo) {
                return 0;
            }
            int i3;
            if (an.is2G(ac.getContext())) {
                i3 = 1;
            } else if (an.isWifi(ac.getContext())) {
                i3 = 3;
            } else if (an.is3G(ac.getContext())) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            String boc = boc();
            x.i("MicroMsg.MidHelper", "querymid checkReportMid moment:%d mid[%s]", Integer.valueOf(i), boc);
            com.tencent.mm.plugin.report.d.pPH.h(11402, boc, Integer.valueOf(i), Integer.valueOf(i3), q.yF(), Integer.valueOf(i2), str, an.getISPName(ac.getContext()), Integer.valueOf(0), q.getDeviceID(ac.getContext()));
            g.Dj().CU().set(331778, Long.valueOf(259200 + Wo));
            return 0;
        }
        x.i("MicroMsg.MidHelper", "checkReportMid acc not ready");
        return -1;
    }
}
