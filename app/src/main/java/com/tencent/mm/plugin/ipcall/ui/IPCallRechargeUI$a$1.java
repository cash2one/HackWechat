package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.a;

class IPCallRechargeUI$a$1 implements OnClickListener {
    final /* synthetic */ a nLP;

    IPCallRechargeUI$a$1(a aVar) {
        this.nLP = aVar;
    }

    public final void onClick(View view) {
        IPCallRechargeUI.b(a.a(this.nLP), ((Integer) view.getTag()).intValue());
    }
}
