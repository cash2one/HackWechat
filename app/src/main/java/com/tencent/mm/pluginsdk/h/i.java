package com.tencent.mm.pluginsdk.h;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends b {
    public i(Activity activity) {
        super(activity);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.ErrorMsgBoxProcessor", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
    }

    public final boolean b(o oVar) {
        x.d("MicroMsg.ErrorMsgBoxProcessor", "handleOpenUrl");
        Toast.makeText(this.activity, oVar.content, 0).show();
        return true;
    }

    public final boolean c(o oVar) {
        x.d("MicroMsg.ErrorMsgBoxProcessor", "handleIgnore");
        Toast.makeText(this.activity, oVar.content, 0).show();
        return true;
    }

    public final boolean d(o oVar) {
        x.d("MicroMsg.ErrorMsgBoxProcessor", "handleFalseLast");
        Toast.makeText(this.activity, oVar.content, 0).show();
        return true;
    }

    public final boolean e(o oVar) {
        x.d("MicroMsg.ErrorMsgBoxProcessor", "handleFalseCancel");
        Toast.makeText(this.activity, oVar.content, 0).show();
        return true;
    }
}
