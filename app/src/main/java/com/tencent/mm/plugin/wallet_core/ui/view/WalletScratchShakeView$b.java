package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.pluginsdk.k.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class WalletScratchShakeView$b extends View {
    private int jnM = 0;
    long kCU;
    int nmE;
    c oNJ;
    private Bitmap rlH;
    private Canvas sXE;
    Paint sXF;
    Drawable sXG;
    Paint sXH;
    Paint sXI;
    Path sXJ;
    Path sXK;
    private float sXL;
    private float sXM;
    private int[] sXN;
    private int sXO = -1;
    boolean sXP;
    boolean sXQ;
    float sXR;
    float sXS;
    int sXT;
    private boolean sXU;
    private boolean sXV = false;
    boolean sXW;
    private float sXX = 0.9f;
    final /* synthetic */ WalletScratchShakeView sXY;

    static /* synthetic */ void d(WalletScratchShakeView$b walletScratchShakeView$b) {
        if (walletScratchShakeView$b.sXW) {
            x.i("MicroMsg.WalletScratchShakeView", "onStartShake, already finish clear mask");
        } else if (!walletScratchShakeView$b.bNa()) {
            if (walletScratchShakeView$b.sXU) {
                walletScratchShakeView$b.sXS += (float) (walletScratchShakeView$b.getHeight() / 6);
                walletScratchShakeView$b.bNb();
            } else {
                walletScratchShakeView$b.sXR += (float) (walletScratchShakeView$b.getHeight() / 6);
                walletScratchShakeView$b.bNb();
            }
            walletScratchShakeView$b.sXU = !walletScratchShakeView$b.sXU;
            if (!walletScratchShakeView$b.sXP) {
                ag.h(new Runnable(walletScratchShakeView$b) {
                    final /* synthetic */ WalletScratchShakeView$b sXZ;

                    {
                        this.sXZ = r1;
                    }

                    public final void run() {
                        if (WalletScratchShakeView.a(this.sXZ.sXY) != null) {
                            WalletScratchShakeView.a(this.sXZ.sXY).jT(false);
                        }
                    }
                }, 50);
                walletScratchShakeView$b.sXP = true;
            }
            walletScratchShakeView$b.bNa();
        }
    }

    static /* synthetic */ void e(WalletScratchShakeView$b walletScratchShakeView$b) {
        int width = walletScratchShakeView$b.getWidth();
        int height = walletScratchShakeView$b.getHeight();
        walletScratchShakeView$b.rlH.getPixels(walletScratchShakeView$b.sXN, 0, width, 0, 0, width, height);
        float f = (float) (width * height);
        float f2 = 0.0f;
        for (int i = 0; ((float) i) < f; i++) {
            if (walletScratchShakeView$b.sXN[i] == 0) {
                f2 += 1.0f;
            }
        }
        f2 = (f2 < 0.0f || f <= 0.0f) ? 0.0f : f2 / f;
        x.i("MicroMsg.WalletScratchShakeView", "erasePercent: %s", new Object[]{Float.valueOf(f2)});
        x.i("MicroMsg.WalletScratchShakeView", "");
        if (f2 >= walletScratchShakeView$b.sXX) {
            walletScratchShakeView$b.sXW = true;
            if (!walletScratchShakeView$b.sXQ) {
                ag.y(new Runnable(walletScratchShakeView$b) {
                    final /* synthetic */ WalletScratchShakeView$b sXZ;

                    {
                        this.sXZ = r1;
                    }

                    public final void run() {
                        this.sXZ.animate().alpha(0.0f).setDuration(100);
                        if (WalletScratchShakeView.a(this.sXZ.sXY) != null) {
                            WalletScratchShakeView.a(this.sXZ.sXY).bMZ();
                        }
                    }
                });
                walletScratchShakeView$b.sXQ = true;
            }
        }
    }

    public WalletScratchShakeView$b(WalletScratchShakeView walletScratchShakeView, Context context) {
        this.sXY = walletScratchShakeView;
        super(context);
    }

    static byte[] K(Bitmap bitmap) {
        int i = 0;
        int[] iArr = new int[]{30, bitmap.getWidth() / 3, bitmap.getWidth() - (bitmap.getWidth() / 3), bitmap.getWidth() - 30};
        int[] iArr2 = new int[]{0, bitmap.getHeight()};
        ByteBuffer order = ByteBuffer.allocate(92).order(ByteOrder.nativeOrder());
        order.put((byte) 1);
        order.put((byte) 4);
        order.put((byte) 2);
        order.put((byte) 9);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(iArr[0]);
        order.putInt(iArr[1]);
        order.putInt(iArr[2]);
        order.putInt(iArr[3]);
        order.putInt(iArr2[0]);
        order.putInt(iArr2[1]);
        while (i < 9) {
            order.putInt(1);
            i++;
        }
        return order.array();
    }

    private boolean bNa() {
        if (this.sXS < ((float) getHeight())) {
            return false;
        }
        this.sXW = true;
        if (!this.sXQ) {
            if (WalletScratchShakeView.a(this.sXY) != null) {
                WalletScratchShakeView.a(this.sXY).bMZ();
            }
            this.sXQ = true;
        }
        if (this.sXE != null) {
            this.sXK.reset();
            this.sXK.moveTo(0.0f, 0.0f);
            this.sXK.lineTo((float) getWidth(), 0.0f);
            this.sXK.lineTo((float) getWidth(), (float) getHeight());
            this.sXK.lineTo(0.0f, (float) getHeight());
            this.sXE.drawPath(this.sXK, this.sXI);
        }
        invalidate();
        return true;
    }

    private void bNb() {
        if (this.sXE != null) {
            this.sXK.reset();
            this.sXK.moveTo(0.0f, this.sXS);
            this.sXK.cubicTo((float) (getWidth() / 2), (float) getHeight(), (float) (getWidth() / 2), 0.0f, (float) getWidth(), this.sXR);
            this.sXK.lineTo((float) getWidth(), 0.0f);
            this.sXK.lineTo(0.0f, 0.0f);
            this.sXE.drawPath(this.sXK, this.sXI);
        }
        invalidate();
    }

    protected final void onDraw(Canvas canvas) {
        canvas.save();
        if (this.rlH == null) {
            int width = getWidth();
            int height = getHeight();
            x.i("MicroMsg.WalletScratchShakeView", "createMasker width: %s, height: %s, waterMark: %s", new Object[]{Integer.valueOf(width), Integer.valueOf(height), this.sXG});
            this.rlH = Bitmap.createBitmap(width, height, Config.ARGB_8888);
            this.sXE = new Canvas(this.rlH);
            if (this.sXG != null) {
                this.sXG.setBounds(new Rect(0, 0, width, height));
                this.sXG.draw(this.sXE);
            }
            this.sXN = new int[(width * height)];
        }
        canvas.drawBitmap(this.rlH, 0.0f, 0.0f, this.sXF);
        canvas.restore();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!WalletScratchShakeView.b(this.sXY)) {
            return super.onTouchEvent(motionEvent);
        }
        boolean z = false;
        float x;
        float y;
        switch (motionEvent.getAction()) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.sXJ.reset();
                this.sXJ.moveTo(x, y);
                this.sXL = x;
                this.sXM = y;
                invalidate();
                if (!this.sXP) {
                    ag.h(new Runnable(this) {
                        final /* synthetic */ WalletScratchShakeView$b sXZ;

                        {
                            this.sXZ = r1;
                        }

                        public final void run() {
                            if (WalletScratchShakeView.a(this.sXZ.sXY) != null) {
                                WalletScratchShakeView.a(this.sXZ.sXY).jT(true);
                            }
                        }
                    }, 50);
                    this.sXP = true;
                    z = true;
                    break;
                }
            case 1:
            case 3:
                this.sXL = 0.0f;
                this.sXM = 0.0f;
                this.sXJ.reset();
                e.post(new Runnable(this) {
                    final /* synthetic */ WalletScratchShakeView$b sXZ;

                    {
                        this.sXZ = r1;
                    }

                    public final void run() {
                        WalletScratchShakeView$b.e(this.sXZ);
                    }
                }, "ScratchShakeView_calcErasePercentAndCallEnd");
                invalidate();
                z = true;
                break;
            case 2:
                x = motionEvent.getX();
                y = motionEvent.getY();
                if (this.sXE != null) {
                    int abs = (int) Math.abs(y - this.sXM);
                    if (((int) Math.abs(x - this.sXL)) >= this.nmE || abs >= this.nmE) {
                        this.sXL = x;
                        this.sXM = y;
                        this.sXJ.quadTo((this.sXL + x) / 2.0f, (this.sXM + y) / 2.0f, x, y);
                        this.sXE.drawPath(this.sXJ, this.sXH);
                        this.sXJ.reset();
                        this.sXJ.moveTo(this.sXL, this.sXM);
                    }
                }
                invalidate();
                z = true;
                break;
        }
        z = true;
        if (this.sXW || E(motionEvent) || !r0) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public final boolean E(MotionEvent motionEvent) {
        if (this.rlH != null && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3 || motionEvent.getAction() == 0)) {
            int width = getWidth();
            int height = getHeight();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int width2 = getWidth() * getHeight();
            x.d("MicroMsg.WalletScratchShakeView", "checkIsTouchEraseArea, x: %s, y: %s, width: %s, height: %s, index: %s, len: %s", new Object[]{Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()), Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf((y * width) + x), Integer.valueOf(width2)});
            if ((y * width) + x > 0 && x > 0 && y > 0 && x < getWidth() && y < getHeight()) {
                if (this.rlH.getPixel(x, y) == 0) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}
