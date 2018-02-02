package com.tencent.mm.plugin.facedetect.ui;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public class a$c extends CountDownTimer {
    WeakReference<TextView> mjv = null;
    WeakReference<TextView> mjw = null;
    String mjx = null;
    int mjy = 0;
    int mjz = 0;

    public a$c() {
        super(Long.MAX_VALUE, 500);
    }

    public final void onTick(long j) {
        if (this.mjv == null || this.mjv.get() == null || this.mjw == null || this.mjw.get() == null) {
            x.w("MicroMsg.FaceDetectJumper", "hy: tv ref released");
            cancel();
        } else {
            TextView textView = (TextView) this.mjw.get();
            ((TextView) this.mjv.get()).setText(this.mjx.substring(0, this.mjy));
            textView.setText(this.mjx.substring(this.mjy, this.mjy + (this.mjz % ((this.mjx.length() - this.mjy) + 1))));
        }
        this.mjz++;
    }

    public final void onFinish() {
    }
}
