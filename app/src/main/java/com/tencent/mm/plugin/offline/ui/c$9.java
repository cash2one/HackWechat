package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;

class c$9 implements OnClickListener {
    final /* synthetic */ c oXK;

    c$9(c cVar) {
        this.oXK = cVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        a.bhS();
        h.bu(this.oXK.mActivity, this.oXK.mActivity.getResources().getString(i.uXE));
        c.a(this.oXK);
    }
}
