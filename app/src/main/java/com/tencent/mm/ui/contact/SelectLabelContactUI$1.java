package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class SelectLabelContactUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SelectLabelContactUI yUD;

    SelectLabelContactUI$1(SelectLabelContactUI selectLabelContactUI) {
        this.yUD = selectLabelContactUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        x.i("MicroMsg.SelectLabelContactUI", "SelectUser: %s", new Object[]{new ArrayList(SelectLabelContactUI.a(this.yUD)).toString()});
        SelectLabelContactUI.a(this.yUD, bh.d(r0, ","));
        return true;
    }
}
