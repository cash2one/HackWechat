package com.tencent.mm.plugin.appbrand.performance;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager.SetAppPerformanceModeTask;

class AppBrandPerformanceManager$SetAppPerformanceModeTask$1 implements Creator<SetAppPerformanceModeTask> {
    AppBrandPerformanceManager$SetAppPerformanceModeTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        SetAppPerformanceModeTask setAppPerformanceModeTask = new SetAppPerformanceModeTask((byte) 0);
        setAppPerformanceModeTask.f(parcel);
        return setAppPerformanceModeTask;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SetAppPerformanceModeTask[i];
    }
}
