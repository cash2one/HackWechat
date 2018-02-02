package com.tencent.mm.plugin.collect.reward.b;

import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;

public final class a implements com.tencent.mm.modelcdntran.i.a {
    public static final String ljA = (com.tencent.mm.loader.stub.a.gZK + "wallet/img/");
    private static a ljB;
    private String filename;
    public Map<String, a> gKa;

    public static a ayT() {
        if (ljB == null) {
            ljB = new a();
        }
        return ljB;
    }

    public final boolean ayU() {
        return new File(ljA + ayV()).exists();
    }

    public final String ayV() {
        if (bh.ov(this.filename)) {
            this.filename = ab.UZ(q.FS() + "_reward_img");
        }
        return this.filename;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        x.i("MicroMsg.QrRewardCdnDownloadHelper", "cdn callback, id: %s, ret: %s, sceneResult: %s", new Object[]{str, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_SceneResult});
        ag.y(new 1(this, str, com_tencent_mm_modelcdntran_keep_SceneResult, i));
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] h(String str, byte[] bArr) {
        return new byte[0];
    }
}
