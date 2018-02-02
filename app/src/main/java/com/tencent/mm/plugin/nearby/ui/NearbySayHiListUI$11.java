package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bf.h;
import com.tencent.mm.bk.a;
import com.tencent.mm.g.a.j;
import com.tencent.mm.g.b.af;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class NearbySayHiListUI$11 implements OnItemClickListener {
    final /* synthetic */ NearbySayHiListUI oPo;

    NearbySayHiListUI$11(NearbySayHiListUI nearbySayHiListUI) {
        this.oPo = nearbySayHiListUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (NearbySayHiListUI.d(this.oPo).getHeaderViewsCount() > 0) {
            i -= NearbySayHiListUI.d(this.oPo).getHeaderViewsCount();
        }
        h hVar = (h) NearbySayHiListUI.b(this.oPo).getItem(i);
        if (hVar != null && hVar.field_content != null) {
            d Xu = d.Xu(hVar.field_content);
            Intent intent = new Intent();
            if (a.bXU()) {
                intent.putExtra("Chat_User", hVar.field_sayhiencryptuser);
                intent.putExtra("lbs_mode", true);
                intent.putExtra("add_scene", 18);
                com.tencent.mm.plugin.nearby.a.ifs.e(intent, this.oPo);
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("Contact_User", bh.ov(Xu.rYX) ? hVar.field_sayhiuser : Xu.rYX);
                intent2.putExtra("Contact_Alias", Xu.gfN);
                intent2.putExtra("Contact_Nick", Xu.fpL);
                intent2.putExtra("Contact_QuanPin", Xu.hwV);
                intent2.putExtra("Contact_PyInitial", Xu.hwU);
                intent2.putExtra("Contact_Sex", Xu.fWf);
                intent2.putExtra("Contact_Signature", Xu.signature);
                intent2.putExtra("Contact_Scene", Xu.scene);
                intent2.putExtra("Contact_FMessageCard", true);
                intent2.putExtra("Contact_City", Xu.getCity());
                intent2.putExtra("Contact_Province", Xu.getProvince());
                intent2.putExtra("Contact_Content", bh.ov(hVar.field_sayhicontent) ? this.oPo.getString(R.l.dRf) : hVar.field_sayhicontent);
                intent2.putExtra("Contact_verify_Scene", Xu.scene);
                intent2.putExtra("Contact_Uin", Xu.pjS);
                intent2.putExtra("Contact_QQNick", Xu.hwW);
                intent2.putExtra("Contact_Mobile_MD5", Xu.xzj);
                intent2.putExtra("User_From_Fmessage", true);
                intent2.putExtra("Contact_from_msgType", 37);
                intent2.putExtra("Verify_ticket", Xu.mOi);
                intent2.putExtra("Contact_Source_FMessage", Xu.scene);
                intent2.putExtra("Contact_ShowFMessageList", true);
                ar.Hg();
                af WO = c.EY().WO(Xu.rYX);
                if (!(WO == null || ((int) WO.gJd) < 0 || com.tencent.mm.l.a.fZ(WO.field_type))) {
                    int i2 = Xu.fuL;
                    if (i2 == 0 || i2 == 2 || i2 == 5) {
                        intent2.putExtra("User_Verify", true);
                    }
                    intent2.putExtra("Contact_IsLBSFriend", true);
                    intent2.putExtra("Sns_from_Scene", 18);
                }
                com.tencent.mm.plugin.nearby.a.ifs.d(intent2, this.oPo);
            }
            b jVar = new j();
            jVar.fna.scene = Xu.scene;
            com.tencent.mm.sdk.b.a.xef.m(jVar);
        }
    }
}
