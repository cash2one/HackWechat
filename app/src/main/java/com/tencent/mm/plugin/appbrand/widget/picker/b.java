package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.widget.input.l;
import com.tencent.mm.sdk.platformtools.x;

public abstract class b {
    public a kcP;

    public abstract View agG();

    public final <T extends e> T y(Class<T> cls) {
        d dz = dz(true);
        this.kcP = dz;
        if (dz == null) {
            return null;
        }
        if (!cls.isInstance(dz.kdn)) {
            try {
                e eVar = (e) cls.getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{dz.getContext()});
                if (dz.kdn == null || eVar == null || eVar.getClass() != dz.kdn.getClass()) {
                    if (dz.kdn != null) {
                        dz.kdn.anI();
                    }
                    dz.kdn = eVar;
                    if (dz.kdn != null) {
                        dz.kdn.b(dz);
                    }
                    if (!(dz.kdo == null || dz.kdn == null || dz.kdn.getView() == null)) {
                        dz.kdo.removeAllViews();
                        dz.anM();
                        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                        layoutParams.gravity = 17;
                        dz.kdo.addView(dz.kdn.getView(), layoutParams);
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandBottomPickerInvokeHandler", "newInstance class[%s], exp[%s]", cls.getSimpleName(), e);
                return null;
            }
        }
        return dz.kdn;
    }

    public final a dz(boolean z) {
        if (this.kcP != null) {
            return this.kcP;
        }
        if (agG() == null) {
            return null;
        }
        View bS = l.bS(agG());
        if (bS == null) {
            return null;
        }
        a ce = a.ce(bS);
        if (ce != null || !z) {
            return ce;
        }
        ce = new a(agG().getContext());
        bS.g(ce, true);
        return ce;
    }
}
