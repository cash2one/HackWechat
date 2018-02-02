package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements f {
    final /* synthetic */ a oDB;

    a$1(a aVar) {
        this.oDB = aVar;
    }

    public final boolean R(byte[] bArr) {
        if (this.oDB.oDA != null) {
            MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = this.oDB.oDA;
            if (bArr == null || mMSightCameraGLSurfaceView.oDC == null || mMSightCameraGLSurfaceView.oDC.ioB) {
                x.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
            } else {
                mMSightCameraGLSurfaceView.oDC.b(bArr, mMSightCameraGLSurfaceView.ioD, mMSightCameraGLSurfaceView.ioE, mMSightCameraGLSurfaceView.ioX, false);
                mMSightCameraGLSurfaceView.requestRender();
            }
        }
        return false;
    }
}
