package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u;
import com.tencent.mm.g.a.oj;
import com.tencent.mm.plugin.scanner.util.b;
import com.tencent.mm.plugin.scanner.util.b$a;
import com.tencent.mm.protocal.c.ia;
import com.tencent.mm.protocal.c.ib;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public abstract class c extends i implements b$a {
    private long pTO;
    int pTP;
    private HighlightRectSideView pTQ;
    k pTR;
    private r pTS;
    private i pTT;

    protected abstract b a(b$a com_tencent_mm_plugin_scanner_util_b_a);

    protected abstract float boI();

    protected abstract String boJ();

    protected abstract int boK();

    static /* synthetic */ void a(c cVar, final String str) {
        if (cVar.pTT != null) {
            cVar.pTT.dismiss();
        }
        cVar.pTT = h.a(cVar.pXp.getContext(), R.l.eHK, R.l.dGO, new OnClickListener(cVar) {
            final /* synthetic */ c pTV;

            public final void onClick(DialogInterface dialogInterface, int i) {
                ar.CG().c(this.pTV.pTR);
                com.tencent.mm.sdk.b.b ojVar = new oj();
                ojVar.fGk.cardType = str;
                ojVar.fGk.fGl = 2;
                a.xef.m(ojVar);
                this.pTV.pXp.getContext().finish();
            }
        }, null);
    }

    public c(i.b bVar, Point point, DisplayMetrics displayMetrics, int i) {
        super(bVar, point);
        this.pTP = 0;
        this.pTR = null;
        this.pTS = null;
        this.pTT = null;
        this.pXn = 0;
        this.pXo = 0;
        float boI = boI();
        Point point2 = i == 1 ? new Point(displayMetrics.widthPixels, displayMetrics.heightPixels) : new Point(displayMetrics.heightPixels, displayMetrics.widthPixels);
        int i2 = (int) (((float) point2.y) * 0.8f);
        int i3 = (int) (((float) point2.x) * 0.8f);
        if (((float) i2) * boI > ((float) point2.x)) {
            i2 = (int) (((float) i3) / boI);
        } else {
            i3 = (int) (((float) i2) * boI);
        }
        Point point3 = new Point((int) (((float) i3) / displayMetrics.density), (int) (((float) i2) / displayMetrics.density));
        this.pXo = (int) (((((float) point2.y) / displayMetrics.density) - ((float) point3.y)) / 2.0f);
        dl(point3.x, point3.y);
        if (bh.eY(bVar.getContext()) < 100) {
            x.w("MicroMsg.BaseScanModeLicence", "memory is not much");
            this.pTO = 280;
            return;
        }
        this.pTO = 80;
    }

    protected final void onResume() {
    }

    protected final void onDestroy() {
    }

    protected final void boL() {
    }

    protected final b boM() {
        if (this.pXj == null) {
            this.pXj = a(this);
        }
        return this.pXj;
    }

    protected final int boN() {
        return R.i.dre;
    }

    protected final int boO() {
        return 0;
    }

    protected final void boP() {
    }

    protected final void cr(View view) {
        if (view != null) {
            TextView textView = (TextView) view.findViewById(R.h.bSl);
            if (textView != null) {
                textView.setText(view.getContext().getString(R.l.eHJ, new Object[]{view.getContext().getString(boK())}));
            }
        }
    }

    protected final boolean boQ() {
        return false;
    }

    protected final boolean boR() {
        return false;
    }

    protected final void h(Rect rect) {
        x.d("MicroMsg.BaseScanModeLicence", "smoothie, maskRect = %s", new Object[]{rect});
        HighlightRectSideView highlightRectSideView = (HighlightRectSideView) this.pXp.findViewById(R.h.bQN);
        if (highlightRectSideView != null) {
            highlightRectSideView.i(rect);
        }
        this.pTQ = highlightRectSideView;
    }

    public void a(int i, String str, byte[] bArr, int i2, int i3) {
        x.d("MicroMsg.BaseScanModeLicence", "onDecodeSuccess");
        Bitmap bitmap = ((com.tencent.mm.plugin.scanner.util.k) this.pXj).qaT;
        final String boJ = boJ();
        if (this.pTS != null) {
            this.pTS.dismiss();
        }
        Context context = this.pXp.getContext();
        context.getString(R.l.dGO);
        this.pTS = h.a(context, context.getString(R.l.eHO), false, null);
        this.pTS.setOnKeyListener(new 2(this, boJ));
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new ia();
        aVar.hmk = new ib();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanlicense";
        aVar.hmi = 1803;
        com.tencent.mm.ae.b JZ = aVar.JZ();
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap.compress(CompressFormat.JPEG, 80, byteArrayOutputStream)) {
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            if (bh.bw(toByteArray)) {
                r(2, boJ, "");
                return;
            }
            ia iaVar = (ia) JZ.hmg.hmo;
            iaVar.vOd = new com.tencent.mm.bq.b(toByteArray);
            if (boJ.equals("driving")) {
                iaVar.vOc = 0;
            } else if (boJ.equals("identity")) {
                iaVar.vOc = 1;
            }
            this.pTR = u.a(JZ, new u.a(this) {
                final /* synthetic */ c pTV;

                public final int a(int i, int i2, String str, com.tencent.mm.ae.b bVar, k kVar) {
                    x.i("MicroMsg.BaseScanModeLicence", "errType: %d, errCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    c cVar = this.pTV;
                    cVar.pTP++;
                    this.pTV.r(i2, boJ, ((ib) bVar.hmh.hmo).vOe);
                    return 0;
                }
            }, false);
            return;
        }
        r(2, boJ, "");
    }

    public final void boH() {
        x.d("MicroMsg.BaseScanModeLicence", "onDecodeFail");
        if (this.pXp == null) {
            x.e("MicroMsg.BaseScanModeLicence", "ui callback is null");
        } else {
            boS();
        }
    }

    private void boS() {
        this.pTQ.b(((com.tencent.mm.plugin.scanner.util.k) this.pXj).bpL());
        this.pXp.eg(this.pTO);
    }

    private void r(int i, String str, String str2) {
        com.tencent.mm.sdk.b.b ojVar;
        if (i == 0) {
            ojVar = new oj();
            ojVar.fGk.cardType = str;
            ojVar.fGk.fGl = 1;
            ojVar.fGk.fGm = str2;
            if (this.pXj instanceof com.tencent.mm.plugin.scanner.util.k) {
                ojVar.fGk.fGn = ((com.tencent.mm.plugin.scanner.util.k) this.pXj).qaT;
            }
            a.xef.a(ojVar, Looper.getMainLooper());
            if (this.pTS != null) {
                this.pTS.dismiss();
            }
            this.pXp.getContext().finish();
        } else if ((i & 2) > 0 && (i & 1) > 0) {
            r0 = new oj();
            r0.fGk.cardType = str;
            r0.fGk.fGl = 0;
            r0.fGk.fGm = str2;
            a.xef.a(r0, Looper.getMainLooper());
            if (this.pTS != null) {
                this.pTS.dismiss();
            }
            this.pXp.getContext().finish();
        } else if (this.pTP >= 3) {
            ojVar = new oj();
            ojVar.fGk.cardType = str;
            ojVar.fGk.fGl = 1;
            ojVar.fGk.fGm = str2;
            if (this.pXj instanceof com.tencent.mm.plugin.scanner.util.k) {
                ojVar.fGk.fGn = ((com.tencent.mm.plugin.scanner.util.k) this.pXj).qaT;
            }
            a.xef.a(ojVar, Looper.getMainLooper());
            if (this.pTS != null) {
                this.pTS.dismiss();
            }
            this.pXp.getContext().finish();
        } else if ((i & 1) <= 0 || this.pTP >= 3) {
            r0 = new oj();
            r0.fGk.cardType = str;
            r0.fGk.fGl = 0;
            r0.fGk.fGm = str2;
            a.xef.a(r0, Looper.getMainLooper());
            if (this.pTS != null) {
                this.pTS.dismiss();
            }
            this.pXp.getContext().finish();
        } else {
            if (this.pTS != null) {
                this.pTS.dismiss();
            }
            boM().bpv();
            int i2 = (i & 32) > 0 ? R.l.eHM : (i & 64) > 0 ? R.l.eHN : R.l.eHL;
            Toast.makeText(this.pXp.getContext(), i2, 0).show();
            boS();
        }
    }

    public final void D(Bundle bundle) {
    }
}
