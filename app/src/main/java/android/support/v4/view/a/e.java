package android.support.v4.view.a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

final class e {

    static class AnonymousClass1 extends AccessibilityNodeProvider {
        final /* synthetic */ a AB;

        AnonymousClass1(a aVar) {
            this.AB = aVar;
        }

        public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            this.AB.ch();
            return null;
        }

        public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            return this.AB.cf();
        }

        public final boolean performAction(int i, int i2, Bundle bundle) {
            return this.AB.ce();
        }

        public final AccessibilityNodeInfo findFocus(int i) {
            this.AB.ci();
            return null;
        }
    }

    interface a {
        boolean ce();

        List<Object> cf();

        Object ch();

        Object ci();
    }
}
