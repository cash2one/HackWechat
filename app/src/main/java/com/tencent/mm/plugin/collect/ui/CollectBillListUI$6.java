package com.tencent.mm.plugin.collect.ui;

import android.support.design.widget.BottomSheetBehavior;
import com.tencent.mm.sdk.platformtools.x;

class CollectBillListUI$6 implements Runnable {
    final /* synthetic */ CollectBillListUI llF;
    final /* synthetic */ DatePickerDialogView llG;
    final /* synthetic */ BottomSheetBehavior llH;

    CollectBillListUI$6(CollectBillListUI collectBillListUI, DatePickerDialogView datePickerDialogView, BottomSheetBehavior bottomSheetBehavior) {
        this.llF = collectBillListUI;
        this.llG = datePickerDialogView;
        this.llH = bottomSheetBehavior;
    }

    public final void run() {
        x.d("MicroMsg.CollectBillListUI", "view height: %d", Integer.valueOf(this.llG.getHeight()));
        this.llH.q(this.llG.getHeight());
    }
}
