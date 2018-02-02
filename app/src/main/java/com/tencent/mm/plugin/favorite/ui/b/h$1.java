package com.tencent.mm.plugin.favorite.ui.b;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.a.g;
import com.tencent.mm.av.a.a;
import com.tencent.mm.av.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;
import java.io.File;

class h$1 implements OnClickListener {
    final /* synthetic */ h myc;

    h$1(h hVar) {
        this.myc = hVar;
    }

    public final void onClick(View view) {
        if (!f.ze()) {
            u.fI(this.myc.mpb.context);
        } else if (view.getTag() instanceof com.tencent.mm.plugin.fav.a.f) {
            com.tencent.mm.plugin.fav.a.f fVar = (com.tencent.mm.plugin.fav.a.f) view.getTag();
            vk vkVar = fVar.field_favProto.weS;
            uq p = j.p(fVar);
            if (p == null) {
                x.w("MicroMsg.FavBaseListItem", "data item is null");
            } else if (e.l(p)) {
                x.i("MicroMsg.FavBaseListItem", "same song, do release");
                b.Qo();
                h.a(this.myc, null);
            } else {
                String absolutePath;
                File file = new File(j.i(p));
                if (file.exists()) {
                    absolutePath = file.getAbsolutePath();
                } else if (p.fqf == null) {
                    absolutePath = "";
                } else {
                    file = new File(j.aIE() + g.s(p.fqf.getBytes()));
                    absolutePath = file.exists() ? file.getAbsolutePath() : "";
                }
                b.b(((a) com.tencent.mm.kernel.g.h(a.class)).a(6, null, p.title, p.desc, p.wcQ, p.wcU, p.wcS, p.mvG, j.aIG(), absolutePath, "", vkVar.appId));
                h.a(this.myc, (ImageView) view);
            }
        }
    }
}
