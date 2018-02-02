package com.tencent.mm.ui.account.mobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class f$3 implements OnClickListener {
    final /* synthetic */ f xUF;

    f$3(f fVar) {
        this.xUF = fVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + this.xUF.xOA.xPq + " img len" + this.xUF.xOA.xPs.length + " " + g.zh());
        k vVar = new v(this.xUF.xOA.hNv, this.xUF.xOA.xPp, this.xUF.xOA.xPt, this.xUF.xKa.coF(), this.xUF.xKa.xPq, this.xUF.xKa.xPr, 1, "", false, true);
        ar.CG().a(vVar, 0);
        Context context = this.xUF.xUE;
        this.xUF.xUE.getString(R.l.dGO);
        h.a(context, this.xUF.xUE.getString(R.l.etF), true, new 1(this, vVar));
    }
}
