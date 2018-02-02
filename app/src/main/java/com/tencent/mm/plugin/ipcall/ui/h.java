package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.n;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.g.m;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public final class h extends o<c> implements com.tencent.mm.ad.d.a {
    private static HashMap<String, c> nGG = null;
    private boolean kFT = false;
    private d nHJ;
    private HashMap<Long, c> nHK = new HashMap();
    private HashSet<String> nHL = new HashSet();
    private boolean nHM = false;
    ArrayList<k> nLq;
    private OnClickListener nLr = new 1(this);

    private class a {
        ImageView ihQ;
        TextView jLc;
        TextView nHR;
        LinearLayout nHS;
        TextView nHT;
        TextView nHU;
        TextView nHV;
        TextView nHW;
        ImageView nHX;
        View nHY;
        View nHZ;
        View nIa;
        ImageView nIb;
        final /* synthetic */ h nLs;

        private a(h hVar) {
            this.nLs = hVar;
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (c) obj;
        if (obj == null) {
            obj = new c();
        }
        obj.b(cursor);
        return obj;
    }

    public h(Context context) {
        super(context, null);
        lU(true);
        this.nHJ = new d(context);
        n.Jz().a(this);
    }

    protected final void Xz() {
        this.nLq = m.aUh();
    }

    public final void Xy() {
        this.nLq = m.aUh();
    }

    public final int getCount() {
        if (this.nLq == null) {
            this.nLq = m.aUh();
        }
        if (this.nLq != null) {
            return this.nLq.size();
        }
        return 0;
    }

    public final k rD(int i) {
        return (k) this.nLq.get(i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.i.dmh, viewGroup, false);
            a aVar = new a();
            aVar.nHZ = view.findViewById(R.h.crx);
            aVar.nIa = view.findViewById(R.h.ccl);
            aVar.ihQ = (ImageView) view.findViewById(R.h.bLL);
            aVar.jLc = (TextView) view.findViewById(R.h.cAn);
            aVar.nHR = (TextView) view.findViewById(R.h.cCu);
            aVar.nHS = (LinearLayout) view.findViewById(R.h.cGl);
            aVar.nHT = (TextView) view.findViewById(R.h.cGm);
            aVar.nHU = (TextView) view.findViewById(R.h.cGn);
            aVar.nHV = (TextView) view.findViewById(R.h.bJo);
            aVar.nHW = (TextView) view.findViewById(R.h.bJi);
            aVar.nHX = (ImageView) view.findViewById(R.h.bJj);
            aVar.nHY = view.findViewById(R.h.crz);
            aVar.nHY.setClickable(true);
            aVar.nIb = (ImageView) view.findViewById(R.h.divider);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        aVar2.nHY.setClickable(true);
        aVar2.nHY.setTag(Integer.valueOf(i));
        aVar2.nIb.setVisibility(8);
        if (qY(i)) {
            aVar2.jLc.setVisibility(8);
            aVar2.nHR.setVisibility(8);
            aVar2.nHS.setVisibility(8);
            aVar2.ihQ.setVisibility(8);
            aVar2.ihQ.setTag(null);
            aVar2.nHW.setVisibility(8);
            aVar2.nHV.setVisibility(8);
            aVar2.nHX.setVisibility(8);
        } else {
            k rD = rD(i);
            if (rD != null) {
                c dy;
                if (i == 0) {
                    aVar2.nHW.setVisibility(0);
                    aVar2.nHV.setVisibility(8);
                    aVar2.nHW.setText(this.context.getString(R.l.eqX));
                } else {
                    aVar2.nHW.setVisibility(8);
                    aVar2.nHV.setVisibility(8);
                }
                aVar2.nIb.setVisibility(0);
                aVar2.jLc.setVisibility(0);
                LayoutParams layoutParams = (LayoutParams) aVar2.nHZ.getLayoutParams();
                layoutParams.height = (int) aVar2.nHR.getContext().getResources().getDimension(R.f.bwa);
                aVar2.nHZ.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) aVar2.ihQ.getLayoutParams();
                layoutParams2.height = (int) aVar2.ihQ.getContext().getResources().getDimension(R.f.bvZ);
                layoutParams2.width = (int) aVar2.ihQ.getContext().getResources().getDimension(R.f.bvZ);
                aVar2.ihQ.setLayoutParams(layoutParams2);
                if (rD.field_addressId > 0) {
                    dy = this.nHK.containsKey(Long.valueOf(rD.field_addressId)) ? (c) this.nHK.get(Long.valueOf(rD.field_addressId)) : i.aTD().dy(rD.field_addressId);
                    if (dy != null) {
                        this.nHK.put(Long.valueOf(rD.field_addressId), dy);
                        aVar2.jLc.setText(dy.field_systemAddressBookUsername);
                    }
                } else {
                    aVar2.jLc.setText(com.tencent.mm.plugin.ipcall.b.a.Di(rD.field_phonenumber));
                    dy = null;
                }
                aVar2.nHR.setVisibility(8);
                aVar2.nHS.setVisibility(0);
                aVar2.nHU.setText(com.tencent.mm.plugin.ipcall.b.c.dC(rD.field_calltime));
                if (rD.field_duration > 0) {
                    aVar2.nHT.setText(com.tencent.mm.plugin.ipcall.b.c.dE(rD.field_duration));
                } else {
                    aVar2.nHT.setText(com.tencent.mm.plugin.ipcall.b.c.rI(rD.field_status));
                }
                ImageView imageView = aVar2.ihQ;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    imageView.setTag(null);
                    imageView.setImageResource(R.g.bDh);
                    if (dy != null) {
                        if (!bh.ov(dy.field_contactId) && !bh.ov(dy.field_wechatUsername)) {
                            this.nHJ.a(dy.field_contactId, dy.field_wechatUsername, imageView);
                        } else if (!bh.ov(dy.field_contactId)) {
                            this.nHJ.b(dy.field_contactId, imageView);
                        } else if (!bh.ov(dy.field_wechatUsername)) {
                            this.nHJ.c(dy.field_wechatUsername, imageView);
                        }
                        if (!bh.ov(dy.field_wechatUsername)) {
                            this.nHL.add(dy.field_wechatUsername);
                        }
                    }
                }
            }
            aVar2.nHY.setVisibility(0);
            aVar2.nHX.setVisibility(0);
            aVar2.nHY.setOnClickListener(this.nLr);
        }
        return view;
    }

    public final int getItemViewType(int i) {
        return super.getItemViewType(i);
    }

    public final int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    public final void jh(String str) {
        if (this.nHL.contains(str)) {
            ag.y(new 2(this));
        }
    }

    public final void notifyDataSetChanged() {
        this.nLq = m.aUh();
        this.nHK.clear();
        super.notifyDataSetChanged();
    }
}
