package com.tencent.mm.plugin.appbrand.appcache;

import android.os.SystemClock;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import com.tencent.mm.plugin.appbrand.appcache.i.1;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiBatchGetContact;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.appbrand.launching.f;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.report.a.l;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.regex.Pattern;

final class i$a implements p$a {
    private final ab iEd;
    private final int iEe;
    private final boolean iEf;
    private a iEg;
    private ArrayList<IDKey> iEh;
    private long iEi;
    private long iEj;
    private long iEk;
    private l iEl;

    private i$a(ab abVar) {
        this.iEi = 0;
        this.iEj = 0;
        this.iEk = 0;
        this.iEd = abVar;
        this.iEe = i.pA(abVar.appId) ? 776 : 368;
        String[] split = abVar.appId.split(Pattern.quote("$"));
        this.iEf = (split == null ? -1 : split.length) == 2;
    }

    private void jx(int i) {
        bw(this.iEe, i);
    }

    private void bw(int i, int i2) {
        if (this.iEh == null) {
            this.iEh = new ArrayList();
        }
        this.iEh.add(new IDKey(i, i2, 1));
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
        if (this.iEd instanceof x) {
            this.iEg = "@LibraryAppId".equals(this.iEd.appId) ? a.iEq : a.iEp;
            this.iEl = new l(this.iEd.appId, ((x) this.iEd).iEZ, ((x) this.iEd).iFa);
            this.iEl.jIN = bh.Wp();
        } else if ("@LibraryAppId".equals(this.iEd.appId)) {
            this.iEg = a.iEo;
        } else if (a.jv(this.iEd.fvM)) {
            WxaPkgWrappingInfo sZ = f.sZ(this.iEd.appId);
            this.iEg = sZ != null ? a.iEn : a.iEm;
            this.iEl = new l(this.iEd.appId, sZ == null ? 0 : sZ.iGL, this.iEd.version);
            this.iEl.jIN = bh.Wp();
        } else {
            this.iEg = a.iEm;
        }
        switch (1.iEc[this.iEg.ordinal()]) {
            case 1:
                i = 1;
                break;
            case 2:
                i = 10;
                break;
            case 3:
                i = 20;
                break;
            case 4:
                i = 35;
                break;
            case 5:
                i = 46;
                break;
        }
        jx(i);
        this.iEi = SystemClock.elapsedRealtime();
    }

    public final void ZA() {
        jx(32);
    }

    public final void ZB() {
        int i;
        switch (1.iEc[this.iEg.ordinal()]) {
            case 3:
            case 5:
                i = 30;
                break;
            default:
                i = 31;
                break;
        }
        jx(i);
    }

    public final void a(com.tencent.mm.pluginsdk.i.a.d.l lVar) {
        int i;
        String str;
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.iEi;
        int i2 = (lVar == null || lVar.status != 2) ? 0 : 1;
        switch (1.iEc[this.iEg.ordinal()]) {
            case 1:
                jx(i2 != 0 ? 2 : 3);
                break;
            case 2:
                jx(i2 != 0 ? 11 : 12);
                break;
            case 3:
                jx(i2 != 0 ? 21 : 22);
                break;
            case 4:
                jx(i2 != 0 ? 36 : 37);
                break;
            case 5:
                jx(i2 != 0 ? 47 : 48);
                break;
        }
        if (!(i2 != 0 || "@LibraryAppId".equals(this.iEd.appId) || 999 == this.iEd.fvM)) {
            int i3;
            if (lVar == null || !(lVar.httpStatusCode == TencentLocation.ERROR_UNKNOWN || lVar.httpStatusCode == ap.CTRL_INDEX)) {
                i3 = 19;
            } else {
                i3 = 23;
            }
            com.tencent.mm.plugin.appbrand.report.a.z(this.iEd.appId, i3, this.iEd.fvM + 1);
        }
        if (lVar != null) {
            try {
                if (lVar.status == 2) {
                    i = 1;
                    str = (a.iEo != this.iEg || a.iEq == this.iEg) ? "" : this.iEd.appId;
                    com.tencent.mm.plugin.appbrand.report.a.a(str, this.iEg.value, i, elapsedRealtime, this.iEf);
                    AppBrandPerformanceManager.t(this.iEd.appId, elapsedRealtime);
                    ZJ();
                    if (this.iEl == null) {
                        return;
                    }
                    if (i2 != 0) {
                        this.iEl.akc();
                        if (this.iEd instanceof x) {
                            this.iEl.lu(0);
                        } else if (lVar != null) {
                            this.iEl.lu(3);
                        } else if (lVar.status != JsApiBatchGetContact.CTRL_INDEX) {
                            this.iEl.lu(1);
                        } else if (lVar.status == TencentLocation.ERROR_UNKNOWN) {
                            this.iEl.lu(2);
                        } else {
                            this.iEl.lu(3);
                        }
                        this.iEl.wW();
                    } else if (this.iEd instanceof x) {
                        this.iEl.jIM = e.bN(this.iEd.getFilePath());
                    } else {
                        this.iEl.jIL = e.bN(this.iEd.getFilePath());
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrand.PkgDownloadReporterImpl", e, "report onEnd, appId %s", this.iEd.appId);
            }
        }
        if (lVar != null) {
            if (lVar.status == 4) {
                i = 3;
                if (a.iEo != this.iEg) {
                }
                com.tencent.mm.plugin.appbrand.report.a.a(str, this.iEg.value, i, elapsedRealtime, this.iEf);
                AppBrandPerformanceManager.t(this.iEd.appId, elapsedRealtime);
                ZJ();
                if (this.iEl == null) {
                    if (i2 != 0) {
                        this.iEl.akc();
                        if (this.iEd instanceof x) {
                            this.iEl.lu(0);
                        } else if (lVar != null) {
                            this.iEl.lu(3);
                        } else if (lVar.status != JsApiBatchGetContact.CTRL_INDEX) {
                            this.iEl.lu(1);
                        } else if (lVar.status == TencentLocation.ERROR_UNKNOWN) {
                            this.iEl.lu(3);
                        } else {
                            this.iEl.lu(2);
                        }
                        this.iEl.wW();
                    } else if (this.iEd instanceof x) {
                        this.iEl.jIL = e.bN(this.iEd.getFilePath());
                    } else {
                        this.iEl.jIM = e.bN(this.iEd.getFilePath());
                    }
                }
                return;
            }
        }
        i = 2;
        if (a.iEo != this.iEg) {
        }
        com.tencent.mm.plugin.appbrand.report.a.a(str, this.iEg.value, i, elapsedRealtime, this.iEf);
        AppBrandPerformanceManager.t(this.iEd.appId, elapsedRealtime);
        ZJ();
        if (this.iEl == null) {
            return;
        }
        if (i2 != 0) {
            this.iEl.akc();
            if (this.iEd instanceof x) {
                this.iEl.lu(0);
            } else if (lVar != null) {
                this.iEl.lu(3);
            } else if (lVar.status != JsApiBatchGetContact.CTRL_INDEX) {
                this.iEl.lu(1);
            } else if (lVar.status == TencentLocation.ERROR_UNKNOWN) {
                this.iEl.lu(2);
            } else {
                this.iEl.lu(3);
            }
            this.iEl.wW();
        } else if (this.iEd instanceof x) {
            this.iEl.jIM = e.bN(this.iEd.getFilePath());
        } else {
            this.iEl.jIL = e.bN(this.iEd.getFilePath());
        }
    }

    public final void ZC() {
        this.iEk = SystemClock.elapsedRealtime();
        bw(697, 1);
    }

    public final void jw(int i) {
        SystemClock.elapsedRealtime();
        if (i == 0) {
            bw(697, 2);
        } else if (i < 0) {
            bw(697, -i);
        } else if (i == 1) {
            bw(697, 10);
        }
        ZJ();
        if (this.iEl == null) {
            return;
        }
        if (i != 0) {
            if (i == -4) {
                this.iEl.lu(4);
            } else {
                this.iEl.lu(5);
            }
            this.iEl.akc();
            this.iEl.wW();
            return;
        }
        this.iEl.jIL = e.bN(((x) this.iEd).ZS());
    }

    public final void ZD() {
        if (a.iEo != this.iEg && a.iEq != this.iEg) {
            com.tencent.mm.plugin.appbrand.report.a.z(this.iEd.appId, 20, this.iEd.fvM + 1);
        }
    }

    public final void ZE() {
        this.iEj = SystemClock.elapsedRealtime();
        switch (1.iEc[this.iEg.ordinal()]) {
            case 1:
                jx(5);
                return;
            case 2:
                jx(14);
                return;
            case 3:
                jx(24);
                return;
            case 4:
                jx(41);
                return;
            case 5:
                jx(49);
                return;
            default:
                return;
        }
    }

    public final void co(boolean z) {
        int i;
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.iEj;
        switch (1.iEc[this.iEg.ordinal()]) {
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
            case 3:
                if (!z) {
                    i = 26;
                    break;
                } else {
                    i = 25;
                    break;
                }
            case 4:
                if (!z) {
                    i = 43;
                    break;
                } else {
                    i = 42;
                    break;
                }
            case 5:
                if (!z) {
                    i = 51;
                    break;
                } else {
                    i = 50;
                    break;
                }
            default:
                i = 0;
                break;
        }
        jx(i);
        ZJ();
        String str = (a.iEo == this.iEg || a.iEq == this.iEg) ? "" : this.iEd.appId;
        com.tencent.mm.plugin.appbrand.report.a.a(str, this.iEg.value + 1, z ? 1 : 2, elapsedRealtime, this.iEf);
        if (!z) {
            com.tencent.mm.plugin.appbrand.report.a.z(this.iEd.appId, 22, this.iEd.fvM + 1);
        }
        if (this.iEl != null) {
            this.iEl.akc();
            if (this.iEg != a.iEp && this.iEg != a.iEq) {
                this.iEl.jIJ = z;
            } else if (z) {
                this.iEl.jIJ = true;
                this.iEl.jIK = true;
            } else {
                this.iEl.lu(6);
            }
            this.iEl.wW();
        }
    }
}
