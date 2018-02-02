package com.tencent.mm.plugin.ext.voicecontrol;

import com.qq.wx.voice.embed.recognizer.a;
import com.qq.wx.voice.embed.recognizer.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class ExtControlProviderVoiceControl$5 implements c {
    final /* synthetic */ ExtControlProviderVoiceControl mbL;

    ExtControlProviderVoiceControl$5(ExtControlProviderVoiceControl extControlProviderVoiceControl) {
        this.mbL = extControlProviderVoiceControl;
    }

    public final void a(a aVar) {
        if (aVar == null) {
            x.w("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl onGetResult restult is null");
            return;
        }
        x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl use time2:%s,text: %s,name: %s", new Object[]{Long.valueOf(System.currentTimeMillis() - ExtControlProviderVoiceControl.b(this.mbL)), aVar.text, aVar.name});
        if (!bh.ov(aVar.name)) {
            ExtControlProviderVoiceControl.c(this.mbL);
            ExtControlProviderVoiceControl.b(this.mbL, aVar.name);
        }
    }

    public final void ee(int i) {
        x.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl onGetError:%s", new Object[]{Integer.valueOf(i)});
    }
}
