package com.tencent.mm.ui.chatting.viewitems;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.x;

public final class p extends RelativeLayout {
    private LayoutInflater nny;
    private int yLw;

    public p(LayoutInflater layoutInflater, int i) {
        super(layoutInflater.getContext());
        this.nny = layoutInflater;
        this.yLw = i;
        View inflate = this.nny.inflate(R.i.ddb, null);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        inflate.setId(R.h.bUh);
        layoutParams.setMargins(0, getResources().getDimensionPixelSize(R.f.bvJ), 0, getResources().getDimensionPixelSize(R.f.bvJ));
        inflate.setVisibility(8);
        addView(inflate, layoutParams);
        inflate = new TextView(getContext(), null, R.m.eYK);
        inflate.setId(R.h.bVf);
        int dimensionPixelSize = inflate.getResources().getDimensionPixelSize(R.f.bvW);
        if (a.aa(getContext(), R.f.bvW) != dimensionPixelSize) {
            x.e("MicroMsg.ChattingItemContainer", "WDF!!! cacheSize:%s sysSize:%s", new Object[]{Integer.valueOf(a.aa(getContext(), R.f.bvW)), Integer.valueOf(dimensionPixelSize)});
        }
        inflate.setTextSize(0, (float) dimensionPixelSize);
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, R.h.bUh);
        layoutParams.addRule(14);
        layoutParams.setMargins(0, getResources().getDimensionPixelSize(R.f.bvJ), 0, getResources().getDimensionPixelSize(R.f.bvJ));
        addView(inflate, layoutParams);
        CheckBox checkBox = (CheckBox) LayoutInflater.from(getContext()).inflate(R.i.dnp, this, false);
        checkBox.setId(R.h.bTC);
        dimensionPixelSize = a.fromDPToPix(getContext(), 32);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams2.setMargins(0, getResources().getDimensionPixelSize(R.f.buo), getResources().getDimensionPixelSize(R.f.bvS), 0);
        layoutParams2.addRule(3, R.h.bVf);
        layoutParams2.addRule(11);
        layoutParams2.width = dimensionPixelSize;
        layoutParams2.height = dimensionPixelSize;
        addView(checkBox, layoutParams2);
        View inflate2 = this.nny.inflate(this.yLw, null);
        int id = inflate2.getId();
        if (-1 == id) {
            x.v("MicroMsg.ChattingItemContainer", "content view has no id, use defaul id");
            id = R.h.bTF;
            inflate2.setId(R.h.bTF);
        }
        layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(3, R.h.bVf);
        layoutParams2.addRule(0, R.h.bTC);
        addView(inflate2, layoutParams2);
        inflate2 = new View(getContext());
        inflate2.setId(R.h.bUC);
        inflate2.setVisibility(8);
        layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(6, id);
        layoutParams2.addRule(8, id);
        addView(inflate2, layoutParams2);
    }
}
