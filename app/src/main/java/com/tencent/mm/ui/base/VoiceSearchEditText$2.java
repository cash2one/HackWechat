package com.tencent.mm.ui.base;

import android.text.Editable;
import android.text.TextWatcher;

class VoiceSearchEditText$2 implements TextWatcher {
    final /* synthetic */ VoiceSearchEditText yhM;

    VoiceSearchEditText$2(VoiceSearchEditText voiceSearchEditText) {
        this.yhM = voiceSearchEditText;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        VoiceSearchEditText.a(this.yhM, true);
        VoiceSearchEditText.e(this.yhM);
    }

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
