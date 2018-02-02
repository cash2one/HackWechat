package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

class AASelectContactUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ AASelectContactUI iiA;

    AASelectContactUI$3(AASelectContactUI aASelectContactUI) {
        this.iiA = aASelectContactUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (((long) AASelectContactUI.b(this.iiA).size()) > AASelectContactUI.d(this.iiA)) {
            h.b(this.iiA.mController.xIM, this.iiA.getString(i.uJv, new Object[]{Long.valueOf(AASelectContactUI.d(this.iiA))}), "", true);
            g.pQN.h(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(8)});
            g.pQN.h(13722, new Object[]{Integer.valueOf(3)});
        } else if (AASelectContactUI.b(this.iiA).size() <= 0) {
            h.b(this.iiA.mController.xIM, this.iiA.getString(i.uHp, new Object[]{Integer.valueOf(1)}), "", true);
            g.pQN.h(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(9)});
        } else {
            List linkedList = new LinkedList();
            linkedList.addAll(AASelectContactUI.b(this.iiA));
            this.iiA.setResult(-1, this.iiA.getIntent().putExtra("Select_Contact", bh.d(linkedList, ",")));
            this.iiA.finish();
            this.iiA.aWs();
            g.pQN.h(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(8)});
        }
        return true;
    }
}
