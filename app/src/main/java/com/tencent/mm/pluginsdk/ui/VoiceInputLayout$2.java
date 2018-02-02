package com.tencent.mm.pluginsdk.ui;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.bg.f.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Set;

class VoiceInputLayout$2 implements b {
    final /* synthetic */ VoiceInputLayout vme;

    VoiceInputLayout$2(VoiceInputLayout voiceInputLayout) {
        this.vme = voiceInputLayout;
    }

    public final void UT() {
        x.d("MicroMsg.VoiceInputLayout", "onRecordFin() onRecordFin currentState = %s", new Object[]{Integer.valueOf(this.vme.vlD)});
        if (VoiceInputLayout.c(this.vme) != null) {
            VoiceInputLayout.c(this.vme).TG();
        }
        VoiceInputLayout.d(this.vme).sendEmptyMessage(0);
    }

    public final void UX() {
        x.d("MicroMsg.VoiceInputLayout", "onRecognize Finish");
        VoiceInputLayout.a(this.vme).removeMessages(0);
        VoiceInputLayout.a(this.vme).removeMessages(1);
        VoiceInputLayout.e(this.vme).caG();
        this.vme.reset(false);
    }

    public final void a(String[] strArr, Set<String> set) {
        VoiceInputLayout.e(this.vme).b(strArr, set);
        VoiceInputLayout.a(this.vme).removeMessages(0);
        VoiceInputLayout.a(this.vme).sendEmptyMessageDelayed(0, (long) VoiceInputLayout.f(this.vme));
    }

    public final void D(int i, int i2, int i3) {
        VoiceInputLayout.a(this.vme).removeMessages(0);
        VoiceInputLayout.a(this.vme).removeMessages(1);
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putInt("localCode", i);
        bundle.putInt("errType", i2);
        bundle.putInt("errCode", i3);
        message.setData(bundle);
        message.what = 1;
        VoiceInputLayout.d(this.vme).sendMessage(message);
    }
}
