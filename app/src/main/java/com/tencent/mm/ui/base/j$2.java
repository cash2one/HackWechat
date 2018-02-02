package com.tencent.mm.ui.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ui.base.j.a;

class j$2 implements OnClickListener {
    final /* synthetic */ a xZP;

    j$2(a aVar) {
        this.xZP = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.xZP != null) {
            this.xZP.ch(false);
        }
    }
}
