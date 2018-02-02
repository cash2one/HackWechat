package com.tencent.mm.ui.base.preference;

import com.tencent.mm.ui.base.preference.DialogPreference.a;
import com.tencent.mm.ui.base.preference.i.2;

class i$2$1 implements a {
    final /* synthetic */ Preference jKu;
    final /* synthetic */ DialogPreference yji;
    final /* synthetic */ 2 yjx;

    i$2$1(2 2, DialogPreference dialogPreference, Preference preference) {
        this.yjx = 2;
        this.yji = dialogPreference;
        this.jKu = preference;
    }

    public final void cqm() {
        i.c(this.yjx.yjw);
        if (this.yji.yjI) {
            i.b(this.yjx.yjw).edit().putString(this.jKu.ibD, this.yji.getValue()).commit();
        }
        i.d(this.yjx.yjw).notifyDataSetChanged();
    }
}
