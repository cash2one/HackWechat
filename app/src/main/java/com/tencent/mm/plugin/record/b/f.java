package com.tencent.mm.plugin.record.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.pluginsdk.ui.tools.g;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;

public class f {
    private HashMap<String, String[]> mru = new HashMap();
    public com.tencent.mm.a.f<String, Bitmap> mrw = new com.tencent.mm.a.f(10);
    public g pFq = new 1(this);
    private HashSet<String> pFr = new HashSet();
    private HashMap<String, a> pFs = new HashMap();

    public final void destory() {
        this.pFq.destory();
        this.mru.clear();
        this.pFr.clear();
        this.pFq = null;
        this.mru = null;
        this.pFr = null;
    }

    public final boolean a(uq uqVar, long j) {
        String d = h.d(uqVar.mvG, j, true);
        a aVar = (a) this.pFs.get(d);
        if (aVar == null) {
            this.pFs.put(d, new a());
            return true;
        } else if (aVar.zi() <= 30000) {
            return false;
        } else {
            aVar.gHJ = SystemClock.elapsedRealtime();
            return true;
        }
    }

    public final Bitmap a(uq uqVar, long j, boolean z, boolean z2) {
        if (!com.tencent.mm.compatible.util.f.ze()) {
            return BitmapFactory.decodeResource(ac.getContext().getResources(), R.g.bEi);
        }
        String f;
        if (z) {
            f = h.f(uqVar, j);
        } else {
            f = h.c(uqVar, j);
        }
        if (bh.ov(f) || !e.bO(f)) {
            x.d("MicroMsg.RecordMsgImgService", "getBitmap file not exist, thumb[%B] path[%s]", new Object[]{Boolean.valueOf(z), f});
            return null;
        }
        Bitmap bitmap = (Bitmap) this.mrw.get(f);
        if (bitmap != null) {
            return bitmap;
        }
        int i;
        int i2;
        x.d("MicroMsg.RecordMsgImgService", "get from cache fail, try to decode from file, path %s", new Object[]{f});
        Options options = new Options();
        options.inJustDecodeBounds = true;
        bitmap = BitmapFactory.decodeFile(f, options);
        if (bitmap != null) {
            x.i("MicroMsg.RecordMsgImgService", "bitmap recycled %s", new Object[]{bitmap});
            bitmap.recycle();
        }
        Object obj = (!d.bt(options.outWidth, options.outHeight) || options.outWidth <= 480) ? null : 1;
        Object obj2 = (!d.bs(options.outWidth, options.outHeight) || options.outHeight <= 480) ? null : 1;
        if (obj == null && obj2 == null) {
            i = 960;
            i2 = 960;
        } else {
            i = options.outHeight;
            i2 = options.outWidth;
        }
        int UJ = ExifHelper.UJ(f);
        if (UJ == 90 || UJ == 270) {
            int i3 = i2;
            i2 = i;
            i = i3;
        }
        bitmap = d.d(f, i, i2, false);
        if (bitmap == null) {
            x.e("MicroMsg.RecordMsgImgService", "extractThumbNail fail, temBmp is null, filePath = " + f);
            return null;
        }
        bitmap = d.b(bitmap, (float) UJ);
        this.mrw.put(f, bitmap);
        return bitmap;
    }

    public final Bitmap b(uq uqVar, long j) {
        Bitmap a = a(uqVar, j, true, false);
        if (a == null) {
            x.d("MicroMsg.RecordMsgImgService", "get thumb fail, try download, can retry:%B", new Object[]{Boolean.valueOf(a(uqVar, j))});
            h.b(uqVar, j, r1);
        }
        return a;
    }

    public final void a(ImageView imageView, uq uqVar, long j, String str, int i, int i2, int i3) {
        String str2 = h.Ac(uqVar.mvG) + "@" + String.valueOf(j);
        if (uqVar.mvG != null) {
            String[] strArr;
            String[] strArr2 = (String[]) this.mru.get(str2);
            if (strArr2 == null || strArr2.length <= 0) {
                strArr = new String[]{h.f(uqVar, j)};
                this.mru.put(str2, strArr);
            } else {
                strArr = strArr2;
            }
            this.pFq.a(imageView, strArr, str, i, i2, i3);
            if (!this.pFr.contains(str2)) {
                this.pFr.add(str2);
                if (!new File(strArr[0]).exists() && !bh.ov(uqVar.hbj)) {
                    h.b(uqVar, j, a(uqVar, j));
                }
            }
        }
    }
}
