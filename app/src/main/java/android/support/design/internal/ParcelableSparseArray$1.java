package android.support.design.internal;

import android.os.Parcel;
import android.support.v4.os.c;

class ParcelableSparseArray$1 implements c<ParcelableSparseArray> {
    ParcelableSparseArray$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new ParcelableSparseArray(parcel, classLoader);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ParcelableSparseArray[i];
    }
}
