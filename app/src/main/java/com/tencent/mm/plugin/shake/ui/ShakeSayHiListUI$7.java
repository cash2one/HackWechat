package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bf.j;
import com.tencent.mm.g.b.af;
import com.tencent.mm.l.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class ShakeSayHiListUI$7 implements OnItemClickListener {
    final /* synthetic */ ShakeSayHiListUI qsr;

    ShakeSayHiListUI$7(ShakeSayHiListUI shakeSayHiListUI) {
        this.qsr = shakeSayHiListUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        j jVar = (j) ShakeSayHiListUI.b(this.qsr).getItem(i);
        if (jVar != null && jVar.field_content != null) {
            d Xu = d.Xu(jVar.field_content);
            Intent intent = new Intent();
            intent.putExtra("Contact_User", Xu.rYX);
            intent.putExtra("Contact_Encryptusername", Xu.xzu);
            intent.putExtra("Contact_Alias", Xu.gfN);
            intent.putExtra("Contact_Nick", Xu.fpL);
            intent.putExtra("Contact_QuanPin", Xu.hwV);
            intent.putExtra("Contact_PyInitial", Xu.hwU);
            intent.putExtra("Contact_Sex", Xu.fWf);
            intent.putExtra("Contact_Signature", Xu.signature);
            intent.putExtra("Contact_Scene", Xu.scene);
            intent.putExtra("Contact_FMessageCard", true);
            intent.putExtra("Contact_City", Xu.getCity());
            intent.putExtra("Contact_Province", Xu.getProvince());
            intent.putExtra("Contact_Content", bh.ov(jVar.field_sayhicontent) ? this.qsr.getString(R.l.dRf) : jVar.field_sayhicontent);
            intent.putExtra("Contact_verify_Scene", Xu.scene);
            intent.putExtra("Contact_Uin", Xu.pjS);
            intent.putExtra("Contact_QQNick", Xu.hwW);
            intent.putExtra("Contact_Mobile_MD5", Xu.xzj);
            intent.putExtra("User_From_Fmessage", true);
            intent.putExtra("Contact_from_msgType", 37);
            intent.putExtra("Verify_ticket", Xu.mOi);
            intent.putExtra("Contact_ShowFMessageList", true);
            intent.putExtra("Contact_Source_FMessage", Xu.scene);
            ar.Hg();
            af WO = c.EY().WO(Xu.rYX);
            if (!(WO == null || ((int) WO.gJd) < 0 || a.fZ(WO.field_type))) {
                int i2 = Xu.fuL;
                if (i2 == 0 || i2 == 2 || i2 == 5) {
                    intent.putExtra("User_Verify", true);
                }
                intent.putExtra("Contact_IsLBSFriend", true);
                intent.putExtra("Sns_from_Scene", 18);
            }
            com.tencent.mm.plugin.shake.a.ifs.d(intent, this.qsr);
        }
    }
}
