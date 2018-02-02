package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.protocal.c.bmf;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.a;
import com.tencent.mm.ui.chatting.a.b;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.m;

class j$2 implements OnClickListener {
    final /* synthetic */ j yGA;

    j$2(j jVar) {
        this.yGA = jVar;
    }

    public final void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof au)) {
            au auVar = (au) view.getTag();
            a.a(a.a.yoP, auVar);
            r nF = t.nF(auVar.field_imgPath);
            bmf com_tencent_mm_protocal_c_bmf = nF.hVQ;
            if (com_tencent_mm_protocal_c_bmf != null && !com.tencent.mm.platformtools.t.ov(com_tencent_mm_protocal_c_bmf.hdo)) {
                int i;
                o.TU();
                String nu = s.nu(auVar.field_imgPath);
                Intent intent = new Intent();
                intent.putExtra("IsAd", false);
                intent.putExtra("KStremVideoUrl", com_tencent_mm_protocal_c_bmf.hdo);
                intent.putExtra("KThumUrl", com_tencent_mm_protocal_c_bmf.hdt);
                intent.putExtra("KThumbPath", nu);
                intent.putExtra("KMediaId", "fakeid_" + auVar.field_msgId);
                intent.putExtra("KMediaVideoTime", com_tencent_mm_protocal_c_bmf.weC);
                intent.putExtra("KMediaTitle", com_tencent_mm_protocal_c_bmf.hdq);
                intent.putExtra("StreamWording", com_tencent_mm_protocal_c_bmf.hdr);
                intent.putExtra("StremWebUrl", com_tencent_mm_protocal_c_bmf.hds);
                String str = auVar.field_talker;
                boolean endsWith = str.endsWith("@chatroom");
                nu = endsWith ? ba.hP(auVar.field_content) : str;
                intent.putExtra("KSta_StremVideoAduxInfo", com_tencent_mm_protocal_c_bmf.hdu);
                intent.putExtra("KSta_StremVideoPublishId", com_tencent_mm_protocal_c_bmf.hdv);
                intent.putExtra("KSta_SourceType", 1);
                String str2 = "KSta_Scene";
                if (endsWith) {
                    i = b.yoY.value;
                } else {
                    i = b.yoX.value;
                }
                intent.putExtra(str2, i);
                intent.putExtra("KSta_FromUserName", nu);
                intent.putExtra("KSta_ChatName", str);
                intent.putExtra("KSta_MsgId", auVar.field_msgSvrId);
                intent.putExtra("KSta_SnsStatExtStr", nF.fGG);
                if (endsWith) {
                    intent.putExtra("KSta_ChatroomMembercount", m.gl(str));
                }
                d.b(this.yGA.yDo.yCS.mController.xIM, "sns", ".ui.VideoAdPlayerUI", intent);
            } else if (com_tencent_mm_protocal_c_bmf != null && !bh.ov(com_tencent_mm_protocal_c_bmf.hdr) && !bh.ov(com_tencent_mm_protocal_c_bmf.hds)) {
                x.i("MicroMsg.ImageGalleryViewHolder", "moreBtn click,opening " + com_tencent_mm_protocal_c_bmf.hds);
                Intent intent2 = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("key_snsad_statextstr", nF.fGG);
                intent2.putExtra("jsapiargs", bundle);
                intent2.putExtra("rawUrl", com_tencent_mm_protocal_c_bmf.hds);
                intent2.putExtra("useJs", true);
                ar.CG().a(new c("", 18, 5, "", 2, -1), 0);
                new af(Looper.getMainLooper()).post(new 1(this, intent2));
            }
        }
    }
}
