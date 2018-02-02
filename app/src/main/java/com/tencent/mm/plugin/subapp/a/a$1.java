package com.tencent.mm.plugin.subapp.a;

import com.tencent.mm.protocal.c.ahk;
import com.tencent.mm.protocal.c.bru;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements a {
    final /* synthetic */ a rWc;

    a$1(a aVar) {
        this.rWc = aVar;
    }

    public final boolean uF() {
        if (this.rWc.rWb < 0) {
            return false;
        }
        bru com_tencent_mm_protocal_c_bru;
        ahk com_tencent_mm_protocal_c_ahk = (ahk) this.rWc.gJQ.hmh.hmo;
        try {
            com_tencent_mm_protocal_c_bru = (bru) com_tencent_mm_protocal_c_ahk.woV.get(this.rWc.rWb);
        } catch (Exception e) {
            x.e("MicroMsg.NetSceneGetVUserInfo", "get item :" + this.rWc.rWb + " not Found");
            com_tencent_mm_protocal_c_bru = null;
        }
        if (!(com_tencent_mm_protocal_c_bru == null || com_tencent_mm_protocal_c_bru.wTt == null || com_tencent_mm_protocal_c_bru.wTs == null)) {
            x.d("MicroMsg.NetSceneGetVUserInfo", "onGYNetEnd ver:" + com_tencent_mm_protocal_c_ahk.ktM + " idx:" + this.rWc.rWb + " id:" + Integer.toHexString(com_tencent_mm_protocal_c_bru.fgt) + " size:" + com_tencent_mm_protocal_c_bru.wTs.wJB + " hdsize:" + com_tencent_mm_protocal_c_bru.wTt.wJB);
            a.a(com_tencent_mm_protocal_c_bru.fgt, true, com_tencent_mm_protocal_c_bru.wTt.wJD.toByteArray());
            a.a(com_tencent_mm_protocal_c_bru.fgt, false, com_tencent_mm_protocal_c_bru.wTs.wJD.toByteArray());
        }
        a aVar = this.rWc;
        aVar.rWb--;
        return true;
    }
}
