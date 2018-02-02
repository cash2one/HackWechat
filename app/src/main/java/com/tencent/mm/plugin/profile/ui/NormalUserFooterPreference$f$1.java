package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.f;
import com.tencent.mm.ui.e.a;

class NormalUserFooterPreference$f$1 implements OnClickListener {
    final /* synthetic */ f pkS;

    NormalUserFooterPreference$f$1(f fVar) {
        this.pkS = fVar;
    }

    public final void onClick(View view) {
        d.oSu.T(1, 1, 3);
        Intent intent = new Intent();
        intent.putExtra("Contact_User", NormalUserFooterPreference.a(this.pkS.pkA).field_username);
        intent.putExtra("Contact_Scene", NormalUserFooterPreference.l(this.pkS.pkA));
        intent.putExtra(a.xEi, NormalUserFooterPreference.a(this.pkS.pkA).fWF);
        com.tencent.mm.plugin.profile.a.ifs.a(intent, this.pkS.pkA.mContext);
    }
}
