package com.tencent.mm.ui.account.mobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.accountsync.a.c;
import com.tencent.mm.plugin.accountsync.a.c.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bh;

class h$9 implements OnClickListener {
    final /* synthetic */ h xUN;

    h$9(h hVar) {
        this.xUN = hVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.xUN.xUE.finish();
        c.je(a.ikN);
        if (bh.HO().HP() > 0) {
            b.oH(this.xUN.xUE.pRQ);
            b.b(false, ar.CB() + "," + getClass().getName() + ",RE200_300," + ar.fH("RE200_300") + ",2");
            return;
        }
        b.oH(this.xUN.xUE.pRQ);
        b.b(false, ar.CB() + "," + getClass().getName() + ",R200_300," + ar.fH("R200_300") + ",2");
    }
}
