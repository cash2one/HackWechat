package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BackupMoveChooseUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ BackupMoveChooseUI kmr;

    BackupMoveChooseUI$1(BackupMoveChooseUI backupMoveChooseUI) {
        this.kmr = backupMoveChooseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kmr.finish();
        return false;
    }
}
