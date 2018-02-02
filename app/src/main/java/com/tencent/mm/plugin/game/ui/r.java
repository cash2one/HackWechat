package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class r implements OnClickListener {
    int kFm;
    protected Context mContext;
    private d nbT;
    String ntU = null;

    public r(Context context) {
        this.mContext = context;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof d) {
            this.nbT = (d) view.getTag();
            x.i("MicroMsg.GamePreemptiveCliclListener", "Clicked appid = " + this.nbT.field_appId);
            if (g.m(this.mContext, this.nbT.field_appId)) {
                x.d("MicroMsg.GamePreemptiveCliclListener", "launchFromWX, appId = " + this.nbT.field_appId + ", pkg = " + this.nbT.field_packageName + ", openId = " + this.nbT.field_openId);
                com.tencent.mm.plugin.game.model.g.Y(this.mContext, this.nbT.field_appId);
                ap.a(this.mContext, this.nbT.scene, this.nbT.fFj, this.nbT.position, 3, this.nbT.field_appId, this.kFm, this.nbT.fop, this.nbT.nbh);
                return;
            }
            x.i("MicroMsg.GamePreemptiveCliclListener", "get preemptive url:[%s]", new Object[]{this.ntU});
            if (bh.ov(this.ntU)) {
                x.e("MicroMsg.GamePreemptiveCliclListener", "null or nill preemptive url");
                return;
            }
            c.ac(this.mContext, this.ntU);
            ap.a(this.mContext, this.nbT.scene, this.nbT.fFj, this.nbT.position, 11, this.nbT.field_appId, this.kFm, this.nbT.fop, this.nbT.nbh);
            return;
        }
        x.e("MicroMsg.GamePreemptiveCliclListener", "No GameAppInfo");
    }
}
