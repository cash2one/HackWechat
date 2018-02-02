package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiOperateGameCenterMsg.OperateGameCenterMsgTask;

class GameJsApiOperateGameCenterMsg$OperateGameCenterMsgTask$1 implements Creator<OperateGameCenterMsgTask> {
    GameJsApiOperateGameCenterMsg$OperateGameCenterMsgTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new OperateGameCenterMsgTask(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new OperateGameCenterMsgTask[i];
    }
}
