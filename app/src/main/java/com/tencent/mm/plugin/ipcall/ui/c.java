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
import com.tencent.mm.ad.d.a;
import com.tencent.mm.ad.n;
import com.tencent.mm.plugin.ipcall.a.g.b;
import com.tencent.mm.plugin.ipcall.a.g.d;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class c extends o<com.tencent.mm.plugin.ipcall.a.g.c> implements a {
    static HashMap<String, com.tencent.mm.plugin.ipcall.a.g.c> nGG = null;
    private String ilo;
    boolean kFT = false;
    HashMap<String, Integer> ldT = new HashMap();
    private Context mContext;
    private d nHJ;
    private HashMap<Long, com.tencent.mm.plugin.ipcall.a.g.c> nHK = new HashMap();
    private HashSet<String> nHL = new HashSet();
    private boolean nHM = false;
    private OnClickListener nHN = new 1(this);
    ao nHl = new ao();

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (com.tencent.mm.plugin.ipcall.a.g.c) obj;
        if (obj == null) {
            obj = new com.tencent.mm.plugin.ipcall.a.g.c();
        }
        obj.b(cursor);
        return obj;
    }

    public final /* synthetic */ Object getItem(int i) {
        return rw(i);
    }

    public c(Context context) {
        super(context, null);
        lU(true);
        this.mContext = context;
        this.nHJ = new d(context);
        n.Jz().a(this);
    }

    public final int getCount() {
        return super.getCount();
    }

    public final int aUm() {
        return super.getCount();
    }

    public final com.tencent.mm.plugin.ipcall.a.g.c rw(int i) {
        return (com.tencent.mm.plugin.ipcall.a.g.c) super.getItem(i);
    }

    public final void CN(String str) {
        this.ilo = str;
        if (bh.ov(this.ilo)) {
            this.nHM = false;
        } else {
            this.nHM = true;
        }
        this.xIh.clear();
        Xy();
        notifyDataSetChanged();
    }

    public final void Xy() {
        Cursor CF;
        Object obj = null;
        if (this.nHM) {
            this.kFT = true;
            CF = i.aTD().CF(this.ilo);
            this.kFT = false;
        } else {
            CF = i.aTD().gJP.query("IPCallAddressItem", d.nGI, null, null, null, null, "upper(sortKey) asc");
        }
        if (CF != null) {
            CF.moveToFirst();
        }
        setCursor(CF);
        if (getCursor() != null) {
            Cursor cursor = getCursor();
            try {
                if (cursor.moveToFirst()) {
                    int i = 0;
                    while (!cursor.isAfterLast()) {
                        com.tencent.mm.plugin.ipcall.a.g.c cVar = new com.tencent.mm.plugin.ipcall.a.g.c();
                        cVar.b(cursor);
                        String CO = CO(cVar.field_sortKey);
                        if (i == 0) {
                            this.ldT.put(CO, Integer.valueOf(i));
                        } else if (obj != null) {
                            if (!CO.equals(obj)) {
                                this.ldT.put(CO, Integer.valueOf(i));
                            }
                        }
                        i++;
                        cursor.moveToNext();
                        String str = CO;
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.IPCallAddressAdapter", "initSectionPosMap error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    public final void aUn() {
        super.aUn();
    }

    protected final void Xz() {
        super.aUn();
        Xy();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.i.dmh, viewGroup, false);
            b bVar = new b(this, (byte) 0);
            bVar.nHZ = view.findViewById(R.h.crx);
            bVar.nIa = view.findViewById(R.h.ccl);
            bVar.ihQ = (ImageView) view.findViewById(R.h.bLL);
            bVar.jLc = (TextView) view.findViewById(R.h.cAn);
            bVar.nHR = (TextView) view.findViewById(R.h.cCu);
            bVar.nHS = (LinearLayout) view.findViewById(R.h.cGl);
            bVar.nHT = (TextView) view.findViewById(R.h.cGm);
            bVar.nHU = (TextView) view.findViewById(R.h.cGn);
            bVar.nHV = (TextView) view.findViewById(R.h.bJo);
            bVar.nHW = (TextView) view.findViewById(R.h.bJi);
            bVar.nHX = (ImageView) view.findViewById(R.h.bJj);
            bVar.nHY = view.findViewById(R.h.crz);
            bVar.nHY.setClickable(true);
            bVar.nIb = (ImageView) view.findViewById(R.h.divider);
            view.setTag(bVar);
        }
        b bVar2 = (b) view.getTag();
        bVar2.nHY.setClickable(true);
        bVar2.nHY.setTag(Integer.valueOf(i));
        bVar2.nIb.setVisibility(8);
        if (qY(i)) {
            bVar2.jLc.setVisibility(8);
            bVar2.nHR.setVisibility(8);
            bVar2.nHS.setVisibility(8);
            bVar2.ihQ.setVisibility(8);
            bVar2.ihQ.setTag(null);
            bVar2.nHW.setVisibility(8);
            bVar2.nHV.setVisibility(8);
            bVar2.nHX.setVisibility(8);
        } else {
            com.tencent.mm.plugin.ipcall.a.g.c rw = rw(i);
            if (rw != null) {
                CharSequence charSequence;
                if (bh.ov(rw.field_systemAddressBookUsername)) {
                    bVar2.jLc.setVisibility(8);
                    bVar2.nHR.setVisibility(8);
                } else {
                    bVar2.jLc.setVisibility(0);
                    LayoutParams layoutParams;
                    RelativeLayout.LayoutParams layoutParams2;
                    if (this.nHM) {
                        bVar2.nHR.setVisibility(0);
                        layoutParams = (LayoutParams) bVar2.nHZ.getLayoutParams();
                        layoutParams.height = (int) bVar2.nHR.getContext().getResources().getDimension(R.f.bwb);
                        bVar2.nHZ.setLayoutParams(layoutParams);
                        layoutParams2 = (RelativeLayout.LayoutParams) bVar2.ihQ.getLayoutParams();
                        layoutParams2.height = (int) bVar2.ihQ.getContext().getResources().getDimension(R.f.bvY);
                        layoutParams2.width = (int) bVar2.ihQ.getContext().getResources().getDimension(R.f.bvY);
                        bVar2.ihQ.setLayoutParams(layoutParams2);
                    } else {
                        bVar2.nHR.setVisibility(8);
                        layoutParams = (LayoutParams) bVar2.nHZ.getLayoutParams();
                        layoutParams.height = (int) bVar2.nHR.getContext().getResources().getDimension(R.f.bwa);
                        bVar2.nHZ.setLayoutParams(layoutParams);
                        layoutParams2 = (RelativeLayout.LayoutParams) bVar2.ihQ.getLayoutParams();
                        layoutParams2.height = (int) bVar2.ihQ.getContext().getResources().getDimension(R.f.bvZ);
                        layoutParams2.width = (int) bVar2.ihQ.getContext().getResources().getDimension(R.f.bvZ);
                        bVar2.ihQ.setLayoutParams(layoutParams2);
                    }
                    if (this.nHM && rw.nGH == null && nGG != null && nGG.containsKey(rw.field_contactId)) {
                        rw.nGH = ((com.tencent.mm.plugin.ipcall.a.g.c) nGG.get(rw.field_contactId)).nGH;
                    } else if (this.nHM && rw.nGH == null && (nGG == null || nGG.containsKey(rw.field_contactId))) {
                        rw.nGH = b.CC(rw.field_contactId);
                    }
                    if (!bh.ov(this.ilo) && (bh.p(this.ilo.charAt(0)) || this.ilo.startsWith("+"))) {
                        bVar2.nHR.setText(com.tencent.mm.bc.b.a(a(rw, this.ilo), ao.Vj(this.ilo)));
                        bVar2.jLc.setText(com.tencent.mm.bc.b.a(rw.field_systemAddressBookUsername, this.ilo));
                    } else if (!bh.ov(this.ilo) && !bh.p(this.ilo.charAt(0))) {
                        String str;
                        CharSequence charSequence2 = rw.field_systemAddressBookUsername;
                        String str2 = rw.field_systemAddressBookUsername;
                        CharSequence charSequence3 = this.ilo;
                        if (bh.ov(charSequence3) || bh.ov(str2)) {
                            str = "";
                        } else {
                            if (!bh.Vq(charSequence3) && bh.Vr(charSequence3)) {
                                int i2;
                                int i3;
                                List arrayList = new ArrayList();
                                for (i2 = 0; i2 < str2.length(); i2++) {
                                    String substring = str2.substring(i2, i2 + 1);
                                    arrayList.add(new a(this, com.tencent.mm.platformtools.c.ol(substring), substring));
                                }
                                for (i2 = 2; i2 <= str2.length(); i2++) {
                                    for (i3 = 0; i3 <= str2.length() - i2; i3++) {
                                        String substring2 = str2.substring(i3, i3 + i2);
                                        arrayList.add(new a(this, com.tencent.mm.platformtools.c.ol(substring2), substring2));
                                    }
                                }
                                for (i3 = 0; i3 < arrayList.size(); i3++) {
                                    a aVar = (a) arrayList.get(i3);
                                    if (aVar.nHP.contains(charSequence3)) {
                                        str = aVar.nHQ;
                                        break;
                                    }
                                }
                            }
                            charSequence = charSequence3;
                        }
                        bVar2.jLc.setText(com.tencent.mm.bc.b.a(charSequence2, str));
                        bVar2.nHR.setText(a(rw, this.ilo));
                    } else if (bh.ov(this.ilo)) {
                        bVar2.jLc.setText(rw.field_systemAddressBookUsername);
                    }
                }
                ImageView imageView = bVar2.ihQ;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    imageView.setTag(null);
                    imageView.setImageResource(R.g.bDh);
                    if (rw != null) {
                        if (!bh.ov(rw.field_contactId) && !bh.ov(rw.field_wechatUsername)) {
                            this.nHJ.a(rw.field_contactId, rw.field_wechatUsername, imageView);
                        } else if (!bh.ov(rw.field_contactId)) {
                            this.nHJ.b(rw.field_contactId, imageView);
                        } else if (!bh.ov(rw.field_wechatUsername)) {
                            this.nHJ.c(rw.field_wechatUsername, imageView);
                        }
                        if (!bh.ov(rw.field_wechatUsername)) {
                            this.nHL.add(rw.field_wechatUsername);
                        }
                    }
                }
                bVar2.nHS.setVisibility(8);
                charSequence = CO(rw.field_sortKey);
                if (i == 0) {
                    bVar2.nHV.setVisibility(0);
                    bVar2.nHV.setText(charSequence);
                    bVar2.nHW.setVisibility(8);
                } else if (CO(rw(i - 1).field_sortKey).equals(charSequence)) {
                    bVar2.nHV.setVisibility(8);
                    bVar2.nHV.setText("");
                    bVar2.nHW.setVisibility(8);
                } else {
                    bVar2.nHV.setVisibility(0);
                    bVar2.nHV.setText(charSequence);
                    bVar2.nHW.setVisibility(8);
                }
            }
            bVar2.nHY.setVisibility(8);
            bVar2.nHX.setVisibility(8);
            bVar2.nHX.setOnClickListener(this.nHN);
        }
        Object obj = 1;
        if (!(rw(i + 1) == null || rw(i) == null || CO(rw(i + 1).field_sortKey).equals(CO(rw(i).field_sortKey)))) {
            obj = null;
        }
        if (i + 1 == getCount() || r1 == null) {
            bVar2.nIa.setVisibility(8);
        } else {
            bVar2.nIa.setVisibility(0);
        }
        return view;
    }

    private static String a(com.tencent.mm.plugin.ipcall.a.g.c cVar, String str) {
        if (!(cVar == null || cVar.nGH == null)) {
            Iterator it = cVar.nGH.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (str2.contains(str)) {
                    return str2;
                }
            }
        }
        return null;
    }

    private static String CO(String str) {
        if (bh.ov(str)) {
            return "";
        }
        if (str.startsWith(b.ldS)) {
            return "#";
        }
        return str.toUpperCase().substring(0, 1);
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
        this.nHK.clear();
        super.notifyDataSetChanged();
    }
}
