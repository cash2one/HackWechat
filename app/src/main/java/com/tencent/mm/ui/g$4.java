package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.g;

class g$4 implements Runnable {
    final /* synthetic */ Context val$context;
    final /* synthetic */ Intent val$intent;

    g$4(Context context, Intent intent) {
        this.val$context = context;
        this.val$intent = intent;
    }

    public final void run() {
        g.a(this.val$context, this.val$intent, this.val$context.getString(R.l.ecb));
    }
}
