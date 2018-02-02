package com.tencent.mm.plugin.appbrand.game.widget.input;

import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableStringBuilder;

class WAGamePanelInputEditText$3 extends Factory {
    final /* synthetic */ WAGamePanelInputEditText jaE;

    WAGamePanelInputEditText$3(WAGamePanelInputEditText wAGamePanelInputEditText) {
        this.jaE = wAGamePanelInputEditText;
    }

    public final Spannable newSpannable(CharSequence charSequence) {
        return new SpannableStringBuilder(charSequence);
    }
}
