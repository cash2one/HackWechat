package com.tencent.mm.platformtools;

public class t$a {
    public final String toString() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace == null || stackTrace.length < 4) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 3; i < stackTrace.length; i++) {
            if (stackTrace[i].getClassName().contains("com.tencent.mm")) {
                stringBuilder.append("[");
                stringBuilder.append(stackTrace[i].getClassName().substring(15));
                stringBuilder.append(":");
                stringBuilder.append(stackTrace[i].getMethodName());
                stringBuilder.append("(" + stackTrace[i].getLineNumber() + ")]");
            }
        }
        return stringBuilder.toString();
    }
}
