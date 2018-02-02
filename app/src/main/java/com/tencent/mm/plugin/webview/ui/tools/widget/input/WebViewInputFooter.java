package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;

public final class WebViewInputFooter extends LinearLayout {
    private MMActivity fmM;
    private ImageButton jYB;
    private boolean okA = true;
    private int state = 0;
    public c tKS;
    public a tKT;
    public b tKU;
    private WebViewSmileyPanel tKV;
    private View tKW;
    private View tKX;
    private View tKY;
    MMEditText tKZ;
    private LinearLayout tLa;
    private boolean tLb;
    private int tLc = Integer.MAX_VALUE;

    public interface b {
        void aPs();

        void aPt();
    }

    static /* synthetic */ void a(WebViewInputFooter webViewInputFooter, boolean z) {
        Animation loadAnimation = AnimationUtils.loadAnimation(webViewInputFooter.getContext(), R.a.bqk);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(webViewInputFooter.getContext(), R.a.bql);
        loadAnimation.setDuration(150);
        loadAnimation2.setDuration(150);
        if (webViewInputFooter.tKX != null && webViewInputFooter.tKY != null) {
            if (z) {
                if (webViewInputFooter.tKX.getVisibility() != 8 && webViewInputFooter.tKX.getVisibility() != 4) {
                    webViewInputFooter.tKY.startAnimation(loadAnimation);
                    webViewInputFooter.tKY.setVisibility(0);
                    webViewInputFooter.tKX.startAnimation(loadAnimation2);
                    webViewInputFooter.tKX.setVisibility(8);
                } else {
                    return;
                }
            } else if (webViewInputFooter.tKX.getVisibility() != 0 && webViewInputFooter.tKX.getVisibility() != 0) {
                webViewInputFooter.tKX.startAnimation(loadAnimation);
                webViewInputFooter.tKX.setVisibility(0);
                webViewInputFooter.tKY.startAnimation(loadAnimation2);
                webViewInputFooter.tKY.setVisibility(8);
            } else {
                return;
            }
            webViewInputFooter.tKY.getParent().requestLayout();
        }
    }

    public WebViewInputFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmM = (MMActivity) context;
        ViewGroup viewGroup = (ViewGroup) View.inflate(this.fmM, R.i.cYM, this);
        this.tLa = (LinearLayout) viewGroup.findViewById(R.h.cYK);
        this.tKX = viewGroup.findViewById(R.h.cYO);
        this.tKY = viewGroup.findViewById(R.h.cYN);
        this.tKW = viewGroup.findViewById(R.h.cYP);
        this.tKZ = (MMEditText) viewGroup.findViewById(R.h.cYL);
        this.jYB = (ImageButton) viewGroup.findViewById(R.h.cYQ);
        this.jYB.setOnClickListener(new 1(this));
        this.tKZ.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ WebViewInputFooter tLd;

            {
                this.tLd = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.tLd.okA = false;
                this.tLd.tKV.setVisibility(8);
                this.tLd.jYB.setImageResource(R.g.bBn);
                this.tLd.state = 0;
                return false;
            }
        });
        this.tKV = new WebViewSmileyPanel(getContext());
        this.tKV.setVisibility(8);
        this.tKV.setBackgroundResource(R.g.bzY);
        WebViewSmileyPanel webViewSmileyPanel = this.tKV;
        webViewSmileyPanel.tLi = new 3(this);
        webViewSmileyPanel.tLf.tLm = webViewSmileyPanel.tLi;
        ((LinearLayout) findViewById(R.h.cIu)).addView(this.tKV, -1, 0);
        this.tKY.setOnClickListener(new 4(this));
        this.tKZ.addTextChangedListener(new 5(this));
    }

    private int bSH() {
        if (this.tKU != null) {
            this.tKU.aPs();
        }
        if (this.tKZ != null) {
            this.fmM.df(this.tKZ);
        }
        this.tKV.setVisibility(0);
        WebViewSmileyPanel webViewSmileyPanel = this.tKV;
        if (webViewSmileyPanel.Iv != null) {
            webViewSmileyPanel.Iv.setVisibility(0);
        }
        LayoutParams layoutParams = this.tKV.getLayoutParams();
        if (layoutParams != null && this.okA) {
            layoutParams.height = j.aQ(getContext());
            this.tKV.setLayoutParams(layoutParams);
        }
        if (layoutParams != null) {
            return layoutParams.height;
        }
        return 0;
    }

    private void hideSmileyPanel() {
        if (this.tKU != null) {
            this.tKU.aPt();
        }
        this.tKV.setVisibility(8);
        this.jYB.setImageResource(R.k.dBb);
        this.state = 0;
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bUT();
        if (!(this.tKZ == null || this.fmM == null)) {
            this.fmM.df(this.tKZ);
        }
        this.tKZ = null;
        WebViewSmileyPanel webViewSmileyPanel = this.tKV;
        c cVar = webViewSmileyPanel.tLf;
        cVar.tLl = null;
        cVar.kaK = null;
        if (webViewSmileyPanel.Iv != null) {
            ((ViewGroup) webViewSmileyPanel.Iv.getParent()).removeView(webViewSmileyPanel.Iv);
            ((ViewGroup) webViewSmileyPanel.Iv).removeAllViews();
            webViewSmileyPanel.Iv = null;
        }
        webViewSmileyPanel.kaY = null;
        removeAllViews();
        this.fmM = null;
        this.tKS = null;
    }

    public final void setText(String str) {
        this.tKZ.setText("");
        if (!bh.ov(str)) {
            try {
                this.tKZ.append(str);
            } catch (Exception e) {
                x.d("MicroMsg.WebViewInputFooter", "appendText, exp = %s", new Object[]{e});
            }
            x.d("MicroMsg.WebViewInputFooter", "after setText, editText.getText() = %s", new Object[]{this.tKZ.getText()});
        }
    }

    public final void Bg(int i) {
        if (i > 0) {
            this.tLc = i;
        }
    }

    private void bUT() {
        if (this.tKZ != null) {
            this.tKZ.clearFocus();
            this.tKZ.setFocusable(false);
            this.tKZ.setFocusableInTouchMode(false);
        }
    }

    public final void show() {
        setVisibility(0);
        if (this.tLa != null) {
            this.tLa.setVisibility(0);
        }
        if (this.tKZ != null) {
            this.tKZ.setEnabled(true);
            this.tKZ.setBackgroundResource(R.g.bDf);
        }
        if (this.tKW != null) {
            this.tKW.setVisibility(0);
        }
        this.tLb = false;
        if (this.tKZ != null) {
            this.tKZ.setFocusable(true);
            this.tKZ.setFocusableInTouchMode(true);
            this.tKZ.requestFocus();
        }
        if (this.fmM != null) {
            this.fmM.showVKB();
        }
        this.state = 0;
    }

    public final int bUU() {
        setVisibility(0);
        if (this.tLa != null) {
            this.tLa.setVisibility(8);
        }
        this.tLb = true;
        this.state = 1;
        return bSH();
    }

    public final void hide() {
        setVisibility(8);
        if (this.fmM != null) {
            if (this.tKZ != null) {
                this.fmM.df(this.tKZ);
            }
            this.fmM.aWs();
        }
        this.state = 0;
        hideSmileyPanel();
        bUT();
    }

    public final void bUV() {
        if (this.tLb) {
            setVisibility(8);
        }
        this.state = 0;
        hideSmileyPanel();
    }

    public final boolean isShown() {
        return getVisibility() == 0;
    }
}
