package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CompressPreviewUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ CompressPreviewUI prM;

    CompressPreviewUI$4(CompressPreviewUI compressPreviewUI) {
        this.prM = compressPreviewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent(this.prM, AttachDownloadPage.class);
        intent.putExtra("attach_name", CompressPreviewUI.e(this.prM));
        intent.putExtra("mail_id", CompressPreviewUI.b(this.prM));
        intent.putExtra("attach_id", CompressPreviewUI.f(this.prM));
        intent.putExtra("total_size", CompressPreviewUI.g(this.prM));
        intent.putExtra("is_preview", 0);
        intent.putExtra("is_compress", true);
        this.prM.startActivity(intent);
        return true;
    }
}
