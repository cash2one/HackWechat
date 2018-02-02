package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import org.json.JSONObject;

class a$4 implements OnClickListener {
    final /* synthetic */ int gOK;
    final /* synthetic */ JSONObject jel;
    final /* synthetic */ d mWr;
    final /* synthetic */ a mWs;

    a$4(a aVar, d dVar, JSONObject jSONObject, int i) {
        this.mWs = aVar;
        this.mWr = dVar;
        this.jel = jSONObject;
        this.gOK = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.mWs.b(this.mWr, this.jel, this.gOK);
        dialogInterface.dismiss();
    }
}
