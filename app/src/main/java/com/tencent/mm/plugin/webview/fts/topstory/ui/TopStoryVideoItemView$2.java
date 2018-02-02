package com.tencent.mm.plugin.webview.fts.topstory.ui;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.topstory.a.a.a;
import com.tencent.mm.plugin.topstory.a.a.c;
import com.tencent.mm.plugin.webview.fts.topstory.a.b;
import com.tencent.mm.plugin.webview.fts.topstory.a.f;
import com.tencent.mm.protocal.c.bzu;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.y.g;

class TopStoryVideoItemView$2 implements d {
    final /* synthetic */ f toq;
    final /* synthetic */ c tor;
    final /* synthetic */ Context val$context;

    TopStoryVideoItemView$2(f fVar, Context context, c cVar) {
        this.toq = fVar;
        this.val$context = context;
        this.tor = cVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        f fVar;
        Context context;
        c cVar;
        a aVar;
        if (menuItem.getItemId() == 0) {
            this.toq.bPU();
            fVar = f.tob;
            context = this.val$context;
            cVar = this.tor;
            aVar = b.tnw;
            if (cVar != null && aVar != null) {
                byte[] toByteArray;
                fVar.toc = cVar;
                Intent intent = new Intent();
                intent.putExtra("Ksnsupload_title", cVar.lOY);
                intent.putExtra("Ksnsupload_imgurl", cVar.sez);
                intent.putExtra("Ksnsupload_link", cVar.lOX);
                intent.putExtra("KContentObjDesc", bh.ov(cVar.rfu) ? context.getString(R.l.eCw) : cVar.rfu);
                intent.putExtra("KlinkThumb_url", cVar.sez);
                intent.putExtra("Ksnsupload_source", 1);
                intent.putExtra("Ksnsupload_type", 16);
                intent.putExtra("need_result", true);
                bzu com_tencent_mm_protocal_c_bzu = new bzu();
                com_tencent_mm_protocal_c_bzu.tnm = cVar.sey;
                com_tencent_mm_protocal_c_bzu.tnn = cVar.seE;
                com_tencent_mm_protocal_c_bzu.tno = aVar.sem;
                com_tencent_mm_protocal_c_bzu.tnp = cVar.seD;
                com_tencent_mm_protocal_c_bzu.tnq = cVar.seC;
                com_tencent_mm_protocal_c_bzu.lOX = cVar.lOX;
                com_tencent_mm_protocal_c_bzu.lOY = cVar.lOY;
                com_tencent_mm_protocal_c_bzu.rfu = cVar.rfu;
                com_tencent_mm_protocal_c_bzu.sez = cVar.sez;
                com_tencent_mm_protocal_c_bzu.seA = cVar.seA;
                com_tencent_mm_protocal_c_bzu.seB = cVar.seB;
                com_tencent_mm_protocal_c_bzu.bhd = cVar.bhd;
                com_tencent_mm_protocal_c_bzu.pes = cVar.pes;
                com_tencent_mm_protocal_c_bzu.seF = cVar.seF;
                com_tencent_mm_protocal_c_bzu.seG = cVar.seG;
                try {
                    toByteArray = com_tencent_mm_protocal_c_bzu.toByteArray();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoShareMgr", e, "", new Object[0]);
                    toByteArray = null;
                }
                if (toByteArray != null) {
                    intent.putExtra("KWebSearchInfo", toByteArray);
                }
                com.tencent.mm.bm.d.b(context, "sns", ".ui.SnsUploadUI", intent, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            }
        } else if (menuItem.getItemId() == 1) {
            this.toq.bPU();
            fVar = f.tob;
            context = this.val$context;
            cVar = this.tor;
            aVar = b.tnw;
            fVar.toc = cVar;
            g.a aVar2 = new g.a();
            aVar2.type = 5;
            aVar2.title = cVar.lOY;
            aVar2.description = bh.ov(cVar.rfu) ? context.getString(R.l.eCw) : cVar.rfu;
            aVar2.url = cVar.lOX;
            aVar2.thumburl = cVar.sez;
            com.tencent.mm.y.d aVar3 = new com.tencent.mm.plugin.webview.fts.topstory.a.a();
            aVar3.tnm = cVar.sey;
            aVar3.tnn = cVar.seE;
            aVar3.tno = aVar.sem;
            aVar3.tnp = cVar.seD;
            aVar3.tnq = cVar.seC;
            aVar3.lOX = cVar.lOX;
            aVar3.lOY = cVar.lOY;
            aVar3.rfu = cVar.rfu;
            aVar3.sez = cVar.sez;
            aVar3.seA = cVar.seA;
            aVar3.seB = cVar.seB;
            aVar3.bhd = cVar.bhd;
            aVar3.pes = cVar.pes;
            aVar3.seF = cVar.seF;
            aVar3.seG = cVar.seG;
            aVar2.a(aVar3);
            String a = g.a.a(aVar2, null, null);
            Intent intent2 = new Intent();
            intent2.putExtra("Retr_Msg_Type", 2);
            intent2.putExtra("Retr_Msg_content", a);
            intent2.putExtra("Multi_Retr", true);
            intent2.putExtra("Retr_go_to_chattingUI", false);
            intent2.putExtra("Retr_show_success_tips", true);
            com.tencent.mm.bm.d.a(context, ".ui.transmit.MsgRetransmitUI", intent2, 2048);
        }
    }
}
