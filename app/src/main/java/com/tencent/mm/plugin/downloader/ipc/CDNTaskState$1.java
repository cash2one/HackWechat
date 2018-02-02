package com.tencent.mm.plugin.downloader.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class CDNTaskState$1 implements Creator<CDNTaskState> {
    CDNTaskState$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        CDNTaskState cDNTaskState = new CDNTaskState();
        cDNTaskState.taskState = parcel.readInt();
        cDNTaskState.completeSize = parcel.readInt();
        cDNTaskState.fileTotalSize = parcel.readInt();
        return cDNTaskState;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new CDNTaskState[i];
    }
}
