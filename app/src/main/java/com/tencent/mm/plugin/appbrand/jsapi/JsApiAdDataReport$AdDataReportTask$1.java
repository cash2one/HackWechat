package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiAdDataReport.AdDataReportTask;

class JsApiAdDataReport$AdDataReportTask$1 implements Creator<AdDataReportTask> {
    JsApiAdDataReport$AdDataReportTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new AdDataReportTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new AdDataReportTask[i];
    }
}
