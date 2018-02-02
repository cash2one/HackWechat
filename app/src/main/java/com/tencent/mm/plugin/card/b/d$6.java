package com.tencent.mm.plugin.card.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ui.MMActivity;

class d$6 implements OnClickListener {
    final /* synthetic */ MMActivity jvm;
    final /* synthetic */ boolean kXA;

    d$6(boolean z, MMActivity mMActivity) {
        this.kXA = z;
        this.jvm = mMActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (this.kXA) {
            this.jvm.finish();
        }
    }
}
