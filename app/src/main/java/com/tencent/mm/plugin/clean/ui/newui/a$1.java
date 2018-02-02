package com.tencent.mm.plugin.clean.ui.newui;

import android.view.View;
import android.view.View.OnClickListener;

class a$1 implements OnClickListener {
    final /* synthetic */ int kI;
    final /* synthetic */ a lhH;

    a$1(a aVar, int i) {
        this.lhH = aVar;
        this.kI = i;
    }

    public final void onClick(View view) {
        if (a.a(this.lhH).contains(Integer.valueOf(this.kI))) {
            a.a(this.lhH).remove(Integer.valueOf(this.kI));
        } else {
            a.a(this.lhH).add(Integer.valueOf(this.kI));
        }
        this.lhH.notifyDataSetChanged();
        a.b(this.lhH).a(a.a(this.lhH));
    }
}
