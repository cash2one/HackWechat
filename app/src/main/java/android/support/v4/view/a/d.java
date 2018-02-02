package android.support.v4.view.a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

final class d {

    static class AnonymousClass1 extends AccessibilityNodeProvider {
        final /* synthetic */ a AA;

        AnonymousClass1(a aVar) {
            this.AA = aVar;
        }

        public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            this.AA.ch();
            return null;
        }

        public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            return this.AA.cf();
        }

        public final boolean performAction(int i, int i2, Bundle bundle) {
            return this.AA.ce();
        }
    }

    interface a {
        boolean ce();

        List<Object> cf();

        Object ch();
    }
}
