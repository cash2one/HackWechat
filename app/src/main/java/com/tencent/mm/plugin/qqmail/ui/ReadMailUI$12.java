package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.qqmail.b.p$c;

class ReadMailUI$12 implements OnClickListener {
    final /* synthetic */ ReadMailUI puG;

    ReadMailUI$12(ReadMailUI readMailUI) {
        this.puG = readMailUI;
    }

    public final void onClick(View view) {
        ReadMailUI.j(this.puG).setVisibility(8);
        ReadMailUI.a(this.puG, new p$c());
    }
}
