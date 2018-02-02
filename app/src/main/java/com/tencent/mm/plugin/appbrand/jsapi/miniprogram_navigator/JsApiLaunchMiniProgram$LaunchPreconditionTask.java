package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.task.d;

final class JsApiLaunchMiniProgram$LaunchPreconditionTask extends MainProcessTask {
    public static final Creator<JsApiLaunchMiniProgram$LaunchPreconditionTask> CREATOR = new 1();
    private String joe;
    private int jof;
    private int jog = a.joh.ordinal();

    public final void f(Parcel parcel) {
        this.joe = parcel.readString();
        this.jof = parcel.readInt();
        this.jog = parcel.readInt();
    }

    public final void Yr() {
        d.un(this.joe);
        this.jog = a.joj.ordinal();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.joe);
        parcel.writeInt(this.jof);
        parcel.writeInt(this.jog);
    }

    JsApiLaunchMiniProgram$LaunchPreconditionTask() {
    }

    JsApiLaunchMiniProgram$LaunchPreconditionTask(Parcel parcel) {
        f(parcel);
    }
}
