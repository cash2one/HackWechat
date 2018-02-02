package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.ui.base.h;

class SnsMsgUI$9 implements OnMenuItemClickListener {
    final /* synthetic */ SnsMsgUI rDE;

    SnsMsgUI$9(SnsMsgUI snsMsgUI) {
        this.rDE = snsMsgUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        h.a(this.rDE.mController.xIM, this.rDE.getString(j.qLE), "", new OnClickListener(this) {
            final /* synthetic */ SnsMsgUI$9 rDH;

            {
                this.rDH = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                SnsMsgUI.b(this.rDH.rDE).setVisibility(8);
                SnsMsgUI.c(this.rDH.rDE).setVisibility(0);
                ae.bvA().hhp.fx("SnsComment", "delete from SnsComment");
                this.rDH.rDE.enableOptionMenu(false);
            }
        }, null);
        return true;
    }
}
