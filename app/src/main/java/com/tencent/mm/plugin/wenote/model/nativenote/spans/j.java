package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import java.util.ArrayList;
import java.util.Iterator;

public final class j extends o<Boolean, k> {
    private p tVA = new p();

    public final /* synthetic */ void a(WXRTEditText wXRTEditText, e eVar, Object obj) {
        obj = (Boolean) obj;
        Spannable text = wXRTEditText.getText();
        if (obj == null) {
            obj = Boolean.valueOf(false);
        }
        this.tVA.tVO.clear();
        ArrayList arrayList = wXRTEditText.bWV().tUa;
        int size = arrayList.size();
        int i = 0;
        k kVar = null;
        while (i < size) {
            n nVar = (n) arrayList.get(i);
            ArrayList a = a(text, nVar, s.tWg);
            this.tVA.a(a, nVar);
            k kVar2 = (a.isEmpty() || !(a.get(0) instanceof k)) ? null : (k) a.get(0);
            boolean z = kVar2 != null && kVar2.tVJ;
            if (kVar != null && kVar == kVar2 && z) {
                z = false;
            }
            boolean z2 = !a.isEmpty();
            boolean booleanValue = nVar.a(eVar) ? obj.booleanValue() : z2;
            Object obj2 = (i <= 0 || nVar.bXz() != 1 || ((n) arrayList.get(i - 1)).bXz() != 1 || obj.booleanValue()) ? null : 1;
            boolean z3 = obj2 != null ? false : booleanValue;
            if (z3) {
                this.tVA.a(new k(z, b.bWo(), nVar.isEmpty(), nVar.tVG, nVar.tVH), nVar);
                u.tWl.a(text, nVar, this.tVA);
                u.tWk.a(text, nVar, this.tVA);
            }
            if (!z3 && z2) {
                Iterator it = a.iterator();
                while (it.hasNext()) {
                    text.removeSpan(it.next());
                }
            }
            i++;
            kVar = kVar2;
        }
        this.tVA.c(text);
    }

    public final int bXt() {
        return 3;
    }
}
