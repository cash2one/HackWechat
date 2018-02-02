package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem;

class StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem$1 implements Creator<FullSpanItem> {
    StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new FullSpanItem(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new FullSpanItem[i];
    }
}
