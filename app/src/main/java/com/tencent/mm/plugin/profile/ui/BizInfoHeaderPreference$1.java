package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.pluginsdk.ui.f;

class BizInfoHeaderPreference$1 implements OnClickListener {
    final /* synthetic */ BizInfoHeaderPreference pht;

    BizInfoHeaderPreference$1(BizInfoHeaderPreference bizInfoHeaderPreference) {
        this.pht = bizInfoHeaderPreference;
    }

    public final void onClick(View view) {
        new f(BizInfoHeaderPreference.b(this.pht), BizInfoHeaderPreference.a(this.pht).field_username, BizInfoHeaderPreference.c(this.pht)).caa();
    }
}
