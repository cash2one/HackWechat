package com.tencent.mm.ui.gridviewheaders;

class GridHeadersGridView$f {
    private int ydt;
    final /* synthetic */ GridHeadersGridView zfe;

    private GridHeadersGridView$f(GridHeadersGridView gridHeadersGridView) {
        this.zfe = gridHeadersGridView;
    }

    public final void cxp() {
        this.ydt = GridHeadersGridView.b(this.zfe);
    }

    public final boolean cxq() {
        return this.zfe.hasWindowFocus() && GridHeadersGridView.c(this.zfe) == this.ydt;
    }
}
