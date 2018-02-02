package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.AppBrandOnOpReportStartEvent;

class AppBrandOpReportLogic$AppBrandOnOpReportStartEvent$1 implements Creator<AppBrandOnOpReportStartEvent> {
    AppBrandOpReportLogic$AppBrandOnOpReportStartEvent$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new AppBrandOnOpReportStartEvent(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new AppBrandOnOpReportStartEvent[i];
    }
}
