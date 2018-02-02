package com.tencent.mm.plugin.ipcall.a.c;

import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public String countryCode = "";
    public String ikY = "";
    public long nCi = 0;
    public int nDA = 0;
    public int nDx = 0;
    public long nDy = 0;
    public int nEN = 0;
    public int nEO = 0;
    public int nEP = 0;
    public int nEQ = 0;
    public int nER = 0;
    public long nES = 0;
    public long nET = 0;
    public int nEU = 0;
    public long nEV = 0;
    public int nEW = 0;
    public long nEX = 0;
    public int nEY = 0;
    public String nEZ = "";
    public long nFa = 0;
    public long nFb = 0;
    public long nFc = 0;
    public long nFd = 0;
    public String nFe = "";
    public String nFf = "";
    public String nFg = "";
    public long nFh = 0;
    public long nFi = 0;
    public long nFj = 0;
    public int nFk = 0;
    public int nFl = 0;
    public int nFm = 0;
    public int nFn = 0;

    public final void aTV() {
        x.i("MicroMsg.IPCallReportHelper", "selfShutdown");
        this.nER = 1;
    }

    public final void aTW() {
        x.i("MicroMsg.IPCallReportHelper", "selfCancel");
        this.nEQ = 1;
        if (this.nFj == 0 && this.nFa != 0) {
            this.nFj = System.currentTimeMillis() - this.nFa;
            x.d("MicroMsg.IPCallReportHelper", "cancelTime: %d", new Object[]{Long.valueOf(this.nFj)});
        }
    }

    public final void aTX() {
        x.i("MicroMsg.IPCallReportHelper", "channelConnect");
        this.nEU = 1;
    }

    public final void aTY() {
        if (this.nFm == 0) {
            this.nFm = 1;
        }
    }

    public final void aTZ() {
        x.d("MicroMsg.IPCallReportHelper", "markConnect");
        if (this.nFh == 0) {
            this.nFh = System.currentTimeMillis();
            this.nFi = this.nFh - this.nFa;
            x.d("MicroMsg.IPCallReportHelper", "connectTime: %d", new Object[]{Long.valueOf(this.nFi)});
        }
    }

    public final void aUa() {
        x.d("MicroMsg.IPCallReportHelper", "markStartTalk");
        if (this.nFc == 0) {
            this.nFc = System.currentTimeMillis();
        }
    }
}
