package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.t.d;
import com.tencent.mm.plugin.game.ui.GameMessageUI;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class u implements OnClickListener {
    private Context mContext;
    public int ndn;

    public u(Context context) {
        this.mContext = context;
    }

    public u(Context context, int i) {
        this.mContext = context;
        this.ndn = i;
    }

    public final void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof a)) {
            x.e("MicroMsg.GameMessageClickListener", "v.getTag is null");
            return;
        }
        a aVar = (a) view.getTag();
        if (aVar.nbq == null) {
            x.e("MicroMsg.GameMessageClickListener", "message is null");
        } else if (aVar.ndk == null) {
            x.e("MicroMsg.GameMessageClickListener", "jumpId is null");
        } else {
            d dVar = (d) aVar.nbq.nco.get(aVar.ndk);
            if (dVar == null) {
                x.e("MicroMsg.GameMessageClickListener", "jumpInfo is null");
                return;
            }
            int a = a(this.mContext, aVar.nbq, dVar, aVar.nbq.field_appId, aVar.fFj);
            if (a != 0) {
                ap.a(this.mContext, 13, aVar.fFj, aVar.position, a, 0, aVar.nbq.field_appId, this.ndn, aVar.nbq.ncS, aVar.nbq.field_gameMsgId, aVar.nbq.ncT, null);
            }
        }
    }

    public static int a(Context context, t tVar, d dVar, String str, int i) {
        int i2 = 0;
        switch (dVar.ndb) {
            case 1:
                if (!g.m(context, str)) {
                    return f(context, str, i);
                }
                g.Y(context, str);
                return 3;
            case 2:
                if (!g.m(context, str)) {
                    return 0;
                }
                g.Y(context, str);
                return 3;
            case 3:
                return f(context, str, i);
            case 4:
                if (tVar != null) {
                    tVar.field_isRead = true;
                    SubCoreGameCenter.aRd().c(tVar, new String[0]);
                }
                Intent intent = new Intent(context, GameMessageUI.class);
                intent.putExtra("game_report_from_scene", i);
                context.startActivity(intent);
                return 6;
            case 5:
                String str2 = dVar.lUj;
                if (!bh.ov(str2)) {
                    i2 = c.ac(context, str2);
                }
                return i2;
            default:
                x.i("MicroMsg.GameMessageClickListener", "unknown msg jump type = " + dVar.ndb);
                return 0;
        }
    }

    private static int f(Context context, String str, int i) {
        if (bh.ov(str)) {
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putCharSequence("game_app_id", str);
        bundle.putInt("game_report_from_scene", i);
        return c.a(context, str, null, bundle);
    }
}
