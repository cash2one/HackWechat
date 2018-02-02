package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView$e;
import com.tencent.mm.plugin.u.a;
import com.tencent.mm.plugin.u.a.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.MMActivity;

public class MMSightRecordViewTestUI extends MMActivity {
    private int ipt = 720;
    private float ipu = 0.67f;
    private MMSightRecordView jin;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new 1(this));
        this.jin = (MMSightRecordView) findViewById(d.oEJ);
        this.jin.R(this.ipu);
        this.jin.jp(this.ipt);
        this.jin.sK(100000);
        this.jin.oP(e.bnF + "mmsighttest.mp4");
        this.jin.aZS();
        this.jin.aZR();
        this.jin.oqX.Yk();
        this.jin.jq(3);
        this.jin.a(new 2(this));
        this.jin.oqX.startPreview();
        this.jin.oqX.Yc();
        findViewById(d.oEQ).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MMSightRecordViewTestUI oBx;

            {
                this.oBx = r1;
            }

            public final void onClick(View view) {
                this.oBx.jin.a(new MMSightRecordView$e(this) {
                    final /* synthetic */ AnonymousClass3 oBy;

                    {
                        this.oBy = r1;
                    }

                    public final void r(Bitmap bitmap) {
                        if (bitmap != null) {
                            ((ImageView) this.oBy.oBx.findViewById(d.cpk)).setImageBitmap(bitmap);
                        }
                    }

                    public final void agg() {
                    }
                }, true);
            }
        });
        findViewById(d.oEN).setOnClickListener(new 4(this));
        final TextView textView = (TextView) findViewById(d.oEx);
        ag.h(new Runnable(this) {
            final /* synthetic */ MMSightRecordViewTestUI oBx;

            public final void run() {
                textView.setText("");
                textView.append(String.format("picture size: %s, ratio: %s\n", new Object[]{this.oBx.jin.oqX.Ye(), Float.valueOf(((float) Math.min(this.oBx.jin.oqX.Ye().x, this.oBx.jin.oqX.Ye().y)) / ((float) Math.max(this.oBx.jin.oqX.Ye().x, this.oBx.jin.oqX.Ye().y)))}));
                textView.append(String.format("video size: %s, ratio: %s\n", new Object[]{this.oBx.jin.oqX.Yf(), Float.valueOf(((float) Math.min(this.oBx.jin.oqX.Yf().x, this.oBx.jin.oqX.Yf().y)) / ((float) Math.max(this.oBx.jin.oqX.Yf().x, this.oBx.jin.oqX.Yf().y)))}));
                textView.append(String.format("preview size limit: %s\n", new Object[]{Integer.valueOf(this.oBx.ipt)}));
                textView.append(String.format("display ratio: %s\n", new Object[]{Float.valueOf(this.oBx.ipu)}));
                textView.append(String.format("view size: %s, ratio: %s\n", new Object[]{new Point(this.oBx.jin.getWidth(), this.oBx.jin.getHeight()), Float.valueOf(((float) this.oBx.jin.getWidth()) / ((float) this.oBx.jin.getHeight()))}));
            }
        }, 1000);
        findViewById(d.oEP).setOnClickListener(new 6(this));
    }

    protected void onDestroy() {
        super.onDestroy();
        this.jin.oqX.release();
    }

    protected final int getLayoutId() {
        return a.e.oEX;
    }
}
