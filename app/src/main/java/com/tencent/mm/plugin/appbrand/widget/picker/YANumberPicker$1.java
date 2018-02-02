package com.tencent.mm.plugin.appbrand.widget.picker;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class YANumberPicker$1 extends Handler {
    final /* synthetic */ YANumberPicker keT;

    YANumberPicker$1(YANumberPicker yANumberPicker, Looper looper) {
        this.keT = yANumberPicker;
        super(looper);
    }

    public final void handleMessage(Message message) {
        int i = 0;
        switch (message.what) {
            case 1:
                if (YANumberPicker.a(this.keT).isFinished()) {
                    int c;
                    if (YANumberPicker.d(this.keT) != 0) {
                        if (YANumberPicker.b(this.keT) == 0) {
                            YANumberPicker.b(this.keT, 1);
                        }
                        int e;
                        if (YANumberPicker.d(this.keT) < (-YANumberPicker.e(this.keT)) / 2) {
                            e = (int) ((((float) (YANumberPicker.e(this.keT) + YANumberPicker.d(this.keT))) * 300.0f) / ((float) YANumberPicker.e(this.keT)));
                            int i2 = 0;
                            YANumberPicker.a(this.keT).startScroll(0, YANumberPicker.f(this.keT), i2, YANumberPicker.d(this.keT) + YANumberPicker.e(this.keT), e * 3);
                            c = YANumberPicker.c(this.keT, (YANumberPicker.f(this.keT) + YANumberPicker.e(this.keT)) + YANumberPicker.d(this.keT));
                            i = e;
                        } else {
                            e = (int) ((((float) (-YANumberPicker.d(this.keT))) * 300.0f) / ((float) YANumberPicker.e(this.keT)));
                            YANumberPicker.a(this.keT).startScroll(0, YANumberPicker.f(this.keT), 0, YANumberPicker.d(this.keT), e * 3);
                            c = YANumberPicker.c(this.keT, YANumberPicker.f(this.keT) + YANumberPicker.d(this.keT));
                            i = e;
                        }
                        this.keT.postInvalidate();
                    } else {
                        YANumberPicker.b(this.keT, 0);
                        c = YANumberPicker.c(this.keT, YANumberPicker.f(this.keT));
                    }
                    Message c2 = YANumberPicker.c(2, YANumberPicker.g(this.keT), c, message.obj);
                    if (YANumberPicker.h(this.keT)) {
                        YANumberPicker.i(this.keT).sendMessageDelayed(c2, (long) (i * 2));
                        return;
                    } else {
                        YANumberPicker.c(this.keT).sendMessageDelayed(c2, (long) (i * 2));
                        return;
                    }
                }
                if (YANumberPicker.b(this.keT) == 0) {
                    YANumberPicker.b(this.keT, 1);
                }
                YANumberPicker.c(this.keT).sendMessageDelayed(YANumberPicker.c(1, 0, 0, message.obj), 32);
                return;
            case 2:
                YANumberPicker.a(this.keT, message.arg1, message.arg2, message.obj);
                return;
            default:
                return;
        }
    }
}
