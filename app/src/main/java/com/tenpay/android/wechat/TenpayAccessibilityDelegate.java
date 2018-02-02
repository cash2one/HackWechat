package com.tenpay.android.wechat;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.widget.EditText;
import com.tencent.wcdb.FileUtils;
import com.tenpay.bankcard.LogUtil;
import java.lang.reflect.Method;

public class TenpayAccessibilityDelegate extends AccessibilityDelegate {
    public void sendAccessibilityEvent(View view, int i) {
        LogUtil.d("CFT", "sendAccessibilityEvent eventType=" + i);
        if (view != null && i == FileUtils.S_IWUSR) {
            CharSequence contentDescription;
            if (view instanceof EditText) {
                LogUtil.d("CFT", "EditText");
                EditText editText = (EditText) view;
                if (!TextUtils.isEmpty(editText.getContentDescription())) {
                    contentDescription = editText.getContentDescription();
                } else if (editText.getHint() != null) {
                    contentDescription = editText.getHint();
                } else {
                    contentDescription = null;
                }
                if (!TextUtils.isEmpty(contentDescription)) {
                    for (int i2 = 0; i2 < contentDescription.length(); i2++) {
                        TenpayTTSUtil.speak(String.valueOf(contentDescription.charAt(i2)));
                    }
                }
            } else {
                LogUtil.d("CFT", "not EditText");
                contentDescription = view.getContentDescription();
                TenpayTTSUtil.speak(contentDescription);
            }
            LogUtil.d("CFT", "content = " + contentDescription);
            LogUtil.d("CFT", "host.getContentDescription() = " + view.getContentDescription());
            if (!TextUtils.isEmpty(contentDescription)) {
                Class cls = View.class;
                try {
                    Method method = cls.getMethod("clearAccessibilityFocus", null);
                    method.setAccessible(true);
                    method.invoke(view, null);
                    Method method2 = cls.getMethod("requestAccessibilityFocus", null);
                    method2.setAccessible(true);
                    method2.invoke(view, null);
                } catch (Exception e) {
                }
            }
        }
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        return null;
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return false;
    }
}
