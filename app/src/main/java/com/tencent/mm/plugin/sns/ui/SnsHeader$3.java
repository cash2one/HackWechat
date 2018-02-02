package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.plugin.appbrand.jsapi.share.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.aqs;
import com.tencent.mm.sdk.platformtools.x;

class SnsHeader$3 implements OnClickListener {
    final /* synthetic */ int hvX;
    final /* synthetic */ SnsHeader rBL;
    final /* synthetic */ int rBO;

    SnsHeader$3(SnsHeader snsHeader, int i, int i2) {
        this.rBL = snsHeader;
        this.rBO = i;
        this.hvX = i2;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof String) {
            String str = (String) view.getTag();
            x.i("MicroMsg.SnsHeader", "sns Header localId " + str);
            m Lm = ae.bvv().Lm(str);
            if (SnsHeader.h(this.rBL) != null && Lm != null) {
                Intent intent = new Intent();
                intent.setClass(SnsHeader.h(this.rBL), SnsCommentDetailUI.class);
                if (Lm == null || Lm.field_userName == null || Lm.field_userName.equals("")) {
                    x.i("MicroMsg.SnsHeader", "error cntinfo or username is null");
                    return;
                }
                intent.putExtra("INTENT_TALKER", Lm.field_userName);
                intent.putExtra("INTENT_SNS_LOCAL_ID", str);
                intent.putExtra("INTENT_FROMGALLERY", true);
                b iu = b.iu(726);
                iu.ix(this.rBO).ix(this.hvX).ix(Lm.field_createTime);
                iu.Sx();
                SnsHeader.h(this.rBL).startActivity(intent);
                try {
                    aqs com_tencent_mm_protocal_c_aqs = (aqs) new aqs().aF(Lm.field_postBuf);
                    if (com_tencent_mm_protocal_c_aqs.wyj == 201 || com_tencent_mm_protocal_c_aqs.wyj == i.CTRL_INDEX || com_tencent_mm_protocal_c_aqs.wyj != h.CTRL_INDEX) {
                        com_tencent_mm_protocal_c_aqs.wys = true;
                        Lm.field_postBuf = com_tencent_mm_protocal_c_aqs.toByteArray();
                        ae.bvv().b(Lm.roJ, Lm);
                    }
                } catch (Exception e) {
                }
            }
        }
    }
}
