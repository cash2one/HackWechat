package com.tencent.mm.plugin.sns.lucky.ui;

import android.content.Context;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.q.a.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.h.m;
import com.tencent.mm.protocal.c.akb;
import com.tencent.mm.storage.x;
import com.tencent.mm.wallet_core.ui.e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public final class b extends BaseAdapter {
    private LayoutInflater DF;
    private final String TAG = "SnsLuckyMoneyReceivedRecordListAdapter";
    private Context mContext;
    List<a> ogJ = new ArrayList();
    private int oke = 1;

    public final /* synthetic */ Object getItem(int i) {
        return wx(i);
    }

    public b(Context context) {
        this.mContext = context;
        this.DF = LayoutInflater.from(context);
    }

    public final int getCount() {
        return this.ogJ.size();
    }

    private a wx(int i) {
        return (a) this.ogJ.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        CharSequence charSequence;
        if (view == null) {
            view = this.DF.inflate(g.uEj, viewGroup, false);
            aVar = new a(this);
            aVar.lkk = (ImageView) view.findViewById(f.upw);
            aVar.nqD = (TextView) view.findViewById(f.upz);
            aVar.oid = (TextView) view.findViewById(f.upA);
            aVar.ogw = (TextView) view.findViewById(f.upu);
            aVar.okk = (TextView) view.findViewById(f.upy);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        a wx = wx(i);
        com.tencent.mm.kernel.g.Dk();
        x WO = ((h) com.tencent.mm.kernel.g.h(h.class)).EY().WO(wx.jKk);
        if (wx.jKk != null) {
            com.tencent.mm.pluginsdk.ui.a.b.o(aVar.lkk, wx.jKk);
        } else {
            com.tencent.mm.sdk.platformtools.x.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", new Object[]{wx.jKk});
        }
        TextView textView = aVar.oid;
        Context context = this.mContext;
        long j = ((long) wx.nYI) * 1000;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j < 3600000) {
            charSequence = "";
        } else {
            long timeInMillis = j - new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5)).getTimeInMillis();
            if (timeInMillis <= 0 || timeInMillis > 86400000) {
                Time time = new Time();
                time.set(j);
                charSequence = m.a(context.getString(i.loA, new Object[]{" "}), time).toString();
            } else {
                charSequence = new SimpleDateFormat("HH:mm").format(new Date(j));
            }
        }
        textView.setText(charSequence);
        aVar.oid.setVisibility(0);
        if (WO != null) {
            n.a(this.mContext, aVar.nqD, WO.AQ());
        } else {
            com.tencent.mm.sdk.platformtools.x.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", new Object[]{wx.jKk});
        }
        akb com_tencent_mm_protocal_c_akb = new akb();
        try {
            if (wx.nYJ == null || wx.nYJ.wJB <= 0) {
                aVar.ogw.setVisibility(8);
                aVar.okk.setVisibility(0);
                return view;
            }
            com_tencent_mm_protocal_c_akb.aF(com.tencent.mm.platformtools.n.a(wx.nYJ));
            if (com_tencent_mm_protocal_c_akb.fLR > 0) {
                aVar.ogw.setText(this.mContext.getString(i.upj, new Object[]{e.t(((double) com_tencent_mm_protocal_c_akb.fLR) / 100.0d)}));
                aVar.okk.setVisibility(8);
            } else {
                aVar.ogw.setVisibility(8);
                aVar.okk.setVisibility(0);
            }
            return view;
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.x.e("SnsLuckyMoneyReceivedRecordListAdapter", e.getMessage() + "hbBuffer is error");
            aVar.ogw.setVisibility(8);
            aVar.okk.setVisibility(8);
            aVar.lkk.setVisibility(8);
            aVar.nqD.setVisibility(8);
            aVar.oid.setVisibility(8);
        }
    }
}
