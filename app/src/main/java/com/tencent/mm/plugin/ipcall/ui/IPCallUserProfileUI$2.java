package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.plugin.report.service.g;

class IPCallUserProfileUI$2 implements OnClickListener {
    final /* synthetic */ IPCallUserProfileUI nNH;

    IPCallUserProfileUI$2(IPCallUserProfileUI iPCallUserProfileUI) {
        this.nNH = iPCallUserProfileUI;
    }

    public final void onClick(View view) {
        g.pQN.h(12766, new Object[]{Integer.valueOf(4)});
        c.c(this.nNH, IPCallUserProfileUI.f(this.nNH));
        Toast.makeText(this.nNH, R.l.eqS, 0).show();
    }
}
