package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.protocal.c.akl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.io.ByteArrayOutputStream;

class g$2 implements a {
    final /* synthetic */ g lMw;

    g$2(g gVar) {
        this.lMw = gVar;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s] sentToCloud:[%s]", this.lMw.hBn, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult, Boolean.valueOf(this.lMw.lMc));
        if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
            try {
                int i2;
                int i3 = (int) ((((float) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength) / ((float) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength)) * 100.0f);
                x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "sent to cloud progress %d", Integer.valueOf(i3));
                if (i3 >= 100) {
                    i2 = 99;
                } else {
                    i2 = i3;
                }
                for (String a : this.lMw.lMe.keySet()) {
                    g.a(this.lMw, a, i2);
                }
            } catch (Exception e) {
                x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdnCallback Exception %s", e);
            }
        }
        if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
            if (this.lMw.lMc) {
                akl com_tencent_mm_protocal_c_akl = new akl();
                this.lMw.a(com_tencent_mm_protocal_c_akl, this.lMw.gAc);
                this.lMw.lMc = false;
                if (g.cp(this.lMw.gAc).booleanValue() || g.cq(this.lMw.gAc).booleanValue()) {
                    com_tencent_mm_protocal_c_akl.wrH.vQA = com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey;
                    com_tencent_mm_protocal_c_akl.wrH.wrL = this.lMw.lMg;
                    com_tencent_mm_protocal_c_akl.wrH.vQE = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
                    com_tencent_mm_protocal_c_akl.wrH.nfX = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileUrl;
                    x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "image_msg.url:[%s]", com_tencent_mm_protocal_c_akl.wrH.nfX);
                } else if (g.co(this.lMw.gAc).booleanValue()) {
                    com_tencent_mm_protocal_c_akl.wrI.vQA = com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey;
                    com_tencent_mm_protocal_c_akl.wrI.vQE = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
                    com_tencent_mm_protocal_c_akl.wrI.nfX = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileUrl;
                    x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file_msg.url:[%s]", com_tencent_mm_protocal_c_akl.wrI.nfX);
                } else if (g.cr(this.lMw.gAc).booleanValue()) {
                    com_tencent_mm_protocal_c_akl.wrK.nfX = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileUrl;
                    x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "video_msg.url:[%s]", com_tencent_mm_protocal_c_akl.wrK.nfX);
                }
                this.lMw.lMf = com_tencent_mm_protocal_c_akl;
                for (String a2 : this.lMw.lMe.keySet()) {
                    ar.CG().a(new n(com_tencent_mm_protocal_c_akl, (String) this.lMw.lMe.get(a2), a2, 1), 0);
                }
                this.lMw.lMe.clear();
            }
        }
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getCdnAuthInfo mediaId = " + str);
    }

    public final byte[] h(String str, byte[] bArr) {
        x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "decodePrepareResponse ");
        return bArr;
    }
}
