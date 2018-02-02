package com.tencent.mm.plugin.masssend.ui;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.modelvideo.c.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;

class MassSendMsgUI$5 implements a {
    final /* synthetic */ MassSendMsgUI onR;

    MassSendMsgUI$5(MassSendMsgUI massSendMsgUI) {
        this.onR = massSendMsgUI;
    }

    public final void b(int i, String str, String str2, int i2) {
        x.d("MicroMsg.MassSendMsgUI", "onImportFinish, ret: %s, fileName: %s, importPath: %s", new Object[]{Integer.valueOf(i), str, str2});
        if (i >= 0 || i == -50002) {
            e.post(new 1(this, str, str2, i2), "MassSend_Remux");
            return;
        }
        Toast.makeText(this.onR, this.onR.getString(R.l.eSX), 0).show();
        if (MassSendMsgUI.e(this.onR) != null) {
            MassSendMsgUI.e(this.onR).dismiss();
            MassSendMsgUI.f(this.onR);
        }
    }
}
