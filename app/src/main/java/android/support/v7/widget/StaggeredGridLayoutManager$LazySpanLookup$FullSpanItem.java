package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

class StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem implements Parcelable {
    public static final Creator<StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> CREATOR = new 1();
    int Yg;
    int[] Yh;
    boolean Yi;
    int mPosition;

    public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem(Parcel parcel) {
        boolean z = true;
        this.mPosition = parcel.readInt();
        this.Yg = parcel.readInt();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.Yi = z;
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.Yh = new int[readInt];
            parcel.readIntArray(this.Yh);
        }
    }

    final int bI(int i) {
        return this.Yh == null ? 0 : this.Yh[i];
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mPosition);
        parcel.writeInt(this.Yg);
        parcel.writeInt(this.Yi ? 1 : 0);
        if (this.Yh == null || this.Yh.length <= 0) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(this.Yh.length);
        parcel.writeIntArray(this.Yh);
    }

    public String toString() {
        return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.Yg + ", mHasUnwantedGapAfter=" + this.Yi + ", mGapPerSpan=" + Arrays.toString(this.Yh) + '}';
    }
}
