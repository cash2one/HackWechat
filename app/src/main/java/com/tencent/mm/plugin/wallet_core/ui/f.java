package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet.a.k;
import com.tencent.mm.plugin.wallet.a.l;
import com.tencent.mm.plugin.wallet_core.e.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class f extends BaseAdapter {
    private Context mContext;
    private Orders pPl = null;
    private a sBT;
    private int sEM;
    private int sSY = -1;
    public String sSZ = "";
    public boolean sTa = true;
    private boolean sTb = false;
    public ArrayList<Bankcard> szk;

    public /* synthetic */ Object getItem(int i) {
        return zc(i);
    }

    public f(Context context, ArrayList<Bankcard> arrayList, int i, Orders orders) {
        this.mContext = context;
        this.szk = arrayList;
        this.sEM = i;
        this.pPl = orders;
        this.sBT = new a();
        this.sBT.b(this.mContext, this.szk);
        if (orders != null && orders.sOe == 1) {
            this.sTb = true;
        }
    }

    public int getCount() {
        int i = 0;
        if (!this.sTb) {
            if (this.pPl == null || !this.pPl.sNS.equals("CFT")) {
                i = 1;
            }
            return this.szk != null ? i + this.szk.size() : i;
        } else if (this.szk == null) {
            return 0;
        } else {
            return this.szk.size();
        }
    }

    public Bankcard zc(int i) {
        if (this.sTb) {
            return (Bankcard) this.szk.get(i);
        }
        int count = getCount();
        if (this.pPl == null || !this.pPl.sNS.equals("CFT")) {
            count--;
        }
        if (i < count) {
            return (Bankcard) this.szk.get(i);
        }
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean isEnabled(int i) {
        Bankcard zc = zc(i);
        if (zc == null || zc.a(this.sEM, this.pPl) == 0) {
            return true;
        }
        return false;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.mContext, a$g.uEM, null);
            aVar = new a(this);
            aVar.ihS = (TextView) view.findViewById(com.tencent.mm.plugin.wxpay.a.f.title);
            aVar.pjN = (TextView) view.findViewById(com.tencent.mm.plugin.wxpay.a.f.summary);
            aVar.sTe = (CheckedTextView) view.findViewById(com.tencent.mm.plugin.wxpay.a.f.gVp);
            aVar.sTf = (ImageView) view.findViewById(com.tencent.mm.plugin.wxpay.a.f.ueZ);
            aVar.sTd = (FavourLayout) view.findViewById(com.tencent.mm.plugin.wxpay.a.f.ukt);
            aVar.pjN.setText("");
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.pjN.setTextColor(ac.getResources().getColor(c.bsO));
        aVar.sTd.setVisibility(8);
        Bankcard zc = zc(i);
        LinkedList linkedList;
        if (zc == null) {
            aVar.sTe.setVisibility(4);
            aVar.pjN.setVisibility(8);
            aVar.ihS.setText(a$i.uUs);
            aVar.sTf.setVisibility(8);
            LinkedList linkedList2 = new LinkedList();
            if (!(this.pPl == null || this.pPl.sNX == null || this.pPl.sNX.sDB == null)) {
                k kVar = this.pPl.sNX.sDB.sDh;
                if (kVar != null) {
                    Iterator it = kVar.sDL.iterator();
                    while (it.hasNext()) {
                        linkedList2.add(((l) it.next()).pKc);
                    }
                    linkedList = linkedList2;
                    if (this.sTa && linkedList.size() > 0) {
                        aVar.sTd.setVisibility(0);
                        aVar.pjN.setVisibility(8);
                        aVar.sTd.an(linkedList);
                    }
                }
            }
            linkedList = linkedList2;
            aVar.sTd.setVisibility(0);
            aVar.pjN.setVisibility(8);
            aVar.sTd.an(linkedList);
        } else {
            aVar.sTf.setVisibility(0);
            aVar.sTe.setVisibility(0);
            aVar.pjN.setVisibility(0);
            aVar.pjN.setText("");
            aVar.ihS.setText(zc.field_desc);
            if (zc.bKP()) {
                Bankcard bankcard = o.bLq().szU;
                if (!bh.ov(bankcard.sLg)) {
                    aVar.ihS.setText(bankcard.sLg);
                } else if (bankcard.sLf >= 0.0d) {
                    aVar.ihS.setText(this.mContext.getString(q.Gf() ? a$i.uQJ : a$i.uQI, new Object[]{e.u(bankcard.sLf)}));
                } else {
                    aVar.ihS.setText(this.mContext.getText(a$i.uRT));
                }
            } else if (zc.bKQ()) {
                Bankcard bankcard2 = o.bLq().sQf;
                if (!bh.ov(bankcard2.sLg)) {
                    aVar.ihS.setText(bankcard2.sLg);
                } else if (bankcard2.sLf >= 0.0d) {
                    aVar.ihS.setText(this.mContext.getString(a$i.uSp, new Object[]{e.u(bankcard2.sLf)}));
                } else {
                    aVar.ihS.setText(this.mContext.getText(a$i.uRT));
                }
            }
            aVar.pjN.setVisibility(0);
            switch (zc.a(this.sEM, this.pPl)) {
                case 1:
                    aVar.pjN.setText(a$i.uUv);
                    break;
                case 2:
                    aVar.pjN.setText(a$i.uUB);
                    break;
                case 3:
                    aVar.pjN.setText(a$i.uUG);
                    break;
                case 4:
                    aVar.pjN.setText(a$i.uUx);
                    break;
                case 5:
                    aVar.pjN.setText(a$i.uUt);
                    break;
                case 6:
                    aVar.pjN.setText(a$i.uUz);
                    break;
                case 7:
                    aVar.pjN.setText(a$i.uUE);
                    break;
                case 8:
                    aVar.pjN.setText(zc.field_forbidWord);
                    break;
                default:
                    if (!bh.ov(zc.field_tips)) {
                        aVar.pjN.setText(zc.field_tips);
                        break;
                    }
                    aVar.pjN.setVisibility(8);
                    break;
            }
            String charSequence = aVar.pjN.getText().toString();
            aVar.ihS.setTextColor(this.mContext.getResources().getColor(c.btv));
            if (this.sSZ.equalsIgnoreCase(zc.field_bindSerial)) {
                aVar.sTe.setChecked(true);
                aVar.sTe.setEnabled(true);
            } else if (isEnabled(i)) {
                aVar.sTe.setChecked(false);
                aVar.sTe.setEnabled(true);
            } else {
                aVar.sTe.setEnabled(false);
                aVar.sTe.setChecked(false);
                aVar.ihS.setTextColor(this.mContext.getResources().getColor(c.bsO));
            }
            aVar.sTf.setTag(com.tencent.mm.plugin.wxpay.a.f.uyA, null);
            aVar.sTf.setTag(null);
            aVar.sTf.setImageDrawable(null);
            aVar.pjN.setOnClickListener(null);
            if (zc.bKP()) {
                ImageView imageView = aVar.sTf;
                if (imageView != null) {
                    imageView.setTag(com.tencent.mm.plugin.wxpay.a.f.uyA, null);
                    imageView.setImageResource(com.tencent.mm.plugin.wxpay.a.e.udF);
                }
            } else if (zc.bKQ()) {
                this.sBT.a(zc, aVar.sTf);
            } else if (zc.bKT()) {
                b.a(aVar.sTf, zc.sLr, 0.06f, false);
            } else {
                this.sBT.a(this.mContext, zc, aVar.sTf);
            }
            if (!bh.ov(zc.field_forbid_title) && !bh.ov(zc.field_forbid_url)) {
                charSequence = charSequence + "  ";
                CharSequence spannableString = new SpannableString(charSequence + zc.field_forbid_title);
                aVar.pjN.setOnClickListener(new 1(this));
                spannableString.setSpan(new ForegroundColorSpan(ac.getResources().getColor(c.ubz)), charSequence.length(), charSequence.length() + zc.field_forbid_title.length(), 34);
                aVar.pjN.setText(spannableString);
                aVar.pjN.setTag(zc.field_forbid_url);
            } else if (this.sTa && bh.ov(zc.field_forbidWord) && bh.ov(charSequence)) {
                linkedList = f(zc);
                if (linkedList.size() > 0) {
                    aVar.sTd.setVisibility(0);
                    aVar.pjN.setVisibility(8);
                    aVar.sTd.an(linkedList);
                }
            }
        }
        return view;
    }

    private LinkedList<String> f(Bankcard bankcard) {
        LinkedList<String> linkedList = new LinkedList();
        if (!(this.pPl == null || this.pPl.sNX == null || this.pPl.sNX.sDB == null)) {
            Iterator it = this.pPl.sNX.sDB.sDg.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.wallet.a.b bVar = (com.tencent.mm.plugin.wallet.a.b) it.next();
                if (bVar.oZA.equals(bankcard.field_bindSerial)) {
                    it = bVar.sDi.iterator();
                    while (it.hasNext()) {
                        linkedList.add(((com.tencent.mm.plugin.wallet.a.c) it.next()).pKc);
                    }
                    return linkedList;
                }
            }
        }
        return linkedList;
    }

    public final void d(ArrayList<Bankcard> arrayList, boolean z) {
        if (arrayList == null) {
            this.szk = new ArrayList();
        } else {
            this.szk = arrayList;
        }
        this.sTa = z;
        if (this.szk.size() > 0) {
            this.sBT.b(this.mContext, this.szk);
        }
        notifyDataSetChanged();
    }
}
