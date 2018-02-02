package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

public class LauncherUITabView extends RelativeLayout implements c {
    protected int mjz = 0;
    private long nty = 0;
    private Matrix oeO = new Matrix();
    private int xHA = 0;
    private int xHB = 0;
    private int xHC = 0;
    private boolean xHD = false;
    private int xHE = 0;
    private boolean xHF = false;
    private int xHO;
    private Bitmap xHP;
    private ImageView xHQ;
    protected a xHR;
    protected a xHS;
    protected a xHT;
    protected a xHU;
    private com.tencent.mm.ui.c.a xHg;
    private int xHw = -1;
    protected OnClickListener xHy = new 1(this);
    private af xHz = new 2(this);

    protected class a {
        final /* synthetic */ LauncherUITabView xHV;
        MMTabView xHW;

        protected a(LauncherUITabView launcherUITabView) {
            this.xHV = launcherUITabView;
        }
    }

    public LauncherUITabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LauncherUITabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public final void a(com.tencent.mm.ui.c.a aVar) {
        this.xHg = aVar;
    }

    private a DN(int i) {
        a aVar = new a(this);
        aVar.xHW = new MMTabView(getContext(), i);
        aVar.xHW.setTag(Integer.valueOf(i));
        aVar.xHW.setOnClickListener(this.xHy);
        return aVar;
    }

    private void init() {
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundResource(R.e.white);
        linearLayout.setId(2307141);
        linearLayout.setOrientation(0);
        addView(linearLayout, new LayoutParams(-1, -2));
        this.xHQ = new ImageView(getContext());
        this.xHQ.setImageMatrix(this.oeO);
        this.xHQ.setScaleType(ScaleType.MATRIX);
        this.xHQ.setId(2307142);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, com.tencent.mm.bv.a.fromDPToPix(getContext(), 3));
        layoutParams.addRule(8, 2307141);
        addView(this.xHQ, layoutParams);
        a DN = DN(0);
        DN.xHW.setText(R.l.eua);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.byg));
        layoutParams2.weight = 1.0f;
        linearLayout.addView(DN.xHW, layoutParams2);
        this.xHR = DN;
        DN = DN(1);
        DN.xHW.setText(R.l.eub);
        layoutParams2 = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.byg));
        layoutParams2.weight = 1.0f;
        linearLayout.addView(DN.xHW, layoutParams2);
        this.xHS = DN;
        DN = DN(2);
        DN.xHW.setText(R.l.etZ);
        layoutParams2 = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.byg));
        layoutParams2.weight = 1.0f;
        linearLayout.addView(DN.xHW, layoutParams2);
        this.xHT = DN;
        DN = DN(3);
        DN.xHW.setText(R.l.euz);
        layoutParams2 = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.byg));
        layoutParams2.weight = 1.0f;
        linearLayout.addView(DN.xHW, layoutParams2);
        this.xHU = DN;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        x.d("MicroMsg.LauncherUITabView", "on layout, width %d", new Object[]{Integer.valueOf(i3 - i)});
        this.xHO = (i3 - i) / 4;
        int i5 = this.xHO;
        if (this.xHP == null || this.xHP.getWidth() != i5) {
            String str = "MicroMsg.LauncherUITabView";
            String str2 = "sharp width changed, from %d to %d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.xHP == null ? -1 : this.xHP.getWidth());
            objArr[1] = Integer.valueOf(i5);
            x.w(str, str2, objArr);
            this.xHP = Bitmap.createBitmap(i5, com.tencent.mm.bv.a.fromDPToPix(getContext(), 3), Config.ARGB_8888);
            new Canvas(this.xHP).drawColor(getResources().getColor(R.e.bui));
            h(this.mjz, 0.0f);
            this.xHQ.setImageBitmap(this.xHP);
        }
        oV(this.mjz);
    }

    public final void DH(int i) {
        x.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", new Object[]{Integer.valueOf(i)});
        this.xHA = i;
        if (i <= 0) {
            this.xHR.xHW.Yo(null);
        } else if (i > 99) {
            this.xHR.xHW.Yo(getContext().getString(R.l.eRP));
        } else {
            this.xHR.xHW.Yo(String.valueOf(i));
        }
    }

    public final void clG() {
        if (this.xHR != null && this.xHS != null && this.xHT != null && this.xHU != null) {
            this.xHR.xHW.cne();
            this.xHS.xHW.cne();
            this.xHT.xHW.cne();
            this.xHU.xHW.cne();
        }
    }

    public final void DI(int i) {
        this.xHB = i;
        if (i <= 0) {
            this.xHS.xHW.Yo(null);
        } else if (i > 99) {
            this.xHS.xHW.Yo(getContext().getString(R.l.eRP));
        } else {
            this.xHS.xHW.Yo(String.valueOf(i));
        }
    }

    public final void DJ(int i) {
        this.xHC = i;
        if (i <= 0) {
            this.xHT.xHW.Yo(null);
        } else if (i > 99) {
            this.xHT.xHW.Yo(getContext().getString(R.l.eRP));
        } else {
            this.xHT.xHW.Yo(String.valueOf(i));
        }
    }

    public final void DK(int i) {
        this.xHE = i;
        if (i <= 0) {
            this.xHU.xHW.Yo(null);
        } else if (i > 99) {
            this.xHU.xHW.Yo(getContext().getString(R.l.eRP));
        } else {
            this.xHU.xHW.Yo(String.valueOf(i));
        }
    }

    public final void lM(boolean z) {
        this.xHD = z;
        this.xHT.xHW.lX(z);
    }

    public final void lN(boolean z) {
        this.xHF = z;
        this.xHU.xHW.lX(z);
    }

    public final void h(int i, float f) {
        this.oeO.setTranslate(((float) this.xHO) * (((float) i) + f), 0.0f);
        this.xHQ.setImageMatrix(this.oeO);
    }

    public final int clN() {
        return this.mjz;
    }

    public final void oV(int i) {
        this.mjz = i;
        this.xHR.xHW.setTextColor(i == 0 ? getResources().getColorStateList(R.e.bui) : getResources().getColorStateList(R.e.bsX));
        this.xHS.xHW.setTextColor(i == 1 ? getResources().getColorStateList(R.e.bui) : getResources().getColorStateList(R.e.bsX));
        this.xHT.xHW.setTextColor(i == 2 ? getResources().getColorStateList(R.e.bui) : getResources().getColorStateList(R.e.bsX));
        this.xHU.xHW.setTextColor(i == 3 ? getResources().getColorStateList(R.e.bui) : getResources().getColorStateList(R.e.bsX));
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
