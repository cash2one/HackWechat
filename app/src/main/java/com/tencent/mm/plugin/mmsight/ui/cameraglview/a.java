package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    MMSightCameraGLSurfaceView oDA;
    public f oDz = new 1(this);

    public final void a(byte[] bArr, boolean z, int i) {
        if (this.oDA != null) {
            MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = this.oDA;
            if (bArr == null || mMSightCameraGLSurfaceView.oDC == null || mMSightCameraGLSurfaceView.oDC.ioB) {
                x.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
                return;
            }
            mMSightCameraGLSurfaceView.oDC.b(bArr, mMSightCameraGLSurfaceView.ioD, mMSightCameraGLSurfaceView.ioE, i, z);
            mMSightCameraGLSurfaceView.requestRender();
        }
    }

    public a(MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView) {
        this.oDA = mMSightCameraGLSurfaceView;
    }

    public final void R(int i, int i2, int i3) {
        if (this.oDA != null) {
            int i4 = (i3 == 0 || i3 == 180) ? i : i2;
            if (i3 == 0 || i3 == 180) {
                i = i2;
            }
            MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = this.oDA;
            x.i("MicroMsg.MMSightCameraGLSurfaceView", "setFrameInfo, width: %s, height: %s, rotate: %s this: %s", new Object[]{Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i3), mMSightCameraGLSurfaceView});
            mMSightCameraGLSurfaceView.ioD = i4;
            mMSightCameraGLSurfaceView.ioE = i;
            mMSightCameraGLSurfaceView.ioX = i3;
        }
    }

    public final void bbJ() {
        if (this.oDA != null) {
            MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = this.oDA;
            if (mMSightCameraGLSurfaceView.oDC != null) {
                mMSightCameraGLSurfaceView.oDC.ioS = true;
                mMSightCameraGLSurfaceView.requestRender();
            }
        }
    }
}
