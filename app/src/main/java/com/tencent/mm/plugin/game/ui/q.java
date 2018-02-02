package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class q extends c {
    public q(Context context, int i) {
        super(context);
        this.ndn = i;
    }

    public final void onClick(View view) {
        t tVar;
        Object tag = view.getTag();
        if (tag == null) {
            x.e("MicroMsg.GameMessageOnClickListener", "Tag is null.");
            tVar = null;
        } else if (tag instanceof Long) {
            t dv = SubCoreGameCenter.aRd().dv(((Long) tag).longValue());
            if (dv != null) {
                dv.aQm();
            }
            tVar = dv;
        } else {
            x.e("MicroMsg.GameMessageOnClickListener", "The tag of action listener is not instance of Long");
            tVar = null;
        }
        if (tVar == null) {
            x.e("MicroMsg.GameMessageContentClickListener", "The game message is null.");
            return;
        }
        switch (tVar.field_msgType) {
            case 5:
                if (!bh.ov(tVar.ncG)) {
                    ap.a(this.mContext, 13, 1301, 3, c.ac(this.mContext, tVar.ncG), 0, tVar.field_appId, this.ndn, tVar.field_msgType, tVar.field_gameMsgId, tVar.ncT, null);
                    return;
                }
                return;
            case 6:
                if (!bh.ov(tVar.ncD)) {
                    ap.a(this.mContext, 13, 1301, 3, c.ac(this.mContext, tVar.ncD), 0, tVar.field_appId, this.ndn, tVar.field_msgType, tVar.field_gameMsgId, tVar.ncT, null);
                    return;
                }
                return;
            case 10:
            case 11:
                if (bh.ov(tVar.ncb)) {
                    ap.a(this.mContext, 13, 1301, 3, a(this.mContext, tVar), 0, tVar.field_appId, this.ndn, tVar.field_msgType, tVar.field_gameMsgId, tVar.ncT, null);
                    return;
                }
                ap.a(this.mContext, 13, 1301, 3, c.ac(this.mContext, tVar.ncb), 0, tVar.field_appId, this.ndn, tVar.field_msgType, tVar.field_gameMsgId, tVar.ncT, null);
                return;
            default:
                ap.a(this.mContext, 13, 1301, 3, a(this.mContext, tVar), 0, tVar.field_appId, this.ndn, tVar.field_msgType, tVar.field_gameMsgId, tVar.ncT, null);
                return;
        }
    }
}
