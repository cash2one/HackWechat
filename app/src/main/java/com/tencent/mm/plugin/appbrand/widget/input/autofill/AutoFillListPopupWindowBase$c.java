package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.database.DataSetObserver;

class AutoFillListPopupWindowBase$c extends DataSetObserver {
    final /* synthetic */ AutoFillListPopupWindowBase kaA;

    private AutoFillListPopupWindowBase$c(AutoFillListPopupWindowBase autoFillListPopupWindowBase) {
        this.kaA = autoFillListPopupWindowBase;
    }

    public final void onChanged() {
        if (this.kaA.inJ.isShowing()) {
            this.kaA.show();
        }
    }

    public final void onInvalidated() {
        this.kaA.dismiss();
    }
}
