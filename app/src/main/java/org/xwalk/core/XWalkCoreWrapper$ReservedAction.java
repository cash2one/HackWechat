package org.xwalk.core;

import java.util.Arrays;

class XWalkCoreWrapper$ReservedAction {
    Object[] mArguments;
    Class<?> mClass;
    ReflectMethod mMethod;
    Object mObject;

    XWalkCoreWrapper$ReservedAction(Object obj) {
        this.mObject = obj;
    }

    XWalkCoreWrapper$ReservedAction(Class<?> cls) {
        this.mClass = cls;
    }

    XWalkCoreWrapper$ReservedAction(ReflectMethod reflectMethod) {
        this.mMethod = reflectMethod;
        if (reflectMethod.getArguments() != null) {
            this.mArguments = Arrays.copyOf(reflectMethod.getArguments(), reflectMethod.getArguments().length);
        }
    }
}
