package com.tencent.mm.plugin.favorite.ui.base;

import android.view.View;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.d;
import com.tencent.mm.sdk.platformtools.w;

public final class a {
    public Button lgD;
    public TextView lgK;
    public long muM = j.aIK();
    public boolean muO = false;
    public View muP;
    public a muQ;

    public final void show() {
        if (!this.muO) {
            if (this.muP != null) {
                if (this.muP instanceof ViewStub) {
                    this.muP = ((ViewStub) this.muP).inflate();
                }
                this.lgK = (TextView) this.muP.findViewById(R.h.cgq);
                if (!w.cfe()) {
                    this.lgK.setTextSize(1, 14.0f);
                }
                this.lgD = (Button) this.muP.findViewById(R.h.cgp);
                aJy();
                this.lgD.setOnClickListener(new 1(this));
                this.muO = true;
            } else {
                return;
            }
        }
        if (this.muP.getVisibility() != 0) {
            this.muP.setVisibility(0);
            this.muP.startAnimation(AnimationUtils.loadAnimation(this.muP.getContext(), R.a.bpZ));
        }
    }

    public final void hide() {
        if (this.muO && this.muP.getVisibility() != 8) {
            this.muP.setVisibility(8);
            this.muP.startAnimation(AnimationUtils.loadAnimation(this.muP.getContext(), R.a.bqa));
        }
    }

    public final void aJy() {
        this.lgK.setText(this.lgK.getContext().getString(R.l.eey, new Object[]{d.dg(this.muM)}));
        this.lgD.setEnabled(false);
    }
}
