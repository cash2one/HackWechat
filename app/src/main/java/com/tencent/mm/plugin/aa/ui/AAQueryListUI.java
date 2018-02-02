package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.aa.a.c.b;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.l;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.g;

public class AAQueryListUI extends BaseAAPresenterActivity {
    private b ihY = ((b) q(b.class));
    private ListView ihZ;
    private b iia;
    private Dialog iib;
    private boolean iic = false;
    private boolean iid = false;
    private View iie;
    private AAQueryListH5UrlFooterView iif;
    private String iig;
    private int mode = 1;

    static /* synthetic */ void k(AAQueryListUI aAQueryListUI) {
        if (bh.ov(aAQueryListUI.iig)) {
            x.i("MicroMsg.AAQueryListUI", "empty h5 url!");
            aAQueryListUI.iif.setVisibility(8);
            return;
        }
        TextView textView = aAQueryListUI.iif.ihX;
        textView.setClickable(true);
        textView.setOnTouchListener(new l(aAQueryListUI));
        CharSequence spannableStringBuilder = new SpannableStringBuilder(aAQueryListUI.getString(i.uGX));
        spannableStringBuilder.setSpan(new a(new 7(aAQueryListUI)), 0, spannableStringBuilder.length(), 18);
        textView.setText(spannableStringBuilder);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new 1(this));
        setMMTitle(i.uHh);
        addIconOptionMenu(0, e.bDI, new 4(this));
        this.ihZ = (ListView) findViewById(f.uei);
        this.ihZ.setOnScrollListener(new 2(this));
        this.ihZ.setOnItemClickListener(new 3(this));
        this.iie = new AAQueryListLoadingMoreView(this);
        this.iif = new AAQueryListH5UrlFooterView(this);
        this.iib = g.a(this, false, null);
        this.iia = new b(this, this.mode);
        this.ihZ.setAdapter(this.iia);
        this.ihZ.setVisibility(4);
        d(false, this.mode);
    }

    private void d(boolean z, int i) {
        if (this.iic) {
            x.i("MicroMsg.AAQueryListUI", "getNextPage, loading");
            return;
        }
        if (z) {
            this.iid = false;
            this.ihZ.removeFooterView(this.iif);
        }
        this.iic = true;
        com.tencent.mm.vending.g.g.t(Boolean.valueOf(z), Integer.valueOf(i)).b(this.ihY.ihq).e(new 6(this, z)).a(new 5(this));
    }

    protected final int getLayoutId() {
        return a.g.uAS;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            boolean booleanExtra = intent.getBooleanExtra("close_aa", false);
            int intExtra = intent.getIntExtra("item_position", 0);
            int intExtra2 = intent.getIntExtra("item_offset", 0);
            if (booleanExtra) {
                this.ihZ.setSelectionFromTop(intExtra, intExtra2);
                d(true, this.mode);
            }
        }
        super.onActivityResult(i, i2, intent);
    }
}
