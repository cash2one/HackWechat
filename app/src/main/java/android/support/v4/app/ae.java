package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.InboxStyle;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.ac.a;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class ae {
    private static final Object sO = new Object();
    private static Field sP;
    private static boolean sQ;
    private static final Object sR = new Object();

    public static void a(y yVar, CharSequence charSequence, boolean z, CharSequence charSequence2, CharSequence charSequence3) {
        BigTextStyle bigText = new BigTextStyle(yVar.bg()).setBigContentTitle(charSequence).bigText(charSequence3);
        if (z) {
            bigText.setSummaryText(charSequence2);
        }
    }

    public static void a(y yVar, CharSequence charSequence, boolean z, CharSequence charSequence2, Bitmap bitmap, Bitmap bitmap2, boolean z2) {
        BigPictureStyle bigPicture = new BigPictureStyle(yVar.bg()).setBigContentTitle(charSequence).bigPicture(bitmap);
        if (z2) {
            bigPicture.bigLargeIcon(bitmap2);
        }
        if (z) {
            bigPicture.setSummaryText(charSequence2);
        }
    }

    public static void a(y yVar, CharSequence charSequence, boolean z, CharSequence charSequence2, ArrayList<CharSequence> arrayList) {
        InboxStyle bigContentTitle = new InboxStyle(yVar.bg()).setBigContentTitle(charSequence);
        if (z) {
            bigContentTitle.setSummaryText(charSequence2);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bigContentTitle.addLine((CharSequence) it.next());
        }
    }

    public static SparseArray<Bundle> f(List<Bundle> list) {
        SparseArray<Bundle> sparseArray = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Bundle bundle = (Bundle) list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle a(Notification notification) {
        synchronized (sO) {
            if (sQ) {
                return null;
            }
            try {
                if (sP == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (Bundle.class.isAssignableFrom(declaredField.getType())) {
                        declaredField.setAccessible(true);
                        sP = declaredField;
                    } else {
                        sQ = true;
                        return null;
                    }
                }
                Bundle bundle = (Bundle) sP.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    sP.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e) {
                sQ = true;
                return null;
            } catch (NoSuchFieldException e2) {
                sQ = true;
                return null;
            }
        }
    }

    public static Bundle b(Builder builder, a aVar) {
        builder.addAction(aVar.getIcon(), aVar.getTitle(), aVar.bi());
        Bundle bundle = new Bundle(aVar.getExtras());
        if (aVar.bj() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", ak.b(aVar.bj()));
        }
        return bundle;
    }
}
