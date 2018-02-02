package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.LinkedList;
import java.util.List;

public class FavorPayInfo implements Parcelable {
    public static final Creator<FavorPayInfo> CREATOR = new 1();
    public String sMT;
    public int sMU;
    public String sMV;
    public String sMW;
    public String sMX;
    public List<String> sMY = new LinkedList();

    public FavorPayInfo(Parcel parcel) {
        this.sMT = parcel.readString();
        this.sMU = parcel.readInt();
        this.sMV = parcel.readString();
        this.sMW = parcel.readString();
        this.sMX = parcel.readString();
        this.sMY = parcel.createStringArrayList();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.sMT);
        parcel.writeInt(this.sMU);
        parcel.writeString(this.sMV);
        parcel.writeString(this.sMW);
        parcel.writeString(this.sMX);
        parcel.writeStringList(this.sMY);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(String.format("FavorPayInfo %s isNeedBankPay %s needBankType %s defaultFavorCompId %s changeBankcardTips %s", new Object[]{this.sMT, Integer.valueOf(this.sMU), this.sMV, this.sMW, this.sMX}));
        if (this.sMY != null) {
            stringBuffer.append("bind_serial_list :");
            for (String str : this.sMY) {
                stringBuffer.append(str + ",");
            }
        }
        return stringBuffer.toString();
    }

    public int describeContents() {
        return 0;
    }
}
