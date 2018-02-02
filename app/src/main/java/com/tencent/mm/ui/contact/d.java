package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.o;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import java.util.List;

public final class d extends o<x> {
    protected MMActivity fmM;
    b hvU = null;
    private b.b hvV = null;
    protected f kBC;
    protected c kBD;
    protected com.tencent.mm.ui.base.MMSlideDelView.d kBF = MMSlideDelView.cpx();
    protected List<String> kiU = null;
    protected e oPr;
    com.tencent.mm.pluginsdk.ui.d vnS;
    protected String yPI = null;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        ar.Hg();
        Object WJ = com.tencent.mm.z.c.EY().WJ(x.k(cursor));
        if (WJ != null) {
            return WJ;
        }
        x xVar = new x();
        xVar.b(cursor);
        ar.Hg();
        com.tencent.mm.z.c.EY().O(xVar);
        return xVar;
    }

    public d(Context context, String str) {
        super(context, new x());
        this.fmM = (MMActivity) context;
        this.yPI = str;
        this.hvU = new b(new 1(this));
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

    public final int getCount() {
        return getCursor().getCount();
    }

    protected final void Xz() {
        Xy();
    }

    public final synchronized void Xy() {
        ar.Hg();
        Cursor b = com.tencent.mm.z.c.EY().b(this.yPI, "", this.kiU);
        aUn();
        setCursor(b);
        notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.hvV == null) {
            this.hvV = new b.b(this) {
                final /* synthetic */ d yRp;

                {
                    this.yRp = r1;
                }

                public final String hC(int i) {
                    if (i < 0 || i >= this.yRp.getCount()) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChatroomContactAdapter", "pos is invalid");
                        return null;
                    }
                    x xVar = (x) this.yRp.getItem(i);
                    return xVar == null ? null : xVar.field_username;
                }

                public final int NJ() {
                    return this.yRp.getCount();
                }
            };
        }
        if (this.hvU != null) {
            this.hvU.a(i, this.hvV);
        }
        if (view == null) {
            view = View.inflate(this.fmM, R.i.dcN, null);
            a aVar2 = new a();
            aVar2.nJd = (TextView) view.findViewById(R.h.bYz);
            aVar2.ldx = (MaskLayout) view.findViewById(R.h.bYx);
            aVar2.kEZ = (TextView) view.findViewById(R.h.bYB);
            aVar2.yRq = (ViewGroup) view.findViewById(R.h.bYA);
            LayoutParams layoutParams = aVar2.yRq.getLayoutParams();
            layoutParams.height = (int) (((float) a.ab(this.fmM, R.f.buA)) * a.ex(this.fmM));
            aVar2.yRq.setLayoutParams(layoutParams);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        x xVar = (x) getItem(i - 1);
        int i2 = xVar == null ? -1 : xVar.field_showHead;
        xVar = (x) getItem(i);
        if (i == 0) {
            CharSequence X = X(xVar);
            if (t.ov(X)) {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", xVar.field_username, Integer.valueOf(i));
                aVar.nJd.setVisibility(8);
            } else {
                aVar.nJd.setVisibility(0);
                aVar.nJd.setText(X);
                aVar.nJd.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            if (getItem(i + 1) == null) {
                aVar.yRq.setBackgroundResource(0);
            }
        } else if (i <= 0 || xVar.field_showHead == i2) {
            aVar.nJd.setVisibility(8);
            a(aVar, i, i2);
        } else {
            CharSequence X2 = X(xVar);
            aVar.yRq.setBackgroundResource(R.g.bBx);
            if (t.ov(X2)) {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", xVar.field_username, Integer.valueOf(i));
                aVar.nJd.setVisibility(8);
            } else {
                aVar.nJd.setVisibility(0);
                aVar.nJd.setText(X2);
                if (xVar.field_showHead == 32) {
                    aVar.nJd.setCompoundDrawablesWithIntrinsicBounds(R.g.bDF, 0, 0, 0);
                    aVar.nJd.setCompoundDrawablePadding(2);
                } else {
                    aVar.nJd.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }
            }
            a(aVar, i, i2);
        }
        aVar.kEZ.setTextColor(a.Z(this.fmM, !s.hn(xVar.field_username) ? R.e.bth : R.e.bti));
        ImageView imageView = (ImageView) aVar.ldx.view;
        com.tencent.mm.pluginsdk.ui.a.b.a(imageView, xVar.field_username);
        com.tencent.mm.pluginsdk.ui.a aVar3 = (com.tencent.mm.pluginsdk.ui.a) imageView.getDrawable();
        if (this.vnS != null) {
            this.vnS.a(aVar3);
        }
        aVar.ldx.cpQ();
        try {
            aVar.kEZ.setText(i.c(this.fmM, r.gu(xVar.field_username), (int) aVar.kEZ.getTextSize()));
        } catch (Exception e) {
            aVar.kEZ.setText("");
        }
        return view;
    }

    private void a(a aVar, int i, int i2) {
        x xVar = (x) getItem(i + 1);
        if (xVar == null || !(xVar.field_showHead == i2 || t.ov(X(xVar)))) {
            aVar.yRq.setBackgroundResource(0);
        }
    }

    private String X(x xVar) {
        if (xVar.field_showHead == 31) {
            return "";
        }
        if (xVar.field_showHead == 43) {
            return this.fmM.getString(R.l.eFx);
        }
        return String.valueOf((char) xVar.field_showHead);
    }
}
