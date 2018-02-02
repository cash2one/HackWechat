package com.tencent.mm.ui.contact;

import com.tencent.mm.R;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.ui.base.h;

class SnsLabelContactListUI$b extends c<ny> {
    final /* synthetic */ SnsLabelContactListUI yUM;

    private SnsLabelContactListUI$b(SnsLabelContactListUI snsLabelContactListUI) {
        this.yUM = snsLabelContactListUI;
        this.xen = ny.class.getName().hashCode();
    }

    /* synthetic */ SnsLabelContactListUI$b(SnsLabelContactListUI snsLabelContactListUI, byte b) {
        this(snsLabelContactListUI);
        this.xen = ny.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ny nyVar = (ny) bVar;
        if (!(nyVar instanceof ny)) {
            return false;
        }
        SnsLabelContactListUI.a(this.yUM, nyVar.fFR.fxY);
        if (SnsLabelContactListUI.b(this.yUM) != null) {
            SnsLabelContactListUI.c(this.yUM);
            this.yUM.initView();
        } else {
            this.yUM.initView();
            h.a(this.yUM, this.yUM.getString(R.l.ePT), "", new 1(this));
        }
        return true;
    }
}
