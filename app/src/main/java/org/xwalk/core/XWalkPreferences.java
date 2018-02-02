package org.xwalk.core;

public class XWalkPreferences {
    public static final String ALLOW_UNIVERSAL_ACCESS_FROM_FILE = "allow-universal-access-from-file";
    public static final String ANIMATABLE_XWALK_VIEW = "animatable-xwalk-view";
    public static final String ENABLE_EXTENSIONS = "enable-extensions";
    public static final String ENABLE_JAVASCRIPT = "enable-javascript";
    public static final String ENABLE_THEME_COLOR = "enable-theme-color";
    public static final String JAVASCRIPT_CAN_OPEN_WINDOW = "javascript-can-open-window";
    public static final String PROFILE_NAME = "profile-name";
    public static final String REMOTE_DEBUGGING = "remote-debugging";
    public static final String SPATIAL_NAVIGATION = "enable-spatial-navigation";
    public static final String SUPPORT_MULTIPLE_WINDOWS = "support-multiple-windows";
    public static final String XWEBSDK_VERSION = "xwebsdk-version";
    public static final String XWEB_VERSION = "xweb-version";
    private static XWalkCoreWrapper coreWrapper;
    private static ReflectMethod getBooleanValueStringMethod = new ReflectMethod(null, "getBooleanValue", new Class[0]);
    private static ReflectMethod getIntegerValueStringMethod = new ReflectMethod(null, "getIntegerValue", new Class[0]);
    private static ReflectMethod getStringValueStringMethod = new ReflectMethod(null, "getStringValue", new Class[0]);
    private static ReflectMethod getValueStringMethod = new ReflectMethod(null, "getValue", new Class[0]);
    private static ReflectMethod setValueStringStringMethod = new ReflectMethod(null, "setValue", new Class[0]);
    private static ReflectMethod setValueStringbooleanMethod = new ReflectMethod(null, "setValue", new Class[0]);
    private static ReflectMethod setValueStringintMethod = new ReflectMethod(null, "setValue", new Class[0]);

    public static void setValue(String str, boolean z) {
        reflectionInit();
        try {
            setValueStringbooleanMethod.invoke(new Object[]{str, Boolean.valueOf(z)});
        } catch (RuntimeException e) {
            if (coreWrapper == null) {
                setValueStringbooleanMethod.setArguments(new Object[]{str, Boolean.valueOf(z)});
                XWalkCoreWrapper.reserveReflectMethod(setValueStringbooleanMethod);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public static void setValue(String str, int i) {
        reflectionInit();
        try {
            setValueStringintMethod.invoke(new Object[]{str, Integer.valueOf(i)});
        } catch (RuntimeException e) {
            if (coreWrapper == null) {
                setValueStringintMethod.setArguments(new Object[]{str, Integer.valueOf(i)});
                XWalkCoreWrapper.reserveReflectMethod(setValueStringintMethod);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public static void setValue(String str, String str2) {
        reflectionInit();
        try {
            setValueStringStringMethod.invoke(new Object[]{str, str2});
        } catch (RuntimeException e) {
            if (coreWrapper == null) {
                setValueStringStringMethod.setArguments(new Object[]{str, str2});
                XWalkCoreWrapper.reserveReflectMethod(setValueStringStringMethod);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public static boolean getValue(String str) {
        reflectionInit();
        try {
            return ((Boolean) getValueStringMethod.invoke(new Object[]{str})).booleanValue();
        } catch (RuntimeException e) {
            if (coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public static boolean getBooleanValue(String str) {
        reflectionInit();
        try {
            return ((Boolean) getBooleanValueStringMethod.invoke(new Object[]{str})).booleanValue();
        } catch (RuntimeException e) {
            if (coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public static int getIntegerValue(String str) {
        reflectionInit();
        try {
            return ((Integer) getIntegerValueStringMethod.invoke(new Object[]{str})).intValue();
        } catch (RuntimeException e) {
            if (coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return 0;
        }
    }

    public static String getStringValue(String str) {
        reflectionInit();
        try {
            return (String) getStringValueStringMethod.invoke(new Object[]{str});
        } catch (RuntimeException e) {
            if (coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    static void reflectionInit() {
        if (coreWrapper == null) {
            XWalkCoreWrapper.initEmbeddedMode();
            XWalkCoreWrapper instance = XWalkCoreWrapper.getInstance();
            coreWrapper = instance;
            if (instance == null) {
                XWalkCoreWrapper.reserveReflectClass(XWalkPreferences.class);
                return;
            }
            Class bridgeClass = coreWrapper.getBridgeClass("XWalkPreferencesBridge");
            setValueStringbooleanMethod.init(null, bridgeClass, "setValue", new Class[]{String.class, Boolean.TYPE});
            setValueStringintMethod.init(null, bridgeClass, "setValue", new Class[]{String.class, Integer.TYPE});
            setValueStringStringMethod.init(null, bridgeClass, "setValue", new Class[]{String.class, String.class});
            getValueStringMethod.init(null, bridgeClass, "getValue", new Class[]{String.class});
            getBooleanValueStringMethod.init(null, bridgeClass, "getBooleanValue", new Class[]{String.class});
            getIntegerValueStringMethod.init(null, bridgeClass, "getIntegerValue", new Class[]{String.class});
            getStringValueStringMethod.init(null, bridgeClass, "getStringValue", new Class[]{String.class});
        }
    }
}
