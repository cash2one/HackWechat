package com.tencent.mm.ui.a;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

public final class b {
    private final String TAG = "MicroMsg.Accessibility.Tool";
    private List<String> xNj = new ArrayList();

    public final b Ys(String str) {
        this.xNj.add(str);
        return this;
    }

    public final void dg(View view) {
        if (view != null && this.xNj.size() > 0) {
            CharSequence charSequence = "";
            for (String str : this.xNj) {
                Object obj = charSequence + str + ",";
            }
            view.setContentDescription(charSequence);
        }
    }
}
