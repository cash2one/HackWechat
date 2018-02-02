package com.tencent.mm.ui.bindlinkedin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.at.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.bindlinkedin.BindLinkedInUI.8;
import com.tencent.mm.z.ar;

class BindLinkedInUI$8$1 implements OnClickListener {
    final /* synthetic */ 8 ylx;

    BindLinkedInUI$8$1(8 8) {
        this.ylx = 8;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        k bVar = new b();
        BindLinkedInUI.a(this.ylx.ylv, h.a(this.ylx.ylv, this.ylx.ylv.getString(R.l.ctB), false, new 1(this, bVar)));
        ar.CG().a(bVar, 0);
    }
}
