package com.tencent.mm.plugin.walletlock.gesture.ui.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView.SavedState;

class PatternLockView$SavedState$1 implements Creator<SavedState> {
    PatternLockView$SavedState$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new SavedState(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SavedState[i];
    }
}
