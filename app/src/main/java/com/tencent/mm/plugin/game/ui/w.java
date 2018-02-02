package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.bj;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class w implements OnClickListener {
    private Context mContext;
    int ndn = 0;
    private d ndv;
    String nlh = null;
    private int nwf;

    public w(Context context) {
        this.mContext = context;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof d) {
            this.ndv = (d) view.getTag();
            x.i("MicroMsg.GameTMAssistClickListener", "Clicked appid = " + this.ndv.field_appId);
            if (g.m(this.mContext, this.ndv.field_appId)) {
                x.d("MicroMsg.GameTMAssistClickListener", "launchFromWX, appId = " + this.ndv.field_appId + ", pkg = " + this.ndv.field_packageName + ", openId = " + this.ndv.field_openId);
                ap.a(this.mContext, this.ndv.scene, this.ndv.fFj, this.ndv.position, 3, this.ndv.field_appId, this.ndn, this.nlh);
                com.tencent.mm.plugin.game.model.g.Y(this.mContext, this.ndv.field_appId);
                return;
            }
            bj.aQY();
            this.nwf = bj.Ca(this.ndv.fQP);
            x.i("MicroMsg.GameTMAssistClickListener", "get download status:[%s]", new Object[]{Integer.valueOf(this.nwf)});
            switch (this.nwf) {
                case 1:
                    aRN();
                    return;
                case 2:
                    aRN();
                    return;
                case 3:
                    aRN();
                    return;
                case 4:
                    aRN();
                    return;
                case 5:
                    aRN();
                    return;
                default:
                    aRN();
                    return;
            }
        }
        x.e("MicroMsg.GameTMAssistClickListener", "No GameAppInfo");
    }

    private void aRN() {
        int i;
        String str = this.ndv.fQP;
        if (!bh.ov(str)) {
            str = str.replace("ANDROIDWX.GAMECENTER", "ANDROIDWX.YYB.GAMECENTER");
        }
        if (this.ndv.status == 3) {
            bj.aQY();
            bj.startToAuthorized(this.mContext, str);
        } else {
            bj.aQY();
            bj.ab(this.mContext, str);
        }
        int i2 = 5;
        if (this.ndv.status == 3) {
            i2 = 10;
        }
        if (this.nwf == 4) {
            i = 8;
        } else {
            i = i2;
        }
        ap.a(this.mContext, this.ndv.scene, this.ndv.fFj, this.ndv.position, i, this.ndv.field_appId, this.ndn, this.ndv.fop, this.nlh);
    }
}
