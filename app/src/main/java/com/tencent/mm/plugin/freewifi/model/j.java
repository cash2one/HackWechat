package com.tencent.mm.plugin.freewifi.model;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.RemoteException;
import com.tencent.mm.by.h.d;
import com.tencent.mm.g.a.ad;
import com.tencent.mm.g.a.ae;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.freewifi.g.f;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import com.tencent.mm.z.bs;
import java.util.HashMap;

public final class j implements ap {
    private static HashMap<Integer, d> gwY;
    private c bannerOnInitListener = new c<ad>(this) {
        final /* synthetic */ j mEM;

        {
            this.mEM = r2;
            this.xen = ad.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            b aeVar = new ae();
            aeVar.fnV.fnX = new a(ac.getContext());
            com.tencent.mm.sdk.b.a.xef.m(aeVar);
            return false;
        }
    };
    private bs.a lNW = new 4(this);
    private volatile f mEA;
    private volatile c mEB;
    private volatile c mEC;
    private volatile a mED;
    private volatile e mEE;
    private n mEF = new 7(this);
    private c mEG = new 8(this);
    private c mEH = new 9(this);
    private c mEI = new 10(this);
    private c mEJ = new 11(this);
    private c mEK = new 12(this);
    private c mEL = new 2(this);
    private volatile d mEx;
    private volatile com.tencent.mm.plugin.freewifi.g.d mEy;
    private volatile com.tencent.mm.plugin.freewifi.g.b mEz;

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("FREEWIFIINFO_TABLE".hashCode()), new 1());
        gwY.put(Integer.valueOf("FREEWIFICONFIG_TABLE".hashCode()), new 5());
        gwY.put(Integer.valueOf("FREEWIFILOG_TABLE".hashCode()), new 6());
    }

    public static j aLM() {
        ar.Ha();
        j jVar = (j) bp.hY("plugin.freewifi");
        if (jVar != null) {
            return jVar;
        }
        x.w("MicroMsg.FreeWifi.SubCoreFreeWifi", "not found in MMCore, new one");
        Object jVar2 = new j();
        ar.Ha().a("plugin.freewifi", jVar2);
        return jVar2;
    }

    public static d aLN() {
        g.Dh().Ct();
        if (aLM().mEx == null) {
            aLM().mEx = new d();
        }
        return aLM().mEx;
    }

    public static com.tencent.mm.plugin.freewifi.g.d aLO() {
        g.Dh().Ct();
        if (aLM().mEy == null) {
            j aLM = aLM();
            ar.Hg();
            aLM.mEy = new com.tencent.mm.plugin.freewifi.g.d(com.tencent.mm.z.c.EV());
        }
        return aLM().mEy;
    }

    public static com.tencent.mm.plugin.freewifi.g.b aLP() {
        g.Dh().Ct();
        if (aLM().mEz == null) {
            j aLM = aLM();
            ar.Hg();
            aLM.mEz = new com.tencent.mm.plugin.freewifi.g.b(com.tencent.mm.z.c.EV());
        }
        return aLM().mEz;
    }

    public static f aLQ() {
        g.Dh().Ct();
        if (aLM().mEA == null) {
            j aLM = aLM();
            ar.Hg();
            aLM.mEA = new f(com.tencent.mm.z.c.EV());
        }
        return aLM().mEA;
    }

    public static c aLR() {
        g.Dh().Ct();
        if (aLM().mEB == null) {
            aLM().mEB = new c();
        }
        return aLM().mEB;
    }

    public static c aLS() {
        g.Dh().Ct();
        if (aLM().mEC == null) {
            aLM().mEC = new c();
        }
        return aLM().mEC;
    }

    public static synchronized a aLT() {
        a aVar;
        synchronized (j.class) {
            g.Dh().Ct();
            if (aLM().mED == null) {
                aLM().mED = new a();
            }
            aVar = aLM().mED;
        }
        return aVar;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        ar.getSysCmdMsgExtension().a("freewifi", this.lNW, true);
        ar.a(this.mEF);
        com.tencent.mm.sdk.b.a.xef.b(this.mEG);
        com.tencent.mm.sdk.b.a.xef.b(this.mEH);
        com.tencent.mm.sdk.b.a.xef.b(this.mEI);
        com.tencent.mm.sdk.b.a.xef.b(this.mEJ);
        com.tencent.mm.sdk.b.a.xef.b(this.mEK);
        com.tencent.mm.sdk.b.a.xef.b(this.mEL);
        com.tencent.mm.sdk.b.a.xef.b(this.bannerOnInitListener);
        try {
            this.mEF.eq(-9);
        } catch (RemoteException e) {
            x.e("MicroMsg.FreeWifi.SubCoreFreeWifi", "netChanged.onNetworkChange(NETWORK_ACCOUNT_POST_RESET) error. e.getMessage()=" + e.getMessage());
        }
        b aLy = b.b.aLy();
        x.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "initialized");
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) ac.getContext().getSystemService("connectivity");
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            x.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi=%s", new Object[]{networkInfo.toString()});
            IntentFilter intentFilter;
            if (networkInfo == null || !networkInfo.isConnected()) {
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                x.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoMobile=%s", new Object[]{networkInfo2.toString()});
                if (networkInfo2 != null && networkInfo2.isConnected()) {
                    b.a aVar = new b.a((byte) 0);
                    aVar.mDY = System.currentTimeMillis();
                    aVar.type = 0;
                    aVar.ssid = "";
                    aVar.bssid = "";
                    aVar.mDZ = m.AC(networkInfo2.getExtraInfo());
                    b.a(aLy.mDV.aLx(), aVar);
                    aLy.mDV = aVar;
                }
                intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                aLy.aKS();
                ac.getContext().registerReceiver(aLy.mDW, intentFilter);
            }
            WifiInfo connectionInfo = ((WifiManager) ac.getContext().getSystemService("wifi")).getConnectionInfo();
            String AB = m.AB(connectionInfo.getSSID());
            String toLowerCase = m.AC(connectionInfo.getBSSID()).toLowerCase();
            b.a aVar2 = new b.a((byte) 0);
            aVar2.mDY = System.currentTimeMillis();
            aVar2.type = 1;
            aVar2.ssid = AB;
            aVar2.bssid = toLowerCase;
            aVar2.mDZ = "";
            b.b(aLy.mDV.aLx(), aVar2);
            aLy.mDV = aVar2;
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            aLy.aKS();
            ac.getContext().registerReceiver(aLy.mDW, intentFilter);
        } catch (Exception e2) {
            k.a aLe = k.aLe();
            aLe.fpz = "UnExpectedException";
            aLe.result = -1;
            aLe.kZo = m.e(e2);
            aLe.aLg().aLf();
            x.e("MicroMsg.FreeWifi.UnExcepctedException", m.f(e2));
        }
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        ar.getSysCmdMsgExtension().b("freewifi", this.lNW, true);
        aLN();
        d.release();
        aLR().release();
        ar.b(this.mEF);
        com.tencent.mm.sdk.b.a.xef.c(this.mEG);
        com.tencent.mm.sdk.b.a.xef.c(this.mEH);
        com.tencent.mm.sdk.b.a.xef.c(this.mEI);
        com.tencent.mm.sdk.b.a.xef.c(this.mEJ);
        com.tencent.mm.sdk.b.a.xef.c(this.mEK);
        com.tencent.mm.sdk.b.a.xef.c(this.mEL);
        com.tencent.mm.sdk.b.a.xef.c(this.bannerOnInitListener);
        b.b.aLy().aKS();
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    public static e aLU() {
        g.Dh().Ct();
        if (aLM().mEE == null) {
            aLM().mEE = new e();
        }
        return aLM().mEE;
    }
}
