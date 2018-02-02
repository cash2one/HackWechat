package com.tencent.mm.ui.base.preference;

import com.tencent.mm.ui.base.preference.Preference.a;

class MMPreference$1 implements a {
    final /* synthetic */ MMPreference yjh;

    MMPreference$1(MMPreference mMPreference) {
        this.yjh = mMPreference;
    }

    public final boolean a(Preference preference, Object obj) {
        if (!MMPreference.a(this.yjh) && preference.isEnabled() && preference.yjG) {
            boolean z;
            MMPreference.a(this.yjh, true);
            if (preference instanceof CheckBoxPreference) {
                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
                checkBoxPreference.tSw = checkBoxPreference.isChecked();
                if (checkBoxPreference.yjI) {
                    MMPreference.b(this.yjh).edit().putBoolean(preference.ibD, checkBoxPreference.isChecked()).commit();
                }
                MMPreference.c(this.yjh);
                z = true;
            } else {
                z = false;
            }
            if (preference.ibD != null) {
                this.yjh.a(MMPreference.d(this.yjh), preference);
            }
            if (z) {
                MMPreference.d(this.yjh).notifyDataSetChanged();
            }
            MMPreference.a(this.yjh, false);
            if (z) {
                return true;
            }
        }
        return false;
    }
}
