package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;

class IPCallMyGiftCardUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ IPCallMyGiftCardUI nKQ;

    IPCallMyGiftCardUI$2(IPCallMyGiftCardUI iPCallMyGiftCardUI) {
        this.nKQ = iPCallMyGiftCardUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.nKQ.getString(R.l.eqF));
        intent.putExtra("showShare", false);
        d.b(this.nKQ, "webview", ".ui.tools.WebViewUI", intent);
        return true;
    }
}
