package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication.LaunchApplicationTask;

class GameJsApiLaunchApplication$LaunchApplicationTask$3 implements Creator<LaunchApplicationTask> {
    GameJsApiLaunchApplication$LaunchApplicationTask$3() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new LaunchApplicationTask(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new LaunchApplicationTask[i];
    }
}
