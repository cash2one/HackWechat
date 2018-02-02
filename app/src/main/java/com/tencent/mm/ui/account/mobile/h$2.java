package com.tencent.mm.ui.account.mobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class h$2 implements OnClickListener {
    final /* synthetic */ k flZ;
    final /* synthetic */ Boolean xUA;
    final /* synthetic */ h xUN;
    final /* synthetic */ String xUy;
    final /* synthetic */ String xUz;

    h$2(h hVar, String str, String str2, k kVar, Boolean bool) {
        this.xUN = hVar;
        this.xUy = str;
        this.xUz = str2;
        this.flZ = kVar;
        this.xUA = bool;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ar.CG().a(126, this.xUN);
        final k yVar = new y("", this.xUy, this.xUz, 0, "", this.xUN.xUE.fAf, "", "", this.xUN.xUL, this.xUN.xUE.hNU, "", ((y) this.flZ).Op(), this.xUN.xUE.xKa.coF(), true, this.xUA.booleanValue());
        yVar.mx(this.xUN.xUE.xOW);
        ar.CG().a(yVar, 0);
        MobileVerifyUI mobileVerifyUI = this.xUN.xUE;
        Context context = this.xUN.xUE;
        this.xUN.xUE.getString(R.l.dGO);
        mobileVerifyUI.iln = h.a(context, this.xUN.xUE.getString(R.l.eEh), true, new OnCancelListener(this) {
            final /* synthetic */ h$2 xUO;

            public final void onCancel(DialogInterface dialogInterface) {
                ar.CG().c(yVar);
                ar.CG().b(126, this.xUO.xUN);
            }
        });
    }
}
