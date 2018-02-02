package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.widget.EditText;
import android.widget.ListAdapter;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase.c;
import com.tencent.mm.plugin.appbrand.widget.input.b.a.a;
import com.tencent.mm.plugin.appbrand.widget.input.z;
import java.lang.ref.WeakReference;

public final class d {
    public static <Input extends EditText & z> void a(p pVar, Input input, a aVar) {
        if (((z) input).amL()) {
            h 1 = new 1(new WeakReference(input), new WeakReference(pVar));
            b ana = ((z) input).ana();
            ana.kag = new a(ana.kaa.getContext(), aVar.kbq);
            ana.kag.jZT = ana.kae;
            AutoFillListPopupWindowBase autoFillListPopupWindowBase = ana.kab;
            ListAdapter listAdapter = ana.kag;
            if (autoFillListPopupWindowBase.mObserver == null) {
                autoFillListPopupWindowBase.mObserver = new c(autoFillListPopupWindowBase, (byte) 0);
            } else if (autoFillListPopupWindowBase.FP != null) {
                autoFillListPopupWindowBase.FP.unregisterDataSetObserver(autoFillListPopupWindowBase.mObserver);
            }
            autoFillListPopupWindowBase.FP = listAdapter;
            if (autoFillListPopupWindowBase.FP != null) {
                listAdapter.registerDataSetObserver(autoFillListPopupWindowBase.mObserver);
            }
            if (autoFillListPopupWindowBase.kau != null) {
                autoFillListPopupWindowBase.kau.setAdapter(autoFillListPopupWindowBase.FP);
            }
            ana.kae.kam = 1;
            int i = "screen".equalsIgnoreCase(aVar.kbp) ? f.kaB : f.kaC;
            if (i != 0) {
                ana.kaf = i;
            }
            ana.ano();
        }
    }
}
