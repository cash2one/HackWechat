package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.plugin.appbrand.appusage.g.b;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandNearbyEmptyUI;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.protocal.c.aip;
import com.tencent.mm.protocal.c.asw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

final class e extends h implements OnClickListener, b {
    View VU;
    private Activity fAF;
    private ThreeDotsLoadingView jPG;
    private final int jPZ;
    private final int jQa;
    private final int jQb;
    private final int jQc = -1;
    private View jQk;
    private int jQo = a.jQz;
    private f jQp;
    private final int jQq;
    private TextView jQr;
    private AppBrandNearbyShowcaseView jQs;
    private View jQt;
    private ImageView jQu;
    private boolean jQv = false;

    e(Activity activity, ViewGroup viewGroup) {
        this.fAF = activity;
        this.jPZ = a.fromDPToPix(activity, 25);
        this.jQa = a.fromDPToPix(activity, 19);
        this.jQb = a.fromDPToPix(activity, 2);
        this.VU = LayoutInflater.from(activity).inflate(h.ixi, viewGroup, false);
        View findViewById = this.VU.findViewById(g.ivC);
        this.jQt = findViewById;
        findViewById.setOnClickListener(this);
        this.jQk = this.VU.findViewById(g.ivY);
        this.jQr = (TextView) this.VU.findViewById(g.ivZ);
        this.jQs = (AppBrandNearbyShowcaseView) this.VU.findViewById(g.ivV);
        this.jQs.lP(4);
        this.jQs.lN(this.jPZ + (this.jQb * 2));
        this.jQs.lO(this.jQa);
        this.jPG = (ThreeDotsLoadingView) this.VU.findViewById(g.ivW);
        this.jQu = (ImageView) this.VU.findViewById(g.ivX);
        this.jQq = a.c(activity, d.isC);
        if (!com.tencent.mm.pluginsdk.g.a.aZ(activity, "android.permission.ACCESS_COARSE_LOCATION")) {
            this.jQo = a.jQB;
        }
    }

    final View alv() {
        return this.VU;
    }

    final void onResume() {
        if (a.jQB == this.jQo && com.tencent.mm.pluginsdk.g.a.aZ(this.fAF, "android.permission.ACCESS_COARSE_LOCATION")) {
            this.jQo = a.jQz;
            alu();
        }
    }

    final void alu() {
        dk(com.tencent.mm.plugin.appbrand.appusage.g.aaM());
        if (a.jQB == this.jQo) {
            alx();
            return;
        }
        com.tencent.mm.plugin.appbrand.appusage.g.a(this);
        if (!com.tencent.mm.plugin.appbrand.appusage.g.aaR()) {
            this.VU.post(new 1(this));
        } else if (com.tencent.mm.plugin.appbrand.appusage.g.refresh()) {
            alw();
        } else {
            dk(false);
        }
    }

    final void onDetached() {
        com.tencent.mm.plugin.appbrand.appusage.g.b(this);
        this.fAF = null;
        this.VU = null;
        this.jQs = null;
        this.jQk = null;
    }

    private void alw() {
        this.jQo = a.jQA;
        bL(this.jQk);
        bL(this.jQu);
        bM(this.jPG);
        this.jPG.cze();
    }

    private void alx() {
        boolean z = true;
        int i = 0;
        if (this.VU != null) {
            com.tencent.mm.plugin.appbrand.appusage.h.d dVar;
            if (com.tencent.mm.plugin.appbrand.appusage.g.aaM()) {
                dk(true);
                dVar = ((AppBrandLauncherUI) this.fAF).jKQ;
                if (dVar != null) {
                    dVar.iJH[5] = "1";
                }
            } else {
                dk(false);
            }
            this.jPG.ajm();
            bL(this.jPG);
            if (a.jQB == this.jQo) {
                bL(this.jQk);
                bL(this.jQu);
                return;
            }
            aip aaQ = com.tencent.mm.plugin.appbrand.appusage.g.aaQ();
            if (aaQ == null) {
                this.jQo = a.jQx;
                bL(this.jQk);
                bM(this.jQu);
            } else if (aaQ.kkv <= 0 || bh.cA(aaQ.wpT)) {
                this.jQo = a.jQz;
                bL(this.jQk);
            } else {
                this.jQo = a.jQy;
                dVar = ((AppBrandLauncherUI) this.fAF).jKQ;
                if (dVar != null) {
                    dVar.iJH[3] = "1";
                }
                if (this.jQr != null) {
                    this.jQr.setText(aaQ.wpZ);
                    this.jQr.setTextColor(aK(aaQ.wqa, this.jQq));
                }
                this.jQs.lP(Math.min(aaQ.wpT.size(), 4));
                if (this.jQk.getVisibility() == 0) {
                    z = false;
                }
                if (z) {
                    this.jQs.ame();
                }
                if (this.jQp == null) {
                    this.jQp = new com.tencent.mm.plugin.appbrand.ui.widget.a(this.jPZ, this.jQb);
                }
                while (i < this.jQs.getChildCount()) {
                    com.tencent.mm.modelappbrand.a.b.Jj().a(this.jQs.lQ(i), ((asw) aaQ.wpT.get(i)).wAF, com.tencent.mm.modelappbrand.a.a.Ji(), this.jQp);
                    i++;
                }
                bM(this.jQk);
                if (z) {
                    if (this.jQs != null) {
                        this.jQs.amf();
                    }
                    if (this.jQr != null) {
                        this.jQr.setAlpha(0.0f);
                        this.jQr.animate().alpha(1.0f).setDuration(500).start();
                    }
                }
            }
        }
    }

    private static int aK(String str, int i) {
        try {
            i = Color.parseColor(str);
        } catch (Exception e) {
        }
        return i;
    }

    private void bL(View view) {
        if (view.getVisibility() == 0) {
            view.animate().setDuration(200).alpha(0.0f).withEndAction(new 2(this, view)).start();
        }
    }

    private static void bM(View view) {
        if (view.getVisibility() != 0) {
            view.setAlpha(0.0f);
            view.setVisibility(0);
        }
        view.animate().setDuration(200).alpha(1.0f).withEndAction(null).start();
    }

    public final void aaT() {
        if (this.VU != null) {
            this.VU.post(new 3(this));
        }
    }

    public final void onClick(View view) {
        int i = 0;
        if (view.getId() == g.ivC && this.fAF != null && a.jQA != this.jQo) {
            if (a.jQz == this.jQo) {
                aly();
                this.fAF.startActivityForResult(new Intent(this.fAF, AppBrandNearbyEmptyUI.class).putExtra("extra_enter_reason", 0), 3);
            } else if (a.jQB == this.jQo) {
                aly();
                this.fAF.startActivityForResult(new Intent(this.fAF, AppBrandNearbyEmptyUI.class).putExtra("extra_enter_reason", 1), 3);
            } else {
                boolean z = com.tencent.mm.plugin.appbrand.appusage.g.aaQ() != null && com.tencent.mm.plugin.appbrand.appusage.g.aaR();
                this.jQv = z;
                if (a.jQx == this.jQo || this.jQv) {
                    i = 1;
                }
                Runnable 4 = new 4(this);
                if (i != 0) {
                    alw();
                    com.tencent.mm.plugin.appbrand.appusage.g.refresh();
                    return;
                }
                4.run();
                if (com.tencent.mm.plugin.appbrand.appusage.g.aaQ() != null && com.tencent.mm.plugin.appbrand.appusage.g.aaQ().wqb == 1 && this.jQr != null) {
                    this.jQr.animate().alpha(0.0f).setDuration(200);
                }
            }
        }
    }

    private void aly() {
        if (this.fAF != null) {
            com.tencent.mm.plugin.appbrand.appusage.h.d dVar = ((AppBrandLauncherUI) this.fAF).jKQ;
            if (dVar != null) {
                dVar.iJH[8] = "1";
            }
        }
    }
}
