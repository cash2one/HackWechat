package c.t.m.g;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.map.geolocation.TencentLocation;

class dz$1 implements Creator<TencentLocation> {
    dz$1() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new TencentLocation[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        dz dzVar = new dz(parcel.readInt(), (byte) 0);
        dv dvVar = new dv();
        dt dtVar = new dt();
        dx dxVar = new dx();
        dtVar.c = dxVar;
        dz.a(dzVar, parcel.readString());
        dvVar.a = parcel.readDouble();
        dvVar.b = parcel.readDouble();
        dvVar.d = parcel.readFloat();
        dvVar.c = parcel.readDouble();
        dvVar.f = parcel.readString();
        dxVar.b = parcel.readString();
        dxVar.e = parcel.readString();
        dxVar.f = parcel.readString();
        dxVar.g = parcel.readString();
        dxVar.j = parcel.readString();
        dxVar.k = parcel.readString();
        dxVar.c = parcel.readString();
        dz.a(dzVar, dvVar);
        dz.a(dzVar, dtVar);
        dz.a(dzVar, parcel.readLong());
        Bundle readBundle = parcel.readBundle();
        if (readBundle != null) {
            dz.b(dzVar).putAll(readBundle);
        }
        return dzVar;
    }
}
