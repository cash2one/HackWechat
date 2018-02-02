package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.plugin.qqmail.b.v.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class v$2 implements v$b {
    final /* synthetic */ v ppT;

    v$2(v vVar) {
        this.ppT = vVar;
    }

    public final void a(ArrayList<Long> arrayList, HashMap<Long, String> hashMap) {
        v vVar;
        x.i("MicroMsg.ShareModeMailAppService", "finishChckImgStatus, notUploadedImgIdList.size: %d, attachIdMap.size: %d", new Object[]{Integer.valueOf(arrayList.size()), Integer.valueOf(hashMap.size())});
        if (arrayList.size() > 0) {
            vVar = this.ppT;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) vVar.ppA.get(String.valueOf((Long) it.next()));
                x.i("MicroMsg.ShareModeMailAppService", "appendAllUndownloadImage, filePath: %s", new Object[]{str});
                if (!bh.ov(str)) {
                    if (vVar.ppL == null) {
                        vVar.ppL = new ArrayList();
                    }
                    vVar.ppL.add(new g(str, str));
                }
            }
        }
        if (hashMap.size() > 0) {
            v.a(this.ppT, hashMap);
        }
        this.ppT.va(10);
        vVar = this.ppT;
        x.i("MicroMsg.ShareModeMailAppService", "uploadMsgImg, filesInfo.size = %d", new Object[]{Integer.valueOf(vVar.ppL.size())});
        if (vVar.ppL == null) {
            vVar.ppL = new ArrayList();
        }
        if (vVar.ppL.size() > 0) {
            v$c com_tencent_mm_plugin_qqmail_b_v_3 = new v$3(vVar);
            v$d com_tencent_mm_plugin_qqmail_b_v_4 = new v$4(vVar);
            x.i("MicroMsg.ShareModeMailAppService", "uploadFile, filesInfo.size: %d", new Object[]{Integer.valueOf(vVar.ppL.size())});
            vVar.ppP = com_tencent_mm_plugin_qqmail_b_v_3;
            vVar.ppQ = com_tencent_mm_plugin_qqmail_b_v_4;
            vVar.ppR = vVar.ppL.size();
            if (vVar.ppL != null && vVar.ppL.size() > 0) {
                g gVar = (g) vVar.ppL.remove(0);
                vVar.ppM = gVar.fzR;
                vVar.ppN = gVar.fileName;
                vVar.ppO = new HashMap();
                ar.CG().a(new o(vVar.ppN, vVar.ppM, vVar.ppS), 0);
                return;
            }
            return;
        }
        vVar.va(90);
        vVar.bko();
    }
}
