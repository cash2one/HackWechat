package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.e;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.y;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.applet.b$b;
import com.tencent.mm.ui.o;
import com.tencent.mm.z.ar;
import com.tencent.wcdb.FileUtils;

class EnterpriseBizContactPlainListUI$a extends o<b> implements m.b {
    com.tencent.mm.ui.applet.b hvU = new com.tencent.mm.ui.applet.b(new 1(this));
    private b$b hvV = null;
    final /* synthetic */ EnterpriseBizContactPlainListUI kGD;

    class a {
        ImageView hvY;
        TextView hvZ;
        final /* synthetic */ EnterpriseBizContactPlainListUI$a kGG;

        a(EnterpriseBizContactPlainListUI$a enterpriseBizContactPlainListUI$a) {
            this.kGG = enterpriseBizContactPlainListUI$a;
        }

        public final void clear() {
            if (this.hvY != null) {
                this.hvY.setImageDrawable(null);
                this.hvY.setVisibility(8);
            }
            if (this.hvZ != null) {
                this.hvZ.setText("");
                this.hvZ.setVisibility(8);
            }
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (b) obj;
        if (obj == null) {
            x.e("MicroMsg.EnterpriseBizListAdapter", "item == null");
            obj = new b();
        }
        if (cursor != null) {
            af xVar = new com.tencent.mm.storage.x();
            xVar.b(cursor);
            d dVar = new d();
            dVar.b(cursor);
            obj.userName = xVar.field_username;
            obj.jLe = xVar;
            obj.kEC = dVar;
            x.d("MicroMsg.EnterpriseBizListAdapter", "convertFrom userName = %s", new Object[]{obj.userName});
        }
        return obj;
    }

    public EnterpriseBizContactPlainListUI$a(EnterpriseBizContactPlainListUI enterpriseBizContactPlainListUI, Context context) {
        this.kGD = enterpriseBizContactPlainListUI;
        super(context, new b());
        Xy();
    }

    public final void a(String str, l lVar) {
        x.i("MicroMsg.EnterpriseBizListAdapter", "onNotifyChange");
        ag.y(new 2(this));
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.hvV == null) {
            this.hvV = new 3(this);
        }
        if (this.hvU != null) {
            this.hvU.a(i, this.hvV);
        }
        if (view == null) {
            aVar = new a(this);
            view = View.inflate(this.context, R.i.dgm, null);
            aVar.hvY = (ImageView) view.findViewById(R.h.cyR);
            aVar.hvZ = (TextView) view.findViewById(R.h.cyX);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        b bVar = (b) getItem(i);
        if (bVar == null) {
            aVar.clear();
        } else {
            aVar.clear();
            int paddingBottom = view.getPaddingBottom();
            int paddingTop = view.getPaddingTop();
            int paddingRight = view.getPaddingRight();
            int paddingLeft = view.getPaddingLeft();
            view.setBackgroundDrawable(com.tencent.mm.bv.a.b(this.context, R.g.bBx));
            view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            aVar.hvZ.setText(i.b(this.context, bh.ou(bVar.jLe.AP()), aVar.hvZ.getTextSize()));
            aVar.hvZ.setVisibility(0);
            aVar.hvY.setVisibility(0);
            if (bh.ov(bVar.jLe.field_username)) {
                aVar.hvY.setImageDrawable(null);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(aVar.hvY, bVar.jLe.field_username);
            }
        }
        return view;
    }

    protected final void Xz() {
        Xy();
    }

    public final void Xy() {
        Cursor cursor = null;
        if (ar.Hj()) {
            aUn();
            switch (EnterpriseBizContactPlainListUI.b(this.kGD)) {
                case 1:
                    y.Mf();
                    cursor = e.J(EnterpriseBizContactPlainListUI.c(this.kGD), 25);
                    break;
                case 2:
                    y.Mf();
                    String c = EnterpriseBizContactPlainListUI.c(this.kGD);
                    StringBuilder stringBuilder = new StringBuilder();
                    e.b(stringBuilder);
                    e.c(stringBuilder);
                    e.a(stringBuilder, c);
                    e.b(stringBuilder, false);
                    e.a(stringBuilder, false);
                    stringBuilder.append(" order by ");
                    stringBuilder.append(e.LJ());
                    x.i("MicroMsg.BizInfoStorage", "getEnterpriseDisableChild sql %s", new Object[]{stringBuilder.toString()});
                    cursor = g.Dj().gQj.a(c, null, 0);
                    break;
                case 3:
                    y.Mf();
                    cursor = e.J(EnterpriseBizContactPlainListUI.c(this.kGD), FileUtils.S_IWUSR);
                    break;
                case 4:
                    d jS = f.jS(EnterpriseBizContactPlainListUI.c(this.kGD));
                    if (!(jS == null || jS.field_enterpriseFather == null)) {
                        cursor = y.Mf().jM(jS.field_enterpriseFather);
                        break;
                    }
                default:
                    y.Mf();
                    cursor = e.z(EnterpriseBizContactPlainListUI.c(this.kGD), true);
                    break;
            }
            setCursor(cursor);
            return;
        }
        x.e("MicroMsg.EnterpriseBizListAdapter", "accHasReady");
    }
}
