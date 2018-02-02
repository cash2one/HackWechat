package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.mm.z.q;

class b$32 implements OnClickListener {
    final /* synthetic */ b rPY;

    b$32(b bVar) {
        this.rPY = bVar;
    }

    public final void onClick(View view) {
        m mVar;
        String str;
        boolean z;
        b iu;
        int i = 721;
        boolean z2 = false;
        String str2 = (String) view.getTag();
        x.d("MicroMsg.TimelineClickListener", "onCommentClick:" + str2);
        Intent intent = new Intent();
        String str3 = "";
        if (!(view instanceof MaskImageButton) || ((MaskImageButton) view).zlH == null) {
            mVar = null;
            str = str3;
            z = false;
        } else {
            m Lm = ae.bvv().Lm((String) ((MaskImageButton) view).zlH);
            if (Lm.xl(32)) {
                str = Lm.byz();
                com.tencent.mm.plugin.sns.storage.b bxR = Lm.bxR();
                if (bxR == null || bxR.reG != 1 || bh.ov(bxR.reH)) {
                    mVar = Lm;
                    z = true;
                } else {
                    str2 = bxR.reH;
                    x.i("MicroMsg.TimelineClickListener", "headClickParam url " + str2 + " " + bxR.reI);
                    Intent intent2 = new Intent();
                    if (bxR.reI == 0) {
                        z2 = true;
                    }
                    intent2.putExtra("KsnsViewId", str);
                    intent2.putExtra("KRightBtn", z2);
                    intent2.putExtra("jsapiargs", new Bundle());
                    intent2.putExtra("rawUrl", str2);
                    intent2.putExtra("useJs", true);
                    a.ifs.j(intent2, this.rPY.activity);
                    return;
                }
            }
            mVar = Lm;
            str = str3;
            z = false;
        }
        if (mVar != null) {
            if (this.rPY.scene == 0) {
                iu = b.iu(mVar.xl(32) ? 722 : 721);
            } else {
                if (mVar.xl(32)) {
                    i = 722;
                }
                iu = b.iv(i);
            }
            iu.mB(i.g(mVar)).ix(mVar.field_type).bU(mVar.xl(32)).mB(mVar.byA()).mB(str2);
            iu.Sx();
        }
        if (z) {
            int i2;
            Parcelable snsAdClick = new SnsAdClick(str, this.rPY.scene == 0 ? 1 : 2, mVar.field_snsId, mVar.byA(), mVar.byD(), (byte) 0);
            snsAdClick.hOw = mVar.bxV().nGJ;
            intent.putExtra("Contact_User", str2);
            intent.putExtra("KSnsAdTag", snsAdClick);
            a.ifs.d(intent, this.rPY.activity);
            if (this.rPY.scene == 0) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            k cVar = new c(str, 1, i2, "", mVar.byD(), mVar.bxW());
            g.Dk();
            g.Di().gPJ.a(cVar, 0);
            return;
        }
        this.rPY.rrV.bva().a(mVar, true);
        if (this.rPY.scene == 0) {
            iu = b.iu(746);
        } else {
            iu = b.iv(746);
        }
        iu.mB(str2).bU(str2.endsWith(q.FS()));
        iu.b(intent, "intent_key_StatisticsOplog");
        intent.putExtra("Contact_User", str2);
        a.ifs.d(intent, this.rPY.activity);
    }
}
