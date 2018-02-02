package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class ao$1 implements e {
    final /* synthetic */ String hOm;

    ao$1(String str) {
        this.hOm = str;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.PostTaskUploadHDHeadImg", "onSceneEnd errType:%d, erCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            b.deleteFile(this.hOm);
        }
        ao.ID();
        ar.CG().b(157, ao.Sr());
    }
}
