package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.c;
import com.tencent.mm.plugin.appbrand.appusage.c.b;
import com.tencent.mm.plugin.appbrand.compat.a.a;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.c.ait;
import com.tencent.mm.protocal.c.cbk;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;

final class f extends h implements b, d.b {
    Activity iQz;
    private a jQD = new a((byte) 0);
    d jQE;
    private boolean jQF = false;
    private OnClickListener jQG = null;
    volatile boolean mFinished = false;

    static /* synthetic */ void a(f fVar) {
        boolean z = false;
        ait com_tencent_mm_protocal_c_ait = c.aaJ().iIV;
        if (com_tencent_mm_protocal_c_ait == null) {
            d dVar = fVar.jQE;
            x.i("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "AppBrandLauncherRecentsListHeaderBase.loadingFailed");
            dVar.jPT = d.c.jQh;
            dVar.jPU.jPG.ajm();
            dVar.bL(dVar.jPU.jPG);
            dVar.bL(dVar.jPU.jQk);
            d.bM(dVar.jPU.jQn);
            return;
        }
        if (com_tencent_mm_protocal_c_ait != null && (com_tencent_mm_protocal_c_ait.wqk == 1 || com_tencent_mm_protocal_c_ait.wqk == 2)) {
            c.c jD = c.c.jD(com_tencent_mm_protocal_c_ait.wqk);
            String str = "MicroMsg.AppBrandListRecentsListWAGameHeader";
            String str2 = "Use Game Entry %s";
            Object[] objArr = new Object[1];
            objArr[0] = jD == null ? "null" : jD.name();
            x.i(str, str2, objArr);
            if (jD == c.c.iJb) {
                final String str3 = com_tencent_mm_protocal_c_ait.wqj;
                if (bh.ov(str3)) {
                    String str4 = "MicroMsg.AppBrandListRecentsListWAGameHeader";
                    str = "makeH5ClickListener failed. link_wxagame = [%s]";
                    Object[] objArr2 = new Object[1];
                    if (str3 == null) {
                        str3 = "null";
                    }
                    objArr2[0] = str3;
                    x.e(str4, str, objArr2);
                } else {
                    x.i("MicroMsg.AppBrandListRecentsListWAGameHeader", "H5 link is [%s]", str3);
                    if (bh.ov(str3)) {
                        fVar.jQG = null;
                    } else {
                        fVar.jQG = new OnClickListener(fVar) {
                            final /* synthetic */ f jQH;

                            public final void onClick(View view) {
                                x.i("MicroMsg.AppBrandListRecentsListWAGameHeader", "Invoke H5 click listener, invoke h5");
                                ((a) g.h(a.class)).K(this.jQH.iQz, str3);
                            }
                        };
                    }
                }
            } else if (jD == c.c.iJa) {
                final cbk com_tencent_mm_protocal_c_cbk = com_tencent_mm_protocal_c_ait.wqi;
                if (com_tencent_mm_protocal_c_cbk == null) {
                    x.e("MicroMsg.AppBrandListRecentsListWAGameHeader", "makeWxAppClickListener failed. wxaInfo = null.");
                } else {
                    str = "MicroMsg.AppBrandListRecentsListWAGameHeader";
                    str2 = "WxApp link is [%s]";
                    objArr = new Object[1];
                    objArr[0] = com_tencent_mm_protocal_c_cbk.path == null ? "null" : com_tencent_mm_protocal_c_cbk.path;
                    x.i(str, str2, objArr);
                    new AppBrandStatObject().scene = 1001;
                    fVar.jQG = new OnClickListener(fVar) {
                        final /* synthetic */ f jQH;

                        public final void onClick(View view) {
                            x.i("MicroMsg.AppBrandListRecentsListWAGameHeader", "Invoke WxApp click listener, invoke wxapp");
                            AppBrandLaunchProxyUI.a(this.jQH.iQz, com_tencent_mm_protocal_c_cbk.username, com_tencent_mm_protocal_c_cbk.path, 0, com_tencent_mm_protocal_c_cbk.vOv, new AppBrandStatObject(), null);
                        }
                    };
                }
            }
        } else if (com_tencent_mm_protocal_c_ait == null) {
            x.e("MicroMsg.AppBrandListRecentsListWAGameHeader", "processClickListenerInfo resp is null");
        } else {
            x.e("MicroMsg.AppBrandListRecentsListWAGameHeader", "processClickListenerInfo resp is not null, but action_code is %d", Integer.valueOf(com_tencent_mm_protocal_c_ait.wqk));
        }
        if (com_tencent_mm_protocal_c_ait == null) {
            x.e("MicroMsg.AppBrandListRecentsListWAGameHeader", "processRenderInfo GetWxaGameResponse");
        } else {
            x.i("MicroMsg.AppBrandListRecentsListWAGameHeader", "processRenderInfo entry = [%s] ec = [%s] new = [%s] nc = [%s]", com_tencent_mm_protocal_c_ait.wqm, com_tencent_mm_protocal_c_ait.wqn, com_tencent_mm_protocal_c_ait.wql, com_tencent_mm_protocal_c_ait.wqo);
            fVar.jQD.jQK = bh.az(com_tencent_mm_protocal_c_ait.wql, "");
            fVar.jQD.jQL = ux(com_tencent_mm_protocal_c_ait.wqo);
            fVar.jQD.jQM = new ArrayList(Math.max(com_tencent_mm_protocal_c_ait.wqh == null ? 0 : com_tencent_mm_protocal_c_ait.wqh.size(), 0));
            if (com_tencent_mm_protocal_c_ait.wqh != null && com_tencent_mm_protocal_c_ait.wqh.size() > 0) {
                Iterator it = com_tencent_mm_protocal_c_ait.wqh.iterator();
                while (it.hasNext()) {
                    cbk com_tencent_mm_protocal_c_cbk2 = (cbk) it.next();
                    if (com_tencent_mm_protocal_c_cbk2 != null) {
                        fVar.jQD.jQM.add(com_tencent_mm_protocal_c_cbk2.wAF);
                    }
                }
            }
        }
        if (com_tencent_mm_protocal_c_ait.wqb == 1) {
            z = true;
        }
        fVar.jQF = z;
        fVar.jQE.a(fVar.jQD.jQM, fVar.jQD.jQK, fVar.jQD.jQL);
    }

    f(Activity activity, ViewGroup viewGroup) {
        this.jQE = new d(viewGroup, j.dDV);
        this.jQE.jPS = this;
        this.iQz = activity;
    }

    final void alu() {
        c aaJ = c.aaJ();
        dk(c.enabled());
        if (c.enabled()) {
            if (this != null) {
                synchronized (aaJ.mLock) {
                    aaJ.iIU.add(this);
                }
            }
            aaJ.refresh();
            this.jQE.alw();
            this.mFinished = false;
        }
    }

    final void onDetached() {
        this.mFinished = true;
        c aaJ = c.aaJ();
        if (this != null) {
            synchronized (aaJ.mLock) {
                aaJ.iIU.remove(this);
            }
        }
    }

    final void onResume() {
    }

    public final void aaK() {
        x.i("MicroMsg.AppBrandListRecentsListWAGameHeader", "AppBrandListRecentsListWAGameHeader.onWAGameDataUpdate");
        c.aaJ();
        if (c.enabled() && !this.mFinished) {
            View view = this.jQE.jPU.VU;
            if (view != null) {
                view.post(new Runnable(this) {
                    final /* synthetic */ f jQH;

                    {
                        this.jQH = r1;
                    }

                    public final void run() {
                        if (!this.jQH.mFinished && this.jQH.jQE.jPU.VU != null) {
                            f.a(this.jQH);
                        }
                    }
                });
            }
        }
    }

    private static Integer ux(String str) {
        try {
            return Integer.valueOf(Color.parseColor(str));
        } catch (Exception e) {
            return null;
        }
    }

    final View alv() {
        return this.jQE.jPU.VU;
    }

    public final void b(int i, View view) {
        if (i == 0 || i == d.c.jQf || i == d.c.jQe) {
            x.v("MicroMsg.AppBrandListRecentsListWAGameHeader", "onClick ");
        } else if (i == d.c.jQh) {
            this.jQE.alw();
            c.aaJ().refresh();
        } else if (i == d.c.jQg && this.jQG != null) {
            this.jQG.onClick(view);
            if (this.jQF) {
                d dVar = this.jQE;
                if (dVar.jPU.jQm != null) {
                    dVar.jPU.jQm.animate().alpha(0.0f).setDuration(200).start();
                }
            }
        }
    }
}
