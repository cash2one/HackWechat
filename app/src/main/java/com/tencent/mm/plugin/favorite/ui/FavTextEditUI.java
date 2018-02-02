package com.tencent.mm.plugin.favorite.ui;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.r;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aru;
import com.tencent.mm.protocal.c.arx;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.MMTextInputUI;
import com.tencent.mm.z.ar;
import java.util.LinkedList;

public class FavTextEditUI extends MMTextInputUI {
    protected final int getLayoutId() {
        return R.i.dht;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.eeZ);
    }

    protected final void y(CharSequence charSequence) {
        if (charSequence == null || bh.ov(charSequence.toString())) {
            x.w("MicroMsg.FavTextEditUI", "text is null");
            return;
        }
        int intExtra = getIntent().getIntExtra("key_fav_item_id", -1);
        String charSequence2 = charSequence.toString();
        if (intExtra <= 0) {
            x.w("MicroMsg.Fav.ModFavItemLogic", "modEditText favid:%d", new Object[]{Integer.valueOf(intExtra)});
            return;
        }
        LinkedList linkedList = new LinkedList();
        aru com_tencent_mm_protocal_c_aru = new aru();
        com_tencent_mm_protocal_c_aru.wzz = 4;
        com_tencent_mm_protocal_c_aru.wzA = 0;
        linkedList.add(com_tencent_mm_protocal_c_aru);
        LinkedList linkedList2 = new LinkedList();
        arx com_tencent_mm_protocal_c_arx = new arx();
        com_tencent_mm_protocal_c_arx.niX = "favitem.desc";
        com_tencent_mm_protocal_c_arx.pQt = bh.az(charSequence2, "");
        linkedList2.add(com_tencent_mm_protocal_c_arx);
        com_tencent_mm_protocal_c_arx = new arx();
        com_tencent_mm_protocal_c_arx.niX = "favitem.edittime";
        com_tencent_mm_protocal_c_arx.pQt = String.valueOf(bh.Wo());
        linkedList2.add(com_tencent_mm_protocal_c_arx);
        f dc = h.getFavItemInfoStorage().dc((long) intExtra);
        if (dc != null) {
            dc.field_edittime = bh.Wo();
            dc.field_favProto.fB(dc.field_edittime);
            dc.field_favProto.Uh(bh.az(charSequence2, ""));
            h.getFavItemInfoStorage().a(dc, new String[]{"localId"});
        }
        ar.CG().a(new r(intExtra, linkedList, linkedList2), 0);
        g.pQN.h(10874, new Object[]{Integer.valueOf(1)});
    }
}
