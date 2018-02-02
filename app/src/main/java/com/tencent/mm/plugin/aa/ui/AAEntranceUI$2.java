package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import com.tencent.mm.plugin.aa.ui.a.a;

class AAEntranceUI$2 implements a {
    final /* synthetic */ AAEntranceUI ihP;

    AAEntranceUI$2(AAEntranceUI aAEntranceUI) {
        this.ihP = aAEntranceUI;
    }

    public final void WO() {
        this.ihP.startActivity(new Intent(this.ihP.mController.xIM, AAQueryListUI.class));
    }
}
