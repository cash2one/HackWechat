package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.content.Context;
import android.view.View;
import com.tencent.mm.bz.a;
import com.tencent.mm.plugin.appbrand.canvas.widget.MCanvasView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MDrawableView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MHardwareAccelerateDrawableView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MSurfaceView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MTextureView;
import com.tencent.mm.plugin.appbrand.dynamic.b.b;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    private static volatile boolean gPb = false;
    private static volatile int iVN = 0;

    public static void initialize() {
        a.post(new 1());
    }

    public static void kb(int i) {
        iVN = i;
        gPb = true;
    }

    public static int adm() {
        return iVN;
    }

    public static View be(Context context) {
        if (!gPb) {
            initialize();
        }
        x.d("MicroMsg.WidgetDrawableViewFactory", "inflate(mode : %d)", new Object[]{Integer.valueOf(iVN)});
        View mTextureView;
        switch (iVN) {
            case 1:
                mTextureView = new MTextureView(context);
                mTextureView.iLm.iKy.iKU = b.abn();
                return mTextureView;
            case 2:
                mTextureView = new MSurfaceView(context);
                mTextureView.iLm.iKy.iKU = b.abn();
                return mTextureView;
            case 3:
                mTextureView = new MCanvasView(context);
                mTextureView.iLm.iKy.iKU = b.abn();
                return mTextureView;
            case 4:
                mTextureView = new MDrawableView(context);
                mTextureView.iLm.iKy.iKU = b.abn();
                return mTextureView;
            default:
                mTextureView = new MHardwareAccelerateDrawableView(context);
                mTextureView.iLm.iKy.iKU = b.abn();
                return mTextureView;
        }
    }

    public static String adn() {
        switch (iVN) {
            case 1:
                return "MTextureView";
            case 2:
                return "MSurfaceView";
            case 3:
                return "MCanvasView";
            case 4:
                return "MDrawableView";
            default:
                return "MHADrawableView";
        }
    }
}
