package com.tencent.mm.plugin.appbrand.game.c;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.game.c.b.3;
import com.tencent.mm.plugin.appbrand.game.c.b.4;

class b$1 implements OnClickListener {
    final /* synthetic */ b iYt;

    b$1(b bVar) {
        this.iYt = bVar;
    }

    public final void onClick(View view) {
        b bVar = this.iYt;
        if (bVar.iYp) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            ofFloat.addUpdateListener(new 3(bVar));
            ofFloat.start();
            bVar.iYp = false;
            return;
        }
        ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat.addUpdateListener(new 4(bVar));
        ofFloat.start();
        bVar.iYp = true;
    }
}
