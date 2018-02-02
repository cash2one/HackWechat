package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class BindServiceTask$1 implements Creator<BindServiceTask> {
    BindServiceTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new BindServiceTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new BindServiceTask[i];
    }
}
