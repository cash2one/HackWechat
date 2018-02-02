package com.tencent.mm.plugin.nearlife.ui;

import android.view.View;
import android.view.View.OnClickListener;

class CheckInLifeUI$2 implements OnClickListener {
    final /* synthetic */ CheckInLifeUI oQL;

    CheckInLifeUI$2(CheckInLifeUI checkInLifeUI) {
        this.oQL = checkInLifeUI;
    }

    public final void onClick(View view) {
        CheckInLifeUI.a(this.oQL, view, true);
    }
}
