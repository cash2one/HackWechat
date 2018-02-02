package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class BackupUI$1 implements OnClickListener {
    final /* synthetic */ BackupUI kmO;

    BackupUI$1(BackupUI backupUI) {
        this.kmO = backupUI;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(View view) {
        ar.Hg();
        if (((Boolean) c.CU().get(a.USERINFO_BACKUP_MOVE_RECOVERING_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
            if (b.aoR().aol().kiJ == -100) {
                ar.Hg();
                c.CU().a(a.USERINFO_BACKUP_MOVE_RECOVERING_BOOLEAN, Boolean.valueOf(false));
            } else {
                Intent className = new Intent().setClassName(ac.getContext(), "com.tencent.mm.ui.LauncherUI");
                className.addFlags(335544320);
                className.putExtra("nofification_type", "backup_move_notification");
                ac.getContext().startActivity(className);
                return;
            }
        }
        ar.Hg();
        if (!((Boolean) c.CU().get(a.USERINFO_BACKUP_PC_BACKUPING_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
            ar.Hg();
        }
        if (com.tencent.mm.plugin.backup.backuppcmodel.b.aps().aol().kiJ == -100) {
            ar.Hg();
            c.CU().a(a.USERINFO_BACKUP_PC_BACKUPING_BOOLEAN, Boolean.valueOf(false));
            ar.Hg();
            c.CU().a(a.USERINFO_BACKUP_PC_RECOVERING_BOOLEAN, Boolean.valueOf(false));
            final int aow = g.aow();
            if (aow < 50) {
                com.tencent.mm.plugin.report.service.g.pQN.a(485, 7, 1, false);
                com.tencent.mm.plugin.report.service.g.pQN.h(11787, Integer.valueOf(4));
                h.a(this.kmO, R.l.dHH, R.l.dHG, R.l.dJQ, R.l.dHo, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ BackupUI$1 kmQ;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        x.i("MicroMsg.BackupUI", "low battery, user click sure. battery:%d", Integer.valueOf(aow));
                        com.tencent.mm.plugin.report.service.g.pQN.a(485, 21, 1, false);
                        com.tencent.mm.plugin.report.service.g.pQN.h(11788, Integer.valueOf(3));
                        MMWizardActivity.A(this.kmQ.kmO, new Intent(this.kmQ.kmO, BackupMoveChooseUI.class));
                    }
                }, null, R.e.brv);
                return;
            }
            com.tencent.mm.plugin.report.service.g.pQN.a(485, 21, 1, false);
            com.tencent.mm.plugin.report.service.g.pQN.h(11788, Integer.valueOf(3));
            MMWizardActivity.A(this.kmO, new Intent(this.kmO, BackupMoveChooseUI.class));
            return;
        }
        className = new Intent().setClassName(ac.getContext(), "com.tencent.mm.ui.LauncherUI");
        className.addFlags(335544320);
        className.putExtra("nofification_type", "back_to_pcmgr_notification");
        ac.getContext().startActivity(className);
    }
}
