package com.tencent.mm.ui.conversation;

import android.content.Intent;
import com.tencent.mm.c.i;
import com.tencent.mm.c.i$a;
import com.tencent.mm.pluginsdk.h.p;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.conversation.i.4;
import com.tencent.mm.z.ar;

class i$4$2 implements Runnable {
    final /* synthetic */ 4 yZA;

    i$4$2(4 4) {
        this.yZA = 4;
    }

    public final void run() {
        x.i("MicroMsg.InitHelper", "path:%s,apkMd5:%s", this.yZA.yZz.wQA, this.yZA.yZz.nBr);
        String substring = this.yZA.yZz.nBo.substring(0, this.yZA.yZz.nBo.lastIndexOf(47) + 1);
        String substring2 = this.yZA.yZz.nBo.substring(this.yZA.yZz.nBo.lastIndexOf(47) + 1);
        i iVar = new i(substring, this.yZA.yZz.versionCode);
        iVar.a(new i$a(this.yZA.yZz.nBs, this.yZA.yZz.nBr, this.yZA.yZz.fel, substring2, this.yZA.yZz.jIM));
        Intent intent = new Intent();
        intent.putExtra("intent_short_ips", p.bZi());
        intent.putExtra("intent_client_version", d.vAz);
        intent.putExtra("intent_extra_session", ar.CG().hmV.Kx().CF());
        intent.putExtra("intent_extra_cookie", ar.CG().hmV.Kx().Ks());
        intent.putExtra("intent_extra_ecdhkey", ar.CG().hmV.Kx().Ku());
        intent.putExtra("intent_extra_uin", ar.CG().hmV.Kx().Cg());
        intent.putExtra("intent_update_type", 3);
        intent.putExtra("intent_extra_desc", this.yZA.yZz.fpb);
        intent.putExtra("intent_extra_md5", this.yZA.yZz.fel);
        intent.putExtra("intent_extra_size", this.yZA.yZz.jIM);
        intent.putExtra("intent_extra_download_url", new String[]{this.yZA.yZz.nBo});
        intent.putExtra("intent_extra_patchInfo", iVar.tr());
        intent.putExtra("intent_extra_updateMode", f.fdU);
        intent.putExtra("intent_extra_marketUrl", f.xez);
        intent.putExtra("intent_extra_extinfo", "<extinfo></extinfo>");
        intent.putExtra("intent_extra_tinker_patch", true);
        intent.putExtra("intent_extra_download_mode", 1);
        q.x.bYd().s(i.a(this.yZA.yZy), intent);
        p.bZe();
    }
}
