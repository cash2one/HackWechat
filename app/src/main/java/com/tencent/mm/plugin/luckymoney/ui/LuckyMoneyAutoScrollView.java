package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollItem.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class LuckyMoneyAutoScrollView extends RelativeLayout implements b {
    private View contentView;
    private Context mContext;
    private RelativeLayout oga;
    private RelativeLayout ogb;
    private RelativeLayout ogc;
    LuckyMoneyAutoScrollItem ogd;
    LuckyMoneyAutoScrollItem oge;
    LuckyMoneyAutoScrollItem ogf;
    ImageView ogg;
    ImageView ogh;
    ImageView ogi;
    private String ogj;
    private String ogk;
    private String ogl;
    boolean ogm;
    private a ogn;

    public LuckyMoneyAutoScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.ogj = "0";
        this.ogk = "0";
        this.ogl = "0";
        this.ogm = false;
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(g.uCj, this);
        this.contentView = inflate;
        this.ogd = (LuckyMoneyAutoScrollItem) inflate.findViewById(f.ueA);
        this.oge = (LuckyMoneyAutoScrollItem) inflate.findViewById(f.ueB);
        this.ogf = (LuckyMoneyAutoScrollItem) inflate.findViewById(f.ueC);
        this.ogg = (ImageView) inflate.findViewById(f.uwO);
        this.ogh = (ImageView) inflate.findViewById(f.uwP);
        this.ogi = (ImageView) inflate.findViewById(f.uwQ);
        this.oga = (RelativeLayout) inflate.findViewById(f.ulh);
        this.ogb = (RelativeLayout) inflate.findViewById(f.uli);
        this.ogc = (RelativeLayout) inflate.findViewById(f.ulj);
    }

    public LuckyMoneyAutoScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final void DX(String str) {
        x.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: setting text: %s", new Object[]{str});
        this.ogj = str.substring(0, 1);
        this.ogk = str.substring(2, 3);
        this.ogl = str.substring(3, 4);
        this.ogd.ofQ = bh.getInt(this.ogj, 0);
        this.oge.ofQ = bh.getInt(this.ogk, 0);
        this.ogf.ofQ = bh.getInt(this.ogl, 0);
        this.ogg.setImageResource(((Integer) LuckyMoneyAutoScrollItem.ofU.get(bh.getInt(this.ogj, 0))).intValue());
        this.ogh.setImageResource(((Integer) LuckyMoneyAutoScrollItem.ofU.get(bh.getInt(this.ogk, 0))).intValue());
        this.ogi.setImageResource(((Integer) LuckyMoneyAutoScrollItem.ofU.get(bh.getInt(this.ogl, 0))).intValue());
        this.ogg.setVisibility(4);
        this.ogh.setVisibility(4);
        this.ogi.setVisibility(4);
        this.ogd.ofT = this;
        this.oge.ofT = this;
        this.ogf.ofT = this;
        x.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: first: %s, second :%s, third: %s", new Object[]{this.ogj, this.ogk, this.ogl});
    }

    public final void a(a aVar) {
        this.ogn = aVar;
        ag.y(new 1(this));
    }

    public final void aXw() {
        if (!this.ogm) {
            this.ogm = true;
            ag.y(new 2(this));
        }
    }

    public final void cL(int i, int i2) {
        if (i > 0 && i2 > 0) {
            LayoutParams layoutParams = (LayoutParams) this.contentView.getLayoutParams();
            layoutParams.height = i2;
            this.contentView.setLayoutParams(layoutParams);
            this.contentView.invalidate();
            layoutParams = (LayoutParams) this.oga.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.oga.setLayoutParams(layoutParams);
            this.oga.invalidate();
            layoutParams = (LayoutParams) this.ogb.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.ogb.setLayoutParams(layoutParams);
            this.ogb.invalidate();
            layoutParams = (LayoutParams) this.ogc.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            layoutParams.leftMargin = 0;
            this.ogc.setLayoutParams(layoutParams);
            this.ogc.invalidate();
        }
    }
}
