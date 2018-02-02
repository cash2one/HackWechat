package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.luckymoney.b.j.a;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a {
    final /* synthetic */ b oby;

    b$1(b bVar) {
        this.oby = bVar;
    }

    public final void a(keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, String str, boolean z) {
        if (z) {
            x.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "the download image data is success! filePath:" + str);
        } else {
            x.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "download image fail!  filePath:" + str);
        }
    }
}
