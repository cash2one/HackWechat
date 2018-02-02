package com.tencent.mm.pluginsdk.ui.applet;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

class i$3 implements OnClickListener {
    final /* synthetic */ int kI;
    final /* synthetic */ i vop;
    final /* synthetic */ ViewGroup voq;

    i$3(i iVar, ViewGroup viewGroup, int i) {
        this.vop = iVar;
        this.voq = viewGroup;
        this.kI = i;
    }

    public final void onClick(View view) {
        this.vop.vnD.BY(this.kI);
    }
}
