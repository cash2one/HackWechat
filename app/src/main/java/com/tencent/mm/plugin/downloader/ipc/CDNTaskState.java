package com.tencent.mm.plugin.downloader.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CDNTaskState implements Parcelable {
    public static final Creator<CDNTaskState> CREATOR = new 1();
    public int completeSize = 0;
    public int fileTotalSize = 0;
    public int taskState = -100;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.taskState);
        parcel.writeInt(this.completeSize);
        parcel.writeInt(this.fileTotalSize);
    }
}
