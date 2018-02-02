package com.tencent.mm.plugin.gallery.ui;

import android.widget.TextView;
import com.tencent.mm.plugin.gallery.ui.a.c;

class a$c$2 implements a$c$a {
    a$c$2() {
    }

    public final void a(c cVar, int i) {
        if (cVar != null && c.c(cVar) != null) {
            TextView textView = (TextView) c.c(cVar).get();
            if (textView != null) {
                c.d(textView, i);
                c.aOo().remove(textView);
            }
        }
    }
}
