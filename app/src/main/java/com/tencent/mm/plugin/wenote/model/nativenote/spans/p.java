package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import java.util.ArrayList;
import java.util.Iterator;

public final class p {
    final ArrayList<a> tVO = new ArrayList();

    private static class a {
        final f tVP;
        final n tVQ;
        final boolean tVR;

        a(Object obj, n nVar, boolean z) {
            this.tVP = (f) obj;
            this.tVQ = nVar;
            this.tVR = z;
        }
    }

    public final void a(ArrayList<Object> arrayList, n nVar) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof f) {
                this.tVO.add(new a(next, nVar, true));
            }
        }
    }

    public final void a(Object obj, n nVar) {
        this.tVO.add(new a(obj, nVar, false));
    }

    public final void c(Spannable spannable) {
        Iterator it = this.tVO.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            f fVar = aVar.tVP;
            int i = aVar.tVQ.Ww;
            int spanStart;
            if (aVar.tVR) {
                spanStart = spannable.getSpanStart(fVar);
                if (spanStart >= 0 && spanStart < i) {
                    spannable.setSpan(fVar.bXw(), spanStart, i, 34);
                }
                spannable.removeSpan(fVar);
            } else {
                n nVar = aVar.tVQ;
                int i2 = aVar.tVQ.wq;
                spanStart = (nVar.tVH && nVar.isEmpty()) ? 34 : (nVar.tVH && nVar.tVG) ? 18 : nVar.tVH ? 34 : 33;
                if (i2 > spannable.length()) {
                    i2 = spannable.length();
                }
                spannable.setSpan(fVar, i, i2, spanStart);
            }
        }
    }
}
