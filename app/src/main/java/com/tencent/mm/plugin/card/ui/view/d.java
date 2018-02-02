package com.tencent.mm.plugin.card.ui.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;

public final class d extends i {
    private TextView kOl;
    private View kWo;
    private TextView kWp;
    private TextView kWq;

    public final void initView() {
        this.kWo = findViewById(R.h.bJA);
        this.kWp = (TextView) findViewById(R.h.bJB);
        this.kOl = (TextView) findViewById(R.h.cNK);
        this.kWq = (TextView) findViewById(R.h.bRL);
        this.kWp.setOnClickListener(this.kWz.avM());
        this.kWo.setVisibility(8);
    }

    public final void update() {
        b avI = this.kWz.avI();
        Context avL = this.kWz.avL();
        this.kWo.setVisibility(0);
        if (TextUtils.isEmpty(avI.atB().vRT)) {
            this.kWp.setVisibility(8);
        } else {
            this.kWp.setVisibility(0);
            this.kWp.setText(avI.atB().vRT);
            if (avI.ath() || (avI.atg() && avI.atj())) {
                this.kWp.setTextColor(avL.getResources().getColor(R.e.white));
            } else if (avI.atg() && avI.ati()) {
                this.kWp.setTextColor(avL.getResources().getColor(R.e.brH));
                this.kWo.setBackgroundColor(avL.getResources().getColor(R.e.brI));
            } else {
                this.kWp.setTextColor(avL.getResources().getColor(R.e.white));
            }
        }
        View findViewById = this.kWo.findViewById(R.h.bRY);
        if (this.kWz.avN().awT()) {
            findViewById.setVisibility(0);
            this.kWq.setText(avL.getString(R.l.dPi));
            this.kWq.setTextColor(avL.getResources().getColor(R.e.white));
            int dimensionPixelOffset = avL.getResources().getDimensionPixelOffset(R.f.bvJ);
            Button button = (Button) this.kWo.findViewById(R.h.bRJ);
            Drawable d = l.d(avL, avL.getResources().getColor(R.e.white), dimensionPixelOffset);
            Drawable ch = l.ch(avL.getResources().getColor(R.e.white), dimensionPixelOffset);
            Drawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, ch);
            stateListDrawable.addState(new int[0], d);
            button.setBackgroundDrawable(stateListDrawable);
            int[] iArr = new int[]{l.wO(avI.atB().hbM), avL.getResources().getColor(R.e.white)};
            button.setTextColor(new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[0]}, iArr));
            button.setOnClickListener(this.kWz.avM());
            findViewById = this.kWo.findViewById(R.h.cvW);
            View findViewById2 = this.kWo.findViewById(R.h.bQX);
            if (avI.atB().vSh == 1) {
                findViewById.setVisibility(0);
                findViewById2.setVisibility(0);
                return;
            }
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
            return;
        }
        findViewById.setVisibility(8);
    }

    public final void awW() {
        this.kWo.setVisibility(8);
    }

    public final void wE(String str) {
        this.kWq.setText(str);
    }
}
