package com.tencent.mm.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.bu.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.m.a$e;
import com.tencent.mm.plugin.m.a$f;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.f;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.HorizontalListViewV2;
import com.tencent.mm.view.a.e;
import com.tencent.mm.view.e.a.3;
import com.tencent.mm.view.e.a.a;
import com.tencent.mm.view.f.a.1;
import java.util.Iterator;

public class SmileyPanelImpl extends SmileyPanel implements a {
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanel";
    private boolean jYL = false;
    private com.tencent.mm.view.e.a zDr;
    private com.tencent.mm.view.f.a zDs;

    public SmileyPanelImpl(Context context) {
        super(context, null);
        init();
    }

    public SmileyPanelImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.zDs = new com.tencent.mm.view.f.a();
        this.zDr = new com.tencent.mm.view.e.a(getContext(), this.zDs, this);
    }

    public final void onResume() {
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onResume");
        com.tencent.mm.view.f.a aVar = this.zDs;
        aVar.zGL = true;
        aVar.cBe();
        aVar.cAV();
        com.tencent.mm.view.e.a aVar2 = this.zDr;
        aVar2.cAN();
        aVar2.cAP();
    }

    public final void onPause() {
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onPause");
        this.zDs.onPause();
    }

    public final void destroy() {
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onDestroy");
        this.vjB = null;
        if (this.zDr != null) {
            x.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "ui clear");
            com.tencent.mm.view.e.a aVar = this.zDr;
            aVar.cAM();
            aVar.kaK = null;
            if (aVar.zFZ != null) {
                aVar.zFZ.a(null);
            }
            x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager destroy remove listener.");
            ((c) g.k(c.class)).getProvider().h(aVar.zGp);
            ((c) g.k(c.class)).getProvider().f(aVar.lxe);
            com.tencent.mm.sdk.b.a.xef.c(aVar.lxf);
            this.zDr = null;
        }
        if (this.zDs != null) {
            x.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "stg clear");
            this.zDs.onPause();
            com.tencent.mm.view.f.a aVar2 = this.zDs;
            Iterator it = aVar2.zGS.iterator();
            while (it.hasNext()) {
                com.tencent.mm.view.c.a aVar3 = (com.tencent.mm.view.c.a) it.next();
                if (aVar3 != null) {
                    aVar3.zDs = null;
                    aVar3.zFQ = null;
                }
            }
            aVar2.cBd();
        }
        ((c) g.k(c.class)).getProvider().onDestroy();
    }

    public final void a(f fVar) {
        super.a(fVar);
    }

    public final void aE(boolean z) {
        com.tencent.mm.view.e.a aVar = this.zDr;
        if (aVar.zGj != null) {
            aVar.zGj.setEnabled(z);
        }
    }

    public final void th() {
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "dealOrientationChange");
        this.zDr.zDs.RT = 0;
    }

    public final void ti() {
        this.vjB = null;
    }

    public final void refresh() {
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "reflesh");
        try {
            if (this.zDs != null && this.zDr != null) {
                this.zDr.cAQ();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.emoji.SmileyPanel.SmileyPanel", e, "", new Object[0]);
        }
    }

    public final void tj() {
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideCustomBtn");
        this.zDs.zGG = true;
    }

    public final void tk() {
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "[hideDefaultBtn]");
        this.zDs.zGH = true;
    }

    public final void g(boolean z, boolean z2) {
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideSmiley: %B, hideEmojiSmiley: %B", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        this.zDs.zGI = z;
        this.zDs.zGJ = z2;
    }

    public final void aF(boolean z) {
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideSendButton:B", new Object[]{Boolean.valueOf(z)});
        this.zDr.nI(z);
        this.zDs.zGM = true;
    }

    public final ChatFooterPanel.a cAn() {
        return this.vjB;
    }

    public final j cAo() {
        return (j) this.vjC;
    }

    public final void ei(int i) {
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "setPortHeightPx: %d", new Object[]{Integer.valueOf(i)});
        this.zDs.RT = 0;
        com.tencent.mm.view.f.a aVar = this.zDs;
        if (aVar.zGC != i) {
            aVar.zGR = false;
            aVar.zGQ = false;
        }
        aVar.zGC = i;
        this.zDs.cAU();
        aVar = this.zDs;
        int i2 = i - this.zDs.zGs;
        com.tencent.mm.view.f.a aVar2 = this.zDs;
        aVar.Hw(i2 - (aVar2.zDD - aVar2.zGA));
        this.zDs.kbg = 0;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void setVisibility(int i) {
        int i2 = 0;
        super.setVisibility(i);
        if (i == 0) {
            this.jYL = false;
            if (this.zDr != null) {
                com.tencent.mm.view.e.a aVar = this.zDr;
                x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initView begin");
                if (this == null) {
                    return;
                }
                if (aVar.mView != null && getChildCount() > 0) {
                    x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "already load view --- pass");
                    aVar.cAL();
                    return;
                } else if (aVar.zDs == null) {
                    x.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "mPanelStg is null");
                    return;
                } else {
                    aVar.zDs.zGV = false;
                    if (aVar.mView == null) {
                        aVar.mView = View.inflate(aVar.tI, a$f.lJD, null);
                    } else if (aVar.mView.getParent() != null) {
                        ((ViewGroup) aVar.mView.getParent()).removeView(aVar.mView);
                    }
                    aVar.zFZ = (SmileyPanelViewPager) aVar.findViewById(a$e.cOP);
                    aVar.zFZ.zDs = aVar.zDs;
                    aVar.zFZ.zDT = aVar;
                    aVar.zFZ.b(aVar);
                    aVar.zFZ.xe(3);
                    aVar.zDs.kbg = aVar.zFZ.getWidth();
                    aVar.zGb = (SmileyPanelScrollView) aVar.findViewById(a$e.cOO);
                    aVar.zGb.zDt = aVar;
                    aVar.zGb.zDu = aVar.zDs;
                    aVar.zGc = (HorizontalListViewV2) aVar.findViewById(a$e.lJr);
                    aVar.zGd = new e(aVar.kaK, aVar.zDs);
                    aVar.zGc.setAdapter(aVar.zGd);
                    aVar.zGc.setOnItemClickListener(aVar.zGq);
                    aVar.zGj = (TextView) aVar.findViewById(a$e.cLs);
                    aVar.zGf = (ImageView) aVar.findViewById(a$e.lJp);
                    aVar.zGf.setOnClickListener(aVar);
                    aVar.zGe = aVar.findViewById(a$e.lJo);
                    aVar.zGg = (ImageView) aVar.findViewById(a$e.lJq);
                    aVar.zGj.setOnClickListener(aVar);
                    aVar.zGj.setVisibility(aVar.zDs.cAY() ? 0 : 8);
                    addView(aVar.mView, new LayoutParams(-1, -1));
                    aVar.zDs.zGV = true;
                    View view = aVar.zGe;
                    int i3 = (aVar.zDs.zGG || aVar.zDs.zGH) ? 8 : 0;
                    view.setVisibility(i3);
                    aVar.zGi = (ImageButton) aVar.findViewById(a$e.lJn);
                    aVar.zGi.setOnClickListener(aVar);
                    ImageButton imageButton = aVar.zGi;
                    if (!(aVar.zDs.zGH && aVar.zDs.irz == ChatFooterPanel.vjG)) {
                        i2 = 8;
                    }
                    imageButton.setVisibility(i2);
                    return;
                }
            }
            x.w("MicroMsg.emoji.SmileyPanel.SmileyPanel", "Smiley Panel Manager is null.");
        } else if (this.zDs != null) {
            this.zDs.cBd();
        } else {
            x.w("MicroMsg.emoji.SmileyPanel.SmileyPanel", "Smiley PanelStg Manager is null.");
        }
    }

    public final void ce(String str) {
        this.zDs.vpS = str;
    }

    public final void cf(String str) {
        com.tencent.mm.view.f.a aVar = this.zDs;
        aVar.aar(str);
        aVar.cAU();
        if (aVar.zGU == null) {
            aVar.zGU = new 1(aVar);
        }
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "add succeed send listener");
        com.tencent.mm.sdk.b.a.xef.b(aVar.zGU);
    }

    protected void onMeasure(int i, int i2) {
        if (this.jYL) {
            setVisibility(8);
            i = MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public final void tm() {
        this.zDs.zGO = true;
    }

    public final void tl() {
        if (this.zDr != null) {
            com.tencent.mm.view.e.a aVar = this.zDr;
            String str = "TAG_DEFAULT_TAB";
            if (!(aVar.zFZ == null || aVar.zDs == null)) {
                if (aVar.zGn) {
                    aVar.zGo = null;
                    aVar.zFZ.post(new 3(aVar, str));
                } else {
                    aVar.zGo = str;
                }
            }
        }
        if (this.zDs != null) {
            com.tencent.mm.bu.a.cdS();
            b bVar = com.tencent.mm.bu.a.xbo;
            b.UB("TAG_DEFAULT_TAB");
        }
    }

    public final void ej(int i) {
        if (this.zDs != null) {
            this.zDs.irz = i;
        }
    }
}
