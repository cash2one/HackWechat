package com.tencent.mm.plugin.backup.f;

import android.os.Looper;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.backup.e.j;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import junit.framework.Assert;

public abstract class b extends k {
    private static final Map<Integer, Set<e>> gKa = new HashMap();
    private static final af handler = new af(Looper.getMainLooper());
    static int kiF = -1;
    static final LinkedHashMap<Integer, b> koI = new LinkedHashMap();
    private static d koJ;
    static a koK;
    private static f koL = null;
    private static i koM = null;
    private static g koN = null;
    private static int koO = new Random(System.currentTimeMillis()).nextInt(1147483648);
    private static c koP = null;
    PByteArray koH = new PByteArray();

    public interface a {
        void i(int i, byte[] bArr);

        int j(int i, byte[] bArr);
    }

    public interface c {
        void apf();
    }

    public abstract com.tencent.mm.bq.a apH();

    public abstract com.tencent.mm.bq.a apI();

    public abstract int getType();

    public abstract void mL(int i);

    public static void a(d dVar) {
        koJ = dVar;
    }

    public static void a(a aVar) {
        koK = aVar;
    }

    public static void mA(int i) {
        kiF = i;
    }

    public static int aoo() {
        return kiF;
    }

    public static void a(com.tencent.mm.plugin.backup.f.f.a aVar) {
        koL = new f(aVar);
    }

    public static void apJ() {
        boolean z = true;
        if (koL != null) {
            boolean z2;
            f fVar = koL;
            String str = "HeartBeatTimeoutCallback is null";
            if (fVar.klv != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assert.assertTrue(str, z2);
            String str2 = "New BackupHeartBeatHandler EveryTime !";
            if (fVar.kpj != null) {
                z = false;
            }
            Assert.assertTrue(str2, z);
            x.i("MicroMsg.BackupHeartBeatHandler", "start backup heart beat handler.");
            fVar.apZ();
            fVar.kpj = Boolean.valueOf(false);
            com.tencent.mm.sdk.f.e.b(new f$1(fVar), "BackupSendBackupHeartBeat").start();
            fVar.aqa();
            return;
        }
        x.e("MicroMsg.BackupBaseScene", "startHeartBeatHandler backupHeartBeatHandler is null!");
    }

    public static void apK() {
        if (koL != null) {
            f fVar = koL;
            if (fVar.kpj != null) {
                fVar.kpj = Boolean.valueOf(true);
            }
        }
    }

    public static void a(com.tencent.mm.plugin.backup.f.i.a aVar) {
        koM = new i(aVar);
    }

    public static void apL() {
        int i = 0;
        if (koM != null) {
            i iVar = koM;
            x.i("MicroMsg.BackupSpeedCalculator", "start backupGetSpeedTimeHandler.");
            iVar.kpw = bh.Wp();
            iVar.kpv = 0;
            iVar.kpt = 0;
            iVar.kpz.clear();
            iVar.kpy = 0;
            iVar.kpx = 0;
            while (i < 10) {
                iVar.kpz.offer(Long.valueOf(0));
                i++;
            }
            iVar.kpA.J(1000, 1000);
            return;
        }
        x.e("MicroMsg.BackupBaseScene", "startSpeedCalculator backupSpeedCalculator is null!");
    }

    public static void apM() {
        if (koM != null) {
            i iVar = koM;
            x.i("MicroMsg.BackupSpeedCalculator", "stop backupGetSpeedTimeHandler.");
            iVar.kpA.TG();
            iVar.kpy = 0;
        }
    }

    public static String apN() {
        if (koM == null) {
            return "0B";
        }
        x.i("MicroMsg.BackupSpeedCalculator", "getBackupPcSpeed[%s]", new Object[]{i.bJ(koM.kpu)});
        return i.bJ(koM.kpu);
    }

    public static void a(com.tencent.mm.plugin.backup.f.g.a aVar) {
        if (koN == null) {
            x.i("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, no old backupReconnectHandler is stopped, new one.");
        } else if (koN.kpn) {
            x.i("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, old backupReconnectHandler is stopped, new one.");
        } else {
            x.e("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, backupReconnectHandler already running, ignore it.");
            return;
        }
        g gVar = new g(aVar);
        koN = gVar;
        x.i("MicroMsg.BackupReconnectHandler", "start backupReconnectTimeHandler.");
        g.index = 0;
        gVar.kpn = false;
        gVar.kpm = 1;
        if (gVar.kpl != null) {
            gVar.kpo.J(0, 0);
        }
    }

    public static void apO() {
        if (koN != null) {
            koN.kpm = 0;
            g gVar = koN;
            if (!gVar.kpn) {
                x.i("MicroMsg.BackupReconnectHandler", "stop backupReconnectTimeHandler.");
                gVar.kpo.TG();
                gVar.kpn = true;
            }
        }
    }

    public static int apP() {
        if (koN == null) {
            return 0;
        }
        return koN.kpm;
    }

    public static void mM(int i) {
        if (koN != null) {
            koN.kpm = i;
        }
    }

    public static void clear() {
        x.i("MicroMsg.BackupBaseScene", "BackupBaseScene clear.");
        synchronized (koI) {
            koI.clear();
        }
        synchronized (gKa) {
            gKa.clear();
        }
    }

    public static void a(c cVar) {
        koP = cVar;
    }

    public static void apf() {
        if (koP != null) {
            koP.apf();
        }
    }

    public boolean apQ() {
        try {
            byte[] toByteArray = apI().toByteArray();
            synchronized (koI) {
                int apS = apS();
                j.a(toByteArray, apS, (short) getType(), this.koH, kiF);
                if (koK != null) {
                    koK.i(apS, this.koH.value);
                }
                x.i("MicroMsg.BackupBaseScene", "doScene sendSeq[%d], type[%d], buflen[%d]", new Object[]{Integer.valueOf(apS), Integer.valueOf(getType()), Integer.valueOf(this.koH.value.length)});
                koI.put(Integer.valueOf(apS), this);
            }
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupBaseScene", e, "req to buf fail: " + e.toString(), new Object[0]);
            return false;
        }
    }

    public final boolean apR() {
        try {
            byte[] toByteArray = apI().toByteArray();
            synchronized (koI) {
                int apS = apS();
                j.a(toByteArray, apS, (short) getType(), this.koH, kiF);
                if (koK != null) {
                    koK.j(apS, this.koH.value);
                }
                x.i("MicroMsg.BackupBaseScene", "doSceneSameThread sendSeq[%d], type[%d], buflen[%d]", new Object[]{Integer.valueOf(apS), Integer.valueOf(getType()), Integer.valueOf(this.koH.value.length)});
                koI.put(Integer.valueOf(apS), this);
            }
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupBaseScene", e, "req to buf fail: " + e.toString(), new Object[0]);
            return false;
        }
    }

    public static boolean F(byte[] bArr, int i) {
        PByteArray pByteArray = new PByteArray();
        synchronized (koI) {
            int apS = apS();
            j.a(bArr, apS, (short) i, pByteArray, kiF);
            if (koK != null) {
                koK.i(apS, pByteArray.value);
            }
            x.i("MicroMsg.BackupBaseScene", "sendBuf sendSeq[%d], type[%d], buflen[%d]", new Object[]{Integer.valueOf(apS), Integer.valueOf(i), Integer.valueOf(pByteArray.value.length)});
        }
        return true;
    }

    public static boolean o(byte[] bArr, int i, int i2) {
        PByteArray pByteArray = new PByteArray();
        j.a(bArr, i2, (short) i, pByteArray, kiF);
        if (koK != null) {
            koK.i(i2, pByteArray.value);
        }
        x.i("MicroMsg.BackupBaseScene", "sendResp sendSeq[%d], type[%d], len[%d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(pByteArray.value.length)});
        return true;
    }

    public static void b(boolean z, int i, int i2, byte[] bArr) {
        String str = "MicroMsg.BackupBaseScene";
        String str2 = "callback receive isLocal[%b], receiveSeq[%d], type[%d], bufLen[%d]";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        x.i(str, str2, objArr);
        if (z) {
            try {
                x.w("MicroMsg.BackupBaseScene", "callback error buf content : " + (bArr == null ? "null" : new String(bArr)));
            } catch (Exception e) {
            }
            b(z, i2, bArr, i);
            return;
        }
        if (koL != null) {
            koL.apZ();
            x.d("MicroMsg.BackupBaseScene", "updateHeartBeatTimeStamp type:%d, current time stamp:%d", new Object[]{Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis())});
        }
        synchronized (koI) {
            b bVar = (b) koI.remove(Integer.valueOf(i));
        }
        if (bVar == null) {
            x.i("MicroMsg.BackupBaseScene", "notify scene null type:%d", new Object[]{Integer.valueOf(i2)});
            if (bVar == null && i2 == 16) {
                synchronized (koI) {
                    Iterator it = new HashSet(koI.keySet()).iterator();
                    while (it.hasNext()) {
                        Integer num = (Integer) it.next();
                        bVar = (b) koI.get(num);
                        String str3 = "MicroMsg.BackupBaseScene";
                        String str4 = "callback sceneMap seq:%d scene:%s type:%s";
                        Object[] objArr2 = new Object[3];
                        objArr2[0] = num;
                        objArr2[1] = bVar;
                        if (bVar == null) {
                            str = "null";
                        } else {
                            str = Integer.valueOf(bVar.getType());
                        }
                        objArr2[2] = str;
                        x.d(str3, str4, objArr2);
                        if (bVar != null && bVar.getType() == 15) {
                            koI.remove(num);
                            try {
                                bVar.apH().aF(bArr);
                                bVar.mL(i);
                            } catch (Throwable e2) {
                                bVar.f(3, -1, "buf to tagResp fail");
                                x.printErrStackTrace("MicroMsg.BackupBaseScene", e2, "buf to tagResp error, type[%d], errMsg:%s ", new Object[]{Integer.valueOf(bVar.getType()), e2.toString()});
                            }
                        }
                    }
                }
                return;
            }
            x.i("MicroMsg.BackupBaseScene", "notify seq:%d, type:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            b(z, i2, bArr, i);
        } else if (bArr == null) {
            try {
                throw new Exception("buf is null");
            } catch (Throwable e3) {
                bVar.f(3, -1, "buf to resq fail");
                x.printErrStackTrace("MicroMsg.BackupBaseScene", e3, "%s ", new Object[]{e3.toString()});
            }
        } else {
            bVar.apH().aF(bArr);
            bVar.mL(i);
        }
    }

    public static int apS() {
        int i = koO;
        koO++;
        return i;
    }

    public static void mN(int i) {
        if (koM != null) {
            i iVar = koM;
            iVar.kpv = ((long) i) + iVar.kpv;
        }
    }

    private static void b(final boolean z, final int i, final byte[] bArr, final int i2) {
        handler.post(new Runnable() {
            public final void run() {
                if (b.koJ != null) {
                    b.koJ.a(z, i, bArr, i2);
                } else {
                    x.w("MicroMsg.BackupBaseScene", "callbackToNotify, onNotify is null");
                }
            }
        });
    }

    public final void f(int i, int i2, String str) {
        handler.post(new 2(this, i, i2, str));
    }

    public static void a(int i, e eVar) {
        synchronized (gKa) {
            if (!gKa.containsKey(Integer.valueOf(i))) {
                gKa.put(Integer.valueOf(i), new HashSet());
            }
            if (!((Set) gKa.get(Integer.valueOf(i))).contains(eVar)) {
                ((Set) gKa.get(Integer.valueOf(i))).add(eVar);
            }
        }
    }

    public static void b(int i, e eVar) {
        synchronized (gKa) {
            try {
                if (gKa.get(Integer.valueOf(i)) != null) {
                    ((Set) gKa.get(Integer.valueOf(i))).remove(eVar);
                }
            } catch (Exception e) {
                x.e("MicroMsg.BackupBaseScene", "removeSceneEndListener failed:%s", new Object[]{e});
            }
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        return 0;
    }

    public static void a(b bVar) {
        handler.postAtFrontOfQueueV2(new 3(bVar));
    }
}
