package com.tencent.mm.plugin.appbrand.menu;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.menu.MenuDelegate_EnableDebug.SetAppDebugModeTask;

class MenuDelegate_EnableDebug$SetAppDebugModeTask$1 implements Creator<SetAppDebugModeTask> {
    MenuDelegate_EnableDebug$SetAppDebugModeTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        SetAppDebugModeTask setAppDebugModeTask = new SetAppDebugModeTask((byte) 0);
        setAppDebugModeTask.f(parcel);
        return setAppDebugModeTask;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SetAppDebugModeTask[i];
    }
}
