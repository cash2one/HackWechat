package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.platformtools.t;

class n$5 implements OnClickListener {
    final /* synthetic */ n zby;

    n$5(n nVar) {
        this.zby = nVar;
    }

    public final void onClick(View view) {
        if (!t.F((Context) this.zby.voC.get(), this.zby.zbo)) {
            Intent intent = new Intent();
            intent.putExtra("title", ((Context) this.zby.voC.get()).getString(R.l.exH));
            intent.putExtra("rawUrl", ((Context) this.zby.voC.get()).getString(R.l.exB));
            intent.putExtra("showShare", false);
            d.b((Context) this.zby.voC.get(), "webview", ".ui.tools.WebViewUI", intent);
        }
    }
}
