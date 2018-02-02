package com.tencent.mm.plugin.recharge.ui;

import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.tencent.mm.plugin.recharge.model.b;
import com.tencent.mm.plugin.recharge.ui.MallEditText.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

class MallEditText$a$a extends Filter {
    final /* synthetic */ a pCE;

    private MallEditText$a$a(a aVar) {
        this.pCE = aVar;
    }

    protected final synchronized FilterResults performFiltering(CharSequence charSequence) {
        FilterResults filterResults;
        FilterResults filterResults2 = new FilterResults();
        List arrayList = new ArrayList();
        String Id = charSequence != null ? b.Id(charSequence.toString()) : "";
        if (Id.equals(a.a(this.pCE))) {
            MallEditText.a(this.pCE.pCy).post(new Runnable(this) {
                final /* synthetic */ MallEditText$a$a pCF;

                {
                    this.pCF = r1;
                }

                public final void run() {
                    MallEditText.a(this.pCF.pCE.pCy).dismissDropDown();
                }
            });
            filterResults = filterResults2;
        } else {
            com.tencent.mm.plugin.recharge.model.a aVar;
            boolean z;
            boolean z2;
            a.a(this.pCE, Id);
            if (this.pCE.pCy.XO()) {
                long currentTimeMillis = System.currentTimeMillis();
                x.d("MicroMsg.MallEditText", "performFiltering " + charSequence);
                for (com.tencent.mm.plugin.recharge.model.a aVar2 : a.b(this.pCE)) {
                    if (aVar2.pBH.equals(a.a(this.pCE))) {
                        aVar2.pBJ = com.tencent.mm.plugin.recharge.model.a.pBF;
                        arrayList.clear();
                        arrayList.add(aVar2);
                    }
                }
                if (arrayList.size() <= 0) {
                    if (MallEditText.f(this.pCE.pCy) == null) {
                        try {
                            MallEditText.a(this.pCE.pCy, com.tencent.mm.pluginsdk.a.bV(this.pCE.pCy.getContext()));
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.MallEditText", e, "", new Object[0]);
                        }
                    }
                    if (MallEditText.f(this.pCE.pCy) != null) {
                        for (String[] strArr : MallEditText.f(this.pCE.pCy)) {
                            String Id2 = b.Id(strArr[2]);
                            Object dL = dL(a.a(this.pCE), Id2);
                            if (com.tencent.mm.plugin.recharge.model.a.pBF.equals(dL)) {
                                com.tencent.mm.plugin.recharge.model.a aVar3 = new com.tencent.mm.plugin.recharge.model.a(Id2, strArr[1], 1);
                                aVar3.pBJ = com.tencent.mm.plugin.recharge.model.a.pBF;
                                arrayList.clear();
                                arrayList.add(aVar3);
                                break;
                            } else if (!com.tencent.mm.plugin.recharge.model.a.pBG.equals(dL) && arrayList.size() < 5) {
                                com.tencent.mm.plugin.recharge.model.a aVar4 = new com.tencent.mm.plugin.recharge.model.a(Id2, strArr[1], 1);
                                aVar4.pBJ = dL;
                                arrayList.add(aVar4);
                            }
                        }
                    }
                }
                x.d("MicroMsg.MallEditText", " search phone number cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
                z = true;
            } else if (bh.ov(a.a(this.pCE))) {
                arrayList.addAll(a.b(this.pCE));
                z = false;
            } else {
                x.d("MicroMsg.MallEditText", "performFiltering " + charSequence);
                for (com.tencent.mm.plugin.recharge.model.a aVar22 : a.b(this.pCE)) {
                    if (aVar22.pBH.startsWith(a.a(this.pCE))) {
                        arrayList.add(aVar22);
                    }
                }
                z = false;
            }
            if (arrayList.size() == 0) {
                MallEditText.a(this.pCE.pCy).post(new Runnable(this) {
                    final /* synthetic */ MallEditText$a$a pCF;

                    {
                        this.pCF = r1;
                    }

                    public final void run() {
                        MallEditText.a(this.pCF.pCE.pCy).dismissDropDown();
                    }
                });
                z2 = false;
            } else {
                if (arrayList.size() == 1 && this.pCE.pCy.XO()) {
                    aVar22 = (com.tencent.mm.plugin.recharge.model.a) arrayList.get(0);
                    if (com.tencent.mm.plugin.recharge.model.a.pBF.equals(aVar22.pBJ)) {
                        MallEditText.a(this.pCE.pCy).post(new 3(this, aVar22));
                        z2 = false;
                    }
                }
                z2 = z;
            }
            List list = this.pCE.pCz;
            this.pCE.pCz = arrayList;
            this.pCE.pCA = z2;
            filterResults2.count = this.pCE.pCz.size();
            filterResults2.values = this.pCE.pCz;
            x.d("MicroMsg.MallEditText", "results.count " + filterResults2.count);
            list.clear();
            filterResults = filterResults2;
        }
        return filterResults;
    }

    protected final void publishResults(CharSequence charSequence, FilterResults filterResults) {
    }

    private static int[] dL(String str, String str2) {
        if (str.equals(str2)) {
            return com.tencent.mm.plugin.recharge.model.a.pBF;
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
        return com.tencent.mm.plugin.recharge.model.a.pBG;
    }
}
