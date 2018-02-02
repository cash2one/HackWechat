package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bc.d;
import com.tencent.mm.g.b.af;
import com.tencent.mm.protocal.c.bfe;
import com.tencent.mm.protocal.c.jj;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.base.sortview.a;
import com.tencent.mm.ui.base.sortview.a.b;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class a$b extends b {
    public final boolean a(Context context, a aVar, Object... objArr) {
        if (!(aVar instanceof a)) {
            return false;
        }
        a aVar2 = (a) aVar;
        if (aVar.data instanceof jj) {
            jj jjVar = (jj) aVar.data;
            if (jjVar.vPF == null || jjVar.vPF.vPn == null) {
                x.e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
                return false;
            }
            String str;
            int i;
            int i2 = 0;
            c cVar = null;
            String str2 = "";
            if (objArr != null) {
                c cVar2;
                if (objArr.length <= 0 || !(objArr[0] instanceof c)) {
                    cVar2 = null;
                } else {
                    cVar2 = (c) objArr[0];
                }
                if (objArr.length > 2 && (objArr[2] instanceof Integer)) {
                    i2 = ((Integer) objArr[2]).intValue();
                }
                if (objArr.length <= 3 || !(objArr[3] instanceof String)) {
                    cVar = cVar2;
                    str = str2;
                    i = i2;
                } else {
                    i = i2;
                    c cVar3 = cVar2;
                    str = (String) objArr[3];
                    cVar = cVar3;
                }
            } else {
                str = str2;
                i = 0;
            }
            String str3 = jjVar.vPF.nfg;
            bfe com_tencent_mm_protocal_c_bfe = jjVar.vPF.vPn;
            String str4 = com_tencent_mm_protocal_c_bfe.wsB != null ? com_tencent_mm_protocal_c_bfe.wsB.wJF : null;
            String str5 = com_tencent_mm_protocal_c_bfe.vYI != null ? com_tencent_mm_protocal_c_bfe.vYI.wJF : null;
            if (bh.ov(str5)) {
                x.e("MicroMsg.BizContactDataItem", "onItemClick but username is null");
                return false;
            }
            int i3;
            d.lT(str5);
            if (bh.ov(str3)) {
                ar.Hg();
                af WO = c.EY().WO(str5);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("Contact_Ext_Args_Search_Id", str);
                bundle.putInt("Contact_Ext_Args_Index", aVar2.asD());
                bundle.putString("Contact_Ext_Args_Query_String", "");
                bundle.putInt("Contact_Scene", i);
                intent.putExtra("Contact_Ext_Args", bundle);
                intent.putExtra("Contact_User", str5);
                intent.putExtra("Contact_Scene", i);
                if (!com.tencent.mm.l.a.fZ(WO.field_type)) {
                    intent.putExtra("Contact_Alias", com_tencent_mm_protocal_c_bfe.hvy);
                    intent.putExtra("Contact_Nick", str4);
                    intent.putExtra("Contact_Signature", com_tencent_mm_protocal_c_bfe.hvw);
                    intent.putExtra("Contact_RegionCode", RegionCodeDecoder.ah(com_tencent_mm_protocal_c_bfe.hvC, com_tencent_mm_protocal_c_bfe.hvu, com_tencent_mm_protocal_c_bfe.hvv));
                    intent.putExtra("Contact_Sex", com_tencent_mm_protocal_c_bfe.hvt);
                    intent.putExtra("Contact_VUser_Info", com_tencent_mm_protocal_c_bfe.wvg);
                    intent.putExtra("Contact_VUser_Info_Flag", com_tencent_mm_protocal_c_bfe.wvf);
                    intent.putExtra("Contact_KWeibo_flag", com_tencent_mm_protocal_c_bfe.wvj);
                    intent.putExtra("Contact_KWeibo", com_tencent_mm_protocal_c_bfe.wvh);
                    intent.putExtra("Contact_KWeiboNick", com_tencent_mm_protocal_c_bfe.wvi);
                    if (com_tencent_mm_protocal_c_bfe.wKn != null) {
                        try {
                            intent.putExtra("Contact_customInfo", com_tencent_mm_protocal_c_bfe.wKn.toByteArray());
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.BizContactDataItem", e, "", new Object[0]);
                        }
                    }
                }
                com.tencent.mm.plugin.brandservice.a.ifs.d(intent, context);
                i3 = 1;
            } else {
                i3 = 8;
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", str3);
                intent2.putExtra("useJs", true);
                intent2.putExtra("vertical_scroll", true);
                com.tencent.mm.bm.d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
            }
            c$b asC = aVar2.asC();
            if (!(asC == null || cVar == null)) {
                asC.a(cVar, aVar, i3, str5, aVar2.asD(), aVar2.getPosition());
            }
            return true;
        }
        x.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BusinessResultItem.");
        return false;
    }

    public final View b(Context context, View view) {
        if (view == null) {
            return View.inflate(context, R.i.drs, null);
        }
        return view;
    }

    public final void a(Context context, a.a aVar, a aVar2) {
        int i = 8;
        if (context == null || aVar == null || aVar2 == null || aVar2.data == null) {
            x.e("MicroMsg.BizContactDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
        } else if (!(aVar instanceof a$a)) {
            x.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BizContactViewHolder.");
        } else if (aVar2 instanceof a) {
            a$a com_tencent_mm_plugin_brandservice_ui_a_a = (a$a) aVar;
            a aVar3 = (a) aVar2;
            com_tencent_mm_plugin_brandservice_ui_a_a.username = aVar3.username;
            com_tencent_mm_plugin_brandservice_ui_a_a.iconUrl = aVar3.iconUrl;
            com.tencent.mm.plugin.brandservice.ui.base.b.a.a(com_tencent_mm_plugin_brandservice_ui_a_a.iip, aVar3.username, aVar3.iconUrl);
            com_tencent_mm_plugin_brandservice_ui_a_a.kFa.setVisibility(aVar3.kEW ? 0 : 8);
            View view = com_tencent_mm_plugin_brandservice_ui_a_a.kFe;
            if (aVar3.kEX) {
                i = 0;
            }
            view.setVisibility(i);
            com.tencent.mm.plugin.brandservice.a.a.b(com_tencent_mm_plugin_brandservice_ui_a_a.kEZ, aVar3.nickName);
            boolean b = com.tencent.mm.plugin.brandservice.a.a.b(com_tencent_mm_plugin_brandservice_ui_a_a.kFd, aVar3.kEV);
            boolean b2 = com.tencent.mm.plugin.brandservice.a.a.b(com_tencent_mm_plugin_brandservice_ui_a_a.kFc, aVar3.kEU);
            if (com.tencent.mm.plugin.brandservice.a.a.b(com_tencent_mm_plugin_brandservice_ui_a_a.kFb, aVar3.kET)) {
                if (b || b2) {
                    com_tencent_mm_plugin_brandservice_ui_a_a.kFb.setMaxLines(1);
                } else {
                    com_tencent_mm_plugin_brandservice_ui_a_a.kFb.setMaxLines(2);
                }
            }
            x.d("MicroMsg.BizContactDataItem", "fillingView , nickName : %s, followFriends : %s.", new Object[]{aVar3.nickName, aVar3.kEU});
        } else {
            x.e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
        }
    }

    public final void a(View view, a.a aVar) {
        if (view != null && aVar != null && (aVar instanceof a$a)) {
            a$a com_tencent_mm_plugin_brandservice_ui_a_a = (a$a) aVar;
            com_tencent_mm_plugin_brandservice_ui_a_a.kEY = (TextView) view.findViewById(R.h.bYz);
            com_tencent_mm_plugin_brandservice_ui_a_a.kFe = view.findViewById(R.h.bNN);
            com_tencent_mm_plugin_brandservice_ui_a_a.iip = (ImageView) view.findViewById(R.h.bLD);
            com_tencent_mm_plugin_brandservice_ui_a_a.kEZ = (TextView) view.findViewById(R.h.cAm);
            com_tencent_mm_plugin_brandservice_ui_a_a.kFa = view.findViewById(R.h.cUy);
            com_tencent_mm_plugin_brandservice_ui_a_a.kFc = (TextView) view.findViewById(R.h.ciT);
            com_tencent_mm_plugin_brandservice_ui_a_a.kFb = (TextView) view.findViewById(R.h.cpS);
            com_tencent_mm_plugin_brandservice_ui_a_a.kFd = (TextView) view.findViewById(R.h.cZR);
        }
    }
}
