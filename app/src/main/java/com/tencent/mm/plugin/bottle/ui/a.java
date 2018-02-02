package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.o$a;
import com.tencent.mm.z.ar;

final class a extends o<ae> implements b {
    private final MMActivity fmM;
    protected f kBC;
    protected c kBD;
    protected e kBE;
    protected d kBF = MMSlideDelView.cpx();

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (ae) obj;
        if (obj == null) {
            obj = new ae();
        }
        obj.dF("");
        obj.dG("");
        obj.b(cursor);
        return obj;
    }

    public a(Context context, o$a com_tencent_mm_ui_o_a) {
        super(context, new ae());
        this.xIi = com_tencent_mm_ui_o_a;
        this.fmM = (MMActivity) context;
    }

    public final void Xy() {
        ar.Hg();
        setCursor(com.tencent.mm.z.c.Fd().ciG());
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

    public final void a(c cVar) {
        this.kBD = cVar;
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
        int i2;
        ae aeVar = (ae) getItem(i);
        if (view == null) {
            a aVar2 = new a();
            View view2 = (MMSlideDelView) View.inflate(this.fmM, R.i.daY, null);
            View inflate = View.inflate(this.fmM, R.i.dta, null);
            aVar2.iip = (ImageView) inflate.findViewById(R.h.bLL);
            aVar2.kBH = (TextView) inflate.findViewById(R.h.cAn);
            aVar2.kBI = (TextView) inflate.findViewById(R.h.cTR);
            aVar2.kBJ = (TextView) inflate.findViewById(R.h.csx);
            aVar2.kBK = (ImageView) inflate.findViewById(R.h.cPk);
            aVar2.kBL = (TextView) inflate.findViewById(R.h.cRX);
            aVar2.kBM = view2.findViewById(R.h.cOC);
            aVar2.kBN = (TextView) view2.findViewById(R.h.cOD);
            view2.setView(inflate);
            view2.kBC = this.kBC;
            view2.kBD = this.kBD;
            view2.kBF = this.kBF;
            view2.mAK = false;
            view2.setTag(aVar2);
            aVar = aVar2;
            view = view2;
        } else {
            aVar = (a) view.getTag();
        }
        ar.Hg();
        aVar.kBH.setText(A(com.tencent.mm.z.c.EY().WO(aeVar.field_username)));
        aVar.kBI.setText(aeVar.field_status == 1 ? this.fmM.getString(R.l.euA) : n.c(this.fmM, aeVar.field_conversationTime, true));
        com.tencent.mm.pluginsdk.ui.a.b.a(aVar.iip, x.WD(aeVar.field_username));
        ar.Hg();
        aVar.kBJ.setText(i.b(this.fmM, com.tencent.mm.z.c.Fd().uw().a(aeVar.field_isSend, aeVar.field_username, aeVar.field_content, vP(aeVar.field_msgType), this.fmM), aVar.kBJ.getTextSize()));
        aVar.kBJ.setTextColor(com.tencent.mm.bv.a.Z(this.fmM, R.e.btk));
        if (vP(aeVar.field_msgType) == 34 && aeVar.field_isSend == 0 && !bh.ov(aeVar.field_content) && !new com.tencent.mm.modelvoice.n(aeVar.field_content).hVA) {
            aVar.kBJ.setTextColor(com.tencent.mm.bv.a.Z(this.fmM, R.e.btl));
        }
        switch (aeVar.field_status) {
            case 0:
                i2 = -1;
                break;
            case 1:
                i2 = R.k.dze;
                break;
            case 2:
                i2 = -1;
                break;
            case 5:
                i2 = R.k.dzd;
                break;
            default:
                i2 = -1;
                break;
        }
        if (i2 != -1) {
            aVar.kBK.setBackgroundResource(i2);
            aVar.kBK.setVisibility(0);
        } else {
            aVar.kBK.setVisibility(8);
        }
        aVar.kBM.setTag(aeVar.field_username);
        aVar.kBM.setOnClickListener(new 1(this));
        i2 = view.getPaddingBottom();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingLeft = view.getPaddingLeft();
        if (aeVar.field_unReadCount > 100) {
            aVar.kBL.setText("...");
            aVar.kBL.setVisibility(0);
            com.tencent.mm.sdk.platformtools.x.v("MicroMsg.BottleConversationAdapter", "has unread 100");
        } else if (aeVar.field_unReadCount > 0) {
            aVar.kBL.setText(aeVar.field_unReadCount);
            aVar.kBL.setVisibility(0);
            com.tencent.mm.sdk.platformtools.x.v("MicroMsg.BottleConversationAdapter", "has unread");
        } else {
            aVar.kBL.setVisibility(4);
            com.tencent.mm.sdk.platformtools.x.v("MicroMsg.BottleConversationAdapter", "no unread");
        }
        view.setBackgroundResource(R.g.bDH);
        view.setPadding(paddingLeft, paddingTop, paddingRight, i2);
        return view;
    }

    final String A(x xVar) {
        return com.tencent.mm.plugin.bottle.a.c.a(this.fmM, xVar);
    }

    private static int vP(String str) {
        int i = 1;
        if (str != null && str.length() > 0) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    protected final void Xz() {
        Xy();
    }
}
