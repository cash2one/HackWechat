package com.tencent.mm.ui.friend;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.ui.MMWizardActivity;

class FindMContactAddUI$13 implements OnClickListener {
    final /* synthetic */ FindMContactAddUI zcv;

    FindMContactAddUI$13(FindMContactAddUI findMContactAddUI) {
        this.zcv = findMContactAddUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (FindMContactAddUI.k(this.zcv) == null || !FindMContactAddUI.k(this.zcv).contains("2")) {
            FindMContactAddUI.n(this.zcv);
            return;
        }
        Intent intent = new Intent(this.zcv, FindMContactInviteUI.class);
        intent.putExtra("regsetinfo_ticket", FindMContactAddUI.l(this.zcv));
        intent.putExtra("login_type", FindMContactAddUI.m(this.zcv));
        intent.putExtra("regsetinfo_NextStyle", FindMContactAddUI.e(this.zcv));
        MMWizardActivity.A(this.zcv, intent);
    }
}
