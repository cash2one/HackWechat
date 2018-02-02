package com.tencent.mm.aq;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class p$1 extends AsyncTask<String, Integer, Bitmap> {
    final /* synthetic */ p hCN;

    p$1(p pVar) {
        this.hCN = pVar;
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        String[] strArr = (String[]) objArr;
        if (strArr.length <= 0) {
            return null;
        }
        String lu = p.lu(strArr[0]);
        return new File(lu).exists() ? d.UN(lu) : null;
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        if (bitmap != null) {
            x.d("MicroMsg.UrlImageCacheService", "load from sdcard");
            if (!this.hCN.hCM) {
                o.Pv();
                c.g(this.hCN.hCL.url, bitmap);
                this.hCN.hCL.hCO.h(this.hCN.hCL.url, bitmap);
            }
            this.hCN.hCL = null;
            this.hCN.PD();
            return;
        }
        x.i("MicroMsg.UrlImageCacheService", "try load from " + this.hCN.hCL.url);
        o.Pv().a(this.hCN.hCL.url, this.hCN);
    }
}
