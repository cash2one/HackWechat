package com.tencent.mm.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

class ShowImageUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ ShowImageUI zmY;

    ShowImageUI$2(ShowImageUI showImageUI) {
        this.zmY = showImageUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        if (ShowImageUI.a(this.zmY) && d.OQ("favorite")) {
            linkedList2.add(Integer.valueOf(0));
            linkedList.add(this.zmY.getString(R.l.eEG));
            linkedList2.add(Integer.valueOf(1));
            linkedList.add(this.zmY.getString(R.l.eAd));
            linkedList2.add(Integer.valueOf(2));
            linkedList.add(this.zmY.getString(R.l.eHg));
        } else {
            linkedList2.add(Integer.valueOf(0));
            linkedList.add(this.zmY.getString(R.l.eEG));
            linkedList2.add(Integer.valueOf(2));
            linkedList.add(this.zmY.getString(R.l.eHg));
        }
        b dhVar = new dh();
        dhVar.frQ.fqm = this.zmY.getIntent().getLongExtra("key_message_id", -1);
        a.xef.m(dhVar);
        if (dhVar.frR.frp) {
            linkedList2.add(Integer.valueOf(3));
            linkedList.add(this.zmY.getString(R.l.dRM));
        }
        h.a(this.zmY, "", linkedList, linkedList2, "", false, new 1(this));
        return true;
    }
}
