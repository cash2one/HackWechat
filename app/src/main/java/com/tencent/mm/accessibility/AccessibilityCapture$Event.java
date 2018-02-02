package com.tencent.mm.accessibility;

import android.app.Activity;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class AccessibilityCapture$Event {
    public final Activity activity;
    public final long elapsedTime;
    public final AccessibilityEvent event;
    public final View view;

    public AccessibilityCapture$Event(AccessibilityEvent accessibilityEvent, View view, Activity activity, long j) {
        this.event = accessibilityEvent;
        this.view = view;
        this.activity = activity;
        this.elapsedTime = j;
    }
}
