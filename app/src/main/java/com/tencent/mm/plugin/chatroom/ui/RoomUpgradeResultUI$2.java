package com.tencent.mm.plugin.chatroom.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.z.q;

class RoomUpgradeResultUI$2 implements OnClickListener {
    final /* synthetic */ RoomUpgradeResultUI lco;

    RoomUpgradeResultUI$2(RoomUpgradeResultUI roomUpgradeResultUI) {
        this.lco = roomUpgradeResultUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.lco.getString(R.l.dQv, new Object[]{w.cfi()}));
        intent.putExtra("geta8key_username", q.FS());
        d.c(this.lco, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", 0);
    }
}
