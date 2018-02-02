package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.subapp.c.e;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;

class ai$4 implements OnClickListener {
    final /* synthetic */ au yNY;
    final /* synthetic */ ai yOa;
    final /* synthetic */ e yOc;

    ai$4(ai aiVar, au auVar, e eVar) {
        this.yOa = aiVar;
        this.yNY = auVar;
        this.yOc = eVar;
    }

    public final void onClick(View view) {
        h.a(ai.a(this.yOa).getContext(), R.l.eTO, R.l.eTQ, new 1(this), null);
    }
}
