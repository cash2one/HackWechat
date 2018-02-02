package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.contact.AddressUI.a;

class AddressUI$a$4 implements d {
    final /* synthetic */ a yQF;

    AddressUI$a$4(a aVar) {
        this.yQF = aVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
            case 2:
                a.a(this.yQF, a.k(this.yQF));
                return;
            case 7:
                a.c(this.yQF, a.k(this.yQF));
                return;
            default:
                return;
        }
    }
}
