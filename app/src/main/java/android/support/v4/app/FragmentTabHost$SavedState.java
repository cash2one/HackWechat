package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class FragmentTabHost$SavedState extends BaseSavedState {
    public static final Creator<FragmentTabHost$SavedState> CREATOR = new 1();
    String rk;

    FragmentTabHost$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    private FragmentTabHost$SavedState(Parcel parcel) {
        super(parcel);
        this.rk = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.rk);
    }

    public String toString() {
        return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.rk + "}";
    }
}
