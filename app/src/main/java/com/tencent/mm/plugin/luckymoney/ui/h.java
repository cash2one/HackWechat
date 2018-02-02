package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class h {
    private static final Drawable ojM = new ColorDrawable();
    private Activity activity;
    private String imagePath;
    private q ojL;
    private GetHdHeadImageGalleryView ojN;
    private int ojO;
    private int ojP;
    private String username;

    static /* synthetic */ void a(h hVar) {
        List arrayList = new ArrayList();
        arrayList.add(hVar.activity.getString(i.eEG));
        arrayList.add(hVar.activity.getString(i.eHg));
        arrayList.add(hVar.activity.getString(i.eAd));
        com.tencent.mm.ui.base.h.a(hVar.activity, null, (String[]) arrayList.toArray(new String[arrayList.size()]), "", new 2(hVar));
    }

    static /* synthetic */ void e(h hVar) {
        b cfVar = new cf();
        ve veVar = new ve();
        uq uqVar = new uq();
        uqVar.CJ(2);
        uqVar.TE(hVar.imagePath);
        LinkedList linkedList = new LinkedList();
        linkedList.add(uqVar);
        veVar.av(linkedList);
        cfVar.fqp.fqr = veVar;
        cfVar.fqp.type = 2;
        cfVar.fqp.activity = hVar.activity;
        cfVar.fqp.fqw = 2;
        a.xef.m(cfVar);
    }

    public h(Activity activity, String str, String str2) {
        this(activity, str, str2, a.ojR);
    }

    private h(Activity activity, String str, String str2, int i) {
        this.ojP = 1;
        this.activity = activity;
        this.username = str;
        this.imagePath = str2;
        this.ojO = i;
    }

    public final void n(boolean z, int i) {
        x.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "previewImg readImgFromCache:" + z + ", sceneFromUI:" + i);
        View inflate = LayoutInflater.from(this.activity).inflate(g.uEY, null);
        this.ojL = new q(inflate, -1, -1);
        this.ojL.setFocusable(true);
        this.ojL.setOutsideTouchable(true);
        this.ojL.setBackgroundDrawable(ojM);
        this.ojL.showAtLocation(this.activity.getWindow().getDecorView(), 49, 0, 0);
        this.ojN = (GetHdHeadImageGalleryView) inflate.findViewById(f.ckt);
        this.ojN.vjH = this.ojL;
        this.ojN.username = this.username;
        this.ojN.qhu = this.imagePath;
        this.ojP = i;
        com.tencent.mm.kernel.g.Dk();
        Bitmap aq;
        if (com.tencent.mm.kernel.g.Dj().isSDCardAvailable()) {
            aq = n.aq(this.imagePath, z);
            if (aq == null || aq.isRecycled()) {
                x.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "The image of %s is not in the cache, use default avatar", new Object[]{this.username});
            } else {
                x.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "The image of %s is in the cache", new Object[]{this.username});
                this.ojN.N(aq);
            }
            this.ojN.zlg = new 1(this);
            return;
        }
        x.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "previewImg sdcard is not available!");
        u.fI(this.activity);
        aq = BitmapFactory.decodeResource(ac.getContext().getResources(), e.bEi);
        try {
            Bitmap bitmap;
            if (aq.getWidth() >= 480 || aq.getWidth() <= 0) {
                bitmap = aq;
            } else {
                float width = 480.0f / ((float) aq.getWidth());
                Matrix matrix = new Matrix();
                matrix.postScale(width, width);
                bitmap = Bitmap.createBitmap(aq, 0, 0, aq.getWidth(), aq.getHeight(), matrix, true);
            }
            x.d("MicroMsg.LuckyMoneyPreviewImgGallaryView", "dkhdbm old[%d %d] new[%d %d]", new Object[]{Integer.valueOf(aq.getWidth()), Integer.valueOf(aq.getHeight()), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())});
            this.ojN.N(bitmap);
            this.ojN.qhu = null;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.LuckyMoneyPreviewImgGallaryView", e, "", new Object[0]);
        }
    }
}
