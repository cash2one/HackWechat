package com.tencent.mm.plugin.appbrand.q;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class j {
    private static final Comparator<e> jSf = new Comparator<e>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            e eVar = (e) obj;
            e eVar2 = (e) obj2;
            int i = eVar.x - eVar2.x;
            return i == 0 ? eVar.y - eVar2.y : i;
        }
    };

    public static class b {
        public final List<e> jSg;
        public final int[] jSh;
        private final int[] jSi;
        public final a jSj;
        public final int jSk;
        public final int jSl;
        private final boolean jSm;

        b(a aVar, List<e> list, int[] iArr, int[] iArr2, boolean z) {
            this.jSg = list;
            this.jSh = iArr;
            this.jSi = iArr2;
            Arrays.fill(this.jSh, 0);
            Arrays.fill(this.jSi, 0);
            this.jSj = aVar;
            this.jSk = aVar.akF();
            this.jSl = aVar.akG();
            this.jSm = z;
            e eVar = this.jSg.isEmpty() ? null : (e) this.jSg.get(0);
            if (!(eVar != null && eVar.x == 0 && eVar.y == 0)) {
                eVar = new e();
                eVar.x = 0;
                eVar.y = 0;
                eVar.jSp = false;
                eVar.size = 0;
                eVar.jSu = false;
                this.jSg.add(0, eVar);
            }
            alL();
        }

        private void alL() {
            int i = this.jSk;
            int i2 = this.jSl;
            for (int size = this.jSg.size() - 1; size >= 0; size--) {
                e eVar = (e) this.jSg.get(size);
                int i3 = eVar.x + eVar.size;
                int i4 = eVar.y + eVar.size;
                if (this.jSm) {
                    while (i > i3) {
                        if (this.jSh[i - 1] == 0) {
                            c(i, i2, size, false);
                        }
                        i--;
                    }
                    while (i2 > i4) {
                        if (this.jSi[i2 - 1] == 0) {
                            c(i, i2, size, true);
                        }
                        i2--;
                    }
                }
                for (i2 = 0; i2 < eVar.size; i2++) {
                    i3 = eVar.x + i2;
                    i4 = eVar.y + i2;
                    i = this.jSj.bS(i3, i4) ? 1 : 2;
                    this.jSh[i3] = (i4 << 5) | i;
                    this.jSi[i4] = i | (i3 << 5);
                }
                i = eVar.x;
                i2 = eVar.y;
            }
        }

        private boolean c(int i, int i2, int i3, boolean z) {
            int i4;
            int i5;
            int i6 = 8;
            if (z) {
                int i7 = i2 - 1;
                i2--;
                i4 = i;
                i5 = i7;
            } else {
                i5 = i - 1;
                i4 = i - 1;
            }
            while (i3 >= 0) {
                e eVar = (e) this.jSg.get(i3);
                int i8 = eVar.x + eVar.size;
                int i9 = eVar.y + eVar.size;
                if (z) {
                    for (i4--; i4 >= i8; i4--) {
                        if (this.jSj.bR(i4, i5)) {
                            i7 = this.jSj.bS(i4, i5) ? 8 : 4;
                            this.jSi[i5] = (i4 << 5) | 16;
                            this.jSh[i4] = i7 | (i5 << 5);
                            return true;
                        }
                    }
                    continue;
                } else {
                    for (i4 = i2 - 1; i4 >= i9; i4--) {
                        if (this.jSj.bR(i5, i4)) {
                            if (!this.jSj.bS(i5, i4)) {
                                i6 = 4;
                            }
                            this.jSh[i - 1] = (i4 << 5) | 16;
                            this.jSi[i4] = i6 | ((i - 1) << 5);
                            return true;
                        }
                    }
                    continue;
                }
                i4 = eVar.x;
                i2 = eVar.y;
                i3--;
            }
            return false;
        }

        private static c b(List<c> list, int i, boolean z) {
            for (int size = list.size() - 1; size >= 0; size--) {
                c cVar = (c) list.get(size);
                if (cVar.jSn == i && cVar.jSp == z) {
                    list.remove(size);
                    for (int i2 = size; i2 < list.size(); i2++) {
                        c cVar2 = (c) list.get(i2);
                        cVar2.jSo = (z ? 1 : -1) + cVar2.jSo;
                    }
                    return cVar;
                }
            }
            return null;
        }

        public final void a(List<c> list, k kVar, int i, int i2, int i3) {
            if (this.jSm) {
                for (int i4 = i2 - 1; i4 >= 0; i4--) {
                    int i5 = this.jSi[i3 + i4] & 31;
                    switch (i5) {
                        case 0:
                            kVar.bN(i, 1);
                            for (c cVar : list) {
                                cVar.jSo++;
                            }
                            break;
                        case 4:
                        case 8:
                            int i6 = this.jSi[i3 + i4] >> 5;
                            kVar.bP(b(list, i6, true).jSo, i);
                            if (i5 != 4) {
                                break;
                            }
                            kVar.d(i, 1, this.jSj.bT(i6, i3 + i4));
                            break;
                        case 16:
                            list.add(new c(i3 + i4, i, false));
                            break;
                        default:
                            throw new IllegalStateException("unknown flag for pos " + (i4 + i3) + " " + Long.toBinaryString((long) i5));
                    }
                }
                return;
            }
            kVar.bN(i, i2);
        }

        public final void b(List<c> list, k kVar, int i, int i2, int i3) {
            if (this.jSm) {
                for (int i4 = i2 - 1; i4 >= 0; i4--) {
                    int i5 = this.jSh[i3 + i4] & 31;
                    switch (i5) {
                        case 0:
                            kVar.bO(i + i4, 1);
                            for (c cVar : list) {
                                cVar.jSo--;
                            }
                            break;
                        case 4:
                        case 8:
                            int i6 = this.jSh[i3 + i4] >> 5;
                            c b = b(list, i6, false);
                            kVar.bP(i + i4, b.jSo - 1);
                            if (i5 != 4) {
                                break;
                            }
                            kVar.d(b.jSo - 1, 1, this.jSj.bT(i3 + i4, i6));
                            break;
                        case 16:
                            list.add(new c(i3 + i4, i + i4, true));
                            break;
                        default:
                            throw new IllegalStateException("unknown flag for pos " + (i4 + i3) + " " + Long.toBinaryString((long) i5));
                    }
                }
                return;
            }
            kVar.bO(i, i2);
        }
    }

    public static b a(a aVar, boolean z) {
        int akF = aVar.akF();
        int akG = aVar.akG();
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        arrayList2.add(new d(akF, akG));
        int abs = (akF + akG) + Math.abs(akF - akG);
        int[] iArr = new int[(abs * 2)];
        int[] iArr2 = new int[(abs * 2)];
        List arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            d dVar = (d) arrayList2.remove(arrayList2.size() - 1);
            e a = a(aVar, dVar.jSq, dVar.jSr, dVar.jSs, dVar.jSt, iArr, iArr2, abs);
            if (a != null) {
                if (a.size > 0) {
                    arrayList.add(a);
                }
                a.x += dVar.jSq;
                a.y += dVar.jSs;
                d dVar2 = arrayList3.isEmpty() ? new d() : (d) arrayList3.remove(arrayList3.size() - 1);
                dVar2.jSq = dVar.jSq;
                dVar2.jSs = dVar.jSs;
                if (a.jSu) {
                    dVar2.jSr = a.x;
                    dVar2.jSt = a.y;
                } else if (a.jSp) {
                    dVar2.jSr = a.x - 1;
                    dVar2.jSt = a.y;
                } else {
                    dVar2.jSr = a.x;
                    dVar2.jSt = a.y - 1;
                }
                arrayList2.add(dVar2);
                if (!a.jSu) {
                    dVar.jSq = a.x + a.size;
                    dVar.jSs = a.y + a.size;
                } else if (a.jSp) {
                    dVar.jSq = (a.x + a.size) + 1;
                    dVar.jSs = a.y + a.size;
                } else {
                    dVar.jSq = a.x + a.size;
                    dVar.jSs = (a.y + a.size) + 1;
                }
                arrayList2.add(dVar);
            } else {
                arrayList3.add(dVar);
            }
        }
        Collections.sort(arrayList, jSf);
        return new b(aVar, arrayList, iArr, iArr2, z);
    }

    private static e a(a aVar, int i, int i2, int i3, int i4, int[] iArr, int[] iArr2, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i2 - i <= 0 || i4 - i3 <= 0) {
            return null;
        }
        int i8 = i6 - i7;
        int i9 = ((i6 + i7) + 1) / 2;
        Arrays.fill(iArr, (i5 - i9) - 1, (i5 + i9) + 1, 0);
        Arrays.fill(iArr2, ((i5 - i9) - 1) + i8, ((i5 + i9) + 1) + i8, i6);
        Object obj = i8 % 2 != 0 ? 1 : null;
        int i10 = 0;
        while (i10 <= i9) {
            int i11 = -i10;
            while (i11 <= i10) {
                int i12;
                boolean z;
                if (i11 == (-i10) || (i11 != i10 && iArr[(i5 + i11) - 1] < iArr[(i5 + i11) + 1])) {
                    i12 = iArr[(i5 + i11) + 1];
                    z = false;
                } else {
                    i12 = iArr[(i5 + i11) - 1] + 1;
                    z = true;
                }
                int i13 = i12;
                i12 -= i11;
                while (i13 < i6 && i12 < i7 && aVar.bR(i + i13, i3 + i12)) {
                    i13++;
                    i12++;
                }
                iArr[i5 + i11] = i13;
                if (obj == null || i11 < (i8 - i10) + 1 || i11 > (i8 + i10) - 1 || iArr[i5 + i11] < iArr2[i5 + i11]) {
                    i11 += 2;
                } else {
                    e eVar = new e();
                    eVar.x = iArr2[i5 + i11];
                    eVar.y = eVar.x - i11;
                    eVar.size = iArr[i5 + i11] - iArr2[i5 + i11];
                    eVar.jSp = z;
                    eVar.jSu = false;
                    return eVar;
                }
            }
            i11 = -i10;
            while (i11 <= i10) {
                int i14 = i11 + i8;
                if (i14 == i10 + i8 || (i14 != (-i10) + i8 && iArr2[(i5 + i14) - 1] < iArr2[(i5 + i14) + 1])) {
                    i12 = iArr2[(i5 + i14) - 1];
                    z = false;
                } else {
                    i12 = iArr2[(i5 + i14) + 1] - 1;
                    z = true;
                }
                i13 = i12;
                i12 -= i14;
                while (i13 > 0 && i12 > 0 && aVar.bR((i + i13) - 1, (i3 + i12) - 1)) {
                    i13--;
                    i12--;
                }
                iArr2[i5 + i14] = i13;
                if (obj != null || i11 + i8 < (-i10) || i11 + i8 > i10 || iArr[i5 + i14] < iArr2[i5 + i14]) {
                    i11 += 2;
                } else {
                    eVar = new e();
                    eVar.x = iArr2[i5 + i14];
                    eVar.y = eVar.x - i14;
                    eVar.size = iArr[i5 + i14] - iArr2[i5 + i14];
                    eVar.jSp = z;
                    eVar.jSu = true;
                    return eVar;
                }
            }
            i10++;
        }
        throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
    }
}
