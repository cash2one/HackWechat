package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;

class g$1 implements OnClickListener {
    final /* synthetic */ g kTQ;

    g$1(g gVar) {
        this.kTQ = gVar;
    }

    public final void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        g gVar = this.kTQ;
        if (((Boolean) gVar.kTO.get(intValue)).booleanValue()) {
            gVar.kTO.set(intValue, Boolean.valueOf(false));
        } else {
            gVar.kTO.set(intValue, Boolean.valueOf(true));
        }
        gVar.notifyDataSetChanged();
    }
}
