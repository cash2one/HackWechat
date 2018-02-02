package com.tencent.mm.plugin.backup.backuppcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.LinkedList;

class BackupPcChooseUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ BackupPcChooseUI koo;

    BackupPcChooseUI$2(BackupPcChooseUI backupPcChooseUI) {
        this.koo = backupPcChooseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        LinkedList linkedList;
        a a = BackupPcChooseUI.a(this.koo);
        LinkedList linkedList2 = new LinkedList();
        if (a.kmb.size() <= 0) {
            linkedList = linkedList2;
        } else {
            LinkedList aoN = b.aps().apw().aoN();
            if (aoN != null) {
                for (int i = 0; i < a.getCount(); i++) {
                    if (a.kmb.contains(Integer.valueOf(i))) {
                        linkedList2.add(aoN.get(i));
                    }
                }
            }
            x.i("MicroMsg.BackupPcChooseAdapter", "finishSelected usernameSize:%d", Integer.valueOf(linkedList2.size()));
            linkedList = linkedList2;
        }
        final LinkedList u = g.u(linkedList);
        ar.Hg();
        x.i("MicroMsg.BackupPcChooseUI", "initView OnMenuItemClickListener startbackup choose records finish, selectedConversation size[%d], hasMove[%b], timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", Integer.valueOf(linkedList.size()), Boolean.valueOf(((Boolean) c.CU().get(a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.valueOf(false))).booleanValue()), Integer.valueOf(BackupPcChooseUI.JM()), Long.valueOf(BackupPcChooseUI.IL()), Long.valueOf(BackupPcChooseUI.apk()), Integer.valueOf(BackupPcChooseUI.apD()));
        if (((Boolean) c.CU().get(a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
            h.a(this.koo, R.l.dJb, 0, R.l.dJQ, 0, new OnClickListener(this) {
                final /* synthetic */ BackupPcChooseUI$2 kor;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    b.aps().apw().z(linkedList);
                    b.aps().apt().mI(2);
                    b.aps().aol().kiJ = 12;
                    b.aps().apu().A(u);
                    b.aps().apu().bI((long) linkedList.size());
                    com.tencent.mm.plugin.report.service.g.pQN.a(400, 8, 1, false);
                    com.tencent.mm.plugin.report.service.g.pQN.h(13735, Integer.valueOf(10), Integer.valueOf(b.aps().apt().knJ));
                    if (BackupPcChooseUI.JM() == 1 && BackupPcChooseUI.apD() == 1) {
                        com.tencent.mm.plugin.report.service.g.pQN.a(400, 32, 1, false);
                        com.tencent.mm.plugin.report.service.g.pQN.a(400, 35, 1, false);
                        com.tencent.mm.plugin.report.service.g.pQN.h(13735, Integer.valueOf(13), Integer.valueOf(b.aps().apt().knJ));
                    } else if (BackupPcChooseUI.JM() == 1) {
                        com.tencent.mm.plugin.report.service.g.pQN.a(400, 32, 1, false);
                        com.tencent.mm.plugin.report.service.g.pQN.h(13735, Integer.valueOf(11), Integer.valueOf(b.aps().apt().knJ));
                    } else if (BackupPcChooseUI.apD() == 1) {
                        com.tencent.mm.plugin.report.service.g.pQN.a(400, 35, 1, false);
                        com.tencent.mm.plugin.report.service.g.pQN.h(13735, Integer.valueOf(12), Integer.valueOf(b.aps().apt().knJ));
                    }
                    this.kor.koo.finish();
                }
            }, null, R.e.brv);
        } else {
            b.aps().apw().z(linkedList);
            b.aps().apt().mI(2);
            b.aps().aol().kiJ = 12;
            b.aps().apu().A(u);
            b.aps().apu().bI((long) linkedList.size());
            com.tencent.mm.plugin.report.service.g.pQN.a(400, 8, 1, false);
            com.tencent.mm.plugin.report.service.g.pQN.h(13735, Integer.valueOf(10), Integer.valueOf(b.aps().apt().knJ));
            if (BackupPcChooseUI.JM() == 1 && BackupPcChooseUI.apD() == 1) {
                com.tencent.mm.plugin.report.service.g.pQN.a(400, 32, 1, false);
                com.tencent.mm.plugin.report.service.g.pQN.a(400, 35, 1, false);
                com.tencent.mm.plugin.report.service.g.pQN.h(13735, Integer.valueOf(13), Integer.valueOf(b.aps().apt().knJ));
            } else if (BackupPcChooseUI.JM() == 1) {
                com.tencent.mm.plugin.report.service.g.pQN.a(400, 32, 1, false);
                com.tencent.mm.plugin.report.service.g.pQN.h(13735, Integer.valueOf(11), Integer.valueOf(b.aps().apt().knJ));
            } else if (BackupPcChooseUI.apD() == 1) {
                com.tencent.mm.plugin.report.service.g.pQN.a(400, 35, 1, false);
                com.tencent.mm.plugin.report.service.g.pQN.h(13735, Integer.valueOf(12), Integer.valueOf(b.aps().apt().knJ));
            }
            this.koo.finish();
        }
        return true;
    }
}
