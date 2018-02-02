package android.support.v4.app;

import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import java.util.List;
import java.util.Map;

final class b {

    public static abstract class a {
        public abstract Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF);

        public abstract View onCreateSnapshotView(Context context, Parcelable parcelable);
    }

    private static class b extends SharedElementCallback {
        private a pc;

        public b(a aVar) {
            this.pc = aVar;
        }

        public final void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
        }

        public final void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
        }

        public final void onRejectSharedElements(List<View> list) {
        }

        public final void onMapSharedElements(List<String> list, Map<String, View> map) {
        }

        public final Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.pc.onCaptureSharedElementSnapshot(view, matrix, rectF);
        }

        public final View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.pc.onCreateSnapshotView(context, parcelable);
        }
    }

    static SharedElementCallback a(a aVar) {
        if (aVar != null) {
            return new b(aVar);
        }
        return null;
    }
}
