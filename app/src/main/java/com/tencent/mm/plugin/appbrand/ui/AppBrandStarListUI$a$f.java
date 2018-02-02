package com.tencent.mm.plugin.appbrand.ui;

import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandStarListUI.a;

final class AppBrandStarListUI$a$f extends t implements OnClickListener, OnLongClickListener {
    final /* synthetic */ a jMg;
    i jMu;
    ImageView jMv;
    TextView jMw;
    TextView jMx;
    View jMy;

    AppBrandStarListUI$a$f(a aVar, View view) {
        this.jMg = aVar;
        super(view);
        this.jMv = (ImageView) view.findViewById(g.icon);
        this.jMw = (TextView) view.findViewById(g.name);
        this.jMx = (TextView) view.findViewById(g.iwB);
        this.jMy = view.findViewById(g.ivj);
        this.jMy.setOnClickListener(this);
        this.VU.setOnClickListener(this);
        this.VU.setOnLongClickListener(this);
    }

    public final void onClick(View view) {
        if (this.jMu != null) {
            if (a.e(this.jMg) && view == this.jMy) {
                c.Dm().F(new 1(this, this.jMu.fnl, this.jMu.iGA, ge()));
            }
            if (!a.e(this.jMg) && view == this.VU) {
                i iVar = this.jMu;
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1003;
                AppBrandLaunchProxyUI.a(this.jMg.getActivity(), iVar.fnl, null, iVar.iGA, -1, appBrandStatObject, null);
            }
        }
    }

    public final boolean onLongClick(View view) {
        if (a.e(this.jMg)) {
            return false;
        }
        a.g(this.jMg);
        return true;
    }
}
