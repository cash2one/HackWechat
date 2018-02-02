package com.tencent.mm.pluginsdk.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PayInfo implements Parcelable {
    public static final Creator<PayInfo> CREATOR = new 1();
    public String appId;
    public String fCB = "";
    public int fCR;
    public int fCV = 0;
    public int fCW = -1;
    public String fKx;
    public String fnL;
    public String fqV;
    public String fuH;
    public int fwX;
    public String fwZ;
    public String fxa;
    public String iIj;
    public String kKe;
    public boolean ncX = false;
    public String ned;
    public int pLj = 0;
    public String partnerId;
    public String tan;
    public int vzA;
    public long vzB = 0;
    public int vzC = -1;
    public String vzD;
    public String vzE;
    public int vzF = 1;
    public double vzG = 0.0d;
    public int vzu = 0;
    public boolean vzv = true;
    public String vzw;
    public Bundle vzx;
    public int vzy = 0;
    public int vzz = 0;

    public PayInfo(Parcel parcel) {
        boolean z = true;
        this.fCV = parcel.readInt();
        this.vzu = parcel.readInt();
        this.fuH = parcel.readString();
        this.ned = parcel.readString();
        this.appId = parcel.readString();
        this.tan = parcel.readString();
        this.partnerId = parcel.readString();
        this.fKx = parcel.readString();
        this.fqV = parcel.readString();
        this.fnL = parcel.readString();
        this.fCR = parcel.readInt();
        this.fCW = parcel.readInt();
        this.ncX = parcel.readInt() == 1;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.vzv = z;
        this.vzx = parcel.readBundle();
        this.vzy = parcel.readInt();
        this.fwZ = parcel.readString();
        this.fxa = parcel.readString();
        this.fwX = parcel.readInt();
        this.vzB = parcel.readLong();
        this.fCB = parcel.readString();
        this.vzD = parcel.readString();
        this.vzE = parcel.readString();
        this.vzF = parcel.readInt();
        this.kKe = parcel.readString();
        this.iIj = parcel.readString();
        this.pLj = parcel.readInt();
        this.vzG = parcel.readDouble();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeInt(this.fCV);
        parcel.writeInt(this.vzu);
        parcel.writeString(this.fuH);
        parcel.writeString(this.ned);
        parcel.writeString(this.appId);
        parcel.writeString(this.tan);
        parcel.writeString(this.partnerId);
        parcel.writeString(this.fKx);
        parcel.writeString(this.fqV);
        parcel.writeString(this.fnL);
        parcel.writeInt(this.fCR);
        parcel.writeInt(this.fCW);
        parcel.writeInt(this.ncX ? 1 : 0);
        if (!this.vzv) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeBundle(this.vzx);
        parcel.writeInt(this.vzy);
        parcel.writeString(this.fwZ);
        parcel.writeString(this.fxa);
        parcel.writeInt(this.fwX);
        parcel.writeLong(this.vzB);
        parcel.writeString(this.fCB);
        parcel.writeString(this.vzD);
        parcel.writeString(this.vzE);
        parcel.writeInt(this.vzF);
        parcel.writeString(this.kKe);
        parcel.writeString(this.iIj);
        parcel.writeInt(this.pLj);
        parcel.writeDouble(this.vzG);
    }

    public String toString() {
        return String.format("sense : %d, reqKey : %s, uuid : %s, appId : %s, appSource : %s, partnerId : %s, paySign : %s, productId : %s, soterAuth: %s", new Object[]{Integer.valueOf(this.fCV), this.fuH, this.ned, this.appId, this.tan, this.partnerId, this.fKx, this.fqV, this.fCB});
    }
}
