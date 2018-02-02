package com.tencent.mm.plugin.sight.draft.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;

class SightDraftUI$2 implements a {
    final /* synthetic */ SightDraftUI qwc;

    SightDraftUI$2(SightDraftUI sightDraftUI) {
        this.qwc = sightDraftUI;
    }

    public final void btl() {
        this.qwc.addTextOptionMenu(SightDraftUI.a(this.qwc), this.qwc.getString(R.l.ePE), new OnMenuItemClickListener(this) {
            final /* synthetic */ SightDraftUI$2 qwd;

            {
                this.qwd = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                SightDraftUI.b(this.qwd.qwc);
                return true;
            }
        });
    }

    public final void btm() {
        this.qwc.removeOptionMenu(SightDraftUI.a(this.qwc));
    }
}
