package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class BackupMoveRecoverUI$2 implements OnClickListener {
    final /* synthetic */ int kly;
    final /* synthetic */ BackupMoveRecoverUI kmF;

    BackupMoveRecoverUI$2(BackupMoveRecoverUI backupMoveRecoverUI, int i) {
        this.kmF = backupMoveRecoverUI;
        this.kly = i;
    }

    public final void onClick(View view) {
        h.a(this.kmF, R.l.dHA, R.l.dHz, R.l.dIp, R.l.dHo, new 1(this), null, R.e.brw);
    }
}
