package com.tencent.mm.plugin.voip.video;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;

class OpenGlRender$a extends af {
    final /* synthetic */ OpenGlRender suz;

    public OpenGlRender$a(OpenGlRender openGlRender, Looper looper) {
        this.suz = openGlRender;
        super(looper);
    }

    public final void handleMessage(Message message) {
        this.suz.requestRender();
    }
}
