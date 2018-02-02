package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetOpenDeviceId.GetDeviceIdTask;

class GameJsApiGetOpenDeviceId$GetDeviceIdTask$1 implements Creator<GetDeviceIdTask> {
    GameJsApiGetOpenDeviceId$GetDeviceIdTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new GetDeviceIdTask(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new GetDeviceIdTask[i];
    }
}
