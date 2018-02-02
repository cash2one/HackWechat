package com.tencent.mm.plugin.product.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import com.tencent.mm.plugin.product.a.a;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.sdk.platformtools.bh;

public class MallProductReceiptUI extends MallBaseUI {
    private c pfH;
    private d pfX = null;
    private AutoCompleteTextView pfY = null;
    private h pfZ = null;

    protected final int getLayoutId() {
        return g.uDA;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pfX = a.biM().biO();
        a.biM();
        this.pfH = a.biN();
        initView();
    }

    public final void initView() {
        setMMTitle(i.uLx);
        addTextOptionMenu(0, getString(i.dFl), new 1(this));
        this.pfY = (AutoCompleteTextView) findViewById(f.uqH);
        bbk biU = this.pfH.biU();
        if (!(biU == null || bh.ov(biU.ngs))) {
            this.pfY.setText(biU.ngs);
        }
        this.pfY.setSelection(this.pfY.getText().length());
        this.pfZ = new h(this);
        this.pfY.setAdapter(this.pfZ);
        this.pfY.setOnItemClickListener(new 2(this));
        View.inflate(this.mController.xIM, g.uDy, null).setOnClickListener(new 3(this));
    }
}
