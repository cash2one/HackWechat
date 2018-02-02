package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.x;

public class GameBlockView extends LinearLayout {
    LayoutInflater DF;
    LinearLayout muI;
    LayoutParams nlV;
    l nlW;

    public GameBlockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setOrientation(1);
        this.DF = (LayoutInflater) getContext().getSystemService("layout_inflater");
        this.nlV = new LayoutParams(-1, -2);
        this.muI = this;
        this.nlW = new l();
        x.i("MicroMsg.GameBlockView", "initView finished");
    }
}
