package com.tencent.mm.ui.bindmobile;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.i;

class FindMContactAlertUI$7 implements OnGlobalLayoutListener {
    final /* synthetic */ i lpG;
    final /* synthetic */ FindMContactAlertUI ymg;

    FindMContactAlertUI$7(FindMContactAlertUI findMContactAlertUI, i iVar) {
        this.ymg = findMContactAlertUI;
        this.lpG = iVar;
    }

    public final void onGlobalLayout() {
        int measuredWidth;
        this.lpG.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
        int measuredWidth2 = this.lpG.getWindow().getDecorView().getMeasuredWidth();
        int measuredHeight = this.lpG.getWindow().getDecorView().getMeasuredHeight();
        View a = FindMContactAlertUI.a(this.ymg, (ViewGroup) this.lpG.getWindow().getDecorView());
        if (a != null) {
            measuredWidth = a.getMeasuredWidth() * 2;
        } else {
            measuredWidth = measuredWidth2;
        }
        x.d("MicroMsg.FindMContactAlertUI", "dialog width: %s height: %s", new Object[]{Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight)});
        FindMContactAlertUI.a(this.ymg, measuredWidth, measuredHeight);
    }
}
