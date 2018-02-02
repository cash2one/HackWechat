package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.sdk.platformtools.x;

class MyGameInfoView$3 implements OnClickListener {
    final /* synthetic */ MyGameInfoView nwj;

    MyGameInfoView$3(MyGameInfoView myGameInfoView) {
        this.nwj = myGameInfoView;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof d) {
            d dVar = (d) view.getTag();
            if (MyGameInfoView.c(this.nwj).containsKey(dVar.field_appId)) {
                o oVar = (o) MyGameInfoView.c(this.nwj).get(dVar.field_appId);
                oVar.cP(MyGameInfoView.a(this.nwj));
                MyGameInfoView.d(this.nwj).a(dVar, oVar);
                return;
            }
            x.e("MicroMsg.MyGameInfoView", "No DownloadInfo found");
            return;
        }
        x.e("MicroMsg.MyGameInfoView", "No button tag retrived, ignore click");
    }
}
