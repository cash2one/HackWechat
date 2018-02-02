package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.z.az;

class k$5 implements OnClickListener {
    final /* synthetic */ int iGh;
    final /* synthetic */ int xFz;
    final /* synthetic */ k zaU;

    k$5(k kVar, int i, int i2) {
        this.zaU = kVar;
        this.iGh = i;
        this.xFz = i2;
    }

    public final void onClick(View view) {
        az.Hs().aX(this.iGh, this.xFz);
        Context context = (Context) this.zaU.voC.get();
        Intent intent = new Intent();
        intent.putExtra("preceding_scence", 17);
        d.b(context, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
        g.pQN.h(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, new Object[]{Integer.valueOf(10), Integer.valueOf(1)});
        g.pQN.h(12065, new Object[]{Integer.valueOf(2)});
    }
}
