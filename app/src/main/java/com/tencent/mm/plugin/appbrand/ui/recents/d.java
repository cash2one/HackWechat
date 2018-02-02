package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.plugin.appbrand.q$d;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.List;

final class d implements OnClickListener {
    b jPS;
    int jPT = c.jQe;
    final d jPU = new d((byte) 0);
    private final int jPV;
    private final int jPW = 200;
    private final a jPX;

    public d(ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        this.jPX = new a(this, context, (byte) 0);
        View inflate = LayoutInflater.from(context).inflate(h.ixi, viewGroup, false);
        this.jPU.VU = inflate;
        this.jPU.jQj = (TextView) inflate.findViewById(g.title);
        this.jPU.jQk = inflate.findViewById(g.ivY);
        this.jPU.jQm = (TextView) inflate.findViewById(g.ivZ);
        this.jPU.jQl = (AppBrandNearbyShowcaseView) inflate.findViewById(g.ivV);
        this.jPU.jPG = (ThreeDotsLoadingView) inflate.findViewById(g.ivW);
        this.jPU.jQn = (ImageView) inflate.findViewById(g.ivX);
        this.jPU.VU.setOnClickListener(this);
        this.jPU.jQj.setText(i);
        AppBrandNearbyShowcaseView appBrandNearbyShowcaseView = this.jPU.jQl;
        if (appBrandNearbyShowcaseView != null) {
            appBrandNearbyShowcaseView.lP(4);
            appBrandNearbyShowcaseView.lN(this.jPX.jPZ + (this.jPX.jQb * 2));
            appBrandNearbyShowcaseView.lO(this.jPX.jQa);
        }
        this.jPV = a.c(context, q$d.isC);
    }

    protected final void alw() {
        x.i("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "AppBrandLauncherRecentsListHeaderBase.loading");
        this.jPT = c.jQf;
        bL(this.jPU.jQk);
        bL(this.jPU.jQn);
        bM(this.jPU.jPG);
        this.jPU.jPG.cze();
    }

    protected final void a(List<String> list, String str, Integer num) {
        x.i("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "AppBrandLauncherRecentsListHeaderBase.loadingSuccess");
        this.jPT = c.jQg;
        this.jPU.jPG.ajm();
        bL(this.jPU.jPG);
        if (list == null || list.size() == 0) {
            x.e("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "AppBrandLauncherRecentsListHeaderBase.showLoadingSuccess empty iconUrl list");
            return;
        }
        if (list == null) {
            x.e("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "prepareIconList without icon urls");
        } else {
            this.jPU.jQl.lP(Math.min(list.size(), 4));
            this.jPU.jQl.ame();
            a aVar = this.jPX;
            if (aVar.jQd == null) {
                aVar.jQd = new com.tencent.mm.plugin.appbrand.ui.widget.a(aVar.jPZ, aVar.jQb);
            }
            f fVar = aVar.jQd;
            for (int i = 0; i < this.jPU.jQl.getChildCount(); i++) {
                b.Jj().a(this.jPU.jQl.lQ(i), (String) list.get(i), com.tencent.mm.modelappbrand.a.a.Ji(), fVar);
            }
        }
        int intValue = num == null ? this.jPV : num.intValue();
        if (this.jPU.jQm != null) {
            this.jPU.jQm.setText(str);
            this.jPU.jQm.setTextColor(intValue);
        }
        if (this.jPU.jQk != null) {
            bM(this.jPU.jQk);
            if (this.jPU.jQl != null) {
                this.jPU.jQl.amf();
            }
            if (this.jPU.jQm != null) {
                this.jPU.jQm.setAlpha(0.0f);
                this.jPU.jQm.animate().alpha(1.0f).setDuration(500).start();
            }
        }
    }

    public final void onClick(View view) {
        if (this.jPS != null) {
            this.jPS.b(this.jPT, view);
        }
    }

    final void bL(View view) {
        if (view.getVisibility() == 0) {
            view.animate().setDuration(200).alpha(0.0f).withEndAction(new 1(this, view)).start();
        }
    }

    static void bM(View view) {
        if (view.getVisibility() != 0) {
            view.setAlpha(0.0f);
            view.setVisibility(0);
        }
        view.animate().setDuration(200).alpha(1.0f).withEndAction(null).start();
    }
}
