package com.tencent.mm.plugin.game.gamewebview.ui;

import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.mm.ui.base.p.b;

class i$2 implements b {
    final /* synthetic */ i nai;

    i$2(i iVar) {
        this.nai = iVar;
    }

    public final void a(TextView textView, MenuItem menuItem) {
        CharSequence charSequence = menuItem.getTitle();
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
