package com.tencent.mm.plugin.appbrand.ui;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI.ProcessRestartTask;

class AppBrandUI$ProcessRestartTask$1 implements Creator<ProcessRestartTask> {
    AppBrandUI$ProcessRestartTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        ProcessRestartTask processRestartTask = new ProcessRestartTask((byte) 0);
        processRestartTask.f(parcel);
        return processRestartTask;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ProcessRestartTask[i];
    }
}
