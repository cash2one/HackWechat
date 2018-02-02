package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.sns.ui.bg.9;
import com.tencent.mm.z.ak.a;

class bg$9$2 implements OnCancelListener {
    final /* synthetic */ 9 rMI;
    final /* synthetic */ bd rMJ;

    bg$9$2(9 9, bd bdVar) {
        this.rMI = 9;
        this.rMJ = bdVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        a.hfL.hK(this.rMJ.rMd);
    }
}
