package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bf.j;
import com.tencent.mm.bf.k;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.o;

final class b extends o<j> {
    private int asN = -1;
    private MMActivity fmM;
    protected f kBC;
    protected c kBD;
    protected d kBF = MMSlideDelView.cpx();
    protected e oPr;
    private k qqh;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (j) obj;
        if (obj == null) {
            obj = new j();
        }
        obj.b(cursor);
        return obj;
    }

    public b(Context context, k kVar, int i) {
        super(context, new j());
        this.fmM = (MMActivity) context;
        this.asN = i;
        this.qqh = kVar;
    }

    public final void a(f fVar) {
        this.kBC = fVar;
    }

    public final void a(e eVar) {
        this.oPr = eVar;
    }

    public final void a(c cVar) {
        this.kBD = cVar;
    }

    public final void wf(int i) {
        aUn();
        this.asN = i;
        Xy();
    }

    protected final void Xz() {
        Xy();
    }

    public final void Xy() {
        k kVar = this.qqh;
        setCursor(kVar.gJP.rawQuery("SELECT * FROM " + kVar.getTableName() + " where isSend = 0 ORDER BY createtime desc LIMIT " + this.asN, null));
        super.notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        j jVar = (j) getItem(i);
        if (view == null) {
            View view2 = (MMSlideDelView) View.inflate(this.fmM, R.i.daY, null);
            a aVar2 = new a();
            View inflate = View.inflate(this.fmM, R.i.dqS, null);
            aVar2.ihQ = (ImageView) inflate.findViewById(R.h.bYy);
            aVar2.hvZ = (TextView) inflate.findViewById(R.h.ccg);
            aVar2.onx = (TextView) inflate.findViewById(R.h.cIK);
            aVar2.kBM = view2.findViewById(R.h.cOC);
            aVar2.kBN = (TextView) view2.findViewById(R.h.cOD);
            view2.setView(inflate);
            view2.kBC = this.kBC;
            view2.kBD = this.kBD;
            view2.kBF = this.kBF;
            view2.mAK = false;
            view2.setTag(aVar2);
            view = view2;
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.kBM.setTag(Long.valueOf(jVar.field_svrid));
        aVar.kBM.setOnClickListener(new 1(this));
        aVar.hvZ.setText(i.b(this.fmM, au.d.Xu(jVar.field_content).getDisplayName(), aVar.hvZ.getTextSize()));
        aVar.onx.setText(jVar.field_sayhicontent);
        com.tencent.mm.pluginsdk.ui.a.b.a(aVar.ihQ, jVar.field_sayhiuser);
        return view;
    }
}
