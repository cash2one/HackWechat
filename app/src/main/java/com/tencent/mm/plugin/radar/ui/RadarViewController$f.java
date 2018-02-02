package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import b.i;
import com.tencent.mm.plugin.radar.b.e$e;
import com.tencent.mm.plugin.radar.ui.RadarViewController.c;
import java.util.LinkedList;

final class RadarViewController$f implements OnClickListener {
    final /* synthetic */ RadarViewController pzY;

    RadarViewController$f(RadarViewController radarViewController) {
        this.pzY = radarViewController;
    }

    public final void onClick(View view) {
        if (this.pzY.pzO == e$e.pxz || this.pzY.pzO == e$e.pxA) {
            Context context = this.pzY.getContext();
            if (context == null) {
                throw new i("null cannot be cast to non-null type android.app.Activity");
            }
            ((Activity) context).finish();
            return;
        }
        RadarViewController radarViewController = this.pzY;
        c d = RadarViewController.d(this.pzY);
        LinkedList linkedList = new LinkedList();
        int length = ((Object[]) d.pAa).length;
        for (int i = 0; i < length; i++) {
            Object obj = d.pAa[i];
            if (obj != null) {
                linkedList.add(obj);
            }
        }
        if (RadarViewController.a(radarViewController, linkedList)) {
            RadarViewController.f(this.pzY).bmk();
            RadarViewController.f(this.pzY).setVisibility(0);
            RadarViewController.c(this.pzY).blt();
            RadarViewController.a(this.pzY, e$e.pxA);
        } else {
            RadarViewController.a(this.pzY, e$e.pxz);
        }
        RadarViewController.d(this.pzY).blx();
    }
}
