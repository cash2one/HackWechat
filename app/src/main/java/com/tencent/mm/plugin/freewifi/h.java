package com.tencent.mm.plugin.freewifi;

import android.net.Uri;
import com.tencent.mm.plugin.freewifi.g.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.c.ad;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public final class h {
    private String aBs;
    private b mCf;

    enum a {
        version("version", "2"),
        httpConnectTimeoutMillis("httpConnectTimeoutMillis", "5000"),
        httpReadTimeoutMillis("httpReadTimeoutMillis", "5000"),
        pingEnabled("pingEnabled", "1"),
        pingUrl("pingUrl", "http://o2o.gtimg.com/wifi/echo"),
        threeTwoBlackUrl("threeTwoBlackUrl", "http://o2o.gtimg.com/wifi/echo.html");
        
        String aAM;
        String mCm;

        private a(String str, String str2) {
            this.aAM = str;
            this.mCm = str2;
        }
    }

    private h() {
        this.mCf = j.aLP();
    }

    public final synchronized void a(ad adVar) {
        aKV();
        if (adVar == null || adVar.vEs == null) {
            x.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config is null.");
        } else {
            this.mCf.aMp();
            if (adVar.vEs.version == -1) {
                this.mCf.Tt();
                x.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "all local config data deleted.");
                this.mCf.aMp();
            } else if (adVar.vEs.version > aKW()) {
                x.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.version is %d, local version is %d.", new Object[]{Integer.valueOf(adVar.vEs.version), Integer.valueOf(aKW())});
                x.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.version = %d " + adVar.vEs.version);
                x.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.httpConnectTimeoutMillis = %d " + adVar.vEs.vXD);
                x.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.httpReadTimeoutMillis = %d " + adVar.vEs.vXE);
                x.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.pingUrl = %s " + adVar.vEs.fpy);
                x.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.pingEnabled = %s " + adVar.vEs.fpx);
                x.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.ThreeTwoBlackUrl = %s " + adVar.vEs.vXF);
                pS(adVar.vEs.vXD);
                pT(adVar.vEs.vXE);
                Ax(adVar.vEs.fpy);
                Aw(adVar.vEs.fpx);
                Ay(adVar.vEs.vXF);
                pR(adVar.vEs.version);
                x.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "local config data changed.");
                this.mCf.aMp();
            }
        }
    }

    private synchronized void aKV() {
        try {
            String AP = this.mCf.AP(a.version.aAM);
            if (!m.AA(AP) && Integer.valueOf(AP).intValue() < Integer.valueOf(a.version.mCm).intValue()) {
                pS(Integer.valueOf(a.httpConnectTimeoutMillis.mCm).intValue());
                pT(Integer.valueOf(a.httpReadTimeoutMillis.mCm).intValue());
                Ax(a.pingUrl.mCm);
                Aw(a.pingEnabled.mCm);
                Ay(a.threeTwoBlackUrl.mCm);
                pR(Integer.valueOf(a.version.mCm).intValue());
            }
        } catch (Exception e) {
            x.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "updateDiskDbCacheIfLowerThanDefault exception. " + m.f(e));
        }
    }

    public final synchronized int aKW() {
        int intValue;
        aKV();
        try {
            String AP = this.mCf.AP(a.version.aAM);
            if (m.AA(AP)) {
                intValue = Integer.valueOf(a.version.mCm).intValue();
            } else {
                intValue = Integer.valueOf(AP).intValue();
            }
        } catch (Exception e) {
            intValue = Integer.valueOf(a.version.mCm).intValue();
        }
        return intValue;
    }

    private synchronized void pR(int i) {
        if (i > Integer.valueOf(a.version.mCm).intValue()) {
            j.aLP().cD(a.version.aAM, String.valueOf(i));
        }
    }

    public final int aKX() {
        aKV();
        try {
            String AP = this.mCf.AP(a.httpConnectTimeoutMillis.aAM);
            if (m.AA(AP)) {
                return Integer.valueOf(a.httpConnectTimeoutMillis.mCm).intValue();
            }
            return Integer.valueOf(AP).intValue();
        } catch (Exception e) {
            return Integer.valueOf(a.httpConnectTimeoutMillis.mCm).intValue();
        }
    }

    private static void pS(int i) {
        if (i > 0) {
            j.aLP().cD(a.httpConnectTimeoutMillis.aAM, String.valueOf(i));
        }
    }

    public final int aKY() {
        aKV();
        try {
            String AP = this.mCf.AP(a.httpReadTimeoutMillis.aAM);
            if (m.AA(AP)) {
                return Integer.valueOf(a.httpReadTimeoutMillis.mCm).intValue();
            }
            return Integer.valueOf(AP).intValue();
        } catch (Exception e) {
            return Integer.valueOf(a.httpReadTimeoutMillis.mCm).intValue();
        }
    }

    private void pT(int i) {
        if (i > 0) {
            this.mCf.cD(a.httpReadTimeoutMillis.aAM, String.valueOf(i));
        }
    }

    public final String aKZ() {
        aKV();
        try {
            if ("0".equals(this.mCf.AP(a.pingEnabled.aAM))) {
                return "0";
            }
            return "1";
        } catch (Exception e) {
            return a.pingEnabled.mCm;
        }
    }

    private void Aw(String str) {
        if ("0".equals(str) || "1".equals(str)) {
            try {
                this.mCf.cD(a.pingEnabled.aAM, str);
            } catch (Exception e) {
            }
        }
    }

    public final String aLa() {
        aKV();
        try {
            String AP = this.mCf.AP(a.pingUrl.aAM);
            if (m.AA(AP)) {
                return a.pingUrl.mCm;
            }
            Uri.parse(AP);
            return AP;
        } catch (Exception e) {
            return a.pingUrl.mCm;
        }
    }

    private void Ax(String str) {
        if (!m.AA(str)) {
            try {
                Uri.parse(str);
                this.mCf.cD(a.pingUrl.aAM, str);
            } catch (Exception e) {
            }
        }
    }

    public final String aLb() {
        aKV();
        try {
            String AP = this.mCf.AP(a.threeTwoBlackUrl.aAM);
            if (m.AA(AP)) {
                return a.threeTwoBlackUrl.mCm;
            }
            Uri.parse(AP);
            return AP;
        } catch (Exception e) {
            return a.threeTwoBlackUrl.mCm;
        }
    }

    private void Ay(String str) {
        if (!m.AA(str)) {
            try {
                Uri.parse(str);
                this.mCf.cD(a.threeTwoBlackUrl.aAM, str);
            } catch (Exception e) {
            }
        }
    }

    public final String getUserAgent() {
        if (m.AA(this.aBs)) {
            this.aBs = s.aL(ac.getContext(), null).toLowerCase();
        }
        return this.aBs;
    }
}
