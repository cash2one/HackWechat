package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.z.az;

class k$6 implements OnClickListener {
    final /* synthetic */ int iGh;
    final /* synthetic */ int xFz;
    final /* synthetic */ k zaU;

    k$6(k kVar, int i, int i2) {
        this.zaU = kVar;
        this.iGh = i;
        this.xFz = i2;
    }

    public final void onClick(View view) {
        az.Hs().aX(this.iGh, this.xFz);
        d.y((Context) this.zaU.voC.get(), "game", ".ui.GameCenterUI");
        g.pQN.h(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, new Object[]{Integer.valueOf(9), Integer.valueOf(1)});
    }
}
