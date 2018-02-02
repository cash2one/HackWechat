package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.smtt.sdk.WebView;

public class VoIPVideoView extends MMTextureView implements SurfaceTextureListener {
    private static final int[] oJd = new int[]{452984831, 369098751, 268435455, 369098751, 268435455, 184549375, 268435455, 184549375, 100663295};
    private SurfaceTexture aDa;
    private int ioA;
    private int ioz;
    private Paint oJe;
    private int svA = 15;
    private float svB = 0.02f;
    private float svx = 0.4f;
    private int svy = 30;
    private int svz = 30;

    public VoIPVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public VoIPVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        this.oJe = new Paint();
        this.oJe.setColor(WebView.NIGHT_MODE_COLOR);
        this.oJe.setFilterBitmap(true);
        this.oJe.setTextSize(40.0f);
        setSurfaceTextureListener(this);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        String str = "MicroMsg.VoIP.VoIPVideoView";
        String str2 = "onSurfaceTextureAvailable %b %d %d";
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(surfaceTexture != null);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        x.i(str, str2, objArr);
        this.aDa = surfaceTexture;
        this.ioz = i;
        this.ioA = i2;
        cpK();
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z;
        String str = "MicroMsg.VoIP.VoIPVideoView";
        String str2 = "onSurfaceTextureSizeChanged %b %d %d";
        Object[] objArr = new Object[3];
        if (surfaceTexture != null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        x.i(str, str2, objArr);
        this.ioz = i;
        this.ioA = i2;
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        boolean z = true;
        String str = "MicroMsg.VoIP.VoIPVideoView";
        String str2 = "onSurfaceTextureDestroyed %b";
        Object[] objArr = new Object[1];
        if (surfaceTexture == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        this.aDa = null;
        this.ioA = 0;
        this.ioz = 0;
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        boolean z = true;
        String str = "MicroMsg.VoIP.VoIPVideoView";
        String str2 = "onSurfaceTextureUpdated %b";
        Object[] objArr = new Object[1];
        if (surfaceTexture == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.v(str, str2, objArr);
    }
}
