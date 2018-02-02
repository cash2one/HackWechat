package com.tencent.mm.plugin.walletlock.gesture.ui.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class PatternLockView$SavedState extends BaseSavedState {
    public static final Creator<PatternLockView$SavedState> CREATOR = new 1();
    boolean tgI;
    boolean tgJ;
    boolean tgK;
    String thc;
    int thd;

    public PatternLockView$SavedState(Parcel parcel) {
        super(parcel);
        this.thc = parcel.readString();
        this.thd = parcel.readInt();
        this.tgJ = ((Boolean) parcel.readValue(null)).booleanValue();
        this.tgK = ((Boolean) parcel.readValue(null)).booleanValue();
        this.tgI = ((Boolean) parcel.readValue(null)).booleanValue();
    }

    public PatternLockView$SavedState(Parcelable parcelable, String str, int i, boolean z, boolean z2, boolean z3) {
        super(parcelable);
        this.thc = str;
        this.thd = i;
        this.tgJ = z;
        this.tgK = z2;
        this.tgI = z3;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.thc);
        parcel.writeInt(this.thd);
        parcel.writeValue(Boolean.valueOf(this.tgJ));
        parcel.writeValue(Boolean.valueOf(this.tgK));
        parcel.writeValue(Boolean.valueOf(this.tgI));
    }
}
