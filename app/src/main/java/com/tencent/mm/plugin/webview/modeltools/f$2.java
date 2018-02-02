package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.g.a.tu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import com.tencent.mm.z.t;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

class f$2 extends c<tu> {
    final /* synthetic */ f tuZ;

    f$2(f fVar) {
        this.tuZ = fVar;
        this.xen = tu.class.getName().hashCode();
    }

    private static boolean a(tu tuVar) {
        if (!(tuVar instanceof tu)) {
            return false;
        }
        String str;
        String FS = q.FS();
        List arrayList = new ArrayList();
        arrayList.add(tuVar.fMo.fMp);
        arrayList.add(tuVar.fMo.fMq);
        arrayList.add(tuVar.fMo.fMr);
        arrayList.add(tuVar.fMo.fMs);
        arrayList.add(tuVar.fMo.url);
        arrayList.add(tuVar.fMo.fMt);
        arrayList.add(tuVar.fMo.fMu);
        arrayList.add(tuVar.fMo.fMv);
        arrayList.add(tuVar.fMo.fMw);
        arrayList.add(tuVar.fMo.fMx);
        arrayList.add(FS);
        arrayList.add(tuVar.fMo.fMy);
        arrayList.add(tuVar.fMo.fMz);
        PString pString = new PString();
        String a = ((i) g.h(i.class)).a(tuVar.fMo.fMA, pString);
        arrayList.add(a);
        arrayList.add("");
        arrayList.add("");
        arrayList.add("");
        int N = t.N(tuVar.fMo.fMr, tuVar.fMo.fMs);
        int N2 = t.N(FS, tuVar.fMo.fMu);
        arrayList.add(String.valueOf(N));
        arrayList.add(String.valueOf(N2));
        Object obj = tuVar.fMo.fMB;
        try {
            obj = URLEncoder.encode(obj, "UTF-8");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SubCoreTools", e, "", new Object[0]);
        }
        arrayList.add(obj);
        arrayList.add(pString.value);
        String str2 = "MicroMsg.SubCoreTools";
        String str3 = "report(11954) : prePublishId : %s, curPublishId : %s, preUsername : %s, preChatName : %s, url : %s, preMsgIndex : %s, curChatName : %s, curChatTitle : %s, curChatMemberCount : %s, sendAppMsgScene : %s, curUserName : %s, getA8KeyScene : %s, referUrl : %s. : statExtStr:%s(%s), preChatType:%d, curChatType:%d, webViewTitle:%s, sourceAppId:%s";
        Object[] objArr = new Object[19];
        objArr[0] = tuVar.fMo.fMp;
        objArr[1] = tuVar.fMo.fMq;
        objArr[2] = tuVar.fMo.fMr;
        objArr[3] = tuVar.fMo.fMs;
        if (tuVar.fMo.url == null) {
            str = tuVar.fMo.url;
        } else {
            str = tuVar.fMo.url.replace(",", "!");
        }
        objArr[4] = str;
        objArr[5] = Integer.valueOf(tuVar.fMo.fMt);
        objArr[6] = tuVar.fMo.fMu;
        objArr[7] = tuVar.fMo.fMv;
        objArr[8] = Integer.valueOf(tuVar.fMo.fMw);
        objArr[9] = Integer.valueOf(tuVar.fMo.fMx);
        objArr[10] = FS;
        objArr[11] = Integer.valueOf(tuVar.fMo.fMy);
        if (tuVar.fMo.fMz == null) {
            str = tuVar.fMo.fMz;
        } else {
            str = tuVar.fMo.fMz.replace(",", "!");
        }
        objArr[12] = str;
        objArr[13] = tuVar.fMo.fMA;
        objArr[14] = a;
        objArr[15] = Integer.valueOf(N);
        objArr[16] = Integer.valueOf(N2);
        objArr[17] = tuVar.fMo.fMB;
        objArr[18] = pString.value;
        x.d(str2, str3, objArr);
        if (tuVar.fMo.fMC != 2) {
            com.tencent.mm.plugin.report.service.g.pQN.d(11954, arrayList);
        }
        return true;
    }
}
