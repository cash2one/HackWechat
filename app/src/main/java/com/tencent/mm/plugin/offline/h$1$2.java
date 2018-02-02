package com.tencent.mm.plugin.offline;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.offline.h.1;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.ui.MMActivity;

class h$1$2 implements OnClickListener {
    final /* synthetic */ MMActivity jvm;
    final /* synthetic */ 1 oVI;
    final /* synthetic */ int oVJ;

    h$1$2(1 1, MMActivity mMActivity, int i) {
        this.oVI = 1;
        this.jvm = mMActivity;
        this.oVJ = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.X(this.jvm, this.oVJ);
        this.oVI.oVH.a(this.jvm, 0, h.m(this.oVI.oVH));
    }
}
