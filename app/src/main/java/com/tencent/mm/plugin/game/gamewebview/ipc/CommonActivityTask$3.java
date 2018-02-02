package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class CommonActivityTask$3 implements Creator<CommonActivityTask> {
    CommonActivityTask$3() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new CommonActivityTask(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new CommonActivityTask[i];
    }
}
