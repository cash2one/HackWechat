package com.tencent.mm.plugin.appbrand.share.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.e;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.modelappbrand.g;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class a implements g {
    private final Map<String, SoftReference<e>> jJg = new ConcurrentHashMap();
    private final Map<String, SoftReference<f>> jJh = new ConcurrentHashMap();
    private final Map<Integer, a> jJi = new ConcurrentHashMap();
    private final Map<Integer, Bundle> jJj = new ConcurrentHashMap();

    public a() {
        a(1, new 1(this));
    }

    public final View be(Context context) {
        Assert.assertNotNull(context);
        return new WxaShareMessagePage(context);
    }

    public final boolean a(String str, View view, Bundle bundle) {
        Bitmap bitmap = null;
        Assert.assertNotNull(view);
        Assert.assertNotNull(bundle);
        if (!(view instanceof WxaShareMessagePage)) {
            return false;
        }
        x.i("MicroMsg.WxaShareMessageService", "onBindView(%s, %s)", new Object[]{str, Integer.valueOf(view.hashCode())});
        WxaShareMessagePage wxaShareMessagePage = (WxaShareMessagePage) view;
        boolean z = bundle.getBoolean("is_dynamic_page");
        wxaShareMessagePage.jJn.setText(bundle.getString("title", ""));
        if (z) {
            wxaShareMessagePage.jsu.setVisibility(4);
            View view2 = wxaShareMessagePage.jJp;
            view2.setVisibility(0);
            bundle.putInt("view_init_width", WxaShareMessagePage.akf());
            bundle.putInt("view_init_height", WxaShareMessagePage.akg());
            ((com.tencent.mm.modelappbrand.e) com.tencent.mm.kernel.g.h(com.tencent.mm.modelappbrand.e.class)).a(str, view2, bundle, new r(new 2(this, wxaShareMessagePage)));
        } else {
            wxaShareMessagePage.jJp.setVisibility(4);
            wxaShareMessagePage.jsu.setVisibility(0);
            byte[] byteArray = bundle.getByteArray("image_data");
            if (byteArray != null && byteArray.length > 0) {
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                if (!(decodeByteArray == null || decodeByteArray.isRecycled())) {
                    wxaShareMessagePage.s(decodeByteArray);
                    return true;
                }
            }
            String string = bundle.getString("delay_load_img_path");
            if (bh.ov(string)) {
                String string2 = bundle.getString("image_url");
                if (string2 == null || !(string2.startsWith("http://") || string2.startsWith("https://"))) {
                    if (string2 != null && string2.startsWith("file://")) {
                        Bitmap a = b.Jj().a(string2, null);
                        if (!(a == null || a.isRecycled())) {
                            wxaShareMessagePage.s(a);
                            return true;
                        }
                    }
                    wxaShareMessagePage.Jn();
                } else {
                    wxaShareMessagePage.ue(string2);
                }
            } else {
                if (!string.startsWith("delayLoadFile://")) {
                    bitmap = b.Jj().a(string, null);
                    x.i("MicroMsg.WxaShareMessageService", "findCachedLocal(%s)", new Object[]{string});
                } else if (this.jJj.containsKey(Integer.valueOf(2))) {
                    bitmap = d.UN(string.replace("delayLoadFile://", ""));
                    x.i("MicroMsg.WxaShareMessageService", "getBitmapNative(%s)", new Object[]{string});
                }
                if (bitmap != null) {
                    if (bitmap.isRecycled()) {
                        wxaShareMessagePage.ue(string);
                    } else {
                        wxaShareMessagePage.s(bitmap);
                    }
                    return true;
                }
                x.i("MicroMsg.WxaShareMessageService", "delay loadImage(%s)", new Object[]{string});
                wxaShareMessagePage.jJq.setVisibility(0);
                wxaShareMessagePage.jJo.setVisibility(4);
                wxaShareMessagePage.jsu.setVisibility(4);
                wxaShareMessagePage.jJq.cze();
                a(2, new 3(this, wxaShareMessagePage));
            }
        }
        return true;
    }

    public final void a(String str, View view) {
        Assert.assertNotNull(view);
        if (view instanceof WxaShareMessagePage) {
            x.i("MicroMsg.WxaShareMessageService", "onUnbindView(%s, %s)", new Object[]{str, Integer.valueOf(view.hashCode())});
            ((com.tencent.mm.modelappbrand.e) com.tencent.mm.kernel.g.h(com.tencent.mm.modelappbrand.e.class)).a(str, ((WxaShareMessagePage) view).jJp);
            this.jJi.remove(Integer.valueOf(2));
        }
    }

    public final synchronized void c(int i, Bundle bundle) {
        a aVar = (a) this.jJi.get(Integer.valueOf(i));
        if (aVar != null) {
            aVar.x(bundle);
        }
        this.jJj.put(Integer.valueOf(i), bundle);
        x.i("MicroMsg.WxaShareMessageService", "onAction(%d, %s)", new Object[]{Integer.valueOf(i), bundle});
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final e aZ(int i, int i2) {
        e eVar;
        String format = String.format("%d-%d-dp", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        SoftReference softReference = (SoftReference) this.jJg.get(format);
        if (softReference != null) {
            eVar = (e) softReference.get();
        }
        synchronized (this) {
            softReference = (SoftReference) this.jJg.get(format);
            if (softReference != null) {
                eVar = (e) softReference.get();
            }
            eVar = new com.tencent.mm.plugin.appbrand.share.a(com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), i), com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), i2));
            this.jJg.put(format, new SoftReference(eVar));
        }
        return eVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final f IY() {
        f fVar;
        String format = String.format("%d-%d-dp", new Object[]{Integer.valueOf(MMGIFException.D_GIF_ERR_IMAGE_DEFECT), Integer.valueOf(90)});
        SoftReference softReference = (SoftReference) this.jJh.get(format);
        if (softReference != null) {
            fVar = (f) softReference.get();
        }
        synchronized (this) {
            softReference = (SoftReference) this.jJh.get(format);
            if (softReference != null) {
                fVar = (f) softReference.get();
            }
            fVar = new com.tencent.mm.plugin.appbrand.share.b(com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), MMGIFException.D_GIF_ERR_IMAGE_DEFECT), com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 90));
            this.jJh.put(format, new SoftReference(fVar));
        }
        return fVar;
    }

    private void a(int i, a aVar) {
        this.jJi.put(Integer.valueOf(i), aVar);
        if (this.jJj.containsKey(Integer.valueOf(i))) {
            aVar.x((Bundle) this.jJj.get(Integer.valueOf(i)));
        }
    }
}
