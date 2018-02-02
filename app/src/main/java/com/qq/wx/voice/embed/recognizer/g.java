package com.qq.wx.voice.embed.recognizer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;

final class g {
    Handler b = new h(this);
    c bgv;

    public final void a(int i) {
        Message obtainMessage = this.b.obtainMessage(100);
        Bundle bundle = new Bundle();
        bundle.putInt(OpenSDKTool4Assistant.EXTRA_ERROR_CODE, i);
        obtainMessage.setData(bundle);
        this.b.sendMessage(obtainMessage);
    }
}
