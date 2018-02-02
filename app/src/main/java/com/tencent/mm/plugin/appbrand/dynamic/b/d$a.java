package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.appcache.ai;
import com.tencent.mm.plugin.appbrand.appcache.p.a;
import com.tencent.mm.plugin.appbrand.dynamic.b.d.1;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.pluginsdk.i.a.d.l;
import java.util.ArrayList;
import java.util.Locale;

final class d$a implements a {
    private final ab iEd;
    private ArrayList<IDKey> iEh;
    private long iEi;
    private long iEj;
    private int iSK;

    private d$a(ab abVar) {
        this.iEi = 0;
        this.iEj = 0;
        this.iEd = abVar;
    }

    private void jU(int i) {
        if (this.iEh == null) {
            this.iEh = new ArrayList();
        }
        this.iEh.add(new IDKey(640, i, 1));
    }

    private void ZJ() {
        try {
            d.pPH.a(this.iEh, false);
            this.iEh.clear();
        } catch (Exception e) {
        }
    }

    public final void Zz() {
        int i = 0;
        if (com.tencent.mm.plugin.appbrand.appcache.d.a.jv(this.iEd.fvM)) {
            int i2;
            if (((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).YW() == null) {
                i2 = 1;
            } else {
                ai YW = ((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).YW();
                String str = this.iEd.appId;
                int i3 = this.iEd.fvM;
                Cursor a = YW.iGs.a(String.format(Locale.US, "select count(%s) from %s where %s=? and %s=?", new Object[]{"version", "AppBrandWxaPkgManifestRecord", "appId", "debugType"}), new String[]{str, String.valueOf(i3)}, 2);
                if (a == null) {
                    i2 = 0;
                } else {
                    if (a.moveToFirst()) {
                        i2 = a.getInt(0);
                    } else {
                        i2 = 0;
                    }
                    a.close();
                }
            }
            this.iSK = i2 > 1 ? a.iSM : a.iSL;
        } else {
            this.iSK = a.iSL;
        }
        switch (1.iSJ[this.iSK - 1]) {
            case 1:
                i = 1;
                break;
            case 2:
                i = 10;
                break;
        }
        jU(i);
        this.iEi = SystemClock.elapsedRealtime();
    }

    public final void ZA() {
        jU(32);
    }

    public final void ZB() {
        jU(31);
    }

    public final void a(l lVar) {
        int i;
        boolean z = true;
        int i2 = 2;
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.iEi;
        if (elapsedRealtime <= 1000) {
            i = 0;
        } else if (elapsedRealtime <= 2000) {
            i = 1;
        } else if (elapsedRealtime <= 3000) {
            i = 2;
        } else if (elapsedRealtime <= 4000) {
            i = 3;
        } else if (elapsedRealtime <= 5000) {
            i = 4;
        } else {
            i = 5;
        }
        d.pPH.a(665, (long) i, 1, false);
        if (lVar == null || lVar.status != 2) {
            z = false;
        }
        switch (1.iSJ[this.iSK - 1]) {
            case 1:
                if (!z) {
                    i2 = 3;
                }
                jU(i2);
                break;
            case 2:
                jU(z ? 11 : 12);
                break;
        }
        ZJ();
    }

    public final void ZC() {
    }

    public final void jw(int i) {
    }

    public final void ZD() {
    }

    public final void ZE() {
        this.iEj = SystemClock.elapsedRealtime();
        switch (1.iSJ[this.iSK - 1]) {
            case 1:
                jU(5);
                return;
            case 2:
                jU(14);
                return;
            default:
                return;
        }
    }

    public final void co(boolean z) {
        int i;
        SystemClock.elapsedRealtime();
        switch (1.iSJ[this.iSK - 1]) {
            case 1:
                if (!z) {
                    i = 7;
                    break;
                } else {
                    i = 6;
                    break;
                }
            case 2:
                if (!z) {
                    i = 16;
                    break;
                } else {
                    i = 15;
                    break;
                }
            default:
                i = 0;
                break;
        }
        jU(i);
        ZJ();
    }
}
