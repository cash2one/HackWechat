package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.sdk.platformtools.x;

class VoiceSearchEditText$3 implements OnFocusChangeListener {
    final /* synthetic */ VoiceSearchEditText yhM;

    VoiceSearchEditText$3(VoiceSearchEditText voiceSearchEditText) {
        this.yhM = voiceSearchEditText;
    }

    public final void onFocusChange(View view, boolean z) {
        x.d("MicroMsg.VoiceSearchEditText", "onFocusChange hasFocus = [%s], currentFocusState = [%s]", new Object[]{Boolean.valueOf(z), Boolean.valueOf(VoiceSearchEditText.f(this.yhM))});
        if (!z && VoiceSearchEditText.f(this.yhM)) {
            VoiceSearchEditText.e(this.yhM);
            VoiceSearchEditText.a(this.yhM, false);
        }
    }
}
