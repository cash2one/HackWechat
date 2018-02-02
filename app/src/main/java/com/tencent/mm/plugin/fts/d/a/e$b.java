package com.tencent.mm.plugin.fts.d.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.d.a.b.b;
import com.tencent.mm.plugin.fts.d.a.e.a;
import com.tencent.mm.plugin.fts.d.j$e;
import com.tencent.mm.plugin.fts.d.j.d;
import com.tencent.mm.plugin.fts.d.j.f;

public class e$b extends b {
    final /* synthetic */ e mPV;

    public e$b(e eVar) {
        this.mPV = eVar;
        super(eVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(j$e.djh, viewGroup, false);
        a aVar = new a(this.mPV);
        aVar.mPU = (TextView) inflate.findViewById(d.cRV);
        aVar.jCP = (ImageView) inflate.findViewById(d.coO);
        aVar.contentView = inflate.findViewById(d.cJK);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, b.a aVar, b bVar, Object... objArr) {
        a aVar2 = (a) aVar;
        e eVar = (e) bVar;
        cm(aVar2.contentView);
        aVar2.mPU.setText(eVar.mPR);
        aVar2.jCP.setImageResource(f.dyG);
    }

    public final boolean a(Context context, b bVar) {
        Intent intent = new Intent();
        intent.putExtra("detail_query", this.mPV.mMb.mLA);
        intent.putExtra("detail_type", this.mPV.mPx);
        intent.putExtra("Search_Scene", this.mPV.mOz);
        com.tencent.mm.bm.d.b(context, "search", ".ui.FTSDetailUI", intent);
        return true;
    }
}
