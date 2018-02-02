package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.x;

class g$1 implements OnClickListener {
    final /* synthetic */ g rjg;

    g$1(g gVar) {
        this.rjg = gVar;
    }

    public final void onClick(View view) {
        g gVar = this.rjg;
        gVar.riW++;
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 1);
        intent.putExtra("kwebmap_slat", this.rjg.rjd.rfZ.nQx);
        intent.putExtra("kwebmap_lng", this.rjg.rjd.rfZ.nQy);
        intent.putExtra("kwebmap_scale", this.rjg.rjd.rfZ.fzv);
        intent.putExtra("kPoiName", this.rjg.rjd.rfZ.fDu);
        intent.putExtra("Kwebmap_locaion", this.rjg.rjd.rfZ.nQz);
        x.i("AdLandingBorderedComp", "locatint to slat " + this.rjg.rjd.rfZ.nQx + ", slong " + this.rjg.rjd.rfZ.nQy + ", " + this.rjg.rjd.rfZ.fDu);
        d.b(this.rjg.context, "location", ".ui.RedirectUI", intent, 2);
    }
}
