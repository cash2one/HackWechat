package com.tencent.mm.plugin.qmessage.ui;

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
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView$d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.o;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;

final class c extends o<ae> implements b {
    private final MMActivity fmM;
    protected f kBC;
    protected com.tencent.mm.ui.base.MMSlideDelView.c kBD;
    protected e kBE;
    protected MMSlideDelView$d kBF = MMSlideDelView.cpx();

    public static class a {
        public ImageView iip;
        public TextView kBH;
        public TextView kBI;
        public TextView kBJ;
        public ImageView kBK;
        public TextView kBL;
    }

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

    public c(Context context, com.tencent.mm.ui.o.a aVar) {
        super(context, new ae());
        this.xIi = aVar;
        this.fmM = (MMActivity) context;
    }

    public final void Xy() {
        ar.Hg();
        setCursor(com.tencent.mm.z.c.Fd().Xg(s.hfm));
        if (this.xIi != null) {
            this.xIi.Xv();
        }
        super.notifyDataSetChanged();
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final int getItemViewType(int i) {
        return 0;
    }

    public final void a(f fVar) {
        this.kBC = fVar;
    }

    public final void a(e eVar) {
        this.kBE = eVar;
    }

    public final void a(com.tencent.mm.ui.base.MMSlideDelView.c cVar) {
        this.kBD = cVar;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int i2;
        int paddingTop;
        int paddingRight;
        int paddingLeft;
        ae aeVar = (ae) getItem(i);
        if (view == null) {
            a aVar2 = new a();
            view = View.inflate(this.fmM, R.i.dta, null);
            aVar2.iip = (ImageView) view.findViewById(R.h.bLL);
            aVar2.kBH = (TextView) view.findViewById(R.h.cAn);
            aVar2.kBI = (TextView) view.findViewById(R.h.cTR);
            aVar2.kBJ = (TextView) view.findViewById(R.h.csx);
            aVar2.kBK = (ImageView) view.findViewById(R.h.cPk);
            aVar2.kBL = (TextView) view.findViewById(R.h.cRX);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.kBH.setText(r.gu(aeVar.field_username));
        TextView textView = aVar.kBI;
        CharSequence string = aeVar.field_status == 1 ? this.fmM.getString(R.l.euA) : aeVar.field_conversationTime == Long.MAX_VALUE ? "" : n.c(this.fmM, aeVar.field_conversationTime, true);
        textView.setText(string);
        com.tencent.mm.pluginsdk.ui.a.b.a(aVar.iip, aeVar.field_username);
        ar.Hg();
        as.b uw = com.tencent.mm.z.c.Fd().uw();
        if (!bh.ov(aeVar.field_digest)) {
            if (bh.ov(aeVar.field_digestUser)) {
                string = aeVar.field_digest;
            } else {
                String L = (aeVar.field_isSend == 0 && s.eV(aeVar.field_username)) ? r.L(aeVar.field_digestUser, aeVar.field_username) : r.gu(aeVar.field_digestUser);
                try {
                    string = String.format(aeVar.field_digest, new Object[]{L});
                } catch (Exception e) {
                }
            }
            aVar.kBJ.setText(i.b(this.fmM, string, aVar.kBJ.getTextSize()));
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
            if (i2 == -1) {
                aVar.kBK.setBackgroundResource(i2);
                aVar.kBK.setVisibility(0);
            } else {
                aVar.kBK.setVisibility(8);
            }
            i2 = view.getPaddingBottom();
            paddingTop = view.getPaddingTop();
            paddingRight = view.getPaddingRight();
            paddingLeft = view.getPaddingLeft();
            if (aeVar.field_unReadCount > 100) {
                aVar.kBL.setText("...");
                aVar.kBL.setVisibility(0);
            } else if (aeVar.field_unReadCount <= 0) {
                aVar.kBL.setText(aeVar.field_unReadCount);
                aVar.kBL.setVisibility(0);
            } else {
                aVar.kBL.setVisibility(4);
            }
            view.setBackgroundResource(R.g.bDH);
            view.setPadding(paddingLeft, paddingTop, paddingRight, i2);
            return view;
        }
        string = uw.a(aeVar.field_isSend, aeVar.field_username, aeVar.field_content, vP(aeVar.field_msgType), this.fmM);
        aVar.kBJ.setText(i.b(this.fmM, string, aVar.kBJ.getTextSize()));
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
        if (i2 == -1) {
            aVar.kBK.setVisibility(8);
        } else {
            aVar.kBK.setBackgroundResource(i2);
            aVar.kBK.setVisibility(0);
        }
        i2 = view.getPaddingBottom();
        paddingTop = view.getPaddingTop();
        paddingRight = view.getPaddingRight();
        paddingLeft = view.getPaddingLeft();
        if (aeVar.field_unReadCount > 100) {
            aVar.kBL.setText("...");
            aVar.kBL.setVisibility(0);
        } else if (aeVar.field_unReadCount <= 0) {
            aVar.kBL.setVisibility(4);
        } else {
            aVar.kBL.setText(aeVar.field_unReadCount);
            aVar.kBL.setVisibility(0);
        }
        view.setBackgroundResource(R.g.bDH);
        view.setPadding(paddingLeft, paddingTop, paddingRight, i2);
        return view;
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

    public final void onPause() {
        if (this.kBF != null) {
            this.kBF.aUy();
        }
    }

    protected final void Xz() {
        Xy();
    }
}
