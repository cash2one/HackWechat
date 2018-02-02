package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.pluginsdk.ui.d.i;

public final class d implements b {
    Context context;
    int kGp;
    int kGq;

    public d(Context context) {
        this.context = context;
    }

    public final View dp(Context context) {
        return View.inflate(context, R.i.dqw, null);
    }

    public final void a(View view, int i, com.tencent.mm.plugin.record.ui.a.b bVar) {
        TextView textView = (TextView) view.findViewById(R.h.cGV);
        textView.setText(bVar.fve.desc);
        i.f(textView, 1);
        textView.setOnLongClickListener(new 1(this, bVar));
        view.setOnTouchListener(new 2(this));
    }

    public final void destroy() {
        this.context = null;
    }

    public final void pause() {
    }
}
