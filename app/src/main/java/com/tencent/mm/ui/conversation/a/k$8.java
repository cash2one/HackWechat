package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.az;
import com.tencent.mm.z.c;

class k$8 implements OnClickListener {
    final /* synthetic */ int iGh;
    final /* synthetic */ int xFz;
    final /* synthetic */ k zaU;

    k$8(k kVar, int i, int i2) {
        this.zaU = kVar;
        this.iGh = i;
        this.xFz = i2;
    }

    public final void onClick(View view) {
        boolean z;
        az.Hs().aX(this.iGh, this.xFz);
        Context context = (Context) this.zaU.voC.get();
        ar.Hg();
        String str = (String) c.CU().get(68377, null);
        ar.Hg();
        c.CU().set(68377, "");
        Intent intent = new Intent();
        intent.putExtra("sns_timeline_NeedFirstLoadint", true);
        if (bh.ov(str)) {
            z = true;
        } else {
            z = false;
        }
        if (n.qQA != null && n.qQA.Tq() > 0) {
            z = false;
        }
        intent.putExtra("sns_resume_state", z);
        d.b(context, "sns", ".ui.SnsTimeLineUI", intent);
        g.pQN.h(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, new Object[]{Integer.valueOf(8), Integer.valueOf(1)});
    }
}
