package com.tencent.mm.accessibility;

import com.tencent.mm.accessibility.AccessibilityCapture.Event;

public interface AccessibilityCapture$APIProvider {
    void d(String str, String str2, Object... objArr);

    void e(String str, String str2, Object... objArr);

    void i(String str, String str2, Object... objArr);

    void onEvent(Event event);

    void post(Runnable runnable, String str);

    void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

    void v(String str, String str2, Object... objArr);
}
