package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.g;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.ui.n.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class h extends n {
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

    public h(Context context) {
        super(context);
        this.nsA = R.i.djO;
    }

    protected final void a(d dVar, n$b com_tencent_mm_plugin_game_ui_n_b, int i) {
        com_tencent_mm_plugin_game_ui_n_b.nsK.setText(dVar.position);
        Bitmap Cd = Cd(dVar.field_appId);
        if (Cd == null || Cd.isRecycled()) {
            com_tencent_mm_plugin_game_ui_n_b.nkH.setImageResource(R.g.bCC);
        } else {
            com_tencent_mm_plugin_game_ui_n_b.nkH.setImageBitmap(Cd);
        }
        com_tencent_mm_plugin_game_ui_n_b.nkI.setText(dVar.field_appName);
        if (bh.ov(dVar.naQ)) {
            com_tencent_mm_plugin_game_ui_n_b.nsN.setVisibility(8);
        } else {
            com_tencent_mm_plugin_game_ui_n_b.nsN.setVisibility(0);
            com_tencent_mm_plugin_game_ui_n_b.nsN.setText(dVar.naQ);
        }
        if (bh.cA(dVar.nba)) {
            if (!bh.ov(dVar.nbd)) {
                com_tencent_mm_plugin_game_ui_n_b.nsL.setVisibility(0);
                com_tencent_mm_plugin_game_ui_n_b.nsL.setText(dVar.nbd);
                try {
                    com_tencent_mm_plugin_game_ui_n_b.nsL.setBackgroundDrawable(g.ch(Color.parseColor(dVar.nbe), com.tencent.mm.bv.a.fromDPToPix(this.mContext, 10)));
                } catch (IllegalArgumentException e) {
                    x.e("MicroMsg.GameCenterListAdapter", e.getMessage());
                } catch (Exception e2) {
                    x.e("MicroMsg.GameCenterListAdapter", e2.getMessage());
                }
            }
            com_tencent_mm_plugin_game_ui_n_b.nsL.setVisibility(8);
        } else {
            com_tencent_mm_plugin_game_ui_n_b.nsL.setVisibility(0);
            com_tencent_mm_plugin_game_ui_n_b.nsL.setText((CharSequence) dVar.nba.get(0));
        }
        com_tencent_mm_plugin_game_ui_n_b.nsP.rd(this.noD);
        com_tencent_mm_plugin_game_ui_n_b.nsO.setOnClickListener(this.npt);
        com_tencent_mm_plugin_game_ui_n_b.nsP.setOnClickListener(this.npt);
        com_tencent_mm_plugin_game_ui_n_b.nsO.setTag(dVar);
        com_tencent_mm_plugin_game_ui_n_b.nsP.setTag(dVar);
        this.noI.a(com_tencent_mm_plugin_game_ui_n_b.nsP, com_tencent_mm_plugin_game_ui_n_b.nsO, dVar, (o) this.nsE.get(dVar.field_appId));
        com_tencent_mm_plugin_game_ui_n_b.nsQ.H(dVar.naY);
    }

    protected final void a(d dVar, n$b com_tencent_mm_plugin_game_ui_n_b) {
    }
}
