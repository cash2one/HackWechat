package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.base.p.d;

class IPCallUserProfileUI$7 implements d {
    final /* synthetic */ IPCallUserProfileUI nNH;
    final /* synthetic */ TextView nNJ;

    IPCallUserProfileUI$7(IPCallUserProfileUI iPCallUserProfileUI, TextView textView) {
        this.nNH = iPCallUserProfileUI;
        this.nNJ = textView;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (i == 0) {
            g.pQN.h(12766, Integer.valueOf(4));
            c.c(this.nNH, this.nNJ.getText().toString());
            Toast.makeText(this.nNH, R.l.eqS, 0).show();
        }
    }
}
