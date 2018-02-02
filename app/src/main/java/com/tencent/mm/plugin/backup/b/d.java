package com.tencent.mm.plugin.backup.b;

import android.util.Pair;
import com.tencent.mm.g.a.bl;
import com.tencent.mm.g.a.pe;
import com.tencent.mm.g.a.z;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.g.a.2;
import com.tencent.mm.protocal.c.er;
import com.tencent.mm.protocal.c.es;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class d {
    private static int kkf = 0;
    private static int kkg = 1;
    private static int kkh = 2;
    private static boolean kki = false;
    private boolean hnr;
    private final int kiF;
    public boolean kjZ = false;
    private final com.tencent.mm.plugin.backup.a.d kjp;
    private final HashMap<String, String> kka = ar.Hg().FN().chM();
    private HashSet<String> kkb = new HashSet();
    private final int kkc;
    private com.tencent.mm.plugin.backup.a.b.d kkd;
    private int kke = kkf;
    private HashMap<String, Pair<Long, Long>> kkj;
    private a kkk;
    private boolean kkl;
    private int kkm;
    private Object lock = new Object();

    static /* synthetic */ void a(d dVar, boolean z, int i) {
        if (dVar.kke == kkg) {
            dVar.kke = kkh;
            aoE();
            if (z) {
                if (dVar.kiF == 1) {
                    ar.Hg();
                    c.CU().a(a.xtf, Boolean.valueOf(false));
                } else if (dVar.kiF == 2) {
                    ar.Hg();
                    c.CU().a(a.xti, Boolean.valueOf(false));
                }
                ar.Hg().FM().chL();
                ar.Hg().FN().chL();
            }
            if (i != 0) {
                dVar.kjp.aol().kiJ = i;
                dVar.mB(i);
            }
            dVar.kke = kkf;
            dVar.aoD();
            dVar.kjp.aon();
        } else if (dVar.kke == kkf) {
            dVar.kke = kkh;
            if (z) {
                if (dVar.kiF == 1) {
                    ar.Hg();
                    c.CU().a(a.xtf, Boolean.valueOf(false));
                } else if (dVar.kiF == 2) {
                    ar.Hg();
                    c.CU().a(a.xti, Boolean.valueOf(false));
                }
                ar.Hg().FM().chL();
                ar.Hg().FN().chL();
            }
            x.i("MicroMsg.BackupRecoverMerger", "cancel and restart sync");
            if (i != 0) {
                dVar.kjp.aol().kiJ = i;
                dVar.mB(i);
            }
            dVar.kke = kkf;
            dVar.aoD();
            dVar.kjp.aon();
        }
    }

    private a aoB() {
        if (this.kkk == null) {
            this.kkk = new a(this, (byte) 0);
        }
        return this.kkk;
    }

    public d(com.tencent.mm.plugin.backup.a.d dVar, int i, com.tencent.mm.plugin.backup.a.b.d dVar2, int i2, boolean z, LinkedList<String> linkedList, LinkedList<Long> linkedList2) {
        x.i("MicroMsg.BackupRecoverMerger", "BackupRecoverMerger, msgListDataIdHashMap size[%d], backupMode[%d], totalSession[%d], isQuickBackup[%b]", new Object[]{Integer.valueOf(this.kka.size()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)});
        this.kjp = dVar;
        this.kiF = i;
        this.kkd = dVar2;
        this.kkc = i2;
        kki = z;
        this.kkj = a((LinkedList) linkedList, (LinkedList) linkedList2);
        this.kkb.clear();
    }

    private static HashMap<String, Pair<Long, Long>> a(LinkedList<String> linkedList, LinkedList<Long> linkedList2) {
        HashMap<String, Pair<Long, Long>> hashMap = new HashMap();
        Iterator it = linkedList2.iterator();
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            String str = (String) it2.next();
            if (it.hasNext()) {
                long longValue = ((Long) it.next()).longValue();
                if (longValue == 0) {
                    longValue = Long.MIN_VALUE;
                }
                if (!it.hasNext()) {
                    break;
                }
                long longValue2 = ((Long) it.next()).longValue();
                if (longValue2 == 0) {
                    longValue2 = Long.MAX_VALUE;
                }
                hashMap.put(str, new Pair(Long.valueOf(longValue), Long.valueOf(longValue2)));
            }
        }
        return hashMap;
    }

    public final synchronized void aoC() {
        if (this.kjZ) {
            x.e("MicroMsg.BackupRecoverMerger", "hasStartMerge , return");
        } else {
            this.kjZ = true;
            x.i("MicroMsg.BackupRecoverMerger", "startMerge");
            this.kjp.aom();
            com.tencent.mm.plugin.backup.g.d.aqe().aqh();
            x.i("MicroMsg.BackupRecoverMerger", "backupStartMerge");
            b.lz(true);
            aoF();
            this.kke = kkg;
            if (this.kiF == 1) {
                ar.Hg();
                c.CU().a(a.xtf, Boolean.valueOf(true));
            } else if (this.kiF == 2) {
                ar.Hg();
                c.CU().a(a.xti, Boolean.valueOf(true));
            }
            x.i("MicroMsg.BackupRecoverMerger", "recoverFromSdcardImp start, mergeState[%d], totalSession size[%d], msgListDataIdHashMap size[%d]", new Object[]{Integer.valueOf(this.kke), Integer.valueOf(this.kkc), Integer.valueOf(this.kka.size())});
            e.d(new 1(this), "BackupRecoverMerger_recoverFromSdcard", 1).start();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(String str, HashMap<String, Integer> hashMap, HashMap<String, LinkedList<Long>> hashMap2) {
        long Wp = bh.Wp();
        byte[] e = com.tencent.mm.a.e.e(str, 0, -1);
        try {
            er erVar;
            es esVar = (es) new es().aF(e);
            Iterator it = esVar.ksP.iterator();
            while (it.hasNext()) {
                erVar = (er) it.next();
                synchronized (this.lock) {
                    if (this.hnr) {
                        x.i("MicroMsg.BackupRecoverMerger", "backupImp canceled");
                        return -1;
                    }
                }
            }
            e.aoK();
            x.i("MicroMsg.BackupRecoverMerger", "readFromSdcard merge item time[%d]", new Object[]{Long.valueOf(bh.bz(Wp))});
            return esVar.ksP.size();
            e.mC(erVar.ktN);
            aoB().aoJ();
        } catch (Throwable e2) {
            Throwable th = e2;
            String str2 = "";
            try {
                File file = new File(str);
                str2 = ((str2 + file.exists() + ",") + file.canRead() + ",") + file.length() + ".";
            } catch (Exception e3) {
            }
            String str3 = "MicroMsg.BackupRecoverMerger";
            String str4 = "read mmPath errr %s [%s] buflen:%d %s,";
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = str2;
            objArr[2] = Integer.valueOf(e == null ? -1 : e.length);
            objArr[3] = th;
            x.printErrStackTrace(str3, th, str4, objArr);
            return 0;
        }
    }

    public final void h(boolean z, int i) {
        synchronized (this.lock) {
            x.i("MicroMsg.BackupRecoverMerger", "cancel, needClearContinueRecoverData[%b], mergeState[%d], updateState[%d]", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.kke), Integer.valueOf(i)});
            this.hnr = true;
        }
        this.kkl = z;
        this.kkm = i;
    }

    private void aoD() {
        this.kjZ = false;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
    }

    public final void mB(int i) {
        if (this.kkd != null) {
            this.kkd.mz(i);
        }
    }

    public static void aoE() {
        x.i("MicroMsg.BackupRecoverMerger", "backupFinishMerge");
        com.tencent.mm.sdk.b.a.xef.m(new bl());
        com.tencent.mm.sdk.b.a.xef.m(new z());
        com.tencent.mm.a.e.g(new File(g.aov()));
        com.tencent.mm.plugin.backup.g.a aqg = com.tencent.mm.plugin.backup.g.d.aqe().aqg();
        aqg.handler.post(new 2(aqg));
        ar.Hg();
        c.Fa().aZn();
        com.tencent.mm.sdk.b.a.xef.m(new pe());
        b.lz(false);
    }

    public static void aoF() {
        com.tencent.mm.plugin.backup.g.d.aqe().aqf().Fa().Et("BACKUP_MERGE_LOCK");
    }

    public static void aoG() {
        com.tencent.mm.plugin.backup.g.d.aqe().aqf().Fa().Eu("BACKUP_MERGE_LOCK");
    }
}
