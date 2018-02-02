package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AppBrandLocalMediaObject implements Parcelable {
    public static final Creator<AppBrandLocalMediaObject> CREATOR = new 1();
    public String fus;
    public String hhZ;
    public String iHF;
    public boolean iHG;
    public long iHH;
    public long ieE;
    public String mimeType;

    public String toString() {
        return "AppBrandLocalMediaObject{localId='" + this.fus + '\'' + ", fileFullPath='" + this.hhZ + '\'' + ", mimeType='" + this.mimeType + '\'' + ", fileExt='" + this.iHF + '\'' + '}';
    }

    protected AppBrandLocalMediaObject() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.fus);
        parcel.writeString(this.hhZ);
        parcel.writeString(this.mimeType);
        parcel.writeString(this.iHF);
        parcel.writeByte(this.iHG ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.ieE);
        parcel.writeLong(this.iHH);
    }

    protected AppBrandLocalMediaObject(Parcel parcel) {
        this.fus = parcel.readString();
        this.hhZ = parcel.readString();
        this.mimeType = parcel.readString();
        this.iHF = parcel.readString();
        this.iHG = parcel.readByte() != (byte) 0;
        this.ieE = parcel.readLong();
        this.iHH = parcel.readLong();
    }
}
