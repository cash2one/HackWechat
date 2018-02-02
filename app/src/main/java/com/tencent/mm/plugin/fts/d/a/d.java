package com.tencent.mm.plugin.fts.d.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.d.d$b;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.plugin.fts.d.j.e;
import com.tencent.mm.plugin.fts.d.j.g;

public final class d extends b {
    CharSequence mPM;
    private com.tencent.mm.plugin.fts.d.a.b.b mPN = new b(this);
    com.tencent.mm.plugin.fts.d.a.b.a mPO = new a(this);

    public class a extends com.tencent.mm.plugin.fts.d.a.b.a {
        public View mPK;
        public TextView mPP;
        final /* synthetic */ d mPQ;

        public a(d dVar) {
            this.mPQ = dVar;
            super(dVar);
        }
    }

    public class b extends com.tencent.mm.plugin.fts.d.a.b.b {
        final /* synthetic */ d mPQ;

        public b(d dVar) {
            this.mPQ = dVar;
            super(dVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(e.mPc, viewGroup, false);
            a aVar = (a) this.mPQ.mPO;
            aVar.mPP = (TextView) inflate.findViewById(com.tencent.mm.plugin.fts.d.j.d.cpO);
            aVar.mPK = inflate.findViewById(com.tencent.mm.plugin.fts.d.j.d.cCk);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, b bVar, Object... objArr) {
            a aVar2 = (a) aVar;
            com.tencent.mm.plugin.fts.d.e.a(this.mPQ.mPM, aVar2.mPP);
            if (this.mPQ.position == 0) {
                aVar2.mPK.setVisibility(8);
            } else {
                aVar2.mPK.setVisibility(0);
            }
        }

        public final boolean a(Context context, b bVar) {
            return false;
        }
    }

    public d(int i) {
        super(18, i);
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, Object... objArr) {
        Object charSequence = TextUtils.ellipsize(this.mMb.mLA, d$b.mOJ, 400.0f, TruncateAt.MIDDLE).toString();
        this.mPM = f.a(context.getString(g.eIE), context.getString(g.eID), com.tencent.mm.plugin.fts.d.b.a.d(charSequence, charSequence)).mQk;
    }

    public final com.tencent.mm.plugin.fts.d.a.b.b adp() {
        return this.mPN;
    }

    protected final com.tencent.mm.plugin.fts.d.a.b.a adq() {
        return this.mPO;
    }
}
