package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.qqmail.ui.MailAddrListUI.a;
import java.util.ArrayList;
import java.util.List;

class MailAddrListUI$7 implements OnMenuItemClickListener {
    final /* synthetic */ MailAddrListUI psL;

    MailAddrListUI$7(MailAddrListUI mailAddrListUI) {
        this.psL = mailAddrListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        a e = MailAddrListUI.e(this.psL);
        List arrayList = new ArrayList();
        for (String str : e.psO.keySet()) {
            arrayList.add(e.psO.get(str));
        }
        ComposeUI.bq(arrayList);
        this.psL.setResult(-1);
        this.psL.finish();
        return true;
    }
}
