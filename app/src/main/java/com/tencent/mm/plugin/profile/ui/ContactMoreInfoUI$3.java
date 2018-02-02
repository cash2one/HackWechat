package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.q;

class ContactMoreInfoUI$3 implements OnClickListener {
    final /* synthetic */ ContactMoreInfoUI pis;

    ContactMoreInfoUI$3(ContactMoreInfoUI contactMoreInfoUI) {
        this.pis = contactMoreInfoUI;
    }

    public final void onClick(View view) {
        if (bh.ov(ContactMoreInfoUI.a(this.pis))) {
            ContactMoreInfoUI.a(this.pis, ContactMoreInfoUI.b(this.pis).fWC);
        }
        if (!bh.ov(ContactMoreInfoUI.a(this.pis))) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", ContactMoreInfoUI.a(this.pis));
            intent.putExtra("geta8key_username", q.FS());
            d.b(this.pis, "webview", ".ui.tools.WebViewUI", intent);
        }
    }
}
