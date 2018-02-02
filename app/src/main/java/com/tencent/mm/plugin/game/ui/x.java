package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.plugin.game.model.t.h;
import com.tencent.mm.sdk.platformtools.bh;

public final class x implements OnClickListener {
    private int irz = 13;
    private Context mContext;
    private int mPosition;
    private int ndn;
    private int nwg;

    public x(Context context) {
        this.mContext = context;
    }

    public final void cG(int i, int i2) {
        this.ndn = i;
        this.nwg = 1301;
        this.mPosition = i2;
    }

    public final void onClick(View view) {
        if (view.getTag() != null) {
            String str;
            if (view.getTag() instanceof t) {
                t tVar = (t) view.getTag();
                if (!bh.cA(tVar.ncj)) {
                    str = ((h) tVar.ncj.get(0)).ndi;
                    if (bh.ov(str)) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.GameURLClickListener", "message's jumpurl is null");
                        return;
                    }
                    ap.a(this.mContext, this.irz, this.nwg, this.mPosition, c.ac(this.mContext, str), 0, tVar.field_appId, this.ndn, tVar.field_msgType, tVar.field_gameMsgId, tVar.ncT, null);
                }
            } else if (view.getTag() instanceof String) {
                str = (String) view.getTag();
                if (!bh.ov(str)) {
                    ap.a(this.mContext, this.irz, this.nwg, this.mPosition, c.ac(this.mContext, str), this.ndn, null);
                }
            }
        }
    }
}
