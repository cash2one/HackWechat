package com.tencent.mm.plugin.appbrand.performance;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import android.util.SparseArray;
import android.view.Choreographer.FrameCallback;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.game.c.h;
import com.tencent.mm.plugin.appbrand.game.c.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiGetStorageInfoTask;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u;

@SuppressLint({"DefaultLocale"})
public final class AppBrandPerformanceManager {
    private static SparseArray<a> jFM = new SparseArray();

    private static class a implements Runnable {
        volatile boolean AW = true;
        private c iZc;
        volatile boolean iqR = false;
        private volatile double jFO = 0.0d;
        private volatile int jFP = 4;
        volatile boolean jFQ = false;
        d jFR;
        com.tencent.mm.plugin.appbrand.performance.d.a jFS = new 2(this);
        b jFT = new 3(this);
        private volatile boolean jsG = false;
        final String mAppId;

        public a(String str) {
            this.mAppId = str;
            this.iZc = new c(Process.myPid());
            e oQ = com.tencent.mm.plugin.appbrand.a.oQ(str);
            if (oQ != null && oQ.Yz()) {
                this.jsG = true;
            }
            if (ajs()) {
                this.jFR = new d();
                this.jFR.mInterval = 100;
                this.jFR.jFS = this.jFS;
            }
        }

        static boolean ajs() {
            return VERSION.SDK_INT >= 16;
        }

        public final void run() {
            if (this.AW && !this.iqR) {
                double aju = this.iZc.aju();
                AppBrandPerformanceManager.n(this.mAppId, 101, ((int) aju) + "%");
                a.a(this.mAppId, "Hardware", "CPU", aju);
                int cgD = bh.cgD();
                AppBrandPerformanceManager.n(this.mAppId, 102, cgD + "m");
                a.a(this.mAppId, "Hardware", "MEMORY", (double) cgD);
                if (this.jsG) {
                    synchronized (i.iZn) {
                        if (i.iZn.iZv) {
                            h aeh = i.iZn.aeh();
                            if (aeh != null) {
                                cgD = aeh.a(h.aeg());
                            }
                        }
                        cgD = Integer.MAX_VALUE;
                    }
                    if (cgD != Integer.MAX_VALUE) {
                        AppBrandPerformanceManager.n(this.mAppId, 103, cgD + "m");
                    }
                }
                this.jFP++;
                if (this.jFP >= 4) {
                    this.jFP = 0;
                    MainProcessTask jsApiGetStorageInfoTask = new JsApiGetStorageInfoTask();
                    jsApiGetStorageInfoTask.appId = this.mAppId;
                    jsApiGetStorageInfoTask.jcI = new 1(this, jsApiGetStorageInfoTask);
                    jsApiGetStorageInfoTask.afi();
                    AppBrandMainProcessService.a(jsApiGetStorageInfoTask);
                }
            }
            if (this.AW) {
                c.Dm().g(this, 3000);
            }
        }
    }

    private static class GetPkgDownloadCostTask extends MainProcessTask {
        public static final Creator<GetPkgDownloadCostTask> CREATOR = new 1();
        private long jFN;
        private String mAppId;

        private GetPkgDownloadCostTask() {
        }

        public final void Yr() {
            x.d("MicroMsg.AppBrandPerformanceManager", "try to get pkg download cost in main process.");
            String str = this.mAppId + "_PkgDownloadCost";
            com.tencent.mm.plugin.appbrand.config.c Zl = f.Zl();
            if (Zl == null) {
                x.e("MicroMsg.AppBrandPerformanceManager", "appBrandCommonKVDataStorage is null, return");
                afp();
                return;
            }
            String str2 = Zl.get(str, null);
            if (str2 != null) {
                f.Zl().aV(str, null);
                try {
                    this.jFN = Long.parseLong(str2);
                } catch (Exception e) {
                    x.e("MicroMsg.AppBrandPerformanceManager", "GetPkgDownloadCost error.");
                }
            }
            afp();
        }

        public final void Ys() {
            x.d("MicroMsg.AppBrandPerformanceManager", "received pkg download cost from main process: %d ms", new Object[]{Long.valueOf(this.jFN)});
            if (this.jFN != 0) {
                AppBrandPerformanceManager.a(this.mAppId, 201, this.jFN);
            }
            afj();
        }

        public final void f(Parcel parcel) {
            this.mAppId = parcel.readString();
            this.jFN = parcel.readLong();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mAppId);
            parcel.writeLong(this.jFN);
        }
    }

    private static class SetAppPerformanceModeTask extends MainProcessTask {
        public static final Creator<SetAppPerformanceModeTask> CREATOR = new 1();
        private String mAppId;
        private boolean mEnable;

        private SetAppPerformanceModeTask() {
        }

        public final void Yr() {
            f.Zl().aV(this.mAppId + "_PerformancePanelEnabled", this.mEnable ? "1" : "0");
        }

        public final void f(Parcel parcel) {
            this.mAppId = parcel.readString();
            this.mEnable = parcel.readByte() != (byte) 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mAppId);
            parcel.writeByte(this.mEnable ? (byte) 1 : (byte) 0);
        }
    }

    public static final void tQ(String str) {
        x.d("MicroMsg.AppBrandPerformanceManager", "startMonitoring, appId: %s", new Object[]{str});
        a aVar = (a) jFM.get(str.hashCode());
        if (aVar == null) {
            aVar = new a(str);
            jFM.put(str.hashCode(), aVar);
        }
        aVar.AW = true;
        c.Dm().F(aVar);
        com.tencent.mm.plugin.appbrand.c.a(aVar.mAppId, aVar.jFT);
        if (a.ajs() && aVar.jFR != null) {
            FrameCallback frameCallback = aVar.jFR;
            frameCallback.AW = true;
            frameCallback.jGh.postFrameCallback(frameCallback);
        }
        if (!aVar.jFQ) {
            MainProcessTask getPkgDownloadCostTask = new GetPkgDownloadCostTask();
            getPkgDownloadCostTask.mAppId = aVar.mAppId;
            AppBrandMainProcessService.a(getPkgDownloadCostTask);
            aVar.jFQ = true;
        }
    }

    public static final void tR(String str) {
        x.d("MicroMsg.AppBrandPerformanceManager", "enablePanel for AppId %s", new Object[]{str});
        SetAppPerformanceModeTask setAppPerformanceModeTask = new SetAppPerformanceModeTask();
        setAppPerformanceModeTask.mAppId = str;
        setAppPerformanceModeTask.mEnable = true;
        AppBrandMainProcessService.a(setAppPerformanceModeTask);
    }

    public static final void tS(String str) {
        x.d("MicroMsg.AppBrandPerformanceManager", "disablePanel for AppId %s", new Object[]{str});
        SetAppPerformanceModeTask setAppPerformanceModeTask = new SetAppPerformanceModeTask();
        setAppPerformanceModeTask.mAppId = str;
        setAppPerformanceModeTask.mEnable = false;
        AppBrandMainProcessService.a(setAppPerformanceModeTask);
    }

    public static final boolean tT(String str) {
        if (DebuggerShell.acg()) {
            return true;
        }
        AppBrandSysConfig oS = com.tencent.mm.plugin.appbrand.a.oS(str);
        if (oS != null && oS.iOj && oS.iOI.iGK == 1) {
            return true;
        }
        return false;
    }

    public static final void a(String str, int i, long j) {
        n(str, i, String.format("%d ms", new Object[]{Long.valueOf(j)}));
    }

    public static final void n(String str, int i, String str2) {
        com.tencent.mm.plugin.appbrand.ui.h oU = com.tencent.mm.plugin.appbrand.a.oU(str);
        if (oU == null) {
            u.GK().t(str.hashCode() + "performance_data", true).o(String.valueOf(i), str2);
        } else {
            oU.N(i, str2);
        }
    }

    public static final void D(String str, String str2, String str3) {
        com.tencent.mm.plugin.appbrand.ui.h oU = com.tencent.mm.plugin.appbrand.a.oU(str);
        if (oU == null) {
            u.GK().t(str.hashCode() + "performance_custom_data", true).o(str2, str3);
        } else {
            oU.bC(str2, str3);
        }
    }

    public static final void tU(String str) {
        com.tencent.mm.plugin.appbrand.ui.h oU = com.tencent.mm.plugin.appbrand.a.oU(str);
        u.b hy = u.GK().hy(str.hashCode() + "performance_data");
        if (oU == null) {
            x.e("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData panel is not ready.");
        } else if (hy == null) {
            x.d("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData cache is empty.");
        } else {
            for (String str2 : hy.GL()) {
                String str3 = (String) hy.get(str2);
                if (str3 != null) {
                    oU.N(Integer.valueOf(str2).intValue(), str3);
                }
            }
        }
        tV(str);
    }

    private static final void tV(String str) {
        com.tencent.mm.plugin.appbrand.ui.h oU = com.tencent.mm.plugin.appbrand.a.oU(str);
        u.b hy = u.GK().hy(str.hashCode() + "performance_custom_data");
        if (oU == null) {
            x.e("MicroMsg.AppBrandPerformanceManager", "insertCachedCustomData panel is not ready.");
        } else if (hy == null) {
            x.d("MicroMsg.AppBrandPerformanceManager", "insertCachedCustomData cache is empty.");
        } else {
            for (String str2 : hy.GL()) {
                String str3 = (String) hy.get(str2);
                if (str3 != null) {
                    oU.bC(str2, str3);
                }
            }
        }
    }

    public static final void t(String str, long j) {
        f.Zl().aV(str + "_PkgDownloadCost", String.valueOf(j));
    }
}
