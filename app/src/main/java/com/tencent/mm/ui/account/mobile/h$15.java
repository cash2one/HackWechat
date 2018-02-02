package com.tencent.mm.ui.account.mobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.z.ar;

class h$15 implements OnClickListener {
    final /* synthetic */ k flZ;
    final /* synthetic */ h xUN;

    h$15(h hVar, k kVar) {
        this.xUN = hVar;
        this.flZ = kVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ar.CG().a(701, this.xUN);
        this.xUN.xQO = new a(new 1(this), ((s) this.flZ).getUsername(), ((s) this.flZ).NV(), this.xUN.xUE.fAf);
        this.xUN.xQO.j(this.xUN.xUE);
    }
}
