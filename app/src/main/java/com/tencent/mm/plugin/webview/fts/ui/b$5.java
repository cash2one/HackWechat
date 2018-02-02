package com.tencent.mm.plugin.webview.fts.ui;

import com.tencent.mm.sdk.platformtools.bc;

class b$5 extends bc<Boolean> {
    final /* synthetic */ int jhi;
    final /* synthetic */ b trB;

    public b$5(b bVar, Boolean bool, int i) {
        this.trB = bVar;
        this.jhi = i;
        super(1000, bool);
    }

    protected final /* synthetic */ Object run() {
        return Boolean.valueOf(this.trB.ls(this.jhi));
    }
}
