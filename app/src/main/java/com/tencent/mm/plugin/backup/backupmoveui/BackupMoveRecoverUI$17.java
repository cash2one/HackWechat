package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.w;

class BackupMoveRecoverUI$17 implements OnClickListener {
    final /* synthetic */ BackupMoveRecoverUI kmF;

    BackupMoveRecoverUI$17(BackupMoveRecoverUI backupMoveRecoverUI) {
        this.kmF = backupMoveRecoverUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("title", this.kmF.getString(R.l.dIb));
        intent.putExtra("rawUrl", this.kmF.getString(R.l.dIa, new Object[]{w.cfi()}));
        intent.putExtra("showShare", false);
        intent.putExtra("neverGetA8Key", true);
        d.b(this.kmF, "webview", ".ui.tools.WebViewUI", intent);
    }
}
