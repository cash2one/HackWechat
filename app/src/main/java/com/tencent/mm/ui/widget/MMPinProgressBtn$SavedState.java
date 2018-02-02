package com.tencent.mm.ui.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

public class MMPinProgressBtn$SavedState extends BaseSavedState {
    public static final Creator<MMPinProgressBtn$SavedState> CREATOR = new 1();
    private int sm;
    private int zua;

    public MMPinProgressBtn$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    private MMPinProgressBtn$SavedState(Parcel parcel) {
        super(parcel);
        this.sm = parcel.readInt();
        this.zua = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.sm);
        parcel.writeInt(this.zua);
    }
}
