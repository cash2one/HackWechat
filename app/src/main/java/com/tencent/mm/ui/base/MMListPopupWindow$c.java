package com.tencent.mm.ui.base;

import android.database.DataSetObserver;

class MMListPopupWindow$c extends DataSetObserver {
    final /* synthetic */ MMListPopupWindow ybW;

    private MMListPopupWindow$c(MMListPopupWindow mMListPopupWindow) {
        this.ybW = mMListPopupWindow;
    }

    public final void onChanged() {
        if (this.ybW.inJ.isShowing()) {
            this.ybW.show();
        }
    }

    public final void onInvalidated() {
        this.ybW.dismiss();
    }
}
