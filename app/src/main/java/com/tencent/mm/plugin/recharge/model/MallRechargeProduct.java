package com.tencent.mm.plugin.recharge.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MallRechargeProduct implements Parcelable {
    public static final Creator<MallRechargeProduct> CREATOR = new 1();
    public String appId;
    public String fqV;
    public boolean isDefault;
    public String lEM;
    public String pBK;
    public String pBL;
    public float pBM = 0.0f;
    public float pBN = 0.0f;
    public boolean pBO;
    public int pBP;
    public int pBQ;
    public int pBR;
    public final boolean pBS;
    public boolean pBT = true;

    public MallRechargeProduct(boolean z) {
        this.pBS = z;
    }

    public final boolean isValid() {
        if (!this.pBO || this.pBP > 0) {
            return true;
        }
        return false;
    }

    public static void a(MallRechargeProduct mallRechargeProduct, MallRechargeProduct mallRechargeProduct2) {
        mallRechargeProduct2.appId = mallRechargeProduct.appId;
        mallRechargeProduct2.pBK = mallRechargeProduct.pBK;
        mallRechargeProduct2.fqV = mallRechargeProduct.fqV;
        mallRechargeProduct2.lEM = mallRechargeProduct.lEM;
        mallRechargeProduct2.pBL = mallRechargeProduct.pBL;
        mallRechargeProduct2.pBM = mallRechargeProduct.pBM;
        mallRechargeProduct2.pBN = mallRechargeProduct.pBN;
        mallRechargeProduct2.pBO = mallRechargeProduct.pBO;
        mallRechargeProduct2.pBP = mallRechargeProduct.pBP;
        mallRechargeProduct2.pBQ = mallRechargeProduct.pBQ;
        mallRechargeProduct2.isDefault = mallRechargeProduct.isDefault;
        mallRechargeProduct2.pBT = mallRechargeProduct.pBT;
        mallRechargeProduct2.pBR = mallRechargeProduct.pBR;
    }

    public int describeContents() {
        return 0;
    }

    public MallRechargeProduct(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.pBK = parcel.readString();
        this.appId = parcel.readString();
        this.fqV = parcel.readString();
        this.lEM = parcel.readString();
        this.pBL = parcel.readString();
        this.pBM = parcel.readFloat();
        this.pBN = parcel.readFloat();
        this.pBO = parcel.readInt() == 1;
        this.pBP = parcel.readInt();
        this.pBQ = parcel.readInt();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.isDefault = z;
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.pBS = z2;
        this.pBR = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.pBK);
        parcel.writeString(this.appId);
        parcel.writeString(this.fqV);
        parcel.writeString(this.lEM);
        parcel.writeString(this.pBL);
        parcel.writeFloat(this.pBM);
        parcel.writeFloat(this.pBN);
        parcel.writeInt(this.pBO ? 1 : 0);
        parcel.writeInt(this.pBP);
        parcel.writeInt(this.pBQ);
        if (this.isDefault) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.pBS) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeInt(this.pBR);
    }
}
