package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Parcel;
import com.tencent.mm.ipcinvoker.extension.f;

public class h$b implements f {
    String fIR;
    boolean iTt;
    boolean iTu;
    String id;

    public final void e(Parcel parcel) {
        int i;
        int i2 = 1;
        parcel.writeString(this.id);
        if (this.iTt) {
            i = 1;
        } else {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeString(this.fIR);
        if (!this.iTu) {
            i2 = 0;
        }
        parcel.writeInt(i2);
    }

    public final void readFromParcel(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.id = parcel.readString();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.iTt = z;
        this.fIR = parcel.readString();
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.iTu = z2;
    }
}
