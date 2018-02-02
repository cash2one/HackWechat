package com.tencent.mm.ipcinvoker.extension.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ipcinvoker.extension.a;
import com.tencent.mm.ipcinvoker.extension.c;

class WrapperParcelable implements Parcelable {
    public static final Creator<WrapperParcelable> CREATOR = new 1();
    Object gMY;

    private WrapperParcelable() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.gMY != null) {
            a av = c.av(this.gMY);
            if (av != null) {
                parcel.writeInt(1);
                parcel.writeString(av.getClass().getName());
                av.a(this.gMY, parcel);
                return;
            }
        }
        parcel.writeInt(1);
    }
}
