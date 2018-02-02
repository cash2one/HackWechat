package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import com.tencent.mm.ipcinvoker.o;

public final class g implements a {
    public final boolean au(Object obj) {
        return obj instanceof f;
    }

    public final void a(Object obj, Parcel parcel) {
        f fVar = (f) obj;
        parcel.writeString(fVar.getClass().getName());
        fVar.e(parcel);
    }

    public final Object d(Parcel parcel) {
        f fVar = (f) o.e(parcel.readString(), f.class);
        if (fVar == null) {
            return null;
        }
        fVar.readFromParcel(parcel);
        return fVar;
    }
}
