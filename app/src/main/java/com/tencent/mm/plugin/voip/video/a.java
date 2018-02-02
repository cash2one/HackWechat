package com.tencent.mm.plugin.voip.video;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.g.a.lp;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.video.ObservableSurfaceView;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.video.b;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class a implements com.tencent.mm.plugin.video.a, b {
    private static final Pattern qap = Pattern.compile(",");
    private static int ssJ = 20;
    private static int ssK = 70;
    protected int mHeight = 240;
    protected int mWidth = 320;
    protected boolean ssL = false;
    protected boolean ssM = false;
    protected boolean ssN = false;
    protected boolean ssO = false;
    protected boolean ssP = false;
    protected long ssQ = 0;
    protected long ssR = 30000;
    protected int ssS = 0;
    protected Camera ssT;
    protected Parameters ssU;
    protected Size ssV;
    protected int ssW;
    protected boolean ssX = false;
    protected boolean ssY = false;
    protected boolean ssZ = false;
    protected ObservableSurfaceView sta = null;
    protected ObservableTextureView stb;
    protected f stc;
    protected boolean std = false;
    protected boolean ste = false;
    protected byte[] stf = null;
    protected int[] stg = null;
    protected List<byte[]> sth;
    protected boolean sti = true;
    protected int stj;
    protected int stk = 0;
    protected int stl = 0;
    protected int stm = 0;
    PreviewCallback stn = new 2(this);

    public a(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
        i.dH(ac.getContext().getApplicationContext());
        x.d("MicroMsg.Voip.CaptureRender", "width: %d, height: %d", new Object[]{Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight)});
    }

    public final void a(ObservableSurfaceView observableSurfaceView) {
        if (observableSurfaceView != null) {
            this.sta = observableSurfaceView;
            this.sta.a(this);
            this.ssZ = true;
        }
    }

    public final void a(ObservableTextureView observableTextureView) {
        x.d("MicroMsg.Voip.CaptureRender", "bindTextureView");
        if (observableTextureView != null) {
            this.stb = observableTextureView;
            this.stb.a(this);
            this.ssZ = false;
        }
    }

    public final void a(SurfaceHolder surfaceHolder) {
        boolean z = false;
        x.d("MicroMsg.Voip.CaptureRender", "surfaceChange");
        if (!this.ssX || surfaceHolder.getSurface() == null) {
            String str = "MicroMsg.Voip.CaptureRender";
            String str2 = "surfaceChange failed, CameraOpen: %b, surface: %b";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.ssX);
            if (surfaceHolder.getSurface() == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            x.e(str, str2, objArr);
            return;
        }
        try {
            this.ssT.setPreviewCallback(null);
            this.ssT.stopPreview();
            this.ssT.setPreviewDisplay(surfaceHolder);
            bIt();
            this.ssT.startPreview();
        } catch (Exception e) {
            Exception exception = e;
            g.pQN.a(159, 0, 1, false);
            g.pQN.a(159, 2, 1, false);
            x.e("MicroMsg.Voip.CaptureRender", "surfaceChange failed" + exception.getMessage());
            this.ssS = 1;
        }
        if (this.ste) {
            bIv();
            this.ste = false;
        }
        d.bGj().yH(this.ssS);
    }

    public final void d(SurfaceTexture surfaceTexture) {
        boolean z = false;
        x.d("MicroMsg.Voip.CaptureRender", "onSurfaceTextureAvailable");
        if (!this.ssX || surfaceTexture == null) {
            String str = "MicroMsg.Voip.CaptureRender";
            String str2 = "onSurfaceTextureAvailable failed, CameraOpen: %b, surface: %b";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.ssX);
            if (surfaceTexture == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            x.e(str, str2, objArr);
            return;
        }
        try {
            this.ssT.setPreviewCallback(null);
            this.ssT.stopPreview();
            this.ssT.setPreviewTexture(surfaceTexture);
            bIt();
            this.ssT.startPreview();
        } catch (Exception e) {
            Exception exception = e;
            g.pQN.a(159, 0, 1, false);
            g.pQN.a(159, 2, 1, false);
            x.e("MicroMsg.Voip.CaptureRender", "surfaceChange failed" + exception.getMessage());
            this.ssS = 1;
        }
        if (this.ste) {
            bIv();
            this.ste = false;
        }
        d.bGj().yH(this.ssS);
    }

    public final int a(f fVar, boolean z) {
        if (i.suQ.gDQ <= 0) {
            this.ssS = 1;
            return -1;
        }
        if (z) {
            if (!i.suQ.sty) {
                z = false;
            }
        } else if (!i.suQ.stz) {
            z = true;
        }
        this.stc = fVar;
        if (d(z, this.mWidth, this.mHeight) <= 0) {
            int d = d(z, 0, 0);
            if (d <= 0) {
                this.ssS = 1;
                return d;
            }
        }
        bIt();
        this.ssS = 0;
        return 1;
    }

    private void bIt() {
        if (this.ssV == null || this.ssV.height <= 0 || this.ssV.width <= 0) {
            this.ssT.setPreviewCallback(this.stn);
            return;
        }
        int i;
        int i2 = ((this.ssV.height * this.ssV.width) * 3) / 2;
        if (this.sth == null) {
            this.sth = new ArrayList(3);
            for (i = 0; i < 3; i++) {
                this.sth.add(new byte[i2]);
            }
        }
        for (i = 0; i < this.sth.size(); i++) {
            this.ssT.addCallbackBuffer((byte[]) this.sth.get(i));
        }
        this.ssT.setPreviewCallbackWithBuffer(this.stn);
    }

    private static Camera jn(boolean z) {
        Camera camera = null;
        if (i.suQ.gDQ > 0 && i.suW) {
            if (z) {
                try {
                    camera = Camera.open(i.suR);
                    x.i("Camera", "Use front");
                } catch (Exception e) {
                    Exception exception = e;
                    g.pQN.a(159, 0, 1, false);
                    g.pQN.a(159, 1, 1, false);
                    x.e("MicroMsg.Voip.CaptureRender", "openCameraByHighApiLvl:error:" + exception.toString());
                }
            } else {
                camera = Camera.open(i.suS);
                x.i("Camera", "Use back");
            }
        }
        return camera;
    }

    private Camera jo(boolean z) {
        Camera jn = jn(z);
        if (jn == null) {
            try {
                jn = Camera.open();
                try {
                    Parameters parameters = jn.getParameters();
                    parameters.set("camera-id", z ? 2 : 1);
                    jn.setParameters(parameters);
                } catch (Exception e) {
                    Exception exception = e;
                    g.pQN.a(159, 0, 1, false);
                    x.e("MicroMsg.Voip.CaptureRender", "set camera-id error:" + exception.toString());
                }
            } catch (Exception e2) {
                x.e("MicroMsg.Voip.CaptureRender", "OpenCameraError:" + e2.toString());
                g.pQN.a(159, 0, 1, false);
                g.pQN.a(159, 1, 1, false);
                if (this.stc != null) {
                    this.stc.bdd();
                }
                return null;
            }
        }
        this.ssL = z;
        i(jn);
        h(jn);
        return jn;
    }

    private static boolean a(Camera camera, int i, int i2) {
        if (camera == null) {
            return false;
        }
        try {
            Parameters parameters = camera.getParameters();
            if (i > 0 && i2 > 0) {
                parameters.setPreviewSize(i, i2);
            }
            camera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            g.pQN.a(159, 0, 1, false);
            x.e("MicroMsg.Voip.CaptureRender", "TryPreviewSize fail:" + e.toString());
            return false;
        }
    }

    private boolean g(Camera camera) {
        if (camera == null) {
            return false;
        }
        try {
            Parameters parameters = camera.getParameters();
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes != null) {
                x.d("MicroMsg.Voip.CaptureRender", "supported focus modes size = " + supportedFocusModes.size());
                for (String str : supportedFocusModes) {
                    x.d("MicroMsg.Voip.CaptureRender", "supported focus modes : " + str);
                }
                if (q.gFU.gEw == 0) {
                    if (supportedFocusModes.contains("auto")) {
                        x.d("MicroMsg.Voip.CaptureRender", "camera support auto focus");
                        parameters.setFocusMode("auto");
                        this.ssY = false;
                    } else if (supportedFocusModes.contains("continuous-video")) {
                        x.d("MicroMsg.Voip.CaptureRender", "camera support continuous video focus");
                        parameters.setFocusMode("continuous-video");
                        this.ssY = true;
                    }
                } else if (q.gFU.gEw == 1) {
                    if (supportedFocusModes.contains("continuous-video")) {
                        x.d("MicroMsg.Voip.CaptureRender", "camera support continuous video focus");
                        parameters.setFocusMode("continuous-video");
                        this.ssY = true;
                    } else if (supportedFocusModes.contains("auto")) {
                        x.d("MicroMsg.Voip.CaptureRender", "camera support auto focus");
                        parameters.setFocusMode("auto");
                        this.ssY = false;
                    }
                }
                camera.setParameters(parameters);
            }
            return true;
        } catch (Exception e) {
            g.pQN.a(159, 0, 1, false);
            x.e("MicroMsg.Voip.CaptureRender", "TrySetAutoFocus fail:" + e.toString());
            return false;
        }
    }

    private static Point a(CharSequence charSequence, Point point) {
        int indexOf;
        int parseInt;
        String[] split = qap.split(charSequence);
        int length = split.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = Integer.MAX_VALUE;
        while (i < length) {
            int i5;
            String trim = split[i].trim();
            indexOf = trim.indexOf(120);
            if (indexOf < 0) {
                x.w("MicroMsg.Voip.CaptureRender", "Bad preview-size: " + trim);
                i5 = i2;
                i2 = i3;
            } else {
                try {
                    parseInt = Integer.parseInt(trim.substring(0, indexOf));
                    indexOf = Integer.parseInt(trim.substring(indexOf + 1));
                    i5 = Math.abs(parseInt - point.x) + Math.abs(indexOf - point.y);
                    if (i5 == 0) {
                        break;
                    } else if (i5 >= i4 || parseInt == indexOf) {
                        i5 = i2;
                        i2 = i3;
                    } else {
                        i4 = i5;
                        i2 = parseInt;
                        i5 = indexOf;
                    }
                } catch (NumberFormatException e) {
                    x.w("MicroMsg.Voip.CaptureRender", "Bad preview-size: " + trim);
                    i5 = i2;
                    i2 = i3;
                }
            }
            i++;
            i3 = i2;
            i2 = i5;
        }
        indexOf = i2;
        parseInt = i3;
        if (parseInt <= 0 || indexOf <= 0) {
            return null;
        }
        return new Point(parseInt, indexOf);
    }

    private int d(boolean z, int i, int i2) {
        Exception e;
        Object obj;
        Size size;
        Camera camera;
        CameraInfo cameraInfo;
        int i3;
        x.i("MicroMsg.Voip.CaptureRender", "try open camera, face: " + z);
        this.ssY = false;
        Object obj2 = 1;
        if (this.ssT != null) {
            if (this.ssL != z) {
                this.ssT.setPreviewCallback(null);
                this.ssT.stopPreview();
                this.ssT.release();
                this.ssT = null;
            } else {
                obj2 = null;
            }
        }
        if (obj2 != null) {
            this.ssT = jo(z);
            if (this.ssT == null) {
                this.ssX = false;
                return -1;
            }
        }
        try {
            Parameters parameters;
            Point point;
            Size size2;
            boolean a;
            if (this.ssT != null) {
                this.ssT.getParameters();
            }
            this.ssX = true;
            Camera camera2 = this.ssT;
            int i4 = i.suQ.stx;
            if (camera2 != null) {
                try {
                    parameters = camera2.getParameters();
                    if (l.xg()) {
                        parameters.setPreviewFpsRange(i4 * 1000, i4 * 1000);
                    } else {
                        parameters.setPreviewFrameRate(i4);
                    }
                    camera2.setParameters(parameters);
                } catch (Exception e2) {
                    x.e("MicroMsg.Voip.CaptureRender", "SafeSetFps error:" + e2.toString());
                }
            }
            x.i("MicroMsg.Voip.CaptureRender", "Camera Open Success, try set size: w,h:" + i + "," + i2);
            if (z) {
                point = i.suQ.stC;
            } else {
                point = i.suQ.stD;
            }
            if (point != null) {
                obj = 1;
            } else {
                obj = null;
            }
            Size size3 = null;
            if (point != null) {
                Camera camera3 = this.ssT;
                camera3.getClass();
                Size size4 = new Size(camera3, point.x, point.y);
                x.i("MicroMsg.Voip.CaptureRender", "getCameraSize from table:" + size4.width + "," + size4.height);
                size = size4;
            } else {
                size = null;
            }
            try {
                CharSequence charSequence;
                Camera camera4 = this.ssT;
                parameters = camera4.getParameters();
                Point point2 = new Point(i, i2);
                String str = parameters.get("preview-size-values");
                if (str == null) {
                    charSequence = parameters.get("preview-size-value");
                } else {
                    Object obj3 = str;
                }
                Point point3 = null;
                if (charSequence != null) {
                    x.i("MicroMsg.Voip.CaptureRender", "preview-size-values parameter: " + charSequence);
                    point3 = a(charSequence, point2);
                }
                if (point3 == null) {
                    point3 = new Point((point2.x >> 3) << 3, (point2.y >> 3) << 3);
                }
                camera4.getClass();
                size2 = new Size(camera4, point3.x, point3.y);
                try {
                    x.i("MicroMsg.Voip.CaptureRender", "getCameraResolution:" + size2.width + "," + size2.height);
                } catch (Exception e3) {
                    e2 = e3;
                    size3 = size2;
                    x.e("MicroMsg.Voip.CaptureRender", "getCameraResolution failed: %s", new Object[]{e2.getMessage()});
                    size2 = size3;
                    if (obj != null) {
                        x.i("MicroMsg.Voip.CaptureRender", "2.no config size!");
                        if (size2 != null) {
                            x.i("MicroMsg.Voip.CaptureRender", "2.try support size alternatively! w" + size2.width + ",h" + size2.height);
                            if (!a(this.ssT, size2.width, size2.height)) {
                                x.e("MicroMsg.Voip.CaptureRender", "2.try support size fail: w" + size2.width + ",h" + size2.height);
                                return -1;
                            }
                        }
                    }
                    a = a(this.ssT, size.width, size.height);
                    x.i("MicroMsg.Voip.CaptureRender", "1.try config size first! w" + size.width + ",h" + size.height);
                    x.e("MicroMsg.Voip.CaptureRender", "1.try config size failed!,try support size: w" + size2.width + ",h" + size2.height);
                    if (!a(this.ssT, size2.width, size2.height)) {
                        x.e("MicroMsg.Voip.CaptureRender", "1.try support size fail: w" + size2.width + ",h" + size2.height);
                        return -1;
                    }
                    g(this.ssT);
                    this.ssU = this.ssT.getParameters();
                    this.ssV = this.ssU.getPreviewSize();
                    i4 = this.ssU.getPreviewFrameRate();
                    this.ssW = i.suV;
                    if (this.ssW <= 0) {
                        this.ssW = 7;
                    }
                    try {
                        camera = this.ssT;
                        cameraInfo = new CameraInfo();
                        Camera.getCameraInfo(this.ssL ? i.suS : i.suR, cameraInfo);
                        i3 = 0;
                        switch (((WindowManager) ac.getContext().getSystemService("window")).getDefaultDisplay().getRotation()) {
                            case 0:
                                i3 = 0;
                                break;
                            case 1:
                                i3 = 90;
                                break;
                            case 2:
                                i3 = 180;
                                break;
                            case 3:
                                i3 = 270;
                                break;
                        }
                        i3 = this.ssL ? ((cameraInfo.orientation - i3) + 360) % 360 : (360 - ((i3 + cameraInfo.orientation) % 360)) % 360;
                        camera.setDisplayOrientation(i3);
                        this.stj = i3;
                    } catch (Exception e22) {
                        x.e("MicroMsg.Voip.CaptureRender", "setDisplayOrientation failed: %s", new Object[]{e22.getMessage()});
                    }
                    x.i("MicroMsg.Voip.CaptureRender", "Camera ok, fps: %d, mSize.width: %d, mSize.height: %d, format: %d, IsRotate180: %d, displayOrientation: %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(this.ssV.width), Integer.valueOf(this.ssV.height), Integer.valueOf(this.ssW), Integer.valueOf(i.suT), Integer.valueOf(this.stj)});
                    return 1;
                }
            } catch (Exception e4) {
                e22 = e4;
                x.e("MicroMsg.Voip.CaptureRender", "getCameraResolution failed: %s", new Object[]{e22.getMessage()});
                size2 = size3;
                if (obj != null) {
                    a = a(this.ssT, size.width, size.height);
                    x.i("MicroMsg.Voip.CaptureRender", "1.try config size first! w" + size.width + ",h" + size.height);
                    x.e("MicroMsg.Voip.CaptureRender", "1.try config size failed!,try support size: w" + size2.width + ",h" + size2.height);
                    if (a(this.ssT, size2.width, size2.height)) {
                        x.e("MicroMsg.Voip.CaptureRender", "1.try support size fail: w" + size2.width + ",h" + size2.height);
                        return -1;
                    }
                }
                x.i("MicroMsg.Voip.CaptureRender", "2.no config size!");
                if (size2 != null) {
                    x.i("MicroMsg.Voip.CaptureRender", "2.try support size alternatively! w" + size2.width + ",h" + size2.height);
                    if (a(this.ssT, size2.width, size2.height)) {
                        x.e("MicroMsg.Voip.CaptureRender", "2.try support size fail: w" + size2.width + ",h" + size2.height);
                        return -1;
                    }
                }
                g(this.ssT);
                this.ssU = this.ssT.getParameters();
                this.ssV = this.ssU.getPreviewSize();
                i4 = this.ssU.getPreviewFrameRate();
                this.ssW = i.suV;
                if (this.ssW <= 0) {
                    this.ssW = 7;
                }
                camera = this.ssT;
                cameraInfo = new CameraInfo();
                if (this.ssL) {
                }
                Camera.getCameraInfo(this.ssL ? i.suS : i.suR, cameraInfo);
                i3 = 0;
                switch (((WindowManager) ac.getContext().getSystemService("window")).getDefaultDisplay().getRotation()) {
                    case 0:
                        i3 = 0;
                        break;
                    case 1:
                        i3 = 90;
                        break;
                    case 2:
                        i3 = 180;
                        break;
                    case 3:
                        i3 = 270;
                        break;
                }
                if (this.ssL) {
                }
                camera.setDisplayOrientation(i3);
                this.stj = i3;
                x.i("MicroMsg.Voip.CaptureRender", "Camera ok, fps: %d, mSize.width: %d, mSize.height: %d, format: %d, IsRotate180: %d, displayOrientation: %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(this.ssV.width), Integer.valueOf(this.ssV.height), Integer.valueOf(this.ssW), Integer.valueOf(i.suT), Integer.valueOf(this.stj)});
                return 1;
            }
            if (obj != null) {
                a = a(this.ssT, size.width, size.height);
                x.i("MicroMsg.Voip.CaptureRender", "1.try config size first! w" + size.width + ",h" + size.height);
                if (!(a || size2 == null)) {
                    x.e("MicroMsg.Voip.CaptureRender", "1.try config size failed!,try support size: w" + size2.width + ",h" + size2.height);
                    if (a(this.ssT, size2.width, size2.height)) {
                        x.e("MicroMsg.Voip.CaptureRender", "1.try support size fail: w" + size2.width + ",h" + size2.height);
                        return -1;
                    }
                }
            }
            x.i("MicroMsg.Voip.CaptureRender", "2.no config size!");
            if (size2 != null) {
                x.i("MicroMsg.Voip.CaptureRender", "2.try support size alternatively! w" + size2.width + ",h" + size2.height);
                if (a(this.ssT, size2.width, size2.height)) {
                    x.e("MicroMsg.Voip.CaptureRender", "2.try support size fail: w" + size2.width + ",h" + size2.height);
                    return -1;
                }
            }
            g(this.ssT);
            try {
                this.ssU = this.ssT.getParameters();
                this.ssV = this.ssU.getPreviewSize();
                i4 = this.ssU.getPreviewFrameRate();
                this.ssW = i.suV;
                if (this.ssW <= 0) {
                    this.ssW = 7;
                }
                camera = this.ssT;
                cameraInfo = new CameraInfo();
                if (this.ssL) {
                }
                Camera.getCameraInfo(this.ssL ? i.suS : i.suR, cameraInfo);
                i3 = 0;
                switch (((WindowManager) ac.getContext().getSystemService("window")).getDefaultDisplay().getRotation()) {
                    case 0:
                        i3 = 0;
                        break;
                    case 1:
                        i3 = 90;
                        break;
                    case 2:
                        i3 = 180;
                        break;
                    case 3:
                        i3 = 270;
                        break;
                }
                if (this.ssL) {
                }
                camera.setDisplayOrientation(i3);
                this.stj = i3;
                x.i("MicroMsg.Voip.CaptureRender", "Camera ok, fps: %d, mSize.width: %d, mSize.height: %d, format: %d, IsRotate180: %d, displayOrientation: %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(this.ssV.width), Integer.valueOf(this.ssV.height), Integer.valueOf(this.ssW), Integer.valueOf(i.suT), Integer.valueOf(this.stj)});
                return 1;
            } catch (Exception e222) {
                g.pQN.a(159, 0, 1, false);
                x.e("MicroMsg.Voip.CaptureRender", "try getParameters and getPreviewSize fail, error:%s", new Object[]{e222.getMessage()});
                return -1;
            }
        } catch (Exception e2222) {
            g.pQN.a(159, 0, 1, false);
            x.e("MicroMsg.Voip.CaptureRender", "Camera open failed, error:%s", new Object[]{e2222.getMessage()});
            if (this.stc != null) {
                this.stc.bdd();
            }
            return -1;
        }
    }

    public final void bIu() {
        if (i.suQ.gDQ < 2) {
            x.e("MicroMsg.Voip.CaptureRender", "ExchangeCapture...gCameraNum= " + i.suQ.gDQ);
            return;
        }
        x.i("MicroMsg.Voip.CaptureRender", "ExchangeCapture start, gCameraNum= " + i.suQ.gDQ);
        bIw();
        a(this.stc, !this.ssL);
        bIv();
        d.bGj().yH(this.ssS);
        this.sti = true;
    }

    public final int bIv() {
        if (!this.ssX) {
            x.e("MicroMsg.Voip.CaptureRender", "StartCapture: failed without open camera");
            this.ssS = 1;
            return -1;
        } else if (this.std) {
            x.e("MicroMsg.Voip.CaptureRender", "StartCapture: is in capture already ");
            return -1;
        } else if (this.sta == null || this.sta.bFD()) {
            x.d("MicroMsg.Voip.CaptureRender", "StartCapture now, isUesSurfacePreivew: %b", new Object[]{Boolean.valueOf(this.ssZ)});
            if (this.sta != null && this.ssZ) {
                try {
                    this.ssT.setPreviewDisplay(this.sta.getSurfaceHolder());
                } catch (Exception e) {
                    g.pQN.a(159, 0, 1, false);
                    g.pQN.a(159, 2, 1, false);
                    this.ssS = 1;
                    x.e("MicroMsg.Voip.CaptureRender", "StartCapture:error:" + e.toString());
                }
            } else if (!(this.stb == null || this.ssZ)) {
                try {
                    this.ssT.setPreviewTexture(this.stb.getSurfaceTexture());
                } catch (Exception e2) {
                    g.pQN.a(159, 0, 1, false);
                    g.pQN.a(159, 2, 1, false);
                    this.ssS = 1;
                    x.e("MicroMsg.Voip.CaptureRender", "StartCapture:error:" + e2.toString());
                }
            }
            try {
                this.ssT.startPreview();
            } catch (Exception e22) {
                g.pQN.a(159, 0, 1, false);
                g.pQN.a(159, 2, 1, false);
                this.ssS = 1;
                if (this.stc != null) {
                    this.stc.bdd();
                }
                x.e("MicroMsg.Voip.CaptureRender", "startPreview:error" + e22.toString());
            }
            this.std = true;
            return 1;
        } else {
            x.d("MicroMsg.Voip.CaptureRender", "StartCapture:surface not ready, try later.... ");
            this.ste = true;
            return 0;
        }
    }

    public final void bIw() {
        x.d("MicroMsg.Voip.CaptureRender", "StopCapture....mIsInCapture = " + this.std);
        if (this.std) {
            this.ste = false;
            this.ssT.setPreviewCallback(null);
            try {
                this.ssT.stopPreview();
            } catch (Exception e) {
                x.e("MicroMsg.Voip.CaptureRender", "stopPreview:error" + e.toString());
            }
            this.std = false;
        }
        if (1 == this.ssS) {
            com.tencent.mm.sdk.b.b lpVar = new lp();
            lpVar.fDc.type = 2;
            com.tencent.mm.sdk.b.a.xef.m(lpVar);
        }
        x.d("MicroMsg.Voip.CaptureRender", "UnInitCapture....mCameraOpen = " + this.ssX);
        if (this.ssX) {
            this.ssS = 0;
            this.ste = false;
            this.ssT.setPreviewCallback(null);
            this.ssT.release();
            this.ssT = null;
            this.ssX = false;
        } else if (this.ssT != null) {
            this.ssT.release();
            this.ssT = null;
            this.ssX = false;
        }
        this.stf = null;
        if (this.sth != null) {
            this.sth.clear();
        }
        this.sth = null;
        this.ssY = false;
    }

    public static void bIx() {
    }

    @TargetApi(14)
    public final void l(int[] iArr) {
        boolean z = true;
        if (q.gFU.gEw != 1 || !this.ssY) {
            if (q.gFU.gEv > MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                this.ssR = (long) q.gFU.gEv;
            }
            boolean z2;
            boolean z3;
            if (iArr == null) {
                x.e("MicroMsg.Voip.CaptureRender", "focusOnFace error, faceLocation is null");
                z2 = System.currentTimeMillis() - this.ssQ > this.ssR;
                if (!this.ssN || z2 || this.ssO != this.ssL) {
                    String str = "MicroMsg.Voip.CaptureRender";
                    StringBuilder stringBuilder = new StringBuilder("now i need autoFocus! and !mIsCameraNoParamAutoFocus: ");
                    if (this.ssN) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    StringBuilder append = stringBuilder.append(z3).append(",isAutoFocusTimeout: ").append(z2).append(",mAutoFocusTimeOut:").append(this.ssR).append(",mIsLastAutoFocusFaceCamera != mIsCurrentFaceCamera :");
                    if (this.ssO == this.ssL) {
                        z = false;
                    }
                    x.i(str, append.append(z).append(",isClickScreen :false").toString());
                    try {
                        if (this.ssT != null && this.ssT.getParameters() != null && this.ssT.getParameters().getFocusMode() != null && this.ssT.getParameters().getFocusMode().equals("auto")) {
                            this.ssT.autoFocus(null);
                            this.stg = null;
                            this.ssQ = System.currentTimeMillis();
                            this.ssN = true;
                            this.ssO = this.ssL;
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        x.e("MicroMsg.Voip.CaptureRender", "mCamera.getParameters() or autoFocus fail!" + e.toString());
                        return;
                    }
                }
                return;
            }
            Rect rect;
            Parameters parameters;
            if (this.stg == null) {
                this.stg = iArr;
                z2 = true;
            } else {
                z2 = false;
            }
            int[] iArr2 = this.stg;
            int abs = Math.abs(iArr2[3] - iArr[3]) + ((Math.abs(iArr2[0] - iArr[0]) + Math.abs(iArr2[1] - iArr[1])) + Math.abs(iArr2[2] - iArr[2]));
            x.d("MicroMsg.Voip.CaptureRender", "face location diff:%d", new Object[]{Integer.valueOf(abs)});
            if (abs > ssK || abs > ssJ) {
                this.stg = iArr;
                if (abs > ssK) {
                    z2 = true;
                }
                if (abs > ssJ) {
                    z3 = true;
                    if (!z2 || z3) {
                        List arrayList;
                        rect = new Rect(this.stg[0], this.stg[1], this.stg[2], this.stg[3]);
                        parameters = this.ssT.getParameters();
                        if (z3) {
                            if (com.tencent.mm.compatible.util.d.fM(14) || parameters.getMaxNumMeteringAreas() <= 0) {
                                x.d("MicroMsg.Voip.CaptureRender", "camera not support metering area");
                                z3 = false;
                            } else {
                                arrayList = new ArrayList();
                                arrayList.add(new Area(rect, 1000));
                                parameters.setMeteringAreas(arrayList);
                            }
                        }
                        if (z2) {
                            if (com.tencent.mm.compatible.util.d.fM(14) || parameters.getMaxNumFocusAreas() <= 0) {
                                x.d("MicroMsg.Voip.CaptureRender", "camera not support area focus");
                                z2 = false;
                            } else {
                                arrayList = new ArrayList();
                                arrayList.add(new Area(rect, 1000));
                                parameters.setFocusAreas(arrayList);
                            }
                        }
                        if (z2 || r3) {
                            this.ssT.setParameters(parameters);
                        }
                        if (z2) {
                            x.d("MicroMsg.Voip.CaptureRender", "refocus, mIsFocusOnFace:%b", new Object[]{Boolean.valueOf(this.sti)});
                            if (this.sti) {
                                this.ssN = false;
                                this.sti = false;
                                this.ssT.autoFocus(new 1(this));
                            }
                        }
                    }
                    return;
                }
            }
            z3 = false;
            if (z2) {
            }
            try {
                rect = new Rect(this.stg[0], this.stg[1], this.stg[2], this.stg[3]);
                parameters = this.ssT.getParameters();
                if (z3) {
                    if (com.tencent.mm.compatible.util.d.fM(14)) {
                    }
                    x.d("MicroMsg.Voip.CaptureRender", "camera not support metering area");
                    z3 = false;
                }
                if (z2) {
                    if (com.tencent.mm.compatible.util.d.fM(14)) {
                    }
                    x.d("MicroMsg.Voip.CaptureRender", "camera not support area focus");
                    z2 = false;
                }
                this.ssT.setParameters(parameters);
                if (z2) {
                    x.d("MicroMsg.Voip.CaptureRender", "refocus, mIsFocusOnFace:%b", new Object[]{Boolean.valueOf(this.sti)});
                    if (this.sti) {
                        this.ssN = false;
                        this.sti = false;
                        this.ssT.autoFocus(new 1(this));
                    }
                }
            } catch (Exception e2) {
                x.e("MicroMsg.Voip.CaptureRender", "focusOnFace exception:%s", new Object[]{e2.getMessage()});
            }
        }
    }

    private int h(Camera camera) {
        int i;
        int i2;
        Throwable th;
        if (camera == null) {
            return 0;
        }
        try {
            List<Size> supportedPreviewSizes = camera.getParameters().getSupportedPreviewSizes();
            if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
                i = 0;
            } else {
                i = 0;
                for (Size size : supportedPreviewSizes) {
                    try {
                        x.d("MicroMsg.Voip.CaptureRender", "support Size:" + size.width + "," + size.height);
                        if (i == 0) {
                            this.stk = size.width;
                            this.stl = size.height;
                        }
                        i++;
                    } catch (Throwable e) {
                        Throwable th2 = e;
                        i2 = i;
                        th = th2;
                    }
                }
            }
            List<Integer> supportedPreviewFormats = camera.getParameters().getSupportedPreviewFormats();
            if (!(supportedPreviewFormats == null || supportedPreviewFormats.size() == 0)) {
                for (Integer intValue : supportedPreviewFormats) {
                    x.i("MicroMsg.Voip.CaptureRender", "support Format:" + intValue.intValue());
                }
            }
            return i;
        } catch (Throwable e2) {
            th = e2;
            i2 = 0;
            x.printErrStackTrace("MicroMsg.Voip.CaptureRender", th, "", new Object[0]);
            return i2;
        }
    }

    private static void i(Camera camera) {
        List supportedPreviewFrameRates;
        String str;
        List list = null;
        try {
            supportedPreviewFrameRates = camera.getParameters().getSupportedPreviewFrameRates();
        } catch (Exception e) {
            x.d("MicroMsg.Voip.CaptureRender", "getSupportedPreviewFrameRates:error:" + e.toString());
            supportedPreviewFrameRates = list;
        }
        String str2 = "supportFps:";
        if (supportedPreviewFrameRates != null) {
            str = str2;
            for (int i = 0; i < supportedPreviewFrameRates.size(); i++) {
                str = str + ((Integer) supportedPreviewFrameRates.get(i)).intValue() + ",";
            }
        } else {
            str = str2;
        }
        x.i("MicroMsg.Voip.CaptureRender", str);
    }

    public final boolean bIy() {
        return this.ssL;
    }

    public final boolean bIz() {
        return this.ssM;
    }

    public final int bIA() {
        return this.ssS;
    }

    public final void bIB() {
        try {
            if (this.ssU != null) {
                Size previewSize = this.ssU.getPreviewSize();
                c bIU = com.tencent.mm.plugin.voip_cs.b.b.bIU();
                int i = this.ssX ? 1 : 0;
                this.ssU.getPreviewFrameRate();
                int i2 = this.stk;
                int i3 = this.stl;
                int i4 = previewSize.width;
                int i5 = previewSize.height;
                x.d("MicroMsg.VoipCSReportHelper", "setCameraInfo");
                bIU.swf = i;
                bIU.swb = i2;
                bIU.swc = i3;
                bIU.swd = i4;
                bIU.swe = i5;
            }
        } catch (Exception e) {
            x.e("MicroMsg.Voip.CaptureRender", "getCameraDataForVoipCS failed" + e.getMessage());
        }
    }
}
