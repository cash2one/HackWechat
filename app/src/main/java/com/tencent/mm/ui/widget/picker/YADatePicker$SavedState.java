package com.tencent.mm.ui.widget.picker;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class YADatePicker$SavedState extends BaseSavedState {
    public static final Creator<YADatePicker$SavedState> CREATOR = new Creator<YADatePicker$SavedState>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new YADatePicker$SavedState(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new YADatePicker$SavedState[i];
        }
    };
    private final int kyN;
    private final int kyO;
    private final int kyP;

    private YADatePicker$SavedState(Parcelable parcelable, int i, int i2, int i3) {
        super(parcelable);
        this.kyN = i;
        this.kyO = i2;
        this.kyP = i3;
    }

    private YADatePicker$SavedState(Parcel parcel) {
        super(parcel);
        this.kyN = parcel.readInt();
        this.kyO = parcel.readInt();
        this.kyP = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.kyN);
        parcel.writeInt(this.kyO);
        parcel.writeInt(this.kyP);
    }
}
