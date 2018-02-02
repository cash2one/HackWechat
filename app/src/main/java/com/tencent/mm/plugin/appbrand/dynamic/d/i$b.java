package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Parcel;
import com.tencent.mm.ipcinvoker.extension.f;

public class i$b implements f {
    String id;
    String url;

    public final void e(Parcel parcel) {
        parcel.writeString(this.id);
        parcel.writeString(this.url);
    }

    public final void readFromParcel(Parcel parcel) {
        this.id = parcel.readString();
        this.url = parcel.readString();
    }
}
