package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.ReportStorageSizeTask;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.game.page.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.report.a.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class n extends FrameLayout {
    public e irP;
    public LinkedList<l> jDj = new LinkedList();
    private LinkedList<l> jDk = new LinkedList();
    private p jDl;
    public volatile a jDm;
    private boolean jDn = false;
    public a jDo;
    String mAppId;

    static /* synthetic */ void a(n nVar, int i) {
        if (nVar.jDj.size() <= 1) {
            c.a(nVar.mAppId, c.c.iqk);
            nVar.irP.close();
            return;
        }
        long Wp = bh.Wp();
        if (i <= 0) {
            i = 1;
        }
        if (i >= nVar.jDj.size()) {
            i = nVar.jDj.size() - 1;
        }
        l lVar = (l) nVar.jDj.getFirst();
        l lVar2 = (l) nVar.jDj.get(i);
        nVar.a(lVar, lVar2);
        nVar.a(lVar2, lVar, aa.jFG);
        nVar.jDm.g(bh.Wp() - Wp, 4);
        nVar.jDm.a(lVar2.aex(), lVar.aex(), aa.jFG);
    }

    static /* synthetic */ void a(n nVar, final l lVar, boolean z, final boolean z2) {
        if (lVar != null) {
            if (z2) {
                nVar.jDj.remove(lVar);
            }
            lVar.aet();
            Runnable anonymousClass6 = new Runnable(nVar) {
                final /* synthetic */ n jDp;

                public final void run() {
                    lVar.hide();
                    if (z2) {
                        this.jDp.a(lVar);
                    }
                }
            };
            if (z) {
                ObjectAnimator.ofFloat(lVar, "translationX", new float[]{0.0f, -(((float) lVar.getWidth()) * 0.25f)}).setDuration(250);
                ObjectAnimator.ofFloat(lVar, "translationX", new float[]{0.0f}).setDuration(0);
                Animator animatorSet = new AnimatorSet();
                animatorSet.playSequentially(new Animator[]{r1, r2});
                nVar.a(animatorSet, anonymousClass6);
                return;
            }
            anonymousClass6.run();
        }
    }

    static /* synthetic */ void a(n nVar, String str, aa aaVar) {
        x.i("MicroMsg.AppBrandPageContainer", "navigateTo: %s", new Object[]{str});
        if (bh.ov(str)) {
            str = nVar.irP.iqy.abM();
        }
        if (str.startsWith("?")) {
            str = nVar.irP.iqy.abM() + str;
        }
        x.i("MicroMsg.AppBrandPageContainer", "navigateTo: %s, fixed", new Object[]{str});
        if (aaVar != aa.jFK) {
            nVar.irP.iqP.a(str, new 15(nVar, str, aaVar));
        } else if (nVar.tH(str) != null) {
            nVar.tG(str);
        } else if (nVar.tI(str) != null) {
            nVar.tG(str);
        } else {
            nVar.b(str, aa.jFK);
        }
    }

    static /* synthetic */ void a(n nVar, String str, String str2, int[] iArr) {
        Iterator it = nVar.jDj.iterator();
        while (it.hasNext()) {
            ((l) it.next()).b(str, str2, iArr);
        }
        it = nVar.jDk.iterator();
        while (it.hasNext()) {
            ((l) it.next()).b(str, str2, iArr);
        }
    }

    static /* synthetic */ boolean b(aa aaVar) {
        return (aaVar == aa.jFE || aaVar == aa.jFH || aaVar == aa.jFI || aaVar == aa.jFJ) ? false : true;
    }

    static /* synthetic */ void c(n nVar) {
        if (!nVar.jDn) {
            nVar.jDn = true;
            nVar.jDo.YG();
            MainProcessTask reportStorageSizeTask = new ReportStorageSizeTask();
            reportStorageSizeTask.appId = nVar.mAppId;
            AppBrandMainProcessService.a(reportStorageSizeTask);
        }
    }

    static /* synthetic */ boolean c(aa aaVar) {
        return aaVar == aa.jFH || aaVar == aa.jFK || aaVar == aa.jFI || aaVar == aa.jFJ;
    }

    public n(Context context, e eVar) {
        super(context);
        this.irP = eVar;
        this.mAppId = eVar.mAppId;
        this.jDm = new a(this.irP);
    }

    public final void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }

    public final int getPageCount() {
        return this.jDj.size() + this.jDk.size();
    }

    public final void W(String str, boolean z) {
        runOnUiThread(new 12(this, str, z));
    }

    public final void aiR() {
        tE(this.irP.iqy.abM());
    }

    public final void tE(final String str) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ n jDp;

            public final void run() {
                n.a(this.jDp, str, aa.jFH);
            }
        });
    }

    public final void tF(final String str) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ n jDp;

            public final void run() {
                n.a(this.jDp, str, aa.jFK);
            }
        });
    }

    public final void aiS() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ n jDp;

            {
                this.jDp = r1;
            }

            public final void run() {
                this.jDp.ld(1);
            }
        });
    }

    public final void ld(int i) {
        runOnUiThread(new 17(this, i));
    }

    private void b(String str, aa aaVar) {
        View bVar;
        x.d("MicroMsg.AppBrandPageContainer", "navigateToNext: %s, Staging Count: %d", new Object[]{str, Integer.valueOf(this.jDk.size())});
        if (this.irP.Yz()) {
            bVar = new b(getContext(), this);
        } else {
            boolean z;
            if (!this.irP.Yz()) {
                if (aaVar == aa.jFK) {
                    z = true;
                } else if (aaVar == aa.jFI || aaVar == aa.jFJ) {
                    z = this.irP.iqy.iMA.qA(str);
                } else {
                    int size = (this.jDj.size() + 1) - (aaVar == aa.jFH ? 1 : 0);
                    if (this.irP.iqy.iMA.qA(str) && size == 1) {
                        z = true;
                    }
                }
                if (z) {
                    bVar = new s(getContext(), this);
                } else {
                    bVar = new e(getContext(), this);
                }
            }
            z = false;
            if (z) {
                bVar = new s(getContext(), this);
            } else {
                bVar = new e(getContext(), this);
            }
        }
        this.jDk.push(bVar);
        addView(bVar, 0);
        boolean[] zArr = new boolean[]{false};
        Runnable 2 = new 2(this, zArr, aaVar, bVar);
        if (this.jDj.size() == 0) {
            postDelayed(2, 5000);
        } else {
            postDelayed(2, 500);
        }
        bVar.aex().a(new 3(this, bVar, zArr, 2, System.currentTimeMillis(), aaVar));
        bVar.loadUrl(str);
        bVar.a(aaVar);
    }

    private void tG(String str) {
        p aex = aiT().aex();
        l tH = tH(str);
        if (tH != null) {
            tH.loadUrl(str);
            tH.a(aa.jFK);
            tH.aiQ();
        } else {
            l tI = tI(str);
            if (tI != null) {
                tI.loadUrl(str);
                tH = (l) this.jDj.getFirst();
                a(tH, tI);
                a(tI, tH, aa.jFK);
            }
            tH = tI;
        }
        if (tH != null) {
            this.jDm.a(tH.aex(), aex, aa.jFK);
        }
    }

    private void a(l lVar, l lVar2) {
        Iterator it = this.jDj.iterator();
        Object obj = null;
        while (it.hasNext()) {
            l lVar3 = (l) it.next();
            if (lVar3 == lVar) {
                obj = 1;
            } else if (lVar3 == lVar2) {
                return;
            } else {
                if (obj != null) {
                    a(lVar3);
                    it.remove();
                }
            }
        }
    }

    private void a(l lVar, final l lVar2, aa aaVar) {
        this.jDj.remove(lVar2);
        if (lVar2.mSwiping) {
            a(lVar2);
        } else {
            Runnable anonymousClass4 = new Runnable(this) {
                final /* synthetic */ n jDp;

                public final void run() {
                    this.jDp.a(lVar2);
                }
            };
            Animator ofFloat = ObjectAnimator.ofFloat(lVar2, "translationX", new float[]{0.0f, (float) lVar2.getWidth()});
            ofFloat.setDuration(250);
            a(ofFloat, anonymousClass4);
        }
        x.i("MicroMsg.AppBrandPageContainer", "switchPageClear, in: %s out: %s", new Object[]{lVar.aeq(), lVar2.aeq()});
        lVar.a(aaVar);
        lVar.aes();
        if (lVar2.mSwiping) {
            lVar.aiQ();
            return;
        }
        anonymousClass4 = new 5(this, lVar);
        ofFloat = ObjectAnimator.ofFloat(lVar, "translationX", new float[]{-(((float) lVar.getWidth()) * 0.25f), 0.0f});
        ofFloat.setDuration(250);
        a(ofFloat, anonymousClass4);
    }

    private synchronized void a(l lVar, boolean z) {
        if (lVar != null) {
            this.jDj.remove(lVar);
            this.jDj.push(lVar);
            this.jDk.remove(lVar);
            lVar.bringToFront();
            requestLayout();
            invalidate();
            lVar.aes();
            Runnable 7 = new 7(this, lVar);
            if (z) {
                Animator ofFloat = ObjectAnimator.ofFloat(lVar, "translationX", new float[]{(float) lVar.getWidth(), 0.0f});
                ofFloat.setDuration(250);
                a(ofFloat, 7);
            } else {
                7.run();
            }
        }
    }

    private l tH(String str) {
        if (this.jDj.size() == 0) {
            return null;
        }
        return ((this.jDj.getFirst() instanceof e) && ((l) this.jDj.getFirst()).rO(str)) ? (l) this.jDj.getFirst() : null;
    }

    private l tI(String str) {
        if (this.jDj.size() < 2) {
            return null;
        }
        int i = 1;
        while (i < this.jDj.size()) {
            if ((this.jDj.get(i) instanceof e) && ((l) this.jDj.get(i)).rO(str)) {
                return (l) this.jDj.get(i);
            }
            i++;
        }
        return null;
    }

    private void a(l lVar) {
        lVar.setVisibility(8);
        lVar.aer();
        removeView(lVar);
        lVar.cleanup();
    }

    public final void c(String str, String str2, int[] iArr) {
        runOnUiThread(new 8(this, str, str2, iArr));
    }

    public final synchronized l aiT() {
        l lVar;
        if (this.jDk.isEmpty()) {
            try {
                lVar = (l) this.jDj.getFirst();
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandPageContainer", e.getMessage());
                lVar = null;
            }
        } else {
            lVar = (l) this.jDk.getFirst();
        }
        return lVar;
    }

    public final synchronized String aeq() {
        String aeq;
        l aiT = aiT();
        if (aiT != null) {
            aeq = aiT.aeq();
        } else {
            aeq = null;
        }
        return aeq;
    }

    public final void cleanup() {
        if (!bh.cA(this.jDj)) {
            a aVar = this.jDm;
            p aex = aiT().aex();
            if (!(aex == null || aVar.jDf)) {
                aVar.d(aex);
            }
        }
        Iterator it = this.jDj.iterator();
        while (it.hasNext()) {
            l lVar = (l) it.next();
            lVar.aer();
            lVar.cleanup();
        }
        it = this.jDk.iterator();
        while (it.hasNext()) {
            lVar = (l) it.next();
            lVar.aer();
            lVar.cleanup();
        }
        if (this.jDl != null) {
            this.jDl.cleanup();
        }
        this.jDj.clear();
        this.jDk.clear();
    }

    public final p aiU() {
        p pVar = null;
        if (this.irP.Yz()) {
            return null;
        }
        if (this.jDl == null) {
            if (this.irP.iqy.iMD || !com.tencent.mm.plugin.appbrand.task.c.ako()) {
                pVar = com.tencent.mm.plugin.appbrand.task.c.uh(this.irP.mAppId);
            }
            if (pVar == null) {
                pVar = new p();
            }
            pVar.a(getContext(), this.irP);
            return pVar;
        }
        p pVar2 = this.jDl;
        this.jDl = null;
        pVar2.show();
        removeView(pVar2.getContentView());
        return pVar2;
    }

    public final void aiV() {
        if (!this.irP.Yz()) {
            postDelayed(new 9(this), 200);
        }
    }

    private void a(Animator animator, Runnable runnable) {
        animator.addListener(new 10(this, runnable));
        animator.start();
    }
}
