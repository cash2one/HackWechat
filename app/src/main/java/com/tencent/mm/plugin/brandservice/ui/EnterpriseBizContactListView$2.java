package com.tencent.mm.plugin.brandservice.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.ag.f;
import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView$a.1;
import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView$a.2;
import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.widget.i;

class EnterpriseBizContactListView$2 implements OnItemLongClickListener {
    final /* synthetic */ EnterpriseBizContactListView kGr;

    EnterpriseBizContactListView$2(EnterpriseBizContactListView enterpriseBizContactListView) {
        this.kGr = enterpriseBizContactListView;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (EnterpriseBizContactListView.a(this.kGr) == null) {
            EnterpriseBizContactListView.a(this.kGr, new EnterpriseBizContactListView$a(this.kGr));
        }
        EnterpriseBizContactListView$a a = EnterpriseBizContactListView.a(this.kGr);
        int b = EnterpriseBizContactListView.b(this.kGr);
        int c = EnterpriseBizContactListView.c(this.kGr);
        if (a.kGt == null) {
            EnterpriseBizContactListView enterpriseBizContactListView = (EnterpriseBizContactListView) a.kGu.get();
            if (enterpriseBizContactListView == null) {
                return false;
            }
            a.kGt = new i(enterpriseBizContactListView.getContext());
        }
        Object tag = view.getTag();
        if (tag == null || !(tag instanceof c)) {
            return false;
        }
        a.kGs = ((c) tag).username;
        if (bh.ov(a.kGs) || f.eE(a.kGs)) {
            return false;
        }
        a.kGt.zul = view;
        a.kGt.a(adapterView, i, j, new 1(a, i), new 2(a), b, c);
        return true;
    }
}
