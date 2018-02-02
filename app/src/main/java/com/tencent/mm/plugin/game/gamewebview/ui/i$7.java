package com.tencent.mm.plugin.game.gamewebview.ui;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.ipc.AddShortcutTask;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import org.json.JSONObject;

class i$7 implements Runnable {
    final /* synthetic */ i nai;
    final /* synthetic */ AddShortcutTask nam;

    i$7(i iVar, AddShortcutTask addShortcutTask) {
        this.nai = iVar;
        this.nam = addShortcutTask;
    }

    public final void run() {
        this.nam.afj();
        d dVar = this.nai.mZP.mWG;
        boolean z = this.nam.success;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", z);
            dVar.cH("onAddShortcutStatus", jSONObject.toString());
        } catch (Exception e) {
            x.e("MicroMsg.GameWebviewJsLoader", "onGetAddShortcutStatus, e:" + e.getMessage());
        }
        if (this.nam.success) {
            h.a(this.nai.mYx, R.l.eXS, R.l.dGO, false, new 1(this));
        } else {
            Toast.makeText(this.nai.mYx, this.nai.mYx.getString(R.l.eXR), 0).show();
        }
    }
}
