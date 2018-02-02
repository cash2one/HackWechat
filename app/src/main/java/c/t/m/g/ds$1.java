package c.t.m.g;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class ds$1 implements Creator<ds> {
    ds$1() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ds[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        ds dsVar = new ds();
        dsVar.a = parcel.readString();
        dsVar.b = parcel.readString();
        dsVar.c = parcel.readString();
        dsVar.d = parcel.readDouble();
        dsVar.e = parcel.readDouble();
        dsVar.f = parcel.readDouble();
        dsVar.g = parcel.readString();
        dsVar.h = parcel.readString();
        return dsVar;
    }
}
