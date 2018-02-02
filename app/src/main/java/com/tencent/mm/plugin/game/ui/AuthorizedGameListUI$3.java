package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.pluginsdk.model.app.x;
import com.tencent.mm.z.ar;

class AuthorizedGameListUI$3 implements OnCancelListener {
    final /* synthetic */ AuthorizedGameListUI nkT;
    final /* synthetic */ x nkU;

    AuthorizedGameListUI$3(AuthorizedGameListUI authorizedGameListUI, x xVar) {
        this.nkT = authorizedGameListUI;
        this.nkU = xVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.nkU);
    }
}
