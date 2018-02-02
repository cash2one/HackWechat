package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ui.base.h.a;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.j;

class h$14 implements OnClickListener {
    final /* synthetic */ LinearLayout qio;
    final /* synthetic */ a xYT;

    h$14(LinearLayout linearLayout, a aVar) {
        this.qio = linearLayout;
        this.xYT = aVar;
    }

    public final void onClick(View view) {
        for (int i = 0; i < this.qio.getChildCount(); i++) {
            TextView textView = (TextView) this.qio.getChildAt(i);
            if (textView.getId() != g.cSe) {
                textView.setCompoundDrawablesWithIntrinsicBounds(j.dAq, 0, 0, 0);
            }
        }
        ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(j.dAr, 0, 0, 0);
        view.post(new 1(this, ((Integer) view.getTag()).intValue()));
    }
}
