package com.tencent.mm.pluginsdk.h;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends b {
    public k(Activity activity) {
        super(activity);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        x.i("MicroMsg.ErrorYesNoProcessor", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
    }

    public final boolean b(o oVar) {
        x.d("MicroMsg.ErrorYesNoProcessor", "handleOpenUrl");
        Toast.makeText(this.activity, oVar.content, 0).show();
        return true;
    }

    public final boolean c(o oVar) {
        x.d("MicroMsg.ErrorYesNoProcessor", "handleIgnore");
        Toast.makeText(this.activity, oVar.content, 0).show();
        return true;
    }

    public final boolean d(o oVar) {
        x.d("MicroMsg.ErrorYesNoProcessor", "handleFalseLast");
        Toast.makeText(this.activity, oVar.content, 0).show();
        return true;
    }

    public final boolean e(o oVar) {
        x.d("MicroMsg.ErrorYesNoProcessor", "handleFalseCancel");
        Toast.makeText(this.activity, oVar.content, 0).show();
        return true;
    }
}
