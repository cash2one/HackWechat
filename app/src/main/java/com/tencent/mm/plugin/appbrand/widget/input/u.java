package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.i;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyPanelBase;
import com.tencent.mm.plugin.appbrand.widget.input.s.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public class u extends LinearLayout implements a {
    private static final b jYH = new f((byte) 0);
    private static final int jau = g.iuo;
    private MMActivity fmM;
    private View jYA;
    private ImageButton jYB;
    private boolean jYC;
    private View jYD;
    private boolean jYE;
    public EditText jYF;
    private int jYG = 0;
    private final Runnable jYu = new 1(this);
    d jYv;
    c jYw;
    private boolean jYx = false;
    public e jYy;
    private AppBrandSmileyPanel jYz;
    private int state = 2;

    interface b {
        void c(u uVar, int i);

        void k(u uVar);

        void l(u uVar);

        void m(u uVar);

        void n(u uVar);
    }

    public interface c {
        void ds(boolean z);
    }

    static /* synthetic */ void b(u uVar) {
        x.v("MicroMsg.AppBrandSmileyPanelWrapper", "[scrollUp] forceMeasurePanel enter");
        uVar.jYz.requestLayout();
    }

    public static u bY(View view) {
        return (u) view.getRootView().findViewById(jau);
    }

    public static u bZ(View view) {
        l bS = l.bS(view);
        if (bS.jXF == null || !(bS.jXF instanceof s)) {
            bS.jXF = new s();
        }
        u bY = bY(view);
        if (bY != null) {
            return bY;
        }
        View uVar = new u(view.getContext());
        bS.bT(uVar);
        return uVar;
    }

    public final void lX(int i) {
        jYH.c(this, i);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        x.v("MicroMsg.AppBrandSmileyPanelWrapper", "[scrollUp] SoftKeyboardPanel onLayout measuredHeight = %d", new Object[]{Integer.valueOf(getMeasuredHeight())});
    }

    public final void dw(boolean z) {
        x.d("MicroMsg.AppBrandSmileyPanelWrapper", "onKeyboardStateChanged, kbShown = %b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            mb(0);
            hideSmileyPanel();
        } else if (!isShown()) {
        } else {
            if (this.jYC && 1 == this.state) {
                amW();
            } else {
                hide();
            }
        }
    }

    private void lY(int i) {
        Object obj;
        AppBrandSmileyPanel appBrandSmileyPanel = this.jYz;
        if (i <= 0 || appBrandSmileyPanel.jYt == i) {
            obj = null;
        } else {
            appBrandSmileyPanel.jYt = i;
            obj = 1;
        }
        if (obj != null) {
            this.jYu.run();
        }
    }

    public int getMinimumHeight() {
        return getVisibility() == 0 ? com.tencent.mm.bv.a.fromDPToPix(getContext(), 48) : 0;
    }

    protected final void ds(boolean z) {
        if (!this.jYx && this.jYw != null) {
            this.jYx = true;
            this.jYw.ds(z);
            this.jYx = false;
        }
    }

    public u(Context context) {
        super(context);
        this.fmM = (MMActivity) context;
        super.setId(jau);
        setOrientation(1);
        View aeZ = aeZ();
        this.jYA = aeZ;
        addView(aeZ);
        this.jYz = new AppBrandSmileyPanel(getContext());
        this.jYz.setVisibility(8);
        this.jYz.setBackgroundColor(0);
        AppBrandSmileyPanelBase appBrandSmileyPanelBase = this.jYz;
        appBrandSmileyPanelBase.kaX = new 4(this);
        appBrandSmileyPanelBase.kaL.kbe = appBrandSmileyPanelBase.kaX;
        addView(this.jYz);
        aeV();
    }

    public void setId(int i) {
    }

    public final void lZ(int i) {
        super.setId(i);
    }

    public <T extends View & a> T aeZ() {
        T gVar = new g(getContext());
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842913}, ac.getResources().getDrawable(i.dBc));
        stateListDrawable.addState(new int[0], ac.getResources().getDrawable(i.dBb));
        this.jYB = (ImageButton) gVar.findViewById(g.iww);
        this.jYB.setSelected(false);
        this.jYB.setImageDrawable(stateListDrawable);
        this.jYB.setOnClickListener(new 2(this));
        this.jYD = gVar.findViewById(g.iwv);
        this.jYD.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ u jYI;

            {
                this.jYI = r1;
            }

            public final void onClick(View view) {
                this.jYI.ds(true);
            }
        });
        return gVar;
    }

    private void amT() {
        ((s) l.bS(this).jXF).jYo = this;
    }

    private void amU() {
        ((s) l.bS(this).jXF).jYo = null;
    }

    private void ma(int i) {
        post(new 5(this, i, this.jYx));
    }

    private void amV() {
        hideSmileyPanel();
        if (this.jYF != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.jYF.getContext().getSystemService("input_method");
            if (!inputMethodManager.showSoftInput(this.jYF, 1)) {
                inputMethodManager.showSoftInput(this.jYF, 2);
                return;
            }
            return;
        }
        this.fmM.showVKB();
    }

    private void amW() {
        jYH.l(this);
        if (this.jYB != null) {
            this.jYB.setSelected(true);
        }
        ma(1);
    }

    private void hideSmileyPanel() {
        jYH.k(this);
        if (this.jYB != null) {
            this.jYB.setSelected(false);
        }
        ma(0);
    }

    public void aeV() {
        boolean z = false;
        if (this.jYA != null) {
            a aVar = (a) this.jYA;
            if (((!this.jYC ? 1 : 0) & (!this.jYE ? 1 : 0)) != 0 || j.bK(this)) {
                z = true;
            }
            aVar.cF(z);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        x.d("MicroMsg.AppBrandSmileyPanelWrapper", "smileyPanelWrapper, onMeasure");
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        amT();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mb(8);
        if (this.fmM != null) {
            if (this.jYF != null) {
                this.fmM.df(this.jYF);
            } else {
                this.fmM.aWs();
            }
        }
        AppBrandSmileyPanelBase appBrandSmileyPanelBase = this.jYz;
        com.tencent.mm.plugin.appbrand.widget.input.panel.c cVar = appBrandSmileyPanelBase.kaL;
        cVar.kbd = null;
        cVar.kaK = null;
        if (appBrandSmileyPanelBase.Iv != null) {
            ((ViewGroup) appBrandSmileyPanelBase.Iv.getParent()).removeView(appBrandSmileyPanelBase.Iv);
            ((ViewGroup) appBrandSmileyPanelBase.Iv).removeAllViews();
            appBrandSmileyPanelBase.Iv = null;
        }
        appBrandSmileyPanelBase.kaY = null;
        if (this.jYB != null) {
            this.jYB.setOnClickListener(null);
        }
        this.jYv = null;
        removeAllViews();
        this.fmM = null;
        amU();
    }

    public void setVisibility(int i) {
        if (i == 8) {
            if (getVisibility() != i) {
                ds(false);
            }
            hide();
        } else if (i == 0) {
            show();
        } else {
            mb(i);
        }
    }

    final void mb(int i) {
        if (i == 0 && j.bK(this)) {
            i = 8;
        }
        if (getVisibility() != i) {
            super.setVisibility(i);
            if (i == 0) {
                amT();
            } else {
                amU();
            }
        }
    }

    public final void amX() {
        int i = 0;
        this.jYC = false;
        if (this.jYB != null) {
            ImageButton imageButton = this.jYB;
            if (!this.jYC) {
                i = 4;
            }
            imageButton.setVisibility(i);
        }
        aeV();
    }

    public final void dx(boolean z) {
        this.jYE = z;
        if (this.jYD != null) {
            this.jYD.setVisibility(this.jYE ? 0 : 4);
        }
        aeV();
    }

    public EditText aeY() {
        return this.jYF;
    }

    public final void b(EditText editText) {
        if (editText == this.jYF) {
            this.jYF = null;
        }
    }

    public void aeW() {
        amX();
        dx(this.jYE);
        aeV();
    }

    public void show() {
        amV();
        aeW();
        if (!isShown()) {
            mb(0);
        }
        lY(com.tencent.mm.compatible.util.j.aQ(getContext()));
    }

    public final void hide() {
        if (isShown()) {
            mb(8);
            if (!(this.fmM == null || this.fmM.mController.hideVKB())) {
                af.cd(this).hideSoftInputFromWindow(getWindowToken(), 0);
            }
            hideSmileyPanel();
        }
    }
}
