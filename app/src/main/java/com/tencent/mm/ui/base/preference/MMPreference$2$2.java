package com.tencent.mm.ui.base.preference;

import com.tencent.mm.ui.base.preference.EditPreference.a;
import com.tencent.mm.ui.base.preference.MMPreference.2;

class MMPreference$2$2 implements a {
    final /* synthetic */ Preference jKu;
    final /* synthetic */ 2 yjj;
    final /* synthetic */ EditPreference yjk;

    MMPreference$2$2(2 2, EditPreference editPreference, Preference preference) {
        this.yjj = 2;
        this.yjk = editPreference;
        this.jKu = preference;
    }

    public final void cqm() {
        MMPreference.c(this.yjj.yjh);
        if (this.yjk.yjI) {
            MMPreference.b(this.yjj.yjh).edit().putString(this.jKu.ibD, this.yjk.value).commit();
        }
        MMPreference.d(this.yjj.yjh).notifyDataSetChanged();
    }
}
