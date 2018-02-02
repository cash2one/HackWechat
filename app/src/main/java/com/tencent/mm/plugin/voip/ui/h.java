package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;

public final class h extends BaseSmallView {
    private TextView lUD = ((TextView) findViewById(R.h.cYl));

    public h(Context context) {
        super(context, null);
        LayoutInflater.from(context).inflate(R.i.dtP, this);
    }

    public final void MF(String str) {
        this.lUD.setTextSize(1, 14.0f);
        this.lUD.setText(str);
    }

    public final void ME(String str) {
        this.lUD.setTextSize(1, 12.0f);
        this.lUD.setText(str);
    }

    public final void a(CaptureView captureView) {
    }

    protected final void bIj() {
    }

    protected final void bIk() {
    }

    protected final void onAnimationEnd() {
    }
}
