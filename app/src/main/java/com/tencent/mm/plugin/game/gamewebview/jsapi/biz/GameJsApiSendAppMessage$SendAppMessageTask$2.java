package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiSendAppMessage.SendAppMessageTask;

class GameJsApiSendAppMessage$SendAppMessageTask$2 implements Creator<SendAppMessageTask> {
    GameJsApiSendAppMessage$SendAppMessageTask$2() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new SendAppMessageTask(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SendAppMessageTask[i];
    }
}
