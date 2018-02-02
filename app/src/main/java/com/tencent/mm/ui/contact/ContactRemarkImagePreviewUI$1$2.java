package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.ui.contact.ContactRemarkImagePreviewUI.1;
import java.io.File;

class ContactRemarkImagePreviewUI$1$2 implements p$d {
    final /* synthetic */ 1 yRC;

    ContactRemarkImagePreviewUI$1$2(1 1) {
        this.yRC = 1;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                if (ContactRemarkImagePreviewUI.b(this.yRC.yRB)) {
                    new File(ContactRemarkImagePreviewUI.c(this.yRC.yRB)).delete();
                    ContactRemarkImagePreviewUI.a(this.yRC.yRB, true);
                    return;
                }
                ContactRemarkImagePreviewUI.a(this.yRC.yRB, true);
                return;
            case 1:
                k.h(ContactRemarkImagePreviewUI.c(this.yRC.yRB), this.yRC.yRB);
                return;
            case 2:
                ContactRemarkImagePreviewUI.d(this.yRC.yRB);
                return;
            default:
                return;
        }
    }
}
