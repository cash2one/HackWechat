package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.az;
import com.tencent.mm.z.c;

class k$2 implements OnClickListener {
    final /* synthetic */ int iGh;
    final /* synthetic */ int xFz;
    final /* synthetic */ k zaU;

    k$2(k kVar, int i, int i2) {
        this.zaU = kVar;
        this.iGh = i;
        this.xFz = i2;
    }

    public final void onClick(View view) {
        az.Hs().aX(this.iGh, this.xFz);
        Context context = (Context) this.zaU.voC.get();
        if (context != null) {
            ar.Hg();
            if (c.isSDCardAvailable()) {
                Intent intent = new Intent();
                intent.putExtra("intent_set_avatar", true);
                intent.putExtra("KEnterFromBanner", true);
                d.b(context, "setting", ".ui.setting.SettingsPersonalInfoUI", intent);
                g.pQN.h(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, new Object[]{Integer.valueOf(4), Integer.valueOf(1)});
                return;
            }
            u.fI(context);
        }
    }
}
