package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.e;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;

class k$2 implements e {
    final /* synthetic */ k pjC;
    final /* synthetic */ NormalUserHeaderPreference pjD;

    k$2(k kVar, NormalUserHeaderPreference normalUserHeaderPreference) {
        this.pjC = kVar;
        this.pjD = normalUserHeaderPreference;
    }

    public final void au(String str, boolean z) {
        this.pjD.bc(str, z);
        this.pjD.jh(this.pjC.jLe.field_username);
    }
}
