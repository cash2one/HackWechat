package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import android.text.style.CharacterStyle;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class e<V, C extends g<V>> extends t<V, C> {
    public abstract boolean bO(Object obj);

    protected abstract g<V> bXu();

    protected abstract V getValue(Object obj);

    protected final com.tencent.mm.plugin.wenote.model.nativenote.manager.e p(WXRTEditText wXRTEditText) {
        return new com.tencent.mm.plugin.wenote.model.nativenote.manager.e(wXRTEditText);
    }

    public void a(WXRTEditText wXRTEditText, V v) {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.e p = p(wXRTEditText);
        int i = p.isEmpty() ? 18 : 34;
        Spannable text = wXRTEditText.getText();
        Iterator it = a(text, p, s.tWg).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            boolean equals = getValue(next).equals(v);
            int spanStart = text.getSpanStart(next);
            if (spanStart < p.Ww) {
                if (equals) {
                    p.es(p.Ww - spanStart, 0);
                    i = 34;
                } else {
                    getValue(next);
                    text.setSpan(bXu(), spanStart, p.Ww, 33);
                }
            }
            spanStart = text.getSpanEnd(next);
            if (spanStart > p.wq) {
                if (equals) {
                    p.es(0, spanStart - p.wq);
                } else {
                    getValue(next);
                    text.setSpan(bXu(), p.wq, spanStart, 34);
                }
            }
            text.removeSpan(next);
        }
        if (v != null) {
            text.setSpan(bXu(), p.Ww, p.wq, i);
        }
    }

    protected final s<ArrayList> a(Spannable spannable, com.tencent.mm.plugin.wenote.model.nativenote.manager.e eVar, int i) {
        Object arrayList = new ArrayList();
        for (Object obj : spannable.getSpans(Math.max(0, eVar.Ww - 1), Math.min(spannable.length(), eVar.wq + 1), CharacterStyle.class)) {
            if (bO(obj)) {
                boolean z;
                int spanStart = spannable.getSpanStart(obj);
                int spanEnd = spannable.getSpanEnd(obj);
                int i2 = eVar.Ww;
                int i3 = eVar.wq;
                int max = Math.max(spanStart, i2);
                int min = Math.min(spanEnd, i3);
                if (max > min) {
                    z = false;
                } else if (max < min) {
                    z = true;
                } else if ((spanStart > i2 && spanEnd < i3) || (i2 > spanStart && i3 < spanEnd)) {
                    z = true;
                } else if (i == s.tWf) {
                    z = false;
                } else {
                    spanStart = spannable.getSpanFlags(obj) & 51;
                    z = spanEnd == i2 ? c(spanStart, new int[]{34, 18}) : c(spanStart, new int[]{17, 18});
                }
                if (z) {
                    arrayList.add(obj);
                }
            }
        }
        return arrayList;
    }
}
