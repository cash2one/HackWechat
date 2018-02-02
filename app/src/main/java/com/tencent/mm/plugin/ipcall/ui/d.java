package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.n;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.as.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.z;
import java.lang.ref.WeakReference;

public final class d {
    Context context;
    private af hae = new af(Looper.getMainLooper());
    as nIc = new as(5, "IPCallAddressAvatarLoader", 1, Looper.getMainLooper());
    z<String, WeakReference<Bitmap>> nId = new z(50);

    static /* synthetic */ void a(d dVar, final ImageView imageView, final String str, final Bitmap bitmap) {
        if (bitmap != null) {
            dVar.nId.put(str, new WeakReference(bitmap));
            dVar.hae.post(new Runnable(dVar) {
                final /* synthetic */ d nIg;

                public final void run() {
                    if (imageView.getTag() != null && imageView.getTag().equals(str) && bitmap != null && !bitmap.isRecycled()) {
                        imageView.setImageBitmap(bitmap);
                    }
                }
            });
        }
    }

    public d(Context context) {
        this.context = context;
    }

    public final void a(String str, String str2, ImageView imageView) {
        if (!bh.ov(str) && !bh.ov(str2) && imageView != null) {
            String cX = cX(str, str2);
            imageView.setTag(cX);
            if (!d(cX(str, str2), imageView)) {
                this.nIc.c(new 1(this, str, cX, imageView, str2));
            }
        }
    }

    public final void b(final String str, final ImageView imageView) {
        if (!bh.ov(str) && imageView != null) {
            final String CQ = CQ(str);
            imageView.setTag(CQ);
            if (!d(CQ(str), imageView)) {
                this.nIc.c(new a(this) {
                    final /* synthetic */ d nIg;

                    public final boolean JB() {
                        d.a(this.nIg, imageView, CQ, com.tencent.mm.plugin.ipcall.b.a.an(this.nIg.context, str));
                        return true;
                    }

                    public final boolean JC() {
                        return true;
                    }
                });
            }
        }
    }

    public final void c(final String str, final ImageView imageView) {
        if (!bh.ov(str) && imageView != null) {
            final String CP = CP(str);
            imageView.setTag(CP);
            if (!d(CP(str), imageView)) {
                this.nIc.c(new a(this) {
                    final /* synthetic */ d nIg;

                    public final boolean JB() {
                        Bitmap a = b.a(str, false, -1);
                        if (a == null) {
                            n.Jz();
                            a = com.tencent.mm.ad.d.jd(str);
                        }
                        d.a(this.nIg, imageView, CP, a);
                        return true;
                    }

                    public final boolean JC() {
                        return false;
                    }
                });
            }
        }
    }

    private boolean d(String str, ImageView imageView) {
        WeakReference weakReference = (WeakReference) this.nId.get(str);
        if (weakReference != null) {
            Bitmap bitmap = (Bitmap) weakReference.get();
            if (!(bitmap == null || imageView.getTag() == null || !imageView.getTag().toString().equals(str))) {
                if (!(bitmap == null || bitmap.isRecycled())) {
                    imageView.setImageBitmap(bitmap);
                }
                return true;
            }
        }
        return false;
    }

    private static String CP(String str) {
        return str + "@username";
    }

    private static String CQ(String str) {
        return str + "@contactId";
    }

    public static String cX(String str, String str2) {
        return str + "@" + str2 + "@contactId@username";
    }
}
