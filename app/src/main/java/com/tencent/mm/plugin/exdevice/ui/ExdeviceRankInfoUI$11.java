package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.exdevice.model.ac.a;
import com.tencent.mm.z.u;

class ExdeviceRankInfoUI$11 implements a {
    final /* synthetic */ ExdeviceRankInfoUI lXj;

    ExdeviceRankInfoUI$11(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        this.lXj = exdeviceRankInfoUI;
    }

    public final void yU(String str) {
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_appid", "wx7fa037cc7dfabad5");
        intent.putExtra("Ksnsupload_appname", this.lXj.getString(R.l.edR));
        intent.putExtra("Ksnsupload_source", 1);
        intent.putExtra("need_result", true);
        String hz = u.hz("wx_sport");
        u.GK().t(hz, true).o("prePublishId", "wx_sport");
        intent.putExtra("reportSessionId", hz);
        intent.putExtra("Ksnsupload_type", 0);
        intent.putExtra("sns_kemdia_path", str);
        d.b(this.lXj, "sns", ".ui.SnsUploadUI", intent, 2);
    }
}
