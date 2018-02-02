package com.tencent.mm.ui.transmit;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.platformtools.t;

class SelectConversationUI$17 implements OnMenuItemClickListener {
    final /* synthetic */ SelectConversationUI zpv;

    SelectConversationUI$17(SelectConversationUI selectConversationUI) {
        this.zpv = selectConversationUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (SelectConversationUI.n(this.zpv)) {
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_User", t.d(SelectConversationUI.o(this.zpv), ","));
        Intent intent2 = (Intent) this.zpv.getIntent().getParcelableExtra("Select_Conv_NextStep");
        if (intent2 != null) {
            SelectConversationUI.a(this.zpv, intent, intent2);
        } else if (SelectConversationUI.p(this.zpv)) {
            SelectConversationUI.a(this.zpv, intent);
            this.zpv.finish();
        } else {
            SelectConversationUI.b(this.zpv, intent);
        }
        return true;
    }
}
