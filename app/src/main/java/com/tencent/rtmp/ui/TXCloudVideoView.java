package com.tencent.rtmp.ui;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.liteav.renderer.a;
import com.tencent.liteav.renderer.d;

public class TXCloudVideoView extends FrameLayout {
    private static final int FOCUS_AREA_SIZE_DP = 70;
    private static final String TAG = "TXCloudVideoView";
    private int mFocusAreaSize;
    private a mFocusIndicatorView;
    private d mGLSurfaceView;
    private a mLogView;
    private TextureView mVideoView;

    public TXCloudVideoView(Context context) {
        this(context, null);
    }

    public TXCloudVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFocusAreaSize = 0;
        this.mLogView = new a(context);
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void addVideoView(d dVar) {
        if (this.mGLSurfaceView != null) {
            removeView(this.mGLSurfaceView);
        }
        this.mGLSurfaceView = dVar;
        addView(this.mGLSurfaceView);
        removeView(this.mLogView);
        addView(this.mLogView);
    }

    public void addVideoView(TextureView textureView) {
        if (this.mVideoView != null) {
            removeView(this.mVideoView);
        }
        this.mVideoView = textureView;
        addView(this.mVideoView);
        removeView(this.mLogView);
        addView(this.mLogView);
    }

    public void removeVideoView() {
        if (this.mVideoView != null) {
            removeView(this.mVideoView);
            this.mVideoView = null;
        }
        if (this.mGLSurfaceView != null) {
            removeView(this.mGLSurfaceView);
            this.mGLSurfaceView = null;
        }
    }

    public void onDestroy() {
    }

    public void setStreamUrl(String str) {
    }

    public TextureView getVideoView() {
        return this.mVideoView;
    }

    public d getGLSurfaceView() {
        return this.mGLSurfaceView;
    }

    public void setUseBeautyView(boolean z) {
    }

    public void enableHardwareDecode(boolean z) {
    }

    public void setRenderMode(int i) {
    }

    public void setRenderRotation(int i) {
    }

    public TextureView getHWVideoView() {
        return this.mVideoView;
    }

    public void setSurfaceTextureListener(SurfaceTextureListener surfaceTextureListener) {
    }

    public void adjustVideoSize() {
    }

    public void clearLastFrame(boolean z) {
        if (z) {
            setVisibility(8);
        }
    }

    public void refreshLastFrame() {
    }

    public void setGLOnTouchListener(OnTouchListener onTouchListener) {
    }

    public void onTouchFocus(int i, int i2) {
        if (this.mGLSurfaceView != null) {
            if (this.mFocusIndicatorView == null) {
                this.mFocusIndicatorView = new a(getContext());
                this.mFocusIndicatorView.setVisibility(0);
                addView(this.mFocusIndicatorView);
            }
            Rect touchRect = getTouchRect(i, i2, this.mGLSurfaceView.getWidth(), this.mGLSurfaceView.getHeight(), 1.0f);
            this.mFocusIndicatorView.a(touchRect.left, touchRect.top, touchRect.right - touchRect.left);
        }
    }

    private Rect getTouchRect(int i, int i2, int i3, int i4, float f) {
        if (this.mFocusAreaSize == 0 && this.mGLSurfaceView != null) {
            this.mFocusAreaSize = (int) ((70.0f * this.mGLSurfaceView.getResources().getDisplayMetrics().density) + 0.5f);
        }
        int intValue = Float.valueOf(((float) this.mFocusAreaSize) * f).intValue();
        int clamp = clamp(i - (intValue / 2), 0, i3 - intValue);
        int clamp2 = clamp(i2 - (intValue / 2), 0, i4 - intValue);
        return new Rect(clamp, clamp2, clamp + intValue, intValue + clamp2);
    }

    private int clamp(int i, int i2, int i3) {
        if (i > i3) {
            return i3;
        }
        if (i < i2) {
            return i2;
        }
        return i;
    }

    public void setMirror(boolean z) {
    }

    public void disableLog(boolean z) {
        this.mLogView.b(z);
    }

    public void showLog(boolean z) {
        this.mLogView.a(z);
    }

    public void clearLog() {
        this.mLogView.a();
    }

    public void setLogText(Bundle bundle, Bundle bundle2, int i) {
        this.mLogView.a(bundle, bundle2, i);
    }

    public void setLogMargin(int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = this.mLogView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams = (FrameLayout.LayoutParams) layoutParams;
        } else {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        }
        layoutParams.leftMargin = a.a(getContext(), (float) i);
        layoutParams.rightMargin = a.a(getContext(), (float) i2);
        layoutParams.topMargin = a.a(getContext(), (float) i3);
        layoutParams.bottomMargin = a.a(getContext(), (float) i4);
        this.mLogView.setLayoutParams(layoutParams);
    }
}
