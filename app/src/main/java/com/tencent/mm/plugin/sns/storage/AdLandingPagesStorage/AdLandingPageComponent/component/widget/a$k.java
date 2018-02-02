package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.view.View;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class a$k implements Runnable {
    WeakReference<Bitmap> qug;
    final /* synthetic */ a rmk;

    private a$k(a aVar) {
        this.rmk = aVar;
        this.qug = new WeakReference(null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        View view = null;
        boolean z = true;
        String str;
        View view2;
        if (a.m(this.rmk) == null || !a.m(this.rmk).isValid()) {
            boolean z2;
            str = "MicroMsg.SightPlayController";
            String str2 = "#0x%x-#0x%x want draw thumb, but surface status error, surface null ? %B, thumb bgView null ? %B, thumb null ? %B, mask null ? %B";
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(this.rmk.hashCode());
            objArr[1] = Integer.valueOf(hashCode());
            objArr[2] = Boolean.valueOf(a.m(this.rmk) == null);
            if (a.n(this.rmk) == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[3] = Boolean.valueOf(z2);
            if (this.qug.get() == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[4] = Boolean.valueOf(z2);
            if (a.o(this.rmk) == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[5] = Boolean.valueOf(z2);
            x.w(str, str2, objArr);
            if (a.o(this.rmk) == null) {
                Bitmap bitmap = (Bitmap) this.qug.get();
                if (a.n(this.rmk) != null) {
                    view = (View) a.n(this.rmk).get();
                }
                if (view == null || bitmap == null || bitmap.isRecycled()) {
                    boolean z3;
                    str = "MicroMsg.SightPlayController";
                    str2 = "bgView:%B, thumb:%B";
                    objArr = new Object[2];
                    if (view == null) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    objArr[0] = Boolean.valueOf(z3);
                    if (bitmap != null) {
                        z = false;
                    }
                    objArr[1] = Boolean.valueOf(z);
                    x.e(str, str2, objArr);
                    return;
                }
                view.post(new 1(this, view, bitmap));
                return;
            }
            if (!(a.p(this.rmk) != null && a.p(this.rmk).getWidth() == a.o(this.rmk).getWidth() && a.p(this.rmk).getHeight() == a.o(this.rmk).getHeight())) {
                try {
                    a.a(this.rmk, Bitmap.createBitmap(a.o(this.rmk).getWidth(), a.o(this.rmk).getHeight(), Config.ARGB_8888));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SightPlayController", e, "try to create thumb bmp error:%s", new Object[]{e.getMessage()});
                    a.a(this.rmk, null);
                }
            }
            if (a.p(this.rmk) == null || this.qug.get() == null || ((Bitmap) this.qug.get()).isRecycled()) {
                String str3 = "MicroMsg.SightPlayController";
                str = "mThubmBgBmp:%B, thumbRef:%B";
                Object[] objArr2 = new Object[2];
                if (a.p(this.rmk) == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr2[0] = Boolean.valueOf(z2);
                if (this.qug.get() != null) {
                    z = false;
                }
                objArr2[1] = Boolean.valueOf(z);
                x.e(str3, str, objArr2);
                return;
            }
            long nanoTime = System.nanoTime();
            SightVideoJNI.handleThumb((Bitmap) this.qug.get(), a.p(this.rmk), a.o(this.rmk));
            x.i("MicroMsg.SightPlayController", "handle thumb use %d us", new Object[]{Long.valueOf((System.nanoTime() - nanoTime) / 1000)});
            Bitmap p = a.p(this.rmk);
            if (a.n(this.rmk) != null) {
                view2 = (View) a.n(this.rmk).get();
            } else {
                view2 = null;
            }
            if (view2 != null && p != null) {
                view2.post(new 2(this, view2, p));
                return;
            }
            return;
        }
        str3 = "MicroMsg.SightPlayController";
        str = "#0x%x-#0x%x draw thumb, thumb empty ? %B";
        objArr2 = new Object[3];
        objArr2[0] = Integer.valueOf(this.rmk.hashCode());
        objArr2[1] = Integer.valueOf(hashCode());
        objArr2[2] = Boolean.valueOf(this.qug.get() == null);
        x.d(str3, str, objArr2);
        if (a.n(this.rmk) != null) {
            view2 = (View) a.n(this.rmk).get();
            if (view2 != null) {
                view2.post(new 3(this, view2));
            }
        }
        if (this.qug.get() == null) {
            SightVideoJNI.drawSurfaceColor(a.m(this.rmk), 0);
        } else {
            SightVideoJNI.drawSurfaceThumb(a.m(this.rmk), (Bitmap) this.qug.get(), a.o(this.rmk));
        }
    }
}
