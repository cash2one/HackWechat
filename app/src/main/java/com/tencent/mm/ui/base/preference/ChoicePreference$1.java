package com.tencent.mm.ui.base.preference;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

class ChoicePreference$1 implements OnCheckedChangeListener {
    final /* synthetic */ ChoicePreference yib;

    ChoicePreference$1(ChoicePreference choicePreference) {
        this.yib = choicePreference;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (ChoicePreference.a(this.yib) != null) {
            if (i != -1) {
                ChoicePreference.a(this.yib, ChoicePreference.b(this.yib)[i - 1048576]);
            } else {
                ChoicePreference.a(this.yib, null);
            }
            ChoicePreference.a(this.yib, i);
            ChoicePreference.a(this.yib).a(this.yib, this.yib.value);
        }
    }
}
