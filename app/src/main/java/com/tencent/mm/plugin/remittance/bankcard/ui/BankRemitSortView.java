package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c$a;
import com.tencent.mm.ui.base.sortview.d;

public class BankRemitSortView extends BaseSortView {
    private final String TAG = "MicroMsg.BankcardSortView";
    private ListView kHk;

    public BankRemitSortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final View inflate() {
        return View.inflate(getContext(), g.uBm, this);
    }

    public final VerticalScrollBar asw() {
        return (VerticalScrollBar) findViewById(f.cOn);
    }

    public final ListView getListView() {
        this.kHk = (ListView) findViewById(f.ctf);
        return this.kHk;
    }

    public final View asx() {
        return null;
    }

    public final boolean a(String str, d dVar) {
        return false;
    }

    public final c$a asy() {
        return new 1(this);
    }
}
