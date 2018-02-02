package com.tencent.mm.plugin.brandservice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.a.3;
import com.tencent.mm.plugin.profile.a.c;
import com.tencent.mm.z.ar;

class EnterpriseBizContactListView$a$3$1 implements OnCancelListener {
    final /* synthetic */ c kGw;
    final /* synthetic */ 3 kGx;

    EnterpriseBizContactListView$a$3$1(3 3, c cVar) {
        this.kGx = 3;
        this.kGw = cVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.kGw);
        ar.CG().b(1394, this.kGx.kGv);
    }
}
