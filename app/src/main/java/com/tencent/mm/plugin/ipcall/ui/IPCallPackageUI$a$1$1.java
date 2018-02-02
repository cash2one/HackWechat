package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.ipcall.a.e.f;
import com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI.a.1;
import com.tencent.mm.protocal.c.bwp;

class IPCallPackageUI$a$1$1 implements OnClickListener {
    final /* synthetic */ bwp nLk;
    final /* synthetic */ 1 nLl;

    IPCallPackageUI$a$1$1(1 1, bwp com_tencent_mm_protocal_c_bwp) {
        this.nLl = 1;
        this.nLk = com_tencent_mm_protocal_c_bwp;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        f b = IPCallPackageUI.b(this.nLl.nLj.nLi);
        b.nGc++;
        IPCallPackageUI.a(this.nLl.nLj.nLi, this.nLk.vIR);
    }
}
