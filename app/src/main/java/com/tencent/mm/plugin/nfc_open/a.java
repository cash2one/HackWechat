package com.tencent.mm.plugin.nfc_open;

import android.content.ComponentName;
import android.nfc.NfcAdapter;
import android.os.Process;
import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.nfc_open.a.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import com.tencent.mm.z.c;
import java.util.HashMap;

public final class a implements ap {
    private com.tencent.mm.plugin.nfc_open.b.a oSf;

    private static a bfx() {
        ar.Ha();
        a aVar = (a) bp.hY("plugin.nfc_open");
        if (aVar != null) {
            return aVar;
        }
        x.w("MicroMsg.SubCoreCpuCard", "[NFC]not found in MMCore, new one");
        Object aVar2 = new a();
        ar.Ha().a("plugin.nfc_open", aVar2);
        return aVar2;
    }

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void br(boolean z) {
    }

    public final void bq(boolean z) {
        boolean z2;
        int i = 1800;
        x.i("MicroMsg.SubCoreCpuCard", "alvinluo process: %s", new Object[]{bh.r(ac.getContext(), Process.myPid())});
        g.Dh().Ct();
        if (bfx().oSf == null) {
            bfx().oSf = new com.tencent.mm.plugin.nfc_open.b.a();
        }
        com.tencent.mm.plugin.nfc_open.b.a aVar = bfx().oSf;
        if (NfcAdapter.getDefaultAdapter(ac.getContext()) == null) {
            x.i("MicroMsg.CpuCardConfigManager", "Nfc not support no need update");
        } else if (aVar.oSh != null) {
            int i2 = aVar.oSh.vYp;
            if (i2 >= 1800) {
                if (i2 > 604800) {
                    i = 604800;
                } else {
                    i = i2;
                }
            }
            x.i("MicroMsg.CpuCardConfigManager", "now=" + bh.Wo() + ", lastUpdateTime=" + aVar.oSh.lastUpdateTime + ", updateFreq=" + i + ", configUpdateFreq=" + aVar.oSh.vYp);
            if (bh.Wo() - aVar.oSh.lastUpdateTime > ((long) i)) {
                z2 = true;
                if (z2) {
                    x.i("MicroMsg.CpuCardConfigManager", "do update cpu card config");
                    ar.CG().a(1561, aVar);
                    ar.CG().a(new b(aVar.oSh.version), 0);
                }
                ar.Hg();
                i = ((Integer) c.CU().get(com.tencent.mm.storage.w.a.xoW, Integer.valueOf(0))).intValue();
                if (i == 0) {
                    ar.Hg();
                    if (((Integer) c.CU().get(com.tencent.mm.storage.w.a.xoX, Integer.valueOf(0))).intValue() != 1) {
                        ha(true);
                    } else {
                        ha(false);
                    }
                } else if (i != 1) {
                    ha(true);
                } else {
                    ha(false);
                }
                x.i("MicroMsg.SubCoreCpuCard", "doNFCReport start");
                e.post(new 1(this), getClass().getName());
            }
        }
        z2 = false;
        if (z2) {
            x.i("MicroMsg.CpuCardConfigManager", "do update cpu card config");
            ar.CG().a(1561, aVar);
            ar.CG().a(new b(aVar.oSh.version), 0);
        }
        ar.Hg();
        i = ((Integer) c.CU().get(com.tencent.mm.storage.w.a.xoW, Integer.valueOf(0))).intValue();
        if (i == 0) {
            ar.Hg();
            if (((Integer) c.CU().get(com.tencent.mm.storage.w.a.xoX, Integer.valueOf(0))).intValue() != 1) {
                ha(false);
            } else {
                ha(true);
            }
        } else if (i != 1) {
            ha(false);
        } else {
            ha(true);
        }
        x.i("MicroMsg.SubCoreCpuCard", "doNFCReport start");
        e.post(new 1(this), getClass().getName());
    }

    private static void ha(boolean z) {
        if (z) {
            ac.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ac.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
        } else {
            ac.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ac.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
        }
    }

    public final void onAccountRelease() {
    }
}
