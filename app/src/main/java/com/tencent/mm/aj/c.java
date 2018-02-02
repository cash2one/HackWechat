package com.tencent.mm.aj;

import android.os.Process;
import com.tencent.mm.loader.stub.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

final class c implements Runnable {
    int huC = 0;
    private d huD = null;
    b huE = new b();
    private long huF = 0;
    private long huG = 0;
    private long huH = 0;
    String huI = null;
    private String huJ = null;
    boolean huK = false;

    c() {
        if (this.huI == null) {
            this.huI = a.gZK + "ProcessDetector";
            File file = new File(this.huI);
            if (!file.exists()) {
                file.mkdir();
            }
        }
        if (ac.cfw()) {
            this.huJ = this.huI + "/mm";
        } else if (ac.cfx()) {
            this.huJ = this.huI + "/push";
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        b bVar;
        Exception e;
        ObjectOutputStream objectOutputStream;
        Throwable th;
        clear();
        this.huG = System.currentTimeMillis();
        this.huH = this.huG;
        this.huD = new d();
        this.huD.a(Process.myPid(), this.huG, this.huH, this.huC);
        if (this.huE.huL.isEmpty()) {
            try {
                bVar = (b) b.h(new FileInputStream(this.huJ));
                if (bVar != null) {
                    bVar.huM.addAll(this.huE.huM);
                    bVar.huN.addAll(this.huE.huN);
                    bVar.huO.addAll(this.huE.huO);
                    this.huE = bVar;
                }
            } catch (Exception e2) {
                x.e("MicroMsg.ActiveDetector.ProcessDetector", "%s,read exception:" + e2.getMessage(), new Object[]{this.huJ});
            }
        }
        a(this.huE);
        this.huE.huL.add(this.huD);
        x.i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]exist process status data size:%s,send broadcast size:%s, receive broadcast size:%s", new Object[]{Integer.valueOf(this.huE.huL.size()), Integer.valueOf(this.huE.huM.size()), Integer.valueOf(this.huE.huN.size())});
        while (this.huK && !Thread.currentThread().isInterrupted()) {
            try {
                int myPid = Process.myPid();
                long currentTimeMillis = System.currentTimeMillis();
                d dVar = this.huD;
                long j = this.huH;
                int i = this.huC;
                long j2 = currentTimeMillis - j;
                if (dVar.huv != i || j2 > 20000) {
                    d b = d.b(myPid, j, currentTimeMillis, i);
                    if (dVar.huv != i) {
                        b.hux = true;
                    }
                    if (j2 > 20000) {
                        b.huw = false;
                    }
                    dVar = b;
                } else {
                    dVar.a(myPid, j, currentTimeMillis, i);
                    dVar = null;
                }
                if (dVar != null) {
                    x.i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]create process status:%s", new Object[]{dVar});
                    this.huD = dVar;
                    this.huE.huL.add(this.huD);
                } else {
                    x.d("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]current process status:%s", new Object[]{this.huD});
                }
                x.d("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]send broadcast:%s,receive broadcast:%s", new Object[]{this.huE.huM, this.huE.huN});
                this.huH = currentTimeMillis;
                if (this.huF <= 0 || currentTimeMillis - this.huF > 180000) {
                    this.huF = currentTimeMillis;
                    if (!(this.huE == null || this.huE.huL == null || this.huE.huL.isEmpty())) {
                        x.d("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]save data to %s", new Object[]{this.huJ});
                        bVar = this.huE;
                        OutputStream fileOutputStream = new FileOutputStream(this.huJ);
                        if (bVar != null) {
                            try {
                                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                                try {
                                    objectOutputStream.writeObject(bVar);
                                    objectOutputStream.flush();
                                    objectOutputStream.close();
                                } catch (Exception e3) {
                                    e2 = e3;
                                    try {
                                        x.w("MicroMsg.ObjectUtil", "Write exception:" + e2.getMessage());
                                        if (objectOutputStream != null) {
                                            objectOutputStream.close();
                                        }
                                        x.i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]one 3*minute per log, current process status:%s", new Object[]{this.huD});
                                        x.i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]one 3*minute per log, send broadcast size:%s,receive broadcast size:%s", new Object[]{Integer.valueOf(this.huE.huM.size()), Integer.valueOf(this.huE.huN.size())});
                                        Thread.sleep(10000);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (objectOutputStream != null) {
                                            objectOutputStream.close();
                                        }
                                        throw th;
                                    }
                                }
                            } catch (Exception e4) {
                                e2 = e4;
                                objectOutputStream = null;
                                x.w("MicroMsg.ObjectUtil", "Write exception:" + e2.getMessage());
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                                x.i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]one 3*minute per log, current process status:%s", new Object[]{this.huD});
                                x.i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]one 3*minute per log, send broadcast size:%s,receive broadcast size:%s", new Object[]{Integer.valueOf(this.huE.huM.size()), Integer.valueOf(this.huE.huN.size())});
                                Thread.sleep(10000);
                            } catch (Throwable th3) {
                                th = th3;
                                objectOutputStream = null;
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                                throw th;
                            }
                        }
                    }
                    x.i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]one 3*minute per log, current process status:%s", new Object[]{this.huD});
                    x.i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]one 3*minute per log, send broadcast size:%s,receive broadcast size:%s", new Object[]{Integer.valueOf(this.huE.huM.size()), Integer.valueOf(this.huE.huN.size())});
                }
            } catch (Exception e22) {
                x.w("MicroMsg.ObjectUtil", "Write close exception:" + e22.getMessage());
            } catch (InterruptedException e5) {
                x.i("MicroMsg.ActiveDetector.ProcessDetector", "process detector thread interrupt.thread id:%s", new Object[]{Integer.valueOf(Process.myTid())});
                Thread.currentThread().interrupt();
                this.huK = false;
            }
            Thread.sleep(10000);
        }
    }

    final void clear() {
        this.huK = false;
        this.huG = 0;
        this.huH = 0;
    }

    private static void a(b bVar) {
        if (bVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                for (d dVar : bVar.huL) {
                    if (dVar != null) {
                        if (currentTimeMillis - dVar.endTime < 86400000) {
                            break;
                        }
                        bVar.huL.remove(dVar);
                    } else {
                        bVar.huL.remove(dVar);
                    }
                }
                for (a aVar : bVar.huM) {
                    if (aVar != null) {
                        if (currentTimeMillis - aVar.time < 86400000) {
                            break;
                        }
                        bVar.huM.remove(aVar);
                    } else {
                        bVar.huM.remove(aVar);
                    }
                }
                for (a aVar2 : bVar.huN) {
                    if (aVar2 != null) {
                        if (currentTimeMillis - aVar2.time < 86400000) {
                            break;
                        }
                        bVar.huN.remove(aVar2);
                    } else {
                        bVar.huN.remove(aVar2);
                    }
                }
                for (c cVar : bVar.huO) {
                    if (cVar == null) {
                        bVar.huO.remove(cVar);
                    } else if (currentTimeMillis - cVar.huP >= 86400000) {
                        bVar.huO.remove(cVar);
                    } else {
                        return;
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ActiveDetector.ProcessDetector", e, "check data exception.", new Object[0]);
            }
        }
    }
}
