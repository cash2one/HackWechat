package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

final class d<T> implements ClassLoaderCreator<T> {
    private final c<T> vC;

    public d(c<T> cVar) {
        this.vC = cVar;
    }

    public final T createFromParcel(Parcel parcel) {
        return this.vC.createFromParcel(parcel, null);
    }

    public final T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.vC.createFromParcel(parcel, classLoader);
    }

    public final T[] newArray(int i) {
        return this.vC.newArray(i);
    }
}
