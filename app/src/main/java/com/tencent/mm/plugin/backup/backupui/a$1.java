package com.tencent.mm.plugin.backup.backupui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements OnClickListener {
    final /* synthetic */ a kqb;

    a$1(a aVar) {
        this.kqb = aVar;
    }

    public final void onClick(View view) {
        x.i(a.bz(), "backupbanner onclick, backupMode[%d]", new Object[]{Integer.valueOf(d.aoo())});
        switch (d.aoo()) {
            case 1:
                x.i(a.bz(), "backupbanner onclick, backupPcState[%d]", new Object[]{Integer.valueOf(b.aps().aol().kiJ)});
                switch (b.aps().aol().kiJ) {
                    case -4:
                    case 4:
                    case 5:
                    case 12:
                    case 14:
                    case 15:
                    case 22:
                    case 23:
                        x.i(a.bz(), "click backup banner skipToBackupPcUI,BackupPcState[%d]", new Object[]{Integer.valueOf(b.aps().aol().kiJ)});
                        a.a(this.kqb, false);
                        return;
                    case 24:
                    case 25:
                        x.i(a.bz(), "click backup banner skipToBackupPcUI,BackupPcState[%d]", new Object[]{Integer.valueOf(b.aps().aol().kiJ)});
                        a.a(this.kqb, true);
                        return;
                    default:
                        x.i(a.bz(), "click backup banner, BackupPcState[%d]", new Object[]{Integer.valueOf(b.aps().aol().kiJ)});
                        return;
                }
            case 22:
                x.i(a.bz(), "backupbanner onclick, backupMoveState[%d]", new Object[]{Integer.valueOf(com.tencent.mm.plugin.backup.c.b.aoR().aol().kiJ)});
                switch (com.tencent.mm.plugin.backup.c.b.aoR().aol().kiJ) {
                    case -4:
                    case 4:
                    case 5:
                    case 12:
                    case 22:
                    case 23:
                    case 52:
                        x.i(a.bz(), "click backup banner skipToBackupMoveRecoverUI, backupMoveState[%d]", new Object[]{Integer.valueOf(r0)});
                        a.b(this.kqb, false);
                        return;
                    case 24:
                    case 25:
                        x.i(a.bz(), "click backup banner skipToBackupMoveRecoverUI, backupMoveState[%d]", new Object[]{Integer.valueOf(r0)});
                        a.b(this.kqb, true);
                        return;
                    default:
                        x.i(a.bz(), "click backup banner,backupMoveState[%d]", new Object[]{Integer.valueOf(r0)});
                        return;
                }
            default:
                return;
        }
    }
}
