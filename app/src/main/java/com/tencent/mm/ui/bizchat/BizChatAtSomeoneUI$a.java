package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ag.a.e;
import com.tencent.mm.ag.a.j;
import com.tencent.mm.ag.a.k;
import com.tencent.mm.ag.y;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.a.a.c.a;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI.b;
import com.tencent.mm.ui.o;
import java.util.List;

class BizChatAtSomeoneUI$a extends o<j> {
    private List<String> kiU;
    private c lcT = null;
    String ldh;
    private com.tencent.mm.ag.a.c ync;
    private String[] ynf;
    private Bitmap yng;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        j jVar = new j();
        jVar.b(cursor);
        return jVar;
    }

    protected final /* bridge */ /* synthetic */ Object aRG() {
        return null;
    }

    public BizChatAtSomeoneUI$a(Context context, j jVar, com.tencent.mm.ag.a.c cVar, String[] strArr, List<String> list) {
        super(context, jVar);
        this.ync = cVar;
        this.ynf = strArr;
        this.kiU = list;
        a aVar = new a();
        aVar.hDD = e.ku(this.ync.field_brandUserName);
        aVar.hDA = true;
        aVar.hDX = true;
        aVar.hDP = R.k.bBB;
        this.lcT = aVar.PK();
        this.yng = d.u(context.getResources().getDrawable(R.k.dvN));
    }

    protected final int aRF() {
        return BizChatAtSomeoneUI.access$100() ? 1 : 0;
    }

    public final boolean qY(int i) {
        return false;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        View view2;
        if (view == null) {
            view = View.inflate(this.context, R.i.daB, null);
            b bVar2 = new b((byte) 0);
            bVar2.ldx = (MaskLayout) view.findViewById(R.h.bLk);
            bVar2.kEZ = (TextView) view.findViewById(R.h.bLl);
            view.setTag(bVar2);
            bVar = bVar2;
            view2 = view;
        } else {
            bVar = (b) view.getTag();
            view2 = view;
        }
        if (i == 0 && BizChatAtSomeoneUI.access$100()) {
            bVar.ynh.setImageBitmap(this.yng);
            bVar.kEZ.setText(this.context.getResources().getString(R.l.dHk, new Object[]{"@"}));
            return view2;
        }
        j jVar = (j) getItem(i - (BizChatAtSomeoneUI.access$100() ? 1 : 0));
        bVar.kEZ.setTextColor(com.tencent.mm.bv.a.Z(this.context, R.e.bth));
        com.tencent.mm.aq.o.PA().a(jVar.field_headImageUrl, (ImageView) bVar.ldx.view, this.lcT);
        bVar.ldx.cpQ();
        bVar.kEZ.setText(i.b(this.context, BizChatAtSomeoneUI.a(this.ync, jVar.field_userId), bVar.kEZ.getTextSize()));
        return view2;
    }

    public final void Xy() {
        String str;
        aUn();
        k Mj = y.Mj();
        String[] strArr = this.ynf;
        String str2 = this.ldh;
        List list = this.kiU;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select *  from BizChatUserInfo where ");
        StringBuilder append = stringBuilder.append(k.a(strArr, list));
        if (str2 == null || str2.equals("")) {
            str = "";
        } else {
            str = " and (" + "userName like '%" + str2 + "%' )";
        }
        append.append(str);
        StringBuilder append2 = stringBuilder.append(" order by ");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" case when length(BizChatUserInfo.userNamePY) > 0 then upper(").append("BizChatUserInfo.userNamePY) ");
        stringBuffer.append(" else upper(BizChatUserInfo.userName) end asc, ");
        stringBuffer.append(" upper(BizChatUserInfo.userNamePY) asc, ");
        stringBuffer.append(" upper(BizChatUserInfo.userName) asc ");
        append2.append(stringBuffer.toString());
        setCursor(Mj.gJP.rawQuery(stringBuilder.toString(), null));
        super.notifyDataSetChanged();
    }

    protected final void Xz() {
        Xy();
    }
}
