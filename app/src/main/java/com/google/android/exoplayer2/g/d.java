package com.google.android.exoplayer2.g;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.g.e.a;
import com.google.android.exoplayer2.s;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.t;
import java.util.Arrays;
import java.util.Map;

public abstract class d extends g {
    private final SparseArray<Map<m, b>> aAl = new SparseArray();
    private final SparseBooleanArray aAm = new SparseBooleanArray();
    private a aAn;
    private int aez = 0;

    protected abstract e[] a(s[] sVarArr, m[] mVarArr, int[][][] iArr);

    public final h a(s[] sVarArr, m mVar) {
        int i;
        int i2;
        int[] iArr;
        int[] iArr2 = new int[(sVarArr.length + 1)];
        l[][] lVarArr = new l[(sVarArr.length + 1)][];
        int[][][] iArr3 = new int[(sVarArr.length + 1)][][];
        for (i = 0; i < lVarArr.length; i++) {
            lVarArr[i] = new l[mVar.length];
            iArr3[i] = new int[mVar.length][];
        }
        int[] iArr4 = new int[sVarArr.length];
        for (i = 0; i < iArr4.length; i++) {
            iArr4[i] = sVarArr[i].hU();
        }
        for (i2 = 0; i2 < mVar.length; i2++) {
            int[] iArr5;
            l lVar = mVar.asG[i2];
            int length = sVarArr.length;
            i = 0;
            int i3 = 0;
            while (i3 < sVarArr.length) {
                s sVar = sVarArr[i3];
                int i4 = 0;
                while (i4 < lVar.length) {
                    int b = sVar.b(lVar.arZ[i4]) & 7;
                    if (b > i) {
                        if (b == 4) {
                            break;
                        }
                        length = b;
                        b = i3;
                    } else {
                        b = length;
                        length = i;
                    }
                    i4++;
                    i = length;
                    length = b;
                }
                i3++;
            }
            i3 = length;
            if (i3 == sVarArr.length) {
                iArr5 = new int[lVar.length];
            } else {
                s sVar2 = sVarArr[i3];
                iArr = new int[lVar.length];
                for (i = 0; i < lVar.length; i++) {
                    iArr[i] = sVar2.b(lVar.arZ[i]);
                }
                iArr5 = iArr;
            }
            length = iArr2[i3];
            lVarArr[i3][length] = lVar;
            iArr3[i3][length] = iArr5;
            iArr2[i3] = iArr2[i3] + 1;
        }
        m[] mVarArr = new m[sVarArr.length];
        iArr = new int[sVarArr.length];
        for (i4 = 0; i4 < sVarArr.length; i4++) {
            b = iArr2[i4];
            mVarArr[i4] = new m((l[]) Arrays.copyOf(lVarArr[i4], b));
            iArr3[i4] = (int[][]) Arrays.copyOf(iArr3[i4], b);
            iArr[i4] = sVarArr[i4].getTrackType();
        }
        m mVar2 = new m((l[]) Arrays.copyOf(lVarArr[sVarArr.length], iArr2[sVarArr.length]));
        e[] a = a(sVarArr, mVarArr, iArr3);
        for (i2 = 0; i2 < sVarArr.length; i2++) {
            e eVar;
            e[] eVarArr;
            if (this.aAm.get(i2)) {
                eVar = null;
                b = i2;
                eVarArr = a;
            } else {
                m mVar3 = mVarArr[i2];
                Map map = (Map) this.aAl.get(i2);
                Object obj = (map == null || !map.containsKey(mVar3)) ? null : 1;
                if (obj != null) {
                    b bVar = (b) ((Map) this.aAl.get(i2)).get(mVar3);
                    if (bVar == null) {
                        eVar = null;
                        b = i2;
                        eVarArr = a;
                    } else {
                        a aVar = bVar.aAt;
                        l[] lVarArr2 = mVar3.asG;
                        eVar = aVar.lj();
                        b = i2;
                        eVarArr = a;
                    }
                } else {
                }
            }
            eVarArr[b] = eVar;
        }
        a aVar2 = new a(iArr, mVarArr, iArr4, iArr3, mVar2);
        t[] tVarArr = new t[sVarArr.length];
        for (length = 0; length < sVarArr.length; length++) {
            tVarArr[length] = a[length] != null ? t.aey : null;
        }
        int i5 = this.aez;
        if (i5 != 0) {
            b = -1;
            int i6 = -1;
            i4 = 0;
            while (i4 < sVarArr.length) {
                int trackType = sVarArr[i4].getTrackType();
                e eVar2 = a[i4];
                if ((trackType == 1 || trackType == 2) && eVar2 != null) {
                    Object obj2;
                    int[][] iArr6 = iArr3[i4];
                    m mVar4 = mVarArr[i4];
                    if (eVar2 == null) {
                        obj2 = null;
                    } else {
                        int a2 = mVar4.a(eVar2.lg());
                        for (length = 0; length < eVar2.length(); length++) {
                            if ((iArr6[a2][eVar2.cO(length)] & 32) != 32) {
                                obj2 = null;
                                break;
                            }
                        }
                        obj2 = 1;
                    }
                    if (obj2 != null) {
                        if (trackType == 1) {
                            if (b != -1) {
                                i3 = 0;
                                break;
                            }
                            length = i6;
                            i6 = i4;
                            i4++;
                            b = i6;
                            i6 = length;
                        } else if (i6 != -1) {
                            i3 = 0;
                            break;
                        } else {
                            length = i4;
                            i6 = b;
                            i4++;
                            b = i6;
                            i6 = length;
                        }
                    }
                }
                length = i6;
                i6 = b;
                i4++;
                b = i6;
                i6 = length;
            }
            i3 = 1;
            length = (b == -1 || i6 == -1) ? 0 : 1;
            if ((length & i3) != 0) {
                t tVar = new t(i5);
                tVarArr[b] = tVar;
                tVarArr[i6] = tVar;
            }
        }
        return new h(mVar, new f(a), aVar2, tVarArr);
    }

    public final void W(Object obj) {
        this.aAn = (a) obj;
    }
}
