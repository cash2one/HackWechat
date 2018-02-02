package com.tencent.mm.plugin.appbrand.game.c;

import android.content.Context;
import android.os.Looper;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.ak;

public final class c extends AppCompatTextView {
    StringBuilder azu = new StringBuilder(100);
    private long iYu = -1;
    private long iYv = -1;
    private int iYw = 0;
    private float iYx = 60.0f;
    private int iYy = 0;
    private ak ikI = new ak(Looper.getMainLooper(), new 1(this), true);

    public c(Context context) {
        super(context);
        setTextSize(12.0f);
        setTextColor(-65536);
        setFocusable(false);
        setClickable(false);
        setOnClickListener(null);
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c iYz;

            {
                this.iYz = r1;
            }

            public final void onClick(View view) {
                this.iYz.iYx = 60.0f;
            }
        });
        this.ikI.J(500, 500);
    }
}
