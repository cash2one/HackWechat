package com.tencent.mm.ui.widget;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.t;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.cb.a.b;
import com.tencent.mm.cb.a.d;
import com.tencent.mm.cb.a.f;
import com.tencent.mm.cb.a.g;
import com.tencent.mm.cb.a.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.o;

public class g$b extends a<a> {
    OnItemClickListener SY;
    final /* synthetic */ g ztC;

    public g$b(g gVar) {
        this.ztC = gVar;
    }

    public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
        View inflate = g.n(this.ztC) == g.zto ? LayoutInflater.from(g.o(this.ztC)).inflate(f.zzu, viewGroup, false) : g.n(this.ztC) == g.ztq ? LayoutInflater.from(g.o(this.ztC)).inflate(f.zzv, viewGroup, false) : LayoutInflater.from(g.o(this.ztC)).inflate(f.zzw, viewGroup, false);
        return new a(this, inflate);
    }

    public final /* synthetic */ void a(t tVar, int i) {
        a aVar = (a) tVar;
        o oVar;
        if (i < g.a(this.ztC).size()) {
            if (g.p(this.ztC) >= g.a(this.ztC).size()) {
                g.a(this.ztC, 0);
            }
            oVar = (o) g.a(this.ztC).ycc.get(i);
            aVar.jpW.setText(oVar.getTitle());
            if (oVar.getIcon() != null) {
                aVar.jMv.setVisibility(0);
                aVar.jMv.setImageDrawable(oVar.getIcon());
            } else if (g.q(this.ztC) != null) {
                aVar.jMv.setVisibility(0);
                g.q(this.ztC).a(aVar.jMv, oVar);
            } else if (g.r(this.ztC)) {
                aVar.jMv.setVisibility(4);
            } else {
                aVar.jMv.setVisibility(8);
            }
            if (g.s(this.ztC) != null) {
                g.s(this.ztC).a(aVar.jpW, oVar);
            }
            if (oVar.wPS) {
                if (g.t(this.ztC).booleanValue()) {
                    aVar.jpW.setTextColor(g.o(this.ztC).getResources().getColor(b.buk));
                } else {
                    aVar.jpW.setTextColor(g.o(this.ztC).getResources().getColor(b.zyL));
                }
                aVar.ztF.setBackgroundResource(b.transparent);
            } else if (g.t(this.ztC).booleanValue()) {
                aVar.jpW.setTextColor(g.o(this.ztC).getResources().getColor(b.buj));
                aVar.ztF.setBackgroundResource(d.zze);
            } else {
                aVar.jpW.setTextColor(g.o(this.ztC).getResources().getColor(b.isB));
                aVar.ztF.setBackgroundResource(d.zzd);
            }
            if (aVar.riU != null) {
                if (bh.M(oVar.qef)) {
                    aVar.riU.setVisibility(8);
                } else {
                    aVar.riU.setVisibility(0);
                    aVar.riU.setText(oVar.qef);
                    aVar.riU.setMovementMethod(LinkMovementMethod.getInstance());
                }
            }
            if (g.u(this.ztC)) {
                if (oVar.wPS) {
                    aVar.ztD.setVisibility(8);
                    aVar.riU.setTextColor(g.o(this.ztC).getResources().getColor(b.zyL));
                } else {
                    aVar.riU.setTextColor(g.o(this.ztC).getResources().getColor(b.zyM));
                    aVar.ztD.setVisibility(0);
                    if (g.p(this.ztC) == i) {
                        aVar.ztD.setChecked(true);
                    } else {
                        aVar.ztD.setChecked(false);
                    }
                }
                aVar.ztE.setVisibility(0);
            }
        } else if (g.c(this.ztC).size() > 0 && i < g.a(this.ztC).size() + g.c(this.ztC).size()) {
            oVar = (o) g.c(this.ztC).ycc.get(i - g.a(this.ztC).size());
            aVar.jpW.setText(oVar.getTitle());
            if (g.p(this.ztC) >= g.a(this.ztC).size() + g.c(this.ztC).size()) {
                g.a(this.ztC, 0);
            }
            if (oVar.getIcon() != null) {
                aVar.jMv.setVisibility(0);
                aVar.jMv.setImageDrawable(oVar.getIcon());
            } else {
                aVar.jMv.setVisibility(8);
            }
            if (oVar.wPS) {
                if (g.t(this.ztC).booleanValue()) {
                    aVar.jpW.setTextColor(g.o(this.ztC).getResources().getColor(b.buk));
                } else {
                    aVar.jpW.setTextColor(g.o(this.ztC).getResources().getColor(b.zyL));
                }
                aVar.ztF.setBackgroundResource(b.transparent);
            } else if (g.t(this.ztC).booleanValue()) {
                aVar.jpW.setTextColor(g.o(this.ztC).getResources().getColor(b.buj));
                aVar.ztF.setBackgroundResource(d.zze);
            } else {
                aVar.jpW.setTextColor(g.o(this.ztC).getResources().getColor(b.isB));
                aVar.ztF.setBackgroundResource(d.zzd);
            }
            if (aVar.riU != null) {
                if (bh.M(oVar.qef)) {
                    aVar.riU.setVisibility(8);
                } else {
                    aVar.riU.setVisibility(0);
                    aVar.riU.setText(oVar.qef);
                }
            }
            if (g.u(this.ztC)) {
                if (oVar.wPS) {
                    aVar.ztD.setVisibility(8);
                    aVar.riU.setTextColor(g.o(this.ztC).getResources().getColor(b.zyL));
                } else {
                    aVar.riU.setTextColor(g.o(this.ztC).getResources().getColor(b.zyM));
                    aVar.ztD.setVisibility(0);
                    if (g.p(this.ztC) == i) {
                        aVar.ztD.setChecked(true);
                    } else {
                        aVar.ztD.setChecked(false);
                    }
                }
                aVar.ztE.setVisibility(0);
            }
        } else if (g.v(this.ztC)) {
            aVar.jpW.setText(h.dNb);
            aVar.jMv.setImageResource(g.zzB);
        }
    }

    public final int getItemCount() {
        if (g.v(this.ztC)) {
            return (g.a(this.ztC).size() + g.c(this.ztC).size()) + 1;
        }
        return g.a(this.ztC).size() + g.c(this.ztC).size();
    }
}
