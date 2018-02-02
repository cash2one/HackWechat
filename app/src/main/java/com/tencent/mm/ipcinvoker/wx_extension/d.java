package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import com.tencent.mm.ipcinvoker.extension.a;

public final class d implements a {
    public final boolean au(Object obj) {
        return obj instanceof Parcel;
    }

    public final void a(Object obj, Parcel parcel) {
        Parcel parcel2 = (Parcel) obj;
        parcel2.setDataPosition(0);
        parcel.writeInt(parcel2.dataSize());
        parcel.appendFrom(parcel2, 0, parcel2.dataSize());
    }

    public final Object d(Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        obtain.appendFrom(parcel, parcel.dataPosition(), parcel.readInt());
        obtain.setDataPosition(0);
        return obtain;
    }
}
