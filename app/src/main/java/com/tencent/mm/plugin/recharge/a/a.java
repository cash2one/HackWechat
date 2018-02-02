package com.tencent.mm.plugin.recharge.a;

import android.telephony.PhoneNumberUtils;
import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.p;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

public class a implements ap {
    private List<com.tencent.mm.plugin.recharge.model.a> pBE = null;

    public static a bmr() {
        return (a) p.s(a.class);
    }

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void br(boolean z) {
    }

    public final void bq(boolean z) {
    }

    public final void onAccountRelease() {
    }

    public final boolean a(com.tencent.mm.plugin.recharge.model.a aVar) {
        if (aVar == null || !PhoneNumberUtils.isGlobalPhoneNumber(aVar.pBH)) {
            return false;
        }
        List<com.tencent.mm.plugin.recharge.model.a> bms = bms();
        for (com.tencent.mm.plugin.recharge.model.a aVar2 : bms) {
            if (aVar.pBH.equals(aVar2.pBH)) {
                if (bh.ov(aVar.name)) {
                    aVar.name = aVar2.name;
                }
                bms.remove(aVar2);
                bms.add(0, aVar);
                bt(bms);
                return true;
            }
        }
        bms.add(0, aVar);
        bt(bms);
        return true;
    }

    public final void bt(List<com.tencent.mm.plugin.recharge.model.a> list) {
        this.pBE = list;
        if (list == null || list.size() == 0) {
            this.pBE = new LinkedList();
        } else if (list.size() > 10) {
            for (int size = list.size() - 1; size >= 10; size--) {
                list.remove(size);
            }
        }
        JSONArray jSONArray = new JSONArray();
        for (com.tencent.mm.plugin.recharge.model.a bmu : this.pBE) {
            jSONArray.put(bmu.bmu());
            x.i("MicroMsg.SubCoreRecharge", "number: %s", new Object[]{bmu.name});
        }
        x.d("MicroMsg.SubCoreRecharge", "setMobileHistory : " + jSONArray.toString());
        g.Dj().CU().set(270337, jSONArray.toString());
        g.Dj().CU().lH(true);
    }

    public final List<com.tencent.mm.plugin.recharge.model.a> bms() {
        if (this.pBE != null) {
            return this.pBE;
        }
        this.pBE = new LinkedList();
        String str = (String) g.Dj().CU().get(270337, null);
        if (bh.ov(str)) {
            x.i("MicroMsg.SubCoreRecharge", "empty history");
            return this.pBE;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < Math.min(jSONArray.length(), 100); i++) {
                com.tencent.mm.plugin.recharge.model.a R = com.tencent.mm.plugin.recharge.model.a.R(jSONArray.getJSONObject(i));
                if (R != null) {
                    this.pBE.add(R);
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SubCoreRecharge", e, "", new Object[0]);
            String[] split = str.split("&");
            if (split != null && split.length > 0) {
                for (int i2 = 0; i2 < Math.min(split.length, 100); i2++) {
                    String[] split2 = split[i2].split("=");
                    if (split2.length == 2) {
                        this.pBE.add(new com.tencent.mm.plugin.recharge.model.a(split2[0], split2[1], 2));
                    } else if (split2.length == 1) {
                        this.pBE.add(new com.tencent.mm.plugin.recharge.model.a(split2[0], "", 2));
                    }
                }
            }
        }
        x.i("MicroMsg.SubCoreRecharge", "getMobileHistory : " + this.pBE.size());
        return this.pBE;
    }

    public static com.tencent.mm.plugin.recharge.model.a bmt() {
        String str = (String) g.Dj().CU().get(6, null);
        if (bh.ov(str)) {
            return null;
        }
        return new com.tencent.mm.plugin.recharge.model.a(str, ac.getContext().getString(i.uVT), 3);
    }
}
