package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.d.a.b.b;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.plugin.search.ui.a.o.a;

public class o$b extends b {
    final /* synthetic */ o qeP;

    public o$b(o oVar) {
        this.qeP = oVar;
        super(oVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.i.diO, viewGroup, false);
        a aVar = this.qeP.qeO;
        aVar.iip = (ImageView) inflate.findViewById(R.h.bLL);
        aVar.iiq = (TextView) inflate.findViewById(R.h.cSu);
        aVar.iir = (TextView) inflate.findViewById(R.h.caS);
        aVar.contentView = inflate.findViewById(R.h.cJK);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, com.tencent.mm.plugin.fts.d.a.b bVar, Object... objArr) {
        a aVar2 = (a) aVar;
        o oVar = (o) bVar;
        cm(aVar2.contentView);
        if (oVar.username == null || oVar.username.length() <= 0) {
            aVar2.iip.setImageResource(R.g.bBB);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.a(aVar2.iip, oVar.username);
        }
        aVar2.iiq.setText(oVar.kHu);
        aVar2.iiq.setMaxWidth(com.tencent.mm.bv.a.fromDPToPix(context, 200));
        e.a(oVar.kHv, aVar2.iir);
    }

    public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.b bVar) {
        o oVar = (o) bVar;
        a(this.qeP.mMb.mLA, oVar.iVU);
        com.tencent.mm.plugin.search.a.ifs.e(new Intent().putExtra("Chat_User", oVar.username).putExtra("finish_direct", true), context);
        return true;
    }
}
