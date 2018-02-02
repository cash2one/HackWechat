package com.tencent.mm.plugin.record.ui.b;

import android.content.ClipboardManager;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.record.ui.b.d.1;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;

class d$1$2 implements d {
    final /* synthetic */ TextView lbM;
    final /* synthetic */ 1 pGT;

    d$1$2(1 1, TextView textView) {
        this.pGT = 1;
        this.lbM = textView;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (i == 0) {
            ((ClipboardManager) this.pGT.pGS.context.getSystemService("clipboard")).setText(this.lbM.getText());
            h.bt(this.pGT.pGS.context, this.pGT.pGS.context.getString(R.l.dEt));
        }
    }
}
