package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.R;
import com.tencent.mm.g.b.af;
import com.tencent.mm.protocal.c.bfd;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.base.sortview.a;
import com.tencent.mm.ui.base.sortview.a.b;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class b$1 extends b {
    final /* synthetic */ b kFh;

    b$1(b bVar) {
        this.kFh = bVar;
    }

    public final boolean a(Context context, a aVar, Object... objArr) {
        if (!(aVar instanceof b)) {
            return false;
        }
        String str;
        String str2;
        b bVar = (b) aVar;
        bfd com_tencent_mm_protocal_c_bfd = (bfd) aVar.data;
        if (com_tencent_mm_protocal_c_bfd.wsB != null) {
            str = com_tencent_mm_protocal_c_bfd.wsB.wJF;
        } else {
            str = null;
        }
        if (com_tencent_mm_protocal_c_bfd.vYI != null) {
            str2 = com_tencent_mm_protocal_c_bfd.vYI.wJF;
        } else {
            str2 = null;
        }
        if (bh.ov(str2)) {
            x.e("MicroMsg.BizRecommDataItem", "onItemClick but username is null");
            return false;
        }
        c cVar;
        ar.Hg();
        af WO = c.EY().WO(str2);
        Intent intent = new Intent();
        if (com.tencent.mm.l.a.fZ(WO.field_type)) {
            intent.putExtra("Contact_User", str2);
            intent.putExtra("Contact_Scene", 55);
        } else {
            intent.putExtra("Contact_User", str2);
            intent.putExtra("Contact_Alias", com_tencent_mm_protocal_c_bfd.hvy);
            intent.putExtra("Contact_Nick", str);
            intent.putExtra("Contact_Signature", com_tencent_mm_protocal_c_bfd.hvw);
            intent.putExtra("Contact_RegionCode", RegionCodeDecoder.ah(com_tencent_mm_protocal_c_bfd.hvC, com_tencent_mm_protocal_c_bfd.hvu, com_tencent_mm_protocal_c_bfd.hvv));
            intent.putExtra("Contact_Sex", com_tencent_mm_protocal_c_bfd.hvt);
            intent.putExtra("Contact_VUser_Info", com_tencent_mm_protocal_c_bfd.wvg);
            intent.putExtra("Contact_VUser_Info_Flag", com_tencent_mm_protocal_c_bfd.wvf);
            intent.putExtra("Contact_KWeibo_flag", com_tencent_mm_protocal_c_bfd.wvj);
            intent.putExtra("Contact_KWeibo", com_tencent_mm_protocal_c_bfd.wvh);
            intent.putExtra("Contact_KWeiboNick", com_tencent_mm_protocal_c_bfd.wvi);
            intent.putExtra("Contact_Scene", 55);
            if (com_tencent_mm_protocal_c_bfd.wvm != null) {
                try {
                    intent.putExtra("Contact_customInfo", com_tencent_mm_protocal_c_bfd.wvm.toByteArray());
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.BizRecommDataItem", e, "", new Object[0]);
                }
            }
        }
        com.tencent.mm.plugin.brandservice.a.ifs.d(intent, context);
        if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof c)) {
            cVar = null;
        } else {
            cVar = (c) objArr[0];
        }
        c.b asC = bVar.asC();
        if (asC == null || cVar == null) {
            return true;
        }
        asC.a(cVar, aVar, 1, str2, bVar.asD(), bVar.getPosition());
        return true;
    }

    public final View b(Context context, View view) {
        if (view == null) {
            return View.inflate(context, R.i.drs, null);
        }
        return view;
    }

    public final void a(Context context, a.a aVar, a aVar2) {
        int i = 0;
        if (context == null || aVar == null || aVar2 == null || aVar2.data == null) {
            x.e("MicroMsg.BizRecommDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
        } else if (!(aVar instanceof b.a)) {
            x.e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of BizRecommViewHolder.");
        } else if (aVar2.data instanceof bfd) {
            int i2;
            b.a aVar3 = (b.a) aVar;
            b bVar = (b) aVar2;
            aVar3.username = bVar.username;
            aVar3.iconUrl = bVar.iconUrl;
            com.tencent.mm.plugin.brandservice.ui.base.b.a.a(aVar3.iip, bVar.username, bVar.iconUrl);
            aVar3.kBH.setText(bVar.iil, BufferType.SPANNABLE);
            View view = aVar3.kFe;
            if (bVar.kEX) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view.setVisibility(i2);
            View view2 = aVar3.kFa;
            if (!bVar.kEW) {
                i = 8;
            }
            view2.setVisibility(i);
            aVar3.kFb.setText(bVar.kET, BufferType.SPANNABLE);
            com.tencent.mm.plugin.brandservice.a.a.b(aVar3.kEY, bVar.kFg);
        } else {
            x.e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of SearchOrRecommendItem.");
        }
    }

    public final void a(View view, a.a aVar) {
        if (view != null && aVar != null && (aVar instanceof b.a)) {
            b.a aVar2 = (b.a) aVar;
            aVar2.iip = (ImageView) view.findViewById(R.h.bLD);
            aVar2.kBH = (TextView) view.findViewById(R.h.cAm);
            aVar2.kEY = (TextView) view.findViewById(R.h.bYz);
            aVar2.kFe = view.findViewById(R.h.bNN);
            aVar2.kFa = view.findViewById(R.h.cUy);
            aVar2.kFb = (TextView) view.findViewById(R.h.cpS);
        }
    }
}
