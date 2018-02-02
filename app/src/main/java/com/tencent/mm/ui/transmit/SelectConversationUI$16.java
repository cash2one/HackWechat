package com.tencent.mm.ui.transmit;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;

class SelectConversationUI$16 implements OnMenuItemClickListener {
    final /* synthetic */ SelectConversationUI zpv;

    SelectConversationUI$16(SelectConversationUI selectConversationUI) {
        this.zpv = selectConversationUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        SelectConversationUI.a(this.zpv, !SelectConversationUI.a(this.zpv));
        this.zpv.cvZ().nb(SelectConversationUI.a(this.zpv));
        this.zpv.yTa.nb(SelectConversationUI.a(this.zpv));
        SelectConversationUI.k(this.zpv);
        SelectConversationUI.m(this.zpv).setText(!SelectConversationUI.a(this.zpv) ? SelectConversationUI.l(this.zpv) : R.l.eJs);
        return true;
    }
}
