package com.tencent.mm.ui.base.preference;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ui.base.preference.Preference.BaseSavedState;

class Preference$BaseSavedState$1 implements Creator<BaseSavedState> {
    Preference$BaseSavedState$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new BaseSavedState(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new BaseSavedState[i];
    }
}
