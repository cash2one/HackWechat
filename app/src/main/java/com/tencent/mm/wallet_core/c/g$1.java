package com.tencent.mm.wallet_core.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ui.MMActivity;

class g$1 implements OnClickListener {
    final /* synthetic */ MMActivity fgW;
    final /* synthetic */ g zHr;

    g$1(g gVar, MMActivity mMActivity) {
        this.zHr = gVar;
        this.fgW = mMActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.fgW.finish();
    }
}
