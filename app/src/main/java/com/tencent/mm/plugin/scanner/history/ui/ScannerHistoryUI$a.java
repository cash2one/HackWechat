package com.tencent.mm.plugin.scanner.history.ui;

import android.database.Cursor;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.aq.a.a.c$a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.scanner.a.i;
import com.tencent.mm.plugin.scanner.c;
import com.tencent.mm.plugin.scanner.history.a.a;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.o;
import com.tencent.mm.z.ar;

class ScannerHistoryUI$a extends o<a> {
    final /* synthetic */ ScannerHistoryUI pSn;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (a) obj;
        if (obj == null) {
            obj = new a();
        }
        obj.b(cursor);
        return obj;
    }

    public ScannerHistoryUI$a(ScannerHistoryUI scannerHistoryUI) {
        this.pSn = scannerHistoryUI;
        super(scannerHistoryUI, new a());
        lU(true);
    }

    public final void Xy() {
        setCursor(c.boB().Tj());
        notifyDataSetChanged();
    }

    protected final void Xz() {
        aUn();
        Xy();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        ScannerHistoryUI$b scannerHistoryUI$b;
        a aVar = (a) getItem(i);
        if (view == null) {
            view = View.inflate(this.pSn.mController.xIM, R.i.dqZ, null);
            ScannerHistoryUI$b scannerHistoryUI$b2 = new ScannerHistoryUI$b(this.pSn);
            scannerHistoryUI$b2.jMv = (ImageView) view.findViewById(R.h.cry);
            scannerHistoryUI$b2.kUP = (TextView) view.findViewById(R.h.crT);
            scannerHistoryUI$b2.kUQ = (TextView) view.findViewById(R.h.crR);
            scannerHistoryUI$b2.kUR = (TextView) view.findViewById(R.h.cru);
            view.setTag(scannerHistoryUI$b2);
            scannerHistoryUI$b = scannerHistoryUI$b2;
        } else {
            scannerHistoryUI$b = (ScannerHistoryUI$b) view.getTag();
        }
        n.a bW = i.bW(aVar.field_xmlContent, aVar.field_funcType);
        scannerHistoryUI$b.kUP.setText(bW.field_title);
        scannerHistoryUI$b.kUQ.setText(com.tencent.mm.pluginsdk.h.n.c(this.pSn, aVar.field_ScanTime, true));
        scannerHistoryUI$b.kUR.setText(bW.field_subtitle);
        int dimensionPixelSize = this.pSn.getResources().getDimensionPixelSize(R.f.bxR);
        scannerHistoryUI$b.jMv.setImageResource(R.g.bEF);
        x.d("MicroMsg.ScannerHistoryUI", "ScannerHistoryUI getView () position : " + i + " logo_url :  " + bW.field_thumburl);
        if (TextUtils.isEmpty(bW.field_thumburl)) {
            scannerHistoryUI$b.jMv.setImageResource(R.g.bEF);
        } else {
            String format;
            c$a com_tencent_mm_aq_a_a_c_a = new c$a();
            com_tencent_mm_aq_a_a_c_a.hDD = e.bnF;
            com.tencent.mm.aq.o.PB();
            com_tencent_mm_aq_a_a_c_a.hDW = null;
            c boA = c.boA();
            String str = bW.field_thumburl;
            if (ar.Hj()) {
                format = String.format("%s/scanbook_%s", new Object[]{boA.gQi + "image/scan/img", g.s(str.getBytes())});
            } else {
                format = "";
            }
            com_tencent_mm_aq_a_a_c_a.hDC = format;
            com_tencent_mm_aq_a_a_c_a.hDA = true;
            com_tencent_mm_aq_a_a_c_a.hDY = false;
            com_tencent_mm_aq_a_a_c_a.hDy = true;
            com_tencent_mm_aq_a_a_c_a.hDH = dimensionPixelSize;
            com_tencent_mm_aq_a_a_c_a.hDG = dimensionPixelSize;
            com_tencent_mm_aq_a_a_c_a.hDP = R.g.bEF;
            com.tencent.mm.aq.o.PA().a(bW.field_thumburl, scannerHistoryUI$b.jMv, com_tencent_mm_aq_a_a_c_a.PK());
        }
        return view;
    }
}
