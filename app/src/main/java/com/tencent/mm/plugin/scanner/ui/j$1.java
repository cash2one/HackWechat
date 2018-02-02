package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class j$1 implements OnClickListener {
    final /* synthetic */ j pXz;

    j$1(j jVar) {
        this.pXz = jVar;
    }

    public final void onClick(View view) {
        View inflate = ((LayoutInflater) this.pXz.pXp.getContext().getSystemService("layout_inflater")).inflate(R.i.dqW, null);
        Context context = this.pXz.pXp.getContext();
        h.a(context, context.getString(R.l.eHo), context.getString(R.l.eHn), inflate, new 1(this)).show();
    }
}
