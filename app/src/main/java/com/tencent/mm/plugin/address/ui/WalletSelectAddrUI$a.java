package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.address.d.b;
import java.util.ArrayList;
import java.util.List;

public class WalletSelectAddrUI$a extends BaseAdapter {
    private final Context context;
    List<b> hiv = new ArrayList();
    final /* synthetic */ WalletSelectAddrUI iom;

    public final /* synthetic */ Object getItem(int i) {
        return jo(i);
    }

    public WalletSelectAddrUI$a(WalletSelectAddrUI walletSelectAddrUI, Context context) {
        this.iom = walletSelectAddrUI;
        this.context = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        a aVar2 = new a(this);
        if (view == null) {
            view = View.inflate(this.context, R.i.dtS, null);
            aVar2.inv = (ImageView) view.findViewById(R.h.bVW);
            aVar2.inu = (TextView) view.findViewById(R.h.bJf);
            aVar2.inw = (TextView) view.findViewById(R.h.bJl);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        b jo = jo(i);
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(jo.imk)) {
            stringBuilder.append(jo.imk);
        }
        if (!TextUtils.isEmpty(jo.iml)) {
            stringBuilder.append(" ");
            stringBuilder.append(jo.iml);
        }
        if (!TextUtils.isEmpty(jo.imm)) {
            stringBuilder.append(" ");
            stringBuilder.append(jo.imm);
        }
        if (!TextUtils.isEmpty(jo.imo)) {
            stringBuilder.append(" ");
            stringBuilder.append(jo.imo);
        }
        aVar.inu.setText(stringBuilder.toString());
        aVar.inw.setText(jo.imp + "，" + jo.imq);
        if (WalletSelectAddrUI.e(this.iom) && WalletSelectAddrUI.f(this.iom) != null && WalletSelectAddrUI.f(this.iom).id == jo.id) {
            aVar.inv.setImageResource(R.k.dAr);
        } else {
            aVar.inv.setImageBitmap(null);
        }
        return view;
    }

    public final int getCount() {
        return this.hiv.size();
    }

    private b jo(int i) {
        return (b) this.hiv.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }
}
