package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI;
import com.tencent.mm.plugin.backup.c.b;

class BackupMoveChooseUI$3 implements OnClickListener {
    final /* synthetic */ BackupMoveChooseUI kmr;

    BackupMoveChooseUI$3(BackupMoveChooseUI backupMoveChooseUI) {
        this.kmr = backupMoveChooseUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.kmr, BackupSelectExtUI.class);
        intent.putExtra("BACKUP_MODE", 2);
        intent.putExtra("BACKUP_SELECT_TIME_MODE", BackupMoveChooseUI.JM());
        intent.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", true);
        intent.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupMoveChooseUI.ts());
        intent.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupMoveChooseUI.apk());
        intent.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupMoveChooseUI.apl());
        intent.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", b.aoR().aoV().kkC);
        this.kmr.startActivityForResult(intent, 0);
    }
}
