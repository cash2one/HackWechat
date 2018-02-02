package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import com.tencent.mm.ipcinvoker.i;

class f$1 implements i<Parcel> {
    final /* synthetic */ f iJh;

    f$1(f fVar) {
        this.iJh = fVar;
    }

    public final /* synthetic */ void as(Object obj) {
        Parcel parcel = (Parcel) obj;
        this.iJh.b(parcel.readString(), parcel.readInt(), parcel.readString());
    }
}
