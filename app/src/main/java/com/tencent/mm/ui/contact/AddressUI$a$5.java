package com.tencent.mm.ui.contact;

import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.VerticalScrollBar.a;

class AddressUI$a$5 implements a {
    final /* synthetic */ AddressUI.a yQF;

    AddressUI$a$5(AddressUI.a aVar) {
        this.yQF = aVar;
    }

    public final void xh(String str) {
        int i = 0;
        if (this.yQF.getString(R.l.eIq).equals(str)) {
            AddressUI.a.c(this.yQF).setSelection(0);
            return;
        }
        a a = AddressUI.a.a(this.yQF);
        x.v("MicroMsg.AddressAdapter", "getSections");
        String[] strArr = a.yPO;
        if (strArr == null) {
            return;
        }
        if ("↑".equals(str)) {
            AddressUI.a.c(this.yQF).setSelection(0);
        } else if ("☆".equals(str)) {
            AddressUI.a.c(this.yQF).setSelection(AddressUI.a.c(this.yQF).getHeaderViewsCount());
        } else {
            while (i < strArr.length && strArr[i] != null) {
                if (strArr[i].equals(str)) {
                    AddressUI.a.c(this.yQF).setSelection(AddressUI.a.a(this.yQF).getPositionForSection(i) + AddressUI.a.c(this.yQF).getHeaderViewsCount());
                    return;
                }
                i++;
            }
        }
    }
}
