package com.tencent.mm.pluginsdk.ui;

import android.widget.Toast;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.comm.a.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.MMGestureGallery.c;

class GetHdHeadImageGalleryView$b implements c {
    final /* synthetic */ GetHdHeadImageGalleryView vjL;

    private GetHdHeadImageGalleryView$b(GetHdHeadImageGalleryView getHdHeadImageGalleryView) {
        this.vjL = getHdHeadImageGalleryView;
    }

    public final void aJi() {
        if (GetHdHeadImageGalleryView.b(this.vjL) != null && GetHdHeadImageGalleryView.c(this.vjL) != null) {
            h.a(this.vjL.getContext(), null, this.vjL.getContext().getResources().getStringArray(a.lnF), "", new h.c(this) {
                final /* synthetic */ GetHdHeadImageGalleryView$b vjO;

                {
                    this.vjO = r1;
                }

                public final void jl(int i) {
                    switch (i) {
                        case 0:
                            String str = e.gHu + "hdImg_" + g.s(GetHdHeadImageGalleryView.c(this.vjO.vjL).getBytes()) + System.currentTimeMillis() + ".jpg";
                            FileOp.deleteFile(str);
                            FileOp.x(GetHdHeadImageGalleryView.b(this.vjO.vjL), str);
                            d.b(str, this.vjO.vjL.getContext());
                            Toast.makeText(this.vjO.vjL.getContext(), this.vjO.vjL.getContext().getString(com.tencent.mm.plugin.comm.a.h.enz, new Object[]{e.gHu}), 1).show();
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }
}
