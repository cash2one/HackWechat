package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.b.af;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b.2;
import com.tencent.mm.plugin.backup.h.ab;
import com.tencent.mm.plugin.backup.h.t;
import com.tencent.mm.protocal.c.er;
import com.tencent.mm.protocal.c.es;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ar;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class f implements com.tencent.mm.ae.f {
    boolean fvI = false;
    boolean hnr = false;
    boolean kjZ = false;
    HashSet<String> kqJ = new HashSet();
    d kqK;
    private e kqL;
    boolean kqM = false;
    int kqQ = 0;
    List<t> krk;
    List<t> krl;
    int krm = 0;
    public boolean krn = false;
    long kro;
    long krp;
    int krq;
    Object lock = new Object();

    class AnonymousClass5 implements Runnable {
        final /* synthetic */ f krr;
        final /* synthetic */ int krt;

        AnonymousClass5(f fVar, int i) {
            this.krr = fVar;
            this.krt = i;
        }

        public final void run() {
            Throwable e;
            com.tencent.mm.plugin.backup.b.e.reset();
            com.tencent.mm.plugin.backup.b.e.aoL();
            c cVar = new c();
            cVar.begin();
            HashMap hashMap = new HashMap();
            HashSet hashSet = new HashSet();
            int i = 0;
            for (t tVar : this.krr.krk) {
                int a;
                try {
                    a = this.krr.a(a.aqi() + "backupItem/" + a.vn(tVar.ID) + tVar.ID, hashMap, cVar, hashSet);
                    if (a < 0) {
                        cVar.end();
                        x.w("MicroMsg.RecoverPCServer", "Thread has been canceled");
                        return;
                    }
                    a += i;
                    try {
                        this.krr.cc(a, this.krt);
                        x.i("MicroMsg.RecoverPCServer", "recover has done: %d", new Object[]{Integer.valueOf(a)});
                        i = a;
                    } catch (Exception e2) {
                        e = e2;
                        x.e("MicroMsg.RecoverPCServer", "Thread.run err:" + e.toString());
                        x.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
                        x.f("MicroMsg.RecoverPCServer", "recoverFromSdcard MMThread.run() " + e.toString());
                        i = a;
                    }
                } catch (Throwable e3) {
                    Throwable th = e3;
                    a = i;
                    e = th;
                    x.e("MicroMsg.RecoverPCServer", "Thread.run err:" + e.toString());
                    x.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
                    x.f("MicroMsg.RecoverPCServer", "recoverFromSdcard MMThread.run() " + e.toString());
                    i = a;
                }
            }
            com.tencent.mm.plugin.backup.bakoldlogic.d.d.k(hashMap);
            cVar.end();
            this.krr.cc(100, 100);
            x.i("MicroMsg.RecoverPCServer", "build temDB finish!");
            x.cfk();
            b aqJ = b.aqJ();
            aqJ.a(new 2(aqJ, new 1(this)), 10);
        }
    }

    static /* synthetic */ void a(f fVar) {
        com.tencent.mm.a.e.g(new File(a.aqi()));
        fVar.kqL = new e(fVar) {
            final /* synthetic */ f krr;

            {
                this.krr = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                x.i("MicroMsg.RecoverPCServer", "onSceneEnd %s, %d, %d", new Object[]{((com.tencent.mm.plugin.backup.bakoldlogic.c.d) kVar).id, Integer.valueOf(i), Integer.valueOf(i2)});
                synchronized (this.krr.lock) {
                    this.krr.kqJ.remove(r10.id);
                    x.i("MicroMsg.RecoverPCServer", "onSceneEnd left: size:%d", new Object[]{Integer.valueOf(this.krr.kqJ.size())});
                    if (this.krr.kqJ.size() <= 10) {
                        this.krr.lock.notifyAll();
                    }
                }
                f fVar = this.krr;
                fVar.kqQ++;
                if (this.krr.kqQ % 300 == 0) {
                    this.krr.aqD();
                }
                this.krr.aqC();
            }
        };
        com.tencent.mm.plugin.backup.f.b.a(7, fVar.kqL);
        for (t tVar : fVar.krl) {
            if (fVar.fvI && !fVar.hnr) {
                x.i("MicroMsg.RecoverPCServer", "hit pause");
                synchronized (fVar.lock) {
                    try {
                        fVar.lock.wait();
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
                    }
                }
            }
            if (fVar.hnr) {
                x.i("MicroMsg.RecoverPCServer", "backupImp canceled");
                return;
            }
            com.tencent.mm.plugin.backup.bakoldlogic.c.d dVar = new com.tencent.mm.plugin.backup.bakoldlogic.c.d(a.aqi(), tVar.ID, 2, tVar.ktH, fVar, a.aql().kiH);
            synchronized (fVar.lock) {
                dVar.apQ();
                fVar.kqJ.add(tVar.ID);
                x.i("MicroMsg.RecoverPCServer", "media recoverImp now: size:%d", new Object[]{Integer.valueOf(fVar.kqJ.size())});
                if (fVar.kqJ.size() > 10) {
                    try {
                        fVar.lock.wait();
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.RecoverPCServer", e2, "", new Object[0]);
                    }
                }
            }
        }
        for (t tVar2 : fVar.krk) {
            if (fVar.fvI && !fVar.hnr) {
                x.i("MicroMsg.RecoverPCServer", "hit pause");
                synchronized (fVar.lock) {
                    try {
                        fVar.lock.wait();
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.RecoverPCServer", e22, "", new Object[0]);
                    }
                }
            }
            if (fVar.hnr) {
                x.i("MicroMsg.RecoverPCServer", "backupImp canceled");
                return;
            }
            dVar = new com.tencent.mm.plugin.backup.bakoldlogic.c.d(a.aqi(), tVar2.ID, 1, tVar2.ktH, fVar, a.aql().kiH);
            synchronized (fVar.lock) {
                dVar.apQ();
                fVar.kqJ.add(tVar2.ID);
                x.i("MicroMsg.RecoverPCServer", "digest recoverImp now: size:%d", new Object[]{Integer.valueOf(fVar.kqJ.size())});
                if (fVar.kqJ.size() > 10) {
                    try {
                        fVar.lock.wait();
                    } catch (Throwable e222) {
                        x.printErrStackTrace("MicroMsg.RecoverPCServer", e222, "", new Object[0]);
                    }
                }
            }
        }
        fVar.kqM = true;
        x.i("MicroMsg.RecoverPCServer", "send RestoreData req finish");
        fVar.aqC();
    }

    public final void pause() {
        x.i("MicroMsg.RecoverPCServer", "pause");
        this.fvI = true;
    }

    public final void resume() {
        x.i("MicroMsg.RecoverPCServer", "resume");
        this.fvI = false;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
    }

    public final void cancel() {
        x.i("MicroMsg.RecoverPCServer", "cancel");
        this.hnr = true;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
        com.tencent.mm.plugin.backup.f.b.b(7, this.kqL);
        this.kqK = null;
        this.krn = false;
        this.kjZ = false;
        this.krm = 0;
        this.krq = 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void aqC() {
        if (this.kqM && !this.hnr) {
            synchronized (this.lock) {
                if (this.kqJ.isEmpty()) {
                    if (this.hnr) {
                        return;
                    }
                    this.krn = true;
                    this.krq = 0;
                    a.aql().aqm().krc = 6;
                    a.aql().aqm().krd = 5;
                    if (this.kqK != null) {
                        this.kqK.aqz();
                    } else {
                        x.i("MicroMsg.RecoverPCServer", "operatorCallback is null");
                    }
                    com.tencent.mm.plugin.backup.f.b.b(7, this.kqL);
                    cc(0, 0);
                    e.aqx();
                    x.i("MicroMsg.RecoverPCServer", "checkRecover publicRestAccUinEven");
                }
            }
        }
    }

    public static int ah(List<t> list) {
        int i = 0;
        for (t tVar : list) {
            try {
                i = ((es) new es().aF(com.tencent.mm.a.e.e(a.aqi() + "backupItem/" + a.vn(tVar.ID) + tVar.ID, 0, -1))).ksP.size() + i;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
            }
        }
        return i;
    }

    final void cc(int i, int i2) {
        int i3 = (int) (i == 0 ? 0 : (((long) i) * 100) / ((long) i2));
        if ((i == 0 && i2 == 0) || i3 > this.krm) {
            this.krm = i3;
            if (!(this.fvI || this.hnr || this.kqK == null || this.krm < 0 || this.krm > 100)) {
                this.kqK.mX(this.krm);
            }
            ab abVar = new ab();
            abVar.ksA = 13;
            abVar.kuc = 0;
            abVar.kud = this.krm;
            try {
                x.i("MicroMsg.RecoverPCServer", "send progress cmd, progress :%d", new Object[]{Integer.valueOf(i3)});
                com.tencent.mm.plugin.backup.f.b.F(abVar.toByteArray(), 3);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.RecoverPCServer", e, "", new Object[0]);
                x.e("MicroMsg.RecoverPCServer", "buf to PacketCommandRequest err");
            }
        }
    }

    final int a(String str, HashMap<String, Integer> hashMap, c cVar, HashSet<String> hashSet) {
        Throwable e;
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        byte[] e2 = com.tencent.mm.a.e.e(str, 0, -1);
        try {
            es esVar = (es) new es().aF(e2);
            Iterator it = esVar.ksP.iterator();
            while (it.hasNext()) {
                er erVar = (er) it.next();
                if (this.fvI && !this.hnr) {
                    synchronized (this.lock) {
                        try {
                            this.lock.wait();
                        } catch (Throwable e3) {
                            x.printErrStackTrace("MicroMsg.RecoverPCServer", e3, "", new Object[0]);
                        }
                    }
                }
                if (this.hnr) {
                    x.i("MicroMsg.RecoverPCServer", "backupImp canceled");
                    return -1;
                }
                try {
                    String str3 = (String) b.aqJ().aqK().CU().get(2, null);
                    com.tencent.mm.plugin.messenger.foundation.a.a.c Fa = b.aqJ().aqK().Fa();
                    str2 = erVar.vGX.wJF;
                    String str4 = erVar.vGY.wJF;
                    String str5;
                    if (bh.ov(str2) || bh.ov(str4)) {
                        str3 = "MicroMsg.BackupPackMsgLogic";
                        str5 = "recoverMsg fromUserName or toUserName is null, fromUserName[%s], toUserName[%s]";
                        Object[] objArr = new Object[2];
                        if (str2 == null) {
                            str2 = "null";
                        }
                        objArr[0] = str2;
                        if (str4 == null) {
                            str4 = "null";
                        }
                        objArr[1] = str4;
                        x.w(str3, str5, objArr);
                    } else {
                        x.i("MicroMsg.BackupPackMsgLogic", "recoverMsg, type[%d], from[%s], to[%s]", new Object[]{Integer.valueOf(erVar.ktN), str2, str4});
                        com.tencent.mm.plugin.backup.bakoldlogic.d.c aqK = b.aqJ().aqK();
                        if (aqK.uin == 0) {
                            throw new com.tencent.mm.z.b();
                        }
                        com.tencent.mm.plugin.messenger.foundation.a.a.f fVar = aqK.kpQ;
                        ar EY = b.aqJ().aqK().EY();
                        Object obj = (fVar.has(str2) || str3.equals(str2)) ? 1 : null;
                        str5 = obj != null ? str4 : str2;
                        long j = erVar.vKj != 0 ? erVar.vKj : ((long) erVar.vKb) * 1000;
                        hashSet.add(str5);
                        List aox = a.aox();
                        if (aox.contains(str2) || aox.contains(str4)) {
                            x.w("MicroMsg.BackupPackMsgLogic", "recoverMsg hit the blockList: " + str2 + " " + str4);
                        } else {
                            if (erVar.vHe == 0 && erVar.vGW != 0) {
                                erVar.vHe = (long) erVar.vGW;
                            }
                            if (erVar.vHe != 0) {
                                if (!str3.equals(str2)) {
                                    str4 = str2;
                                }
                                cf F = Fa.F(str4, erVar.vHe);
                                if (F.field_msgId != 0) {
                                    x.i("MicroMsg.BackupPackMsgLogic", "recoverMsg msg exist");
                                } else {
                                    if (erVar.vHe != 0) {
                                        F.ap(erVar.vHe);
                                    }
                                    F.as((long) erVar.vKi);
                                    F.aq(j);
                                    F.fa(erVar.vKk);
                                    F.setType(erVar.ktN);
                                    af WO = EY.WO(str5);
                                    if (WO == null || bh.ov(WO.field_username) || !WO.cia()) {
                                        F.eR(obj != null ? 1 : 0);
                                        F.dS(str5);
                                        F.eQ(obj != null ? erVar.vKa : 4);
                                        if (hashMap.get(str5) == null) {
                                            hashMap.put(str5, Integer.valueOf(0));
                                        }
                                        if (obj == null && erVar.vKa == 3) {
                                            hashMap.put(str5, Integer.valueOf(bh.a((Integer) hashMap.get(str5), 0) + 1));
                                        }
                                        com.tencent.mm.plugin.backup.bakoldlogic.b.k mQ = com.tencent.mm.plugin.backup.bakoldlogic.b.d.aqk().mQ(erVar.ktN);
                                        if (mQ == null) {
                                            x.i("MicroMsg.BackupPackMsgLogic", "recoverMsg unknown type");
                                        } else {
                                            mQ.a(str3, erVar, F);
                                        }
                                    } else {
                                        x.w("MicroMsg.BackupPackMsgLogic", "recoverMsg hit the blockList: " + str5);
                                    }
                                }
                            } else {
                                x.w("MicroMsg.BackupPackMsgLogic", "recoverMsg drop the item server id < 0");
                            }
                        }
                    }
                    this.kqQ++;
                    if (this.kqQ % 100 == 0) {
                        aqD();
                    }
                } catch (Throwable e32) {
                    x.e("MicroMsg.RecoverPCServer", "readFromSdcard err:" + e32.toString());
                    x.printErrStackTrace("MicroMsg.RecoverPCServer", e32, "", new Object[0]);
                }
                com.tencent.mm.plugin.backup.b.e.mC(erVar.ktN);
                long Wp = bh.Wp();
                if (Wp - cVar.hhB > 10000) {
                    cVar.end();
                    cVar.begin();
                    cVar.hhB = Wp;
                }
            }
            com.tencent.mm.plugin.backup.b.e.aoK();
            x.d("MicroMsg.RecoverPCServer", "read item time " + (System.currentTimeMillis() - currentTimeMillis));
            return esVar.ksP.size();
        } catch (Throwable e4) {
            e32 = e4;
            String str6 = "MicroMsg.RecoverPCServer";
            str2 = "read mmPath errr %s, %s, len:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = str;
            objArr2[1] = e32;
            objArr2[2] = Integer.valueOf(e2 == null ? 0 : e2.length);
            x.e(str6, str2, objArr2);
            x.printErrStackTrace("MicroMsg.RecoverPCServer", e32, "", new Object[0]);
            return 0;
        }
    }

    public final void aqD() {
        System.gc();
        long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
        long totalMemory = Runtime.getRuntime().totalMemory() / 1000;
        x.i("MicroMsg.RecoverPCServer", "memoryInfo avail/total, dalvik[%dk, %dk, user:%dk], recoverCnt:%d", new Object[]{Long.valueOf(freeMemory), Long.valueOf(totalMemory), Long.valueOf(totalMemory - freeMemory), Integer.valueOf(this.kqQ)});
    }

    public final void a(int i, int i2, k kVar) {
        this.krp += (long) i;
        int i3 = this.kro == 0 ? 0 : (int) ((this.krp * 100) / this.kro);
        if (i3 > this.krq) {
            this.krq = i3;
            com.tencent.mm.plugin.backup.bakoldlogic.c.d.setProgress(this.krq);
        }
        if (this.fvI || this.hnr || this.kqK == null || this.krq < 0 || this.krq > 100) {
            x.d("MicroMsg.RecoverPCServer", "failed to call operatorCallback.onNetProgress:%d", new Object[]{Integer.valueOf(this.krq)});
        } else {
            this.kqK.mW(this.krq);
        }
    }
}
