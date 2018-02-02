package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.Intent;
import com.tencent.mm.ae.e;
import com.tencent.mm.plugin.backup.backuppcmodel.d.2;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.f.b.d;
import com.tencent.mm.plugin.backup.f.f.a;
import com.tencent.mm.plugin.backup.f.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

public final class c {
    private static int hkU = 2;
    private static boolean klo = false;
    private ak kln;
    final e klp = new 1(this);
    private final e klq = new 3(this);
    com.tencent.mm.plugin.backup.f.b.c klu = new com.tencent.mm.plugin.backup.f.b.c(this) {
        final /* synthetic */ c knN;

        {
            this.knN = r1;
        }

        public final void apf() {
            x.i("MicroMsg.BackupPcProcessMgr", "engineStopCallback ");
            b.apK();
            b.aps().aon();
        }
    };
    private final a klv = new 6(this);
    private final i.a klw = new i.a(this) {
        final /* synthetic */ c knN;

        {
            this.knN = r1;
        }

        public final void apd() {
            int i = b.aps().apt().knD;
            if (1 == i || 3 == i) {
                b.aps().apu().mK(b.aps().aol().kiJ);
            } else if (2 == i || 4 == i) {
                b.aps().apv().mz(b.aps().aol().kiJ);
            }
        }

        public final void mE(int i) {
        }

        public final void ape() {
            int i = b.aps().aol().kiJ;
            x.e("MicroMsg.BackupPcProcessMgr", "speedOverTime callback, state[%d]", new Object[]{Integer.valueOf(i)});
            int i2 = b.aps().apt().knD;
            if ((1 == i2 || 3 == i2) && (i == 14 || i == 4)) {
                b.aps().aoS().stop();
                b.aps().apu().al(true);
                g.pQN.a(400, 9, 1, false);
                b.aps().apu().mJ(18);
                b.aps().aol().kiJ = -4;
                b.aps().apu().mK(-4);
            } else if (2 != i2 && 4 != i2) {
            } else {
                if (i == 23 || i == 4) {
                    b.aps().aoS().stop();
                    b.aps().apv().a(true, false, -4);
                    g.pQN.a(400, 17, 1, false);
                    b.aps().apv().mJ(18);
                }
            }
        }
    };
    public int knD = 0;
    public String knE;
    String knF;
    int knG;
    boolean knH;
    private com.tencent.mm.bq.b knI;
    public int knJ;
    public boolean knK = true;
    private final d knL = new 4(this);
    public final com.tencent.mm.plugin.backup.f.g.a knM = new 8(this);

    static /* synthetic */ void a(c cVar, int i, int i2) {
        x.i("MicroMsg.BackupPcProcessMgr", "newBackup, command[%d]", new Object[]{Integer.valueOf(i)});
        cVar.knD = 1;
        b.aps().kiE = null;
        b.aps().apu().init();
        e apu = b.aps().apu();
        x.i("MicroMsg.BackupPcServer", "clearContinueBackupData.");
        apu.klC.dC(false);
        cb(i, i2);
        b.aps().apu().aoj();
    }

    static /* synthetic */ void b(c cVar) {
        b.mA(1);
        b.aps().aom();
        b.a(cVar.klu);
        b.a(cVar.knL);
        b.a(b.aps().aoS());
        b.a(cVar.klw);
        b.a(cVar.klv);
        b.aps().aol().kiJ = 1;
        Intent className = new Intent().setClassName(ac.getContext(), "com.tencent.mm.ui.LauncherUI");
        className.addFlags(335544320);
        className.putExtra("nofification_type", "back_to_pcmgr_notification");
        ac.getContext().startActivity(className);
        klo = false;
        x.i("MicroMsg.BackupPcProcessMgr", "startConnectPc, PC ip:%s, PC wifi:%s, Phone wifi:%s", new Object[]{cVar.knF, cVar.knE, com.tencent.mm.plugin.backup.a.g.cl(ac.getContext())});
        hkU = 2;
        cVar.apx();
    }

    static /* synthetic */ void b(c cVar, int i, int i2) {
        x.i("MicroMsg.BackupPcProcessMgr", "newRecover, command[%d]", new Object[]{Integer.valueOf(i)});
        cVar.knD = 2;
        b.aps().kiE = null;
        b.aps().apv().init();
        b.aps().apv().aoX();
        cb(i, i2);
        d apv = b.aps().apv();
        Set hashSet = new HashSet();
        hashSet.addAll(apv.knP);
        ag.y(new 2(apv, hashSet));
    }

    static /* synthetic */ void d(c cVar) {
        String str = cVar.knE;
        String str2 = cVar.knF;
        String cl = com.tencent.mm.plugin.backup.a.g.cl(ac.getContext());
        b.aps().aoS().stop();
        x.e("MicroMsg.BackupPcProcessMgr", "tryConnectFailed thisWifiName:%s, pcWifiName:%s, pcIpAddress:%s, tryCount:%d", new Object[]{cl, str, str2, Integer.valueOf(hkU)});
        if (cl == null || cl.equals("")) {
            g.pQN.a(400, 1, 1, false);
            g.pQN.h(13736, new Object[]{Integer.valueOf(1), str, cl, Integer.valueOf(0), Integer.valueOf(b.aps().apt().knJ)});
            b.aps().aol().kiJ = -1;
            b.aps().apu().mK(-1);
        } else if (str == null || !str.equals(cl)) {
            g.pQN.a(400, 2, 1, false);
            g.pQN.h(13736, new Object[]{Integer.valueOf(2), str, cl, Integer.valueOf(0), Integer.valueOf(b.aps().apt().knJ)});
            b.aps().aol().kiJ = -2;
            b.aps().apu().mK(-2);
        } else if (!com.tencent.mm.plugin.backup.a.g.vo(str2)) {
            g.pQN.a(400, 3, 1, false);
            g.pQN.h(13736, new Object[]{Integer.valueOf(3), str, cl, Integer.valueOf(0), Integer.valueOf(b.aps().apt().knJ)});
            b.aps().aol().kiJ = -3;
            b.aps().apu().mK(-3);
        } else if (hkU <= 0) {
            g.pQN.a(400, 63, 1, false);
            g.pQN.h(13736, new Object[]{Integer.valueOf(6), str, cl, Integer.valueOf(0), Integer.valueOf(b.aps().apt().knJ)});
            b.aps().aol().kiJ = -5;
            b.aps().apu().mK(-5);
        } else {
            hkU--;
            cVar.apx();
        }
    }

    public final void a(boolean z, com.tencent.mm.bq.b bVar) {
        this.knH = z;
        this.knI = bVar;
    }

    private void apx() {
        b.aps().aoS().connect(this.knF, this.knG);
        b.clear();
        b.a(1, this.klq);
        com.tencent.mm.plugin.backup.f.a aVar = new com.tencent.mm.plugin.backup.f.a(b.aps().kiC, b.aps().kiD, com.tencent.mm.plugin.backup.a.d.aop(), b.aps().kiB, 0, 1);
        aVar.o(true, true);
        aVar.koB.ktP = 1;
        aVar.apQ();
        x.i("MicroMsg.BackupPcProcessMgr", "tryConnect start backupConnectTimerHandler.");
        if (this.kln == null) {
            this.kln = new ak(new ak.a(this) {
                final /* synthetic */ c knN;

                {
                    this.knN = r1;
                }

                public final boolean uF() {
                    if (!c.klo) {
                        x.e("MicroMsg.BackupPcProcessMgr", "tryConnect overtime failed.");
                        if (this.knN.kln != null) {
                            this.knN.kln.TG();
                        }
                        c.d(this.knN);
                    }
                    return true;
                }
            }, false);
        }
        this.kln.J(3000, 3000);
    }

    public static String apy() {
        return b.apN();
    }

    public final void mI(int i) {
        x.i("MicroMsg.BackupPcProcessMgr", "backupSendCommandRequest cmd:%d", new Object[]{Integer.valueOf(i)});
        com.tencent.mm.plugin.backup.h.b bVar = new com.tencent.mm.plugin.backup.h.b();
        bVar.ksA = i;
        if (i == 9) {
            bVar.ksB = this.knI;
        }
        try {
            b.F(bVar.toByteArray(), 17);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupPcProcessMgr", e, "BackupCommandRequest to buf err.", new Object[0]);
        }
    }

    public static void cb(int i, int i2) {
        x.i("MicroMsg.BackupPcProcessMgr", "backupSendCommandResponse cmd:%d", new Object[]{Integer.valueOf(i)});
        com.tencent.mm.plugin.backup.h.c cVar = new com.tencent.mm.plugin.backup.h.c();
        cVar.ksA = i;
        try {
            b.o(cVar.toByteArray(), 18, i2);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupPcProcessMgr", e, "BackupCommandResponse to buf err.", new Object[0]);
        }
    }

    public static void apa() {
        x.i("MicroMsg.BackupPcProcessMgr", "backupSendCancelRequest.");
        com.tencent.mm.plugin.backup.h.a aVar = new com.tencent.mm.plugin.backup.h.a();
        aVar.ID = b.aps().kiB;
        try {
            b.F(aVar.toByteArray(), 5);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupPcProcessMgr", e, "BackupCancelRequest to buf err.", new Object[0]);
        }
    }
}
