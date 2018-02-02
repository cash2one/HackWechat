package com.tencent.mm.plugin.downloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FileDownloadTaskInfo implements Parcelable {
    public static Creator<FileDownloadTaskInfo> CREATOR = new 1();
    public String appId;
    public String fqR;
    public int fwH;
    public long fwf;
    public long fwg;
    public long id;
    public boolean lsK;
    public String path;
    public int status;
    public String url;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.id);
        parcel.writeString(this.url);
        parcel.writeInt(this.status);
        parcel.writeString(this.path);
        parcel.writeString(this.fqR);
        parcel.writeString(this.appId);
        parcel.writeLong(this.fwf);
        parcel.writeLong(this.fwg);
        parcel.writeByte((byte) (this.lsK ? 1 : 0));
        parcel.writeInt(this.fwH);
    }

    public FileDownloadTaskInfo() {
        this.id = -1;
        this.url = "";
        this.status = 0;
        this.path = "";
        this.fqR = "";
        this.appId = "";
        this.fwf = 0;
        this.fwg = 0;
        this.lsK = false;
        this.fwH = 2;
    }

    private FileDownloadTaskInfo(Parcel parcel) {
        boolean z = true;
        this.id = -1;
        this.url = "";
        this.status = 0;
        this.path = "";
        this.fqR = "";
        this.appId = "";
        this.fwf = 0;
        this.fwg = 0;
        this.lsK = false;
        this.fwH = 2;
        this.id = parcel.readLong();
        this.url = parcel.readString();
        this.status = parcel.readInt();
        this.path = parcel.readString();
        this.fqR = parcel.readString();
        this.appId = parcel.readString();
        this.fwf = parcel.readLong();
        this.fwg = parcel.readLong();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.lsK = z;
        this.fwH = parcel.readInt();
    }
}
