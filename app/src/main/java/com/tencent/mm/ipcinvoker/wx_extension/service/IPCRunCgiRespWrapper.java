package com.tencent.mm.ipcinvoker.wx_extension.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ae.b;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.ipcinvoker.wx_extension.a;

public class IPCRunCgiRespWrapper implements Parcelable {
    public static final Creator<IPCRunCgiRespWrapper> CREATOR = new 1();
    public int errCode;
    public int errType;
    public String fnL;
    public b gJQ;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.errType);
        parcel.writeInt(this.errCode);
        parcel.writeString(this.fnL);
        c.a(this.gJQ, parcel);
    }

    IPCRunCgiRespWrapper(Parcel parcel) {
        this.errType = parcel.readInt();
        this.errCode = parcel.readInt();
        this.fnL = parcel.readString();
        this.gJQ = (b) c.a(a.class.getName(), parcel);
    }

    public static IPCRunCgiRespWrapper BG() {
        IPCRunCgiRespWrapper iPCRunCgiRespWrapper = new IPCRunCgiRespWrapper();
        iPCRunCgiRespWrapper.gJQ = null;
        iPCRunCgiRespWrapper.fnL = null;
        iPCRunCgiRespWrapper.errType = 3;
        iPCRunCgiRespWrapper.errCode = -2;
        return iPCRunCgiRespWrapper;
    }
}
