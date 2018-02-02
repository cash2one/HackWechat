package com.tencent.mm.plugin.i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.tencent.mm.by.h.d;
import com.tencent.mm.g.a.bl;
import com.tencent.mm.g.a.cb;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.platformtools.g.a;
import com.tencent.mm.plugin.i.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.HashMap;
import java.util.HashSet;

public final class b implements c, com.tencent.mm.kernel.b.c {
    private static b kHC;
    private static HashMap<Integer, d> kHz;
    private BroadcastReceiver hGD;
    private boolean hGE = false;
    private boolean hGF = true;
    private Runnable hGH;
    private com.tencent.mm.plugin.i.b.b kHA;
    private a kHB;
    private ag kHD;
    private com.tencent.mm.plugin.i.c.c kHE = null;
    public HashSet<Long> kHF = new HashSet();
    public boolean kHG = false;
    private boolean kHH = false;
    public com.tencent.mm.plugin.i.c.c kHI = null;
    com.tencent.mm.plugin.i.c.b kHJ = null;
    private HashMap<Integer, com.tencent.mm.plugin.i.a.a> kHK = new HashMap();
    private com.tencent.mm.plugin.i.c.c.a kHL = new 6(this);
    private com.tencent.mm.plugin.i.c.c.a kHM = new com.tencent.mm.plugin.i.c.c.a(this) {
        final /* synthetic */ b kHR;

        {
            this.kHR = r1;
        }

        public final void finish() {
            this.kHR.i(new 1(this));
        }
    };
    private com.tencent.mm.plugin.messenger.foundation.a.a.c.a kHN = new com.tencent.mm.plugin.messenger.foundation.a.a.c.a(this) {
        final /* synthetic */ b kHR;

        {
            this.kHR = r1;
        }

        public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.c cVar, com.tencent.mm.plugin.messenger.foundation.a.a.c.c cVar2) {
            if (cVar != null && cVar2 != null && cVar2.ooV != null) {
                this.kHR.i(new 1(this, cVar2));
            }
        }
    };
    private com.tencent.mm.sdk.b.c<cb> kHO = new 11(this);
    private boolean kHP = false;
    private com.tencent.mm.sdk.b.c<bl> kHQ = new 3(this);

    static /* synthetic */ boolean e(b bVar) {
        return (bVar.kHH || !bVar.hGE || bVar.hGF) ? false : true;
    }

    static {
        HashMap hashMap = new HashMap();
        kHz = hashMap;
        hashMap.put(Integer.valueOf("WXFILEINDEX_TABLE".hashCode()), new 1());
    }

    public static synchronized b asG() {
        b bVar;
        synchronized (b.class) {
            if (kHC == null) {
                kHC = new b();
            }
            bVar = kHC;
        }
        return bVar;
    }

    public final com.tencent.mm.plugin.i.b.b asH() {
        if (this.kHA == null) {
            this.kHA = new com.tencent.mm.plugin.i.b.b(this.kHB);
        }
        return this.kHA;
    }

    public final void i(Runnable runnable) {
        if (this.kHD != null) {
            this.kHD.F(runnable);
            return;
        }
        x.w("MicroMsg.CalcWxService", "%s post runnable but thread is null ", new Object[]{asN()});
    }

    public final void dX(boolean z) {
        boolean z2 = false;
        String str = "MicroMsg.CalcWxService";
        String str2 = "%s manual scan now manualScanTask[%b] uiClick[%b]";
        Object[] objArr = new Object[3];
        objArr[0] = asN();
        if (this.kHI != null) {
            z2 = true;
        }
        objArr[1] = Boolean.valueOf(z2);
        objArr[2] = Boolean.valueOf(z);
        x.d(str, str2, objArr);
        i(new 4(this, z));
    }

    private void arf() {
        i(new 8(this));
    }

    public final void onAccountInitialized(e.c cVar) {
        x.i("MicroMsg.CalcWxService", "%s CalcWxService Initialized", new Object[]{asN()});
        if (this.kHD == null) {
            x.i("MicroMsg.CalcWxService", "%s init calc wx thread", new Object[]{asN()});
            this.kHD = new ag("calc-wx");
        }
        this.kHB = g.a(hashCode(), com.tencent.mm.kernel.g.Dj().cachePath + "WxFileIndex.db", kHz, true);
        this.kHK.put(Integer.valueOf(43), new com.tencent.mm.plugin.i.a.e());
        this.kHK.put(Integer.valueOf(62), new com.tencent.mm.plugin.i.a.e());
        this.kHK.put(Integer.valueOf(44), new com.tencent.mm.plugin.i.a.e());
        this.kHK.put(Integer.valueOf(34), new f());
        this.kHK.put(Integer.valueOf(3), new com.tencent.mm.plugin.i.a.d());
        this.kHK.put(Integer.valueOf(49), new com.tencent.mm.plugin.i.a.c());
        this.kHK.put(Integer.valueOf(268435505), new com.tencent.mm.plugin.i.a.b());
        asI();
        ((h) com.tencent.mm.kernel.g.h(h.class)).aZi().a(this.kHN, null);
        com.tencent.mm.sdk.b.a.xef.a(this.kHO);
        Context context = ac.getContext();
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra(DownloadInfo.STATUS, -1);
            boolean z = intExtra == 2 || intExtra == 5;
            this.hGE = z;
        } else {
            this.hGE = false;
        }
        this.hGF = ((PowerManager) context.getSystemService("power")).isScreenOn();
        this.hGD = new 2(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        context.registerReceiver(this.hGD, intentFilter);
        com.tencent.mm.sdk.b.a.xef.a(this.kHQ);
        if (this.kHP) {
            com.tencent.mm.sdk.b.a.xef.m(new bl());
        }
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.CalcWxService", "CalcWxService Release");
        this.kHF.clear();
        this.kHG = false;
        if (this.kHB != null) {
            this.kHB.iV(hashCode());
            this.kHB = null;
        }
        ((h) com.tencent.mm.kernel.g.h(h.class)).aZi().a(this.kHN);
        com.tencent.mm.sdk.b.a.xef.c(this.kHO);
        this.kHK.clear();
        if (this.hGD != null) {
            ac.getContext().unregisterReceiver(this.hGD);
            this.hGD = null;
        }
        if (this.hGH != null) {
            ar.Dm();
            ag.K(this.hGH);
            this.hGH = null;
        }
        arf();
        if (this.kHD != null) {
            x.i("MicroMsg.CalcWxService", "%s quit calc wx thread", new Object[]{asN()});
            this.kHD.oAt.quit();
        }
        this.kHD = null;
        com.tencent.mm.sdk.b.a.xef.c(this.kHQ);
    }

    public static long asI() {
        long longValue = ((Long) com.tencent.mm.kernel.g.Dj().CU().get(w.a.xwl, Long.valueOf(-1))).longValue();
        if (longValue > -1) {
            return longValue;
        }
        longValue = ((h) com.tencent.mm.kernel.g.h(h.class)).aZi().EX("message");
        com.tencent.mm.kernel.g.Dj().CU().a(w.a.xwl, Long.valueOf(longValue));
        return longValue;
    }

    public final boolean asJ() {
        boolean z = asL() >= asI();
        x.i("MicroMsg.CalcWxService", "%d scan finish [%d %d %b]", new Object[]{Integer.valueOf(hashCode()), Long.valueOf(asI()), Long.valueOf(asL()), Boolean.valueOf(z)});
        if (z && ((Long) com.tencent.mm.kernel.g.Dj().CU().get(w.a.xwo, Long.valueOf(0))).longValue() <= 0) {
            com.tencent.mm.kernel.g.Dj().CU().a(w.a.xwo, Long.valueOf(bh.Wo()));
        }
        return z;
    }

    public final void asK() {
        this.kHG = false;
        this.kHF.clear();
        x.d("MicroMsg.CalcWxService", "%d unlock msg change [%s]", new Object[]{Integer.valueOf(hashCode()), bh.cgy()});
    }

    public final void H(au auVar) {
        if (auVar != null) {
            try {
                com.tencent.mm.plugin.i.a.a aVar = (com.tencent.mm.plugin.i.a.a) this.kHK.get(Integer.valueOf(auVar.getType()));
                if (aVar != null) {
                    aVar.I(auVar);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.CalcWxService", e, "", new Object[0]);
                com.tencent.mm.plugin.report.service.g.pQN.a(664, 5, 1, false);
            }
        }
    }

    public static void p(int i, long j) {
        int i2;
        int i3 = 30;
        if (j <= 1000) {
            i2 = i + 5;
        } else {
            i2 = i - 5;
        }
        if (i2 <= 30) {
            i3 = i2;
        }
        if (i3 < 5) {
            i3 = 5;
        }
        com.tencent.mm.kernel.g.Dj().CU().a(w.a.xwj, Integer.valueOf(i3));
        com.tencent.mm.plugin.report.service.g.pQN.a(664, (long) ((Integer) com.tencent.mm.plugin.report.service.g.a(i3, new int[]{5, 10, 20, 25, 30}, 10, 15)).intValue(), 1, false);
    }

    public final void bO(long j) {
        x.d("MicroMsg.CalcWxService", "%d update scan msgid[%d]", new Object[]{Integer.valueOf(hashCode()), Long.valueOf(j)});
        com.tencent.mm.kernel.g.Dj().CU().a(w.a.xwk, Long.valueOf(j));
    }

    public static long asL() {
        return ((Long) com.tencent.mm.kernel.g.Dj().CU().get(w.a.xwk, Long.valueOf(0))).longValue();
    }

    public static int asM() {
        return ((Integer) com.tencent.mm.kernel.g.Dj().CU().get(w.a.xwj, Integer.valueOf(5))).intValue();
    }

    public final String asN() {
        return hashCode();
    }
}
