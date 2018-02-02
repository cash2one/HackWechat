package com.tencent.mm.plugin.appbrand.performance;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager.GetPkgDownloadCostTask;

class AppBrandPerformanceManager$GetPkgDownloadCostTask$1 implements Creator<GetPkgDownloadCostTask> {
    AppBrandPerformanceManager$GetPkgDownloadCostTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        GetPkgDownloadCostTask getPkgDownloadCostTask = new GetPkgDownloadCostTask((byte) 0);
        getPkgDownloadCostTask.f(parcel);
        return getPkgDownloadCostTask;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new GetPkgDownloadCostTask[i];
    }
}
