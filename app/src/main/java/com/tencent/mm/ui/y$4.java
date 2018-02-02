package com.tencent.mm.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI;

class y$4 implements OnClickListener {
    final /* synthetic */ y xKX;

    y$4(y yVar) {
        this.xKX = yVar;
    }

    public final void onClick(View view) {
        g.pQN.h(11264, new Object[]{Integer.valueOf(1)});
        this.xKX.startActivity(new Intent(this.xKX.getContext(), SelfQRCodeUI.class));
    }
}
