package com.tencent.mm.ui.bindmobile;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mm.sdk.platformtools.x;

class FindMContactAlertUI$8 implements OnGlobalLayoutListener {
    final /* synthetic */ View quh;
    final /* synthetic */ FindMContactAlertUI ymg;

    FindMContactAlertUI$8(FindMContactAlertUI findMContactAlertUI, View view) {
        this.ymg = findMContactAlertUI;
        this.quh = view;
    }

    public final void onGlobalLayout() {
        this.quh.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        int measuredHeight = this.quh.getMeasuredHeight();
        x.d("MicroMsg.FindMContactAlertUI", "bg width: %s height: %s", new Object[]{Integer.valueOf(this.quh.getMeasuredWidth()), Integer.valueOf(measuredHeight)});
        FindMContactAlertUI.b(this.ymg, r1, measuredHeight);
    }
}
