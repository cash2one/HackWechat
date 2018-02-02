package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class o<V, C extends g<V>> extends t<V, C> {
    public abstract void a(WXRTEditText wXRTEditText, e eVar, V v);

    protected final e p(WXRTEditText wXRTEditText) {
        return wXRTEditText.bWU();
    }

    public final void a(WXRTEditText wXRTEditText, V v) {
        e bWU = wXRTEditText.bWU();
        if (wXRTEditText.tTH && wXRTEditText.bWN().Ww == bWU.Ww && bWU.Ww > 1) {
            ArrayList a = a(wXRTEditText.getText(), bWU, s.tWg);
            if (!a.isEmpty() && wXRTEditText.getLayout().getPrimaryHorizontal(wXRTEditText.bWN().Ww) == ((float) b.bWo())) {
                Iterator it = a.iterator();
                while (it.hasNext()) {
                    wXRTEditText.getText().removeSpan(it.next());
                }
                wXRTEditText.getText().insert(bWU.Ww - 1, "\n");
            }
        }
        a(wXRTEditText, bWU, (Object) v);
        u.a(wXRTEditText, new t[]{this});
    }

    protected final void a(Spannable spannable, n nVar, p pVar) {
        pVar.a(a(spannable, (e) nVar, s.tWf), nVar);
    }

    protected final s<ArrayList> a(Spannable spannable, e eVar, int i) {
        ArrayList arrayList = new ArrayList();
        Type[] actualTypeArguments = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
        if (actualTypeArguments == null) {
            return null;
        }
        for (Object obj : spannable.getSpans(eVar.Ww, eVar.wq, (Class) actualTypeArguments[actualTypeArguments.length - 1])) {
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
                z = spanStart == i2 && spanEnd == i3 && i2 == i3;
            } else {
                spanStart = spannable.getSpanFlags(obj) & 51;
                z = spanEnd == i2 ? c(spanStart, new int[]{34, 18}) : c(spanStart, new int[]{17, 18});
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
