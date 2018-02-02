package com.tencent.mm.plugin.appbrand.task;

import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public class AppBrandRemoteTaskController extends MainProcessTask {
    public static final Creator<AppBrandRemoteTaskController> CREATOR = new Creator<AppBrandRemoteTaskController>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppBrandRemoteTaskController appBrandRemoteTaskController = new AppBrandRemoteTaskController();
            appBrandRemoteTaskController.f(parcel);
            return appBrandRemoteTaskController;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandRemoteTaskController[i];
        }
    };
    private static long jJI;
    public b irc = null;
    public c irr = null;
    public String jJE;
    public int jJF = a.jJK;
    public int jJG;
    public long jJH;
    public int jxk;
    public String mAppId;

    private enum a {
        ;

        public static int[] akt() {
            return (int[]) jJV.clone();
        }

        static {
            jJK = 1;
            jJL = 2;
            jJM = 3;
            jJN = 4;
            jJO = 5;
            jJP = 6;
            jJQ = 7;
            jJR = 8;
            jJS = 9;
            jJT = 10;
            jJU = 11;
            jJV = new int[]{jJK, jJL, jJM, jJN, jJO, jJP, jJQ, jJR, jJS, jJT, jJU};
        }
    }

    public interface c {
        void a(AppBrandRemoteTaskController appBrandRemoteTaskController);

        void finish();
    }

    public final void aI(String str, int i) {
        this.jJF = a.jJL;
        this.mAppId = str;
        this.jxk = i;
        AppBrandMainProcessService.a((MainProcessTask) this);
    }

    final void ui(String str) {
        this.jJF = a.jJN;
        this.mAppId = str;
        aks();
        afp();
    }

    public final void Yr() {
        switch (2.jJJ[this.jJF - 1]) {
            case 1:
                akr();
                synchronized (AppBrandRemoteTaskController.class) {
                    if (jJI == 0) {
                        long currentTimeMillis = System.currentTimeMillis();
                        jJI = currentTimeMillis;
                        Editor edit = MultiProcessSharedPreferences.getSharedPreferences(ac.getContext(), "pref_appbrand_process", 4).edit();
                        edit.putLong("on_wxa_process_connected_time", currentTimeMillis);
                        edit.commit();
                        x.v("MicroMsg.AppBrandReporter", "update timestamp(%s)", new Object[]{Long.valueOf(currentTimeMillis)});
                    }
                    this.jJH = jJI;
                }
                afp();
                return;
            case 2:
                akr();
                return;
            case 3:
                aks();
                return;
            case 4:
                d.lv(this.jJG);
                return;
            case 5:
                d.uj(this.mAppId);
                return;
            case 6:
                d.aku();
                return;
            default:
                return;
        }
    }

    private void akr() {
        e um = d.um(this.jJE);
        if (um != null) {
            um.a(this.mAppId, this.jxk, this);
            d.a(um);
        }
    }

    private void aks() {
        if (d.bz(this.mAppId, this.jJE) != null) {
            d.uo(this.mAppId);
        }
    }

    public final void Ys() {
        switch (2.jJJ[this.jJF - 1]) {
            case 3:
                this.irc.finish();
                return;
            case 7:
                switch (this.jJG) {
                    case 0:
                        b.iu(ac.Br());
                        this.irr.finish();
                        Process.killProcess(Process.myPid());
                        return;
                    case 1:
                        this.irr.a(this);
                        return;
                    default:
                        return;
                }
            case 8:
                Assert.assertTrue("AppBrand Test Assert", false);
                return;
            case 9:
                j.onNetworkChange();
                return;
            default:
                return;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAppId);
        parcel.writeInt(this.jxk);
        parcel.writeString(this.jJE);
        parcel.writeInt(this.jJF == 0 ? -1 : this.jJF - 1);
        parcel.writeInt(this.jJG);
        parcel.writeLong(this.jJH);
    }

    public final void f(Parcel parcel) {
        this.mAppId = parcel.readString();
        this.jxk = parcel.readInt();
        this.jJE = parcel.readString();
        int readInt = parcel.readInt();
        this.jJF = readInt == -1 ? 0 : a.akt()[readInt];
        this.jJG = parcel.readInt();
        this.jJH = parcel.readLong();
    }
}
