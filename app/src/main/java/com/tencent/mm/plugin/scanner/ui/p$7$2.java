package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.plugin.scanner.ui.p.7;

class p$7$2 implements OnClickListener {
    final /* synthetic */ 7 pYt;

    p$7$2(7 7) {
        this.pYt = 7;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pYt.pYq.pYh = false;
        this.pYt.pYq.pYi = false;
        l.pST.reset();
        l.pST.vE(l.pSQ);
        if (this.pYt.pYq.pXp != null) {
            this.pYt.pYq.pXp.hG(false);
            this.pYt.pYq.pXp.eg(this.pYt.pYq.pXC);
        }
    }
}
