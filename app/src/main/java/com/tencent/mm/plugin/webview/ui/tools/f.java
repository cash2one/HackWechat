package com.tencent.mm.plugin.webview.ui.tools;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;

public final class f implements b {
    static final int txU = R.g.bHQ;
    public boolean iMZ = false;
    a txQ;
    ImageView txR;
    LogoWebViewWrapper txS;
    int txT = 0;
    private boolean txV = false;
    private boolean txW = false;
    private int txX = 0;
    private float txY = 0.0f;
    private ValueAnimator txZ;
    private ViewPropertyAnimator tya;
    private float tyb;
    private View tyc;
    View tyd;
    private TextView tye;
    private boolean tyf = true;
    public boolean tyg = false;

    public final void cU(View view) {
        String str;
        this.txS = (LogoWebViewWrapper) view.findViewById(R.h.cux);
        this.txR = (ImageView) view.findViewById(R.h.cYT);
        this.tyc = view.findViewById(R.h.cYS);
        if (this.tyc != null) {
            this.tyd = this.tyc.findViewById(R.h.cZS);
            this.tye = (TextView) this.tyd.findViewById(R.h.cZU);
        }
        this.txT = BackwardSupportUtil.b.b(this.txS.getContext(), 72.0f);
        String str2 = "MicroMsg.WebViewPullDownLogoDelegate";
        String str3 = "refreshImage.id = %s, logoWrapper.id = %s";
        Object[] objArr = new Object[2];
        if (this.txR == null) {
            str = "null";
        } else {
            str = String.valueOf(this.txR.getId());
        }
        objArr[0] = str;
        if (this.txS == null) {
            str = "null";
        } else {
            str = String.valueOf(this.txS.getId());
        }
        objArr[1] = str;
        x.d(str2, str3, objArr);
        x.d("MicroMsg.WebViewPullDownLogoDelegate", "LOADING_LOGO_HEIGHT = %d", new Object[]{Integer.valueOf(this.txT)});
    }

    public final void b(MMWebView mMWebView) {
        mMWebView.zvH = this.txS;
        mMWebView.cyW();
        if (VERSION.SDK_INT <= 10) {
            this.txS.bSg().setBackgroundColor(this.txS.getResources().getColor(R.e.buh));
        }
        LogoWebViewWrapper logoWebViewWrapper = this.txS;
        logoWebViewWrapper.bSg();
        if (logoWebViewWrapper.twc != null) {
            logoWebViewWrapper.lbq = mMWebView;
            logoWebViewWrapper.twc.addView(logoWebViewWrapper.lbq);
        }
        CharSequence charSequence = "";
        if (mMWebView.isXWalkKernel() || mMWebView.isX5Kernel) {
            this.tyf = true;
        } else {
            this.tyf = false;
        }
        if (!(this.tyd == null || mMWebView.isX5Kernel)) {
            ((ImageView) this.tyd.findViewById(R.h.cZT)).setVisibility(8);
            ((TextView) this.tyd.findViewById(R.h.cpP)).setText(charSequence);
        }
        if (!this.tyf || this.tyg) {
            kr(true);
            return;
        }
        kr(false);
        if (this.tyd != null) {
            this.tyd.setVisibility(0);
        }
    }

    public final void bSu() {
        this.iMZ = false;
        stopLoading();
        if (this.tyf && this.tyd != null && !this.tyg) {
            kr(false);
            this.txS.twk = 0;
            this.tyd.setVisibility(0);
        }
    }

    public final void startLoading() {
        if (!this.txV && this.txR != null && this.txS != null) {
            this.txV = true;
            this.txS.kr(true);
            this.txR.clearAnimation();
            if (this.txZ != null) {
                this.txZ.cancel();
            }
            this.txZ = ObjectAnimator.ofFloat(this, "startLoadingStep", new float[]{this.txY + 0.0f, this.txY + 354.0f});
            this.txZ.setDuration(960);
            this.txZ.setRepeatMode(1);
            this.txZ.setRepeatCount(-1);
            this.txZ.setInterpolator(new LinearInterpolator());
            this.txZ.start();
            if (this.txQ != null) {
                this.txQ.bSw();
            }
        }
    }

    public final void stopLoading() {
        if (this.txV) {
            x.d("MicroMsg.WebViewPullDownLogoDelegate", "stopLoading()");
            this.txW = true;
            this.txV = false;
            if (this.txS != null && this.iMZ) {
                this.txS.kr(false);
            }
            if (this.txZ != null) {
                this.txZ.cancel();
            }
            if (this.txS != null) {
                this.txS.O(0, 250);
            }
            if (this.txR != null) {
                x.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage, alpha to 0f");
                this.txR.animate().alpha(0.0f).setDuration(500).start();
            }
        }
    }

    public final void release() {
        if (this.txS != null) {
            LogoWebViewWrapper logoWebViewWrapper = this.txS;
            if (logoWebViewWrapper.twc != null) {
                logoWebViewWrapper.twc.removeView(logoWebViewWrapper.lbq);
                logoWebViewWrapper.lbq = null;
            }
            logoWebViewWrapper = this.txS;
            logoWebViewWrapper.twm = null;
            logoWebViewWrapper.twl = null;
        }
        if (this.tyc != null) {
            ((ViewGroup) this.tyc).removeAllViews();
        }
        this.txS = null;
        this.txR = null;
        this.txX = 0;
        if (this.txZ != null) {
            this.txZ.cancel();
            this.txZ = null;
        }
    }

    public final void AF(int i) {
        if (this.tyc != null) {
            this.tyc.setBackgroundColor(i);
        }
    }

    public final void bSv() {
        if (this.tyd != null) {
            this.tyd.setVisibility(8);
        }
    }

    public final void S(int i, boolean z) {
        String str;
        String str2 = "MicroMsg.WebViewPullDownLogoDelegate";
        String str3 = "onOverScrollOffset, offset = %d, pointerDown = %b, refreshImage.visibility = %s, refreshImage.drawable = %s, refreshImage.alpha = %s";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Boolean.valueOf(z);
        if (this.txR == null) {
            str = "null";
        } else {
            str = String.valueOf(this.txR.getVisibility());
        }
        objArr[2] = str;
        if (this.txR == null) {
            str = "null";
        } else {
            str = this.txR.getDrawable().toString();
        }
        objArr[3] = str;
        if (this.txR == null) {
            str = "null";
        } else {
            str = String.valueOf(this.txR.getAlpha());
        }
        objArr[4] = str;
        x.v(str2, str3, objArr);
        if (this.iMZ) {
            if (i == 0) {
                this.txW = false;
            }
            if (this.txR != null) {
                if (z) {
                    if (Math.abs(i) >= this.txT) {
                        if (this.txS != null) {
                            this.txS.twk = this.txT;
                        }
                    } else if (this.txS != null) {
                        this.txS.twk = 0;
                    }
                } else if (Math.abs(i) > this.txT && !this.txV) {
                    x.d("MicroMsg.WebViewPullDownLogoDelegate", "startLoading()");
                    startLoading();
                    return;
                } else if (this.txV) {
                    return;
                }
                if (this.txR != null && this.txR.getAlpha() < 1.0f && this.tya == null && z) {
                    x.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage alpha to 1.0f");
                    this.tya = this.txR.animate().alpha(1.0f).setDuration(500);
                    this.tya.setListener(new 1(this));
                    this.tya.start();
                }
                if (!this.txW) {
                    int i2 = (-i) - this.txX;
                    if (Math.abs(i) >= this.txT) {
                        i2 *= 5;
                    } else {
                        i2 *= 2;
                    }
                    this.txX = -i;
                    float height = ((float) this.txR.getHeight()) / 2.0f;
                    float width = ((float) this.txR.getWidth()) / 2.0f;
                    this.txY -= (float) i2;
                    this.txR.setScaleType(ScaleType.MATRIX);
                    Matrix imageMatrix = this.txR.getImageMatrix();
                    imageMatrix.postRotate((float) (-i2), width, height);
                    this.txR.setImageMatrix(imageMatrix);
                    this.txR.setImageResource(txU);
                }
                this.txR.invalidate();
            }
        }
    }

    public final float getStartLoadingStep() {
        return this.tyb;
    }

    public final void setStartLoadingStep(float f) {
        float f2 = 0.0f;
        this.tyb = f;
        this.txR.setScaleType(ScaleType.MATRIX);
        Matrix imageMatrix = this.txR.getImageMatrix();
        float width = this.txR == null ? 0.0f : ((float) this.txR.getWidth()) / 2.0f;
        if (this.txR != null) {
            f2 = ((float) this.txR.getHeight()) / 2.0f;
        }
        imageMatrix.setRotate(f, width, f2);
        this.txY = f;
        this.txR.invalidate();
    }

    public final void kr(boolean z) {
        if (this.txS != null && this.txS.twi != z) {
            this.txS.kr(z);
            if (this.tyd != null) {
                this.tyd.setVisibility(8);
            }
            this.tyg = z;
        }
    }

    public final void Pk(String str) {
        if (!this.tyf || this.tyg) {
            kr(true);
            if (this.tyd != null && this.tyd.getVisibility() == 0) {
                this.tyd.setVisibility(8);
            }
        } else if (this.tye != null) {
            if (!bh.ov(str)) {
                if (!bh.ov(Uri.parse(str).getHost())) {
                    CharSequence string = this.tye.getContext().getString(R.l.eWX, new Object[]{r0});
                    this.tye.setVisibility(0);
                    this.tye.setText(string);
                    kr(false);
                    return;
                }
            }
            this.tye.setVisibility(8);
        }
    }
}
