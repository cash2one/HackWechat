package com.tencent.mm.modelvideo;

import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

class f$1 implements a {
    final /* synthetic */ f hUl;

    f$1(f fVar) {
        this.hUl = fVar;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        if (i != 0) {
            x.w("MicroMsg.NetScenePreloadVideoFake", "%d preload video error startRet[%d]", new Object[]{Integer.valueOf(this.hUl.hashCode()), Integer.valueOf(i)});
            if (this.hUl.hUk != null) {
                this.hUl.hUk.a(this.hUl, false, 0, 0);
            }
        }
        if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
            x.d("MicroMsg.NetScenePreloadVideoFake", "%d preload video[%d %d] mediaId[%s]", new Object[]{Integer.valueOf(this.hUl.hashCode()), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength), str});
        }
        if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
            x.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video error [%d]", new Object[]{Integer.valueOf(this.hUl.hashCode()), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode)});
            if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode == 0) {
                x.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video download all video file", new Object[]{Integer.valueOf(this.hUl.hashCode())});
                this.hUl.f(this.hUl.hUe, com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength, this.hUl.htH);
            } else if (this.hUl.hUk != null) {
                this.hUl.hUk.a(this.hUl, false, 0, 0);
            }
        }
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] h(String str, byte[] bArr) {
        return new byte[0];
    }
}
