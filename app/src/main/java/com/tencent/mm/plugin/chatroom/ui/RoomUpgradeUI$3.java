package com.tencent.mm.plugin.chatroom.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.z.q;

class RoomUpgradeUI$3 implements OnClickListener {
    final /* synthetic */ RoomUpgradeUI lcy;

    RoomUpgradeUI$3(RoomUpgradeUI roomUpgradeUI) {
        this.lcy = roomUpgradeUI;
    }

    public final void onClick(View view) {
        if (RoomUpgradeUI.e(this.lcy).getVisibility() == 0) {
            Intent intent = new Intent();
            RoomUpgradeUI.a(this.lcy, this.lcy.getString(R.l.dQv, new Object[]{w.cfi()}));
            intent.putExtra("rawUrl", RoomUpgradeUI.f(this.lcy));
            intent.putExtra("geta8key_username", q.FS());
            intent.putExtra("showShare", false);
            d.b(this.lcy, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 500);
        }
    }
}
