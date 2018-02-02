package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences.Editor;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.backup.a.b.b;
import com.tencent.mm.plugin.backup.b.c;
import com.tencent.mm.plugin.backup.f.b.d;
import com.tencent.mm.plugin.backup.f.h;
import com.tencent.mm.plugin.backup.f.j;
import com.tencent.mm.plugin.backup.h.m;
import com.tencent.mm.plugin.backup.h.o;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class e {
    private static boolean kki = false;
    private static boolean klH = false;
    static boolean knX = false;
    private b kjo = new 5(this);
    LinkedList<String> klA;
    private com.tencent.mm.plugin.backup.b.b klB;
    c klC;
    private long klD = 0;
    private long klE = 0;
    final com.tencent.mm.ae.e klr = new com.tencent.mm.ae.e(this) {
        final /* synthetic */ e koc;

        {
            this.koc = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            com.tencent.mm.plugin.backup.f.b.b(3, this.koc.klr);
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp success, errMsg[%s]", new Object[]{str});
                o oVar = ((j) kVar).kpD;
                if (b.aps().kiB.equals(oVar.ID)) {
                    b.aps().aol().kiM = oVar.kte;
                    x.i("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp BigDataSize[%d]", new Object[]{Long.valueOf(oVar.kte)});
                    ar.Hg();
                    com.tencent.mm.z.c.CU().a(a.xtj, Boolean.valueOf(false));
                    com.tencent.mm.plugin.backup.f.b.apJ();
                    e.a(this.koc);
                    return;
                }
                x.e("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp not the same id");
                g.pQN.a(400, 118, 1, false);
                b.aps().aol().kiJ = -5;
                this.koc.mK(-5);
                return;
            }
            x.e("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp failed, errType[%d], errCode[%d], errMsg[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            g.pQN.a(400, 117, 1, false);
            b.aps().aol().kiJ = -5;
            this.koc.mK(-5);
        }
    };
    public Set<com.tencent.mm.plugin.backup.a.b.c> knP = new HashSet();
    public com.tencent.mm.plugin.backup.a.b.a knQ;
    private boolean knS = false;
    public boolean knY = false;
    public boolean knZ = false;
    final com.tencent.mm.ae.e koa = new 2(this);
    private final d kob = new 3(this);

    static /* synthetic */ void a(e eVar) {
        com.tencent.mm.plugin.backup.f.b.a(11, eVar.koa);
        h hVar = new h(eVar.klA, eVar.klD, eVar.klE);
        x.i("MicroMsg.BackupPcServer", "backupPcSendRequestSession, chooseConvNames size[%d]", new Object[]{Integer.valueOf(eVar.klA.size())});
        hVar.apQ();
    }

    public static void apC() {
        knX = true;
    }

    public final void init() {
        x.i("MicroMsg.BackupPcServer", "BackupPcServer init.");
        knX = false;
        this.knS = false;
        com.tencent.mm.plugin.backup.f.b.a(this.kob);
        this.klC = new c(b.aps(), 1, this.kjo);
    }

    public final void al(boolean z) {
        x.i("MicroMsg.BackupPcServer", "cancel, isSelf[%b], Caller:%s", new Object[]{Boolean.valueOf(z), ai.cfH()});
        knX = true;
        if (!z) {
            b.aps().apt();
            c.apa();
        }
        this.klC.cancel();
        if (this.klB != null) {
            this.klB.cancel();
            this.klB = null;
        }
        com.tencent.mm.plugin.backup.f.b.apK();
        com.tencent.mm.plugin.backup.f.b.apM();
        com.tencent.mm.plugin.backup.f.b.apO();
    }

    public final void A(LinkedList<String> linkedList) {
        this.klA = linkedList;
        b.aps();
        if (b.aoq().getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0) == 1) {
            klH = true;
        } else {
            klH = false;
        }
        b.aps();
        this.klD = b.aoq().getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0);
        b.aps();
        this.klE = b.aoq().getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0);
        b.aps();
        if (b.aoq().getInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0) == 1) {
            kki = true;
        } else {
            kki = false;
        }
        String str = "MicroMsg.BackupPcServer";
        String str2 = "setBackupChooseData users size[%d], isSelectTime[%b], isQuickBackup[%b], selectStartTime[%d], selectEndTime[%d]";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
        objArr[1] = Boolean.valueOf(klH);
        objArr[2] = Boolean.valueOf(kki);
        objArr[3] = Long.valueOf(this.klD);
        objArr[4] = Long.valueOf(this.klE);
        x.i(str, str2, objArr);
        ar.Hg();
        com.tencent.mm.z.c.CU().a(a.xtd, Boolean.valueOf(true));
        if (1 == b.aps().apt().knD) {
            b.aps();
            Editor edit = b.aoq().edit();
            edit.putString("BACKUP_PC_CHOOSE_SESSION", com.tencent.mm.plugin.backup.a.g.a("", ",", linkedList == null ? new String[0] : (String[]) linkedList.toArray(new String[linkedList.size()])));
            edit.commit();
        }
    }

    public static void d(int i, long j, long j2, int i2) {
        long j3 = 0;
        x.i("MicroMsg.BackupPcServer", "setBackupSelectTimeData, timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)});
        if (i == 0) {
            j2 = 0;
        } else {
            j3 = j;
        }
        b.aps();
        Editor edit = b.aoq().edit();
        if (1 == b.aps().apt().knD) {
            edit.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", i);
            edit.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", i2);
            edit.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", j3);
            edit.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", j2);
        }
        edit.commit();
    }

    public final void bI(long j) {
        int i = 3;
        x.i("MicroMsg.BackupPcServer", "backupPcSendStartRequest");
        com.tencent.mm.plugin.backup.f.b.a(3, this.klr);
        j jVar = new j(b.aps().kiB);
        PLong pLong = new PLong();
        PLong pLong2 = new PLong();
        ar.Hg();
        com.tencent.mm.plugin.backup.a.g.a(pLong, pLong2, com.tencent.mm.z.c.FC());
        if (!kki) {
            ar.Hg();
            if (((Boolean) com.tencent.mm.z.c.CU().get(a.xtj, Boolean.valueOf(false))).booleanValue()) {
                i = 0;
            } else {
                i = 1;
            }
        }
        m bH = com.tencent.mm.plugin.backup.a.g.bH(pLong2.value);
        jVar.kpC.kte = 0;
        jVar.kpC.ktf = j;
        jVar.kpC.ktg = 0;
        jVar.kpC.kth = bH;
        jVar.kpC.kti = 0;
        jVar.kpC.ktj = i;
        x.i("MicroMsg.BackupPcServer", "backupPcSendStartRequest sessionCount:%d, transferType:%d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        jVar.apQ();
    }

    public final void mJ(int i) {
        long j;
        long j2 = 0;
        if (this.klC != null) {
            if (this.klC.kjr != 0) {
                j2 = bh.bz(this.klC.kjr);
            }
            j = j2;
            j2 = this.klC.aoy();
        } else {
            j = 0;
            j2 = 0;
        }
        g.pQN.h(13737, new Object[]{Integer.valueOf(i), Long.valueOf(j2), Long.valueOf(j / 1000), Integer.valueOf(1), Integer.valueOf(b.aps().apt().knJ)});
        x.i("MicroMsg.BackupPcServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d kb], backupCostTime[%d s]", new Object[]{Integer.valueOf(13737), Integer.valueOf(i), Long.valueOf(j2), Long.valueOf(j / 1000)});
    }

    public final void aoj() {
        Set hashSet = new HashSet();
        hashSet.addAll(this.knP);
        ag.y(new 4(this, hashSet));
    }

    public final void mK(int i) {
        this.kjo.mz(i);
    }
}
