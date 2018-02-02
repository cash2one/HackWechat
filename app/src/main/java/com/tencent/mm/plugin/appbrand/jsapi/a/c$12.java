package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.ui.base.h;

class c$12 implements OnClickListener {
    final /* synthetic */ c jgI;
    final /* synthetic */ View jgQ;

    c$12(c cVar, View view) {
        this.jgI = cVar;
        this.jgQ = view;
    }

    public final void onClick(View view) {
        if (this.jgQ.getParent() != null) {
            ((ViewGroup) this.jgQ.getParent()).removeAllViews();
        }
        h.a(this.jgI.jgr.mContext, false, this.jgI.jgr.getContentView().getResources().getString(j.izf), this.jgQ, this.jgI.jgr.getContentView().getResources().getString(j.ize), "", new 1(this), new 2(this));
    }
}
