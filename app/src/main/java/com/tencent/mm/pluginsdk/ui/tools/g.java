package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.SparseArray;
import android.widget.ImageView;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public class g {
    public byte[] gSF = new byte[0];
    af hae;
    volatile boolean vxa = false;
    private HandlerThread vxb = e.Wf("ImageEngine_handlerThread" + System.currentTimeMillis());
    private af vxc;
    public HashMap<String, ImageView> vxd = new HashMap();
    public HashMap<ImageView, String> vxe = new HashMap();
    c<String, Bitmap> vxf;
    private SparseArray<Bitmap> vxg;
    a<e> vxh;
    a<b> vxi;
    private boolean vxj = true;
    private a vxk = new 6(this);

    public g(int i) {
        this.vxb.start();
        this.vxc = new af(this.vxb.getLooper());
        this.hae = new af(Looper.getMainLooper());
        this.vxh = new 1(this, this.vxb.getLooper());
        this.vxi = new 2(this, Looper.getMainLooper());
        this.vxg = new SparseArray();
        this.vxf = new c<String, Bitmap>(this, i) {
            final /* synthetic */ g vxl;

            protected final /* synthetic */ void bT(Object obj) {
                Bitmap bitmap = (Bitmap) obj;
                if (bitmap != null) {
                    x.i("MicroMsg.ImageEngine", "recycle bitmap:%s", new Object[]{bitmap.toString()});
                    bitmap.recycle();
                }
            }
        };
        j.b(this.vxk);
    }

    public final void destory() {
        x.d("MicroMsg.ImageEngine", "do destory");
        this.vxa = true;
        this.vxb.quit();
        j.c(this.vxk);
        SparseArray sparseArray = this.vxg;
        c cVar = this.vxf;
        this.vxg = new SparseArray();
        this.vxf = new c<String, Bitmap>(this) {
            final /* synthetic */ g vxl;

            {
                this.vxl = r2;
            }

            protected final /* bridge */ /* synthetic */ void bT(Object obj) {
            }
        };
        e.post(new 5(this, sparseArray, cVar), "ImageEngine_destroy_" + System.currentTimeMillis());
    }

    public i h(String str, String str2, int i, int i2) {
        return null;
    }

    private void a(ImageView imageView, int i) {
        if (i == 0) {
            d.d(imageView);
            return;
        }
        Bitmap bitmap = (Bitmap) this.vxg.get(i);
        if (bitmap == null) {
            bitmap = com.tencent.mm.compatible.f.a.decodeResource(imageView.getResources(), i);
            this.vxg.put(i, bitmap);
        }
        d.b(imageView, bitmap);
    }

    static String p(String str, String str2, int i, int i2) {
        return bh.az(str, "null") + "_" + bh.az(str2, "null") + "_" + i + "_" + i2;
    }

    public final void a(ImageView imageView, String[] strArr, String str, int i, int i2, int i3) {
        int i4 = 0;
        if (!this.vxj) {
            return;
        }
        if (this.vxa) {
            x.w("MicroMsg.ImageEngine", "on attach, isQuit, return");
        } else if (imageView == null) {
            x.w("MicroMsg.ImageEngine", "attach from file path fail, imageview is null");
        } else if ((strArr == null || strArr.length <= 0) && bh.ov(str)) {
            x.w("MicroMsg.ImageEngine", "attach from file path fail, path and url are null or empty");
            a(imageView, i);
        } else {
            String str2 = (strArr == null || strArr.length <= 0) ? null : strArr[0];
            String p = p(str2, str, i2, i3);
            synchronized (this.gSF) {
                str2 = (String) this.vxe.get(imageView);
                if (str2 != null) {
                    this.vxd.remove(str2);
                }
                this.vxe.put(imageView, p);
            }
            Bitmap bitmap = (Bitmap) this.vxf.get(p);
            if (bitmap == null || bitmap.isRecycled()) {
                x.v("MicroMsg.ImageEngine", "get first render bmp fail, key[%s]", new Object[]{p});
                if (strArr != null && strArr.length > 1) {
                    for (int i5 = 1; i5 < strArr.length; i5++) {
                        bitmap = (Bitmap) this.vxf.get(p(strArr[i5], str, i2, i3));
                        String str3 = "MicroMsg.ImageEngine";
                        String str4 = "get next render bmp, key[%s], result[%B]";
                        Object[] objArr = new Object[2];
                        objArr[0] = p;
                        objArr[1] = Boolean.valueOf(bitmap != null);
                        x.v(str3, str4, objArr);
                        if (bitmap != null) {
                            d.b(imageView, bitmap);
                            i4 = 1;
                            break;
                        }
                    }
                }
                if (i4 == 0) {
                    x.v("MicroMsg.ImageEngine", "use default res to render");
                    a(imageView, i);
                }
                synchronized (this.gSF) {
                    this.vxd.put(p, imageView);
                }
                b bVar = (b) this.vxi.ccz();
                b.a(bVar, strArr);
                b.a(bVar, str);
                b.b(bVar, p);
                b.a(bVar, i2);
                b.b(bVar, i3);
                this.vxc.postAtFrontOfQueueV2(bVar);
                return;
            }
            d.b(imageView, bitmap);
        }
    }
}
