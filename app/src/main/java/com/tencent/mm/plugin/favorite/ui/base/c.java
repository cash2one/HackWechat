package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class c extends LinearLayout {
    private View muX;
    public View muY;
    public View muZ;
    public a mva;
    private boolean mvb = false;
    private boolean mvc = false;
    private int mvd;

    public c(Context context) {
        super(context);
        setOrientation(1);
        MarginLayoutParams layoutParams = new LayoutParams(-1, -2);
        this.muX = View.inflate(getContext(), R.i.dhH, null);
        View inflate = View.inflate(getContext(), R.i.dhu, null);
        inflate.findViewById(R.h.cBE).setOnClickListener(new 1(this));
        this.muY = inflate;
        inflate = View.inflate(getContext(), R.i.dhG, null);
        inflate.findViewById(R.h.chu).setOnClickListener(new 2(this));
        this.muZ = inflate;
        addView(this.muX, new LayoutParams(layoutParams));
        addView(this.muY, new LayoutParams(layoutParams));
        addView(this.muZ, new LayoutParams(layoutParams));
    }

    public final void fd(boolean z) {
        this.muX.setVisibility(z ? 0 : 8);
    }

    private void pN(int i) {
        this.mvd = i;
        x.i("MicroMsg.FavHeaderView", "showStatusBar status:" + i);
        if (i == 0) {
            this.muZ.setVisibility(8);
            this.muY.setVisibility(8);
        } else if (i == 1) {
            if (!this.mvb) {
                g.pQN.h(14109, new Object[]{Integer.valueOf(1)});
            }
            this.mvb = true;
            this.muZ.setVisibility(8);
            this.muY.setVisibility(0);
            this.muY.findViewById(R.h.cBF).setVisibility(0);
            this.muY.findViewById(R.h.cBG).setVisibility(8);
        } else if (i == 2) {
            this.muZ.setVisibility(0);
            this.muY.setVisibility(8);
        } else if (i == 3) {
            if (!this.mvc) {
                g.pQN.h(14109, new Object[]{Integer.valueOf(0)});
            }
            this.mvc = true;
            this.muZ.setVisibility(8);
            this.muY.setVisibility(0);
            this.muY.findViewById(R.h.cBF).setVisibility(8);
            this.muY.findViewById(R.h.cBG).setVisibility(0);
        }
    }

    public final void aJz() {
        long j;
        int i;
        List<f> aIe = h.getFavItemInfoStorage().aIe();
        if (aIe != null) {
            j = 0;
            i = 0;
            for (f a : aIe) {
                j = b.a(a) + j;
                i = 1;
            }
            x.i("MicroMsg.FavHeaderView", "triggerStatusBar uploadFailedItemList size:%d,totalSize:%d", new Object[]{Integer.valueOf(aIe.size()), Long.valueOf(j)});
        } else {
            j = 0;
            i = 0;
        }
        if (i != 0) {
            if (j > j.aIK()) {
                pN(1);
            } else {
                pN(2);
            }
        } else if (j.aIO()) {
            pN(3);
        } else {
            pN(0);
        }
    }
}
