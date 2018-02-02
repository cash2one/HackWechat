package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.wcdb.database.SQLiteDatabase;

class BackupMoveRecoverUI$15 implements OnClickListener {
    final /* synthetic */ BackupMoveRecoverUI kmF;

    BackupMoveRecoverUI$15(BackupMoveRecoverUI backupMoveRecoverUI) {
        this.kmF = backupMoveRecoverUI;
    }

    public final void onClick(View view) {
        g.pQN.h(11789, new Object[]{Integer.valueOf(7)});
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 1);
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        d.b(this.kmF.mController.xIM, "scanner", ".ui.BaseScanUI", intent);
    }
}
