package com.tencent.mm.plugin.scanner.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.plugin.scanner.util.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public abstract class i {
    protected ProgressDialog iln = null;
    protected TextView jCQ;
    GestureDetector lVX;
    protected Point mgY;
    protected long pXh;
    protected Rect pXi;
    protected b pXj;
    protected Point pXk;
    protected int pXl;
    protected int pXm;
    protected int pXn = 40;
    protected int pXo = 20;
    protected b pXp;
    protected int pXq;
    protected boolean pXr;
    protected af pXs = new 1(this);

    protected abstract void boL();

    protected abstract b boM();

    protected abstract int boN();

    protected abstract int boO();

    protected abstract void boP();

    protected abstract boolean boQ();

    protected abstract boolean boR();

    protected abstract void h(Rect rect);

    protected abstract void onDestroy();

    protected abstract void onResume();

    public final b bpn() {
        return this.pXp;
    }

    protected final void hI(boolean z) {
        if (this.jCQ != null) {
            if (z) {
                this.jCQ.setVisibility(4);
                this.pXs.sendEmptyMessageDelayed(1, 210);
                return;
            }
            this.pXs.removeMessages(1);
            this.jCQ.setVisibility(4);
        }
    }

    public i(b bVar, Point point) {
        this.pXp = bVar;
        this.pXk = point;
    }

    public i(b bVar, Point point, byte b) {
        this.pXp = bVar;
        this.pXk = point;
        this.pXn = 50;
    }

    protected void onPause() {
        if (this.iln != null && this.iln.isShowing()) {
            this.iln.dismiss();
        }
    }

    public final void e(Point point) {
        this.pXk = point;
    }

    protected void cr(View view) {
    }

    protected final double dl(int i, int i2) {
        Context context = this.pXp.getContext();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        double d = ((double) displayMetrics.densityDpi) / 160.0d;
        x.d("MicroMsg.scanner.ScanMode", "dpiLevel [%s]", new Object[]{Double.valueOf(d)});
        if (d > 1.2d) {
            if (this.pXk.x + this.pXk.y <= 3000 || d >= 2.4d) {
                this.pXl = BackwardSupportUtil.b.b(this.pXp.getContext(), (float) i);
                this.pXm = BackwardSupportUtil.b.b(this.pXp.getContext(), (float) i2);
            } else {
                this.pXl = BackwardSupportUtil.b.b(this.pXp.getContext(), ((float) i) * 1.6f);
                this.pXm = BackwardSupportUtil.b.b(this.pXp.getContext(), ((float) i2) * 1.6f);
                if (this instanceof j) {
                    int i3 = (int) (((double) this.pXk.y) * 0.8d);
                    int i4 = (int) (((double) this.pXk.x) * 0.8d);
                    if (this.pXl > i3 && this.pXm > i4) {
                        float f = DownloadHelper.SAVE_FATOR;
                        while (this.pXl > i3 && this.pXm > i4) {
                            this.pXl = BackwardSupportUtil.b.b(this.pXp.getContext(), ((float) i) * f);
                            this.pXm = BackwardSupportUtil.b.b(this.pXp.getContext(), ((float) i2) * f);
                            f -= 0.1f;
                        }
                        x.i("MicroMsg.scanner.ScanMode", "final adjust ratio: %s", new Object[]{Float.valueOf(f)});
                    }
                }
            }
        } else if (this.pXk != null && this.pXk.x + this.pXk.y > 1560) {
            this.pXl = BackwardSupportUtil.b.b(this.pXp.getContext(), ((float) i) * 1.7f);
            this.pXm = BackwardSupportUtil.b.b(this.pXp.getContext(), ((float) i2) * 1.7f);
        } else if (this.pXk == null || this.pXk.x + this.pXk.y <= 1460) {
            this.pXl = BackwardSupportUtil.b.b(this.pXp.getContext(), ((float) i) / 1.1f);
            this.pXm = BackwardSupportUtil.b.b(this.pXp.getContext(), ((float) i2) / 1.1f);
        } else {
            this.pXl = BackwardSupportUtil.b.b(this.pXp.getContext(), ((float) i) * 1.1f);
            this.pXm = BackwardSupportUtil.b.b(this.pXp.getContext(), ((float) i2) * 1.1f);
        }
        if (this.pXl % 2 == 1) {
            this.pXl++;
        }
        if (this.pXm % 2 == 1) {
            this.pXm++;
        }
        x.d("MicroMsg.scanner.ScanMode", "frame, width:%d, height:%d, visDisplayFrameRes:%s", new Object[]{Integer.valueOf(this.pXl), Integer.valueOf(this.pXm), this.pXk});
        return d;
    }

    protected final Rect y(boolean z, boolean z2) {
        if (this.pXi == null || z) {
            int i;
            int i2;
            int i3;
            int i4 = this.pXk.x;
            int i5 = this.pXk.y;
            int b = BackwardSupportUtil.b.b(this.pXp.getContext(), (float) this.pXn);
            if (this.pXp.bpa()) {
                i = b;
            } else {
                i = 0;
            }
            if (!z2) {
                i2 = (i4 / 2) - (this.pXl / 2);
                i3 = (this.pXl / 2) + (i4 / 2);
                b = (i5 / 2) - (this.pXm / 2);
                if (b - i > 0) {
                    b -= i;
                }
                i = b;
                b = this.pXm + b;
            } else if (i4 < i5) {
                i2 = (i5 / 2) - (this.pXl / 2);
                i3 = (i5 / 2) + (this.pXl / 2);
                i = BackwardSupportUtil.b.b(this.pXp.getContext(), (float) this.pXo);
                b = this.pXm + i;
            } else {
                i2 = (i4 / 2) - (this.pXl / 2);
                i3 = (i4 / 2) + (this.pXl / 2);
                i = BackwardSupportUtil.b.b(this.pXp.getContext(), (float) this.pXo);
                b = this.pXm + i;
            }
            x.d("MicroMsg.scanner.ScanMode", "framingRect: width = %s, height = %s; left = %s, right = %s, top = %s, bottom = %s", new Object[]{Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(b)});
            this.pXi = new Rect(i2, i, i3, b);
        }
        return this.pXi;
    }

    protected Rect hJ(boolean z) {
        return y(true, z);
    }

    protected void f(Point point) {
        this.mgY = point;
    }

    public final void hK(boolean z) {
        if (this.jCQ != null) {
            this.jCQ.setVisibility(z ? 0 : 4);
        }
    }

    protected void a(byte[] bArr, Point point, int i, Rect rect) {
        x.i("MicroMsg.scanner.ScanMode", "decode count:" + l.pST.pSW);
        if (boM() != null) {
            boM().a(bArr, point, i, rect);
            if (l.pST.pSW == 30) {
                this.pXp.bpe();
            }
        }
    }
}
