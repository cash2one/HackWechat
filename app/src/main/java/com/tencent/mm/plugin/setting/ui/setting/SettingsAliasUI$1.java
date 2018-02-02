package com.tencent.mm.plugin.setting.ui.setting;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;

class SettingsAliasUI$1 implements TextWatcher {
    final /* synthetic */ SettingsAliasUI qjd;

    SettingsAliasUI$1(SettingsAliasUI settingsAliasUI) {
        this.qjd = settingsAliasUI;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        SettingsAliasUI settingsAliasUI = this.qjd;
        a aVar = new a();
        if (charSequence.length() < 6 || charSequence.length() > 20) {
            aVar.fnL = settingsAliasUI.getString(R.l.eSG);
            aVar.frX = false;
        } else if (bh.o(charSequence.charAt(0))) {
            int length = charSequence.length() - 1;
            while (length > 0) {
                char charAt = charSequence.charAt(length);
                if (bh.o(charAt) || charAt == '-' || charAt == '_' || bh.p(charAt)) {
                    length--;
                } else if (Character.isSpace(charAt)) {
                    aVar.fnL = settingsAliasUI.getString(R.l.eSD);
                    aVar.frX = false;
                } else if (bh.n(charAt)) {
                    aVar.fnL = settingsAliasUI.getString(R.l.eSC);
                    aVar.frX = false;
                } else {
                    aVar.fnL = settingsAliasUI.getString(R.l.eSG);
                    aVar.frX = false;
                }
            }
            aVar.fnL = settingsAliasUI.getString(R.l.evA);
            aVar.frX = true;
        } else {
            aVar.fnL = settingsAliasUI.getString(R.l.eSE);
            aVar.frX = false;
        }
        if (aVar.frX) {
            this.qjd.enableOptionMenu(true);
            SettingsAliasUI.a(this.qjd).setTextColor(this.qjd.getResources().getColorStateList(R.e.bsO));
        } else {
            this.qjd.enableOptionMenu(false);
            SettingsAliasUI.a(this.qjd).setTextColor(this.qjd.getResources().getColorStateList(R.e.btO));
        }
        SettingsAliasUI.a(this.qjd).setText(aVar.fnL);
        SettingsAliasUI.b(this.qjd).setText(this.qjd.getString(R.l.dDJ, new Object[]{charSequence}));
    }

    public final void afterTextChanged(Editable editable) {
    }
}
