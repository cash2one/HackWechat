package com.tencent.mm.accessibility;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class AccessibilityCapture {
    public static final long EVENT_MIN_INTERVAL = 1000;
    private static final String INTERFACE_IACCESSIBILITYMANAGER = "android.view.accessibility.IAccessibilityManager";
    private static final String INTERFACE_IACCESSIBILITYMANAGERCLIENT = "android.view.accessibility.IAccessibilityManagerClient";
    private static final int STATE_FLAG_ACCESSIBILITY_ENABLED = 1;
    private static final String TAG = "MicroMsg.AccessibilityCapture";
    private static Field enableField;
    private static IAccessibilityManagerInvocationHandler iAccessibilityManagerInvocationHandler = null;
    private static Field idField;
    private static long lastEventTime = 0;
    private static int lastEventType = 0;
    private static APIProvider mAPIProvider;
    private static boolean mEnable = false;
    private static boolean mForwardEnable;
    private static AccessibilityManager mManager;
    private static Class<AccessibilityManager> managerClass = AccessibilityManager.class;

    private static class IAccessibilityManagerClientInvocationHandler implements InvocationHandler {
        private IAccessibilityManagerClientInvocationHandler() {
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class[] parameterTypes = method.getParameterTypes();
            if (name.equals("setState") && parameterTypes.length == 1 && parameterTypes[0].equals(Integer.TYPE)) {
                Object obj2 = objArr[0];
                if (obj2 != null && (obj2 instanceof Integer)) {
                    AccessibilityCapture.mAPIProvider.i(AccessibilityCapture.TAG, "setState %d", new Object[]{Integer.valueOf(((Integer) obj2).intValue())});
                    AccessibilityCapture.updateState(r0);
                }
            }
            return null;
        }
    }

    private AccessibilityCapture() {
        throw new UnsupportedOperationException("You should instantiate this class");
    }

    public static boolean isEnable() {
        return mEnable;
    }

    private static void setAccessibilityEnable() {
        Field declaredField;
        if (enableField == null) {
            declaredField = managerClass.getDeclaredField("mIsEnabled");
            enableField = declaredField;
            declaredField.setAccessible(true);
        }
        enableField.set(mManager, Boolean.valueOf(true));
        declaredField = managerClass.getDeclaredField("mService");
        declaredField.setAccessible(true);
        iAccessibilityManagerInvocationHandler = new IAccessibilityManagerInvocationHandler(declaredField.get(mManager), null);
        Class cls = Class.forName(INTERFACE_IACCESSIBILITYMANAGER);
        Object newProxyInstance = Proxy.newProxyInstance(AccessibilityCapture.class.getClassLoader(), new Class[]{cls}, iAccessibilityManagerInvocationHandler);
        try {
            declaredField.set(mManager, newProxyInstance);
            mEnable = true;
            try {
                Class cls2 = Class.forName(INTERFACE_IACCESSIBILITYMANAGERCLIENT);
                int intValue;
                Object invoke;
                if (VERSION.SDK_INT > 17) {
                    declaredField = managerClass.getDeclaredField("mUserId");
                    declaredField.setAccessible(true);
                    intValue = ((Integer) declaredField.get(mManager)).intValue();
                    InvocationHandler iAccessibilityManagerClientInvocationHandler = new IAccessibilityManagerClientInvocationHandler();
                    Object newProxyInstance2 = Proxy.newProxyInstance(AccessibilityCapture.class.getClassLoader(), new Class[]{cls2}, iAccessibilityManagerClientInvocationHandler);
                    invoke = cls.getMethod("addClient", new Class[]{cls2, Integer.TYPE}).invoke(newProxyInstance, new Object[]{newProxyInstance2, Integer.valueOf(intValue)});
                    if (invoke != null && (invoke instanceof Integer)) {
                        mAPIProvider.i(TAG, "api > 17 state: %d", new Object[]{Integer.valueOf(((Integer) invoke).intValue())});
                        updateState(intValue);
                        return;
                    }
                    return;
                }
                InvocationHandler iAccessibilityManagerClientInvocationHandler2 = new IAccessibilityManagerClientInvocationHandler();
                invoke = Proxy.newProxyInstance(AccessibilityCapture.class.getClassLoader(), new Class[]{cls2}, iAccessibilityManagerClientInvocationHandler2);
                invoke = cls.getMethod("addClient", new Class[]{cls2, Integer.TYPE}).invoke(newProxyInstance, new Object[]{invoke});
                if (invoke != null && (invoke instanceof Integer)) {
                    mAPIProvider.i(TAG, "api <= 17 state: %d", new Object[]{Integer.valueOf(((Integer) invoke).intValue())});
                    updateState(intValue);
                }
            } catch (Throwable th) {
                mAPIProvider.printErrStackTrace(TAG, th, "exception:" + th.getMessage(), new Object[0]);
                mForwardEnable = true;
            }
        } catch (Exception e) {
            mAPIProvider.e(TAG, "fail to set IAccessibilityManager proxy", new Object[]{e});
            if (!mForwardEnable) {
                enableField.set(mManager, Boolean.valueOf(false));
            }
            throw new AccessibilityCaptureNotSupportException();
        }
    }

    @TargetApi(16)
    public static void enableAccessibilityCapture(Context context, APIProvider aPIProvider) {
        try {
            Field declaredField;
            mAPIProvider = aPIProvider;
            aPIProvider.d(TAG, "accessibility set up start time: %d", new Object[]{Long.valueOf(SystemClock.elapsedRealtime())});
            if (idField == null) {
                declaredField = View.class.getDeclaredField("mAccessibilityViewId");
                idField = declaredField;
                declaredField.setAccessible(true);
            }
            Class cls = AccessibilityManager.class;
            declaredField = cls.getDeclaredField("sInstance");
            declaredField.setAccessible(true);
            Field declaredField2 = cls.getDeclaredField("mLock");
            declaredField2.setAccessible(true);
            AccessibilityManager accessibilityManager = (AccessibilityManager) declaredField.get(null);
            mManager = accessibilityManager;
            if (accessibilityManager == null) {
                mManager = (AccessibilityManager) cls.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{context.getApplicationContext()});
            }
            Object obj = declaredField2.get(mManager);
            if (obj == null) {
                mAPIProvider.i(TAG, "need to set enable,mLock is null.", new Object[0]);
                setAccessibilityEnable();
            } else {
                mAPIProvider.i(TAG, "need to set enable,mLock is not null.", new Object[0]);
                synchronized (obj) {
                    setAccessibilityEnable();
                }
            }
            mAPIProvider.d(TAG, "accessibility set up end time: %d", new Object[]{Long.valueOf(SystemClock.elapsedRealtime())});
            mAPIProvider.i(TAG, "accessibility enabled", new Object[0]);
        } catch (Throwable th) {
            mAPIProvider.printErrStackTrace(TAG, th, "failed to enable accessibility", new Object[0]);
        }
    }

    private static void notifyListeners(boolean z) {
        try {
            Field declaredField = AccessibilityManager.class.getDeclaredField("mAccessibilityStateChangeListeners");
            declaredField.setAccessible(true);
            Iterator it = ((CopyOnWriteArrayList) declaredField.get(mManager)).iterator();
            while (it.hasNext()) {
                ((AccessibilityStateChangeListener) it.next()).onAccessibilityStateChanged(z);
            }
        } catch (Throwable th) {
        }
    }

    @TargetApi(16)
    public static void disableAccessibilityCapture(Context context) {
        try {
            mAPIProvider.d(TAG, "accessibility set up start time: %d", new Object[]{Long.valueOf(SystemClock.elapsedRealtime())});
            Class cls = AccessibilityManager.class;
            Field declaredField = cls.getDeclaredField("mService");
            declaredField.setAccessible(true);
            Field declaredField2 = cls.getDeclaredField("sInstance");
            declaredField2.setAccessible(true);
            Field declaredField3 = cls.getDeclaredField("mLock");
            declaredField3.setAccessible(true);
            Object obj = (AccessibilityManager) declaredField2.get(null);
            if (obj == null) {
                obj = (AccessibilityManager) cls.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{context.getApplicationContext()});
            }
            Object obj2 = declaredField3.get(mManager);
            Field declaredField4 = cls.getDeclaredField("mIsEnabled");
            declaredField4.setAccessible(true);
            if (obj2 == null) {
                mAPIProvider.i(TAG, "need to set disable,mLock is null.", new Object[0]);
                declaredField4.set(obj, Boolean.valueOf(false));
                if (iAccessibilityManagerInvocationHandler != null) {
                    declaredField.set(obj, iAccessibilityManagerInvocationHandler.getOriginalInstance());
                }
            } else {
                mAPIProvider.i(TAG, "need to set disable,mLock is not null.", new Object[0]);
                synchronized (obj2) {
                    declaredField4.set(obj, Boolean.valueOf(false));
                    if (iAccessibilityManagerInvocationHandler != null) {
                        declaredField.set(obj, iAccessibilityManagerInvocationHandler.getOriginalInstance());
                    }
                }
            }
            mEnable = false;
            mAPIProvider.d(TAG, "accessibility set up end time: %d", new Object[]{Long.valueOf(SystemClock.elapsedRealtime())});
            mAPIProvider.i(TAG, "accessibility disabled", new Object[0]);
        } catch (Throwable th) {
            mAPIProvider.printErrStackTrace(TAG, th, "failed to disable accessibility", new Object[0]);
        }
    }

    private static void post(AccessibilityEvent accessibilityEvent) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        mAPIProvider.d(TAG, "[oneliang]before post event:event time" + accessibilityEvent.getEventTime() + ",elspsed time:" + elapsedRealtime, new Object[0]);
        mAPIProvider.post(new ViewSearchTask(accessibilityEvent, elapsedRealtime), "AccessibilityCapture search event's view");
    }

    private static boolean filter(AccessibilityEvent accessibilityEvent) {
        int i = 1;
        int eventType = accessibilityEvent.getEventType();
        boolean z = eventType == 1 || eventType == 2 || eventType == Downloads.RECV_BUFFER_SIZE || eventType == 4 || eventType == 8192;
        if (VERSION.SDK_INT < 23) {
            return z;
        }
        if (eventType != 8388608) {
            i = 0;
        }
        return z | i;
    }

    private static boolean filterEventMerged(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventTime() - lastEventTime < 1000 && accessibilityEvent.getEventType() == Downloads.RECV_BUFFER_SIZE) {
            return false;
        }
        if (lastEventType == 8192 && accessibilityEvent.getEventType() == 8192) {
            return false;
        }
        lastEventTime = accessibilityEvent.getEventTime();
        lastEventType = accessibilityEvent.getEventType();
        return true;
    }

    private static void logTarget(AccessibilityEvent accessibilityEvent, View view, long j) {
        String str;
        Activity activityOfView = Util.getActivityOfView(view);
        APIProvider aPIProvider = mAPIProvider;
        String str2 = TAG;
        String str3 = "Event: %s, View's id: %s, Activity: %s, Time: %s";
        Object[] objArr = new Object[4];
        objArr[0] = AccessibilityEvent.eventTypeToString(accessibilityEvent.getEventType());
        objArr[1] = Util.getViewIdName(view).trim();
        if (activityOfView == null) {
            str = "unknown";
        } else {
            str = activityOfView.getClass().getName();
        }
        objArr[2] = str;
        objArr[3] = Long.valueOf(accessibilityEvent.getEventTime());
        aPIProvider.i(str2, str3, objArr);
        mAPIProvider.onEvent(new Event(accessibilityEvent, view, activityOfView, j));
    }

    private static void updateState(int i) {
        if ((i & 1) != 0) {
            notifyListeners(true);
            mForwardEnable = true;
            return;
        }
        mForwardEnable = false;
    }
}
