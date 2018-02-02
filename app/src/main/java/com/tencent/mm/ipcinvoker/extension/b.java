package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import com.tencent.mm.ipcinvoker.d.a;
import com.tencent.mm.ipcinvoker.o;

public final class b implements a {
    public final boolean au(Object obj) {
        return obj instanceof a;
    }

    public final void a(Object obj, Parcel parcel) {
        a aVar = (a) obj;
        parcel.writeString(aVar.getClass().getName());
        parcel.writeBundle(aVar.toBundle());
    }

    public final Object d(Parcel parcel) {
        String readString = parcel.readString();
        parcel.readBundle();
        a aVar = (a) o.e(readString, a.class);
        return aVar != null ? aVar : null;
    }
}
