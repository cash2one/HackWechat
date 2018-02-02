package com.tencent.mm.plugin.recharge.ui.form;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.recharge.model.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class d extends BaseAdapter implements Filterable {
    private static String TAG = "MicroMsg.MobileHistoryAdapter";
    private Context mContext;
    public boolean pCA = false;
    private List<a> pCB;
    private String pCD;
    private AutoCompleteTextView pCp;
    private List<String[]> pCt;
    public List<a> pCz = new ArrayList();
    private b pEO;
    public d pEP = null;
    public a pEQ = null;
    private MallFormView pEb;

    private class b extends Filter {
        final /* synthetic */ d pER;

        private b(d dVar) {
            this.pER = dVar;
        }

        protected final synchronized FilterResults performFiltering(CharSequence charSequence) {
            FilterResults filterResults;
            FilterResults filterResults2 = new FilterResults();
            List arrayList = new ArrayList();
            String Id = charSequence != null ? com.tencent.mm.plugin.recharge.model.b.Id(charSequence.toString()) : "";
            if (!Id.equals(this.pER.pCD) || Id.equals("")) {
                boolean z;
                this.pER.pCD = Id;
                if (this.pER.pEb.XO()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    x.i(d.TAG, "performFiltering2 " + charSequence);
                    a bmt = com.tencent.mm.plugin.recharge.a.a.bmt();
                    if (bmt == null || !Id.equals(bmt.pBH)) {
                        if (this.pER.pCt == null || this.pER.pCt.isEmpty()) {
                            this.pER.pCt = com.tencent.mm.pluginsdk.a.bV(this.pER.mContext);
                        }
                        if (this.pER.pCt != null) {
                            for (String[] strArr : this.pER.pCt) {
                                String Id2 = com.tencent.mm.plugin.recharge.model.b.Id(strArr[2]);
                                Object dL = dL(this.pER.pCD, Id2);
                                if (a.pBF.equals(dL)) {
                                    filterResults = filterResults2;
                                    break;
                                } else if (!a.pBG.equals(dL) && arrayList.size() < 4) {
                                    a aVar = new a(Id2, strArr[1], 1);
                                    aVar.pBJ = dL;
                                    arrayList.add(aVar);
                                }
                            }
                        }
                        for (a aVar2 : com.tencent.mm.plugin.recharge.a.a.bmr().bms()) {
                            Object dL2 = dL(this.pER.pCD, com.tencent.mm.plugin.recharge.model.b.Id(aVar2.pBH));
                            if (a.pBF.equals(dL2)) {
                                filterResults = filterResults2;
                                break;
                            } else if (!a.pBG.equals(dL2) && arrayList.size() < 4) {
                                aVar2.pBJ = dL2;
                                arrayList.add(aVar2);
                            }
                        }
                        x.d(d.TAG, " search phone number cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
                        z = true;
                    } else {
                        filterResults = filterResults2;
                    }
                } else if (bh.ov(this.pER.pCD)) {
                    arrayList.addAll(this.pER.pCB);
                    z = false;
                } else {
                    x.i(d.TAG, "performFiltering1 " + charSequence);
                    for (a aVar22 : this.pER.pCB) {
                        if (aVar22.pBH.startsWith(this.pER.pCD)) {
                            arrayList.add(aVar22);
                        }
                    }
                    z = false;
                }
                filterResults2.count = arrayList.size();
                filterResults2.values = arrayList;
                this.pER.pCA = z;
                if (arrayList.size() == 0) {
                    this.pER.pEb.pEL = true;
                } else {
                    this.pER.pEb.pEL = false;
                }
                filterResults = filterResults2;
            } else {
                this.pER.pCp.post(new 1(this));
                filterResults = filterResults2;
            }
            return filterResults;
        }

        protected final void publishResults(CharSequence charSequence, FilterResults filterResults) {
            if (filterResults.values == null) {
                this.pER.pCz = new ArrayList();
            } else {
                this.pER.pCz = (List) filterResults.values;
            }
            x.i(d.TAG, "results.count " + filterResults.count);
            if (filterResults.count > 0) {
                this.pER.notifyDataSetChanged();
            }
        }

        private static int[] dL(String str, String str2) {
            if (str.equals(str2)) {
                return a.pBF;
            }
            if (str2 != null && str.length() == str2.length()) {
                int[] iArr = new int[]{-1, -1};
                int i = 0;
                for (int length = str.length() - 1; length > 0; length--) {
                    if (str2.charAt(length) != str.charAt(length)) {
                        i++;
                        if (i > 2) {
                            break;
                        }
                        iArr[i - 1] = length;
                    }
                }
                if (i <= 2) {
                    return iArr;
                }
            }
            return a.pBG;
        }
    }

    private class c {
        TextView inw;
        TextView pCH;
        final /* synthetic */ d pER;
        ImageView pET;

        private c(d dVar) {
            this.pER = dVar;
        }
    }

    public interface d {
    }

    public final /* synthetic */ Object getItem(int i) {
        return vl(i);
    }

    public d(MallFormView mallFormView, List<String[]> list) {
        this.mContext = mallFormView.getContext();
        this.pEb = mallFormView;
        this.pCp = (AutoCompleteTextView) mallFormView.pEh;
        this.pCt = list;
    }

    public final synchronized void bt(List<a> list) {
        this.pCB = list;
        this.pCz.clear();
        this.pCA = false;
        notifyDataSetChanged();
    }

    public final Filter getFilter() {
        x.d(TAG, "getFilter");
        if (this.pEO == null) {
            this.pEO = new b();
        }
        return this.pEO;
    }

    public final int getCount() {
        if (this.pCA) {
            return this.pCz.size() + 2;
        }
        return this.pCz.size() > 0 ? this.pCz.size() + 1 : 0;
    }

    public final synchronized a vl(int i) {
        a aVar = null;
        synchronized (this) {
            if (this.pCA) {
                if (i != 0) {
                    if (i <= this.pCz.size()) {
                        aVar = (a) this.pCz.get(i - 1);
                    }
                }
            } else if (i < this.pCz.size()) {
                aVar = (a) this.pCz.get(i);
            }
        }
        return aVar;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        switch (getItemViewType(i)) {
            case 0:
                c cVar;
                if (view == null) {
                    view = View.inflate(this.mContext, g.uDR, null);
                    c cVar2 = new c();
                    cVar2.pCH = (TextView) view.findViewById(f.uqc);
                    cVar2.inw = (TextView) view.findViewById(f.uqb);
                    cVar2.pET = (ImageView) view.findViewById(f.uxk);
                    view.setTag(cVar2);
                    cVar = cVar2;
                } else {
                    cVar = (c) view.getTag();
                }
                if (!(cVar == null || cVar.pET == null)) {
                    if (i == 0) {
                        cVar.pET.setVisibility(0);
                    } else {
                        cVar.pET.setVisibility(8);
                    }
                }
                a vl = vl(i);
                if (vl == null || cVar == null || cVar.pCH == null || cVar.inw == null) {
                    return view;
                }
                CharSequence Ie = com.tencent.mm.plugin.recharge.model.b.Ie(vl.pBH);
                x.d(TAG, "record.record " + Ie + ", record.name " + vl.name + "，record.location " + vl.pBI);
                if (a.pBF.equals(vl.pBJ)) {
                    cVar.pCH.setTextSize(16.0f);
                    cVar.pCH.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.bsO));
                    cVar.inw.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.bsO));
                    cVar.pCH.setText(Ie);
                } else {
                    CharSequence spannableStringBuilder = new SpannableStringBuilder(Ie);
                    for (int i2 : vl.pBJ) {
                        int i22;
                        if (i22 >= 0) {
                            if (i22 >= 7) {
                                i22 += 2;
                            } else if (i22 >= 3) {
                                i22++;
                            }
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.ubo)), i22, i22 + 1, 34);
                        }
                    }
                    cVar.pCH.setTextSize(24.0f);
                    cVar.pCH.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btv));
                    cVar.inw.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btv));
                    cVar.pCH.setText(spannableStringBuilder);
                }
                if (vl.name != null && !bh.ov(vl.name.trim())) {
                    if (bh.ov(vl.pBI)) {
                        cVar.inw.setText(vl.name);
                    } else {
                        cVar.inw.setText(vl.name + this.mContext.getString(i.uVN, new Object[]{vl.pBI}));
                    }
                    if (vl.name.equals(this.mContext.getString(i.uVT))) {
                        cVar.inw.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.ubm));
                        return view;
                    }
                    cVar.inw.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.bts));
                    return view;
                } else if (bh.ov(vl.pBI)) {
                    cVar.inw.setText(this.mContext.getString(i.uVV));
                    return view;
                } else {
                    cVar.inw.setText(this.mContext.getString(i.uVV) + this.mContext.getString(i.uVN, new Object[]{vl.pBI}));
                    return view;
                }
            case 1:
                view = View.inflate(this.mContext, g.uDS, null);
                view.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ d pER;

                    {
                        this.pER = r1;
                    }

                    public final void onClick(View view) {
                        com.tencent.mm.plugin.recharge.a.a.bmr().bt(null);
                        this.pER.pEb.bmK();
                        this.pER.bt(new LinkedList());
                        if (this.pER.pEQ != null) {
                            this.pER.pEQ.bmB();
                        }
                    }
                });
                return view;
            case 2:
                view = View.inflate(this.mContext, g.uDQ, null);
                view.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ d pER;

                    {
                        this.pER = r1;
                    }

                    public final void onClick(View view) {
                        this.pER.pCp.dismissDropDown();
                    }
                });
                return view;
            case 3:
                view = View.inflate(this.mContext, g.uDS, null);
                ((TextView) view.findViewById(f.uve)).setText(i.uLO);
                view.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ d pER;

                    {
                        this.pER = r1;
                    }

                    public final void onClick(View view) {
                        this.pER.pCp.dismissDropDown();
                        this.pER.pEb.bmJ();
                    }
                });
                return view;
            default:
                return view;
        }
    }

    public final int getItemViewType(int i) {
        if (this.pCA) {
            if (i == 0) {
                return 2;
            }
            if (i > this.pCz.size()) {
                return 3;
            }
            return 0;
        } else if (i >= this.pCz.size()) {
            return 1;
        } else {
            return 0;
        }
    }

    public final int getViewTypeCount() {
        return 4;
    }
}
