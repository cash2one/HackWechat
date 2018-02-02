package com.tencent.mm.ui.base.preference;

import com.tencent.mm.ui.base.preference.Preference.a;

class i$1 implements a {
    final /* synthetic */ i yjw;

    i$1(i iVar) {
        this.yjw = iVar;
    }

    public final boolean a(Preference preference, Object obj) {
        if (!i.a(this.yjw) && preference.isEnabled() && preference.yjG) {
            boolean z;
            i.a(this.yjw, true);
            if (preference instanceof CheckBoxPreference) {
                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
                checkBoxPreference.tSw = checkBoxPreference.isChecked();
                if (checkBoxPreference.yjI) {
                    i.b(this.yjw).edit().putBoolean(preference.ibD, checkBoxPreference.isChecked()).commit();
                }
                i.c(this.yjw);
                z = true;
            } else {
                z = false;
            }
            if (preference.ibD != null) {
                this.yjw.a(i.d(this.yjw), preference);
            }
            if (z) {
                i.d(this.yjw).notifyDataSetChanged();
            }
            i.a(this.yjw, false);
            if (z) {
                return true;
            }
        }
        return false;
    }
}
