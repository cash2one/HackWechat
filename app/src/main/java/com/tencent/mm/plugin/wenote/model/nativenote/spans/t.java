package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import java.util.ArrayList;

public abstract class t<V, C extends g<V>> {
    protected abstract s<ArrayList> a(Spannable spannable, e eVar, int i);

    public abstract void a(WXRTEditText wXRTEditText, V v);

    public abstract int bXt();

    protected abstract e p(WXRTEditText wXRTEditText);

    public final boolean q(WXRTEditText wXRTEditText) {
        return !a(wXRTEditText.getText(), p(wXRTEditText), s.tWg).isEmpty();
    }

    protected static boolean c(int i, int... iArr) {
        for (int i2 = 0; i2 < 2; i2++) {
            int i3 = iArr[i2];
            if ((i & i3) == i3) {
                return true;
            }
        }
        return false;
    }
}
