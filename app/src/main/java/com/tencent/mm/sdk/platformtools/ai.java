package com.tencent.mm.sdk.platformtools;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public final class ai {
    public final String toString() {
        return cfI();
    }

    public static String cfH() {
        try {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace == null || stackTrace.length < 3) {
                return "";
            }
            return (stackTrace[2].getClassName().substring(15) + ":" + stackTrace[2].getMethodName()) + "(" + stackTrace[2].getLineNumber() + ")";
        } catch (Throwable th) {
            x.e("MicroMsg.Util.MMStack", "getCaller e:%s", i(th));
            return "";
        }
    }

    public static String cfI() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace == null || stackTrace.length < 4) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 3;
        while (i < stackTrace.length) {
            if (stackTrace[i].getClassName().contains("com.tencent.mm") && !stackTrace[i].getClassName().contains("sdk.platformtools.Log")) {
                stringBuilder.append("[");
                stringBuilder.append(stackTrace[i].getClassName().substring(15));
                stringBuilder.append(":");
                stringBuilder.append(stackTrace[i].getMethodName());
                stringBuilder.append("(" + stackTrace[i].getLineNumber() + ")]");
            }
            i++;
        }
        return stringBuilder.toString();
    }

    public static String i(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(byteArrayOutputStream);
            th.printStackTrace(printStream);
            String byteArrayOutputStream2 = byteArrayOutputStream.toString();
            printStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream2;
        } catch (Exception e) {
            return "";
        }
    }

    public static String b(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length < 4) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 3;
        while (i < stackTraceElementArr.length) {
            if (stackTraceElementArr[i].getClassName().contains("com.tencent.mm") && !stackTraceElementArr[i].getClassName().contains("sdk.platformtools.Log")) {
                stringBuilder.append("[");
                stringBuilder.append(stackTraceElementArr[i].getClassName().substring(15));
                stringBuilder.append(":");
                stringBuilder.append(stackTraceElementArr[i].getMethodName());
                stringBuilder.append("(" + stackTraceElementArr[i].getLineNumber() + ")]");
            }
            i++;
        }
        return stringBuilder.toString();
    }
}
