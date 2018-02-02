package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.ipcall.ui.g.a;

class g$6 implements OnClickListener {
    final /* synthetic */ g nKt;

    g$6(g gVar) {
        this.nKt = gVar;
    }

    public final void onClick(View view) {
        a aVar = (a) view.getTag();
        if (aVar.nKu) {
            aVar.nKu = false;
        } else {
            aVar.nKu = true;
        }
        g.a(this.nKt, (TextView) view);
    }
}
