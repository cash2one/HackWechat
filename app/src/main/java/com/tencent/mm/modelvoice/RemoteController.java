package com.tencent.mm.modelvoice;

import android.content.ComponentName;
import android.media.AudioManager;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Method;

public final class RemoteController {
    private static Method hWH;
    private static Method hWI;
    private AudioManager hWF;
    private ComponentName hWG;

    static {
        try {
            if (hWH == null) {
                hWH = AudioManager.class.getMethod("registerMediaButtonEventReceiver", new Class[]{ComponentName.class});
            }
            if (hWI == null) {
                hWI = AudioManager.class.getMethod("unregisterMediaButtonEventReceiver", new Class[]{ComponentName.class});
            }
        } catch (NoSuchMethodException e) {
        }
    }

    protected final void finalize() {
        try {
            if (hWI != null) {
                hWI.invoke(this.hWF, new Object[]{this.hWG});
                RemoteControlReceiver.Uv();
            }
        } catch (Throwable e) {
            Throwable th = e;
            Throwable e2 = th.getCause();
            if (e2 instanceof RuntimeException) {
                throw ((RuntimeException) e2);
            } else if (e2 instanceof Error) {
                throw ((Error) e2);
            } else {
                throw new RuntimeException(th);
            }
        } catch (IllegalAccessException e3) {
            x.e("MicroMsg.RemoteControlReceiver", "unexpected " + e3);
        }
        super.finalize();
    }
}
