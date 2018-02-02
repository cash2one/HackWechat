package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.c;
import com.tencent.mm.plugin.report.service.g;

class NormalUserFooterPreference$c$2 implements OnClickListener {
    final /* synthetic */ c pkM;

    NormalUserFooterPreference$c$2(c cVar) {
        this.pkM = cVar;
    }

    public final void onClick(View view) {
        this.pkM.bjI();
        if (NormalUserFooterPreference.D(this.pkM.pkA) != 0) {
            g.pQN.h(11263, new Object[]{Integer.valueOf(NormalUserFooterPreference.D(this.pkM.pkA)), NormalUserFooterPreference.a(this.pkM.pkA).field_username});
        }
    }
}
