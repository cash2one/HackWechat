package com.tencent.mm.plugin.card.a;

import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.c.kj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.List;

public final class f {
    public int kFm = 3;
    public b kIK;
    public List<com.tencent.mm.plugin.card.model.b> kIO = new ArrayList();
    public com.tencent.mm.plugin.card.model.b kIP;
    public ArrayList<kj> kIQ;
    public MMActivity kaY;

    public f(MMActivity mMActivity) {
        this.kaY = mMActivity;
    }

    public final com.tencent.mm.plugin.card.model.b aua() {
        boolean z;
        com.tencent.mm.plugin.card.model.b bVar = new com.tencent.mm.plugin.card.model.b();
        bVar.kKa = 1;
        if (l.nY(this.kFm) || l.nZ(this.kFm) || this.kFm == 23) {
            if (!(!this.kIK.isAcceptable() || this.kIK.atB().vSc == null || TextUtils.isEmpty(this.kIK.atB().vSc.text) || TextUtils.isEmpty(this.kIK.atB().vRF))) {
                z = true;
            }
            z = false;
        } else {
            if (!(this.kFm != 6 || !this.kIK.aty() || this.kIK.atB().vSc == null || TextUtils.isEmpty(this.kIK.atB().vSc.text) || TextUtils.isEmpty(this.kIK.atB().vRF))) {
                z = true;
            }
            z = false;
        }
        bVar.kKc = z;
        if (!bVar.kKc && !TextUtils.isEmpty(this.kIK.atB().vRV)) {
            bVar.title = this.kIK.atB().vRV;
        } else if (s.gE(this.kIK.atB().vRF)) {
            bVar.title = getString(R.l.dOK);
            bVar.kKc = false;
        } else {
            bVar.title = getString(R.l.dOJ);
            if (this.kIK.atB().vSc == null || this.kIK.atB().vSc.wgA != 1) {
                bVar.kKd = false;
            } else {
                bVar.kKd = true;
            }
        }
        if (!TextUtils.isEmpty(this.kIK.atB().vRX)) {
            bVar.kJQ = this.kIK.atB().vRX;
        }
        bVar.kNs = "";
        bVar.url = "card://jump_service";
        this.kIP = bVar;
        return this.kIP;
    }

    public final String getTitle() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(this.kIK.atB().kKZ)) {
            stringBuilder.append(this.kIK.atB().kKZ);
        } else if (this.kIK.ati()) {
            stringBuilder.append(getString(R.l.dcq));
        } else if (this.kIK.atj()) {
            stringBuilder.append(getString(R.l.dbT));
        } else if (this.kIK.atk()) {
            stringBuilder.append(getString(R.l.dNJ));
        } else if (this.kIK.atl()) {
            stringBuilder.append(getString(R.l.dOc));
        } else if (this.kIK.atm()) {
            stringBuilder.append(getString(R.l.dci));
        }
        return stringBuilder.toString();
    }

    public final String getString(int i) {
        return this.kaY.getString(i);
    }
}
