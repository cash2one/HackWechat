package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.LaunchCheckParams;
import com.tencent.mm.protocal.c.cam;
import com.tencent.mm.protocal.c.cbl;
import com.tencent.mm.protocal.c.cbs;

final class AppBrandTaskUsageRecorder$UpdateTask extends MainProcessTask {
    public static final Creator<AppBrandTaskUsageRecorder$UpdateTask> CREATOR = new 1();
    LaunchCheckParams jxu;

    public final void Yr() {
        cbs com_tencent_mm_protocal_c_cbs = null;
        if (g.Dh().gPy && !a.Cs()) {
            this.jxu.getClass();
            if (this.jxu.jxt.scene == 1086) {
                f.Zm().s(q.qS(this.jxu.jxs.appId), this.jxu.jxs.iGA, 0);
                return;
            }
            cbl com_tencent_mm_protocal_c_cbl;
            AppBrandLaunchReferrer appBrandLaunchReferrer = this.jxu.jxs.iNZ;
            if (appBrandLaunchReferrer == null || 1 != appBrandLaunchReferrer.iOd) {
                com_tencent_mm_protocal_c_cbl = null;
            } else {
                com_tencent_mm_protocal_c_cbl = new cbl();
                com_tencent_mm_protocal_c_cbl.wsW = appBrandLaunchReferrer.appId;
                com_tencent_mm_protocal_c_cbl.wsQ = appBrandLaunchReferrer.fqd;
            }
            if (appBrandLaunchReferrer != null && 2 == appBrandLaunchReferrer.iOd) {
                com_tencent_mm_protocal_c_cbs = new cbs();
                com_tencent_mm_protocal_c_cbs.nkv = appBrandLaunchReferrer.appId;
                com_tencent_mm_protocal_c_cbs.nfX = appBrandLaunchReferrer.url;
            }
            cam com_tencent_mm_protocal_c_cam = new cam();
            com_tencent_mm_protocal_c_cam.wtc = this.jxu.jxs.iGA;
            com_tencent_mm_protocal_c_cam.vNa = this.jxu.iGL;
            com_tencent_mm_protocal_c_cam.rYW = this.jxu.jxt.scene;
            com_tencent_mm_protocal_c_cam.wwC = this.jxu.jxs.iNW;
            com_tencent_mm_protocal_c_cam.wwB = 1;
            com_tencent_mm_protocal_c_cam.wwA = this.jxu.jxt.fIs;
            new e(this.jxu.jxs.appId, false, com_tencent_mm_protocal_c_cam, com_tencent_mm_protocal_c_cbs, com_tencent_mm_protocal_c_cbl, this.jxu.irG, this.jxu.jhr).ahU();
        }
    }

    public AppBrandTaskUsageRecorder$UpdateTask(LaunchCheckParams launchCheckParams) {
        this.jxu = launchCheckParams;
    }

    AppBrandTaskUsageRecorder$UpdateTask(Parcel parcel) {
        f(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final void f(Parcel parcel) {
        this.jxu = (LaunchCheckParams) parcel.readParcelable(LaunchCheckParams.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.jxu, i);
    }
}
