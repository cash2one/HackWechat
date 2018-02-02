package com.tencent.mm.ui.base.preference;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class InputPreference$2 implements OnEditorActionListener {
    final /* synthetic */ InputPreference yiR;

    InputPreference$2(InputPreference inputPreference) {
        this.yiR = inputPreference;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (3 != i || InputPreference.a(this.yiR) == null || InputPreference.b(this.yiR) == null) {
            return false;
        }
        if (InputPreference.b(this.yiR).getText() != null) {
            InputPreference.b(this.yiR).getText().toString();
        }
        return true;
    }
}
