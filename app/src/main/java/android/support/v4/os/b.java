package android.support.v4.os;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class b {

    static class a<T> implements Creator<T> {
        final c<T> vC;

        public a(c<T> cVar) {
            this.vC = cVar;
        }

        public final T createFromParcel(Parcel parcel) {
            return this.vC.createFromParcel(parcel, null);
        }

        public final T[] newArray(int i) {
            return this.vC.newArray(i);
        }
    }

    public static <T> Creator<T> a(c<T> cVar) {
        if (VERSION.SDK_INT >= 13) {
            return new d(cVar);
        }
        return new a(cVar);
    }
}
