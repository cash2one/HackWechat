package org.xwalk.core.extension;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.Log;

public class MessageHandler {
    private String TAG = "MessageHandler";
    private Map<String, Handler> mHandlers = new HashMap();

    public MessageHandler(MessageHandler messageHandler) {
        this.mHandlers.putAll(messageHandler.mHandlers);
    }

    public void register(String str, String str2, ReflectionHelper$MemberType reflectionHelper$MemberType, Object obj, ReflectionHelper reflectionHelper) {
        if (this.mHandlers.containsKey(str)) {
            Log.w(this.TAG, "Existing handler for " + str);
            return;
        }
        this.mHandlers.put(str, new Handler(this, str2, reflectionHelper$MemberType, obj, reflectionHelper));
    }

    public void register(String str, String str2, ReflectionHelper$MemberType reflectionHelper$MemberType, Object obj) {
        register(str, str2, reflectionHelper$MemberType, obj, null);
    }

    public void register(String str, String str2, Object obj) {
        register(str, str2, ReflectionHelper$MemberType.JS_METHOD, obj, null);
    }

    public void register(String str, Object obj) {
        register(str, str, ReflectionHelper$MemberType.JS_METHOD, obj, null);
    }

    public Object handleMessage(MessageInfo messageInfo) {
        Exception e;
        String jsName = messageInfo.getJsName();
        Handler handler = (Handler) this.mHandlers.get(jsName);
        if (handler == null || handler.targetObject == null) {
            Log.w(this.TAG, "Cannot find handler for method " + jsName);
            return null;
        }
        Object obj = handler.targetObject;
        if (!messageInfo.getExtension().isAutoJS() || handler.reflection == null) {
            try {
                return obj.getClass().getMethod(handler.javaName, new Class[]{MessageInfo.class}).invoke(obj, new Object[]{messageInfo});
            } catch (SecurityException e2) {
                e = e2;
                Log.e(this.TAG, e.toString());
                return null;
            } catch (InvocationTargetException e3) {
                e = e3;
                Log.e(this.TAG, e.toString());
                return null;
            } catch (NoSuchMethodException e4) {
                e = e4;
                Log.e(this.TAG, e.toString());
                return null;
            } catch (IllegalArgumentException e5) {
                e = e5;
                Log.e(this.TAG, e.toString());
                return null;
            } catch (IllegalAccessException e6) {
                e = e6;
                Log.e(this.TAG, e.toString());
                return null;
            }
        }
        try {
            return handler.reflection.handleMessage(messageInfo, obj);
        } catch (Exception e7) {
            Log.e(this.TAG, e7.toString());
            return null;
        }
    }
}
