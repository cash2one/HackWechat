package com.tencent.mm.plugin.brandservice.ui;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.brandservice.a.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.List;

class SearchOrRecommendBizUI$1 implements e {
    final /* synthetic */ SearchOrRecommendBizUI kGV;

    SearchOrRecommendBizUI$1(SearchOrRecommendBizUI searchOrRecommendBizUI) {
        this.kGV = searchOrRecommendBizUI;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar == null) {
            x.e("MicroMsg.BrandService.SearchOrRecommendBizUI", "NetScene is null.");
        } else if (kVar.getType() != 456) {
            x.e("MicroMsg.BrandService.SearchOrRecommendBizUI", "The NetScene is not a RecommendGroupNetScene.");
        } else {
            ar.CG().b(456, this);
            x.i("MicroMsg.BrandService.SearchOrRecommendBizUI", "errType(%d) , errCode(%d) , errMsg(%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (i == 0 && i2 == 0) {
                List ask = g.ask();
                final f fVar = SearchOrRecommendBizUI.a(this.kGV) == null ? null : (f) SearchOrRecommendBizUI.a(this.kGV).kFE;
                if (fVar != null && ask != null && ask.size() > 0) {
                    int i3;
                    if (fVar.getCount() == 0) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    fVar.kGP = ask;
                    if (i3 != 0) {
                        ag.y(new Runnable(this) {
                            final /* synthetic */ SearchOrRecommendBizUI$1 kGX;

                            public final void run() {
                                x.i("MicroMsg.BrandService.SearchOrRecommendBizUI", "Has got recommend groups, so notifyDataSetChanged.");
                                fVar.notifyDataSetChanged();
                            }
                        });
                    }
                }
            }
        }
    }
}
