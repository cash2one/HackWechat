package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class SearchView$SavedState extends BaseSavedState {
    public static final Creator<SearchView$SavedState> CREATOR = new 1();
    boolean XJ;

    SearchView$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public SearchView$SavedState(Parcel parcel) {
        super(parcel);
        this.XJ = ((Boolean) parcel.readValue(null)).booleanValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeValue(Boolean.valueOf(this.XJ));
    }

    public String toString() {
        return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.XJ + "}";
    }
}
