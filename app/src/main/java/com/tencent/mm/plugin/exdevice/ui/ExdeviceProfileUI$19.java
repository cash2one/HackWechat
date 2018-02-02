package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.exdevice.model.ac.a;
import com.tencent.mm.z.u;

class ExdeviceProfileUI$19 implements a {
    final /* synthetic */ ExdeviceProfileUI lVZ;

    ExdeviceProfileUI$19(ExdeviceProfileUI exdeviceProfileUI) {
        this.lVZ = exdeviceProfileUI;
    }

    public final void yU(String str) {
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_appid", "wx7fa037cc7dfabad5");
        intent.putExtra("Ksnsupload_appname", this.lVZ.getString(R.l.edR));
        intent.putExtra("Ksnsupload_source", 1);
        intent.putExtra("need_result", true);
        String hz = u.hz("wx_sport");
        u.GK().t(hz, true).o("prePublishId", "wx_sport");
        intent.putExtra("reportSessionId", hz);
        intent.putExtra("Ksnsupload_type", 0);
        intent.putExtra("sns_kemdia_path", str);
        d.b(this.lVZ, "sns", ".ui.SnsUploadUI", intent, 2);
    }
}
