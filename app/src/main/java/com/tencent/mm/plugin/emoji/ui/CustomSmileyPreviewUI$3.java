package com.tencent.mm.plugin.emoji.ui;

import android.os.Message;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

class CustomSmileyPreviewUI$3 extends c<cs> {
    final /* synthetic */ CustomSmileyPreviewUI lBm;

    CustomSmileyPreviewUI$3(CustomSmileyPreviewUI customSmileyPreviewUI) {
        this.lBm = customSmileyPreviewUI;
        this.xen = cs.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        cs csVar = (cs) bVar;
        if (!(csVar == null || bh.ov(CustomSmileyPreviewUI.c(this.lBm)) || !CustomSmileyPreviewUI.c(this.lBm).equals(csVar.fqU.fqV))) {
            CustomSmileyPreviewUI customSmileyPreviewUI = this.lBm;
            String str = csVar.fqU.fqV;
            int i = csVar.fqU.status;
            int i2 = csVar.fqU.progress;
            x.d("MicroMsg.emoji.CustomSmileyPreviewUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", str, Integer.valueOf(i), Integer.valueOf(i2), csVar.fqU.fqW);
            if (i == 6) {
                Message obtain = Message.obtain();
                obtain.getData().putString("product_id", str);
                obtain.getData().putInt("progress", i2);
                obtain.what = 131075;
                if (customSmileyPreviewUI.mHandler != null) {
                    customSmileyPreviewUI.mHandler.sendMessage(obtain);
                }
            } else {
                x.i("MicroMsg.emoji.CustomSmileyPreviewUI", "product status:%d", Integer.valueOf(i));
                Message obtain2 = Message.obtain();
                obtain2.getData().putString("product_id", str);
                obtain2.getData().putInt(DownloadInfo.STATUS, i);
                obtain2.what = 131076;
                if (customSmileyPreviewUI.mHandler != null) {
                    customSmileyPreviewUI.mHandler.sendMessage(obtain2);
                }
            }
            if (!(customSmileyPreviewUI.lAW == null || customSmileyPreviewUI.lAW.luB == null)) {
                f xU = customSmileyPreviewUI.lAW.luB.xU(str);
                if (xU != null) {
                    xU.luQ = r4;
                }
            }
        }
        return false;
    }
}
