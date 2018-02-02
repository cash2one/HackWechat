package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.g;

class ReadMailUI$6 implements Runnable {
    final /* synthetic */ ReadMailUI puG;

    ReadMailUI$6(ReadMailUI readMailUI) {
        this.puG = readMailUI;
    }

    public final void run() {
        g.a(this.puG, this.puG.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail"), this.puG.getString(R.l.dQs), null);
    }
}
