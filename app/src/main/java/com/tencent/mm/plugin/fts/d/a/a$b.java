package com.tencent.mm.plugin.fts.d.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.d.a.a.a;
import com.tencent.mm.plugin.fts.d.a.b.b;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.plugin.fts.d.j$e;
import com.tencent.mm.plugin.fts.d.j.d;
import com.tencent.mm.plugin.fts.d.j.g;

public class a$b extends b {
    final /* synthetic */ a mPu;

    public a$b(a aVar) {
        this.mPu = aVar;
        super(aVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(j$e.mPb, viewGroup, false);
        a aVar = this.mPu.mPr;
        aVar.mPs = (TextView) inflate.findViewById(d.mPa);
        aVar.mPt = (ImageView) inflate.findViewById(d.cxi);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, b.a aVar, b bVar, Object... objArr) {
        a aVar2 = (a) aVar;
        a aVar3 = (a) bVar;
        Resources resources = context.getResources();
        if (this.mPu.mPp) {
            e.a(resources.getString(g.mPm, new Object[]{resources.getString(aVar3.mPo)}), aVar2.mPs);
            aVar2.mPt.setRotation(0.0f);
            return;
        }
        e.a(resources.getString(g.mPn), aVar2.mPs);
        aVar2.mPt.setRotation(180.0f);
    }

    public final boolean a(Context context, b bVar) {
        return false;
    }
}
