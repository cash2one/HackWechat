package com.tencent.mm.plugin.game.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter.StartGameProcessTask;

class SubCoreGameCenter$StartGameProcessTask$1 implements Creator<StartGameProcessTask> {
    SubCoreGameCenter$StartGameProcessTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new StartGameProcessTask(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new StartGameProcessTask[i];
    }
}
