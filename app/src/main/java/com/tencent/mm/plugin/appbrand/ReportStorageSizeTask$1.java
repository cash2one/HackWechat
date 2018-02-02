package com.tencent.mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class ReportStorageSizeTask$1 implements Creator<ReportStorageSizeTask> {
    ReportStorageSizeTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        ReportStorageSizeTask reportStorageSizeTask = new ReportStorageSizeTask();
        reportStorageSizeTask.f(parcel);
        return reportStorageSizeTask;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ReportStorageSizeTask[i];
    }
}
