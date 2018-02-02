package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.widget.RecyclerView.t;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.appusage.h;
import com.tencent.mm.plugin.appbrand.appusage.s;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.widget.i;

final class a$d extends t implements OnClickListener, OnCreateContextMenuListener, d {
    View iiS;
    ImageView jMv;
    View jPA;
    i jPB;
    final int jPC = 1;
    final int jPD = 2;
    final /* synthetic */ a jPj;
    TextView jPw;
    TextView jPx;
    TextView jPy;
    TextView jPz;

    a$d(a aVar, View view) {
        this.jPj = aVar;
        super(view);
        this.iiS = view.findViewById(g.divider);
        this.jPw = (TextView) view.findViewById(g.iwf);
        this.jPx = (TextView) view.findViewById(g.iws);
        this.jPy = (TextView) view.findViewById(g.iwB);
        this.jPz = (TextView) view.findViewById(g.ivE);
        this.jMv = (ImageView) view.findViewById(g.icon);
        this.jPA = view.findViewById(g.iwx);
        view.setOnClickListener(this);
        this.jPB = new 1(this, this.VU.getContext());
        this.jPB.c(this.VU, this, this);
    }

    private int als() {
        return a.g(this.jPj).G(this);
    }

    final com.tencent.mm.plugin.appbrand.appusage.i alt() {
        try {
            return (com.tencent.mm.plugin.appbrand.appusage.i) a.b(this.jPj).lF(als());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrandLauncherRecentsList", e, "getAppInfo", new Object[0]);
            return null;
        }
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        com.tencent.mm.plugin.appbrand.appusage.i alt = alt();
        if (alt != null) {
            if (a.l(this.jPj)) {
                contextMenu.add(0, 1, 0, this.VU.getContext().getString(alt.iJL ? j.iAb : j.iAa));
            }
            contextMenu.add(0, 2, 0, this.VU.getContext().getString(j.izZ));
        }
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        com.tencent.mm.plugin.appbrand.appusage.i alt = alt();
        if (alt != null && menuItem != null) {
            if (1 == menuItem.getItemId()) {
                if (a.a(this.jPj).alA().size() < a.s(this.jPj) || alt.iJL) {
                    a.u(this.jPj).F(new 2(this, alt));
                    a.f(this.jPj).jQS = true;
                } else if (this.jPj.getActivity() != null) {
                    Toast.makeText(this.jPj.getActivity(), this.jPj.getActivity().getString(j.iBs, new Object[]{Integer.valueOf(a.s(this.jPj))}), 1).show();
                }
            } else if (2 == menuItem.getItemId()) {
                if (alt.iJL) {
                    a.u(this.jPj).F(new 3(this, alt));
                } else if (als() < a.a(this.jPj).size()) {
                    a.a(alt.appId, alt.iGA + 1, 3, 1, a.t(this.jPj));
                }
                a.a(this.jPj).lE(als());
                a.f(this.jPj).jQS = true;
                a.e(this.jPj).alr();
                a.b(this.jPj).bl(als());
                a.c(this.jPj);
                s.i(alt.fnl, alt.appId, alt.iGA);
            }
        }
    }

    public final void onClick(View view) {
        com.tencent.mm.plugin.appbrand.appusage.i alt = alt();
        if (alt != null) {
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1001;
            switch (this.jPj.irz) {
                case 10:
                    appBrandStatObject.fIs = 11;
                    break;
                case 11:
                    appBrandStatObject.fIs = 12;
                    break;
                case 13:
                    appBrandStatObject.fIs = 13;
                    break;
            }
            AppBrandLaunchProxyUI.a(this.jPj.getActivity(), alt.fnl, null, alt.iGA, -1, appBrandStatObject, null);
            if (this.jPj.getActivity() != null) {
                h.d dVar = ((AppBrandLauncherUI) this.jPj.getActivity()).jKQ;
                if (dVar != null) {
                    dVar.iJH[7] = "1";
                }
            }
        }
    }
}
