package com.tencent.mm.plugin.ext;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Looper;
import com.tencent.mm.by.h.d;
import com.tencent.mm.compatible.d.m;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.g.a.eq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;

public class b implements ap {
    private static HashMap<Integer, d> gwY;
    private static boolean lZE = false;
    com.tencent.mm.sdk.e.m.b lNX = new 10(this);
    private af lZA = new 8(this, Looper.getMainLooper());
    private a lZB = new 9(this);
    private boolean lZC = true;
    private boolean lZD = false;
    private final long lZo = 1600;
    private t lZp;
    private bb lZq;
    private bk lZr;
    private a lZs;
    private b lZt;
    private HashMap<String, Integer> lZu = new HashMap();
    private c.a lZv = new 5(this);
    j.a lZw = new 6(this);
    private af lZx = new 7(this, Looper.getMainLooper());
    private LinkedList<String> lZy = new LinkedList();
    private final long lZz = 60;

    static {
        int yp = m.yp();
        try {
            if (!Build.CPU_ABI.contains("armeabi")) {
                x.e("hakon SilkCodec", "x86 machines not supported.");
            } else if ((yp & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                k.b("wechatvoicesilk_v7a", b.class.getClassLoader());
            } else if ((yp & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
                k.b("wechatvoicesilk", b.class.getClassLoader());
            } else {
                x.e("hakon SilkCodec", "load library failed! silk don't support armv5!!!!");
            }
        } catch (Exception e) {
            x.e("hakon SilkCodec", "load library failed!");
        }
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("OPENMSGLISTENER_TABLE".hashCode()), new 1());
        gwY.put(Integer.valueOf("USEROPENIDINAPP_TABLE".hashCode()), new 3());
    }

    public static b aFz() {
        ar.Ha();
        b bVar = (b) bp.hY("plugin.ext");
        if (bVar != null) {
            return bVar;
        }
        Object bVar2 = new b();
        ar.Ha().a("plugin.ext", bVar2);
        return bVar2;
    }

    public static t aFA() {
        g.Dh().Ct();
        if (aFz().lZp == null) {
            b aFz = aFz();
            ar.Hg();
            aFz.lZp = new t(com.tencent.mm.z.c.EV());
        }
        return aFz().lZp;
    }

    public static bb aFB() {
        g.Dh().Ct();
        if (aFz().lZq == null) {
            b aFz = aFz();
            ar.Hg();
            aFz.lZq = new bb(com.tencent.mm.z.c.EV());
        }
        return aFz().lZq;
    }

    public static bk aFC() {
        g.Dh().Ct();
        if (aFz().lZr == null) {
            b aFz = aFz();
            ar.Hg();
            aFz.lZr = new bk(com.tencent.mm.z.c.EV());
        }
        return aFz().lZr;
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    public final void br(boolean z) {
        aFD();
    }

    private static void aFD() {
        File file = new File(g.Dj().gQi);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(g.Dj().gQi + "image/ext/pcm");
        if (!file.exists()) {
            file.mkdirs();
        }
        x.i("MicroMsg.SubCoreExt", "summerpcm accPath[%s] [%s]", g.Dj().gQi, bh.cgy());
    }

    public final void bq(boolean z) {
        com.tencent.mm.sdk.b.b eqVar = new eq();
        eqVar.fth.op = 1;
        if (!com.tencent.mm.sdk.b.a.xef.m(eqVar)) {
            x.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountPostReset");
        }
        j.bYn().bYo();
        ar.Hg();
        com.tencent.mm.z.c.Fa().a(this.lZv, null);
        if (this.lZs == null) {
            this.lZs = new a();
        }
        com.tencent.mm.sdk.b.a.xef.b(this.lZs);
        if (this.lZt == null) {
            this.lZt = new b();
        }
        com.tencent.mm.sdk.b.a.xef.b(this.lZt);
        i bin = an.bin();
        if (bin != null) {
            bin.c(this.lZB);
        }
        SharedPreferences cft = ac.cft();
        this.lZD = cft.getBoolean("hasTryToInitVoiceControlData", false);
        lZE = cft.getBoolean("hasCallVoiceControlApi", false);
        x.i("MicroMsg.SubCoreExt", "onAccountPostReset,hasTryToInit:%s,hasCallApi:%s", Boolean.valueOf(this.lZD), Boolean.valueOf(lZE));
        ar.Hg();
        com.tencent.mm.z.c.EY().a(this.lNX);
        eM(true);
        com.tencent.mm.plugin.ext.c.c.aFU();
        aFD();
    }

    public final void onAccountRelease() {
        if (this.lZs != null) {
            com.tencent.mm.sdk.b.a.xef.c(this.lZs);
        }
        if (this.lZt != null) {
            com.tencent.mm.sdk.b.a.xef.c(this.lZt);
        }
        i bin = an.bin();
        if (bin != null) {
            bin.j(this.lZB);
        }
        ar.Hg();
        com.tencent.mm.z.c.Fa().a(this.lZv);
        com.tencent.mm.sdk.b.b eqVar = new eq();
        eqVar.fth.op = 2;
        if (!com.tencent.mm.sdk.b.a.xef.m(eqVar)) {
            x.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountRelease");
        }
        com.tencent.mm.pluginsdk.model.app.t bYn = j.bYn();
        if (ar.Hj()) {
            j.vdo = false;
            an.aRi().b(14, bYn);
        }
        ar.Hg();
        com.tencent.mm.z.c.EY().b(this.lNX);
        com.tencent.mm.plugin.ext.c.c.aFV();
    }

    public static String aFE() {
        return g.Dj().gQi + "image/ext/pcm";
    }

    public static void aFF() {
        String str = (String) aFA().get(w.a.USERINFO_EXT_SPORT_PKGNAME_STRING, null);
        x.i("MicroMsg.SubCoreExt", "sendSportBroadcast pkgNames = " + str);
        if (str != null) {
            for (String str2 : str.split(";")) {
                Intent intent = new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_SET_SPORT_STEP");
                intent.setPackage(str2);
                com.tencent.mm.compatible.a.a.a(12, new 4(intent));
                intent.putExtra("EXTRA_EXT_OPEN_NOTIFY_TYPE", "SPORT_MESSAGE");
                ac.getContext().sendBroadcast(intent);
            }
        }
    }

    public final void gd(int i) {
    }

    public static com.tencent.mm.storage.x cM(long j) {
        if (!ar.Hj() || j <= 0) {
            return null;
        }
        ar.Hg();
        return com.tencent.mm.z.c.EY().fO(j);
    }

    public static void cN(long j) {
        if (j > 0) {
            try {
                ar.Hg();
                if (com.tencent.mm.z.c.Fa().dK(j)) {
                    ar.Hg();
                    c Fa = com.tencent.mm.z.c.Fa();
                    ar.Hg();
                    Fa.R(com.tencent.mm.z.c.Fa().dH(j));
                    return;
                }
                x.e("MicroMsg.SubCoreExt", "msgId is out of range, " + j);
            } catch (Throwable e) {
                x.e("MicroMsg.SubCoreExt", e.getMessage());
                x.printErrStackTrace("MicroMsg.SubCoreExt", e, "", new Object[0]);
            }
        }
    }

    public final void aFG() {
        this.lZx.removeMessages(0);
        this.lZx.sendEmptyMessageDelayed(0, 1600);
    }

    private void eM(boolean z) {
        if (!this.lZC) {
            return;
        }
        if (z && this.lZD) {
            x.i("MicroMsg.SubCoreExt", "fromStartApp and already try to init");
        } else if (z || lZE) {
            x.i("MicroMsg.SubCoreExt", "initLocalVoiceControl,fromStartApp:%s,hasTryToInit:%s,hasCallApi:%s", Boolean.valueOf(z), Boolean.valueOf(this.lZD), Boolean.valueOf(lZE));
            this.lZC = false;
            ar.Dm().g(new 2(this), 10000);
        }
    }
}
