package com.tencent.mm.pluginsdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.x;

class VoiceInputUI$5 implements TextWatcher {
    final /* synthetic */ VoiceInputUI vmw;

    VoiceInputUI$5(VoiceInputUI voiceInputUI) {
        this.vmw = voiceInputUI;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        x.d("VoiceInputUI", "afterTextChanged firstTextChange:%s,textChange:%s", new Object[]{Boolean.valueOf(VoiceInputUI.f(this.vmw)), Boolean.valueOf(VoiceInputUI.g(this.vmw))});
        if (VoiceInputUI.f(this.vmw)) {
            VoiceInputUI.h(this.vmw);
            return;
        }
        VoiceInputUI.d(this.vmw);
        VoiceInputUI.c(this.vmw).requestLayout();
    }
}
