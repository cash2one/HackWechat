package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.ReportTask;

class AppBrandOpReportLogic$ReportTask$1 implements Creator<ReportTask> {
    AppBrandOpReportLogic$ReportTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ReportTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ReportTask[i];
    }
}
