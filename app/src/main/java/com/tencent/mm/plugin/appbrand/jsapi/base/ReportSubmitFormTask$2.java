package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class ReportSubmitFormTask$2 implements Creator<ReportSubmitFormTask> {
    ReportSubmitFormTask$2() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        ReportSubmitFormTask reportSubmitFormTask = new ReportSubmitFormTask();
        reportSubmitFormTask.f(parcel);
        return reportSubmitFormTask;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ReportSubmitFormTask[i];
    }
}
