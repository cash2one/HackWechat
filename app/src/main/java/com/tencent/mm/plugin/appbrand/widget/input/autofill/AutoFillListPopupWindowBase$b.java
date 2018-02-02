package com.tencent.mm.plugin.appbrand.widget.input.autofill;

class AutoFillListPopupWindowBase$b implements Runnable {
    final /* synthetic */ AutoFillListPopupWindowBase kaA;

    private AutoFillListPopupWindowBase$b(AutoFillListPopupWindowBase autoFillListPopupWindowBase) {
        this.kaA = autoFillListPopupWindowBase;
    }

    public final void run() {
        this.kaA.clearListSelection();
    }
}
