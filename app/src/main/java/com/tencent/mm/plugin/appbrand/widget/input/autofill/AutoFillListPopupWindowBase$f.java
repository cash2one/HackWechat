package com.tencent.mm.plugin.appbrand.widget.input.autofill;

class AutoFillListPopupWindowBase$f implements Runnable {
    final /* synthetic */ AutoFillListPopupWindowBase kaA;

    private AutoFillListPopupWindowBase$f(AutoFillListPopupWindowBase autoFillListPopupWindowBase) {
        this.kaA = autoFillListPopupWindowBase;
    }

    public final void run() {
        if (AutoFillListPopupWindowBase.a(this.kaA) != null && AutoFillListPopupWindowBase.a(this.kaA).getCount() > AutoFillListPopupWindowBase.a(this.kaA).getChildCount() && AutoFillListPopupWindowBase.a(this.kaA).getChildCount() <= this.kaA.ST) {
            AutoFillListPopupWindowBase.b(this.kaA).setInputMethodMode(2);
            this.kaA.show();
        }
    }
}
