package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bf.h;
import com.tencent.mm.bf.i;
import com.tencent.mm.bk.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.o;

class NearbySayHiListUI$a extends o<h> {
    int asN = -1;
    private MMActivity fmM;
    protected f kBC;
    protected c kBD;
    protected d kBF = MMSlideDelView.cpx();
    private i oPh;
    final /* synthetic */ NearbySayHiListUI oPo;
    protected e oPr;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (h) obj;
        if (obj == null) {
            obj = new h();
        }
        obj.b(cursor);
        return obj;
    }

    public NearbySayHiListUI$a(NearbySayHiListUI nearbySayHiListUI, Context context, i iVar, int i) {
        this.oPo = nearbySayHiListUI;
        super(context, new h());
        this.fmM = (MMActivity) context;
        this.asN = i;
        this.oPh = iVar;
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

    protected final void Xz() {
        Xy();
    }

    public final void Xy() {
        i iVar;
        if (a.bXU()) {
            iVar = this.oPh;
            int i = this.asN;
            setCursor(iVar.gJP.rawQuery("SELECT a.* FROM (" + ("SELECT sayhiencryptuser,max(createtime) createtime FROM " + iVar.getTableName() + " where isSend = 0 GROUP BY sayhiencryptuser LIMIT " + i) + ") b left join " + iVar.getTableName() + " a on b.sayhiencryptuser=a.sayhiencryptuser and b.createtime=a.createtime where a.isSend = 0 ORDER BY a.createtime desc LIMIT " + i, null));
        } else {
            iVar = this.oPh;
            setCursor(iVar.gJP.rawQuery("SELECT * FROM " + iVar.getTableName() + " where isSend = 0 ORDER BY createtime desc LIMIT " + this.asN, null));
        }
        super.notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        CharSequence charSequence;
        h hVar = (h) getItem(i);
        if (view == null) {
            a aVar2 = new a(this);
            View view2 = (MMSlideDelView) View.inflate(this.fmM, R.i.daY, null);
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
        if (hVar.field_flag != 0) {
            charSequence = au.d.Xu(hVar.field_content).fpL;
        } else {
            charSequence = hVar.field_talker;
        }
        aVar.hvZ.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.fmM, charSequence, aVar.hvZ.getTextSize()));
        aVar.onx.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.fmM, hVar.field_sayhicontent, aVar.onx.getTextSize()));
        aVar.kBM.setTag(Long.valueOf(hVar.field_svrid));
        aVar.kBM.setOnClickListener(new 1(this));
        b.a(aVar.ihQ, hVar.field_sayhiuser);
        return view;
    }
}
