package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.q;

class SnsMsgUI$5 implements OnCancelListener {
    final /* synthetic */ SnsMsgUI rDE;
    final /* synthetic */ q rDF;

    SnsMsgUI$5(SnsMsgUI snsMsgUI, q qVar) {
        this.rDE = snsMsgUI;
        this.rDF = qVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.Dk();
        g.Di().gPJ.c(this.rDF);
    }
}
