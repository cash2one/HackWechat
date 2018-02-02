package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import com.tencent.mm.aq.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.i.a;
import com.tencent.mm.platformtools.i.b;
import com.tencent.mm.plugin.n.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.w.a.f;

public final class t implements i {
    private boolean fvh;
    private long hUf = 0;
    private long hUg = 0;
    private String prP;
    private int type;
    private String url;
    private boolean vdO;

    public t(String str, int i, String str2, boolean z) {
        this.url = str;
        this.type = i;
        this.prP = str2;
        this.fvh = z;
    }

    public static String v(String str, int i, String str2) {
        if (!g.Dh().Cy()) {
            return "";
        }
        return String.format("%s/ReaderApp_%d%s_%s", new Object[]{c.Fi(), Integer.valueOf(i), str2, com.tencent.mm.a.g.s(str.getBytes())});
    }

    public final String Wf() {
        return v(this.url, this.type, this.prP);
    }

    public final String Wg() {
        if (q.PE()) {
            return q.lw(this.url);
        }
        return this.url;
    }

    public final String Wh() {
        return this.url;
    }

    public final String Wi() {
        return this.url + this.prP;
    }

    public final boolean Wj() {
        return false;
    }

    public final boolean Wk() {
        return this.fvh;
    }

    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        int i = 100;
        if (a.ice == aVar) {
            DisplayMetrics displayMetrics;
            int i2;
            String str2 = this.prP;
            a aVar2 = new a();
            Context context = ac.getContext();
            if (context != null) {
                Resources resources = context.getResources();
                if (resources != null) {
                    displayMetrics = resources.getDisplayMetrics();
                    if (displayMetrics == null) {
                        if ("@T".equals(str2)) {
                            i = (int) (50.0f * displayMetrics.density);
                            i2 = i;
                        } else {
                            i2 = (int) (((float) displayMetrics.widthPixels) - (60.0f * displayMetrics.density));
                            i = (int) (167.0f * displayMetrics.density);
                        }
                    } else if ("@T".equals(str2)) {
                        i2 = 100;
                    } else {
                        i2 = Integer.MAX_VALUE;
                        i = 334;
                    }
                    aVar2.w = i2;
                    aVar2.h = i;
                    x.d("MicroMsg.ReaaderAppGetPicStrategy", aVar2.toString());
                    bitmap = d.a(bitmap, aVar2.w, aVar2.h, true);
                    x.d("MicroMsg.ReaaderAppGetPicStrategy", "handlerBitmap, path:%s", new Object[]{Wf()});
                    d.a(bitmap, 100, CompressFormat.PNG, Wf(), false);
                }
            }
            displayMetrics = null;
            if (displayMetrics == null) {
                if ("@T".equals(str2)) {
                    i2 = 100;
                } else {
                    i2 = Integer.MAX_VALUE;
                    i = 334;
                }
            } else if ("@T".equals(str2)) {
                i = (int) (50.0f * displayMetrics.density);
                i2 = i;
            } else {
                i2 = (int) (((float) displayMetrics.widthPixels) - (60.0f * displayMetrics.density));
                i = (int) (167.0f * displayMetrics.density);
            }
            aVar2.w = i2;
            aVar2.h = i;
            x.d("MicroMsg.ReaaderAppGetPicStrategy", aVar2.toString());
            bitmap = d.a(bitmap, aVar2.w, aVar2.h, true);
            try {
                x.d("MicroMsg.ReaaderAppGetPicStrategy", "handlerBitmap, path:%s", new Object[]{Wf()});
                d.a(bitmap, 100, CompressFormat.PNG, Wf(), false);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ReaaderAppGetPicStrategy", e, "", new Object[0]);
                x.e("MicroMsg.ReaaderAppGetPicStrategy", "save image %s fail", new Object[]{this.url});
            }
        }
        return bitmap;
    }

    public final void Wm() {
        this.hUf = bh.Wp();
        if (this.vdO) {
            x.d("MicroMsg.ReaaderAppGetPicStrategy", "beforeGetPicFromNet, from biz msg");
            com.tencent.mm.plugin.report.service.g.pQN.a(86, 0, 1, false);
        }
    }

    public final void N(String str, boolean z) {
        this.hUg = bh.Wp();
        Object obj = null;
        if (q.PE() && !bh.ov(str) && q.lx(Wg()) && str.equals("image/webp")) {
            obj = 1;
        }
        if (!this.vdO) {
            return;
        }
        if (z) {
            long j = this.hUg - this.hUf;
            x.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz image success, used %d", new Object[]{Long.valueOf(j)});
            com.tencent.mm.plugin.report.service.g.pQN.a(86, 4, j, false);
            if (obj != null) {
                x.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz webp image success");
                com.tencent.mm.plugin.report.service.g.pQN.a(86, 17, j, false);
                com.tencent.mm.plugin.report.service.g.pQN.a(86, 13, 1, false);
                return;
            }
            return;
        }
        x.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz image failed");
        com.tencent.mm.plugin.report.service.g.pQN.a(86, 2, 1, false);
        if (obj != null) {
            x.d("MicroMsg.ReaaderAppGetPicStrategy", "afterGetPicFromNet, download biz webp image failed");
            com.tencent.mm.plugin.report.service.g.pQN.a(86, 15, 1, false);
        }
    }

    public final void a(a aVar, String str) {
        if (aVar == a.ice && this.vdO && q.PE() && !bh.ov(str) && q.lx(Wg()) && str.equals("image/webp")) {
            x.d("MicroMsg.ReaaderAppGetPicStrategy", "decode download webp picture failed");
            com.tencent.mm.plugin.report.service.g.pQN.a(86, 14, 1, false);
        }
    }

    public final Bitmap Wl() {
        return BitmapFactory.decodeResource(ac.getContext().getResources(), f.bEi);
    }

    public final b We() {
        return null;
    }
}
