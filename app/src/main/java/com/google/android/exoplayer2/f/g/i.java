package com.google.android.exoplayer2.f.g;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class i implements d {
    private final List<e> awy;
    private final long[] ayz = new long[(this.azS * 2)];
    private final int azS;
    private final long[] azT;

    public i(List<e> list) {
        this.awy = list;
        this.azS = list.size();
        for (int i = 0; i < this.azS; i++) {
            e eVar = (e) list.get(i);
            int i2 = i * 2;
            this.ayz[i2] = eVar.startTime;
            this.ayz[i2 + 1] = eVar.endTime;
        }
        this.azT = Arrays.copyOf(this.ayz, this.ayz.length);
        Arrays.sort(this.azT);
    }

    public final int L(long j) {
        int a = t.a(this.azT, j);
        return a < this.azT.length ? a : -1;
    }

    public final int kJ() {
        return this.azT.length;
    }

    public final long cH(int i) {
        boolean z;
        boolean z2 = true;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        a.am(z);
        if (i >= this.azT.length) {
            z2 = false;
        }
        a.am(z2);
        return this.azT[i];
    }

    public final List<com.google.android.exoplayer2.f.a> M(long j) {
        CharSequence charSequence = null;
        int i = 0;
        e eVar = null;
        ArrayList arrayList = null;
        while (i < this.azS) {
            CharSequence charSequence2;
            e eVar2;
            ArrayList arrayList2;
            CharSequence charSequence3;
            if (this.ayz[i * 2] > j || j >= this.ayz[(i * 2) + 1]) {
                charSequence2 = charSequence;
                eVar2 = eVar;
                arrayList2 = arrayList;
                charSequence3 = charSequence2;
            } else {
                ArrayList arrayList3;
                Object obj;
                if (arrayList == null) {
                    arrayList3 = new ArrayList();
                } else {
                    arrayList3 = arrayList;
                }
                e eVar3 = (e) this.awy.get(i);
                if (eVar3.avU == Float.MIN_VALUE && eVar3.avX == Float.MIN_VALUE) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    arrayList3.add(eVar3);
                    charSequence3 = charSequence;
                    eVar2 = eVar;
                    arrayList2 = arrayList3;
                } else if (eVar == null) {
                    arrayList2 = arrayList3;
                    e eVar4 = eVar3;
                    charSequence3 = charSequence;
                    eVar2 = eVar4;
                } else if (charSequence == null) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append(eVar.text).append("\n").append(eVar3.text);
                    Object obj2 = spannableStringBuilder;
                    eVar2 = eVar;
                    arrayList2 = arrayList3;
                } else {
                    charSequence.append("\n").append(eVar3.text);
                    charSequence3 = charSequence;
                    eVar2 = eVar;
                    arrayList2 = arrayList3;
                }
            }
            i++;
            charSequence2 = charSequence3;
            arrayList = arrayList2;
            eVar = eVar2;
            charSequence = charSequence2;
        }
        if (charSequence != null) {
            arrayList.add(new e(charSequence));
        } else if (eVar != null) {
            arrayList.add(eVar);
        }
        return arrayList != null ? arrayList : Collections.emptyList();
    }
}
