package com.tencent.mm.view;

class SmileySubGrid$d {
    private int ydt;
    final /* synthetic */ SmileySubGrid zEj;

    private SmileySubGrid$d(SmileySubGrid smileySubGrid) {
        this.zEj = smileySubGrid;
    }

    public final void cxp() {
        this.ydt = SmileySubGrid.a(this.zEj);
    }

    public final boolean cxq() {
        return this.zEj.hasWindowFocus() && SmileySubGrid.b(this.zEj) == this.ydt;
    }
}
