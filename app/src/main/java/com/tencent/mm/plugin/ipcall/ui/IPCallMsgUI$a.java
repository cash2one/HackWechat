package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.database.Cursor;
import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a.g.g;
import com.tencent.mm.plugin.ipcall.a.g.h;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView$d;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.v;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

class IPCallMsgUI$a extends o<g> {
    int hKb = this.kUH;
    protected f kBC;
    protected c kBD;
    protected MMSlideDelView$d kBF = new 1(this);
    int kUH = 10;
    final /* synthetic */ IPCallMsgUI nKK;
    private Set<MMSlideDelView> nKM = new HashSet();

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (g) obj;
        if (obj == null) {
            obj = new g();
            x.d("MicroMsg.IPCallMsgUI", "new IPCallMsg");
        }
        obj.b(cursor);
        return obj;
    }

    public IPCallMsgUI$a(IPCallMsgUI iPCallMsgUI, Context context, g gVar) {
        this.nKK = iPCallMsgUI;
        super(context, gVar);
    }

    public final long getItemId(int i) {
        return ((g) getItem(i)).xjy;
    }

    protected final void Xz() {
        aUn();
        Xy();
    }

    public final void a(f fVar) {
        this.kBC = fVar;
    }

    public final void a(c cVar) {
        this.kBD = cVar;
    }

    public final synchronized void a(String str, l lVar) {
        super.a(str, lVar);
    }

    public final void Xy() {
        this.hKb = i.aTG().getCount();
        h aTG = i.aTG();
        int i = this.kUH;
        setCursor(aTG.gJP.query("IPCallMsg", h.nGN, null, null, null, null, "pushTime desc limit " + i));
        notifyDataSetChanged();
    }

    public final boolean awe() {
        return this.kUH >= this.hKb;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        CharSequence charSequence;
        g gVar = (g) getItem(i);
        if (view == null || !(view.getTag() instanceof a)) {
            view = v.fv(this.context).inflate(R.i.dmk, null);
            aVar = new a(this);
            aVar.ihS = (TextView) view.findViewById(R.h.cSh);
            aVar.inu = (TextView) view.findViewById(R.h.bYK);
            aVar.lUD = (TextView) view.findViewById(R.h.cRr);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.ihS.setText(gVar.field_title);
        aVar.inu.setText(gVar.field_content);
        TextView textView = aVar.lUD;
        Context context = this.nKK.mController.xIM;
        long j = gVar.field_pushTime * 1000;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
        String str = (String) DateFormat.format(context.getString(R.l.eiw), j);
        if (str.indexOf("-") > 0) {
            charSequence = (str.split("-")[1] + " " + com.tencent.mm.plugin.ipcall.b.c.ap(context, str.split("-")[0]) + " ") + " " + ((String) com.tencent.mm.plugin.ipcall.b.c.h(context, j));
        } else {
            long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
            if (timeInMillis <= 0 || timeInMillis > 86400000) {
                timeInMillis = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
                charSequence = (timeInMillis <= 0 || timeInMillis > 86400000) ? str + " " + ((String) com.tencent.mm.plugin.ipcall.b.c.h(context, j)) : context.getString(R.l.eiV) + " " + ((String) com.tencent.mm.plugin.ipcall.b.c.h(context, j));
            } else {
                charSequence = ((String) com.tencent.mm.plugin.ipcall.b.c.h(context, j));
            }
        }
        textView.setText(charSequence);
        if ((gVar.field_isRead == (short) 1 ? 1 : null) != null) {
            aVar.ihS.setTextColor(this.nKK.getResources().getColor(R.e.bsR));
        } else {
            aVar.ihS.setTextColor(this.nKK.getResources().getColor(R.e.bsS));
        }
        return view;
    }
}
