package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.view.View.BaseSavedState;

class TextInputLayout$SavedState extends BaseSavedState {
    public static final Creator<TextInputLayout$SavedState> CREATOR = new 1();
    CharSequence lq;

    TextInputLayout$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public TextInputLayout$SavedState(Parcel parcel) {
        super(parcel);
        this.lq = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        TextUtils.writeToParcel(this.lq, parcel, i);
    }

    public String toString() {
        return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.lq + "}";
    }
}
