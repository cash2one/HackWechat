package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import com.tencent.mm.plugin.card.ui.n;

public abstract class i {
    n kWz;

    public abstract void initView();

    public final void a(n nVar) {
        this.kWz = nVar;
        initView();
    }

    public void destroy() {
        this.kWz = null;
    }

    public void update() {
    }

    public void awW() {
    }

    protected final View findViewById(int i) {
        return this.kWz.findViewById(i);
    }

    protected final String getString(int i) {
        return this.kWz.getString(i);
    }
}
