package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.c.a;
import com.tencent.mm.ui.tools.s;
import com.tencent.smtt.sdk.WebView;

public class LauncherUIBottomTabView extends RelativeLayout implements c {
    protected int mjz = 0;
    private long nty = 0;
    private int xHA = 0;
    private int xHB = 0;
    private int xHC = 0;
    private boolean xHD = false;
    private int xHE = 0;
    private boolean xHF = false;
    private a xHg;
    protected a xHh;
    protected a xHi;
    protected a xHj;
    protected a xHk;
    private int xHl = 0;
    private int xHm;
    private int xHn;
    private int xHo;
    private int xHp = 0;
    private int xHq;
    private int xHr;
    private int xHs;
    private int xHt;
    private int xHu;
    private int xHv;
    private int xHw = -1;
    private int xHx = 0;
    protected OnClickListener xHy = new 1(this);
    private af xHz = new 2(this);

    public LauncherUIBottomTabView(Context context) {
        super(context);
        init();
    }

    public LauncherUIBottomTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LauncherUIBottomTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public final void a(a aVar) {
        this.xHg = aVar;
    }

    private a DM(int i) {
        a aVar = new a(this);
        if (com.tencent.mm.bv.a.ey(getContext())) {
            aVar.xHH = b.DY().a((Activity) getContext(), "R.layout.mm_bottom_tabitem_large", R.i.dnr);
        } else {
            aVar.xHH = b.DY().a((Activity) getContext(), "R.layout.mm_bottom_tabitem", R.i.dnq);
        }
        aVar.xHI = (TabIconView) aVar.xHH.findViewById(R.h.coO);
        aVar.xHJ = (TextView) aVar.xHH.findViewById(R.h.coQ);
        aVar.xHK = (TextView) aVar.xHH.findViewById(R.h.cTN);
        aVar.xHK.setBackgroundResource(s.gd(getContext()));
        aVar.xHL = (ImageView) aVar.xHH.findViewById(R.h.cct);
        aVar.xHH.setTag(Integer.valueOf(i));
        aVar.xHH.setOnClickListener(this.xHy);
        aVar.xHJ.setTextSize(0, ((float) com.tencent.mm.bv.a.ab(getContext(), R.f.bvW)) * com.tencent.mm.bv.a.ew(getContext()));
        return aVar;
    }

    private void init() {
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        addView(linearLayout, new LayoutParams(-1, -2));
        this.xHx = (int) (((float) com.tencent.mm.bv.a.ab(getContext(), R.f.buH)) * com.tencent.mm.bv.a.ew(getContext()));
        a DM = DM(0);
        DM.xHH.setId(-16777215);
        DM.xHJ.setText(R.l.euB);
        DM.xHJ.setTextColor(getResources().getColor(R.e.bto));
        DM.xHI.g(R.k.dzj, R.k.dzk, R.k.dzl, com.tencent.mm.bv.a.ey(getContext()));
        DM.xHK.setVisibility(4);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, this.xHx);
        layoutParams.weight = 1.0f;
        linearLayout.addView(DM.xHH, layoutParams);
        this.xHh = DM;
        DM = DM(1);
        DM.xHH.setId(-16777214);
        DM.xHJ.setText(R.l.eub);
        DM.xHJ.setTextColor(getResources().getColor(R.e.btp));
        DM.xHI.g(R.k.dzg, R.k.dzh, R.k.dzi, com.tencent.mm.bv.a.ey(getContext()));
        DM.xHK.setVisibility(4);
        layoutParams = new LinearLayout.LayoutParams(0, this.xHx);
        layoutParams.weight = 1.0f;
        linearLayout.addView(DM.xHH, layoutParams);
        this.xHj = DM;
        DM = DM(2);
        DM.xHH.setId(-16777213);
        DM.xHJ.setText(R.l.etZ);
        DM.xHJ.setTextColor(getResources().getColor(R.e.btp));
        DM.xHI.g(R.k.dzm, R.k.dzn, R.k.dzo, com.tencent.mm.bv.a.ey(getContext()));
        DM.xHK.setVisibility(4);
        layoutParams = new LinearLayout.LayoutParams(0, this.xHx);
        layoutParams.weight = 1.0f;
        linearLayout.addView(DM.xHH, layoutParams);
        this.xHi = DM;
        DM = DM(3);
        DM.xHH.setId(-16777212);
        DM.xHJ.setText(R.l.euz);
        DM.xHJ.setTextColor(getResources().getColor(R.e.btp));
        DM.xHI.g(R.k.dzp, R.k.dzq, R.k.dzr, com.tencent.mm.bv.a.ey(getContext()));
        DM.xHK.setVisibility(4);
        layoutParams = new LinearLayout.LayoutParams(0, this.xHx);
        layoutParams.weight = 1.0f;
        linearLayout.addView(DM.xHH, layoutParams);
        this.xHk = DM;
        this.xHl = getResources().getColor(R.e.bto);
        this.xHm = (this.xHl & 16711680) >> 16;
        this.xHn = (this.xHl & 65280) >> 8;
        this.xHo = this.xHl & 255;
        this.xHp = getResources().getColor(R.e.btp);
        this.xHq = (this.xHp & 16711680) >> 16;
        this.xHr = (this.xHp & 65280) >> 8;
        this.xHs = this.xHp & 255;
        this.xHt = this.xHm - this.xHq;
        this.xHu = this.xHn - this.xHr;
        this.xHv = this.xHo - this.xHs;
    }

    public final void DH(int i) {
        x.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", new Object[]{Integer.valueOf(i)});
        this.xHA = i;
        if (i <= 0) {
            this.xHh.xHK.setText("");
            this.xHh.xHK.setVisibility(4);
        } else if (i > 99) {
            this.xHh.xHK.setText(getContext().getString(R.l.eRP));
            this.xHh.xHK.setVisibility(0);
            this.xHh.xHL.setVisibility(4);
        } else {
            this.xHh.xHK.setText(String.valueOf(i));
            this.xHh.xHK.setVisibility(0);
            this.xHh.xHL.setVisibility(4);
        }
    }

    public final void clG() {
        if (this.xHh != null && this.xHj != null && this.xHi != null) {
        }
    }

    public final void DI(int i) {
        this.xHB = i;
        if (i <= 0) {
            this.xHj.xHK.setText("");
            this.xHj.xHK.setVisibility(4);
        } else if (i > 99) {
            this.xHj.xHK.setText(getContext().getString(R.l.eRP));
            this.xHj.xHK.setVisibility(0);
            this.xHj.xHL.setVisibility(4);
        } else {
            this.xHj.xHK.setText(String.valueOf(i));
            this.xHj.xHK.setVisibility(0);
            this.xHj.xHL.setVisibility(4);
        }
    }

    public final void DJ(int i) {
        this.xHC = i;
        if (i <= 0) {
            this.xHi.xHK.setText("");
            this.xHi.xHK.setVisibility(4);
        } else if (i > 99) {
            this.xHi.xHK.setText(getContext().getString(R.l.eRP));
            this.xHi.xHK.setVisibility(0);
            this.xHi.xHL.setVisibility(4);
        } else {
            this.xHi.xHK.setText(String.valueOf(i));
            this.xHi.xHK.setVisibility(0);
            this.xHi.xHL.setVisibility(4);
        }
    }

    public final void lM(boolean z) {
        int i = 4;
        this.xHD = z;
        this.xHi.xHK.setVisibility(4);
        ImageView imageView = this.xHi.xHL;
        if (z) {
            i = 0;
        }
        imageView.setVisibility(i);
    }

    public final void DK(int i) {
        this.xHE = i;
        if (i <= 0) {
            this.xHk.xHK.setText("");
            this.xHk.xHK.setVisibility(4);
        } else if (i > 99) {
            this.xHk.xHK.setText(getContext().getString(R.l.eRP));
            this.xHk.xHK.setVisibility(0);
            this.xHk.xHL.setVisibility(4);
        } else {
            this.xHk.xHK.setText(String.valueOf(i));
            this.xHk.xHK.setVisibility(0);
            this.xHk.xHL.setVisibility(4);
        }
    }

    public final void lN(boolean z) {
        int i = 4;
        this.xHF = z;
        this.xHk.xHK.setVisibility(4);
        ImageView imageView = this.xHk.xHL;
        if (z) {
            i = 0;
        }
        imageView.setVisibility(i);
    }

    public final void h(int i, float f) {
        int i2 = (int) (255.0f * f);
        int i3 = 255 - i2;
        int i4 = (((((int) ((((float) this.xHt) * f) + ((float) this.xHq))) << 16) + (((int) ((((float) this.xHu) * f) + ((float) this.xHr))) << 8)) + ((int) ((((float) this.xHv) * f) + ((float) this.xHs)))) + WebView.NIGHT_MODE_COLOR;
        int i5 = (((((int) ((((float) this.xHt) * (1.0f - f)) + ((float) this.xHq))) << 16) + (((int) ((((float) this.xHu) * (1.0f - f)) + ((float) this.xHr))) << 8)) + ((int) ((((float) this.xHv) * (1.0f - f)) + ((float) this.xHs)))) + WebView.NIGHT_MODE_COLOR;
        switch (i) {
            case 0:
                this.xHh.xHI.Ed(i3);
                this.xHj.xHI.Ed(i2);
                this.xHh.xHJ.setTextColor(i5);
                this.xHj.xHJ.setTextColor(i4);
                return;
            case 1:
                this.xHj.xHI.Ed(i3);
                this.xHi.xHI.Ed(i2);
                this.xHj.xHJ.setTextColor(i5);
                this.xHi.xHJ.setTextColor(i4);
                return;
            case 2:
                this.xHi.xHI.Ed(i3);
                this.xHk.xHI.Ed(i2);
                this.xHi.xHJ.setTextColor(i5);
                this.xHk.xHJ.setTextColor(i4);
                return;
            default:
                return;
        }
    }

    public final int clN() {
        return this.mjz;
    }

    public final void oV(int i) {
        this.mjz = i;
        switch (i) {
            case 0:
                this.xHh.xHI.Ed(255);
                this.xHi.xHI.Ed(0);
                this.xHj.xHI.Ed(0);
                this.xHk.xHI.Ed(0);
                this.xHh.xHJ.setTextColor(this.xHl);
                this.xHi.xHJ.setTextColor(this.xHp);
                this.xHj.xHJ.setTextColor(this.xHp);
                this.xHk.xHJ.setTextColor(this.xHp);
                break;
            case 1:
                this.xHh.xHI.Ed(0);
                this.xHi.xHI.Ed(0);
                this.xHj.xHI.Ed(255);
                this.xHk.xHI.Ed(0);
                this.xHh.xHJ.setTextColor(this.xHp);
                this.xHi.xHJ.setTextColor(this.xHp);
                this.xHj.xHJ.setTextColor(this.xHl);
                this.xHk.xHJ.setTextColor(this.xHp);
                break;
            case 2:
                this.xHh.xHI.Ed(0);
                this.xHi.xHI.Ed(255);
                this.xHj.xHI.Ed(0);
                this.xHk.xHI.Ed(0);
                this.xHh.xHJ.setTextColor(this.xHp);
                this.xHi.xHJ.setTextColor(this.xHl);
                this.xHj.xHJ.setTextColor(this.xHp);
                this.xHk.xHJ.setTextColor(this.xHp);
                break;
            case 3:
                this.xHh.xHI.Ed(0);
                this.xHi.xHI.Ed(0);
                this.xHj.xHI.Ed(0);
                this.xHk.xHI.Ed(255);
                this.xHh.xHJ.setTextColor(this.xHp);
                this.xHi.xHJ.setTextColor(this.xHp);
                this.xHj.xHJ.setTextColor(this.xHp);
                this.xHk.xHJ.setTextColor(this.xHl);
                break;
        }
        this.nty = System.currentTimeMillis();
        this.xHw = this.mjz;
    }

    public final int clH() {
        return this.xHA;
    }

    public final int clI() {
        return this.xHB;
    }

    public final int clJ() {
        return this.xHC;
    }

    public final int clK() {
        return this.xHE;
    }

    public final boolean clL() {
        return this.xHD;
    }

    public final boolean clM() {
        return this.xHF;
    }
}
