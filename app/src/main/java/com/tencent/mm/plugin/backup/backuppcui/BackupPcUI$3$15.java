package com.tencent.mm.plugin.backup.backuppcui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3;

class BackupPcUI$3$15 implements OnClickListener {
    final /* synthetic */ 3 kou;

    BackupPcUI$3$15(3 3) {
        this.kou = 3;
    }

    public final void onClick(View view) {
        b.aps().aoS().stop();
        b.aps().aol().kiJ = -100;
        BackupPcUI.j(this.kou.kot);
    }
}
