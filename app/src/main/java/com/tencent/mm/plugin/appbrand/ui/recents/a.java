package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.a.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.appbrand.appusage.j$b;
import com.tencent.mm.plugin.appbrand.appusage.n;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.q.k;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class a extends com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.a {
    private Dialog jLV = null;
    private final int jOH;
    private final boolean jOI = true;
    private final boolean jOJ;
    private final g jOK;
    private final Bundle jOL = new Bundle();
    private final AtomicLong jOM = new AtomicLong(-1);
    private final AtomicLong jON = new AtomicLong(-1);
    private final AtomicBoolean jOO = new AtomicBoolean(false);
    private final AtomicLong jOP = new AtomicLong(Long.MAX_VALUE);
    private LoadMoreRecyclerView jOQ;
    private LinearLayoutManager jOR;
    private n jOS;
    private final i jOT = new i();
    private final ag jOU = new ag("AppBrandLauncherUI#RecentsListUI");
    private final m jOV = new m();
    private c jOW;
    private c jOX;
    private b jOY;
    private final k jOZ = new k();
    private boolean jPa = false;
    private boolean jPb = false;
    private final k jPc = new 10(this);
    private final a jPd = new a();
    private final com.tencent.mm.sdk.e.j.a jPe = new com.tencent.mm.sdk.e.j.a(this) {
        final /* synthetic */ a jPj;

        {
            this.jPj = r1;
        }

        public final void a(String str, l lVar) {
            if ("single".equals(str)) {
                if (2 == lVar.iYZ || 3 == lVar.iYZ) {
                    a.a(this.jPj, false, -1, true);
                }
            } else if ("batch".equals(str) && 3 == lVar.iYZ) {
                a.a(this.jPj, false, -1, true);
            }
        }
    };
    private final com.tencent.mm.sdk.e.j.a jPf = new 12(this);
    private final com.tencent.mm.sdk.e.j.a jPg = new 13(this);
    private final com.tencent.mm.sdk.e.j.a jPh = new 14(this);
    private final b jPi = new b(this, (byte) 0);
    private int jaT = 0;
    private String mSceneId;

    private final class a implements android.support.v7.widget.RecyclerView.e.a {
        final /* synthetic */ a jPj;

        private a(a aVar) {
            this.jPj = aVar;
        }

        public final void fS() {
            this.jPj.jOZ.jQR = false;
        }

        final void alr() {
            this.jPj.jOZ.jQR = true;
        }
    }

    private final class c extends o<i, d> {
        final /* synthetic */ a jPj;
        final Map<String, String> jPv;

        private c(a aVar) {
            this.jPj = aVar;
            this.jPv = new HashMap();
        }

        public final /* synthetic */ t a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            return new d(this.jPj, layoutInflater.inflate(h.iwY, viewGroup, false));
        }

        public final /* synthetic */ void a(t tVar, Object obj) {
            d dVar = (d) tVar;
            i iVar = (i) obj;
            dVar.jPx.setVisibility(8);
            dVar.iiS.setVisibility(0);
            a(dVar, bh.ov(iVar.appName) ? iVar.fnl.replaceFirst("@app", "") : iVar.appName);
            b(dVar, iVar.iJJ);
            boolean z = iVar.iJL;
            View view = dVar.jPA;
            int i = (this.jPj.jOI && z) ? 0 : 8;
            view.setVisibility(i);
            a(dVar, iVar.iGA);
            a(dVar);
        }

        public final /* synthetic */ boolean a(t tVar, Object obj, Object obj2) {
            d dVar = (d) tVar;
            if (obj2 == null || !(obj2 instanceof Bundle) || ((Bundle) obj2).size() <= 0) {
                return false;
            }
            Bundle bundle = (Bundle) obj2;
            if (bundle.containsKey("debug_type")) {
                a(dVar, bundle.getInt("debug_type", 0));
            }
            if (((Bundle) obj2).containsKey("nick_name")) {
                a(dVar, ((Bundle) obj2).getString("nick_name"));
            }
            if (((Bundle) obj2).get("running_flag") != null) {
                ((Bundle) obj2).getLong("running_flag");
            }
            if (((Bundle) obj2).get("icon") != null) {
                b(dVar, ((Bundle) obj2).getString("icon"));
            }
            a(dVar);
            return true;
        }

        public final /* synthetic */ long bf(Object obj) {
            i iVar = (i) obj;
            return (long) (iVar.fnl + iVar.iGA).hashCode();
        }

        private void a(d dVar) {
            this.jPj.jOQ;
            if (LoadMoreRecyclerView.aZ(dVar.VU) == this.jPj.jOS.getItemCount() - 1) {
                dVar.iiS.setVisibility(8);
            } else {
                dVar.iiS.setVisibility(0);
            }
            if (this.jPj.jOJ) {
                TextView textView = dVar.jPz;
                this.jPj.jOQ;
                textView.setText(String.valueOf(LoadMoreRecyclerView.aZ(dVar.VU)));
                dVar.jPz.setVisibility(0);
                return;
            }
            dVar.jPz.setVisibility(8);
        }

        private static void a(d dVar, int i) {
            CharSequence ju = com.tencent.mm.plugin.appbrand.appcache.a.ju(i);
            if (bh.ov(ju)) {
                dVar.jPy.setVisibility(8);
                return;
            }
            dVar.jPy.setText(ju);
            dVar.jPy.setVisibility(0);
        }

        private static void a(d dVar, String str) {
            dVar.jPw.setText(str);
        }

        final void b(d dVar, String str) {
            this.jPj.jPa;
            this.jPv.put(str, b.Jj().a(dVar.jMv, str, com.tencent.mm.modelappbrand.a.a.Ji(), f.hkr));
        }
    }

    static /* synthetic */ void a(a aVar, ArrayList arrayList) {
        if (aVar.jOI) {
            int size = aVar.jOT.alA().size();
            aVar.jOT.alA().clear();
            if (!bh.cA(arrayList)) {
                aVar.jOT.alA().addAll(arrayList);
                if (size <= 0) {
                    aVar.jOS.W(0, arrayList.size());
                    return;
                }
                int min = Math.min(size, arrayList.size());
                aVar.jOS.U(0, min);
                if (size == arrayList.size()) {
                    return;
                }
                if (size > arrayList.size()) {
                    aVar.jOS.X(min, size - arrayList.size());
                } else {
                    aVar.jOS.W(min, arrayList.size() - size);
                }
            } else if (size > 0) {
                aVar.jOS.X(0, size);
            }
        }
    }

    static /* synthetic */ void a(a aVar, ArrayList arrayList, boolean z) {
        aVar.alp();
        if (!(z || bh.cA(arrayList))) {
            com.tencent.mm.plugin.appbrand.appcache.l.ZL();
        }
        if (z) {
            aVar.jPb = true;
            aVar.jOO.set(false);
            aVar.jOY.setLoading(com.tencent.mm.plugin.appbrand.appusage.b.aaI());
        }
        int size;
        if (bh.cA(arrayList)) {
            if (z) {
                size = aVar.jOT.alA().size();
                int size2 = aVar.jOT.alB().size();
                aVar.jOT.alB().clear();
                if (size2 > 0) {
                    aVar.jOS.X(size, size2);
                }
                aVar.alo();
            }
        } else if (aVar.jOS != null && aVar.jOQ != null) {
            size = aVar.jOT.alA().size();
            aVar.jOT.alB().clear();
            aVar.jOT.alB().addAll(arrayList);
            aVar.jOS.U(size, arrayList.size());
        }
    }

    static /* synthetic */ void a(a aVar, boolean z, long j, boolean z2) {
        if (!aVar.aln()) {
            Object alC = aVar.jOT.alC();
            if (!bh.cA(alC) || z) {
                long j2;
                long j3;
                ArrayList alB = alC.alB();
                if (bh.cA(alB)) {
                    j2 = Long.MAX_VALUE;
                    j3 = 0;
                } else {
                    long j4 = ((i) alB.get(alB.size() - 1)).gLl;
                    j2 = Math.max(((i) alB.get(0)).gLl, j);
                    j3 = j4;
                }
                alB = i.c(aVar.jOI ? com.tencent.mm.plugin.appbrand.app.f.Zn().jF(j$b.iJT) : null, aVar.jOK.k(n.d(n.a(com.tencent.mm.plugin.appbrand.app.f.Zm().iKb.iKc).a("AppBrandLauncherLayoutItem", null, String.format(Locale.US, "%s>=? and %s<=? and %s=?", new Object[]{"updateTime", "updateTime", "scene"}), new String[]{String.valueOf(j3), String.valueOf(j2), "2"}, null, null, String.format(Locale.US, " %s desc ", new Object[]{"updateTime"}), 2))));
                if (!aVar.aln()) {
                    if (bh.cA(alB)) {
                        aVar.runOnUiThread(new Runnable(aVar) {
                            final /* synthetic */ a jPj;

                            {
                                this.jPj = r1;
                            }

                            public final void run() {
                                int size = this.jPj.jOT.size();
                                if (size > 0) {
                                    this.jPj.jOT.clear();
                                    this.jPj.jOS.X(0, size);
                                }
                                this.jPj.alo();
                            }
                        });
                    } else if (bh.cA(alC)) {
                        aVar.runOnUiThread(new 8(aVar, alB));
                    } else {
                        aVar.jOU.tS();
                        j.b a = j.a(new j(alC, alB), z2);
                        Object obj = (a.jSg == null || a.jSg.size() <= 0) ? null : 1;
                        if (obj != null) {
                            aVar.runOnUiThread(new 9(aVar, alB, a));
                        }
                        aVar.jOU.cfE();
                    }
                }
            }
        }
    }

    static /* synthetic */ void b(a aVar, ArrayList arrayList) {
        int size = aVar.jOT.size();
        if (!bh.cA(arrayList)) {
            aVar.jOT.alB().addAll(arrayList);
            aVar.jOS.W(size, arrayList.size());
            if (size > 0) {
                aVar.jOS.bj(size - 1);
            }
        } else if (!com.tencent.mm.plugin.appbrand.appusage.b.aaI()) {
            aVar.jOY.setLoading(false);
            if (aVar.jOY.VU != null) {
                aVar.jOY.VU.post(new 5(aVar));
            }
        } else if (!(aVar.jOY == null || aVar.jOY.VU == null || !aVar.jOY.VU.isShown())) {
            aVar.s(new 6(aVar));
        }
        aVar.jOO.set(false);
    }

    static /* synthetic */ void o(a aVar) {
        if (aVar.jPb && !aVar.jOO.get()) {
            aVar.jON.set(bh.Wp());
            if (com.tencent.mm.plugin.appbrand.appusage.b.aaI()) {
                com.tencent.mm.plugin.appbrand.appusage.b.aaH().a(aVar.jON.get(), false, aVar.jOL);
                aVar.jOO.set(true);
                return;
            }
            ArrayList alB = aVar.jOT.alB();
            aVar.jOU.F(new 4(aVar, bh.cA(alB) ? Long.MAX_VALUE : ((i) alB.get(alB.size() - 1)).gLl));
        }
    }

    public a() {
        boolean z = true;
        if (!(com.tencent.mm.sdk.a.b.ceK() && g.Dj().CU().getBoolean(com.tencent.mm.storage.w.a.xrM, false))) {
            z = false;
        }
        this.jOJ = z;
        this.jOK = new g(this.jOI);
        this.jOH = com.tencent.mm.plugin.appbrand.appusage.k.iJV != null ? com.tencent.mm.plugin.appbrand.appusage.k.iJV.intValue() : AppBrandGlobalSystemConfig.abS().iNw;
        com.tencent.mm.plugin.appbrand.app.f.Zn().iJN = this.jOH;
    }

    private boolean aln() {
        boolean z = true;
        MMActivity mMActivity = (MMActivity) getActivity();
        if (mMActivity == null) {
            return true;
        }
        synchronized (mMActivity) {
            if (!(mMActivity.isFinishing() || mMActivity.xIq)) {
                z = false;
            }
        }
        return z;
    }

    public final void onResume() {
        super.onResume();
        getActivity().setTitle(q.j.dDT);
        if (this.jOQ != null) {
            this.jOQ.R(false);
        }
        StringBuilder append = new StringBuilder().append(System.currentTimeMillis());
        g.Dh();
        this.mSceneId = append.append(o.getString(com.tencent.mm.kernel.a.Cg())).toString();
        int i = this.jaT + 1;
        this.jaT = i;
        if (i > 1 && this.jOX != null) {
            this.jOX.onResume();
        }
    }

    public final void onPause() {
        super.onPause();
        if (this.jOQ != null) {
            this.jOQ.R(true);
        }
    }

    public final void akE() {
        super.akE();
        if (this.jOQ != null) {
            this.jOQ.setAccessibilityDelegate(null);
        }
    }

    public final void onDestroyView() {
        super.onDestroyView();
        if (this.jOX != null) {
            this.jOX.onDetached();
        }
        if (this.jOY != null) {
            b bVar = this.jOY;
            bVar.VU = null;
            bVar.jPG = null;
            bVar.jPI = null;
        }
        if (this.jOS != null) {
            this.jOS.b(this.jPi);
        }
        if (this.jOW != null) {
            this.jOW.jPv.clear();
            this.jOW = null;
        }
        if (g.Dh().gPy && !com.tencent.mm.kernel.a.Cs()) {
            com.tencent.mm.plugin.appbrand.config.q.abY().j(this.jPg);
            com.tencent.mm.plugin.appbrand.app.f.Zm().j(this.jPf);
            com.tencent.mm.plugin.appbrand.app.f.Zn().j(this.jPe);
            com.tencent.mm.plugin.appbrand.appusage.b.aaH().j(this.jPh);
        }
        this.jOU.oAt.quit();
        this.jOM.set(-1);
        this.jON.set(-1);
        this.jOO.set(false);
        this.jOP.set(Long.MAX_VALUE);
        this.jOZ.c(this.jPi);
        this.jOZ.c(this.jPd);
    }

    public final void akD() {
        if (this.jOQ != null) {
            this.jOQ.smoothScrollToPosition(0);
        }
    }

    public final void lw(int i) {
        super.lw(i);
        this.jOL.putInt("launcher_ui_enter_scene", i);
    }

    public final void initView() {
        getActivity();
        this.jOR = new 15(this);
        this.jOQ = new 2(this, getContext());
        ((FrameLayout) this.Iv).addView(this.jOQ, new LayoutParams(-1, -1));
        this.jOQ.a(new f(this, (byte) 0));
        this.jOQ.a(this.jOZ);
        this.jOZ.b(this.jPi);
        this.jOZ.b(this.jPd);
        n nVar = new n(this.jOT);
        c cVar = new c();
        this.jOW = cVar;
        nVar.jRs.put(i.class.hashCode(), cVar);
        this.jOS = nVar;
        this.jOS.fP();
        this.jOS.a(this.jPi);
        this.jOQ.a(this.jOS);
        this.jOQ.a(new e(this, (byte) 0));
        this.jOX = new c(getActivity(), this.jOQ);
        this.jOQ.addHeaderView(this.jOX.alv());
        this.jOX.alv().setVisibility(8);
        this.jOX.alu();
        this.jOY = new b(getContext(), this.jOQ);
        this.jOY.setLoading(true);
        this.jOQ.cg(this.jOY.VU);
        this.jOQ.dB(true);
        this.jOQ.kge = new com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a(this) {
            final /* synthetic */ a jPj;

            {
                this.jPj = r1;
            }

            public final void akW() {
                b m = this.jPj.jOY;
                Object obj = (m.jPG == null || !m.jPG.isShown()) ? null : 1;
                if (obj != null) {
                    a.o(this.jPj);
                }
            }
        };
        if (com.tencent.mm.plugin.appbrand.l.a.ake()) {
            long currentTimeMillis = System.currentTimeMillis();
            Object obj = g.Dj().CU().get(com.tencent.mm.storage.w.a.xtH, null);
            long longValue = (obj == null || !(obj instanceof Long)) ? 0 : ((Long) obj).longValue();
            String language = Locale.getDefault().getLanguage();
            Object obj2 = g.Dj().CU().get(com.tencent.mm.storage.w.a.xtE, null);
            if (currentTimeMillis - longValue >= 3600000 || obj2 == null || !obj2.equals(language)) {
                g.Di().gPJ.a(new com.tencent.mm.plugin.appbrand.i.a(), 0);
            }
            x.v("MicroMsg.AppBrandSearchLogic", "tryToUpdateSearchInputHint, lang(o : %s, c : %s), lastUpdateTime(o : %s, c : %s)", new Object[]{obj2, language, Long.valueOf(longValue), Long.valueOf(currentTimeMillis)});
        } else {
            x.i("MicroMsg.AppBrandSearchLogic", "do not need to update search input hint, shouldShowSearchEntrance is false");
        }
        alp();
        this.jLV = com.tencent.mm.plugin.appbrand.ui.j.cf(getActivity());
        this.jLV.show();
        this.jOZ.jQS = false;
        com.tencent.mm.plugin.appbrand.config.q.abY().a(this.jPg, this.jOU.oAt.getLooper());
        com.tencent.mm.plugin.appbrand.app.f.Zm().a(this.jPf, this.jOU.oAt.getLooper());
        com.tencent.mm.plugin.appbrand.app.f.Zn().a(this.jPe, this.jOU.oAt.getLooper());
        com.tencent.mm.plugin.appbrand.appusage.b.aaH().a(this.jPh, this.jOU.oAt.getLooper());
        this.jOM.set(bh.Wp());
        this.jOU.J(new 7(this));
    }

    private boolean alo() {
        if (!this.jOS.isEmpty() || ((this.jOX.alv() != null && this.jOX.alv().getVisibility() == 0) || getActivity() == null)) {
            return true;
        }
        ((AppBrandLauncherUI) getActivity()).dg(false);
        return false;
    }

    private void alp() {
        if (this.jLV != null) {
            this.jLV.dismiss();
        }
        this.jLV = null;
    }
}
