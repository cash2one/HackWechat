package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.mm.l.a;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.ui.base.p.b;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class l$2 implements b {
    final /* synthetic */ Context val$context;

    l$2(Context context) {
        this.val$context = context;
    }

    public final void a(TextView textView, MenuItem menuItem) {
        if (textView != null) {
            ar.Hg();
            a WO = c.EY().WO(menuItem.getTitle());
            if (WO == null || ((int) WO.gJd) <= 0) {
                textView.setText(menuItem.getTitle());
            } else {
                textView.setText(i.a(this.val$context, WO.AP()));
            }
        }
    }
}
