package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import android.util.SparseIntArray;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import java.util.ArrayList;
import java.util.List;

public final class l extends o<Boolean, m> {
    private p tVA = new p();

    public final /* synthetic */ void a(WXRTEditText wXRTEditText, e eVar, Object obj) {
        obj = (Boolean) obj;
        Spannable text = wXRTEditText.getText();
        if (obj == null) {
            obj = Boolean.valueOf(false);
        }
        this.tVA.tVO.clear();
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        ArrayList arrayList = wXRTEditText.bWV().tUa;
        int size = arrayList.size();
        int i = 0;
        int i2 = 1;
        while (i < size) {
            int i3;
            int i4;
            n nVar = (n) arrayList.get(i);
            List a = u.tWm.a(text, nVar, s.tWf);
            if (a.isEmpty()) {
                i3 = 0;
            } else {
                i4 = 0;
                for (Object next : a) {
                    i4 = next instanceof g ? ((Integer) ((g) next).getValue()).intValue() + i4 : i4;
                }
                i3 = i4;
            }
            sparseIntArray.put(i2, i3);
            ArrayList a2 = a(text, nVar, s.tWg);
            this.tVA.a(a2, nVar);
            boolean booleanValue = nVar.a(eVar) ? obj.booleanValue() : !a2.isEmpty();
            Object next2 = (i <= 0 || nVar.bXz() != 1 || ((n) arrayList.get(i - 1)).bXz() != 1 || obj.booleanValue()) ? null : 1;
            if (next2 != null ? false : booleanValue) {
                i4 = 1;
                for (int i5 = 1; i5 < i2; i5++) {
                    int i6 = sparseIntArray.get(i5);
                    int i7 = sparseIntArray2.get(i5);
                    if (i6 < i3) {
                        i6 = 1;
                    } else if (i6 != i3) {
                    } else {
                        i6 = i7 == 0 ? 1 : i7 + 1;
                    }
                    i4 = i6;
                }
                sparseIntArray2.put(i2, i4);
                this.tVA.a(new m(i4, b.bWo(), nVar.isEmpty(), nVar.tVG, nVar.tVH), nVar);
                u.tWk.a(text, nVar, this.tVA);
                u.tWj.a(text, nVar, this.tVA);
            }
            i++;
            i2++;
        }
        this.tVA.c(text);
    }

    public final int bXt() {
        return 2;
    }
}
