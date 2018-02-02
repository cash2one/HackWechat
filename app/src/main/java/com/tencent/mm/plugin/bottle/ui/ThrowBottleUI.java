package com.tencent.mm.plugin.bottle.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.media.ToneGenerator;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.bottle.a.h.a;
import com.tencent.mm.plugin.bottle.a.h.d;
import com.tencent.mm.plugin.bottle.ui.ThrowBottleAnimUI.1;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.z.ar;

public class ThrowBottleUI extends FrameLayout implements OnClickListener, a {
    private static final int[] kDX = new int[]{0, 9, 18, 27, 37, 46, 55, 64, 74, 85, 93, 100};
    private static final int[] kDY = new int[]{R.g.byJ, R.g.byM, R.g.byN, R.g.byO, R.g.byP, R.g.byQ, R.g.byR, R.g.byS, R.g.byT, R.g.byK, R.g.byL};
    af handler = new af();
    BottleBeachUI kCH;
    boolean kDT = true;
    d kDZ;
    ImageView kDe;
    ToneGenerator kEa;
    private long kEb = -1;
    Toast kEc;
    Vibrator kEd;
    ThrowBottleAnimUI kEe;
    AnimationDrawable kEf;
    ImageView kEg;
    TextView kEh;
    ImageView kEi;
    MMEditText kEj;
    View kEk;
    Button kEl;
    ImageButton kEm;
    ThrowBottleFooter kEn;
    boolean kEo = false;
    boolean kEp;
    LayoutParams kEq = null;
    private int kEr = 0;
    int kEs = 0;
    private ThrowBottleAnimUI.a kEt = new 4(this);
    final ak kEu = new ak(new 5(this), true);
    final ak kEv = new ak(new 6(this), true);
    boolean kEw = false;
    @SuppressLint({"HandlerLeak"})
    private final af kEx = new 8(this);
    final h.a kEy = new 9(this);

    public ThrowBottleUI(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kCH = (BottleBeachUI) context;
    }

    public void setVisibility(int i) {
        this.kDe.setVisibility(8);
        if (i == 0) {
            this.kDT = true;
            this.kEg.setVisibility(8);
            this.kEh.setVisibility(8);
            this.kEh.setWidth(b.b(this.kCH, 120.0f));
            this.kEi.setVisibility(0);
            ((View) this.kEj.getParent()).setVisibility(8);
            this.kEj.setText("");
            this.kEn.setVisibility(0);
            c.d(this.kEj).GN(com.tencent.mm.k.b.zz()).a(null);
            this.kEm.setImageDrawable(com.tencent.mm.bv.a.b(this.kCH, R.g.bBo));
            this.kEl.setBackgroundDrawable(com.tencent.mm.bv.a.b(this.kCH, R.g.bFg));
            this.kEl.setText(this.kDT ? R.l.dMY : R.l.dMV);
            ((LinearLayout) this.kCH.findViewById(R.h.bOK)).setVisibility(0);
            this.kCH.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        } else {
            this.kCH.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        super.setVisibility(i);
    }

    public void onClick(View view) {
        if (R.h.bNW != view.getId()) {
            this.kCH.nm(0);
        } else if (this.kDT || this.kEj.getText().toString().trim().length() <= 0) {
            asd();
        } else {
            com.tencent.mm.ui.base.h.a(this.kCH, getResources().getString(R.l.dMS), null, getResources().getString(R.l.dMT), new 3(this), null);
        }
    }

    private void asd() {
        boolean z;
        int i = 8;
        this.kEh.setVisibility(8);
        this.kEi.setVisibility(this.kDT ? 8 : 0);
        View view = (View) this.kEj.getParent();
        if (this.kDT) {
            i = 0;
        }
        view.setVisibility(i);
        if (this.kDT) {
            this.kEj.requestFocus();
        }
        if (this.kDT) {
            z = false;
        } else {
            z = true;
        }
        this.kDT = z;
        this.kEm.setImageDrawable(this.kDT ? com.tencent.mm.bv.a.b(this.kCH, R.g.bBo) : com.tencent.mm.bv.a.b(this.kCH, R.g.bBp));
        if (this.kDT) {
            dU(false);
        } else {
            dU(true);
        }
        this.kEl = (Button) this.kCH.findViewById(R.h.bOI);
        this.kEl.setText(this.kDT ? R.l.dMY : R.l.dMV);
    }

    private void ase() {
        int left;
        int i;
        int width;
        if (this.kDT) {
            left = this.kEh.getLeft();
            i = left;
            left = this.kEh.getTop();
            width = this.kEh.getWidth();
        } else {
            width = this.kEj.getLeft();
            left = this.kEj.getTop();
            i = width;
            width = 0;
        }
        this.kEe = (ThrowBottleAnimUI) this.kCH.findViewById(R.h.bOE);
        this.kEe.kDS = this.kEt;
        ThrowBottleAnimUI throwBottleAnimUI = this.kEe;
        throwBottleAnimUI.kDT = this.kDT;
        throwBottleAnimUI.Rn = i;
        throwBottleAnimUI.Ro = left;
        throwBottleAnimUI.kDR = width;
        throwBottleAnimUI.setVisibility(0);
        ag.h(new 1(throwBottleAnimUI), 100);
    }

    private void dU(boolean z) {
        if (z) {
            ((InputMethodManager) this.kCH.getSystemService("input_method")).showSoftInput(this.kEj, 0);
        } else {
            ((InputMethodManager) this.kCH.getSystemService("input_method")).hideSoftInputFromWindow(this.kEj.getWindowToken(), 2);
        }
    }

    public final boolean asf() {
        x.d("MM.Bottle.ThrowBottleUI", "bottle record stop");
        if (this.kEw) {
            boolean vo;
            this.kCH.getWindow().getDecorView().setKeepScreenOn(false);
            if (this.kEf != null) {
                this.kEf.stop();
            }
            if (this.kDZ != null) {
                vo = this.kDZ.vo();
                ae.Vd("keep_app_silent");
                this.kEu.TG();
                this.kEv.TG();
                this.kEb = -1;
            } else {
                vo = false;
            }
            if (vo) {
                ase();
            } else {
                this.kEl.setEnabled(false);
                this.kEl.setBackgroundDrawable(com.tencent.mm.bv.a.b(this.kCH, R.g.bFf));
                this.kEg.setVisibility(8);
                this.kEh.setVisibility(8);
                this.kEx.sendEmptyMessageDelayed(0, 500);
                ar.Hg();
                if (com.tencent.mm.z.c.isSDCardAvailable()) {
                    this.kCH.nl(R.l.dMU);
                }
            }
        }
        this.kEw = false;
        return false;
    }

    public final void cd(int i, int i2) {
        if (i2 == -2002) {
            this.kCH.nm(0);
            this.kCH.nl(R.l.dMC);
        }
    }
}
