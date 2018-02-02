package org.xwalk.core;

public class XWalkViewDatabase {
    private static ReflectMethod clearFormDataMethod = new ReflectMethod(null, "clearFormData", new Class[0]);
    private static XWalkCoreWrapper coreWrapper;
    private static ReflectMethod hasFormDataMethod = new ReflectMethod(null, "hasFormData", new Class[0]);

    public static boolean hasFormData() {
        reflectionInit();
        try {
            return ((Boolean) hasFormDataMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public static void clearFormData() {
        reflectionInit();
        try {
            clearFormDataMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (coreWrapper == null) {
                clearFormDataMethod.setArguments(new Object[0]);
                XWalkCoreWrapper.reserveReflectMethod(clearFormDataMethod);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    static void reflectionInit() {
        if (coreWrapper == null) {
            XWalkCoreWrapper.initEmbeddedMode();
            XWalkCoreWrapper instance = XWalkCoreWrapper.getInstance();
            coreWrapper = instance;
            if (instance == null) {
                XWalkCoreWrapper.reserveReflectClass(XWalkViewDatabase.class);
                return;
            }
            Class bridgeClass = coreWrapper.getBridgeClass("XWalkViewDatabaseBridge");
            hasFormDataMethod.init(null, bridgeClass, "hasFormData", new Class[0]);
            clearFormDataMethod.init(null, bridgeClass, "clearFormData", new Class[0]);
        }
    }
}
