package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class z extends a {
    private Runnable hXj;
    TextView imw;

    public z(Context context, u uVar, ViewGroup viewGroup) {
        super(context, uVar, viewGroup);
    }

    protected final int bjK() {
        return i$g.qGU;
    }

    public final void bwG() {
        super.bwG();
        if (!e.remove(this.hXj)) {
            e.Q(this.hXj);
        }
    }

    protected final void bxa() {
        if (((u) this.rji).fpn != 1) {
            this.imw.setText(((u) this.rji).rhh);
        } else if (!bh.ov(((u) this.rji).rhh)) {
            String replace = ((u) this.rji).rhh.replace("<icon", "<img");
            e.remove(this.hXj);
            this.hXj = new 1(this, replace);
            e.post(this.hXj, "");
        }
        if (((u) this.rji).textAlignment == 0) {
            this.imw.setGravity(3);
        } else if (((u) this.rji).textAlignment == 1) {
            this.imw.setGravity(17);
        } else if (((u) this.rji).textAlignment == 2) {
            this.imw.setGravity(5);
        }
        if (((u) this.rji).rhi == null || ((u) this.rji).rhi.length() <= 0) {
            this.imw.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            try {
                this.imw.setTextColor(Color.parseColor(((u) this.rji).rhi));
            } catch (Exception e) {
                x.e("MicroMsg.Sns.AdLandingPageTextComponent", "parse the color is error : " + ((u) this.rji).rhi);
            }
        }
        if (((u) this.rji).gUh > 0.0f) {
            this.imw.setTextSize(0, ((u) this.rji).gUh);
        }
        TextPaint paint = this.imw.getPaint();
        if (((u) this.rji).rhj) {
            paint.setFakeBoldText(true);
        }
        if (((u) this.rji).rhk) {
            paint.setTextSkewX(-0.25f);
        }
        if (((u) this.rji).rhl) {
            paint.setUnderlineText(true);
        }
        if (((u) this.rji).maxLines > 0) {
            this.imw.setMaxLines(((u) this.rji).maxLines);
        }
        if (((u) this.rji).rhm == u.rhg) {
            this.imw.setTypeface(ac.dx(this.context));
        }
    }

    @TargetApi(17)
    public final View bwW() {
        View view = this.contentView;
        view.setBackgroundColor(this.backgroundColor);
        view.findViewById(f.qDA).setBackgroundColor(this.backgroundColor);
        view.findViewById(f.qDB).setBackgroundColor(this.backgroundColor);
        this.imw = (TextView) view.findViewById(f.qDB);
        return view;
    }

    public final void bwH() {
        super.bwH();
    }

    public final void bwI() {
        super.bwI();
    }
}
