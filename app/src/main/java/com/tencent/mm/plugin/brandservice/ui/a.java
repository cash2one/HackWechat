package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.ag.d.b.d;
import com.tencent.mm.protocal.c.bfe;
import com.tencent.mm.protocal.c.jf;
import com.tencent.mm.protocal.c.jj;
import com.tencent.mm.protocal.c.pr;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.a.b;
import java.util.List;

public final class a extends com.tencent.mm.plugin.brandservice.ui.base.a {
    private static b kES;
    protected String iconUrl;
    protected CharSequence kET;
    protected CharSequence kEU;
    protected CharSequence kEV;
    protected boolean kEW;
    protected boolean kEX;
    protected CharSequence nickName;
    protected String username;

    public a(Object obj) {
        super(5, obj);
    }

    public final b asm() {
        if (kES == null) {
            kES = new b();
        }
        return kES;
    }

    public final com.tencent.mm.ui.base.sortview.a.a asn() {
        return new a();
    }

    public final void a(Context context, com.tencent.mm.ui.base.sortview.a.a aVar, Object... objArr) {
        d dVar = null;
        if (!this.yjT) {
            if (context == null || aVar == null || this.data == null) {
                x.e("MicroMsg.BizContactDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
            } else if (!(aVar instanceof a)) {
                x.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BizContactViewHolder.");
            } else if (this.data instanceof jj) {
                a aVar2 = (a) aVar;
                jj jjVar = (jj) this.data;
                if (jjVar.vPF == null || jjVar.vPF.vPn == null) {
                    x.e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
                    return;
                }
                com.tencent.mm.ag.d dVar2;
                bfe com_tencent_mm_protocal_c_bfe = jjVar.vPF.vPn;
                jf jfVar = jjVar.vPF.vPk;
                if (objArr != null && objArr.length > 1 && (objArr[1] instanceof List)) {
                    this.kHa = (List) objArr[1];
                }
                this.username = com_tencent_mm_protocal_c_bfe.vYI.wJF;
                this.iconUrl = com_tencent_mm_protocal_c_bfe.vUV;
                this.kEU = jfVar == null ? "" : jfVar.vPt;
                String str = com_tencent_mm_protocal_c_bfe.wsB == null ? null : com_tencent_mm_protocal_c_bfe.wsB.wJF;
                try {
                    List list = this.kHa;
                    aVar2.kEZ.getTextSize();
                    this.nickName = com.tencent.mm.plugin.brandservice.a.a.b(context, str, list);
                } catch (Exception e) {
                    this.nickName = "";
                }
                String str2 = com_tencent_mm_protocal_c_bfe.vYI.wJF;
                pr prVar = com_tencent_mm_protocal_c_bfe.wKn;
                if (prVar != null) {
                    dVar2 = new com.tencent.mm.ag.d();
                    dVar2.field_username = str2;
                    com.tencent.mm.plugin.brandservice.a.a.a(dVar2, prVar);
                } else {
                    dVar2 = null;
                }
                if (!(dVar2 == null || dVar2.bI(false) == null)) {
                    dVar = dVar2.bI(false).Lz();
                }
                if (dVar != null) {
                    boolean z;
                    if (!dVar2.bI(false).LB() || bh.ov(dVar.hpl)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    this.kEX = z;
                    this.kEW = com_tencent_mm_protocal_c_bfe.wvf != 0;
                }
                x.v("MicroMsg.BizContactDataItem", "verifyFlag : %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bfe.wvf)});
                String str3 = com_tencent_mm_protocal_c_bfe.hvy;
                if (this.kHa.size() > 0 && str3 != null && str3.toLowerCase().equals(((String) this.kHa.get(0)).toLowerCase())) {
                    try {
                        List list2 = this.kHa;
                        aVar2.kFd.getTextSize();
                        this.kEV = com.tencent.mm.plugin.brandservice.a.a.b(context, str3, list2);
                        this.kEV = TextUtils.concat(new CharSequence[]{context.getResources().getString(R.l.eIM), this.kEV});
                    } catch (Exception e2) {
                        this.kEV = "";
                    }
                }
                if (this.kEV == null || this.kEV.length() == 0 || this.kEU == null || this.kEU.length() == 0) {
                    try {
                        str = com_tencent_mm_protocal_c_bfe.hvw;
                        List list3 = this.kHa;
                        aVar2.kFb.getTextSize();
                        this.kET = com.tencent.mm.plugin.brandservice.a.a.b(context, str, list3);
                    } catch (Exception e3) {
                        this.kET = "";
                    }
                }
                x.d("MicroMsg.BizContactDataItem", "nickName : %s, followFriends : %s.", new Object[]{this.nickName, this.kEU});
                this.yjT = true;
            } else {
                x.e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
            }
        }
    }
}
