package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.plugin.search.ui.a.k.a;
import com.tencent.mm.plugin.search.ui.a.k.b;
import com.tencent.mm.sdk.platformtools.bh;

public class f$a extends b {
    final /* synthetic */ f qee;

    public f$a(f fVar) {
        this.qee = fVar;
        super(fVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.i.djg, viewGroup, false);
        a aVar = this.qee.qeC;
        aVar.iip = (ImageView) inflate.findViewById(R.h.bLL);
        aVar.kBH = (TextView) inflate.findViewById(R.h.cAn);
        aVar.ldJ = (TextView) inflate.findViewById(R.h.cxH);
        aVar.contentView = inflate.findViewById(R.h.cJK);
        aVar.ldK = (TextView) inflate.findViewById(R.h.cRs);
        aVar.iip.getLayoutParams().width = com.tencent.mm.bv.a.aa(context, R.f.bvP);
        aVar.iip.getLayoutParams().height = com.tencent.mm.bv.a.aa(context, R.f.bvP);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, com.tencent.mm.plugin.fts.d.a.b bVar, Object... objArr) {
        f fVar = (f) bVar;
        a aVar2 = (a) aVar;
        cm(aVar2.contentView);
        if (bh.ov(fVar.iVU.talker)) {
            com.tencent.mm.pluginsdk.ui.a.b.a(aVar2.iip, fVar.iVU.mLs);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.a(aVar2.iip, fVar.iVU.talker);
        }
        e.a(fVar.qed, aVar2.kBH);
        e.a(fVar.iim, aVar2.ldJ);
        e.a(fVar.qeA, aVar2.ldK);
    }
}
