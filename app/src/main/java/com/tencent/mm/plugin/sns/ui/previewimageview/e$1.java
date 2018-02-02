package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build.VERSION;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.e;
import com.tencent.mm.plugin.sns.ui.previewimageview.e.7;
import com.tencent.mm.sdk.platformtools.x;

class e$1 implements e {
    final /* synthetic */ DynamicGridView rQy;
    final /* synthetic */ e rQz;

    e$1(e eVar, DynamicGridView dynamicGridView) {
        this.rQz = eVar;
        this.rQy = dynamicGridView;
    }

    public final void xT(int i) {
        x.i("DynamicGrid", "drag started at position " + i);
        if (VERSION.SDK_INT >= 21) {
            this.rQz.rQt = this.rQy.getElevation();
            this.rQy.setElevation(100.0f);
        } else {
            this.rQy.bringToFront();
        }
        e eVar = this.rQz;
        eVar.rQu.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(eVar.rQu, "translationY", new float[]{(float) eVar.rQu.getHeight(), 0.0f});
        ofFloat.setDuration(200);
        ofFloat.start();
        e.a(this.rQz);
    }

    public final void xU(int i) {
        x.i("DynamicGrid", "drag to del " + i);
        a aVar = this.rQz.rQq;
        Object item = aVar.getItem(i);
        aVar.ep.remove(item);
        aVar.rQi.remove(item);
        aVar.notifyDataSetChanged();
        if (aVar.rQn != null) {
            aVar.rQn.removeItem(i - aVar.rQj);
        }
    }

    public final void j(Rect rect) {
        if (k(rect)) {
            e eVar = this.rQz;
            eVar.rQu.setBackgroundColor(Color.parseColor("#ce3c39"));
            eVar.rQv.setImageResource(i.qJb);
            eVar.rth.setText("松手即可删除");
            return;
        }
        e.b(this.rQz);
    }

    public final void bCs() {
        e eVar = this.rQz;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(eVar.rQu, "translationY", new float[]{0.0f, (float) eVar.rQu.getHeight()});
        ofFloat.setDuration(200);
        ofFloat.addListener(new 7(eVar));
        ofFloat.start();
        this.rQz.rQq.bCp();
    }

    public final boolean k(Rect rect) {
        e eVar = this.rQz;
        if (rect == null) {
            return false;
        }
        if (eVar.rQx == null) {
            eVar.rQx = new Rect(eVar.rQu.getLeft(), eVar.rQu.getTop(), eVar.rQu.getRight(), eVar.rQu.getBottom());
        }
        x.d("DynamicGrid", "del area " + eVar.rQx + ", test rect " + rect);
        return eVar.rQx.intersects(rect.left, rect.top, rect.right, rect.bottom);
    }
}
