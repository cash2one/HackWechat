package com.tencent.mm.plugin.webview.fts.ui;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.webview.fts.c.a;
import com.tencent.mm.sdk.platformtools.bc;

class b$4 extends bc<Boolean> {
    final /* synthetic */ int jhi;
    final /* synthetic */ b trB;
    final /* synthetic */ a trC;
    final /* synthetic */ boolean trD;

    public b$4(b bVar, Boolean bool, int i, a aVar, boolean z) {
        this.trB = bVar;
        this.jhi = i;
        this.trC = aVar;
        this.trD = z;
        super(1000, bool);
    }

    protected final /* synthetic */ Object run() {
        boolean z;
        b bVar = this.trB;
        int i = this.jhi;
        a aVar = this.trC;
        boolean z2 = this.trD;
        if (i == bVar.jFm) {
            z = false;
        } else {
            b.a Ag = bVar.Ag(i);
            if (Ag == null || Ag.jFA == null) {
                z = false;
            } else {
                View view = (View) Ag.jFA.get();
                if (view == null) {
                    z = false;
                } else {
                    b.a aVar2;
                    bVar.jFq = i;
                    ViewGroup lj = bVar.lj(Ag.jFB);
                    b.a Ag2 = bVar.Ag(Ag.jFB);
                    if (Ag2 != null) {
                        ViewGroup lj2 = bVar.lj(Ag2.jFB);
                        if (lj2 != null) {
                            View view2 = (View) Ag.jFA.get();
                            if (view2 != null) {
                                LayoutParams layoutParams = view2.getLayoutParams();
                                layoutParams.width = -1;
                                layoutParams.height = -1;
                                view2.setLayoutParams(layoutParams);
                            }
                            bVar.jFq = Ag2.id;
                            lj = lj2;
                            aVar2 = Ag2;
                            if (lj != null) {
                                view = (View) aVar2.jFA.get();
                                lj.addView(bVar.jFo, lj.indexOfChild(view));
                                lj.removeView(view);
                            }
                            bVar.jFn = new float[]{view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight(), (float) aVar2.z};
                            bVar.trA.j(view, z2);
                            bVar.jFm = i;
                            bVar.trz = aVar;
                            z = true;
                        }
                    }
                    aVar2 = Ag;
                    if (lj != null) {
                        view = (View) aVar2.jFA.get();
                        lj.addView(bVar.jFo, lj.indexOfChild(view));
                        lj.removeView(view);
                    }
                    bVar.jFn = new float[]{view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight(), (float) aVar2.z};
                    bVar.trA.j(view, z2);
                    bVar.jFm = i;
                    bVar.trz = aVar;
                    z = true;
                }
            }
        }
        return Boolean.valueOf(z);
    }
}
