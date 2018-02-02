package com.qq.wx.voice.embed.recognizer;

import android.os.Handler;
import android.os.Message;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;

final class h extends Handler {
    private /* synthetic */ g bgu;

    h(g gVar) {
        this.bgu = gVar;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 100:
                this.bgu.bgv.ee(message.getData().getInt(OpenSDKTool4Assistant.EXTRA_ERROR_CODE));
                return;
            case 200:
                this.bgu.bgv.a((a) message.obj);
                return;
            default:
                return;
        }
    }
}
