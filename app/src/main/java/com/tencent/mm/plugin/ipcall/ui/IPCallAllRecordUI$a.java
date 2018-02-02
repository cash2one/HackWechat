package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.o;

class IPCallAllRecordUI$a extends o<k> {
    final /* synthetic */ IPCallAllRecordUI nIG;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (k) obj;
        if (obj == null) {
            obj = new k();
        }
        obj.b(cursor);
        return obj;
    }

    public IPCallAllRecordUI$a(IPCallAllRecordUI iPCallAllRecordUI, Context context) {
        this.nIG = iPCallAllRecordUI;
        super(context, null);
        lU(true);
    }

    public final void Xy() {
        Cursor cursor = null;
        if (!bh.ov(IPCallAllRecordUI.a(this.nIG))) {
            String a = IPCallAllRecordUI.a(this.nIG);
            if (!bh.ov(a)) {
                c CD = i.aTD().CD(a);
                if (!(CD == null || CD.xjy == -1)) {
                    cursor = i.aTE().dB(CD.xjy);
                }
            }
        } else if (!bh.ov(IPCallAllRecordUI.b(this.nIG))) {
            cursor = i.aTE().CH(IPCallAllRecordUI.b(this.nIG));
        }
        setCursor(cursor);
    }

    protected final void Xz() {
        aUn();
        Xy();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.nIG.getLayoutInflater().inflate(R.i.dmi, viewGroup, false);
            aVar = new a(this);
            aVar.nIH = (TextView) view.findViewById(R.h.cDS);
            aVar.nII = (TextView) view.findViewById(R.h.cDU);
            aVar.ihV = (TextView) view.findViewById(R.h.cDV);
            view.setTag(aVar);
        }
        k kVar = (k) getItem(i);
        aVar = (a) view.getTag();
        aVar.nII.setText(a.Di(kVar.field_phonenumber));
        if (kVar.field_duration > 0) {
            aVar.ihV.setText(com.tencent.mm.plugin.ipcall.b.c.dE(kVar.field_duration));
        } else {
            aVar.ihV.setText(com.tencent.mm.plugin.ipcall.b.c.rI(kVar.field_status));
        }
        aVar.nIH.setText(com.tencent.mm.plugin.ipcall.b.c.dC(kVar.field_calltime));
        return view;
    }
}
