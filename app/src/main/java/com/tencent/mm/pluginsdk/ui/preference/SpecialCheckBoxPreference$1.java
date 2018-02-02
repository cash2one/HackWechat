package com.tencent.mm.pluginsdk.ui.preference;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mm.R;

class SpecialCheckBoxPreference$1 implements OnCheckedChangeListener {
    final /* synthetic */ SpecialCheckBoxPreference vun;

    SpecialCheckBoxPreference$1(SpecialCheckBoxPreference specialCheckBoxPreference) {
        this.vun = specialCheckBoxPreference;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        int id = compoundButton.getId();
        if (id == R.h.cIo) {
            SpecialCheckBoxPreference.a(this.vun);
        } else if (id == R.h.cIn) {
            SpecialCheckBoxPreference.b(this.vun);
        } else if (id == R.h.cIq) {
            SpecialCheckBoxPreference.c(this.vun);
        }
    }
}
