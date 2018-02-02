package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.product.b.b;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.e;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class MallProductSelectSkuUI extends MallBaseUI implements a {
    private TextView jJn;
    private m pdK;
    private e pdZ;
    private c pfH;
    private ImageView pgj;
    private TextView pgk;
    private TextView pgl;
    private Button pgm;
    private ListView pgn;
    private MallProductSelectAmountView pgo = null;
    private i pgp = null;
    private f pgq;

    protected final int getLayoutId() {
        return g.uDE;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pgq = new f(this.mController.xIM, new 1(this));
        com.tencent.mm.plugin.product.a.a.biM();
        this.pfH = com.tencent.mm.plugin.product.a.a.biN();
        this.pdK = this.pfH.pdK;
        initView();
        au();
    }

    public void onStart() {
        this.pgq.onStart();
        super.onStart();
    }

    protected void onStop() {
        this.pgq.onStop();
        super.onStop();
    }

    protected final void initView() {
        setMMTitle(i.uLA);
        this.pgj = (ImageView) findViewById(f.uqL);
        this.jJn = (TextView) findViewById(f.uqP);
        this.pgk = (TextView) findViewById(f.uqN);
        this.pgl = (TextView) findViewById(f.uqK);
        this.pgm = (Button) findViewById(f.uqM);
        this.pgn = (ListView) findViewById(f.uqS);
        this.pgo = (MallProductSelectAmountView) findViewById(f.uws);
        MallProductSelectAmountView mallProductSelectAmountView = this.pgo;
        mallProductSelectAmountView.pgg = this.pfH.mCount;
        if (mallProductSelectAmountView.bjo()) {
            mallProductSelectAmountView.ihU.setText(mallProductSelectAmountView.pgg);
            if (mallProductSelectAmountView.pgh != null) {
                mallProductSelectAmountView.pgh.es(mallProductSelectAmountView.pgg);
            }
        }
        this.pgp = new i(this);
        if (this.pdK == null || this.pdK.peo == null || this.pdK.peo.peJ == null) {
            x.e("MicroMsg.MallProductSelectSkuUI", "Illage mProductInfo.base_attr.sku_table");
        } else {
            this.pgp.pgs = this.pdK.peo.peJ;
        }
        this.pgp.pgt = new 2(this);
        this.pgn.setAdapter(this.pgp);
        this.pgo.pgh = new 3(this);
        this.pgm.setOnClickListener(new 4(this));
        this.pgj.setFocusable(true);
        this.pgj.setFocusableInTouchMode(true);
        this.pgj.requestFocus();
    }

    private void au() {
        if (this.pdK != null) {
            if (this.pdZ == null || this.pdK.peo == null) {
                this.pgk.setText(b.l(this.pdK.peo.peA, this.pdK.peo.peB, this.pdK.peo.paz));
            } else {
                this.pgk.setText(b.l(this.pdZ.ped, this.pdZ.pee, this.pdK.peo.paz));
            }
            if (this.pdK.peo != null) {
                this.jJn.setText(this.pdK.peo.name);
            }
        }
        if (!bh.ov(this.pfH.biQ())) {
            this.pgj.setImageBitmap(j.a(new c(this.pfH.biQ())));
            j.a(this);
        }
        this.pgl.setVisibility(8);
        MallProductSelectAmountView mallProductSelectAmountView = this.pgo;
        int biY = this.pfH.biY();
        int i = this.pfH.pdK.pen;
        if (biY > i) {
            mallProductSelectAmountView.pge = 3;
            mallProductSelectAmountView.pgd = i;
        } else {
            mallProductSelectAmountView.pge = 1;
            mallProductSelectAmountView.pgd = biY;
        }
        mallProductSelectAmountView.bjo();
        if (mallProductSelectAmountView.pgh != null) {
            mallProductSelectAmountView.pgh.es(mallProductSelectAmountView.pgg);
        }
        this.pgp.notifyDataSetChanged();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.pgq.onActivityResult(i, i2, intent);
    }

    public final void l(String str, Bitmap bitmap) {
        x.d("MicroMsg.MallProductSelectSkuUI", str + ", bitmap = " + (bitmap == null));
        if (!bh.ov(this.pfH.biQ())) {
            this.pgj.post(new 5(this, bitmap));
        }
    }
}
