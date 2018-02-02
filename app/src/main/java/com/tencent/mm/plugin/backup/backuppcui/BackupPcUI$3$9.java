package com.tencent.mm.plugin.backup.backuppcui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcui.BackupPcUI.3;
import com.tencent.mm.ui.MMWizardActivity;

class BackupPcUI$3$9 implements OnClickListener {
    final /* synthetic */ 3 kou;

    BackupPcUI$3$9(3 3) {
        this.kou = 3;
    }

    public final void onClick(View view) {
        MMWizardActivity.A(this.kou.kot, new Intent(this.kou.kot, BackupPcChooseUI.class));
        b.aps().apw().cancel();
        b.aps().apw().aoP();
        b.aps().apw().dH(false);
    }
}
