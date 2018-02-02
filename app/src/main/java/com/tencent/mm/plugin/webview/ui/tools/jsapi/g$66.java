package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class g$66 implements OnKeyListener {
    final /* synthetic */ g tIj;

    g$66(g gVar) {
        this.tIj = gVar;
    }

    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        h.a(g.i(this.tIj), true, g.i(this.tIj).getString(R.l.eWW), "", g.i(this.tIj).getString(R.l.eWT), g.i(this.tIj).getString(R.l.eWU), new 1(this), new 2(this));
        return true;
    }
}
