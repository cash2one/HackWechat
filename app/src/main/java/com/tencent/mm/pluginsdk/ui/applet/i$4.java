package com.tencent.mm.pluginsdk.ui.applet;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;

class i$4 implements OnLongClickListener {
    final /* synthetic */ int kI;
    final /* synthetic */ i vop;
    final /* synthetic */ ViewGroup voq;

    i$4(i iVar, ViewGroup viewGroup, int i) {
        this.vop = iVar;
        this.voq = viewGroup;
        this.kI = i;
    }

    public final boolean onLongClick(View view) {
        return this.vop.voo.oc(this.kI);
    }
}
