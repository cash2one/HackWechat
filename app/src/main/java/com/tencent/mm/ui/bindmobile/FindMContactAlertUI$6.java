package com.tencent.mm.ui.bindmobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.ui.MMWizardActivity;

class FindMContactAlertUI$6 implements OnClickListener {
    final /* synthetic */ FindMContactAlertUI ymg;

    FindMContactAlertUI$6(FindMContactAlertUI findMContactAlertUI) {
        this.ymg = findMContactAlertUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(this.ymg, FindMContactLearmMoreUI.class);
        intent.putExtra("regsetinfo_ticket", FindMContactAlertUI.a(this.ymg));
        intent.putExtra("regsetinfo_NextStep", FindMContactAlertUI.b(this.ymg));
        intent.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.c(this.ymg));
        MMWizardActivity.A(this.ymg, intent);
    }
}
