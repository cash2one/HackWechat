package com.tencent.mm.pluginsdk.h;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends b {
    public j(Activity activity) {
        super(activity);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.ErrorTextStripleProcessor", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
    }

    public final boolean b(o oVar) {
        x.d("MicroMsg.ErrorTextStripleProcessor", "handleOpenUrl");
        Toast.makeText(this.activity, oVar.content, 0).show();
        return true;
    }

    public final boolean c(o oVar) {
        x.d("MicroMsg.ErrorTextStripleProcessor", "handleIgnore");
        Toast.makeText(this.activity, oVar.content, 0).show();
        return true;
    }

    public final boolean d(o oVar) {
        x.d("MicroMsg.ErrorTextStripleProcessor", "handleFalseLast");
        Toast.makeText(this.activity, oVar.content, 0).show();
        return true;
    }

    public final boolean e(o oVar) {
        x.d("MicroMsg.ErrorTextStripleProcessor", "handleFalseCancel");
        Toast.makeText(this.activity, oVar.content, 0).show();
        return true;
    }
}
