package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.sdk.platformtools.x;

class n$4 implements OnClickListener {
    final /* synthetic */ n nsH;

    n$4(n nVar) {
        this.nsH = nVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof d) {
            d dVar = (d) view.getTag();
            if (this.nsH.nsE.containsKey(dVar.field_appId)) {
                o oVar = (o) this.nsH.nsE.get(dVar.field_appId);
                oVar.cP(this.nsH.mContext);
                this.nsH.noI.nlh = dVar.nbh;
                this.nsH.noI.ndn = this.nsH.ndn;
                this.nsH.noI.a(dVar, oVar);
                return;
            }
            x.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
            return;
        }
        x.e("MicroMsg.GameListAdapter", "No button tag retrived, ignore click");
    }
}
