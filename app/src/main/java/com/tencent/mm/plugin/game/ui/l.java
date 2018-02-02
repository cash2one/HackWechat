package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class l implements OnClickListener, OnItemClickListener {
    protected int ndn = 0;

    public final void qO(int i) {
        this.ndn = i;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object item = adapterView.getAdapter().getItem(i);
        if (item != null && (item instanceof d)) {
            d dVar = (d) item;
            if (!bh.ov(dVar.field_appId)) {
                a(view.getContext(), dVar);
            }
        }
    }

    public final void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof d)) {
            a(view.getContext(), (d) view.getTag());
        }
    }

    private void a(Context context, d dVar) {
        int i = 0;
        if (dVar.type == 1) {
            i = c.ac(context, dVar.naS);
        } else if (dVar.type == 0) {
            if (dVar.aPT() && !bh.ov(dVar.nbl.nfg) && !g.a(context, dVar)) {
                i = c.ac(context, dVar.nbl.nfg);
            } else if (bh.ov(dVar.fQK) || dVar.fQN != 4) {
                Bundle bundle = new Bundle();
                bundle.putCharSequence("game_app_id", dVar.field_appId);
                if (dVar.fFj == 1601) {
                    bundle.putInt("game_report_from_scene", this.ndn);
                } else {
                    bundle.putInt("game_report_from_scene", dVar.fFj);
                }
                i = c.a(context, dVar.field_appId, dVar.naS, bundle);
            } else {
                x.i("MicroMsg.GameItemClickListener", "Download via Google Play");
                q.aY(context, dVar.fQK);
                i = 25;
            }
        }
        ap.a(context, dVar.scene, dVar.fFj, dVar.position, i, dVar.field_appId, this.ndn, dVar.fop, dVar.nbh);
    }
}
