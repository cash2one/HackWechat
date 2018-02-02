package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public abstract class c implements OnClickListener {
    protected Context mContext;
    protected int meP = 1301;
    protected int ndn;

    public c(Context context) {
        this.mContext = context;
        if (context == null) {
            throw new IllegalArgumentException("context is null.");
        }
    }

    protected static int a(Context context, t tVar) {
        if (tVar == null) {
            x.e("MicroMsg.GameMessageOnClickListener", "game message is null.");
            return 0;
        } else if (bh.ov(tVar.field_appId)) {
            x.e("MicroMsg.GameMessageOnClickListener", "message type : " + tVar.field_msgType + " ,message.field_appId is null.");
            return 0;
        } else {
            Bundle bundle = new Bundle();
            bundle.putCharSequence("game_app_id", tVar.field_appId);
            bundle.putInt("game_report_from_scene", 1301);
            return com.tencent.mm.plugin.game.d.c.a(context, tVar.field_appId, null, bundle);
        }
    }
}
