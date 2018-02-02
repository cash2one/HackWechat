package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.plugin.luckymoney.b.ah;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.luckymoney.ui.g.c;
import com.tencent.mm.plugin.luckymoney.ui.g.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class g$a implements d {
    c ojm;

    g$a() {
    }

    public final void a(Context context, ViewGroup viewGroup, ah ahVar) {
        if (bh.ov(ahVar.name)) {
            x.w("MicroMsg.LuckyMoneyOperationViewMgr", "BannerPicOperationView attach iconUrl null");
            viewGroup.setVisibility(8);
            return;
        }
        View imageView = new ImageView(context);
        imageView.setScaleType(ScaleType.FIT_XY);
        n.h(imageView, ahVar.name);
        if (!bh.ov(ahVar.content)) {
            imageView.setOnClickListener(new 1(this, ahVar, context));
        }
        imageView.setLayoutParams(new LayoutParams(-1, -1));
        viewGroup.addView(imageView);
        viewGroup.setVisibility(0);
        g.pQN.h(11701, Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(ahVar.odF));
        if (this.ojm != null) {
            f.eB(this.ojm.ojs, 0);
        }
    }
}
