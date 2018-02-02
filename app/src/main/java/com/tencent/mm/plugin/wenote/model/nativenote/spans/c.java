package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import java.util.ArrayList;

public final class c extends o<Boolean, d> {
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
        while (i < size) {
            n nVar = (n) arrayList.get(i);
            ArrayList a = a(text, nVar, s.tWg);
            this.tVA.a(a, nVar);
            boolean booleanValue = nVar.a(eVar) ? obj.booleanValue() : !a.isEmpty();
            boolean z = i > 0 && nVar.bXz() == 1 && ((n) arrayList.get(i - 1)).bXz() == 1 && !obj.booleanValue();
            if (z ? false : booleanValue) {
                this.tVA.a(new d(b.bWo(), nVar.isEmpty(), nVar.tVG, nVar.tVH), nVar);
                u.tWl.a(text, nVar, this.tVA);
                u.tWj.a(text, nVar, this.tVA);
            }
            i++;
        }
        this.tVA.c(text);
    }

    public final int bXt() {
        return 1;
    }
}
