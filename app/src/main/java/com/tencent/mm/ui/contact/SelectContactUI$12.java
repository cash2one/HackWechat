package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;

class SelectContactUI$12 implements OnClickListener {
    final /* synthetic */ SelectContactUI yUy;

    SelectContactUI$12(SelectContactUI selectContactUI) {
        this.yUy = selectContactUI;
    }

    public final void onClick(View view) {
        g.pQN.h(11140, new Object[]{Integer.valueOf(0)});
        d.y(this.yUy, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
    }
}
