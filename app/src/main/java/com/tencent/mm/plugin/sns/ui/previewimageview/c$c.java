package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.h;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

class c$c extends h<String, Integer, Boolean> {
    private ImageView fyg;
    private Bitmap hkT;
    private String path;
    final /* synthetic */ c rQo;

    public final /* synthetic */ Object buP() {
        if (c.b(this.rQo)) {
            return Boolean.valueOf(false);
        }
        this.hkT = d.d(this.path, ae.bvD(), ae.bvD(), true);
        x.d("MicroMsg.MMAsyncTask", "exifPath : %s degree : %d", this.path, Integer.valueOf(Exif.fromFile(this.path).getOrientationInDegree()));
        this.hkT = d.b(this.hkT, (float) r0);
        return Boolean.valueOf(true);
    }

    public final /* synthetic */ void onPostExecute(Object obj) {
        super.onPostExecute((Boolean) obj);
        if (!c.b(this.rQo) && i.m(this.hkT)) {
            c.a(this.rQo).put(this.path, this.hkT);
            if (this.fyg.getTag() != null && (this.fyg.getTag() instanceof String) && this.fyg.getTag().equals(this.path)) {
                this.fyg.setImageBitmap(this.hkT);
            }
        }
    }

    public c$c(c cVar, ImageView imageView, String str) {
        this.rQo = cVar;
        this.fyg = imageView;
        this.path = str;
    }

    public final af buO() {
        return ae.bvg();
    }
}
