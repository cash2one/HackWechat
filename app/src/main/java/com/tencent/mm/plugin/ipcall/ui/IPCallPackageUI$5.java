package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.ipcall.a.e.f;

class IPCallPackageUI$5 implements OnClickListener {
    final /* synthetic */ IPCallPackageUI nLh;

    IPCallPackageUI$5(IPCallPackageUI iPCallPackageUI) {
        this.nLh = iPCallPackageUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        f b = IPCallPackageUI.b(this.nLh);
        b.nGh++;
        IPCallPackageUI.b(this.nLh).finish();
    }
}
