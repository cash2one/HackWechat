package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.SpanWatcher;
import android.text.Spannable;
import com.tencent.mm.sdk.platformtools.x;

class x$2 implements SpanWatcher {
    final /* synthetic */ x jZj;

    x$2(x xVar) {
        this.jZj = xVar;
    }

    public final void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
        if (af.bm(obj)) {
            x.d("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanAdded %s, %s", new Object[]{spannable, obj.getClass().getSimpleName()});
        }
    }

    public final void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
        if (af.bm(obj)) {
            x.d("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanRemoved %s, %s", new Object[]{spannable, obj.getClass().getSimpleName()});
            this.jZj.jKT.removeCallbacks(this.jZj.jZi);
            this.jZj.jKT.postDelayed(this.jZj.jZi, 100);
        }
    }

    public final void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
        if (af.bm(obj)) {
            x.d("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanChanged %s, %s", new Object[]{spannable, obj.getClass().getSimpleName()});
        }
    }
}
