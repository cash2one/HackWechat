package com.tencent.mm.plugin.backup.backuppcui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI;

class BackupPcChooseUI$3 implements OnClickListener {
    final /* synthetic */ BackupPcChooseUI koo;

    BackupPcChooseUI$3(BackupPcChooseUI backupPcChooseUI) {
        this.koo = backupPcChooseUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.koo, BackupSelectExtUI.class);
        intent.putExtra("BACKUP_MODE", 1);
        intent.putExtra("BACKUP_SELECT_TIME_MODE", BackupPcChooseUI.JM());
        intent.putExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", b.aps().apu().knZ);
        intent.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupPcChooseUI.apD());
        intent.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupPcChooseUI.IL());
        intent.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupPcChooseUI.apk());
        intent.putExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", b.aps().apw().kkC);
        this.koo.startActivityForResult(intent, 0);
    }
}
