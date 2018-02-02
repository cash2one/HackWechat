package com.tencent.mm.plugin.luckymoney.particles;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mm.plugin.luckymoney.particles.c.2;
import com.tencent.mm.plugin.wxpay.a.d;
import java.util.Iterator;

public final class a {
    private static int odN;
    private static int odO;
    private static int odP;
    private static int odQ;
    private static int odR;
    private static int odS;
    public c odT;

    public a(ViewGroup viewGroup) {
        if (odN == 0) {
            Resources resources = viewGroup.getResources();
            odN = resources.getDimensionPixelSize(d.ubR);
            odO = resources.getDimensionPixelOffset(d.ubV);
            odP = resources.getDimensionPixelOffset(d.ubU);
            odQ = resources.getDimensionPixelOffset(d.ubT);
            odR = resources.getDimensionPixelOffset(d.ubW);
            odS = resources.getDimensionPixelOffset(d.ubS);
        }
    }

    public static a a(ViewGroup viewGroup, b bVar) {
        a aVar = new a(viewGroup);
        c ak = new c(viewGroup.getContext(), bVar, new d(viewGroup.getWidth() / 2, viewGroup.getHeight() + 400), viewGroup).y(0.0f, 800.0f).z(-2000.0f, 1250.0f).ak(2000.0f);
        ak.oeB = 3000.0f;
        ak.oeC = 500.0f;
        ak = ak.aXk();
        ak.oef = e.aXo();
        aVar.odT = ak.aXl().aXm();
        return aVar;
    }

    public final c y(int i, long j) {
        c cVar = this.odT;
        cVar.oeb = 0;
        cVar.oec = j;
        cVar.oed = ((float) i) / 1000.0f;
        cVar.oee = 1.0f / cVar.oed;
        if (cVar.jWC != null) {
            cVar.jWC.cancel();
        }
        cVar.oea = 0;
        Iterator it = cVar.odZ.iterator();
        while (it.hasNext()) {
            cVar.odY.add(it.next());
            it.remove();
        }
        ViewParent parent = cVar.odX.getParent();
        if (parent != null) {
            if (parent != cVar.odW) {
                ((ViewGroup) parent).removeView(cVar.odX);
            }
            cVar.odX.terminated = false;
            cVar.z(cVar.oeb, 0);
            cVar.jWC = ValueAnimator.ofInt(new int[]{0}).setDuration(Long.MAX_VALUE);
            cVar.jWC.addUpdateListener(new 2(cVar));
            cVar.jWC.start();
            return cVar;
        }
        cVar.odW.addView(cVar.odX);
        cVar.odX.terminated = false;
        cVar.z(cVar.oeb, 0);
        cVar.jWC = ValueAnimator.ofInt(new int[]{0}).setDuration(Long.MAX_VALUE);
        cVar.jWC.addUpdateListener(new 2(cVar));
        cVar.jWC.start();
        return cVar;
    }
}
