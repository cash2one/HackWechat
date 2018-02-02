package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.o;
import java.util.GregorianCalendar;

final class d extends o<f> {
    private LayoutInflater DF;
    private Context mContext;
    int qqK = 20;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (f) obj;
        if (obj == null) {
            obj = new f();
        }
        obj.b(cursor);
        return obj;
    }

    public d(Context context) {
        super(context, new f());
        this.mContext = context;
        this.DF = LayoutInflater.from(context);
    }

    public final void wf(int i) {
        aUn();
        this.qqK = i;
        Xy();
    }

    protected final void Xz() {
        Xy();
    }

    public final void Xy() {
        g brD = m.brD();
        setCursor(brD.gJP.rawQuery("SELECT * FROM " + brD.getTableName() + " ORDER BY rowid DESC LIMIT " + this.qqK, null));
        super.notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        CharSequence charSequence;
        if (view == null) {
            view = this.DF.inflate(R.i.dss, viewGroup, false);
            aVar = new a(this);
            aVar.qqL = (MMImageView) view.findViewById(R.h.cMQ);
            aVar.jJn = (TextView) view.findViewById(R.h.cMS);
            aVar.lkn = (TextView) view.findViewById(R.h.cMP);
            aVar.oid = (TextView) view.findViewById(R.h.cMR);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        f fVar = (f) getItem(i);
        e.a(aVar.qqL, fVar.field_thumburl, R.k.dvD, false);
        if (bh.ov(fVar.field_title)) {
            aVar.jJn.setVisibility(8);
        } else {
            aVar.jJn.setText(i.b(this.mContext, fVar.field_title, aVar.jJn.getTextSize()));
            aVar.jJn.setVisibility(0);
        }
        if (bh.ov(fVar.field_desc)) {
            aVar.lkn.setVisibility(8);
        } else {
            aVar.lkn.setText(i.b(this.mContext, fVar.field_desc, aVar.lkn.getTextSize()));
            aVar.lkn.setVisibility(0);
        }
        TextView textView = aVar.oid;
        Context context = this.mContext;
        long j = fVar.field_createtime * 1000;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j < 3600000) {
            charSequence = "";
        } else {
            long timeInMillis = gregorianCalendar.getTimeInMillis();
            int i2;
            if ((timeInMillis - j) / 3600000 == 0) {
                i2 = (int) ((timeInMillis - j) / 60000);
                if (i2 <= 0) {
                    i2 = 1;
                }
                charSequence = context.getResources().getQuantityString(R.j.duu, i2, new Object[]{Integer.valueOf(i2)});
            } else {
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
                long timeInMillis2 = j - gregorianCalendar2.getTimeInMillis();
                if (timeInMillis2 <= 0 || timeInMillis2 > 86400000) {
                    timeInMillis2 = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
                    if (timeInMillis2 <= 0 || timeInMillis2 > 86400000) {
                        i2 = (int) ((timeInMillis - j) / 86400000);
                        if (i2 <= 0) {
                            i2 = 1;
                        }
                        charSequence = context.getResources().getQuantityString(R.j.duv, i2, new Object[]{Integer.valueOf(i2)});
                    } else {
                        charSequence = context.getString(R.l.eiV);
                    }
                } else {
                    i2 = (int) ((timeInMillis - j) / 3600000);
                    if (i2 <= 0) {
                        i2 = 1;
                    }
                    charSequence = context.getResources().getQuantityString(R.j.dut, i2, new Object[]{Integer.valueOf(i2)});
                }
            }
        }
        textView.setText(charSequence);
        return view;
    }
}
