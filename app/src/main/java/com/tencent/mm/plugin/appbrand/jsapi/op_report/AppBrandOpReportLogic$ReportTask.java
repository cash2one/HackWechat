package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.b;

final class AppBrandOpReportLogic$ReportTask extends MainProcessTask {
    public static final Creator<AppBrandOpReportLogic$ReportTask> CREATOR = new 1();
    String appId;
    int fIm;
    int fIs;
    String fnq;
    int iKd;
    int jhr;
    String joU;
    int scene;
    String username;

    public final void Yr() {
        b.a(this);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.appId);
        parcel.writeString(this.username);
        parcel.writeInt(this.iKd);
        parcel.writeInt(this.fIm);
        parcel.writeInt(this.scene);
        parcel.writeInt(this.fIs);
        parcel.writeString(this.fnq);
        parcel.writeInt(this.jhr);
        parcel.writeString(this.joU);
    }

    public final void f(Parcel parcel) {
        this.appId = parcel.readString();
        this.username = parcel.readString();
        this.iKd = parcel.readInt();
        this.fIm = parcel.readInt();
        this.scene = parcel.readInt();
        this.fIs = parcel.readInt();
        this.fnq = parcel.readString();
        this.jhr = parcel.readInt();
        this.joU = parcel.readString();
    }

    AppBrandOpReportLogic$ReportTask() {
    }

    AppBrandOpReportLogic$ReportTask(Parcel parcel) {
        f(parcel);
    }
}
