package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class DebuggerInfo$1 implements Creator<DebuggerInfo> {
    DebuggerInfo$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = true;
        DebuggerInfo debuggerInfo = new DebuggerInfo();
        debuggerInfo.iSR = parcel.readInt() != 0;
        debuggerInfo.iSS = parcel.readInt() != 0;
        if (parcel.readInt() == 0) {
            z = false;
        }
        debuggerInfo.iST = z;
        return debuggerInfo;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new DebuggerInfo[i];
    }
}
