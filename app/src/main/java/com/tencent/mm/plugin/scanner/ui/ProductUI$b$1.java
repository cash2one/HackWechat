package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.plugin.scanner.ui.ProductUI.b;
import com.tencent.mm.sdk.platformtools.x;

class ProductUI$b$1 implements ProductScrollView$a {
    final /* synthetic */ b pWz;

    ProductUI$b$1(b bVar) {
        this.pWz = bVar;
    }

    public final void aFi() {
        float f = 1.0f;
        b bVar = this.pWz;
        int scrollY = bVar.pWw.getScrollY();
        float x = scrollY < 0 ? -1.0f : (scrollY >= ProductUI.x(bVar.pWr) - bVar.MP || ((float) ProductUI.x(bVar.pWr)) == 0.0f) ? 1.0f : (((float) scrollY) * 1.37f) / ((float) ProductUI.x(bVar.pWr));
        x.v("MicroMsg.ProductUI.HeaderEffectHelper", "rate=" + x);
        if (x != 1.0f) {
            bVar.pWx = false;
        } else if (!bVar.pWx) {
            bVar.pWx = true;
        } else {
            return;
        }
        if (ProductUI.v(bVar.pWr) != null) {
            float f2 = (1.0f - x) - 0.2f;
            if (f2 <= 0.0f) {
                f2 = 0.0f;
            }
            if (x == 0.0f) {
                f2 = 1.0f;
            }
            ProductUI.k(ProductUI.v(bVar.pWr), f2);
        }
        if (ProductUI.w(bVar.pWr) != null) {
            if (x == 0.0f) {
                f = 0.0f;
            } else if (x >= 0.0f) {
                x += 0.2f;
                if (x <= 1.0f) {
                    f = x;
                }
            }
            ProductUI.k(ProductUI.w(bVar.pWr), f);
        }
    }
}
