package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

public class RecyclerView$SavedState extends BaseSavedState {
    public static final Creator<RecyclerView$SavedState> CREATOR = new 1();
    Parcelable Vu;

    RecyclerView$SavedState(Parcel parcel) {
        super(parcel);
        this.Vu = parcel.readParcelable(RecyclerView$h.class.getClassLoader());
    }

    RecyclerView$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.Vu, 0);
    }
}
