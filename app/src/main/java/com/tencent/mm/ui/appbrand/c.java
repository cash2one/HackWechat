package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.p.k;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.q;

public final class c implements h {
    private Bitmap bitmap = null;
    private View contentView = null;
    private Context context;
    private ImageView fyg = null;
    private ProgressBar fyi = null;
    private View nVo;
    private TextView rFH = null;
    private TextView rFI = null;
    private View rno;
    q vru;
    public boolean vrv = true;
    private long xVF = 10000;
    private ImageView xVG = null;
    private String xVH = null;
    private boolean xVI = false;
    private boolean xVJ = false;
    public a xVK;
    af xVL = null;

    static /* synthetic */ void a(c cVar) {
        if (cVar.fyg == null || cVar.vru == null || cVar.rno == null || cVar.nVo == null) {
            x.e("MicroMsg.AppBrandServiceImageBubble", "these references include null reference");
            return;
        }
        int i;
        if (cVar.bitmap != null) {
            x.d("MicroMsg.AppBrandServiceImageBubble", "bitmap is null,return");
            i = 1;
        } else {
            boolean z = false;
        }
        if (i == 0) {
            cVar.Jm();
        } else {
            cVar.j(cVar.bitmap);
        }
        i = cVar.vrv ? 83 : 85;
        int i2 = cVar.vrv ? 0 : 10;
        int aQ = j.aQ(cVar.context);
        int height = cVar.nVo.getHeight();
        if (cVar.xVJ && height < aQ) {
            height += aQ;
        }
        if (VERSION.SDK_INT >= 21) {
            Rect cnF = ae.cnF();
            i2 = cVar.vrv ? 0 : i2 + cnF.right;
            height += cnF.bottom;
            x.i("MicroMsg.AppBrandServiceImageBubble", "bubble navbar height %s %s", new Object[]{Integer.valueOf(cnF.right), Integer.valueOf(cnF.bottom)});
        }
        cVar.vru.showAtLocation(cVar.rno, i, i2, height);
        if (cVar.xVF > 0) {
            ak akVar = new ak(new 3(cVar), false);
            long j = cVar.xVF;
            akVar.J(j, j);
        }
    }

    public final void Jm() {
        x.d("MicroMsg.AppBrandServiceImageBubble", "beforeLoadBitmap");
        this.fyi.setVisibility(0);
        this.fyg.setVisibility(8);
        this.xVG.setVisibility(8);
    }

    public final void j(Bitmap bitmap) {
        x.d("MicroMsg.AppBrandServiceImageBubble", "onBitmapLoaded");
        if (bitmap == null) {
            x.w("MicroMsg.AppBrandServiceImageBubble", "bitmap is null");
            return;
        }
        this.bitmap = bitmap;
        this.fyi.setVisibility(8);
        if (bitmap == null || bitmap.isRecycled()) {
            this.xVG.setVisibility(0);
            this.fyg.setVisibility(8);
            return;
        }
        this.fyg.setVisibility(0);
        this.fyg.setImageBitmap(bitmap);
        this.xVG.setVisibility(8);
    }

    public final void Jn() {
        x.i("MicroMsg.AppBrandServiceImageBubble", "onLoadFailed");
        this.xVG.setVisibility(0);
        this.fyi.setVisibility(8);
        this.fyg.setVisibility(8);
    }

    public final String Jo() {
        return k.bi(this);
    }

    public c(Context context, View view, View view2, boolean z) {
        this.context = context;
        this.rno = view;
        this.nVo = view2;
        this.xVJ = z;
        this.contentView = View.inflate(this.context, R.i.dcZ, null);
        this.rFH = (TextView) this.contentView.findViewById(R.h.cpy);
        this.rFI = (TextView) this.contentView.findViewById(R.h.cpz);
        this.fyg = (ImageView) this.contentView.findViewById(R.h.cpk);
        this.xVG = (ImageView) this.contentView.findViewById(R.h.ceN);
        this.fyi = (ProgressBar) this.contentView.findViewById(R.h.cpu);
        this.vru = new q(this.contentView, -2, -2, true);
        this.vru.setBackgroundDrawable(new ColorDrawable(0));
        this.vru.setOutsideTouchable(true);
        this.vru.setFocusable(false);
        this.contentView.setOnClickListener(new 1(this));
        this.xVL = new af(this, this.context.getMainLooper()) {
            final /* synthetic */ c xVM;

            public final void handleMessage(Message message) {
                c.a(this.xVM);
            }
        };
    }
}
