package com.tencent.mm.aq;

import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

class p$2 extends AsyncTask<p$b, Integer, Integer> {
    final /* synthetic */ p hCN;

    p$2(p pVar) {
        this.hCN = pVar;
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((p$b[]) objArr);
    }

    private static Integer a(p$b... com_tencent_mm_aq_p_bArr) {
        if (com_tencent_mm_aq_p_bArr.length == 0 || bh.ov(com_tencent_mm_aq_p_bArr[0].path) || com_tencent_mm_aq_p_bArr[0].bitmap == null) {
            x.e("MicroMsg.UrlImageCacheService", "nothing to save");
        } else {
            try {
                d.a(com_tencent_mm_aq_p_bArr[0].bitmap, 100, CompressFormat.PNG, com_tencent_mm_aq_p_bArr[0].path, false);
            } catch (IOException e) {
                x.e("MicroMsg.UrlImageCacheService", "save bitmap to image failed: " + e.toString());
            }
        }
        return null;
    }
}
