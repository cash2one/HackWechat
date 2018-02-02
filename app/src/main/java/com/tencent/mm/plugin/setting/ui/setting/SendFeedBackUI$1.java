package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;

class SendFeedBackUI$1 implements OnClickListener {
    final /* synthetic */ SendFeedBackUI qhI;

    SendFeedBackUI$1(SendFeedBackUI sendFeedBackUI) {
        this.qhI = sendFeedBackUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("showShare", false);
        intent.putExtra("rawUrl", this.qhI.getString(R.l.eXt));
        d.b(this.qhI.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
    }
}
