package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

class ShareToQQWeiboUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ ShareToQQWeiboUI tJW;

    ShareToQQWeiboUI$2(ShareToQQWeiboUI shareToQQWeiboUI) {
        this.tJW = shareToQQWeiboUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        final k adVar = new ad(this.tJW.getIntent().getIntExtra(DownloadSettingTable$Columns.TYPE, 0), this.tJW.getIntent().getStringExtra("shortUrl"), ShareToQQWeiboUI.a(this.tJW).getText().toString());
        ar.CG().a(adVar, 0);
        ShareToQQWeiboUI shareToQQWeiboUI = this.tJW;
        Context context = this.tJW.mController.xIM;
        this.tJW.getString(R.l.dGO);
        ShareToQQWeiboUI.a(shareToQQWeiboUI, h.a(context, this.tJW.getString(R.l.euA), true, new OnCancelListener(this) {
            final /* synthetic */ ShareToQQWeiboUI$2 tJX;

            public final void onCancel(DialogInterface dialogInterface) {
                ar.CG().c(adVar);
            }
        }));
        return true;
    }
}
