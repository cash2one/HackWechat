package com.tencent.mm.view;

class SmileySubGrid$c implements Runnable {
    final /* synthetic */ SmileySubGrid zEj;

    private SmileySubGrid$c(SmileySubGrid smileySubGrid) {
        this.zEj = smileySubGrid;
    }

    public final void run() {
        if (!SmileySubGrid.c(this.zEj)) {
            SmileySubGrid.f(this.zEj).addView(SmileySubGrid.d(this.zEj), SmileySubGrid.e(this.zEj));
            SmileySubGrid.g(this.zEj);
        }
    }
}
