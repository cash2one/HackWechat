package com.tencent.mm.plugin.fps_lighter.a;

import android.util.SparseArray;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.d;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.e;
import com.tencent.mm.plugin.fps_lighter.b.c;
import com.tencent.mm.plugin.fps_lighter.b.g;
import com.tencent.mm.plugin.fps_lighter.e.a$a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class b implements c {
    c mAl;
    private long mAp = System.currentTimeMillis();
    long[] mAq = new long[7200];
    int mAr = 0;
    int mAs = 0;
    SparseArray<ArrayList<a>> mAt = new SparseArray();

    public b(c cVar) {
        this.mAl = cVar;
    }

    public final void a(int i, long j, long j2, int i2, int i3, boolean z, long j3, boolean z2) {
        if ((System.currentTimeMillis() - this.mAp > c.aKK() ? 1 : null) != null) {
            g.aKO();
            g.VO().post(new Runnable(this) {
                final /* synthetic */ b mAu;

                {
                    this.mAu = r1;
                }

                public final void run() {
                    if (this.mAu.mAr != this.mAu.mAs) {
                        b bVar = this.mAu;
                        long[] jArr = this.mAu.mAq;
                        int i = this.mAu.mAr;
                        if (jArr == null) {
                            x.w("MicroMsg.FrameReportCallback", "null == datas");
                            return;
                        }
                        int length;
                        Object obj;
                        long j;
                        int[] iArr = new int[5];
                        int[] iArr2 = new int[5];
                        if (bVar.mAs >= i) {
                            length = jArr.length;
                            obj = 1;
                            x.d("MicroMsg.FrameReportCallback", "isSpecial:%s mLastIndex:%s mNowIndex:%s", new Object[]{Boolean.valueOf(true), Integer.valueOf(bVar.mAs), Integer.valueOf(i)});
                        } else {
                            obj = null;
                            length = i;
                        }
                        Object obj2 = obj;
                        int i2 = bVar.mAs;
                        int i3 = length;
                        while (i2 < i3 && jArr[i2] != 0) {
                            Object obj3;
                            long j2 = jArr[i2];
                            j = j2 >> 58;
                            a aVar = new a(bVar, (int) j, Long.valueOf(j2 & 288230376151711743L));
                            ArrayList arrayList = (ArrayList) bVar.mAt.get((int) j);
                            if (arrayList == null) {
                                arrayList = new ArrayList(7800);
                                arrayList.add(aVar);
                                bVar.mAt.append((int) j, arrayList);
                            } else {
                                arrayList.add(aVar);
                            }
                            if (i2 != i3 - 1 || obj2 == null) {
                                length = i2;
                                i2 = i3;
                                obj3 = obj2;
                            } else {
                                length = -1;
                                obj3 = null;
                                i2 = i;
                            }
                            bVar.mAs = length + 1;
                            obj2 = obj3;
                            i3 = i2;
                            i2 = length + 1;
                        }
                        List list = null;
                        int i4 = 0;
                        int[] iArr3 = iArr2;
                        int[] iArr4 = iArr;
                        while (i4 < bVar.mAt.size()) {
                            List arrayList2;
                            for (length = 0; length < 5; length++) {
                                iArr4[length] = 0;
                                iArr3[length] = 0;
                            }
                            length = bVar.mAt.keyAt(i4);
                            ArrayList arrayList3 = (ArrayList) bVar.mAt.get(length);
                            x.i("MicroMsg.FrameReportCallback", "scene:%s size:%s", new Object[]{Integer.valueOf(length), Integer.valueOf(arrayList3.size())});
                            j = 0;
                            int i5 = -1;
                            int i6 = 0;
                            int[] iArr5 = iArr4;
                            while (i6 < arrayList3.size()) {
                                int[] iArr6;
                                a aVar2 = (a) arrayList3.get(i6);
                                if (aVar2.mAw <= 0) {
                                    x.e("MicroMsg.FrameReportCallback", "[reportSample] %s", new Object[]{aVar2});
                                }
                                long j3 = aVar2.mAw + j;
                                if (aVar2.mAv == a$a.BAD) {
                                    iArr5[0] = iArr5[0] + 1;
                                    iArr3[0] = aVar2.mAx + iArr3[0];
                                } else if (aVar2.mAv == a$a.MEDIUM) {
                                    iArr5[1] = iArr5[1] + 1;
                                    iArr3[1] = aVar2.mAx + iArr3[1];
                                } else if (aVar2.mAv == a$a.SLIGHT) {
                                    iArr5[2] = iArr5[2] + 1;
                                    iArr3[2] = aVar2.mAx + iArr3[2];
                                } else if (aVar2.mAv == a$a.GOOD) {
                                    iArr5[3] = iArr5[3] + 1;
                                    iArr3[3] = aVar2.mAx + iArr3[3];
                                } else if (aVar2.mAv == a$a.BEST) {
                                    iArr5[4] = iArr5[4] + 1;
                                    iArr3[4] = iArr3[4] + 0;
                                }
                                if (j3 >= c.aKL()) {
                                    bVar.a(length, iArr5, iArr3, j3);
                                    iArr6 = new int[5];
                                    iArr = new int[5];
                                    j3 = 0;
                                    i2 = i6;
                                } else {
                                    iArr = iArr3;
                                    i2 = i5;
                                    iArr6 = iArr5;
                                }
                                i6++;
                                j = j3;
                                iArr5 = iArr6;
                                i5 = i2;
                                iArr3 = iArr;
                            }
                            if (-1 != i5) {
                                arrayList2 = list == null ? new ArrayList(arrayList3.size() - i5) : list;
                                for (i3 = i5 + 1; i3 < arrayList3.size(); i3++) {
                                    arrayList2.add(arrayList3.get(i3));
                                }
                                arrayList3.clear();
                                for (i3 = 0; i3 < arrayList2.size(); i3++) {
                                    arrayList3.add(arrayList2.get(i3));
                                }
                                arrayList2.clear();
                            } else {
                                arrayList2 = list;
                            }
                            i4++;
                            list = arrayList2;
                            iArr4 = iArr5;
                        }
                    }
                }
            });
            this.mAp = System.currentTimeMillis();
        } else if (i != -1) {
            this.mAq[this.mAr] = ((0 | ((long) i)) << 58) | TimeUnit.NANOSECONDS.convert(j2 - j, TimeUnit.MILLISECONDS);
            this.mAr++;
            if (this.mAr == this.mAq.length) {
                this.mAr = 0;
            }
        }
    }

    public final void D(int i, boolean z) {
    }

    final void a(int i, int[] iArr, int[] iArr2, long j) {
        if (this.mAl == null) {
            x.d("MicroMsg.FrameReportCallback", "it maybe was stopped!");
            return;
        }
        int i2;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (i2 = 0; i2 < 5; i2++) {
            double d;
            if (iArr[i2] == 0) {
                d = 0.0d;
            } else {
                d = (double) ((((((float) iArr2[i2]) * 1.0f) / ((float) j)) * ((float) c.aKL())) / ((float) iArr[i2]));
            }
            x.i("MicroMsg.FrameReportCallback", "scene:%s  DeviceLevel:%s frame state[index:%s],count:%s avery dropcount:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(this.mAl.mAL), Integer.valueOf(i2), Integer.valueOf(iArr[i2]), Double.valueOf(d)});
            i3 += iArr[i2];
            if (i3 > 1800) {
                x.e("MicroMsg.FrameReportCallback", "frame rate is not normal! %s", new Object[]{Integer.valueOf(i3)});
            }
            x.i("MicroMsg.FrameReportCallback", "scene:%s index:%s metrics[index]:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(iArr[i2])});
            IDKey iDKey = new IDKey();
            IDKey iDKey2 = new IDKey();
            IDKey iDKey3 = new IDKey();
            switch (i) {
                case 0:
                    iDKey.SetID(349);
                    iDKey2.SetID(349);
                    iDKey3.SetID(349);
                    break;
                case 1:
                    iDKey.SetID(350);
                    iDKey2.SetID(350);
                    iDKey3.SetID(350);
                    break;
                case 2:
                    iDKey.SetID(351);
                    iDKey2.SetID(351);
                    iDKey3.SetID(351);
                    break;
                case 3:
                    iDKey.SetID(d.CTRL_INDEX);
                    iDKey2.SetID(d.CTRL_INDEX);
                    iDKey3.SetID(d.CTRL_INDEX);
                    break;
                case 4:
                    iDKey.SetID(e.CTRL_INDEX);
                    iDKey2.SetID(e.CTRL_INDEX);
                    iDKey3.SetID(e.CTRL_INDEX);
                    break;
                case 5:
                    iDKey.SetID(364);
                    iDKey2.SetID(364);
                    iDKey3.SetID(364);
                    break;
            }
            iDKey.SetKey(((i2 * 4) + 24) + this.mAl.mAL);
            iDKey.SetValue((long) ((int) Math.round(d)));
            iDKey2.SetKey((this.mAl.mAL * 5) + i2);
            iDKey2.SetValue((long) iArr[i2]);
            iDKey3.SetKey(((i2 * 4) + 200) + this.mAl.mAL);
            if (d > 0.0d) {
                iDKey3.SetValue(1);
            }
            if (iDKey.GetValue() > 0) {
                arrayList.add(iDKey);
            }
            if (iDKey2.GetValue() > 0) {
                arrayList.add(iDKey2);
            }
            if (iDKey3.GetValue() > 0) {
                arrayList.add(iDKey3);
            }
        }
        IDKey iDKey4 = new IDKey();
        IDKey iDKey5 = new IDKey();
        switch (i) {
            case 0:
                iDKey4.SetID(349);
                iDKey5.SetID(349);
                break;
            case 1:
                iDKey4.SetID(350);
                iDKey5.SetID(350);
                break;
            case 2:
                iDKey4.SetID(351);
                iDKey5.SetID(351);
                break;
            case 3:
                iDKey4.SetID(d.CTRL_INDEX);
                iDKey5.SetID(d.CTRL_INDEX);
                break;
            case 4:
                iDKey4.SetID(e.CTRL_INDEX);
                iDKey5.SetID(e.CTRL_INDEX);
                break;
            case 5:
                iDKey4.SetID(364);
                iDKey5.SetID(364);
                break;
        }
        iDKey4.SetKey(this.mAl.mAL + 20);
        x.i("MicroMsg.FrameReportCallback", "level:%s %s", new Object[]{Integer.valueOf(this.mAl.mAL), Integer.valueOf(Math.round((((float) i3) * 1.0f) / ((float) TimeUnit.SECONDS.convert(j, TimeUnit.NANOSECONDS))))});
        iDKey4.SetValue((long) i2);
        iDKey5.SetKey(this.mAl.mAL + 100);
        iDKey5.SetValue(1);
        if (iDKey4.GetValue() > 0) {
            arrayList.add(iDKey4);
        }
        if (iDKey5.GetValue() > 0) {
            arrayList.add(iDKey5);
        }
        com.tencent.mm.plugin.report.service.g.pQN.a(arrayList, true);
    }

    public final String toString() {
        return "MicroMsg.FrameReportCallback";
    }
}
