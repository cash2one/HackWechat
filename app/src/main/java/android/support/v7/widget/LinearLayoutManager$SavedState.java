package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LinearLayoutManager$SavedState implements Parcelable {
    public static final Creator<LinearLayoutManager$SavedState> CREATOR = new 1();
    int SA;
    int SB;
    boolean SC;

    LinearLayoutManager$SavedState(Parcel parcel) {
        boolean z = true;
        this.SA = parcel.readInt();
        this.SB = parcel.readInt();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.SC = z;
    }

    public LinearLayoutManager$SavedState(LinearLayoutManager$SavedState linearLayoutManager$SavedState) {
        this.SA = linearLayoutManager$SavedState.SA;
        this.SB = linearLayoutManager$SavedState.SB;
        this.SC = linearLayoutManager$SavedState.SC;
    }

    final boolean fc() {
        return this.SA >= 0;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.SA);
        parcel.writeInt(this.SB);
        parcel.writeInt(this.SC ? 1 : 0);
    }
}
