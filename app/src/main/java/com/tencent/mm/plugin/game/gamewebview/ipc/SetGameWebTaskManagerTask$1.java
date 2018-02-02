package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class SetGameWebTaskManagerTask$1 implements Creator<SetGameWebTaskManagerTask> {
    SetGameWebTaskManagerTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new SetGameWebTaskManagerTask(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SetGameWebTaskManagerTask[i];
    }
}
