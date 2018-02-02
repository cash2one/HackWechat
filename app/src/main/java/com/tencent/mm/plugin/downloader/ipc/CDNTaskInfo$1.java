package com.tencent.mm.plugin.downloader.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class CDNTaskInfo$1 implements Creator<CDNTaskInfo> {
    CDNTaskInfo$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new CDNTaskInfo(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new CDNTaskInfo[i];
    }
}
