package com.tencent.mm.pluginsdk.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.d;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.n;
import com.tencent.mm.ag.m;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class f {
    private static final Drawable ojM = new ColorDrawable();
    private Activity activity;
    private String iPN;
    public q ojL;
    private GetHdHeadImageGalleryView ojN;
    private e qht;
    private String username;
    private String vjP;
    private b vjQ;
    private int vjR;

    public f(Activity activity, String str) {
        this(activity, str, null);
    }

    public f(Activity activity, String str, String str2) {
        this(activity, str, str2, a.vjU);
    }

    public f(Activity activity, String str, String str2, int i) {
        this(activity, str, str2, i, (byte) 0);
    }

    private f(Activity activity, String str, String str2, int i, byte b) {
        this.vjP = null;
        this.iPN = null;
        this.activity = activity;
        this.username = str;
        this.iPN = str2;
        this.vjQ = null;
        this.vjR = i;
    }

    public final void caa() {
        View inflate = LayoutInflater.from(this.activity).inflate(R.i.dlu, null);
        this.ojL = new q(inflate, -1, -1);
        switch (2.vjT[this.vjR - 1]) {
            case 1:
                this.ojL.setAnimationStyle(R.m.eYR);
                break;
            case 2:
                this.ojL.setAnimationStyle(R.m.eYS);
                break;
            case 3:
                this.ojL.setAnimationStyle(R.m.eYQ);
                break;
        }
        this.ojL.setFocusable(true);
        this.ojL.setOutsideTouchable(true);
        this.ojL.setBackgroundDrawable(ojM);
        this.ojL.showAtLocation(this.activity.getWindow().getDecorView(), 49, 0, 0);
        this.ojN = (GetHdHeadImageGalleryView) inflate.findViewById(R.h.ckt);
        this.ojN.vjH = this.ojL;
        this.ojN.username = this.username;
        ar.Hg();
        if (c.isSDCardAvailable()) {
            Bitmap d = !bh.ov(this.iPN) ? m.d(this.username, this.iPN, R.g.bEk) : b.a(this.username, true, -1);
            if (d == null) {
                d = BitmapFactory.decodeResource(this.activity.getResources(), R.g.bBB);
            }
            if (d == null || d.isRecycled()) {
                x.i("MicroMsg.GetHdHeadImg", "The avatar of %s is not in the cache, use default avatar", this.username);
            } else {
                x.i("MicroMsg.GetHdHeadImg", "The avatar of %s is in the cache", this.username);
                this.ojN.setThumbImage(d);
            }
            if (!bh.ov(this.vjP)) {
                this.username = this.vjP;
            }
            n.Jz();
            Bitmap je = d.je(this.username);
            if (je == null || je.isRecycled()) {
                this.qht = new e();
                this.qht.a(this.username, new 1(this, d));
                return;
            }
            x.i("MicroMsg.GetHdHeadImg", "The HDAvatar of %s is already exists", this.username);
            n.Jz();
            d(je, d.x(this.username, true));
            return;
        }
        u.fI(this.activity);
        d(n.Jz().bg(this.activity), null);
    }

    private void d(Bitmap bitmap, String str) {
        try {
            Bitmap createBitmap;
            if (bitmap.getWidth() < 480) {
                float width = (float) (480 / bitmap.getWidth());
                Matrix matrix = new Matrix();
                matrix.postScale(width, width);
                createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } else {
                createBitmap = bitmap;
            }
            x.d("MicroMsg.GetHdHeadImg", "dkhdbm old[%d %d] new[%d %d]", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(createBitmap.getWidth()), Integer.valueOf(createBitmap.getHeight()));
            this.ojN.N(createBitmap);
            this.ojN.qhu = str;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GetHdHeadImg", e, "", new Object[0]);
        }
    }
}
