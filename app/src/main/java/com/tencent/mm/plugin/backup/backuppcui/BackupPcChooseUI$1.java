package com.tencent.mm.plugin.backup.backuppcui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BackupPcChooseUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ BackupPcChooseUI koo;

    BackupPcChooseUI$1(BackupPcChooseUI backupPcChooseUI) {
        this.koo = backupPcChooseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.koo.finish();
        return false;
    }
}
