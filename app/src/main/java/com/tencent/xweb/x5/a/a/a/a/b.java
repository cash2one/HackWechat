package com.tencent.xweb.x5.a.a.a.a;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import org.xwalk.core.Log;

public class b {
    public a Asj;

    public Object onMiscCallBack(String str, Bundle bundle) {
        if (this.Asj != null) {
            return this.Asj.super_onMiscCallBack(str, bundle);
        }
        return null;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
        if (this.Asj != null) {
            return this.Asj.super_onInterceptTouchEvent(motionEvent, view);
        }
        Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent, View view) {
        if (this.Asj != null) {
            return this.Asj.super_onTouchEvent(motionEvent, view);
        }
        Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
        if (this.Asj != null) {
            return this.Asj.super_dispatchTouchEvent(motionEvent, view);
        }
        Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
        return false;
    }

    public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
        if (this.Asj != null) {
            return this.Asj.super_overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z, view);
        }
        Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
        return false;
    }

    public void onScrollChanged(int i, int i2, int i3, int i4, View view) {
        if (this.Asj != null) {
            this.Asj.super_onScrollChanged(i, i2, i3, i4, view);
        } else {
            Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
        }
    }

    public void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
        if (this.Asj != null) {
            this.Asj.super_onOverScrolled(i, i2, z, z2, view);
        } else {
            Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
        }
    }

    public void computeScroll(View view) {
        if (this.Asj != null) {
            this.Asj.super_computeScroll(view);
        }
    }

    public boolean onShowLongClickPopupMenu() {
        if (this.Asj != null) {
            return this.Asj.super_onShowLongClickPopupMenu();
        }
        Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
        return false;
    }

    public boolean shouldDiscardCurrentPage() {
        return false;
    }

    public void hasDiscardCurrentPage(boolean z) {
    }
}
