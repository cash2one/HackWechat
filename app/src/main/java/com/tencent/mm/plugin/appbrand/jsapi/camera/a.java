package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class a {
    boolean jhW;
    boolean jhX;
    HashMap<Integer, AppBrandCameraView> jhY;

    private a() {
        this.jhW = true;
        this.jhX = true;
        this.jhY = new HashMap();
    }

    public final boolean g(Integer num) {
        if (!this.jhY.containsKey(num)) {
            return false;
        }
        ((AppBrandCameraView) this.jhY.remove(num)).release();
        return true;
    }

    public final boolean afY() {
        if (!this.jhW) {
            x.i("MicroMsg.AppBrandCameraMrg", "no camera permission");
        }
        return this.jhW;
    }
}
