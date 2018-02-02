package com.tencent.mm.plugin.downloader.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class FileDownloadTaskInfo$1 implements Creator<FileDownloadTaskInfo> {
    FileDownloadTaskInfo$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new FileDownloadTaskInfo(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new FileDownloadTaskInfo[0];
    }
}
