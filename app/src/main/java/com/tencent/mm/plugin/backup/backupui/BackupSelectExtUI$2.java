package com.tencent.mm.plugin.backup.backupui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BackupSelectExtUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ BackupSelectExtUI kqi;

    BackupSelectExtUI$2(BackupSelectExtUI backupSelectExtUI) {
        this.kqi = backupSelectExtUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kqi.finish();
        return true;
    }
}
