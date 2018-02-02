package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;

public class MallProductSelectAmountView extends LinearLayout {
    TextView ihU = null;
    private ImageView pgb = null;
    private ImageView pgc = null;
    int pgd = Integer.MAX_VALUE;
    int pge = 1;
    private int pgf = 1;
    int pgg = this.pgf;
    a pgh = null;

    public MallProductSelectAmountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(g.uDB, this, true);
        this.ihU = (TextView) inflate.findViewById(f.uqJ);
        this.pgb = (ImageView) inflate.findViewById(f.uqI);
        this.pgc = (ImageView) inflate.findViewById(f.uqO);
        this.ihU.setText(this.pgg);
        this.pgb.setOnClickListener(new 1(this));
        this.pgc.setOnClickListener(new 2(this));
    }

    final boolean bjo() {
        if (this.pgg > this.pgd) {
            this.pgg = this.pgd;
            if (this.pgh != null) {
                this.pgh.es(this.pgg);
            }
            if (this.pgh != null) {
                this.pgh.di(this.pgg, this.pge);
            }
            this.ihU.setText(this.pgg);
            return false;
        }
        if (this.pgg > this.pgf) {
            this.pgc.setEnabled(true);
        } else if (this.pgg == this.pgf) {
            this.pgc.setEnabled(false);
        } else {
            this.pgc.setEnabled(false);
            this.pgg = this.pgf;
            if (this.pgh != null) {
                this.pgh.es(this.pgg);
            }
            if (this.pgh != null) {
                this.pgh.di(this.pgg, 2);
            }
            this.ihU.setText(this.pgg);
            return false;
        }
        return true;
    }
}
