package com.tencent.mm.plugin.downloader.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CDNTaskInfo implements Parcelable {
    public static final Creator<CDNTaskInfo> CREATOR = new 1();
    public String downloadUrl;
    public String filePath;
    public boolean htz;
    public int lrA;
    public int lrB;
    public boolean lrC;
    public boolean lrD;
    public String lry;
    public String lrz;
    public String mediaId;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte b;
        byte b2 = (byte) 1;
        parcel.writeByte(this.htz ? (byte) 1 : (byte) 0);
        parcel.writeString(this.downloadUrl);
        parcel.writeString(this.mediaId);
        parcel.writeString(this.filePath);
        parcel.writeString(this.lry);
        parcel.writeString(this.lrz);
        parcel.writeInt(this.lrA);
        parcel.writeInt(this.lrB);
        if (this.lrC) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (!this.lrD) {
            b2 = (byte) 0;
        }
        parcel.writeByte(b2);
    }

    private CDNTaskInfo(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.htz = parcel.readByte() == (byte) 1;
        this.downloadUrl = parcel.readString();
        this.mediaId = parcel.readString();
        this.filePath = parcel.readString();
        this.lry = parcel.readString();
        this.lrz = parcel.readString();
        this.lrA = parcel.readInt();
        this.lrB = parcel.readInt();
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.lrC = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.lrD = z2;
    }

    public boolean equals(Object obj) {
        return obj == this || (obj != null && (obj instanceof CDNTaskInfo) && ((CDNTaskInfo) obj).downloadUrl.equals(this.downloadUrl));
    }

    public int hashCode() {
        return this.downloadUrl.hashCode();
    }

    public CDNTaskInfo(String str) {
        this.downloadUrl = str;
    }
}
