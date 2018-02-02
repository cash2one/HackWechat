package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class StaggeredGridLayoutManager$SavedState implements Parcelable {
    public static final Creator<StaggeredGridLayoutManager$SavedState> CREATOR = new 1();
    int SA;
    boolean SC;
    boolean Sh;
    boolean XV;
    List<StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> Yf;
    int Yj;
    int Yk;
    int[] Yl;
    int Ym;
    int[] Yn;

    StaggeredGridLayoutManager$SavedState(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.SA = parcel.readInt();
        this.Yj = parcel.readInt();
        this.Yk = parcel.readInt();
        if (this.Yk > 0) {
            this.Yl = new int[this.Yk];
            parcel.readIntArray(this.Yl);
        }
        this.Ym = parcel.readInt();
        if (this.Ym > 0) {
            this.Yn = new int[this.Ym];
            parcel.readIntArray(this.Yn);
        }
        this.Sh = parcel.readInt() == 1;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.SC = z;
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.XV = z2;
        this.Yf = parcel.readArrayList(StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem.class.getClassLoader());
    }

    public StaggeredGridLayoutManager$SavedState(StaggeredGridLayoutManager$SavedState staggeredGridLayoutManager$SavedState) {
        this.Yk = staggeredGridLayoutManager$SavedState.Yk;
        this.SA = staggeredGridLayoutManager$SavedState.SA;
        this.Yj = staggeredGridLayoutManager$SavedState.Yj;
        this.Yl = staggeredGridLayoutManager$SavedState.Yl;
        this.Ym = staggeredGridLayoutManager$SavedState.Ym;
        this.Yn = staggeredGridLayoutManager$SavedState.Yn;
        this.Sh = staggeredGridLayoutManager$SavedState.Sh;
        this.SC = staggeredGridLayoutManager$SavedState.SC;
        this.XV = staggeredGridLayoutManager$SavedState.XV;
        this.Yf = staggeredGridLayoutManager$SavedState.Yf;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeInt(this.SA);
        parcel.writeInt(this.Yj);
        parcel.writeInt(this.Yk);
        if (this.Yk > 0) {
            parcel.writeIntArray(this.Yl);
        }
        parcel.writeInt(this.Ym);
        if (this.Ym > 0) {
            parcel.writeIntArray(this.Yn);
        }
        if (this.Sh) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.SC) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.XV) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeList(this.Yf);
    }
}
