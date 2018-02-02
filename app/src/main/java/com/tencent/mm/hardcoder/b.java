package com.tencent.mm.hardcoder;

import com.tencent.mm.sdk.platformtools.x;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b implements Runnable {
    private Queue<Object> gKE = new ConcurrentLinkedQueue();
    private g gKF = new g();
    private boolean gKG = false;
    private Thread thread = null;

    public static class a {
        public final boolean fHG;
        public final boolean gKH;
        public final int key;
        public final int value;

        public a(boolean z, int i, int i2, boolean z2) {
            this.gKH = z;
            this.key = i;
            this.value = i2;
            this.fHG = z2;
        }
    }

    public static class b {
        public final List<a> gKI;
        public final int gKJ;
        public final int gKK;
        public final int[] gKu;
        public final long time;

        public b(long j, List<a> list, int i, int i2, int[] iArr) {
            this.time = j;
            this.gKI = list;
            this.gKJ = i;
            this.gKK = i2;
            this.gKu = iArr;
        }
    }

    public b() {
        this.gKF.initialize();
    }

    public final synchronized void start() {
        if (this.thread == null) {
            this.thread = new Thread(this);
            this.thread.setPriority(5);
            this.thread.start();
        }
    }

    public final void run() {
        x.i("MicroMsg.HCPerfStatThread", "[oneliang]HCPerfStatThread running");
        while (!Thread.currentThread().isInterrupted()) {
            try {
                if (this.gKE.isEmpty()) {
                    synchronized (this) {
                        if (this.gKG && this.thread != null) {
                            this.thread.interrupt();
                            this.thread = null;
                            this.gKG = false;
                        }
                        wait();
                    }
                } else {
                    Object poll = this.gKE.poll();
                    if (poll instanceof b) {
                        long[] jArr;
                        b bVar = (b) poll;
                        long j = bVar.time;
                        List list = bVar.gKI;
                        int i = bVar.gKJ;
                        int i2 = bVar.gKK;
                        int[] iArr = bVar.gKu;
                        if (HardCoderJNI.hcDebug) {
                            x.d("MicroMsg.HardCoderReporter", "[oneliang]save task status,time:%s,size:%s,cpu:%s,io:%s", Long.valueOf(j), Integer.valueOf(list.size()), Integer.valueOf(i), Integer.valueOf(i2));
                        }
                        Map a = c.a(j, this.gKF);
                        int[] k = com.tencent.mm.hardcoder.e.b.k(a);
                        long[] myProcCpuTime = HardCoderJNI.getMyProcCpuTime();
                        if (myProcCpuTime == null) {
                            jArr = new long[]{0, 0};
                        } else {
                            jArr = myProcCpuTime;
                        }
                        for (int i3 = 0; i3 < list.size(); i3++) {
                            a aVar = (a) list.get(i3);
                            if (aVar.gKl != 0) {
                                int[] iArr2;
                                int i4;
                                long j2 = j - aVar.lastUpdateTime;
                                aVar.lastUpdateTime = j;
                                if (i == -1) {
                                    aVar.gKq = 0;
                                    iArr2 = aVar.gKs;
                                    i4 = aVar.gKq;
                                    iArr2[i4] = (int) (((long) iArr2[i4]) + j2);
                                } else if (i == -2) {
                                    iArr2 = aVar.gKs;
                                    i4 = aVar.gKq;
                                    iArr2[i4] = (int) (((long) iArr2[i4]) + j2);
                                } else {
                                    aVar.gKq = i;
                                    iArr2 = aVar.gKs;
                                    iArr2[i] = (int) (((long) iArr2[i]) + j2);
                                }
                                if (i2 == -1) {
                                    aVar.gKr = 0;
                                    iArr2 = aVar.gKt;
                                    i4 = aVar.gKr;
                                    iArr2[i4] = (int) (j2 + ((long) iArr2[i4]));
                                } else if (i2 == -2) {
                                    iArr2 = aVar.gKt;
                                    i4 = aVar.gKr;
                                    iArr2[i4] = (int) (j2 + ((long) iArr2[i4]));
                                } else {
                                    aVar.gKr = i2;
                                    iArr2 = aVar.gKt;
                                    iArr2[i2] = (int) (j2 + ((long) iArr2[i2]));
                                }
                                if (iArr != null && iArr.length > 0) {
                                    aVar.gKu = iArr;
                                }
                                long[] threadCpuJiffies = HardCoderJNI.getThreadCpuJiffies(aVar.gKl);
                                if (threadCpuJiffies == null) {
                                    threadCpuJiffies = new long[]{0, 0};
                                }
                                j2 = HardCoderJNI.getCpuFreqByCoreId(HardCoderJNI.getThreadCoreId(aVar.gKl));
                                if (aVar.gKx == 0) {
                                    aVar.gKx = j2;
                                }
                                if (aVar.gKv == null) {
                                    aVar.gKv = threadCpuJiffies;
                                }
                                if (aVar.gKw == null) {
                                    aVar.gKw = jArr;
                                }
                                aVar.gKx = (j2 + aVar.gKx) / 2;
                                if (threadCpuJiffies != null && aVar.gKl > 0) {
                                    aVar.gKy = (int) ((threadCpuJiffies[0] - aVar.gKv[0]) + (threadCpuJiffies[1] - aVar.gKv[1]));
                                    if (HardCoderJNI.hcDebug) {
                                        x.d("MicroMsg.HardCoderReporter", "thread id:" + aVar.gKl + ",start jiffies:[" + aVar.gKv[0] + "," + aVar.gKv[1] + "], end jiffies:[" + threadCpuJiffies[0] + "," + threadCpuJiffies[1] + "],sum thread jiffies:" + aVar.gKy);
                                    }
                                }
                                if (jArr != null && aVar.gKl > 0 && HardCoderJNI.hcDebug) {
                                    aVar.gKz = (jArr[0] - aVar.gKw[0]) + (jArr[1] - aVar.gKw[1]);
                                    x.d("MicroMsg.HardCoderReporter", "thread id:" + aVar.gKl + ",process start jiffies:[" + aVar.gKw[0] + "," + aVar.gKw[1] + "], process end jiffies:[" + jArr[0] + "," + jArr[1] + "],sum process jiffies:" + aVar.gKz);
                                }
                                if (aVar.gKA == null && aVar.gKB == null) {
                                    aVar.gKA = new com.tencent.mm.hardcoder.e.a(((com.tencent.mm.hardcoder.c.a) a.get(Integer.valueOf(k[0]))).gKU, (long) ((com.tencent.mm.hardcoder.c.a) a.get(Integer.valueOf(k[0]))).gKV);
                                    if (k[1] < 0) {
                                        x.e("MicroMsg.HCPerfStatThread", "cluster one is unused?may be possible.");
                                        aVar.gKB = null;
                                    } else {
                                        aVar.gKB = new com.tencent.mm.hardcoder.e.a(((com.tencent.mm.hardcoder.c.a) a.get(Integer.valueOf(k[1]))).gKU, (long) ((com.tencent.mm.hardcoder.c.a) a.get(Integer.valueOf(k[1]))).gKV);
                                    }
                                } else {
                                    if (aVar.gKA != null) {
                                        aVar.gKA.k(((com.tencent.mm.hardcoder.c.a) a.get(Integer.valueOf(k[0]))).gKU, (long) ((com.tencent.mm.hardcoder.c.a) a.get(Integer.valueOf(k[0]))).gKV);
                                    }
                                    if (aVar.gKB != null) {
                                        aVar.gKB.k(((com.tencent.mm.hardcoder.c.a) a.get(Integer.valueOf(k[1]))).gKU, (long) ((com.tencent.mm.hardcoder.c.a) a.get(Integer.valueOf(k[1]))).gKV);
                                    }
                                }
                            }
                        }
                        continue;
                    } else if (poll instanceof a) {
                        d.a((a) poll);
                    } else if (poll instanceof a) {
                        a aVar2 = (a) poll;
                        d.reportIDKey(aVar2.gKH, aVar2.key, aVar2.value, aVar2.fHG);
                    }
                }
            } catch (InterruptedException e) {
                x.e("MicroMsg.HCPerfStatThread", "Performance status thread need to interrupt:" + e.getMessage());
                Thread.currentThread().interrupt();
                return;
            } catch (Exception e2) {
                x.e("MicroMsg.HCPerfStatThread", "exception:" + e2.getMessage());
            }
        }
    }

    public final void aq(Object obj) {
        if (this.gKE != null) {
            this.gKE.add(obj);
            synchronized (this) {
                notify();
            }
        }
    }

    protected final void finalize() {
        super.finalize();
        this.gKE = null;
    }
}
