package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.appbrand.i.b;
import com.tencent.mm.plugin.appbrand.i.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask;
import com.tencent.mm.protocal.c.amp;
import com.tencent.mm.protocal.c.bec;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class JsApiOperateWXData$OperateWXDataTask$4 implements a<b> {
    final /* synthetic */ int iTc;
    final /* synthetic */ OperateWXDataTask jgl;
    final /* synthetic */ JsApiOperateWXData$OperateWXDataTask$a jgn;

    JsApiOperateWXData$OperateWXDataTask$4(OperateWXDataTask operateWXDataTask, JsApiOperateWXData$OperateWXDataTask$a jsApiOperateWXData$OperateWXDataTask$a, int i) {
        this.jgl = operateWXDataTask;
        this.jgn = jsApiOperateWXData$OperateWXDataTask$a;
        this.iTc = i;
    }

    public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
        b bVar = (b) kVar;
        x.d("MicroMsg.JsApiOperateWXData", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            this.jgn.fq("");
        } else if (!(bVar instanceof b)) {
        } else {
            if (this.iTc == 2) {
                x.d("MicroMsg.JsApiOperateWXData", "press reject button");
                return;
            }
            amp com_tencent_mm_protocal_c_amp = bVar.gJQ == null ? null : (amp) bVar.gJQ.hmh.hmo;
            int i3 = com_tencent_mm_protocal_c_amp.wte.fts;
            String str2 = com_tencent_mm_protocal_c_amp.wte.ftt;
            bec com_tencent_mm_protocal_c_bec = com_tencent_mm_protocal_c_amp.wtl;
            LinkedList linkedList = new LinkedList();
            if (com_tencent_mm_protocal_c_bec != null) {
                linkedList.add(com_tencent_mm_protocal_c_bec);
            }
            String str3 = com_tencent_mm_protocal_c_amp.niZ;
            String str4 = com_tencent_mm_protocal_c_amp.vFW;
            x.d("MicroMsg.JsApiOperateWXData", "stev NetSceneJSOperateWxData jsErrcode %d", new Object[]{Integer.valueOf(i3)});
            if (i3 == -12000) {
                this.jgn.a(linkedList, str3, str4);
            } else if (i3 == 0) {
                x.d("MicroMsg.JsApiOperateWXData", "resp data %s", new Object[]{com_tencent_mm_protocal_c_amp.ksB.cdp()});
                this.jgn.po(r0);
            } else {
                x.e("MicroMsg.JsApiOperateWXData", "onSceneEnd NetSceneJSOperateWxData Failed %s", new Object[]{str2});
                this.jgn.fq(str2);
            }
        }
    }
}
