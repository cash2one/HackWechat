package com.tencent.mm.plugin.appbrand.widget.b;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

public final class c implements Iterator<View> {
    private int jMo = 0;
    private final ViewGroup jWf;

    public final /* synthetic */ Object next() {
        ViewGroup viewGroup = this.jWf;
        int i = this.jMo;
        this.jMo = i + 1;
        return viewGroup.getChildAt(i);
    }

    public c(ViewGroup viewGroup) {
        this.jWf = viewGroup;
    }

    public final boolean hasNext() {
        return this.jMo < this.jWf.getChildCount();
    }

    public final void remove() {
        this.jWf.removeViewAt(this.jMo - 1);
    }
}
