package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.wallet_core.d.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ag {
    public int mRetryCount = 0;
    ArrayList<Bankcard> sCs = new ArrayList();
    ArrayList<Bankcard> sCt = new ArrayList();
    private ArrayList<Bankcard> sPX = new ArrayList();
    private ArrayList<Bankcard> sPY = new ArrayList();
    public af sPZ = null;
    public Bankcard sQa = null;
    ae sQb = null;
    public k sQc = null;
    public b sQd = null;
    private List<c> sQe = new LinkedList();
    public Bankcard sQf = null;
    public long sQg = bh.Wo();
    long sQh = 0;
    public long sQi = -1;
    private String sQj = "";
    public int sQk = 10000;
    public String sQl = "";
    public String sQm = "";
    public Bankcard szU = null;

    public ag() {
        bLV();
    }

    public final boolean bLL() {
        return this.sPZ == null || (this.sPZ != null && this.sPZ.bLK());
    }

    public final boolean bLM() {
        if (this.sPZ != null) {
            if (this.sPZ.field_is_reg == 1) {
                return true;
            }
        }
        return false;
    }

    public final boolean bLJ() {
        return this.sPZ != null && this.sPZ.bLJ();
    }

    public final boolean bLN() {
        if (this.sPZ != null) {
            if (this.sPZ.field_is_reg == 2) {
                return true;
            }
        }
        return false;
    }

    public final boolean bLO() {
        if (this.sPZ != null) {
            if (this.sPZ.field_is_open_touch == 1) {
                return true;
            }
        }
        return false;
    }

    public final String bLP() {
        if (this.sPZ != null) {
            return this.sPZ.field_ftf_pay_url;
        }
        return null;
    }

    public final ae bLQ() {
        if (this.sQb == null) {
            return new ae();
        }
        return this.sQb;
    }

    public final boolean bLR() {
        return this.sPZ != null && this.sPZ.field_isDomesticUser;
    }

    public final String azp() {
        if (this.sPZ != null) {
            return this.sPZ.field_true_name;
        }
        return null;
    }

    public final int bLS() {
        if (this.sPZ != null) {
            return this.sPZ.field_cre_type;
        }
        return 1;
    }

    public final String bLT() {
        g.Dk();
        String str = (String) g.Dj().CU().get(a.xwz, null);
        if (bh.ov(str)) {
            return this.sPZ != null ? this.sPZ.field_lct_wording : null;
        } else {
            return str;
        }
    }

    public final String bLU() {
        if (this.sPZ != null) {
            return this.sPZ.field_lct_url;
        }
        return null;
    }

    public final void bLV() {
        k kVar = null;
        if (g.Dh().Cy()) {
            Bankcard bankcard;
            this.sPZ = o.bLm().bMn();
            if (this.sPZ != null) {
                this.sQb = new ae(this.sPZ.field_switchConfig);
            } else {
                this.sQb = new ae();
            }
            c bLo = o.bLo();
            Cursor a = bLo.gJP.a("select * from WalletBankcard where cardType & " + Bankcard.sKU + " != 0 ", null, 2);
            if (a == null) {
                bankcard = null;
            } else {
                if (a.moveToFirst()) {
                    bankcard = new Bankcard();
                    bankcard.b(a);
                } else {
                    bankcard = null;
                }
                a.close();
            }
            this.szU = bankcard;
            bLo = o.bLo();
            a = bLo.gJP.a("select * from WalletBankcard where cardType & " + Bankcard.sKX + " != 0 ", null, 2);
            if (a == null) {
                bankcard = null;
            } else {
                if (a.moveToFirst()) {
                    bankcard = new Bankcard();
                    bankcard.b(a);
                } else {
                    bankcard = null;
                }
                a.close();
            }
            this.sQf = bankcard;
            e.a("wallet_balance", new 1(this));
            this.sCs = o.bLo().bLX();
            this.sCt = o.bLo().bMl();
            bLo = o.bLo();
            a = bLo.gJP.a("select * from WalletBankcard where cardType & " + Bankcard.sKV + " != 0 ", null, 2);
            if (a == null) {
                bankcard = null;
            } else {
                if (a.moveToNext()) {
                    bankcard = new Bankcard();
                    bankcard.b(a);
                } else {
                    bankcard = null;
                }
                a.close();
            }
            this.sQa = bankcard;
            Cursor a2 = o.bLs().gJP.a("select * from LoanEntryInfo", null, 2);
            if (a2 != null) {
                if (a2.moveToFirst()) {
                    kVar = new k();
                    kVar.b(a2);
                }
                a2.close();
            }
            this.sQc = kVar;
            x.i("MicroMsg.WalletUserInfoManger", "loadDbData!");
            bMc();
            return;
        }
        x.w("MicroMsg.WalletUserInfoManger", "Account Not Ready!");
    }

    public final boolean bLW() {
        if (r.iep) {
            return true;
        }
        g.Dk();
        int intValue = ((Integer) g.Dj().CU().get(a.xwy, Integer.valueOf(-1))).intValue();
        if (intValue != -1) {
            return intValue == 1;
        } else {
            if (this.sPZ != null) {
                return this.sPZ.field_lqt_state == 1;
            } else {
                return false;
            }
        }
    }

    public final void aJh() {
        if (this.sPZ != null) {
            this.sPZ.field_is_reg = -1;
            this.sPZ = null;
        }
        if (this.sQb != null) {
            this.sQb = null;
        }
        if (this.szU != null) {
            this.szU = null;
        }
        if (this.sCs != null) {
            this.sCs.clear();
            this.sCs = null;
        }
        if (this.sCt != null) {
            this.sCt.clear();
            this.sCt = null;
        }
        this.sQh = 0;
        e.a(new e.c[]{new e.c("wallet_balance_version", Integer.valueOf(-1)), new e.c("wallet_balance_last_update_time", Integer.valueOf(-1)), new e.c("wallet_balance", Integer.valueOf(-1))});
        this.sQg = bh.Wo();
    }

    public final ArrayList<Bankcard> bLX() {
        if (this.sCs == null || this.sCs.size() <= 0) {
            this.sCs = o.bLo().bLX();
        }
        if (this.sCs == null || this.sCs.size() <= 0) {
            return null;
        }
        ArrayList<Bankcard> arrayList = new ArrayList();
        Iterator it = this.sCs.iterator();
        while (it.hasNext()) {
            arrayList.add((Bankcard) it.next());
        }
        return arrayList;
    }

    public final List<c> bLY() {
        if (this.sQe != null) {
            this.sQe.size();
        }
        if (this.sQe == null || this.sQe.size() <= 0) {
            return null;
        }
        return this.sQe;
    }

    public final ArrayList<Bankcard> bLZ() {
        if (this.sCs == null || this.sCs.size() <= 0) {
            return null;
        }
        ArrayList<Bankcard> arrayList = new ArrayList();
        Iterator it = this.sCs.iterator();
        while (it.hasNext()) {
            Bankcard bankcard = (Bankcard) it.next();
            if (!(bankcard.bKR() || bankcard.bKT())) {
                arrayList.add(bankcard);
            }
        }
        return arrayList;
    }

    public final ArrayList<Bankcard> jB(boolean z) {
        ArrayList<Bankcard> arrayList = new ArrayList();
        if (z) {
            if (!(this.szU == null || bLJ())) {
                arrayList.add(this.szU);
            }
            if (!(this.sQf == null || bLJ())) {
                arrayList.add(this.sQf);
            }
        }
        if (this.sCs != null && this.sCs.size() > 0) {
            Iterator it = this.sCs.iterator();
            while (it.hasNext()) {
                arrayList.add((Bankcard) it.next());
            }
        }
        return arrayList;
    }

    public final ArrayList<Bankcard> jJ(boolean z) {
        ArrayList<Bankcard> arrayList = new ArrayList();
        if (z) {
            if (!(this.szU == null || bLJ())) {
                arrayList.add(this.szU);
            }
            if (!(this.sQf == null || bLJ())) {
                arrayList.add(this.sQf);
            }
        }
        Iterator it;
        if (this.sPX != null && this.sCs != null && this.sPX.size() == this.sCs.size() && this.sPX.size() > 0) {
            it = this.sPX.iterator();
            while (it.hasNext()) {
                arrayList.add((Bankcard) it.next());
            }
        } else if (this.sCs != null && this.sCs.size() > 0) {
            it = this.sCs.iterator();
            while (it.hasNext()) {
                arrayList.add((Bankcard) it.next());
            }
        }
        return arrayList;
    }

    public final ArrayList<Bankcard> bMa() {
        ArrayList<Bankcard> arrayList = new ArrayList();
        if (!(this.szU == null || bLJ())) {
            arrayList.add(this.szU);
        }
        if (!(this.sPY == null || this.sCs == null || this.sPY.size() <= 0)) {
            Iterator it = this.sPY.iterator();
            while (it.hasNext()) {
                Bankcard bankcard = (Bankcard) it.next();
                if (!bankcard.bKT()) {
                    arrayList.add(bankcard);
                }
            }
        }
        return arrayList;
    }

    public final void d(ArrayList<Bankcard> arrayList, ArrayList<Bankcard> arrayList2) {
        if (this.sCs == null || arrayList == null || arrayList2 == null) {
            x.e("MicroMsg.WalletUserInfoManger", "error list, bankcards == null || bankcardsClone == null || virtualBankcardsClone == null");
            return;
        }
        Iterator it;
        arrayList.clear();
        arrayList2.clear();
        if (this.sCs != null) {
            it = this.sCs.iterator();
            while (it.hasNext()) {
                arrayList.add((Bankcard) it.next());
            }
        }
        if (this.sCt != null) {
            it = this.sCt.iterator();
            while (it.hasNext()) {
                Bankcard bankcard = (Bankcard) it.next();
                if (bankcard.field_wxcreditState == 0) {
                    arrayList2.add(bankcard);
                } else {
                    arrayList.add(bankcard);
                }
            }
        }
    }

    public static boolean ce(List<Bankcard> list) {
        if (list.size() == 0) {
            return false;
        }
        g.Dk();
        String str = (String) g.Dj().CU().get(196659, null);
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String[] split = str.split("&");
        if (split == null || split.length == 0) {
            return true;
        }
        int i = 0;
        for (Object obj : split) {
            if (!TextUtils.isEmpty(obj)) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    Bankcard bankcard = (Bankcard) list.get(i2);
                    if (bankcard != null && obj.equals(bankcard.field_bankcardType)) {
                        i++;
                        break;
                    }
                }
            }
        }
        if (i < list.size()) {
            return true;
        }
        return false;
    }

    public final boolean MX(String str) {
        if (bh.ov(str)) {
            return false;
        }
        Iterator it;
        Bankcard bankcard;
        if (this.sCs != null) {
            it = this.sCs.iterator();
            while (it.hasNext()) {
                bankcard = (Bankcard) it.next();
                if (str.equals(bankcard.field_bankcardType) && bankcard.bKO()) {
                    return false;
                }
            }
        }
        if (this.sCt != null) {
            it = this.sCt.iterator();
            while (it.hasNext()) {
                bankcard = (Bankcard) it.next();
                if (str.equals(bankcard.field_bankcardType) && bankcard.field_bankcardState == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void a(af afVar, ArrayList<Bankcard> arrayList, ArrayList<Bankcard> arrayList2, Bankcard bankcard, Bankcard bankcard2, k kVar, b bVar, Bankcard bankcard3, int i, int i2, List<c> list) {
        x.i("MicroMsg.WalletUserInfoManger", "setBankcards scene %d", new Object[]{Integer.valueOf(i2)});
        if (i2 == 8) {
            this.sPX = arrayList;
        }
        if (i2 == 24 || i2 == 25) {
            this.sPY = arrayList;
        }
        this.sQe = list;
        this.sPZ = afVar;
        this.sCs = arrayList;
        this.sCt = arrayList2;
        this.szU = bankcard;
        this.sQb = new ae(afVar.field_switchConfig);
        this.sQa = bankcard2;
        this.sQc = kVar;
        this.sQd = bVar;
        this.sQf = bankcard3;
        x.i("MicroMsg.WalletUserInfoManger", "setBankcards()! " + afVar.field_switchConfig);
        bMc();
        if (i < 0) {
            i = 600;
        }
        this.sQg = bh.Wo() + ((long) i);
        this.sQh = bh.Wo() + 600;
        x.i("MicroMsg.WalletUserInfoManger", "hy: cache time: %d, dead time: %d, cacheDeadTime: %s", new Object[]{Integer.valueOf(i), Long.valueOf(this.sQg), Long.valueOf(this.sQh)});
        o.bLo().gJP.fx("WalletBankcard", "delete from WalletBankcard");
        if (!(i2 == 24 || i2 == 25 || arrayList == null)) {
            o.bLo().cg(arrayList);
        }
        if (arrayList2 != null) {
            o.bLo().cg(arrayList2);
        }
        if (bankcard != null) {
            o.bLo().e(bankcard);
        }
        if (bankcard2 != null) {
            o.bLo().e(bankcard2);
        }
        if (bankcard3 != null) {
            o.bLo().e(bankcard3);
        }
        o.bLm().gJP.fx("WalletUserInfo", "delete from WalletUserInfo");
        o.bLm().a(afVar);
        o.bLs().gJP.fx("LoanEntryInfo", "delete from LoanEntryInfo");
        if (kVar != null) {
            o.bLs().b(kVar);
        }
    }

    public static void MY(String str) {
        if (!bh.ov(str)) {
            g.Dk();
            g.Dj().CU().set(196612, str);
        }
    }

    public final Bankcard a(ArrayList<Bankcard> arrayList, String str, boolean z, boolean z2) {
        return a(arrayList, str, z, z2, false);
    }

    public final Bankcard a(ArrayList<Bankcard> arrayList, String str, boolean z, boolean z2, boolean z3) {
        if (arrayList == null) {
            arrayList = this.sCs;
        }
        if (bh.ov(str)) {
            g.Dk();
            str = (String) g.Dj().CU().get(196612, null);
        }
        if (z && this.szU != null) {
            if (bLN()) {
                return this.szU;
            }
            if (str != null && str.equals(this.szU.field_bindSerial)) {
                return this.szU;
            }
            if (this.sQf != null && this.sPZ != null && this.sPZ.field_lqt_state == 1 && str != null && str.equals(this.sQf.field_bindSerial)) {
                return this.sQf;
            }
            if (!bLJ() && (arrayList == null || arrayList.size() == 0)) {
                return this.szU;
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            x.e("MicroMsg.WalletUserInfoManger", "not found bankcard!");
            return null;
        } else if (arrayList.size() == 1 && z2) {
            x.e("MicroMsg.WalletUserInfoManger", "only one bankcard!");
            return (Bankcard) arrayList.get(0);
        } else {
            x.i("MicroMsg.WalletUserInfoManger", "have multiple bankcards!");
            if (!bh.ov(str)) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Bankcard bankcard = (Bankcard) it.next();
                    if (bankcard != null && str.equals(bankcard.field_bindSerial)) {
                        if (!z3 || !bankcard.bKT()) {
                            return bankcard;
                        }
                        x.i("MicroMsg.WalletUserInfoManger", "default card is honeypay");
                        if (z && this.szU != null) {
                            return this.szU;
                        }
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            bankcard = (Bankcard) it2.next();
                            if (!bankcard.bKT()) {
                                return bankcard;
                            }
                        }
                        continue;
                    }
                }
            }
            return z2 ? (Bankcard) arrayList.get(0) : null;
        }
    }

    public final String bMb() {
        if (this.sCs == null || this.sCs.size() <= 0) {
            x.e("MicroMsg.WalletUserInfoManger", "not found bankcard!");
            return null;
        }
        Iterator it = this.sCs.iterator();
        if (it.hasNext()) {
            return ((Bankcard) it.next()).field_bindSerial;
        }
        return null;
    }

    private void bMc() {
        x.i("MicroMsg.WalletUserInfoManger", "recordDataState()");
        if (this.sPZ == null) {
            x.i("MicroMsg.WalletUserInfoManger", "userInfo == null");
        }
        if (this.sCs == null) {
            x.i("MicroMsg.WalletUserInfoManger", "bankcards == null");
        } else if (this.sCs.size() == 0) {
            x.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == 0");
        } else {
            x.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == " + this.sCs.size());
        }
        if (this.sCt == null) {
            x.i("MicroMsg.WalletUserInfoManger", "virtualBankcards == null");
        } else if (this.sCt.size() == 0) {
            x.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == 0");
        } else {
            x.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == " + this.sCt.size());
        }
        if (this.szU == null) {
            x.i("MicroMsg.WalletUserInfoManger", "balance == null");
        } else {
            x.i("MicroMsg.WalletUserInfoManger", "balance != null");
        }
        if (this.sQa == null) {
            x.i("MicroMsg.WalletUserInfoManger", "historyBankcard == null");
        } else {
            x.i("MicroMsg.WalletUserInfoManger", "historyBankcard != null");
        }
        if (this.sQc == null) {
            x.i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo == null");
        } else {
            x.i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo != null");
        }
    }
}
