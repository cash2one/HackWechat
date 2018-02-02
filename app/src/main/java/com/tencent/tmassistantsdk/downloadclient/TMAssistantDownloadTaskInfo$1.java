package com.tencent.tmassistantsdk.downloadclient;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class TMAssistantDownloadTaskInfo$1 implements Creator<TMAssistantDownloadTaskInfo> {
    TMAssistantDownloadTaskInfo$1() {
    }

    public final TMAssistantDownloadTaskInfo createFromParcel(Parcel parcel) {
        return new TMAssistantDownloadTaskInfo(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readString());
    }

    public final TMAssistantDownloadTaskInfo[] newArray(int i) {
        return new TMAssistantDownloadTaskInfo[i];
    }
}
