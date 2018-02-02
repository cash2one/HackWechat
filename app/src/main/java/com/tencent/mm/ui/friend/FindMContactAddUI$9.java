package com.tencent.mm.ui.friend;

import android.view.View;
import android.view.View.OnClickListener;

class FindMContactAddUI$9 implements OnClickListener {
    final /* synthetic */ FindMContactAddUI zcv;

    FindMContactAddUI$9(FindMContactAddUI findMContactAddUI) {
        this.zcv = findMContactAddUI;
    }

    public final void onClick(View view) {
        FindMContactAddUI.f(this.zcv).setVisibility(0);
        FindMContactAddUI.g(this.zcv).setVisibility(8);
        FindMContactAddUI.c(this.zcv).bN(false);
        FindMContactAddUI.c(this.zcv).notifyDataSetChanged();
    }
}
