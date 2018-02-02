package com.tencent.mm.hardcoder;

import com.tencent.mm.hardcoder.c.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Deque;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public final class e implements Runnable {
    private boolean gKG;
    Queue<com.tencent.mm.hardcoder.c.b> gLd;
    private b gLe;
    private Deque<b> gLf;
    private Thread thread;

    public static class a {
        public final long gLg;
        public final long gLh;
        public long gLi = 0;
        public long gLj = 0;

        public a(long j, long j2) {
            this.gLg = j;
            this.gLh = j2;
            this.gLi = this.gLg;
            this.gLj = this.gLh;
        }

        public final void k(long j, long j2) {
            this.gLi = (this.gLi + j) / 2;
            this.gLj = (this.gLj + j2) / 2;
        }

        public final String toString() {
            return String.format("startFreq:%s,startPower:%s,averageFreq:%s,averagePower:%s", new Object[]{Long.valueOf(this.gLg), Long.valueOf(this.gLh), Long.valueOf(this.gLi), Long.valueOf(this.gLj)});
        }
    }

    public static class b {
        public final a gKA;
        public final a gKB;
        public final Map<Integer, com.tencent.mm.hardcoder.c.a> gKW;
        public final Map<Integer, c> gLk = new TreeMap();
        public long gLl = 0;
        public final long startTime;

        public b(long j, Map<Integer, com.tencent.mm.hardcoder.c.a> map, Map<Integer, c> map2) {
            int[] k = k(map);
            this.gKW = map;
            this.gKA = new a(((com.tencent.mm.hardcoder.c.a) map.get(Integer.valueOf(k[0]))).gKU, (long) ((com.tencent.mm.hardcoder.c.a) map.get(Integer.valueOf(k[0]))).gKV);
            if (k[1] < 0) {
                x.e("MicroMsg.HardCoderStatThread", "cluster one is unused?may be possible.");
                this.gKB = null;
            } else {
                this.gKB = new a(((com.tencent.mm.hardcoder.c.a) map.get(Integer.valueOf(k[1]))).gKU, (long) ((com.tencent.mm.hardcoder.c.a) map.get(Integer.valueOf(k[1]))).gKV);
            }
            this.startTime = j;
            this.gLl = this.startTime;
            l(map2);
        }

        public static int[] k(Map<Integer, com.tencent.mm.hardcoder.c.a> map) {
            if (map == null) {
                throw new NullPointerException("cpuStatusMap can not be null");
            }
            int i;
            int i2;
            for (i = g.gLo; i >= 0; i--) {
                if (map.containsKey(Integer.valueOf(i))) {
                    i2 = i;
                    break;
                }
            }
            i2 = -1;
            if (i2 < 0) {
                throw new NullPointerException("cluster zero is unused?impossible.");
            }
            i = g.gLp;
            while (i > g.gLo) {
                if (map.containsKey(Integer.valueOf(i))) {
                    break;
                }
                i--;
            }
            i = -1;
            return new int[]{i2, i};
        }

        final void l(Map<Integer, c> map) {
            if (map == null) {
                throw new NullPointerException("threadStatusMap can not be null");
            }
            for (Integer num : map.keySet()) {
                c cVar;
                c cVar2 = (c) map.get(num);
                if (this.gLk.containsKey(num)) {
                    cVar = (c) this.gLk.get(num);
                } else {
                    cVar = new c(cVar2.gKY, cVar2.startTime, cVar2.gKZ, cVar2.gLa, cVar2.gKv);
                    this.gLk.put(num, cVar);
                }
                long j = cVar2.gLa;
                long[] jArr = cVar2.gKv;
                cVar.gKx = (j + cVar.gKx) / 2;
                if (jArr != null) {
                    cVar.gLb = (jArr[0] - cVar.gKv[0]) + (jArr[1] - cVar.gKv[1]);
                    if (HardCoderJNI.hcDebug) {
                        x.d("MicroMsg.HardCoderMonitor", "thread id:" + cVar.gKY + ",start jiffies:[" + cVar.gKv[0] + "," + cVar.gKv[1] + "], end jiffies:[" + jArr[0] + "," + jArr[1] + "]");
                    }
                }
            }
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.format("startTime:%s,updateTime:%s", new Object[]{Long.valueOf(this.startTime), Long.valueOf(this.gLl)}));
            stringBuilder.append(",");
            stringBuilder.append(this.gKA);
            if (this.gKB != null) {
                stringBuilder.append(",");
                stringBuilder.append(this.gKB);
            }
            stringBuilder.append(",");
            stringBuilder.append(this.gLk.toString());
            return stringBuilder.toString();
        }
    }

    public final void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                if (this.gLd.isEmpty()) {
                    synchronized (this) {
                        if (this.gKG) {
                            x.i("MicroMsg.HardCoderStatThread", "snapshotStatDeque size:" + this.gLf.size());
                            if (this.thread != null) {
                                this.thread.interrupt();
                                this.thread = null;
                                this.gKG = false;
                            }
                        }
                        wait();
                    }
                } else {
                    com.tencent.mm.hardcoder.c.b bVar = (com.tencent.mm.hardcoder.c.b) this.gLd.poll();
                    if (bVar != null) {
                        b bVar2;
                        long j = bVar.time;
                        Map map = bVar.gKW;
                        Map map2 = bVar.gKX;
                        if (this.gLe == null) {
                            this.gLe = new b(j, map, map2);
                        } else {
                            bVar2 = this.gLe;
                            int[] k = b.k(map);
                            bVar2.gLl = j;
                            bVar2.gKA.k(((com.tencent.mm.hardcoder.c.a) map.get(Integer.valueOf(k[0]))).gKU, (long) ((com.tencent.mm.hardcoder.c.a) map.get(Integer.valueOf(k[0]))).gKV);
                            if (bVar2.gKB != null) {
                                bVar2.gKB.k(((com.tencent.mm.hardcoder.c.a) map.get(Integer.valueOf(k[1]))).gKU, (long) ((com.tencent.mm.hardcoder.c.a) map.get(Integer.valueOf(k[1]))).gKV);
                            }
                            bVar2.l(map2);
                        }
                        x.i("MicroMsg.HardCoderStatThread", this.gLe.toString());
                        bVar2 = new b(j, map, map2);
                        b bVar3 = (b) this.gLf.peekFirst();
                        b bVar4 = (b) this.gLf.peekLast();
                        if (bVar3 == null || bVar4 == null) {
                            this.gLf.add(bVar2);
                        } else {
                            if (bVar4.startTime - bVar3.startTime >= 30000) {
                                this.gLf.removeFirst();
                            }
                            this.gLf.add(bVar2);
                        }
                    } else {
                        continue;
                    }
                }
            } catch (InterruptedException e) {
                x.e("MicroMsg.HardCoderStatThread", "Stat thread need to interrupt:" + e.getMessage());
                Thread.currentThread().interrupt();
                return;
            } catch (Exception e2) {
                x.e("MicroMsg.HardCoderStatThread", "exception:" + e2.getMessage());
            }
        }
    }

    protected final void finalize() {
        super.finalize();
        this.gLd = null;
        this.gLe = null;
        this.gLf = null;
    }
}
