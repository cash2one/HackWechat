package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.a.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.List;

public final class b implements a {
    public final List<Preference> a(Context context, f fVar, MallTransactionObject mallTransactionObject) {
        f fVar2;
        f fVar3;
        List<Preference> arrayList = new ArrayList();
        boolean z = mallTransactionObject.fjw == 2;
        if (!(bh.ov(mallTransactionObject.paB) || bh.ov(mallTransactionObject.iOg))) {
            d dVar = new d(context);
            dVar.lRA = mallTransactionObject.iOg;
            dVar.mName = mallTransactionObject.paB;
            dVar.mOnClickListener = new 1(this, mallTransactionObject, context);
            arrayList.add(dVar);
            arrayList.add(new PreferenceSmallCategory(context));
        }
        x.i("MicroMsg.FetchOrderPrefFactory", "getOrderPrefList() chargeFee is " + mallTransactionObject.paQ + " and fetchTotalFee is " + mallTransactionObject.pba);
        h hVar;
        if (TextUtils.isEmpty(mallTransactionObject.paQ)) {
            CharSequence string;
            boolean z2;
            i iVar = new i(context);
            iVar.pdg = e.d(mallTransactionObject.ljg, mallTransactionObject.paz);
            if (z) {
                string = context.getString(i.uTg);
            } else {
                string = context.getString(i.uTq);
            }
            iVar.setTitle(string);
            if (!bh.ov(mallTransactionObject.par)) {
                iVar.Hp(mallTransactionObject.par);
            }
            arrayList.add(iVar);
            if (mallTransactionObject.ljg == mallTransactionObject.paF || mallTransactionObject.paF <= 0.0d) {
                z2 = false;
            } else {
                hVar = new h(context);
                hVar.pdd = false;
                hVar.pde = true;
                arrayList.add(hVar);
                fVar2 = new f(context);
                fVar2.setContent(e.d(mallTransactionObject.paF, mallTransactionObject.paz));
                fVar2.setTitle(i.uTy);
                arrayList.add(fVar2);
                if (!bh.ov(mallTransactionObject.paE)) {
                    g gVar = new g(context);
                    gVar.setTitle(i.uTn);
                    gVar.jKn = fVar;
                    String[] split = mallTransactionObject.paE.split("\n");
                    if (split.length == 1) {
                        gVar.pcW = split[0];
                    } else {
                        gVar.pcW = context.getString(i.uTo, new Object[]{Integer.valueOf(split.length), e.d(mallTransactionObject.paF - mallTransactionObject.ljg, mallTransactionObject.paz)});
                        gVar.a(split, TruncateAt.MIDDLE);
                    }
                    arrayList.add(gVar);
                }
                z2 = true;
            }
            h hVar2 = new h(context);
            hVar2.pdd = z2;
            hVar2.pde = true;
            arrayList.add(hVar2);
        } else {
            i iVar2 = new i(context);
            iVar2.pdg = e.d(mallTransactionObject.pba, mallTransactionObject.paz);
            iVar2.setTitle(context.getString(i.uTh));
            if (!bh.ov(mallTransactionObject.pbb)) {
                iVar2.Hp(mallTransactionObject.pbb);
            }
            arrayList.add(iVar2);
            hVar = new h(context);
            hVar.pdd = false;
            hVar.pde = true;
            arrayList.add(hVar);
            fVar2 = new f(context);
            fVar2.setTitle(i.uTq);
            fVar2.setContent(e.d(mallTransactionObject.ljg, mallTransactionObject.paz));
            arrayList.add(fVar2);
            fVar2 = new f(context);
            fVar2.setTitle(i.uTi);
            fVar2.setContent(mallTransactionObject.paQ);
            arrayList.add(fVar2);
        }
        if (!bh.ov(mallTransactionObject.desc)) {
            if (z) {
                fVar3 = new f(context);
                fVar3.setTitle(i.uTw);
                fVar3.setContent(mallTransactionObject.desc);
                arrayList.add(fVar3);
            } else {
                fVar3 = new f(context);
                fVar3.setTitle(i.uzl);
                if (bh.ov(mallTransactionObject.pap)) {
                    fVar3.setContent(mallTransactionObject.desc);
                } else {
                    String string2 = context.getString(i.uTj);
                    fVar3.a(mallTransactionObject.desc + " " + string2, mallTransactionObject.desc.length() + 1, string2.length() + (mallTransactionObject.desc.length() + 1), new 2(this, mallTransactionObject, fVar3, fVar));
                }
                arrayList.add(fVar3);
            }
        }
        if (!bh.ov(mallTransactionObject.pao)) {
            fVar3 = new f(context);
            fVar3.setTitle(i.uTx);
            fVar3.setContent(mallTransactionObject.pao);
            arrayList.add(fVar3);
        }
        if (!bh.ov(mallTransactionObject.pat)) {
            fVar3 = new f(context);
            fVar3.setTitle(i.uTJ);
            fVar3.setContent(mallTransactionObject.pat);
            if (!bh.ov(mallTransactionObject.pau)) {
                fVar3.Ho(mallTransactionObject.pau);
            }
            arrayList.add(fVar3);
        }
        fVar3 = new f(context);
        fVar3.setTitle(i.uTt);
        fVar3.setContent(e.HD(mallTransactionObject.hzW));
        arrayList.add(fVar3);
        if (mallTransactionObject.paM > 0) {
            fVar3 = new f(context);
            fVar3.setTitle(i.uTr);
            fVar3.setContent(e.HD(mallTransactionObject.paM));
            arrayList.add(fVar3);
        } else if (mallTransactionObject.paL > 0) {
            fVar3 = new f(context);
            fVar3.setTitle(i.uTu);
            fVar3.setContent(e.HD(mallTransactionObject.paL));
            arrayList.add(fVar3);
        } else {
            x.e("MicroMsg.FetchOrderPrefFactory", "hy: is fetch but no arrive time or fetch time");
        }
        if (!bh.ov(mallTransactionObject.pax)) {
            fVar2 = new f(context);
            fVar2.setTitle(i.uTs);
            String str = mallTransactionObject.pax;
            if (!bh.ov(mallTransactionObject.pay)) {
                str = str + "(" + mallTransactionObject.pay + ")";
            }
            fVar2.setContent(str);
            arrayList.add(fVar2);
        }
        if (!bh.ov(mallTransactionObject.paw)) {
            fVar3 = new f(context);
            fVar3.setTitle(i.uTv);
            fVar3.setContent(mallTransactionObject.paw);
            arrayList.add(fVar3);
        }
        h hVar3;
        if (bh.ov(mallTransactionObject.paJ) && bh.ov(mallTransactionObject.paA) && bh.ov(mallTransactionObject.pac)) {
            hVar3 = new h(context);
            hVar3.pdd = true;
            hVar3.kej = false;
            arrayList.add(hVar3);
        } else {
            hVar3 = new h(context);
            hVar3.pdd = true;
            arrayList.add(hVar3);
            arrayList.add(com.tencent.mm.plugin.order.model.a.a(context, mallTransactionObject));
        }
        return arrayList;
    }
}
