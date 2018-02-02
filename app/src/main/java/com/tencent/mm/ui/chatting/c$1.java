package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.oy;
import com.tencent.mm.protocal.c.apr;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.chatting.r.n;
import com.tencent.mm.z.ar;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;

class c$1 implements c {
    final /* synthetic */ n yqe;
    final /* synthetic */ c yqf;

    c$1(c cVar, n nVar) {
        this.yqf = cVar;
        this.yqe = nVar;
    }

    public final void jl(int i) {
        switch (i) {
            case 0:
                Intent intent = new Intent();
                try {
                    intent.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/readtemplate?t=wxm-appmsg-inform&bizusername=%s&tid=%s&mid=%s&mtime=%s&scene=%s#wechat_redirect", new Object[]{URLEncoder.encode(this.yqe.rYX, "UTF-8"), URLEncoder.encode(this.yqe.hcc, "UTF-8"), Long.valueOf(this.yqe.fEJ.field_msgSvrId), Integer.valueOf((int) (this.yqe.fEJ.field_createTime / 1000)), Integer.valueOf(42)}));
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("showShare", false);
                    d.b(c.a(this.yqf).thisActivity(), "webview", ".ui.tools.WebViewUI", intent);
                    return;
                } catch (UnsupportedEncodingException e) {
                    x.e("MicroMsg.AppSpamClickListener", "exception in expore, %s", new Object[]{e.getMessage()});
                    return;
                }
            case 1:
                x.d("MicroMsg.AppSpamClickListener", "hakon refulse, fromUserName = %s, templateId = %s", new Object[]{this.yqe.rYX, this.yqe.hcc});
                ar.CG().a(1030, this.yqf);
                apr com_tencent_mm_protocal_c_apr = new apr();
                com_tencent_mm_protocal_c_apr.vGN = 1;
                com_tencent_mm_protocal_c_apr.wwx = this.yqe.hcc;
                com_tencent_mm_protocal_c_apr.fon = "";
                LinkedList linkedList = new LinkedList();
                linkedList.add(com_tencent_mm_protocal_c_apr);
                b oyVar = new oy();
                oyVar.fGQ.fFh = this.yqe.rYX;
                oyVar.fGQ.fGR = linkedList;
                if (a.xef.m(oyVar)) {
                    c cVar = this.yqf;
                    Context thisActivity = c.a(this.yqf).thisActivity();
                    c.a(this.yqf).getString(R.l.dGO);
                    c.a(cVar, h.a(thisActivity, c.a(this.yqf).getString(R.l.dHc), true, new 1(this)));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
