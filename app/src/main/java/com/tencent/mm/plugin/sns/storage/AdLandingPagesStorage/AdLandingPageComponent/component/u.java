package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;

public final class u extends i {
    TextView imw;
    private RelativeLayout rkH;
    ImageView rkI;

    public u(Context context, t tVar, ViewGroup viewGroup) {
        super(context, tVar, viewGroup);
        this.rji = tVar;
    }

    protected final int bjK() {
        return g.qGR;
    }

    public final void bwG() {
        super.bwG();
    }

    protected final void bxa() {
        this.imw.setText(((t) this.rji).label);
        this.imw.setTextSize(0, ((t) this.rji).azb);
        if (((t) this.rji).iMN != null && ((t) this.rji).iMN.length() > 0) {
            this.rkH.setBackgroundColor(Color.parseColor(((t) this.rji).iMN));
        }
        d.a(((t) this.rji).rhb, ((t) this.rji).rgL, new 1(this));
    }

    public final View bwW() {
        View view = this.contentView;
        view.setBackgroundColor(this.backgroundColor);
        this.imw = (TextView) view.findViewById(f.qDz);
        this.rkH = (RelativeLayout) view.findViewById(f.qDx);
        this.rkI = (ImageView) view.findViewById(f.qDy);
        return view;
    }

    public final void bwH() {
        super.bwH();
    }

    public final void bwI() {
        super.bwI();
    }
}
