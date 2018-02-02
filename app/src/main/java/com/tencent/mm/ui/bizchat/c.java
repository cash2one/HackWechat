package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ag.y;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView$c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.o.a;

public final class c extends o<com.tencent.mm.ag.a.c> implements b {
    private final MMActivity fmM;
    protected f kBC;
    protected MMSlideDelView$c kBD;
    protected e kBE;
    protected d kBF = MMSlideDelView.cpx();
    private final String kGH;
    private com.tencent.mm.aq.a.a.c lcT = null;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (com.tencent.mm.ag.a.c) obj;
        if (obj == null) {
            obj = new com.tencent.mm.ag.a.c();
        }
        obj.b(cursor);
        return obj;
    }

    public c(Context context, a aVar, String str) {
        super(context, new com.tencent.mm.ag.a.c());
        this.xIi = aVar;
        this.fmM = (MMActivity) context;
        this.kGH = str;
        com.tencent.mm.aq.a.a.c.a aVar2 = new com.tencent.mm.aq.a.a.c.a();
        aVar2.hDD = com.tencent.mm.ag.a.e.bZ(this.kGH);
        aVar2.hDA = true;
        aVar2.hDX = true;
        aVar2.hDP = R.k.bBB;
        this.lcT = aVar2.PK();
    }

    public final void Xy() {
        aUn();
        com.tencent.mm.ag.a.d Mh = y.Mh();
        String str = this.kGH;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from BizChatInfo");
        stringBuilder.append(" where brandUserName = '").append(str).append("'");
        stringBuilder.append(" and (bitFlag & 8").append(") != 0 ");
        StringBuilder append = stringBuilder.append(" order by ");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" case when length(BizChatInfo.chatNamePY) > 0 then upper(").append("BizChatInfo.chatNamePY) ");
        stringBuffer.append(" else upper(BizChatInfo.chatName) end asc, ");
        stringBuffer.append(" upper(BizChatInfo.chatNamePY) asc, ");
        stringBuffer.append(" upper(BizChatInfo.chatName) asc ");
        append.append(stringBuffer.toString());
        x.d("MicroMsg.BizChatInfoStorage", "getBizChatFavCursor: sql:%s", new Object[]{stringBuilder.toString()});
        setCursor(Mh.gJP.rawQuery(stringBuilder.toString(), null));
        if (this.xIi != null) {
            this.xIi.Xv();
        }
        super.notifyDataSetChanged();
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final void a(f fVar) {
        this.kBC = fVar;
    }

    public final void a(e eVar) {
        this.kBE = eVar;
    }

    public final void a(MMSlideDelView$c mMSlideDelView$c) {
        this.kBD = mMSlideDelView$c;
    }

    public final int getItemViewType(int i) {
        return 0;
    }

    public final void onPause() {
        if (this.kBF != null) {
            this.kBF.aUy();
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        com.tencent.mm.ag.a.c cVar = (com.tencent.mm.ag.a.c) getItem(i);
        if (view == null) {
            a aVar2 = new a();
            view = View.inflate(this.fmM, R.i.dgt, null);
            aVar2.iip = (ImageView) view.findViewById(R.h.bLL);
            aVar2.kBH = (TextView) view.findViewById(R.h.cyB);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        com.tencent.mm.aq.o.PA().a(cVar.field_headImageUrl, aVar.iip, this.lcT);
        aVar.kBH.setText(i.c(this.fmM, cVar.field_chatName, (int) aVar.kBH.getTextSize()));
        return view;
    }

    protected final void Xz() {
        Xy();
    }

    public final void a(int i, m mVar, Object obj) {
        super.a(i, mVar, obj);
    }
}
