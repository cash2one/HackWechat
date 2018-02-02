package com.tencent.mm.hardcoder;

import android.os.Process;
import android.os.SystemClock;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;

public final class a {
    public static boolean gKb = false;
    private static final int[] gKc = new int[]{0, 1, 2, 3};
    private static final int[] gKd = new int[]{0, 1, 2, 3};
    private static final Map<Integer, Integer> gKe;
    private boolean flS;
    private b gKf;
    LinkedBlockingQueue<Object> gKg;

    static class a {
        public int delay = 0;
        public com.tencent.mm.hardcoder.e.a gKA = null;
        public com.tencent.mm.hardcoder.e.a gKB = null;
        public long gKC = 0;
        public long gKD = 0;
        public int gKi = 0;
        public int gKj = 0;
        public int gKk = 0;
        public int gKl = 0;
        public long gKm = 0;
        public long gKn = 0;
        public long gKo = 0;
        public int gKp = 0;
        int gKq = 0;
        int gKr = 0;
        public int[] gKs = new int[a.gKc.length];
        public int[] gKt = new int[a.gKd.length];
        public int[] gKu = null;
        public long[] gKv = null;
        public long[] gKw = null;
        public long gKx = 0;
        public int gKy = 0;
        public long gKz = 0;
        long lastUpdateTime = 0;
        public int scene = 0;
        public long startTime = 0;
        public String tag;

        a() {
        }

        public final String toString(long j) {
            return String.format("h:%x[%d,%d,%d][%d,%d][%d,%d,%d][%d,%d,%d][%s]", new Object[]{Integer.valueOf(hashCode()), Long.valueOf(this.gKn - j), Long.valueOf(this.startTime - j), Long.valueOf(this.gKo - j), Integer.valueOf(this.delay), Integer.valueOf(this.gKi), Integer.valueOf(this.scene), Long.valueOf(this.gKm), Integer.valueOf(this.gKp), Integer.valueOf(this.gKj), Integer.valueOf(this.gKk), Integer.valueOf(this.gKl), this.tag});
        }
    }

    static final class b {
        public int aen = 0;
        public long gKD = 0;

        b() {
        }
    }

    static /* synthetic */ void a(a aVar) {
        x.i("MicroMsg.HardCoder.HCPerfManager", "HCPerfManager thread[%d] running", Long.valueOf(Thread.currentThread().getId()));
        HashSet hashSet = new HashSet();
        long j = 30000;
        ArrayList arrayList = new ArrayList();
        long[] myProcCpuTime = HardCoderJNI.getMyProcCpuTime();
        if (myProcCpuTime == null || myProcCpuTime.length < 2) {
            myProcCpuTime = new long[]{0, 0};
            x.i("MicroMsg.HardCoderReporter", "process jiffes info is invalid");
        }
        x.i("MicroMsg.HardCoderReporter", "process:[" + myProcCpuTime[0] + "," + myProcCpuTime[1] + "]");
        HashMap hashMap = new HashMap();
        HashSet hashSet2 = new HashSet();
        a aVar2 = null;
        a aVar3 = null;
        Collection collection = hashSet;
        while (aVar.flS) {
            int i;
            int i2;
            int i3;
            long j2;
            int min;
            long currentTimeMillis = System.currentTimeMillis();
            int size = aVar.gKg.size();
            if (HardCoderJNI.hcDebug) {
                x.d("MicroMsg.HardCoder.HCPerfManager", "StartLoop queue:" + size + " startTask:" + arrayList.size() + " nextWakeInterval:" + j);
            }
            int i4 = 0;
            while (true) {
                if (i4 >= (size == 0 ? 1 : size)) {
                    break;
                }
                Object poll;
                try {
                    poll = aVar.gKg.poll(j, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    x.e("MicroMsg.HardCoder.HCPerfManager", "queueTask poll: " + e.getMessage());
                    poll = null;
                }
                if (poll == null) {
                    break;
                }
                if (!(poll instanceof a)) {
                    if (!(poll instanceof b)) {
                        if (!HardCoderJNI.checkEnv) {
                            break;
                        }
                        Assert.fail("queueTask poll invalid object");
                    } else {
                        i = ((b) poll).aen;
                        if (hashSet2.contains(Integer.valueOf(i))) {
                            hashMap.put(Integer.valueOf(i), (b) poll);
                        }
                    }
                } else {
                    arrayList.add((a) poll);
                    hashSet2.add(Integer.valueOf(((a) poll).hashCode()));
                }
                i4++;
            }
            aVar.flS = false;
            long j3 = 30000;
            a aVar4 = null;
            a aVar5 = null;
            HashSet hashSet3 = new HashSet();
            long currentTimeMillis2 = System.currentTimeMillis();
            if (HardCoderJNI.hcDebug) {
                x.d("MicroMsg.HardCoder.HCPerfManager", "InLoop startSize:" + arrayList.size());
            }
            int i5 = 0;
            while (i5 < arrayList.size()) {
                a aVar6 = (a) arrayList.get(i5);
                if (aVar6 != null) {
                    if (hashMap.containsKey(Integer.valueOf(aVar6.hashCode()))) {
                        aVar6.gKo = currentTimeMillis2;
                        aVar6.gKD = ((b) hashMap.get(Integer.valueOf(aVar6.hashCode()))).gKD;
                        hashMap.remove(Integer.valueOf(aVar6.hashCode()));
                        aVar.a(currentTimeMillis2, arrayList, -2, -2, null);
                        if (HardCoderJNI.hcDebug) {
                            x.i("MicroMsg.HardCoder.HCPerfManager", "reportPerformanceTask:" + aVar6.hashCode());
                        }
                        aVar.gKf.aq(aVar6);
                    }
                    long j4 = aVar6.gKo - currentTimeMillis2;
                    if (j4 <= 0) {
                        if (HardCoderJNI.hcDebug) {
                            x.d("MicroMsg.HardCoder.HCPerfManager", "InLoop STOP:" + i5 + "/" + arrayList.size() + " task:" + aVar6.toString(currentTimeMillis2));
                        }
                        arrayList.remove(aVar6);
                        hashSet2.remove(Integer.valueOf(aVar6.hashCode()));
                        i5--;
                    } else {
                        j3 = Math.min(j3, j4);
                        j4 = aVar6.startTime - currentTimeMillis2;
                        if (j4 > 0) {
                            if (HardCoderJNI.hcDebug) {
                                x.d("MicroMsg.HardCoder.HCPerfManager", "InLoop WAIT:" + i5 + "/" + arrayList.size() + " task:" + aVar6.toString(currentTimeMillis2));
                            }
                            j3 = Math.min(j3, j4);
                        } else {
                            if (HardCoderJNI.hcDebug) {
                                x.d("MicroMsg.HardCoder.HCPerfManager", "InLoop  RUN:" + i5 + "/" + arrayList.size() + " task:" + aVar6.toString(currentTimeMillis2));
                            }
                            if (aVar6.gKj > 0 && (aVar4 == null || aVar4.gKj > aVar6.gKj || (aVar4.gKj == aVar6.gKj && aVar4.gKo < aVar6.gKo))) {
                                aVar4 = aVar6;
                            }
                            if (aVar6.gKk > 0 && (aVar5 == null || aVar5.gKk > aVar6.gKk || (aVar5.gKk == aVar6.gKk && aVar5.gKo < aVar6.gKo))) {
                                aVar5 = aVar6;
                            }
                            if (aVar6.gKl > 0) {
                                hashSet3.add(aVar6);
                            }
                        }
                    }
                }
                i5++;
            }
            long currentTimeMillis3 = System.currentTimeMillis();
            if (HardCoderJNI.hcDebug) {
                x.d("MicroMsg.HardCoder.HCPerfManager", String.format("EndLoop time:[%d,%d] list:%d stop:%d bindCore:%d -> %d", new Object[]{Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(currentTimeMillis3 - currentTimeMillis), Integer.valueOf(arrayList.size()), Integer.valueOf(hashMap.size()), Integer.valueOf(collection.size()), Integer.valueOf(hashSet3.size())}));
                x.d("MicroMsg.HardCoder.HCPerfManager", "EndLoop CurrCpu:" + (aVar3 == null ? "null" : aVar3.toString(currentTimeMillis2)) + " -> MaxCpu:" + (aVar4 == null ? "null" : aVar4.toString(currentTimeMillis2)));
                x.d("MicroMsg.HardCoder.HCPerfManager", "EndLoop CurrIO:" + (aVar2 == null ? "null" : aVar2.toString(currentTimeMillis2)) + " -> MaxIO:" + (aVar5 == null ? "null" : aVar5.toString(currentTimeMillis2)));
                x.d("MicroMsg.HardCoder.HCPerfManager", String.format("EndLoop BindCore.size cur: %d, need: %d", new Object[]{Integer.valueOf(collection.size()), Integer.valueOf(hashSet3.size())}));
            }
            if (aVar4 == aVar3 && aVar5 == aVar2 && collection.size() == hashSet3.size()) {
                HashSet hashSet4 = new HashSet();
                hashSet4.addAll(collection);
                hashSet4.removeAll(hashSet3);
                if (hashSet4.isEmpty()) {
                    if (HardCoderJNI.hcDebug) {
                        x.i("MicroMsg.HardCoder.HCPerfManager", "EndLoop Nothing Changed , Continue.");
                        j = j3;
                    } else {
                        j = j3;
                    }
                }
            }
            j = 0;
            HashSet hashSet5 = new HashSet();
            hashSet5.addAll(collection);
            hashSet5.removeAll(hashSet3);
            i = hashSet5.size();
            if (i > 0) {
                int[] iArr = new int[i];
                Iterator it = hashSet5.iterator();
                i2 = 0;
                while (it.hasNext()) {
                    aVar6 = (a) it.next();
                    x.i("MicroMsg.HardCoder.HCPerfManager", "!cancelBindCore task:" + aVar6.toString(currentTimeMillis2));
                    if (aVar6.gKo > currentTimeMillis2) {
                        if (!HardCoderJNI.checkEnv) {
                            aVar.flS = false;
                            break;
                        }
                        Assert.fail("stopTime:" + (aVar6.gKo - currentTimeMillis2));
                    }
                    if (aVar6.gKl == 0) {
                        if (!HardCoderJNI.checkEnv) {
                            aVar.flS = false;
                            break;
                        }
                        Assert.fail("bindTid:" + aVar6.gKl);
                    }
                    iArr[i2] = aVar6.gKl;
                    i2++;
                }
                if (!gKb && HardCoderJNI.checkEnv) {
                    HardCoderJNI.cancelCpuCoreForThread(iArr, Process.myTid(), SystemClock.elapsedRealtimeNanos());
                }
                aVar.a(currentTimeMillis2, arrayList, -2, -2, null);
            }
            int[] iArr2 = new int[hashSet3.size()];
            Iterator it2 = hashSet3.iterator();
            i2 = 0;
            int i6 = 0;
            int i7 = Integer.MAX_VALUE;
            int i8 = 0;
            while (it2.hasNext()) {
                aVar6 = (a) it2.next();
                x.i("MicroMsg.HardCoder.HCPerfManager", "requestBindCore task:" + aVar6.toString(currentTimeMillis2));
                if (aVar6.gKo <= currentTimeMillis2) {
                    if (!HardCoderJNI.checkEnv) {
                        aVar.flS = false;
                        break;
                    }
                    Assert.fail("stopTime:" + (aVar6.gKo - currentTimeMillis2));
                }
                if (aVar6.gKl == 0) {
                    if (!HardCoderJNI.checkEnv) {
                        aVar.flS = false;
                        break;
                    }
                    Assert.fail("bindTid:" + aVar6.gKl);
                }
                iArr2[i6] = aVar6.gKl;
                i6++;
                i2 = aVar6.scene;
                j = aVar6.gKm;
                i4 = aVar6.gKp;
                i7 = Math.min((int) (aVar6.gKo - currentTimeMillis2), i7);
                i8 = i4;
            }
            if (aVar5 == null) {
                if (aVar2 != null) {
                    x.i("MicroMsg.HardCoder.HCPerfManager", "!cancelHighIOFreq task:" + aVar2.toString(currentTimeMillis2));
                    if (!gKb && HardCoderJNI.checkEnv) {
                        HardCoderJNI.cancelHighIOFreq(aVar2.gKp, SystemClock.elapsedRealtimeNanos());
                    }
                    aVar.a(currentTimeMillis2, arrayList, -2, -1, null);
                }
            } else if (aVar2 != aVar5 && HardCoderJNI.hcDebug) {
                x.d("MicroMsg.HardCoder.HCPerfManager", "IOReq:" + (aVar2 == null ? "null" : aVar2.toString(currentTimeMillis2)) + " -> " + aVar5.toString(currentTimeMillis2) + " delay:" + (currentTimeMillis3 - aVar5.startTime));
            }
            if (aVar5 != null) {
                i6 = aVar5.gKk;
                i2 = aVar5.scene;
                j = aVar5.gKm;
                i8 = aVar5.gKp;
                i7 = Math.min((int) (aVar5.gKo - currentTimeMillis2), i7);
            } else {
                i6 = 0;
            }
            if (aVar4 == null) {
                if (aVar3 != null) {
                    x.i("MicroMsg.HardCoder.HCPerfManager", "!cancelCpuHighFreq task:" + aVar3.toString(currentTimeMillis2));
                    if (!gKb && HardCoderJNI.checkEnv) {
                        HardCoderJNI.cancelCpuHighFreq(aVar3.gKp, SystemClock.elapsedRealtimeNanos());
                    }
                    aVar.a(currentTimeMillis2, arrayList, -1, -2, null);
                }
            } else if (aVar3 != aVar4 && HardCoderJNI.hcDebug) {
                x.d("MicroMsg.HardCoder.HCPerfManager", "CPUReq:" + (aVar3 == null ? "null" : aVar3.toString(currentTimeMillis2)) + " -> " + aVar4.toString(currentTimeMillis2) + " delay:" + (currentTimeMillis3 - aVar4.startTime));
            }
            if (aVar4 != null) {
                i3 = aVar4.gKj;
                i = aVar4.scene;
                j2 = aVar4.gKm;
                i4 = aVar4.gKp;
                min = Math.min((int) (aVar4.gKo - currentTimeMillis2), i7);
            } else {
                i = i2;
                min = i7;
                i4 = i8;
                j2 = j;
                i3 = 0;
            }
            if (min < Integer.MAX_VALUE) {
                String str = "MicroMsg.HardCoder.HCPerfManager";
                String str2 = "!UnifyRequest [%d,%d,%d] [%d,%d,%d] TO:%d max CPU:%s IO:%s cur CPU:%s IO:%s";
                Object[] objArr = new Object[11];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Long.valueOf(j2);
                objArr[2] = Integer.valueOf(i4);
                objArr[3] = Integer.valueOf(i3);
                objArr[4] = Integer.valueOf(i6);
                objArr[5] = Integer.valueOf(iArr2.length);
                objArr[6] = Integer.valueOf(min);
                objArr[7] = aVar4 == null ? "null" : aVar4.toString(currentTimeMillis2);
                objArr[8] = aVar5 == null ? "null" : aVar5.toString(currentTimeMillis2);
                objArr[9] = aVar4 == null ? "null" : aVar4.toString(currentTimeMillis2);
                objArr[10] = aVar5 == null ? "null" : aVar5.toString(currentTimeMillis2);
                x.i(str, String.format(str2, objArr));
                Assert.assertTrue(min > 0);
                boolean z = i > 0 || j2 > 0;
                Assert.assertTrue(z);
                Assert.assertTrue(i4 > 0);
                z = i3 > 0 || i6 > 0 || iArr2.length > 0;
                Assert.assertTrue(z);
                if (!gKb && HardCoderJNI.checkEnv) {
                    HardCoderJNI.requestUnifyCpuIOThreadCore(i, j2, i3, i6, iArr2, min, i4, SystemClock.elapsedRealtimeNanos());
                    i4 = ((Integer) gKe.get(Integer.valueOf(i))).intValue();
                    String str3 = "MicroMsg.HardCoder.HCPerfManager";
                    str = "hardcoder requestUnifyCpuIOThreadCore reqScene[%d, %d, %d] running[j %b, c %b]";
                    Object[] objArr2 = new Object[5];
                    objArr2[0] = Integer.valueOf(i);
                    objArr2[1] = Long.valueOf(j2);
                    objArr2[2] = Integer.valueOf(i4);
                    objArr2[3] = Boolean.valueOf(HardCoderJNI.isHCEnable());
                    boolean z2 = HardCoderJNI.checkEnv && HardCoderJNI.isRunning() > 0;
                    objArr2[4] = Boolean.valueOf(z2);
                    x.i(str3, str, objArr2);
                    HardCoderJNI.reportIDKey(false, i4, 1, false);
                }
                aVar.a(currentTimeMillis2, arrayList, i3, i6, iArr2);
            }
            if (gKb) {
                Assert.assertTrue(aVar4 == aVar4);
                Assert.assertTrue(aVar5 == aVar5);
                if (arrayList.isEmpty()) {
                    Assert.assertTrue(j3 == 30000);
                    Assert.assertTrue(min == Integer.MAX_VALUE);
                    Assert.assertTrue(hashSet3.isEmpty());
                    Assert.assertTrue(aVar4 == null);
                    Assert.assertTrue(aVar5 == null);
                }
                for (i2 = 0; i2 < arrayList.size(); i2++) {
                    aVar6 = (a) arrayList.get(i2);
                    if (HardCoderJNI.hcDebug) {
                        x.d("MicroMsg.HardCoder.HCPerfManager", "CheckTask:" + i2 + "/" + arrayList.size() + " task:" + aVar6.toString(currentTimeMillis2));
                    }
                    boolean z3 = aVar6.gKj > 0 || aVar6.gKk > 0 || aVar6.gKl > 0;
                    Assert.assertTrue(z3);
                    z3 = aVar6.gKm > 0 || aVar6.scene > 0;
                    Assert.assertTrue(z3);
                    Assert.assertTrue("taskInintTime:" + (aVar6.gKn - currentTimeMillis2), aVar6.gKn <= currentTimeMillis2);
                    Assert.assertTrue("taskStopTime:" + (aVar6.gKo - currentTimeMillis2), aVar6.gKo >= currentTimeMillis2);
                    Assert.assertTrue("taskHash:" + aVar6.hashCode(), !hashMap.containsKey(Integer.valueOf(aVar6.hashCode())));
                    if (aVar6.startTime > currentTimeMillis2) {
                        Assert.assertTrue(aVar6 != aVar4);
                        Assert.assertTrue(aVar6 != aVar5);
                        Assert.assertTrue(!hashSet3.contains(aVar6));
                        Assert.assertTrue("next:" + j3 + " start:" + (aVar6.startTime - currentTimeMillis2), j3 <= aVar6.startTime - currentTimeMillis2);
                    } else {
                        Assert.assertTrue("nextWake:" + j3 + " stop:" + (aVar6.gKo - currentTimeMillis2), j3 <= aVar6.gKo - currentTimeMillis2);
                        String str4 = "reqTimeStamp:" + min;
                        z3 = min > 0 && ((long) min) < Long.MAX_VALUE;
                        Assert.assertTrue(str4, z3);
                        Assert.assertTrue("reqTimeStamp:" + min + " stop:" + (aVar6.gKo - currentTimeMillis2), ((long) min) <= aVar6.gKo - currentTimeMillis2);
                        Assert.assertTrue("reqCpu:" + i3 + " task:" + aVar6.gKj, i3 <= aVar6.gKj);
                        Assert.assertTrue("reqIO:" + i6 + " task:" + aVar6.gKk, i6 <= aVar6.gKk);
                        if (aVar6.gKl > 0) {
                            Assert.assertTrue(hashSet3.contains(aVar6));
                            Assert.assertTrue(!hashSet5.contains(aVar6));
                        }
                    }
                }
                j = j3;
                collection = hashSet3;
                aVar2 = aVar5;
                aVar3 = aVar4;
            } else {
                j = j3;
                collection = hashSet3;
                aVar2 = aVar5;
                aVar3 = aVar4;
            }
        }
    }

    static {
        Map hashMap = new HashMap();
        gKe = hashMap;
        hashMap.clear();
        gKe.put(Integer.valueOf(101), Integer.valueOf(1));
        gKe.put(Integer.valueOf(201), Integer.valueOf(2));
        gKe.put(Integer.valueOf(202), Integer.valueOf(3));
        gKe.put(Integer.valueOf(203), Integer.valueOf(4));
        gKe.put(Integer.valueOf(301), Integer.valueOf(5));
        gKe.put(Integer.valueOf(HardCoderJNI.SCENE_QUIT_CHATTING), Integer.valueOf(6));
        gKe.put(Integer.valueOf(401), Integer.valueOf(7));
        gKe.put(Integer.valueOf(HardCoderJNI.SCENE_DB), Integer.valueOf(8));
        gKe.put(Integer.valueOf(601), Integer.valueOf(9));
        gKe.put(Integer.valueOf(602), Integer.valueOf(10));
        gKe.put(Integer.valueOf(603), Integer.valueOf(11));
        gKe.put(Integer.valueOf(701), Integer.valueOf(12));
        gKe.put(Integer.valueOf(702), Integer.valueOf(13));
        gKe.put(Integer.valueOf(703), Integer.valueOf(14));
    }

    public a() {
        this.gKf = new b();
        this.gKg = new LinkedBlockingQueue();
        this.flS = false;
        this.flS = true;
        e.d(new Runnable(this) {
            final /* synthetic */ a gKh;

            {
                this.gKh = r1;
            }

            public final void run() {
                x.i("MicroMsg.HardCoder.HCPerfManager", "HCPerfManager thread run start[%d, %s]", Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName());
                a.a(this.gKh);
                x.i("MicroMsg.HardCoder.HCPerfManager", "HCPerfManager thread run end");
            }
        }, "HCPerfManager", 10).start();
        x.i("MicroMsg.HardCoder.HCPerfManager", "hardcoder HCPerfManager new thread[%s]", r0);
        this.gKf.start();
    }

    private void a(long j, List<a> list, int i, int i2, int[] iArr) {
        this.gKf.aq(new com.tencent.mm.hardcoder.b.b(j, new ArrayList(list), i, i2, iArr));
    }

    final void reportIDKey(boolean z, int i, int i2, boolean z2) {
        this.gKf.aq(new com.tencent.mm.hardcoder.b.a(z, i, i2, z2));
    }
}
