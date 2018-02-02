package com.tencent.mm.plugin.mmsight.model;

import android.graphics.Point;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public final class g {
    public static b a(Parameters parameters, Point point, int i, boolean z) {
        return b(parameters, point, i, z);
    }

    public static b b(Parameters parameters, Point point, int i, boolean z) {
        int i2;
        ArrayList arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new a((byte) 0));
        ArrayList arrayList2 = new ArrayList(parameters.getSupportedPictureSizes());
        x.i("MicroMsg.MMSightCameraInfo", "supportedPreviewSizes: %s", new Object[]{d.bh(arrayList)});
        float f = ((float) point.x) / ((float) point.y);
        x.i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s lowerBoundPreView: %s", new Object[]{Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(0)});
        long eY = bh.eY(ac.getContext());
        x.d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", new Object[]{Long.valueOf(eY)});
        b bVar = new b();
        bVar.osL = a(arrayList, point, z, i);
        if (bVar.osL != null) {
            bVar.osM = d.a(point, bVar.osL, z);
            bVar.osN = d.a(point, bVar.osL, z, true);
            i2 = 0;
        } else {
            Point point2 = new Point();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Size size = (Size) it.next();
                point2.x = size.width;
                point2.y = size.height;
                if (point2.x == point2.y) {
                    x.i("MicroMsg.MMSightCameraInfo", "exclude square curSize: %s", new Object[]{point2});
                } else {
                    Point a = d.a(point, point2, z);
                    if (a == null) {
                        x.i("MicroMsg.MMSightCameraInfo", "curSize: %s, can not find crop size", new Object[]{point2});
                    } else {
                        x.i("MicroMsg.MMSightCameraInfo", "preViewPoint: %s --> bestSize %s ", new Object[]{point2, a});
                        bVar.osP = new Point(a.x, a.y);
                        bVar.osO = new Point(point2.x, point2.y);
                        bVar.osQ = d.a(point, point2, z, true);
                        if (Math.min(a.x, a.y) <= i) {
                            if (Math.min(a.x, a.y) < 0) {
                                return null;
                            }
                            bVar.osL = new Point(point2.x, point2.y);
                            bVar.osM = a;
                            bVar.osN = d.a(point, bVar.osL, z, true);
                            x.i("MicroMsg.MMSightCameraInfo", "find bestPreviewSize  %s -> %s findcount %d", new Object[]{r5, a, Integer.valueOf(1)});
                            i2 = 1;
                        }
                    }
                }
            }
            i2 = 0;
        }
        x.i("MicroMsg.MMSightCameraInfo", "final tryFindBestSize prewViewSize %s cropSize %s findcount %d", new Object[]{bVar.osL, bVar.osM, Integer.valueOf(i2)});
        return bVar;
    }

    public static b c(Parameters parameters, Point point, int i, boolean z) {
        ArrayList arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new a((byte) 0));
        ArrayList arrayList2 = new ArrayList(parameters.getSupportedPictureSizes());
        x.i("MicroMsg.MMSightCameraInfo", "supportedPreviewSizes: %s", new Object[]{d.bh(arrayList)});
        float f = ((float) point.x) / ((float) point.y);
        x.i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s", new Object[]{Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(f), Integer.valueOf(i)});
        long eY = bh.eY(ac.getContext());
        x.d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", new Object[]{Long.valueOf(eY)});
        b bVar = new b();
        bVar.osL = a(arrayList, point, z, i);
        if (bVar.osL == null) {
            Point point2 = new Point();
            Math.min(point.x, point.y);
            Math.max(point.x, point.y);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Size size = (Size) it.next();
                point2.x = size.width;
                point2.y = size.height;
                if (point2.x != point2.y && Math.min(point2.x, point2.y) <= i && Math.max(point2.x, point2.y) <= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN && d.b(point, point2, z) != null) {
                    bVar.osL = null;
                    break;
                }
            }
        } else {
            bVar.osM = d.b(point, bVar.osL, z);
            bVar.osN = d.b(point, bVar.osL, z, true);
        }
        x.i("MicroMsg.MMSightCameraInfo", "final tryFindBestSize prewViewSize %s cropSize %s findcount %d with any way", new Object[]{bVar.osL, bVar.osM, Integer.valueOf(0)});
        return bVar;
    }

    private static Point a(ArrayList<Size> arrayList, Point point, boolean z, int i) {
        int i2 = point.x;
        int i3 = point.y;
        if ((i3 * i) % i2 != 0) {
            return null;
        }
        int i4;
        i2 = (i3 * i) / i2;
        if (z) {
            i4 = i ^ i2;
            i3 = i4 ^ i2;
            i2 = i4 ^ i3;
            i4 = i3;
            i3 = i2;
        } else {
            i3 = i;
            i4 = i2;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Size size = (Size) it.next();
            if (size.width == i3 && size.height == i4) {
                x.i("MicroMsg.MMSightCameraInfo", "findEqualsPrewViewSize FindBestSize %d %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
                return new Point(i3, i4);
            } else if (Math.min(size.width, size.height) < i) {
                return null;
            }
        }
        return null;
    }
}
