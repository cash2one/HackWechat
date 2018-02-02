package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.sdk.platformtools.bh;

public final class h extends com.tencent.mm.plugin.fts.d.a.b {
    public String mLS;
    public boolean qej;
    public CharSequence qek;
    private b qel;
    private a qem;

    public class a extends com.tencent.mm.plugin.fts.d.a.b.a {
        public View contentView;
        public ImageView jCP;
        public View mPK;
        public TextView mPU;
        final /* synthetic */ h qen;

        public a(h hVar) {
            this.qen = hVar;
            super(hVar);
        }
    }

    public class b extends com.tencent.mm.plugin.fts.d.a.b.b {
        final /* synthetic */ h qen;

        public b(h hVar) {
            this.qen = hVar;
            super(hVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.i.diS, viewGroup, false);
            a aVar = new a(this.qen);
            aVar.mPU = (TextView) inflate.findViewById(R.h.cRV);
            aVar.jCP = (ImageView) inflate.findViewById(R.h.coO);
            aVar.mPK = inflate.findViewById(R.h.cCk);
            aVar.contentView = inflate.findViewById(R.h.cJK);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, com.tencent.mm.plugin.fts.d.a.b bVar, Object... objArr) {
            a aVar2 = (a) aVar;
            h hVar = (h) bVar;
            cm(aVar2.contentView);
            aVar2.mPU.setText(hVar.qek);
            aVar2.jCP.setImageResource(R.k.dyG);
            if (this.qen.position == 0 || !this.qen.qej) {
                aVar2.mPK.setVisibility(8);
            } else {
                aVar2.mPK.setVisibility(0);
            }
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.b bVar) {
            Intent intent = new Intent();
            intent.putExtra("key_talker_query", this.qen.mMb.mLD[0]);
            intent.putExtra("key_query", this.qen.mMb.mLD[1]);
            intent.putExtra("Search_Scene", this.qen.mOz);
            if (bh.ov(this.qen.mLS)) {
                d.b(context, "search", ".ui.FTSTalkerMessageUI", intent);
            } else {
                intent.putExtra("key_conv", this.qen.mLS);
                intent.putExtra("detail_type", 1);
                d.b(context, "search", ".ui.FTSConvTalkerMessageUI", intent);
            }
            return true;
        }
    }

    public h(int i) {
        super(19, i);
        this.qel = new b(this);
        this.qem = new a(this);
        this.mPw = false;
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, Object... objArr) {
        CharSequence ellipsize = TextUtils.ellipsize(this.mMb.mLD[0], com.tencent.mm.plugin.fts.d.d.b.mOJ, 200.0f, TruncateAt.MIDDLE);
        CharSequence ellipsize2 = TextUtils.ellipsize(this.mMb.mLD[1], com.tencent.mm.plugin.fts.d.d.b.mOJ, 400.0f, TruncateAt.MIDDLE);
        if (bh.ov(this.mLS)) {
            this.qek = TextUtils.concat(new CharSequence[]{context.getString(R.l.eIZ), f.b(ellipsize, ellipsize.length()), context.getString(R.l.eJa), f.b(ellipsize2, ellipsize2.length()), context.getString(R.l.eJb)});
            return;
        }
        this.qek = TextUtils.concat(new CharSequence[]{context.getString(R.l.eJc), f.b(ellipsize, ellipsize.length()), context.getString(R.l.eJa), f.b(ellipsize2, ellipsize2.length()), context.getString(R.l.eJb)});
    }

    public final com.tencent.mm.plugin.fts.d.a.b.b adp() {
        return this.qel;
    }

    protected final com.tencent.mm.plugin.fts.d.a.b.a adq() {
        return this.qem;
    }
}
