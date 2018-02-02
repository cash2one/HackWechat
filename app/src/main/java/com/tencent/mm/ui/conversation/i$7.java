package com.tencent.mm.ui.conversation;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.ui.base.h;

class i$7 implements OnClickListener {
    final /* synthetic */ i yZy;

    i$7(i iVar) {
        this.yZy = iVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.Dm().F(new 1(this));
        i.e(this.yZy).dismiss();
        h.a(i.a(this.yZy), R.l.dXZ, R.l.dGO, false, new 2(this));
    }
}
