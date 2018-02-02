package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.f;
import com.tencent.mm.ui.contact.AddressUI.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;

class AddressUI$a$20 implements OnItemClickListener {
    final /* synthetic */ a yQF;

    AddressUI$a$20(a aVar) {
        this.yQF = aVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.i("MicroMsg.AddressUI", "onItemClick " + i + (a.e(this.yQF) == null ? a.e(this.yQF) : Boolean.valueOf(a.e(this.yQF).zqC)));
        if ((i != 0 || "@biz.contact".equals(a.f(this.yQF))) && i >= a.c(this.yQF).getHeaderViewsCount()) {
            int headerViewsCount = i - a.c(this.yQF).getHeaderViewsCount();
            String str;
            if (a.e(this.yQF) == null || !a.e(this.yQF).zqC) {
                f fVar = (f) a.a(this.yQF).DC(headerViewsCount);
                if (fVar != null) {
                    str = fVar.field_username;
                    a aVar = this.yQF;
                    if (str != null && str.length() > 0) {
                        if (s.hd(str)) {
                            x.e("MicroMsg.AddressUI", "error, 4.5 do not contain this contact %s", new Object[]{str});
                            return;
                        }
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", str);
                        if (s.gC(str)) {
                            intent.putExtra("Is_group_card", true);
                        }
                        if (str != null && str.length() > 0) {
                            e.a(intent, str);
                            d.b(aVar.getContext(), "profile", ".ui.ContactInfoUI", intent);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            boolean qY = a.e(this.yQF).qY(headerViewsCount);
            boolean GQ = a.e(this.yQF).GQ(headerViewsCount);
            x.i("MicroMsg.AddressUI", "onItemClick " + GQ);
            if (GQ) {
                a.e(this.yQF).aag("");
            } else if (qY) {
                bek GP = a.e(this.yQF).GP(headerViewsCount);
                String str2 = GP.vYI.wJF;
                ar.Hg();
                af WO = c.EY().WO(str2);
                if (com.tencent.mm.l.a.fZ(WO.field_type)) {
                    r1 = new Intent();
                    r1.putExtra("Contact_User", str2);
                    r1.putExtra("Contact_Scene", 3);
                    if (str2 != null && str2.length() > 0) {
                        if (WO.cia()) {
                            g.pQN.k(10298, str2 + ",3");
                        }
                        e.a(r1, str2);
                        d.b(this.yQF.getContext(), "profile", ".ui.ContactInfoUI", r1);
                        return;
                    }
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("Contact_User", GP.vYI.wJF);
                intent2.putExtra("Contact_Alias", GP.hvy);
                intent2.putExtra("Contact_Nick", GP.wsB.wJF);
                intent2.putExtra("Contact_Signature", GP.hvw);
                intent2.putExtra("Contact_RegionCode", RegionCodeDecoder.ah(GP.hvC, GP.hvu, GP.hvv));
                intent2.putExtra("Contact_Sex", GP.hvt);
                intent2.putExtra("Contact_VUser_Info", GP.wvg);
                intent2.putExtra("Contact_VUser_Info_Flag", GP.wvf);
                intent2.putExtra("Contact_KWeibo_flag", GP.wvj);
                intent2.putExtra("Contact_KWeibo", GP.wvh);
                intent2.putExtra("Contact_KWeiboNick", GP.wvi);
                intent2.putExtra("Contact_KSnsIFlag", GP.wvl.hvE);
                intent2.putExtra("Contact_KSnsBgId", GP.wvl.hvG);
                intent2.putExtra("Contact_KSnsBgUrl", GP.wvl.hvF);
                if (GP.wvm != null) {
                    try {
                        intent2.putExtra("Contact_customInfo", GP.wvm.toByteArray());
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.AddressUI", e, "", new Object[0]);
                    }
                }
                if ((GP.wvf & 8) > 0) {
                    g.pQN.k(10298, str2 + ",3");
                }
                d.b(this.yQF.getContext(), "profile", ".ui.ContactInfoUI", intent2);
            } else {
                af oh = a.e(this.yQF).oh(headerViewsCount);
                if (oh == null) {
                    x.e("MicroMsg.AddressUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[]{Integer.valueOf(a.e(this.yQF).getCount()), Integer.valueOf(headerViewsCount)});
                    return;
                }
                str = oh.field_username;
                if (s.hd(str)) {
                    Intent intent3 = new Intent(this.yQF.getContext(), AddressUI.class);
                    intent3.putExtra("Contact_GroupFilter_Type", "@biz.contact");
                    this.yQF.startActivity(intent3);
                    return;
                }
                r1 = new Intent();
                r1.putExtra("Contact_User", str);
                r1.putExtra("Contact_Scene", 3);
                if (str != null && str.length() > 0) {
                    d.b(this.yQF.getContext(), "profile", ".ui.ContactInfoUI", r1);
                }
            }
        }
    }
}
