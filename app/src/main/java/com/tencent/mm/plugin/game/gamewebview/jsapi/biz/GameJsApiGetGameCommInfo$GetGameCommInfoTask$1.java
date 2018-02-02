package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetGameCommInfo.GetGameCommInfoTask;

class GameJsApiGetGameCommInfo$GetGameCommInfoTask$1 implements Creator<GetGameCommInfoTask> {
    GameJsApiGetGameCommInfo$GetGameCommInfoTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new GetGameCommInfoTask(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new GetGameCommInfoTask[i];
    }
}
