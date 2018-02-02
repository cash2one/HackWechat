package com.tencent.mm.ui.account;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;

class RegSetInfoUI$19 implements OnItemClickListener {
    final /* synthetic */ RegSetInfoUI xSg;
    final /* synthetic */ String[] xSp;

    RegSetInfoUI$19(RegSetInfoUI regSetInfoUI, String[] strArr) {
        this.xSg = regSetInfoUI;
        this.xSp = strArr;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (RegSetInfoUI.t(this.xSg) != null) {
            RegSetInfoUI.t(this.xSg).dismiss();
            RegSetInfoUI.u(this.xSg);
        }
        RegSetInfoUI.a(this.xSg).setText(this.xSp[i]);
        RegSetInfoUI.a(this.xSg).postDelayed(new 1(this), 50);
        RegSetInfoUI.r(this.xSg).setText(this.xSg.getString(R.l.eEq));
    }
}
