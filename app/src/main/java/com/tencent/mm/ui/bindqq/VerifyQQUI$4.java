package com.tencent.mm.ui.bindqq;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.af.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class VerifyQQUI$4 implements OnClickListener {
    final /* synthetic */ VerifyQQUI ymV;

    VerifyQQUI$4(VerifyQQUI verifyQQUI) {
        this.ymV = verifyQQUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        k aVar = new a(VerifyQQUI.b(this.ymV), VerifyQQUI.c(this.ymV), VerifyQQUI.g(this.ymV).xPq, VerifyQQUI.g(this.ymV).coF(), VerifyQQUI.g(this.ymV).xPr, VerifyQQUI.d(this.ymV), VerifyQQUI.e(this.ymV), true);
        ar.CG().a(aVar, 0);
        VerifyQQUI verifyQQUI = this.ymV;
        Context context = this.ymV.mController.xIM;
        this.ymV.getString(R.l.dMa);
        VerifyQQUI.a(verifyQQUI, h.a(context, this.ymV.getString(R.l.dLR), true, new 1(this, aVar)));
    }
}
