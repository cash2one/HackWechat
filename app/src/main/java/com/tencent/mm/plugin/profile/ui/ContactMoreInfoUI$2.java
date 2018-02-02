package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.z.q;

class ContactMoreInfoUI$2 implements OnClickListener {
    final /* synthetic */ ContactMoreInfoUI pis;

    ContactMoreInfoUI$2(ContactMoreInfoUI contactMoreInfoUI) {
        this.pis = contactMoreInfoUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.pis.pir);
        intent.putExtra("geta8key_username", q.FS());
        d.b(this.pis, "webview", ".ui.tools.WebViewUI", intent);
    }
}
