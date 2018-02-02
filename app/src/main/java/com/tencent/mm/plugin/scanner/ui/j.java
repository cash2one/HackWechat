package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends i implements a {
    private long pTO;
    private HighlightRectSideView pXw;
    boolean pXx = false;
    private OnClickListener pXy = new 1(this);

    public j(b bVar, Point point, DisplayMetrics displayMetrics, int i) {
        Point point2;
        super(bVar, point);
        if (i == 1) {
            point2 = new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else {
            point2 = new Point(displayMetrics.heightPixels, displayMetrics.widthPixels);
        }
        int i2 = point2.y - ((int) (118.0f * displayMetrics.density));
        Point point3 = new Point((int) (((float) ((int) (((float) i2) * 1.586f))) / displayMetrics.density), (int) (((float) i2) / displayMetrics.density));
        bVar.getContext().setResult(0);
        this.pXn = 0;
        this.pXo = 64;
        dl(point3.x, point3.y);
        if (bh.eY(bVar.getContext()) < 100) {
            x.w("MicroMsg.ScanModeBankCard", "memory is not much");
            this.pTO = 280;
            return;
        }
        this.pTO = 80;
    }

    protected final void onResume() {
    }

    protected final void onPause() {
    }

    protected final void onDestroy() {
    }

    protected final void boL() {
    }

    protected final com.tencent.mm.plugin.scanner.util.b boM() {
        if (this.pXj == null && this.pXp != null) {
            this.pXj = new g(this, this.pXp.bpa(), this.pXx);
        }
        return this.pXj;
    }

    protected final int boN() {
        return R.i.dqV;
    }

    protected final int boO() {
        return 300;
    }

    protected final void boP() {
    }

    protected final void h(Rect rect) {
        String str;
        LinearLayout linearLayout = (LinearLayout) this.pXp.findViewById(R.h.bMF);
        TextView textView = (TextView) this.pXp.findViewById(R.h.bMI);
        this.pXw = (HighlightRectSideView) this.pXp.findViewById(R.h.bMH);
        this.pXw.i(rect);
        Intent intent = this.pXp.getContext().getIntent();
        if (intent != null) {
            String az = bh.az(intent.getStringExtra("bank_card_owner"), "");
            textView.setText(String.format(this.pXp.getContext().getResources().getString(R.l.eHp), new Object[]{az}));
            str = az;
        } else {
            str = null;
        }
        if (bh.ov(str)) {
            linearLayout.setVisibility(8);
        } else {
            linearLayout.setVisibility(0);
            ((ImageView) this.pXp.findViewById(R.h.bMG)).setOnClickListener(this.pXy);
        }
        if (this.pXj != null && this.pXp != null) {
            g gVar = (g) this.pXj;
            boolean bpa = this.pXp.bpa();
            x.d("MicroMsg.ScanBankCardDecoder", "need rotate:" + bpa);
            gVar.qah = bpa;
        }
    }

    public final void a(int i, String str, byte[] bArr, int i2, int i3) {
        x.d("MicroMsg.ScanModeBankCard", "decode success, resultType:%d", Integer.valueOf(i));
        if (3 != i) {
            x.e("MicroMsg.ScanModeBankCard", "decode success, but result type error:" + i);
            return;
        }
        Bitmap bpB = ((g) this.pXj).bpB();
        if (this.pXx) {
            this.pXp.bpc();
            ConfirmScanBankCardResultUI.c(bpB, str);
            return;
        }
        com.tencent.mm.sdk.b.b ohVar = new oh();
        ohVar.fGh.cardId = str;
        ohVar.fGh.fGi = bpB;
        com.tencent.mm.sdk.b.a.xef.m(ohVar);
        this.pXp.getContext().finish();
    }

    public final void boH() {
        x.d("MicroMsg.ScanModeBankCard", "onDecodeFailed");
        if (this.pXp == null) {
            x.e("MicroMsg.ScanModeBankCard", "ui callback is null");
            return;
        }
        this.pXw.b(((g) this.pXj).qaj);
        this.pXp.eg(this.pTO);
    }

    protected final boolean boQ() {
        return false;
    }

    protected final boolean boR() {
        return false;
    }

    public final void D(Bundle bundle) {
    }
}
