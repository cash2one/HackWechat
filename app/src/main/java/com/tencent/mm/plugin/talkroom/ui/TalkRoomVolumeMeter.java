package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.R;
import com.tencent.smtt.sdk.WebView;

public class TalkRoomVolumeMeter extends FrameLayout {
    a scY;
    private ImageView scZ;
    private ImageView sda;
    private ImageView sdb;
    private FrameLayout sdc;

    public TalkRoomVolumeMeter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    public TalkRoomVolumeMeter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    private void initView() {
        this.scY = new a(this, getContext());
        this.scZ = new ImageView(getContext());
        this.scZ.setScaleType(ScaleType.FIT_XY);
        this.scZ.setImageResource(R.g.bGR);
        this.scZ.setVisibility(0);
        this.sda = new ImageView(getContext());
        this.sda.setScaleType(ScaleType.FIT_CENTER);
        this.sda.setImageResource(R.g.bGQ);
        this.sda.setVisibility(8);
        this.sdb = new ImageView(getContext());
        this.sdb.setScaleType(ScaleType.FIT_CENTER);
        this.sdb.setImageResource(R.g.bGN);
        this.sdb.setVisibility(8);
        this.sdc = new FrameLayout(getContext());
        this.sdc.addView(this.scY);
        this.sdc.addView(this.sda);
        this.sdc.setVisibility(8);
        addView(this.sdc);
        addView(this.sdb);
        addView(this.scZ);
        setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        bringChildToFront(this.scZ);
    }

    public final void iW(boolean z) {
        this.sdc.setVisibility(z ? 0 : 8);
        if (z) {
            a aVar = this.scY;
            if (!aVar.started) {
                aVar.started = true;
                aVar.sdm.J(100, 100);
                return;
            }
            return;
        }
        a aVar2 = this.scY;
        if (aVar2.started) {
            aVar2.started = false;
            if (aVar2.sdp >= aVar2.sdd && aVar2.sdp <= aVar2.sde && aVar2.sdh != null && aVar2.sdg != null) {
                Canvas lockCanvas = aVar2.sdf.lockCanvas();
                if (!(lockCanvas == null || aVar2.sdj == null)) {
                    lockCanvas.setDrawFilter(aVar2.sdq);
                    aVar2.sdj.set(0, 0, aVar2.sdl, aVar2.sdk + 0);
                    lockCanvas.drawBitmap(aVar2.sdr ? aVar2.sdh : aVar2.sdg, null, aVar2.sdj, aVar2.iYm);
                    aVar2.sdf.unlockCanvasAndPost(lockCanvas);
                }
            }
            aVar2.sdm.TG();
        }
    }
}
