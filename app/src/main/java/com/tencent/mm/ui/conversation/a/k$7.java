package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.z.az;
import com.tencent.mm.z.q;

class k$7 implements OnClickListener {
    final /* synthetic */ int iGh;
    final /* synthetic */ int xFz;
    final /* synthetic */ k zaU;

    k$7(k kVar, int i, int i2) {
        this.zaU = kVar;
        this.iGh = i;
        this.xFz = i2;
    }

    public final void onClick(View view) {
        int i;
        az.Hs().aX(this.iGh, this.xFz);
        Context context = (Context) this.zaU.voC.get();
        if ((q.Gd() & 65536) == 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            d.y(context, "masssend", ".ui.MassSendHistoryUI");
        } else {
            d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
        }
        g.pQN.h(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, new Object[]{Integer.valueOf(11), Integer.valueOf(1)});
    }
}
