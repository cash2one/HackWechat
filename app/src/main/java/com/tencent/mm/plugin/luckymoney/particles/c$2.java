package com.tencent.mm.plugin.luckymoney.particles;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mm.plugin.luckymoney.particles.a.b;
import java.util.Iterator;

class c$2 implements AnimatorUpdateListener {
    final /* synthetic */ c oeD;

    c$2(c cVar) {
        this.oeD = cVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        long currentPlayTime = valueAnimator.getCurrentPlayTime();
        c cVar = this.oeD;
        if (currentPlayTime < cVar.oec) {
            if (cVar.oea == 0) {
                cVar.oea = currentPlayTime;
            } else {
                int nextFloat = (int) ((cVar.random.nextFloat() * cVar.oed) * ((float) (currentPlayTime - cVar.oea)));
                if (nextFloat > 0) {
                    cVar.oea = (long) (((float) cVar.oea) + (cVar.oee * ((float) nextFloat)));
                    cVar.z(nextFloat, currentPlayTime);
                }
            }
        }
        c cVar2 = this.oeD;
        Iterator it = cVar2.odZ.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.oeQ == -1) {
                bVar.oeQ = currentPlayTime;
            }
            long j = currentPlayTime - bVar.oeQ;
            bVar.off = j >= 0;
            if (bVar.off && !bVar.terminated) {
                bVar.ofc = b.a(j, bVar.oeR, bVar.oeT, bVar.oel, bVar.oeV, bVar.oep);
                bVar.ofd = b.a(j, bVar.oeS, bVar.oeU, bVar.oen, bVar.oeW, bVar.oer);
                bVar.ofe = b.a(j, bVar.oeX, bVar.oeY, bVar.oex, bVar.oeZ, bVar.oez);
                if (bVar.oef != null) {
                    bVar.alpha = (int) (bVar.oef.getInterpolation(((float) j) / bVar.ofa) * 255.0f);
                } else {
                    bVar.alpha = 255;
                }
                boolean z = !bVar.ofg && ((float) j) >= bVar.ofa;
                bVar.terminated = z;
                bVar.ofb = Math.min(1.0f, ((float) j) / bVar.ofa);
            }
            if ((!bVar.terminated ? 1 : null) == null) {
                it.remove();
                cVar2.odY.add(bVar);
            }
        }
        if (this.oeD.odZ.size() != 0 || currentPlayTime < this.oeD.oec) {
            this.oeD.odX.invalidate();
        } else {
            this.oeD.aXn();
        }
    }
}
