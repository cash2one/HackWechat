package com.tencent.mm.ui.account;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class EmailVerifyUI$3 implements OnClickListener {
    final /* synthetic */ EmailVerifyUI xNK;

    EmailVerifyUI$3(EmailVerifyUI emailVerifyUI) {
        this.xNK = emailVerifyUI;
    }

    public final void onClick(View view) {
        b.oI(ar.CB() + "," + getClass().getName() + ",R500_250," + ar.fH("R500_250") + ",3");
        h.a(this.xNK, R.l.eDi, R.l.eDc, R.l.dFU, R.l.dEn, new 1(this), null);
    }
}
