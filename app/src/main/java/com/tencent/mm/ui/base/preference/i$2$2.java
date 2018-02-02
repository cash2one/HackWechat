package com.tencent.mm.ui.base.preference;

import com.tencent.mm.ui.base.preference.EditPreference.a;
import com.tencent.mm.ui.base.preference.i.2;

class i$2$2 implements a {
    final /* synthetic */ Preference jKu;
    final /* synthetic */ EditPreference yjk;
    final /* synthetic */ 2 yjx;

    i$2$2(2 2, EditPreference editPreference, Preference preference) {
        this.yjx = 2;
        this.yjk = editPreference;
        this.jKu = preference;
    }

    public final void cqm() {
        i.c(this.yjx.yjw);
        if (this.yjk.yjI) {
            i.b(this.yjx.yjw).edit().putString(this.jKu.ibD, this.yjk.value).commit();
        }
        i.d(this.yjx.yjw).notifyDataSetChanged();
    }
}
