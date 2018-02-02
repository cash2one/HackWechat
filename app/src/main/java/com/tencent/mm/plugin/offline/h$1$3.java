package com.tencent.mm.plugin.offline;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.offline.h.1;
import com.tencent.mm.ui.MMActivity;

class h$1$3 implements OnClickListener {
    final /* synthetic */ MMActivity jvm;
    final /* synthetic */ 1 oVI;

    h$1$3(1 1, MMActivity mMActivity) {
        this.oVI = 1;
        this.jvm = mMActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.oVI.oVH.a(this.jvm, 0, h.n(this.oVI.oVH));
    }
}
