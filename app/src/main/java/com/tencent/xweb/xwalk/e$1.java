package com.tencent.xweb.xwalk;

import org.xwalk.core.XWalkUIClient.ConsoleMessageType;

/* synthetic */ class e$1 {
    static final /* synthetic */ int[] AsV = new int[ConsoleMessageType.values().length];

    static {
        try {
            AsV[ConsoleMessageType.DEBUG.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            AsV[ConsoleMessageType.ERROR.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            AsV[ConsoleMessageType.LOG.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            AsV[ConsoleMessageType.INFO.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            AsV[ConsoleMessageType.WARNING.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
