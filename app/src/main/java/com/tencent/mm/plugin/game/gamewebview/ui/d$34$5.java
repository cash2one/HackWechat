package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.game.gamewebview.ui.d.34;
import com.tencent.xweb.f;

class d$34$5 implements OnClickListener {
    final /* synthetic */ 34 mZN;
    final /* synthetic */ f mZO;

    d$34$5(34 34, f fVar) {
        this.mZN = 34;
        this.mZO = fVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.mZO.confirm();
    }
}
