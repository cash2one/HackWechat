package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.k;

public class MallProductItemView extends LinearLayout {
    private TextView jJn;
    private Object mData;
    private String mTitle;
    private int mType;
    private String pcW;
    private int pfT;
    private TextView pfl;
    private ImageView pfm;

    public MallProductItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.pfT = 1;
        this.mType = 0;
        this.mData = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.uZz, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(k.uZB, 0);
        if (resourceId != 0) {
            this.mTitle = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(k.uZC, 0);
        if (resourceId != 0) {
            this.pcW = context.getString(resourceId);
        }
        this.pfT = obtainStyledAttributes.getInt(k.uZA, 1);
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate(g.uDz, this, true);
        this.jJn = (TextView) inflate.findViewById(f.cSu);
        this.pfl = (TextView) inflate.findViewById(f.uwG);
        this.pfm = (ImageView) inflate.findViewById(f.ukU);
        this.jJn.setText(this.mTitle);
        this.pfl.setText(this.pcW);
        this.pfl.setLines(this.pfT);
    }

    public MallProductItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void Hv(String str) {
        this.pcW = str;
        this.pfl.setText(this.pcW);
    }
}
