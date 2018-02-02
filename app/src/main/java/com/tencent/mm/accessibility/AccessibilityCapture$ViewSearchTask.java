package com.tencent.mm.accessibility;

import android.os.SystemClock;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;
import com.tencent.mm.accessibility.ViewSearchTool.Matcher;
import java.lang.reflect.Field;
import java.util.List;

public class AccessibilityCapture$ViewSearchTask implements Runnable {
    private long elapsedTime = 0;
    private final AccessibilityEvent mEvent;

    public AccessibilityCapture$ViewSearchTask(AccessibilityEvent accessibilityEvent, long j) {
        this.mEvent = accessibilityEvent;
        this.elapsedTime = j;
    }

    private int findAccessibilityId() {
        Field declaredField;
        try {
            declaredField = AccessibilityRecord.class.getDeclaredField("mSourceNodeId");
        } catch (NoSuchFieldException e) {
            declaredField = AccessibilityRecord.class.getDeclaredField("mSourceViewId");
        }
        try {
            declaredField.setAccessible(true);
            return (int) ((Long) declaredField.get(this.mEvent)).longValue();
        } catch (NoSuchFieldException e2) {
            declaredField = AccessibilityNodeInfo.class.getDeclaredField("mSourceNodeId");
            Field declaredField2 = AccessibilityRecord.class.getDeclaredField("mSealed");
            declaredField2.setAccessible(true);
            declaredField2.set(this.mEvent, Boolean.valueOf(true));
            r1 = this.mEvent.getSource();
            AccessibilityNodeInfo source;
            if (source == null) {
                throw new AccessibilityIdNotFoundException();
            }
            declaredField.setAccessible(true);
            return (int) ((Long) declaredField.get(source)).longValue();
        } catch (Throwable e3) {
            throw new AccessibilityIdNotFoundException(e3);
        }
    }

    public void run() {
        if (this.mEvent != null) {
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                AccessibilityCapture.access$800(this.mEvent, searchViewByAccessibilityId(findAccessibilityId()), this.elapsedTime);
                elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
                AccessibilityCapture.access$600().i("MicroMsg.AccessibilityCapture", "analysis event %s, cost %dms", new Object[]{AccessibilityEvent.eventTypeToString(this.mEvent.getEventType()), Long.valueOf(elapsedRealtime)});
                try {
                    this.mEvent.recycle();
                } catch (Throwable th) {
                    AccessibilityCapture.access$600().e("MicroMsg.AccessibilityCapture", "Throw something when recycle event which shouldn't occurs.", new Object[]{th});
                }
            } catch (Throwable th2) {
                AccessibilityCapture.access$600().e("MicroMsg.AccessibilityCapture", "Throw something when recycle event which shouldn't occurs.", new Object[]{th2});
            }
        }
    }

    private View searchViewByAccessibilityId(final int i) {
        try {
            List findView = new ViewSearchTool().findView(new Matcher() {
                public boolean match(View view) {
                    try {
                        if (((Integer) AccessibilityCapture.access$900().get(view)).intValue() == i) {
                            return true;
                        }
                        return false;
                    } catch (IllegalAccessException e) {
                        return false;
                    }
                }
            });
            if (findView != null && findView.size() == 1) {
                return (View) findView.get(0);
            }
        } catch (NoSuchMethodException e) {
        } catch (Exception e2) {
            AccessibilityCapture.access$600().e("MicroMsg.AccessibilityCapture", "exception when find root", new Object[]{e2});
        }
        return null;
    }
}
