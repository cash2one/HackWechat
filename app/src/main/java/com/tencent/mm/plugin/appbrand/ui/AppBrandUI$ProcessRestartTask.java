package com.tencent.mm.plugin.appbrand.ui;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.task.d;

class AppBrandUI$ProcessRestartTask extends MainProcessTask {
    public static final Creator<AppBrandUI$ProcessRestartTask> CREATOR = new 1();
    public String gOs;
    public String jJE;

    private AppBrandUI$ProcessRestartTask() {
    }

    public final void Yr() {
        b.iu(this.gOs);
        d.uk(this.jJE);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.gOs);
        parcel.writeString(this.jJE);
    }

    public final void f(Parcel parcel) {
        this.gOs = parcel.readString();
        this.jJE = parcel.readString();
    }
}
