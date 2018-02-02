package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.backup.a.f;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.c.a.2;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.plugin.backup.c.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.LinkedList;

class BackupMoveChooseUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ BackupMoveChooseUI kmr;

    BackupMoveChooseUI$2(BackupMoveChooseUI backupMoveChooseUI) {
        this.kmr = backupMoveChooseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        LinkedList linkedList;
        PLong pLong = new PLong();
        PInt pInt = new PInt();
        a a = BackupMoveChooseUI.a(this.kmr);
        LinkedList linkedList2 = new LinkedList();
        if (a.kmb.size() <= 0) {
            linkedList = linkedList2;
        } else {
            pLong.value = 0;
            pInt.value = 0;
            LinkedList aoN = b.aoR().aoV().aoN();
            if (aoN != null) {
                for (int i = 0; i < a.getCount(); i++) {
                    if (a.kmb.contains(Integer.valueOf(i))) {
                        linkedList2.add(aoN.get(i));
                        pLong.value += ((f.b) aoN.get(i)).kiS;
                        pInt.value = (int) (((long) pInt.value) + ((f.b) aoN.get(i)).kiT);
                    }
                }
            }
            x.i("MicroMsg.BackupMoveChooseAdapter", "finishSelected usernameSize:%d, convSize:%d, convMsgCount:%d", new Object[]{Integer.valueOf(linkedList2.size()), Long.valueOf(pLong.value), Integer.valueOf(pInt.value)});
            linkedList = linkedList2;
        }
        LinkedList u = g.u(linkedList);
        a aoV = b.aoR().aoV();
        if (linkedList.size() == 0) {
            aoV.kkF = new LinkedList();
        } else {
            aoV.kkF = new LinkedList(linkedList.subList((linkedList.size() * 3) / 4, linkedList.size()));
            aoV.kkF.addAll(linkedList.subList(0, (linkedList.size() * 3) / 4));
        }
        d aoT = b.aoR().aoT();
        aoT.klA = u;
        b.aoR();
        if (b.aoq().getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0) == 1) {
            d.klH = true;
        } else {
            d.klH = false;
        }
        b.aoR();
        aoT.klD = b.aoq().getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0);
        b.aoR();
        aoT.klE = b.aoq().getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0);
        b.aoR();
        if (b.aoq().getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0) == 1) {
            d.kki = true;
        } else {
            d.kki = false;
        }
        x.i("MicroMsg.BackupMoveServer", "setBakupChooseData users size[%d], selectStartTime[%d], selectEndTime[%d], isQuickBackup[%b]", new Object[]{Integer.valueOf(u.size()), Long.valueOf(aoT.klD), Long.valueOf(aoT.klE), Boolean.valueOf(d.kki)});
        ar.Hg();
        c.CU().a(w.a.xtg, Boolean.valueOf(true));
        a aoV2 = b.aoR().aoV();
        if (aoV2.kkA != null) {
            aoV2.kkA.cancel();
        }
        e.post(new 2(aoV2), "BakMoveChooseServer.calculateChooseConvSize");
        if (BackupMoveChooseUI.a(this.kmr).kmc) {
            com.tencent.mm.plugin.report.service.g.pQN.a(485, 22, 1, false);
            com.tencent.mm.plugin.report.service.g.pQN.h(11788, new Object[]{Integer.valueOf(4)});
        }
        if (BackupMoveChooseUI.JM() == 1 && BackupMoveChooseUI.ts() == 1) {
            com.tencent.mm.plugin.report.service.g.pQN.a(485, 26, 1, false);
            com.tencent.mm.plugin.report.service.g.pQN.a(485, 27, 1, false);
            com.tencent.mm.plugin.report.service.g.pQN.h(11788, new Object[]{Integer.valueOf(7)});
        } else if (BackupMoveChooseUI.JM() == 1) {
            com.tencent.mm.plugin.report.service.g.pQN.a(485, 26, 1, false);
            com.tencent.mm.plugin.report.service.g.pQN.h(11788, new Object[]{Integer.valueOf(5)});
        } else if (BackupMoveChooseUI.ts() == 1) {
            com.tencent.mm.plugin.report.service.g.pQN.a(485, 27, 1, false);
            com.tencent.mm.plugin.report.service.g.pQN.h(11788, new Object[]{Integer.valueOf(6)});
        }
        com.tencent.mm.plugin.report.service.g.pQN.h(11788, new Object[]{Integer.valueOf(8)});
        MMWizardActivity.A(this.kmr, new Intent(this.kmr, BackupMoveQRCodeUI.class));
        com.tencent.mm.plugin.report.service.g.pQN.a(485, 23, 1, false);
        return true;
    }
}
