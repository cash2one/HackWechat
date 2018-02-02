package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.plugin.shake.ui.ShakeMsgListUI.2;

class ShakeMsgListUI$2$1 implements OnClickListener {
    final /* synthetic */ 2 qqR;

    ShakeMsgListUI$2$1(2 2) {
        this.qqR = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g a = ShakeMsgListUI.a(this.qqR.qqQ);
        a.gJP.delete(a.getTableName(), null, null);
        ShakeMsgListUI.b(this.qqR.qqQ).Xy();
        ShakeMsgListUI.c(this.qqR.qqQ);
    }
}
