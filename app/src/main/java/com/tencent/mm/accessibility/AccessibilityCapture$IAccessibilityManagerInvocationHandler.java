package com.tencent.mm.accessibility;

import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class AccessibilityCapture$IAccessibilityManagerInvocationHandler implements InvocationHandler {
    private final Object originalInstance;

    private AccessibilityCapture$IAccessibilityManagerInvocationHandler(Object obj) {
        this.originalInstance = obj;
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        String name = method.getName();
        Class[] parameterTypes = method.getParameterTypes();
        if (name.equals("sendAccessibilityEvent") && parameterTypes.length == 2 && parameterTypes[0].equals(AccessibilityEvent.class) && parameterTypes[1].equals(Integer.TYPE)) {
            Object obj2 = objArr[0];
            if (obj2 == null || !(obj2 instanceof AccessibilityEvent)) {
                return null;
            }
            AccessibilityEvent accessibilityEvent = (AccessibilityEvent) obj2;
            if (AccessibilityCapture.access$200()) {
                if (AccessibilityCapture.access$300(accessibilityEvent) && AccessibilityCapture.access$400(accessibilityEvent)) {
                    AccessibilityCapture.access$500(AccessibilityEvent.obtain(accessibilityEvent));
                }
                return method.invoke(this.originalInstance, objArr);
            } else if (AccessibilityCapture.access$300(accessibilityEvent) && AccessibilityCapture.access$400(accessibilityEvent)) {
                AccessibilityCapture.access$500(accessibilityEvent);
                return Boolean.valueOf(false);
            } else {
                AccessibilityCapture.access$600().v("MicroMsg.AccessibilityCapture", "filter a event: %s", new Object[]{AccessibilityEvent.eventTypeToString(accessibilityEvent.getEventType())});
                return Boolean.valueOf(true);
            }
        }
        AccessibilityCapture.access$600().i("MicroMsg.AccessibilityCapture", "[oneliang]original accessibility instance: %s,method name:%s", new Object[]{this.originalInstance, name});
        return this.originalInstance != null ? method.invoke(this.originalInstance, objArr) : null;
    }

    public Object getOriginalInstance() {
        return this.originalInstance;
    }
}
