package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.ipcall.a.e.f;

class IPCallPackageUI$4 implements OnClickListener {
    final /* synthetic */ IPCallPackageUI nLh;

    IPCallPackageUI$4(IPCallPackageUI iPCallPackageUI) {
        this.nLh = iPCallPackageUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        f b = IPCallPackageUI.b(this.nLh);
        b.nGg++;
        IPCallPackageUI.b(this.nLh).finish();
        Intent intent = new Intent();
        intent.setClass(this.nLh.mController.xIM, IPCallRechargeUI.class);
        this.nLh.startActivity(intent);
        this.nLh.finish();
    }
}
