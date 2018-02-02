package com.tencent.mm.plugin.multitalk.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.au.a;
import com.tencent.mm.plugin.multitalk.a.d;
import com.tencent.mm.plugin.multitalk.a.i;
import com.tencent.mm.plugin.multitalk.a.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.q;
import java.util.LinkedList;
import java.util.List;

class MultiTalkSelectContactUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ MultiTalkSelectContactUI oHR;

    MultiTalkSelectContactUI$1(MultiTalkSelectContactUI multiTalkSelectContactUI) {
        this.oHR = multiTalkSelectContactUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (an.isNetworkConnected(ac.getContext())) {
            List linkedList = new LinkedList();
            linkedList.addAll(MultiTalkSelectContactUI.a(this.oHR));
            linkedList.add(q.FS());
            String d = bh.d(linkedList, ",");
            if (MultiTalkSelectContactUI.b(this.oHR)) {
                d.a(MultiTalkSelectContactUI.a(this.oHR).size(), MultiTalkSelectContactUI.c(this.oHR), 1, "", MultiTalkSelectContactUI.d(this.oHR).oIv);
                o.bcV().a(this.oHR, d, MultiTalkSelectContactUI.e(this.oHR));
            } else {
                d.a(MultiTalkSelectContactUI.a(this.oHR).size(), MultiTalkSelectContactUI.c(this.oHR), 2, i.bcK(), 0);
                this.oHR.setResult(-1, this.oHR.getIntent().putExtra("Select_Contact", d));
                this.oHR.finish();
            }
        } else {
            a.a(this.oHR, R.l.eVz, null);
        }
        this.oHR.aWs();
        return true;
    }
}
