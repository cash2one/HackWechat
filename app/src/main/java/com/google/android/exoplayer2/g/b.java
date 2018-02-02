package com.google.android.exoplayer2.g;

import android.graphics.Point;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.e.a;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.s;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class b extends d {
    private static final int[] azX = new int[0];
    private final a azY;
    private final AtomicReference<b> azZ;

    public static final class b {
        public final String aAa;
        public final String aAb;
        public final int aAc;
        public final int aAd;
        public final int aAe;
        public final boolean aAf;
        public final boolean aAg;
        public final boolean aAh;
        public final boolean aAi;
        public final boolean aAj;
        public final int viewportHeight;
        public final int viewportWidth;

        public b() {
            this((byte) 0);
        }

        private b(byte b) {
            this.aAa = null;
            this.aAb = null;
            this.aAh = false;
            this.aAi = true;
            this.aAc = Integer.MAX_VALUE;
            this.aAd = Integer.MAX_VALUE;
            this.aAe = Integer.MAX_VALUE;
            this.aAf = true;
            this.aAj = true;
            this.viewportWidth = Integer.MAX_VALUE;
            this.viewportHeight = Integer.MAX_VALUE;
            this.aAg = true;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.aAh == bVar.aAh && this.aAi == bVar.aAi && this.aAc == bVar.aAc && this.aAd == bVar.aAd && this.aAf == bVar.aAf && this.aAj == bVar.aAj && this.aAg == bVar.aAg && this.viewportWidth == bVar.viewportWidth && this.viewportHeight == bVar.viewportHeight && this.aAe == bVar.aAe && TextUtils.equals(this.aAa, bVar.aAa) && TextUtils.equals(this.aAb, bVar.aAb)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            int i;
            int i2 = 1;
            int hashCode = ((this.aAh ? 1 : 0) + (((this.aAa.hashCode() * 31) + this.aAb.hashCode()) * 31)) * 31;
            if (this.aAi) {
                i = 1;
            } else {
                i = 0;
            }
            hashCode = (((((((i + hashCode) * 31) + this.aAc) * 31) + this.aAd) * 31) + this.aAe) * 31;
            if (this.aAf) {
                i = 1;
            } else {
                i = 0;
            }
            hashCode = (i + hashCode) * 31;
            if (this.aAj) {
                i = 1;
            } else {
                i = 0;
            }
            i = (i + hashCode) * 31;
            if (!this.aAg) {
                i2 = 0;
            }
            return ((((i + i2) * 31) + this.viewportWidth) * 31) + this.viewportHeight;
        }
    }

    public b() {
        this((byte) 0);
    }

    private b(byte b) {
        this.azY = null;
        this.azZ = new AtomicReference(new b());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final e[] a(s[] sVarArr, m[] mVarArr, int[][][] iArr) {
        int i;
        int length = sVarArr.length;
        e[] eVarArr = new e[length];
        b bVar = (b) this.azZ.get();
        int i2 = 0;
        int i3 = 0;
        Object obj = null;
        while (i3 < length) {
            int i4;
            if (2 == sVarArr[i3].getTrackType()) {
                if (obj == null) {
                    s sVar = sVarArr[i3];
                    m mVar = mVarArr[i3];
                    int[][] iArr2 = iArr[i3];
                    a aVar = this.azY;
                    e eVar = null;
                    if (aVar != null) {
                        int i5 = bVar.aAi ? 24 : 16;
                        Object obj2 = (!bVar.aAh || (sVar.hU() & i5) == 0) ? null : 1;
                        for (int i6 = 0; i6 < mVar.length; i6++) {
                            int[] iArr3;
                            l lVar = mVar.asG[i6];
                            int[] iArr4 = iArr2[i6];
                            int i7 = bVar.aAc;
                            int i8 = bVar.aAd;
                            int i9 = bVar.aAe;
                            i = bVar.viewportWidth;
                            int i10 = bVar.viewportHeight;
                            boolean z = bVar.aAg;
                            if (lVar.length < 2) {
                                iArr3 = azX;
                            } else {
                                List a = a(lVar, i, i10, z);
                                if (a.size() < 2) {
                                    iArr3 = azX;
                                } else {
                                    String str;
                                    String str2 = null;
                                    if (obj2 == null) {
                                        HashSet hashSet = new HashSet();
                                        int i11 = 0;
                                        int i12 = 0;
                                        while (i12 < a.size()) {
                                            String str3;
                                            str = lVar.arZ[((Integer) a.get(i12)).intValue()].adV;
                                            if (hashSet.add(str)) {
                                                int a2 = a(lVar, iArr4, i5, str, i7, i8, i9, a);
                                                if (a2 > i11) {
                                                    int i13 = a2;
                                                    str3 = str;
                                                    i = i13;
                                                    i12++;
                                                    str2 = str3;
                                                    i11 = i;
                                                }
                                            }
                                            i = i11;
                                            str3 = str2;
                                            i12++;
                                            str2 = str3;
                                            i11 = i;
                                        }
                                        str = str2;
                                    } else {
                                        str = null;
                                    }
                                    b(lVar, iArr4, i5, str, i7, i8, i9, a);
                                    iArr3 = a.size() < 2 ? azX : t.o(a);
                                }
                            }
                            if (iArr3.length > 0) {
                                eVar = aVar.lj();
                                break;
                            }
                        }
                        eVar = null;
                    }
                    if (eVar == null) {
                        eVar = a(mVar, iArr2, bVar);
                    }
                    eVarArr[i3] = eVar;
                    obj = eVarArr[i3] != null ? 1 : null;
                }
                if (mVarArr[i3].length > 0) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                i4 |= i2;
            } else {
                i4 = i2;
            }
            i3++;
            i2 = i4;
        }
        Object obj3 = null;
        Object obj4 = null;
        i = 0;
        while (i < length) {
            switch (sVarArr[i].getTrackType()) {
                case 1:
                    if (obj3 == null) {
                        eVarArr[i] = a(mVarArr[i], iArr[i], bVar, i2 != 0 ? null : this.azY);
                        obj = eVarArr[i] != null ? 1 : null;
                        obj3 = obj4;
                        continue;
                    }
                case 2:
                    obj = obj3;
                    obj3 = obj4;
                    continue;
                case 3:
                    if (obj4 == null) {
                        eVarArr[i] = b(mVarArr[i], iArr[i], bVar);
                        Object obj5 = obj3;
                        obj3 = eVarArr[i] != null ? 1 : null;
                        obj = obj5;
                        continue;
                    }
                default:
                    eVarArr[i] = c(mVarArr[i], iArr[i], bVar);
            }
            obj = obj3;
            obj3 = obj4;
            i++;
            obj4 = obj3;
            obj3 = obj;
        }
        return eVarArr;
    }

    private static int a(l lVar, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        int i5 = 0;
        int i6 = 0;
        while (i5 < list.size()) {
            int intValue = ((Integer) list.get(i5)).intValue();
            if (a(lVar.arZ[intValue], str, iArr[intValue], i, i2, i3, i4)) {
                intValue = i6 + 1;
            } else {
                intValue = i6;
            }
            i5++;
            i6 = intValue;
        }
        return i6;
    }

    private static void b(l lVar, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = ((Integer) list.get(size)).intValue();
            if (!a(lVar.arZ[intValue], str, iArr[intValue], i, i2, i3, i4)) {
                list.remove(size);
            }
        }
    }

    private static boolean a(Format format, String str, int i, int i2, int i3, int i4, int i5) {
        if (!l(i, false) || (i & i2) == 0) {
            return false;
        }
        if (str != null && !t.h(format.adV, str)) {
            return false;
        }
        if (format.width != -1 && format.width > i3) {
            return false;
        }
        if (format.height != -1 && format.height > i4) {
            return false;
        }
        if (format.bitrate == -1 || format.bitrate <= i5) {
            return true;
        }
        return false;
    }

    private static e a(m mVar, int[][] iArr, b bVar) {
        l lVar = null;
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        int i4 = 0;
        for (int i5 = 0; i5 < mVar.length; i5++) {
            l lVar2 = mVar.asG[i5];
            List a = a(lVar2, bVar.viewportWidth, bVar.viewportHeight, bVar.aAg);
            int[] iArr2 = iArr[i5];
            int i6 = 0;
            while (i6 < lVar2.length) {
                int i7;
                l lVar3;
                if (l(iArr2[i6], bVar.aAj)) {
                    Format format = lVar2.arZ[i6];
                    Object obj = (!a.contains(Integer.valueOf(i6)) || ((format.width != -1 && format.width > bVar.aAc) || ((format.height != -1 && format.height > bVar.aAd) || (format.bitrate != -1 && format.bitrate > bVar.aAe)))) ? null : 1;
                    if (obj != null || bVar.aAf) {
                        i7 = obj != null ? 2 : 1;
                        boolean l = l(iArr2[i6], false);
                        if (l) {
                            i7 += 1000;
                        }
                        Object obj2 = i7 > i4 ? 1 : null;
                        if (i7 == i4) {
                            int ar;
                            if (format.io() != i2) {
                                ar = ar(format.io(), i2);
                            } else {
                                ar = ar(format.bitrate, i3);
                            }
                            obj2 = (!l || obj == null) ? ar < 0 ? 1 : null : ar > 0 ? 1 : null;
                        }
                        if (obj2 != null) {
                            i3 = format.bitrate;
                            i2 = format.io();
                            i4 = i7;
                            lVar3 = lVar2;
                            i7 = i6;
                            i6++;
                            lVar = lVar3;
                            i = i7;
                        }
                    }
                }
                i7 = i;
                lVar3 = lVar;
                i6++;
                lVar = lVar3;
                i = i7;
            }
        }
        return lVar == null ? null : new c(lVar, i);
    }

    private static int ar(int i, int i2) {
        return i == -1 ? i2 == -1 ? 0 : -1 : i2 == -1 ? 1 : i - i2;
    }

    private static e a(m mVar, int[][] iArr, b bVar, a aVar) {
        int i;
        int i2 = -1;
        int i3 = -1;
        int i4 = 0;
        for (i = 0; i < mVar.length; i++) {
            l lVar = mVar.asG[i];
            int[] iArr2 = iArr[i];
            int i5 = 0;
            while (i5 < lVar.length) {
                int i6;
                if (l(iArr2[i5], bVar.aAj)) {
                    Format format = lVar.arZ[i5];
                    int i7 = iArr2[i5];
                    String str = bVar.aAa;
                    Object obj = (format.aek & 1) != 0 ? 1 : null;
                    i6 = a(format, str) ? obj != null ? 4 : 3 : obj != null ? 2 : 1;
                    if (l(i7, false)) {
                        i6 += 1000;
                    }
                    if (i6 > i4) {
                        i3 = i6;
                        i2 = i5;
                        i6 = i;
                        i5++;
                        i4 = i3;
                        i3 = i2;
                        i2 = i6;
                    }
                }
                i6 = i2;
                i2 = i3;
                i3 = i4;
                i5++;
                i4 = i3;
                i3 = i2;
                i2 = i6;
            }
        }
        if (i2 == -1) {
            return null;
        }
        lVar = mVar.asG[i2];
        if (aVar != null) {
            int[] iArr3;
            iArr2 = iArr[i2];
            boolean z = bVar.aAh;
            i5 = 0;
            a aVar2 = null;
            HashSet hashSet = new HashSet();
            i6 = 0;
            while (i6 < lVar.length) {
                Format format2 = lVar.arZ[i6];
                a aVar3 = new a(format2.aef, format2.sampleRate, z ? null : format2.adV);
                if (hashSet.add(aVar3)) {
                    i2 = a(lVar, iArr2, aVar3);
                    if (i2 > i5) {
                        i4 = i2;
                        i5 = i4;
                        i6++;
                        aVar2 = aVar3;
                    }
                }
                aVar3 = aVar2;
                i4 = i5;
                i5 = i4;
                i6++;
                aVar2 = aVar3;
            }
            if (i5 > 1) {
                int[] iArr4 = new int[i5];
                i2 = 0;
                for (i = 0; i < lVar.length; i++) {
                    if (a(lVar.arZ[i], iArr2[i], aVar2)) {
                        i5 = i2 + 1;
                        iArr4[i2] = i;
                        i2 = i5;
                    }
                }
                iArr3 = iArr4;
            } else {
                iArr3 = azX;
            }
            if (iArr3.length > 0) {
                return aVar.lj();
            }
        }
        return new c(lVar, i3);
    }

    private static int a(l lVar, int[] iArr, a aVar) {
        int i = 0;
        int i2 = 0;
        while (i < lVar.length) {
            if (a(lVar.arZ[i], iArr[i], aVar)) {
                i2++;
            }
            i++;
        }
        return i2;
    }

    private static boolean a(Format format, int i, a aVar) {
        if (!l(i, false) || format.aef != aVar.aef || format.sampleRate != aVar.sampleRate) {
            return false;
        }
        if (aVar.mimeType == null || TextUtils.equals(aVar.mimeType, format.adV)) {
            return true;
        }
        return false;
    }

    private static e b(m mVar, int[][] iArr, b bVar) {
        l lVar = null;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < mVar.length; i3++) {
            l lVar2 = mVar.asG[i3];
            int[] iArr2 = iArr[i3];
            int i4 = 0;
            while (i4 < lVar2.length) {
                int i5;
                l lVar3;
                if (l(iArr2[i4], bVar.aAj)) {
                    Format format = lVar2.arZ[i4];
                    Object obj = (format.aek & 1) != 0 ? 1 : null;
                    Object obj2 = (format.aek & 2) != 0 ? 1 : null;
                    if (a(format, bVar.aAb)) {
                        if (obj != null) {
                            i5 = 6;
                        } else if (obj2 == null) {
                            i5 = 5;
                        } else {
                            i5 = 4;
                        }
                    } else if (obj != null) {
                        i5 = 3;
                    } else if (obj2 != null) {
                        if (a(format, bVar.aAa)) {
                            i5 = 2;
                        } else {
                            i5 = 1;
                        }
                    }
                    if (l(iArr2[i4], false)) {
                        i5 += 1000;
                    }
                    if (i5 > i2) {
                        i2 = i5;
                        lVar3 = lVar2;
                        i5 = i4;
                        i4++;
                        lVar = lVar3;
                        i = i5;
                    }
                }
                i5 = i;
                lVar3 = lVar;
                i4++;
                lVar = lVar3;
                i = i5;
            }
        }
        return lVar == null ? null : new c(lVar, i);
    }

    private static e c(m mVar, int[][] iArr, b bVar) {
        boolean z = false;
        int i = 0;
        l lVar = null;
        for (int i2 = 0; i2 < mVar.length; i2++) {
            l lVar2 = mVar.asG[i2];
            int[] iArr2 = iArr[i2];
            int i3 = 0;
            while (i3 < lVar2.length) {
                boolean z2;
                int i4;
                l lVar3;
                if (l(iArr2[i3], bVar.aAj)) {
                    if ((lVar2.arZ[i3].aek & 1) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (l(iArr2[i3], false)) {
                        z2 += 1000;
                    }
                    if (z2 > z) {
                        i4 = i3;
                        lVar3 = lVar2;
                        i3++;
                        lVar = lVar3;
                        i = i4;
                        z = z2;
                    }
                }
                z2 = z;
                i4 = i;
                lVar3 = lVar;
                i3++;
                lVar = lVar3;
                i = i4;
                z = z2;
            }
        }
        if (lVar == null) {
            return null;
        }
        return new c(lVar, i);
    }

    private static boolean l(int i, boolean z) {
        int i2 = i & 7;
        return i2 == 4 || (z && i2 == 3);
    }

    private static boolean a(Format format, String str) {
        return str != null && TextUtils.equals(str, t.ah(format.ael));
    }

    private static List<Integer> a(l lVar, int i, int i2, boolean z) {
        int i3;
        ArrayList arrayList = new ArrayList(lVar.length);
        for (i3 = 0; i3 < lVar.length; i3++) {
            arrayList.add(Integer.valueOf(i3));
        }
        if (i == Integer.MAX_VALUE || i2 == Integer.MAX_VALUE) {
            return arrayList;
        }
        int i4 = Integer.MAX_VALUE;
        for (i3 = 0; i3 < lVar.length; i3++) {
            Format format = lVar.arZ[i3];
            if (format.width > 0 && format.height > 0) {
                int i5;
                int i6;
                Point point;
                int i7 = format.width;
                int i8 = format.height;
                if (z) {
                    Object obj;
                    Object obj2;
                    if (i7 > i8) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (i > i2) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj != obj2) {
                        i5 = i;
                        i6 = i2;
                        if (i7 * i5 < i8 * i6) {
                            point = new Point(i6, t.at(i6 * i8, i7));
                        } else {
                            point = new Point(t.at(i5 * i7, i8), i5);
                        }
                        i5 = format.width * format.height;
                        if (format.width >= ((int) (((float) point.x) * 0.98f)) && format.height >= ((int) (((float) point.y) * 0.98f)) && i5 < i4) {
                            i4 = i5;
                        }
                    }
                }
                i5 = i2;
                i6 = i;
                if (i7 * i5 < i8 * i6) {
                    point = new Point(t.at(i5 * i7, i8), i5);
                } else {
                    point = new Point(i6, t.at(i6 * i8, i7));
                }
                i5 = format.width * format.height;
                i4 = i5;
            }
        }
        if (i4 != Integer.MAX_VALUE) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                i3 = lVar.arZ[((Integer) arrayList.get(size)).intValue()].io();
                if (i3 == -1 || i3 > i4) {
                    arrayList.remove(size);
                }
            }
        }
        return arrayList;
    }
}
