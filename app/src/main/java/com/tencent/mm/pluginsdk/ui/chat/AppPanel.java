package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.appbrand.jsapi.bp;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AppPanel extends LinearLayout {
    private static int pYV = bp.CTRL_INDEX;
    private static int pYW = 158;
    private static boolean vpn = false;
    Context context;
    private SharedPreferences gZO;
    private boolean isInit = false;
    private boolean pZg = false;
    private int pZh;
    private int pZi;
    public MMFlipper pZj;
    private MMDotView pZk;
    private int voI = 17;
    private List<f> voL = new LinkedList();
    private final boolean[] voT = new boolean[17];
    a voU;
    b voV;
    private List<AppGrid> voW;
    private int voX = this.voI;
    public a voY;
    private int voZ = 0;
    private int vpa = 0;
    int vpb = 0;
    private boolean vpc = false;
    private boolean vpd = false;
    private boolean vpe = false;
    private boolean vpf = false;
    boolean vpg = false;
    boolean vph = false;
    boolean vpi = false;
    private Map<String, f> vpj = null;
    private boolean vpk = true;
    private final int vpl = 2;
    private AppGrid$b vpm = new 3(this);
    boolean vpo = true;
    private int vpp = -1;

    public interface a {
        void aYN();

        void aYO();

        void aYP();

        void aYQ();

        void aYR();

        void aYS();

        void aYT();

        void aYU();

        void aYV();

        void aYW();

        void aYX();

        void aYY();

        void aYZ();

        void aZa();

        void b(f fVar);

        void sq(int i);

        void sr(int i);
    }

    static /* synthetic */ void a(AppPanel appPanel, boolean z) {
        ar.Hg();
        if (c.isSDCardAvailable()) {
            if (!vpn) {
                vpn = true;
                e.post(new 4(appPanel), "AppPanel_preMakeConnection");
            }
            if (z) {
                appPanel.voU.sq(0);
                return;
            } else {
                appPanel.voU.sq(1);
                return;
            }
        }
        u.fI(appPanel.context);
    }

    public AppPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public final void init(int i) {
        this.voY = new a();
        this.vpb = i;
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getWidth() < defaultDisplay.getHeight()) {
            this.voZ = defaultDisplay.getWidth();
            this.vpa = defaultDisplay.getHeight();
        } else {
            this.voZ = defaultDisplay.getHeight();
            this.vpa = defaultDisplay.getWidth();
        }
        View.inflate(this.context, R.i.dau, this);
        this.pZk = (MMDotView) findViewById(R.h.bKG);
        this.pZj = (MMFlipper) findViewById(R.h.bKH);
        try {
            String value = g.zY().getValue("ShowAPPSuggestion");
            if (bh.ov(value) || Integer.valueOf(value).intValue() != 1) {
                this.voL = com.tencent.mm.pluginsdk.model.app.g.a(this.context, false, this.vpb);
                if (!cbj()) {
                    cx(this.voL);
                }
                cw(this.voL);
                cbg();
                cbc();
            }
            this.voL = com.tencent.mm.pluginsdk.model.app.g.a(this.context, true, this.vpb);
            if (cbj()) {
                cx(this.voL);
            }
            cw(this.voL);
            cbg();
            cbc();
        } catch (Exception e) {
            x.e("MicroMsg.AppPanel", "exception in appPanel init, %s", new Object[]{e.getMessage()});
            this.voL = com.tencent.mm.pluginsdk.model.app.g.a(this.context, false, this.vpb);
        }
    }

    private void cw(List<f> list) {
        boolean z = this.vpc;
        this.vpc = false;
        boolean z2 = this.vpd;
        boolean z3 = this.vpe;
        boolean z4 = this.vpf;
        this.vpd = false;
        this.vpe = false;
        this.vpf = false;
        int i = this.vpb;
        ArrayList arrayList = new ArrayList();
        if (com.tencent.mm.plugin.y.a.a.a.bis() == null) {
            x.e("MicroMsg.AppInfoLogic", "getServiceByAppInfoFlagAndShowFlag, getISubCorePluginBase() == null");
            i = 0;
        } else {
            Cursor df = com.tencent.mm.plugin.y.a.a.a.bis().df(0, i);
            if (df == null) {
                i = 0;
            } else {
                i = df.getCount();
                df.close();
            }
        }
        x.d("MicroMsg.AppPanel", "serviceCount, %d", new Object[]{Integer.valueOf(i)});
        this.vpj = new HashMap();
        if (i > 0 && list != null && list.size() > 0) {
            int i2 = 0;
            while (i2 < list.size()) {
                f fVar = (f) list.get(i2);
                if (!(fVar == null || fVar.field_appId == null || !fVar.bYD())) {
                    boolean z5;
                    int i3;
                    if ((fVar.field_serviceAppInfoFlag & 1) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (!z5) {
                        this.vpc = true;
                    }
                    if (f.vef.equals(fVar.field_appId)) {
                        this.vpj.put(f.vef, fVar);
                        if (!this.vph) {
                            this.vpd = true;
                        }
                        i3 = i2 - 1;
                        list.remove(i2);
                        i2 = i3;
                    }
                    if (f.veh.equals(fVar.field_appId)) {
                        this.vpj.put(f.veh, fVar);
                        if (!this.vpg) {
                            this.vpe = true;
                        }
                        i3 = i2 - 1;
                        list.remove(i2);
                        i2 = i3;
                    }
                    if (f.vei.equals(fVar.field_appId)) {
                        this.vpj.put(f.vei, fVar);
                        if (!this.vpi) {
                            this.vpf = true;
                        }
                        i = i2 - 1;
                        list.remove(i2);
                        i2 = i;
                    }
                }
                i2++;
            }
        }
        x.d("MicroMsg.AppPanel", "hasService %b", new Object[]{Boolean.valueOf(this.vpc)});
        if (z != this.vpc || z2 != this.vpd || z3 != this.vpe || z4 != this.vpf) {
            this.voY.ld(this.vpc);
            this.voY.le(this.vpd);
            this.voY.lf(this.vpe);
            this.voY.lg(this.vpf);
            cbe();
        }
    }

    public final void cbc() {
        a aVar = this.voY;
        aVar.vps.value = true;
        aVar.vpt.value = true;
        aVar.vpu.value = true;
        aVar.vpv.value = true;
        aVar.vpw.value = true;
        aVar.vpx.value = true;
        aVar.vpy.value = true;
        aVar.vpH.value = true;
        aVar.vpF.value = true;
        aVar.vpz.value = true;
        aVar.vpA.value = true;
        aVar.vpB.value = true;
        aVar.vpC.value = true;
        aVar.vpD.value = true;
        aVar.vpE.value = true;
        aVar.vpG.value = true;
        aVar.vpI.value = true;
        aVar.vpJ.value = false;
        aVar.vpK.value = true;
        aVar.vpL.value = true;
        aVar.vpN.value = true;
        aVar.vpO.value = true;
        aVar.vpN.value = false;
        aVar.vpP.value = true;
        this.vpg = false;
        this.vph = false;
        this.vpi = false;
        cbd();
        this.voY.ld(this.vpc);
        this.voY.le(this.vpd);
        this.voY.lf(this.vpe);
        this.voY.lg(this.vpf);
        cbe();
    }

    public final void cbd() {
        boolean z = true;
        g.zZ();
        boolean z2 = com.tencent.mm.k.c.zJ() == 2;
        this.voY.vpy.value = true;
        this.voY.vpE.value = z2;
        this.voY.vpI.value = d.OQ("location");
        if ((q.Gd() & 33554432) != 0) {
            z = false;
        }
        this.voY.vpG.value = z;
    }

    public final void lc(boolean z) {
        this.voY.vpD.value = false;
        cbe();
        x.d("MicroMsg.AppPanel", "enable " + this.voY.vpE.value + " isVoipAudioEnable false");
    }

    public final void cbe() {
        int i = 1;
        int length = this.voT.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.voT[i2] = true;
        }
        if (this.voY.vpu.value) {
            i = 0;
        } else {
            this.voT[0] = false;
        }
        if (!this.voY.vpP.value) {
            this.voT[16] = false;
            i++;
        }
        if (!(this.voY.vpH.value && this.voY.vpI.value)) {
            this.voT[6] = false;
            i++;
        }
        if (!this.voY.vpz.value) {
            this.voT[14] = false;
            i++;
        }
        if (!this.voY.vpA.value) {
            this.voT[8] = false;
            i++;
        }
        if (!this.voY.vpv.value) {
            this.voT[11] = false;
            i++;
        }
        if (!this.voY.vpJ.value) {
            this.voT[13] = false;
            i++;
        }
        if (!this.voY.vpM.value) {
            this.voT[3] = false;
            i++;
        }
        if (!this.voY.vpw.value) {
            this.voT[12] = false;
            i++;
        }
        if (!this.voY.vpC.value) {
            this.voT[5] = false;
            i++;
        }
        if (!(this.voY.vpE.value && this.voY.vpD.value)) {
            this.voT[4] = false;
            i++;
        }
        if (!(this.voY.vpy.value && this.voY.vpx.value)) {
            this.voT[2] = false;
            i++;
        }
        if (!(this.voY.vpG.value && this.voY.vpF.value)) {
            this.voT[10] = false;
            i++;
        }
        if (!this.voY.vpL.value) {
            this.voT[7] = false;
            i++;
        }
        if (!this.voY.vpN.value) {
            this.voT[15] = false;
            i++;
        }
        this.voT[9] = false;
        this.voI = 17 - (i + 1);
    }

    private int cbf() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getWidth() < defaultDisplay.getHeight()) {
            return 1;
        }
        return 2;
    }

    private void cbg() {
        x.d("MicroMsg.AppPanel", "AppPanel initFlipper");
        this.pZj.removeAllViews();
        this.pZj.yal = new 1(this);
        this.pZj.yak = new 2(this);
        cbi();
    }

    public final void refresh() {
        x.v("MicroMsg.AppPanel", "app panel refleshed");
        try {
            String value = g.zY().getValue("ShowAPPSuggestion");
            int coY;
            if (bh.ov(value) || Integer.valueOf(value).intValue() != 1) {
                this.voL = com.tencent.mm.pluginsdk.model.app.g.a(this.context, false, this.vpb);
                x.d("MicroMsg.AppPanel", "jacks not show App Suggestion");
                if (!cbj()) {
                    cx(this.voL);
                }
                cw(this.voL);
                if (this.voY != null) {
                    this.voY.ld(this.vpc);
                    this.voY.le(this.vpd);
                    this.voY.lf(this.vpe);
                    this.voY.lg(this.vpf);
                }
                coY = this.pZj.coY();
                cbh();
                this.pZj.EL(coY);
                this.pZk.EI(coY);
            }
            x.d("MicroMsg.AppPanel", "jacks show App Suggestion");
            this.voL = com.tencent.mm.pluginsdk.model.app.g.a(this.context, true, this.vpb);
            if (cbj()) {
                cx(this.voL);
            }
            cw(this.voL);
            if (this.voY != null) {
                this.voY.ld(this.vpc);
                this.voY.le(this.vpd);
                this.voY.lf(this.vpe);
                this.voY.lg(this.vpf);
            }
            coY = this.pZj.coY();
            cbh();
            this.pZj.EL(coY);
            this.pZk.EI(coY);
        } catch (Exception e) {
            x.e("MicroMsg.AppPanel", "exception in appPanel init, %s", new Object[]{e.getMessage()});
            this.voL = com.tencent.mm.pluginsdk.model.app.g.a(this.context, false, this.vpb);
        }
    }

    private void cbh() {
        if (this.pZh != 0 && this.pZi != 0) {
            AppGrid appGrid;
            this.voW = new ArrayList();
            this.pZj.removeAllViews();
            int b = b.b(this.context, 82.0f);
            int b2 = b.b(this.context, 90.0f);
            requestLayout();
            cbe();
            if (this.vpk) {
                b = 4;
            } else {
                b = this.pZh / b;
            }
            int i = this.pZi / b2;
            if (i > 2) {
                i = 2;
            }
            int i2 = (this.pZi - (b2 * i)) / (i + 1);
            x.d("MicroMsg.AppPanel", "jacks spacing2 = %d", new Object[]{Integer.valueOf(i2)});
            x.d("MicroMsg.AppPanel", "in initAppGrid, gridWidth = %d, gridHeight = %d", new Object[]{Integer.valueOf(this.pZh), Integer.valueOf(this.pZi)});
            if (b == 0) {
                b2 = 1;
            } else {
                b2 = b;
            }
            if (i == 0) {
                i = 1;
            }
            int i3 = b2 * i;
            if (this.voY.vpB.value) {
                this.voX = this.voI + this.voL.size();
            } else {
                this.voX = this.voI;
            }
            int ceil = (int) Math.ceil(((double) this.voX) / ((double) i3));
            x.d("MicroMsg.AppPanel", "in initAppGrid, totalItemCount = %d, itemsPerPage = %d, pageCount = %d", new Object[]{Integer.valueOf(this.voX), Integer.valueOf(i3), Integer.valueOf(ceil)});
            for (i = 0; i < ceil; i++) {
                appGrid = (AppGrid) inflate(this.context, R.i.daq, null);
                appGrid.voJ = new com.tencent.mm.pluginsdk.ui.chat.AppGrid.a(appGrid, appGrid.context, this.voL, this.vpj);
                appGrid.setBackgroundResource(0);
                appGrid.setAdapter(appGrid.voJ);
                appGrid.setOnItemClickListener(appGrid.kGC);
                appGrid.setOnItemLongClickListener(appGrid.mtQ);
                appGrid.setPadding(b.b(appGrid.context, 16.0f), b.b(appGrid.context, 6.0f), b.b(appGrid.context, 16.0f), 0);
                int i4 = this.voX;
                int i5 = this.voI;
                appGrid.voH = i;
                appGrid.voE = i4;
                appGrid.voF = i3;
                appGrid.voG = ceil;
                appGrid.voI = i5;
                appGrid.setNumColumns(b2);
                if (i2 > 0) {
                    appGrid.setPadding(b.b(appGrid.context, 16.0f), i2, b.b(appGrid.context, 16.0f), 0);
                    appGrid.setVerticalSpacing(i2 / 2);
                }
                this.pZj.addView(appGrid, new LayoutParams(-1, -2));
                this.voW.add(appGrid);
            }
            if (this.voW != null) {
                for (AppGrid appGrid2 : this.voW) {
                    appGrid2.voD = this.vpm;
                }
            }
            if (this.voW.size() <= 1) {
                this.pZk.setVisibility(4);
                return;
            }
            this.pZk.setVisibility(0);
            this.pZk.EH(this.voW.size());
            b = this.pZj.coY();
            this.pZj.EL(b);
            this.pZk.EI(b);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            x.d("MicroMsg.AppPanel", "onConfigChanged:" + configuration.orientation);
            if (configuration.orientation == 1) {
                this.vpk = true;
            } else {
                this.vpk = false;
            }
            this.vpo = true;
            th();
        }
    }

    public final void th() {
        this.pZg = false;
        this.pZj.EL(0);
        cbg();
        requestLayout();
    }

    public final void Cg(int i) {
        if (this.vpp != i) {
            this.vpp = i;
            this.vpo = true;
        }
    }

    public final void cbi() {
        if (this.vpo) {
            LayoutParams layoutParams;
            int b;
            View view;
            ViewGroup.LayoutParams layoutParams2;
            View findViewById;
            if (cbf() == 2) {
                x.d("MicroMsg.AppPanel", "initFlipper, landscape");
                findViewById = findViewById(R.h.bKF);
                layoutParams = new LayoutParams(-1, 0);
                b = b.b(this.context, (float) pYW);
                view = findViewById;
                layoutParams2 = layoutParams;
            } else {
                x.d("MicroMsg.AppPanel", "initFlipper, portrait: %d", new Object[]{Integer.valueOf(pYV)});
                findViewById = findViewById(R.h.bKF);
                ViewGroup.LayoutParams layoutParams3 = new LayoutParams(-1, 0);
                if (this.vpp > 0) {
                    b = this.vpp;
                    view = findViewById;
                    layoutParams2 = layoutParams3;
                } else {
                    b = b.b(this.context, (float) pYV);
                    view = findViewById;
                    layoutParams2 = layoutParams3;
                }
            }
            layoutParams.height = b;
            view.setLayoutParams(layoutParams2);
            this.vpo = false;
        }
    }

    private static void cx(List<f> list) {
        if (list != null && !list.isEmpty()) {
            int i = 0;
            while (i < list.size()) {
                f fVar = (f) list.get(i);
                if (fVar == null || !f.veg.equals(fVar.field_appId)) {
                    i++;
                } else {
                    list.remove(fVar);
                    return;
                }
            }
        }
    }

    private static boolean cbj() {
        com.tencent.mm.pluginsdk.q.c cVar = com.tencent.mm.pluginsdk.q.a.vct;
        if (cVar == null || !cVar.auj() || cVar.aum() <= 0) {
            return false;
        }
        return true;
    }
}
