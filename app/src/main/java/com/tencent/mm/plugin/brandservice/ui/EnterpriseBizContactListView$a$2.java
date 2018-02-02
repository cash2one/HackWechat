package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.a;
import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.a.3;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;

class EnterpriseBizContactListView$a$2 implements d {
    final /* synthetic */ a kGv;

    EnterpriseBizContactListView$a$2(a aVar) {
        this.kGv = aVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (!bh.ov(this.kGv.kGs) && menuItem.getItemId() == 1) {
            a aVar = this.kGv;
            String str = this.kGv.kGs;
            EnterpriseBizContactListView enterpriseBizContactListView = (EnterpriseBizContactListView) aVar.kGu.get();
            if (enterpriseBizContactListView != null) {
                Context context = enterpriseBizContactListView.getContext();
                h.a(context, context.getString(R.l.ebM), "", context.getString(R.l.ebL), context.getString(R.l.dEn), new 3(aVar, str, context), null);
            }
        }
    }
}
