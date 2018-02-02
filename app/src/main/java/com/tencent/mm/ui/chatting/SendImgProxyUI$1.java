package com.tencent.mm.ui.chatting;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.ArrayList;

class SendImgProxyUI$1 implements Runnable {
    final /* synthetic */ int hHC;
    final /* synthetic */ boolean yxC;
    final /* synthetic */ SendImgProxyUI yxD;

    SendImgProxyUI$1(SendImgProxyUI sendImgProxyUI, boolean z, int i) {
        this.yxD = sendImgProxyUI;
        this.yxC = z;
        this.hHC = i;
    }

    public final void run() {
        x.i("MicroMsg.SendImgProxyUI", "test before sendMutiImage");
        SendImgProxyUI.a(this.yxD, this.yxD.getIntent());
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(-1));
        ar.Dm().cfE();
        x.i("MicroMsg.SendImgProxyUI", "test before finish");
        SendImgProxyUI.a(this.yxD).dismiss();
        this.yxD.setResult(-1, this.yxD.getIntent().putIntegerArrayListExtra("GalleryUI_ImgIdList", arrayList));
        SendImgProxyUI.akQ();
        this.yxD.finish();
        if (an.isWifi(this.yxD) == this.yxC) {
            HardCoderJNI.stopPerformace(HardCoderJNI.hcSendPicMsgEnable, this.hHC);
        }
    }
}
