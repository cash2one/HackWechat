package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

final class b {
    View VU;
    ThreeDotsLoadingView jPG = ((ThreeDotsLoadingView) this.VU.findViewById(g.ctD));
    View jPH = this.VU.findViewById(g.ivN);
    View jPI = this.VU.findViewById(g.ivM);

    final void setLoading(boolean z) {
        if (z) {
            if (this.jPG != null) {
                this.jPG.setVisibility(0);
                this.jPG.cze();
            }
            if (this.jPI != null) {
                this.jPI.setVisibility(8);
                return;
            }
            return;
        }
        if (this.jPG != null) {
            this.jPG.ajm();
            this.jPG.setVisibility(8);
        }
        if (this.jPI != null) {
            this.jPI.setVisibility(0);
        }
    }

    b(Context context, ViewGroup viewGroup) {
        this.VU = LayoutInflater.from(context).inflate(h.ixh, viewGroup, false);
    }
}
