package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.ipcall.a.e.f;
import com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI.a;
import com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI.a.1;

class IPCallPackageUI$a$1$2 implements OnClickListener {
    final /* synthetic */ 1 nLl;

    IPCallPackageUI$a$1$2(1 1) {
        this.nLl = 1;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        f b = a.a(this.nLl.nLj).nLg;
        b.nGd++;
        a.a(this.nLl.nLj).nLg.finish();
    }
}
