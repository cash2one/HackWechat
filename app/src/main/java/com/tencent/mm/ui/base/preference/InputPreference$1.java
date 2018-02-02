package com.tencent.mm.ui.base.preference;

import android.view.View;
import android.view.View.OnClickListener;

class InputPreference$1 implements OnClickListener {
    final /* synthetic */ InputPreference yiR;

    InputPreference$1(InputPreference inputPreference) {
        this.yiR = inputPreference;
    }

    public final void onClick(View view) {
        if (InputPreference.a(this.yiR) != null && InputPreference.b(this.yiR) != null && InputPreference.b(this.yiR).getText() != null) {
            InputPreference.b(this.yiR).getText().toString();
        }
    }
}
