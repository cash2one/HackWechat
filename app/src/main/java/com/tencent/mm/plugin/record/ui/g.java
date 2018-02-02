package com.tencent.mm.plugin.record.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.record.b.f;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.plugin.record.ui.h.a;
import com.tencent.mm.plugin.record.ui.h.a.b;
import com.tencent.mm.plugin.record.ui.h.a.c;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.vd;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends f implements a {
    public final void a(a.a aVar) {
        String str = null;
        ImageView imageView = aVar.fvf;
        uq uqVar = aVar.fve;
        long j = aVar.pGd;
        int i = aVar.fvg;
        int i2 = aVar.width;
        int i3 = aVar.height;
        if (imageView != null) {
            if (!com.tencent.mm.compatible.util.f.ze()) {
                imageView.setImageResource(R.g.bEi);
            } else if (uqVar == null) {
                imageView.setImageResource(i);
            } else {
                vd vdVar;
                switch (uqVar.bjS) {
                    case 4:
                    case 15:
                        super.a(imageView, uqVar, j, uqVar.fqf, i, i2, i3);
                        return;
                    case 5:
                        vt vtVar;
                        if (uqVar.wdD != null) {
                            vtVar = uqVar.wdD.web;
                        } else {
                            x.w("MicroMsg.RecordMsgImgService", "webpage: get data proto item null, dataid[%s]", uqVar.mvG);
                            vtVar = null;
                        }
                        if (vtVar != null) {
                            str = vtVar.thumbUrl;
                        }
                        super.a(imageView, uqVar, j, bh.ov(str) ? uqVar.fqf : str, i, i2, i3);
                        return;
                    case 7:
                        super.a(imageView, uqVar, j, uqVar.fqf, i, i2, i3);
                        return;
                    case 10:
                        if (uqVar.wdD == null) {
                            x.w("MicroMsg.RecordMsgImgService", "good: get data proto item null, dataid[%s]", uqVar.mvG);
                            return;
                        }
                        vdVar = uqVar.wdD.wed;
                        if (vdVar != null) {
                            this.pFq.a(imageView, null, vdVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    case 11:
                        if (uqVar.wdD == null) {
                            x.w("MicroMsg.RecordMsgImgService", "product: get data proto item null, dataid[%s]", uqVar.mvG);
                            return;
                        }
                        vdVar = uqVar.wdD.wed;
                        if (vdVar != null) {
                            this.pFq.a(imageView, null, vdVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    case 14:
                        if (uqVar.wdD == null) {
                            x.w("MicroMsg.RecordMsgImgService", "tv: get data proto item null, dataid[%s]", uqVar.mvG);
                            return;
                        }
                        vn vnVar = uqVar.wdD.wef;
                        if (vnVar != null) {
                            this.pFq.a(imageView, null, vnVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    default:
                        x.w("MicroMsg.RecordMsgImgService", "attach thumb, pass data type is %d", Integer.valueOf(uqVar.bjS));
                        return;
                }
            }
        }
    }

    public final Bitmap a(c cVar) {
        return super.b(cVar.fve, cVar.pGd);
    }

    public final Bitmap a(b bVar) {
        Bitmap bitmap;
        uq uqVar = bVar.fve;
        long j = bVar.pGd;
        boolean z = bVar.fvh;
        int i = bVar.maxWidth;
        if (com.tencent.mm.compatible.util.f.ze()) {
            String c = h.c(uqVar, j);
            if (bh.ov(c) || !e.bO(c)) {
                x.d("MicroMsg.RecordMsgImgService", "getBitmap file not exist, thumb[%B] path[%s]", Boolean.valueOf(false), c);
                bitmap = null;
            } else {
                bitmap = (Bitmap) this.mrw.get(c);
                if (bitmap != null) {
                    x.d("MicroMsg.RecordMsgImgService", "get bm from cache %s", c);
                } else if (z) {
                    bitmap = null;
                } else {
                    x.d("MicroMsg.RecordMsgImgService", "get from cache fail, try to decode from file, path %s", c);
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    bitmap = BitmapFactory.decodeFile(c, options);
                    if (bitmap != null) {
                        x.i("MicroMsg.RecordMsgImgService", "bitmap recycle %s", bitmap);
                        bitmap.recycle();
                    }
                    int i2 = options.outHeight;
                    int i3 = options.outWidth;
                    x.d("MicroMsg.RecordMsgImgService", "width: %s, height: %s", Integer.valueOf(i3), Integer.valueOf(i2));
                    if (i3 > i) {
                        i2 = (options.outHeight * i) / options.outWidth;
                        i3 = i;
                    }
                    i3 = Math.max(1, i3);
                    i2 = Math.max(1, i2);
                    if (i3 > i) {
                        i2 = (options.outHeight * i) / options.outWidth;
                    } else {
                        i = i3;
                    }
                    i3 = ExifHelper.UJ(c);
                    if (i3 == 90 || i3 == 270) {
                        int i4 = i;
                        i = i2;
                        i2 = i4;
                    }
                    bitmap = d.d(c, i2, i, false);
                    if (bitmap == null) {
                        x.e("MicroMsg.RecordMsgImgService", "extractThumbNail fail, temBmp is null, filePath = " + c);
                        bitmap = null;
                    } else {
                        bitmap = d.b(bitmap, (float) i3);
                        this.mrw.put(c, bitmap);
                    }
                }
            }
        } else {
            bitmap = BitmapFactory.decodeResource(ac.getContext().getResources(), R.g.bEi);
        }
        if (bitmap == null && !z) {
            x.d("MicroMsg.RecordMsgImgService", "get image fail, try download, can retry:%B", Boolean.valueOf(super.a(uqVar, j)));
            h.a(uqVar, j, r3);
        }
        return bitmap;
    }

    public final void bmV() {
        super.destory();
    }
}
