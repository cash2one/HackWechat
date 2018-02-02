package com.tencent.mm.plugin.aa.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.aa.ui.AASelectContactUI.4;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

class AASelectContactUI$4$1 implements OnClickListener {
    final /* synthetic */ 4 iiD;

    AASelectContactUI$4$1(4 4) {
        this.iiD = 4;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (((long) AASelectContactUI.b(this.iiD.iiA).size()) > AASelectContactUI.d(this.iiD.iiA)) {
            h.b(this.iiD.iiA.mController.xIM, this.iiD.iiA.getString(i.uJv, new Object[]{Long.valueOf(AASelectContactUI.d(this.iiD.iiA))}), "", true);
            g.pQN.h(13722, new Object[]{Integer.valueOf(3)});
            return;
        }
        List linkedList = new LinkedList();
        linkedList.addAll(AASelectContactUI.b(this.iiD.iiA));
        this.iiD.iiA.setResult(-1, this.iiD.iiA.getIntent().putExtra("Select_Contact", bh.d(linkedList, ",")));
        this.iiD.iiA.finish();
        g.pQN.h(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(11)});
    }
}
