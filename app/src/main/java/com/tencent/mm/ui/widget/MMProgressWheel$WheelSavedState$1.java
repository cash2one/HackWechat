package com.tencent.mm.ui.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ui.widget.MMProgressWheel.WheelSavedState;

class MMProgressWheel$WheelSavedState$1 implements Creator<WheelSavedState> {
    MMProgressWheel$WheelSavedState$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new WheelSavedState(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new WheelSavedState[i];
    }
}
