package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.d.a.b.a;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.storage.x;

public abstract class b extends com.tencent.mm.plugin.fts.d.a.b {
    public j iVU;
    public x jLe;
    public CharSequence kHu;
    public CharSequence kHv;
    a qdI = new a(this);
    public String username;

    public abstract class b extends com.tencent.mm.plugin.fts.d.a.b.b {
        final /* synthetic */ b qdJ;

        public b(b bVar) {
            this.qdJ = bVar;
            super(bVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.i.diO, viewGroup, false);
            a aVar = this.qdJ.qdI;
            aVar.iip = (ImageView) inflate.findViewById(R.h.bLL);
            aVar.iiq = (TextView) inflate.findViewById(R.h.cSu);
            aVar.iir = (TextView) inflate.findViewById(R.h.caS);
            aVar.contentView = inflate.findViewById(R.h.cJK);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, a aVar, com.tencent.mm.plugin.fts.d.a.b bVar, Object... objArr) {
            a aVar2 = (a) aVar;
            b bVar2 = (b) bVar;
            cm(aVar2.contentView);
            com.tencent.mm.pluginsdk.ui.a.b.a(aVar2.iip, bVar2.username);
            e.a(bVar2.kHu, aVar2.iiq);
            e.a(bVar2.kHv, aVar2.iir);
        }
    }

    public b(int i) {
        super(1, i);
    }

    protected final a adq() {
        return this.qdI;
    }

    public final int ads() {
        return this.iVU.mMo;
    }
}
