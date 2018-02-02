package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;

public final class a extends b implements d {
    private static String TAG = "MicroMsg.BakChatBanner";
    private af handler = new af(Looper.getMainLooper());
    private View kpZ = null;
    private int krG = 0;
    private c krH;
    private int krc = -1;

    static /* synthetic */ boolean a(a aVar) {
        aVar.krG = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aql().aqm().aqw();
        x.d(TAG, "refreshForBakpc PCBannerStatus:%d, percent:%d", new Object[]{Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aql().aqm().krc), Integer.valueOf(aVar.krG)});
        return aVar.dN(false);
    }

    static /* synthetic */ void d(a aVar) {
        Intent intent = new Intent((Context) aVar.voC.get(), BakOperatingUI.class);
        intent.putExtra("from_bak_banner", true);
        MMWizardActivity.A((Context) aVar.voC.get(), intent);
    }

    static /* synthetic */ void e(a aVar) {
        Intent intent = new Intent((Context) aVar.voC.get(), BakFinishUI.class);
        intent.putExtra("cmd", 1);
        MMWizardActivity.A((Context) aVar.voC.get(), intent);
    }

    public a(Context context) {
        super(context);
        if (this.view != null) {
            this.kpZ = this.view.findViewById(R.h.bMB);
            this.kpZ.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a krI;

                {
                    this.krI = r1;
                }

                public final void onClick(View view) {
                    this.krI.krc = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aql().aqm().krc;
                    if (2 == this.krI.krc || 3 == this.krI.krc || 5 == this.krI.krc || 6 == this.krI.krc) {
                        x.d(a.TAG, "OnClickListener goToBakOperatingUI PCBannerStatus:%d, percent:%d", new Object[]{Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aql().aqm().krc), Integer.valueOf(this.krI.krG)});
                        a.d(this.krI);
                    } else if (4 == this.krI.krc) {
                        x.d(a.TAG, "OnClickListener goToBakFinishUI PCBannerStatus:%d, percent:%d", new Object[]{Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aql().aqm().krc), Integer.valueOf(this.krI.krG)});
                        a.e(this.krI);
                    }
                }
            });
        }
        alg();
        this.krH = new 1(this);
        com.tencent.mm.sdk.b.a.xef.b(this.krH);
    }

    public final int getLayoutId() {
        return R.i.bMB;
    }

    private boolean dN(boolean z) {
        this.krc = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aql().aqm().krc;
        x.d(TAG, "dealwithPCBakBanner PCBannerStatus:%d, setCallBack:%b", new Object[]{Integer.valueOf(this.krc), Boolean.valueOf(z)});
        if (this.krc < 2 || this.krc > 6) {
            this.kpZ.setVisibility(8);
            return false;
        }
        this.kpZ.setVisibility(0);
        if (z && !com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aql().aqm().aqt()) {
            com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aql().aqm().a((d) this);
        }
        if (2 == this.krc) {
            ((ImageView) this.view.findViewById(R.h.bMC)).setImageResource(R.k.dxx);
            ((TextView) this.view.findViewById(R.h.bMD)).setText(ac.getContext().getString(R.l.dJT, new Object[]{Integer.valueOf(this.krG)}));
        } else if (3 == this.krc) {
            ((ImageView) this.view.findViewById(R.h.bMC)).setImageResource(R.k.dxx);
            ((TextView) this.view.findViewById(R.h.bMD)).setText(ac.getContext().getString(R.l.dJW, new Object[]{Integer.valueOf(this.krG)}));
        } else if (4 == this.krc) {
            ((TextView) this.view.findViewById(R.h.bMD)).setText(ac.getContext().getString(R.l.dJV));
            ((ImageView) this.view.findViewById(R.h.bMC)).setImageResource(R.k.dxw);
        } else if (5 == this.krc) {
            ((ImageView) this.view.findViewById(R.h.bMC)).setImageResource(R.k.dxx);
            ((TextView) this.view.findViewById(R.h.bMD)).setText(ac.getContext().getString(R.l.dJS, new Object[]{Integer.valueOf(this.krG)}));
        } else if (6 == this.krc) {
            ((TextView) this.view.findViewById(R.h.bMD)).setText(ac.getContext().getString(R.l.dJU));
            ((ImageView) this.view.findViewById(R.h.bMC)).setImageResource(R.k.dxw);
        }
        return true;
    }

    public final boolean alg() {
        this.krG = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aql().aqm().aqw();
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aql().aqm().a((d) this);
        return dN(true);
    }

    public final void release() {
        this.krc = -1;
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aql().aqm().aqu();
    }

    public final void onError(int i) {
    }

    public final void mW(int i) {
        x.d(TAG, "onNetProgress PCBannerStatus:%d, percent:%d", new Object[]{Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aql().aqm().krc), Integer.valueOf(i)});
        this.krG = i;
        this.handler.post(new 3(this));
    }

    public final void mX(int i) {
        x.d(TAG, "onMergeProgress PCBannerStatus:%d, percent:%d", new Object[]{Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aql().aqm().krc), Integer.valueOf(i)});
    }

    public final void aqz() {
        x.d(TAG, "onNetFinish PCBannerStatus:%d", new Object[]{Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aql().aqm().krc)});
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aql().aqm();
        e.mS(17);
        this.handler.post(new 4(this));
    }

    public final void aok() {
    }

    public final void aqA() {
    }

    public final void destroy() {
        com.tencent.mm.sdk.b.a.xef.c(this.krH);
    }

    public final int getOrder() {
        return 3;
    }
}
