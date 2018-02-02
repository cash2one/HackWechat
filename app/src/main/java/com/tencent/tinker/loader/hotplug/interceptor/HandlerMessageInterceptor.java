package com.tencent.tinker.loader.hotplug.interceptor;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.reflect.Field;

public class HandlerMessageInterceptor extends Interceptor<Callback> {
    private static Field Aki;
    private final Handler Akg;
    private final MessageHandler Akh;

    public interface MessageHandler {
        boolean handleMessage(Message message);
    }

    private static class CallbackWrapper implements Callback, ITinkerHotplugProxy {
        private final MessageHandler Akh;
        private final Callback Akj;
        private volatile boolean Akk = false;

        CallbackWrapper(MessageHandler messageHandler, Callback callback) {
            this.Akh = messageHandler;
            this.Akj = callback;
        }

        public boolean handleMessage(Message message) {
            if (this.Akk) {
                return false;
            }
            boolean handleMessage;
            this.Akk = true;
            this.Akh.handleMessage(message);
            if (this.Akj != null) {
                handleMessage = this.Akj.handleMessage(message);
            } else {
                handleMessage = false;
            }
            this.Akk = false;
            return handleMessage;
        }
    }

    protected final /* synthetic */ Object cA(Object obj) {
        Callback callback = (Callback) obj;
        return (callback == null || !ITinkerHotplugProxy.class.isAssignableFrom(callback.getClass())) ? new CallbackWrapper(this.Akh, callback) : callback;
    }

    protected final /* synthetic */ Object cHd() {
        return (Callback) Aki.get(this.Akg);
    }

    protected final /* synthetic */ void cz(Object obj) {
        Aki.set(this.Akg, (Callback) obj);
    }

    static {
        Aki = null;
        synchronized (HandlerMessageInterceptor.class) {
            if (Aki == null) {
                try {
                    Aki = ShareReflectUtil.d(Handler.class, "mCallback");
                } catch (Throwable th) {
                }
            }
        }
    }

    public HandlerMessageInterceptor(Handler handler, MessageHandler messageHandler) {
        this.Akg = handler;
        this.Akh = messageHandler;
    }
}
