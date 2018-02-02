package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c$a;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.g;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.ui.n.a;
import com.tencent.mm.plugin.game.ui.n.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class m extends n {
    public final /* bridge */ /* synthetic */ void Ce(String str) {
        super.Ce(str);
    }

    public final /* bridge */ /* synthetic */ void Cf(String str) {
        super.Cf(str);
    }

    public final /* bridge */ /* synthetic */ void Cg(String str) {
        super.Cg(str);
    }

    public final /* bridge */ /* synthetic */ void O(LinkedList linkedList) {
        super.O(linkedList);
    }

    public final /* bridge */ /* synthetic */ void P(LinkedList linkedList) {
        super.P(linkedList);
    }

    public final /* bridge */ /* synthetic */ void a(a aVar) {
        super.a(aVar);
    }

    public final /* bridge */ /* synthetic */ void b(SparseArray sparseArray) {
        super.b(sparseArray);
    }

    public final /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public final /* bridge */ /* synthetic */ int getItemViewType(int i) {
        return super.getItemViewType(i);
    }

    public final /* bridge */ /* synthetic */ View getView(int i, View view, ViewGroup viewGroup) {
        return super.getView(i, view, viewGroup);
    }

    public final /* bridge */ /* synthetic */ int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    public final /* bridge */ /* synthetic */ void qO(int i) {
        super.qO(i);
    }

    public final /* bridge */ /* synthetic */ void qR(int i) {
        super.qR(i);
    }

    public final /* bridge */ /* synthetic */ void refresh() {
        super.refresh();
    }

    public final /* bridge */ /* synthetic */ void x(View view, int i) {
        super.x(view, i);
    }

    public m(Context context) {
        super(context);
        this.nsA = R.i.dkJ;
    }

    protected final void a(d dVar, b bVar, int i) {
        bVar.nsK.setText(dVar.position);
        bVar.nsK.setVisibility(this.nsC ? 0 : 8);
        Bitmap Cd = Cd(dVar.field_appId);
        if (Cd == null || Cd.isRecycled()) {
            bVar.nkH.setImageResource(R.g.bCC);
        } else {
            bVar.nkH.setImageBitmap(Cd);
        }
        bVar.nkI.setText(dVar.field_appName);
        if (bh.ov(dVar.naP)) {
            bVar.nsM.setVisibility(8);
        } else {
            bVar.nsM.setVisibility(0);
            bVar.nsM.setText(dVar.naP);
        }
        if (bh.ov(dVar.naQ)) {
            bVar.nsN.setVisibility(8);
        } else {
            bVar.nsN.setVisibility(0);
            bVar.nsN.setText(dVar.naQ);
        }
        if (bh.cA(dVar.nba)) {
            if (!bh.ov(dVar.nbd)) {
                bVar.nsL.setVisibility(0);
                bVar.nsL.setText(dVar.nbd);
                try {
                    bVar.nsL.setBackgroundDrawable(g.ch(Color.parseColor(dVar.nbe), com.tencent.mm.bv.a.fromDPToPix(this.mContext, 10)));
                } catch (IllegalArgumentException e) {
                    x.e("MicroMsg.GameLibraryListAdapter", e.getMessage());
                } catch (Exception e2) {
                    x.e("MicroMsg.GameLibraryListAdapter", e2.getMessage());
                }
            }
            bVar.nsL.setVisibility(8);
        } else {
            bVar.nsL.setVisibility(0);
            bVar.nsL.setText((CharSequence) dVar.nba.get(0));
        }
        bVar.nsP.rd(this.noD);
        bVar.nsO.setOnClickListener(this.npt);
        bVar.nsP.setOnClickListener(this.npt);
        bVar.nsO.setTag(dVar);
        bVar.nsP.setTag(dVar);
        this.noI.a(bVar.nsP, bVar.nsO, dVar, (o) this.nsE.get(dVar.field_appId));
        bVar.nsQ.H(dVar.naY);
        bVar.nsR.removeAllViews();
        View view = (View) this.nsF.get(i);
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeAllViews();
            }
            bVar.nsR.addView(view);
        }
    }

    protected final void a(d dVar, b bVar) {
        bVar.nsS.removeAllViews();
        if (!bh.ov(dVar.naT)) {
            View inflate = View.inflate(this.mContext, R.i.dkw, null);
            ImageView imageView = (ImageView) inflate.findViewById(R.h.cmk);
            com.tencent.mm.aq.a.a PA = com.tencent.mm.aq.o.PA();
            String str = dVar.naT;
            c$a com_tencent_mm_aq_a_a_c_a = new c$a();
            com_tencent_mm_aq_a_a_c_a.hDz = true;
            PA.a(str, imageView, com_tencent_mm_aq_a_a_c_a.PK());
            bVar.nsS.addView(inflate, new LayoutParams(-1, com.tencent.mm.bv.a.fromDPToPix(this.mContext, 100)));
        }
    }
}
