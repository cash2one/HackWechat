package com.tencent.mm.bv;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    private static float density = -1.0f;
    private static float gOa = 0.0f;
    private static a xbq = null;
    private static SparseIntArray xbr = new SparseIntArray();

    public interface a {
        int cdT();

        ColorStateList cdU();

        Drawable cdV();

        int cdW();

        String cdX();
    }

    public static int c(Context context, int i) {
        if (xbq != null) {
            return xbq.cdT();
        }
        if (context != null) {
            return context.getResources().getColor(i);
        }
        x.e("MicroMsg.ResourceHelper", "get color, resId %d, but context is null", Integer.valueOf(i));
        return 0;
    }

    public static ColorStateList Z(Context context, int i) {
        if (xbq != null) {
            return xbq.cdU();
        }
        if (context != null) {
            return context.getResources().getColorStateList(i);
        }
        x.e("MicroMsg.ResourceHelper", "get color state list, resId %d, but context is null", Integer.valueOf(i));
        return null;
    }

    public static Drawable b(Context context, int i) {
        if (xbq != null) {
            return xbq.cdV();
        }
        if (context != null) {
            return context.getResources().getDrawable(i);
        }
        x.e("MicroMsg.ResourceHelper", "get drawable, resId %d, but context is null", Integer.valueOf(i));
        return null;
    }

    public static int aa(Context context, int i) {
        float f = 1.625f;
        float f2 = gOa;
        if (f2 <= 1.625f) {
            f = f2;
        }
        int i2;
        if (xbq != null) {
            i2 = xbr.get(i, 0);
            if (i2 == 0) {
                i2 = xbq.cdW();
                xbr.put(i, i2);
            }
            return (int) (f * ((float) i2));
        } else if (context == null) {
            x.e("MicroMsg.ResourceHelper", "get dimension pixel size, resId %d, but context is null", Integer.valueOf(i));
            return 0;
        } else {
            i2 = xbr.get(i, 0);
            if (i2 == 0) {
                i2 = context.getResources().getDimensionPixelSize(i);
                xbr.put(i, i2);
            }
            return (int) (f * ((float) i2));
        }
    }

    public static int ab(Context context, int i) {
        int i2;
        if (xbq != null) {
            i2 = xbr.get(i, 0);
            if (i2 != 0) {
                return i2;
            }
            i2 = xbq.cdW();
            xbr.put(i, i2);
            return i2;
        } else if (context == null) {
            x.e("MicroMsg.ResourceHelper", "get dimension pixel size, resId %d, but context is null", Integer.valueOf(i));
            return 0;
        } else {
            i2 = xbr.get(i, 0);
            if (i2 != 0) {
                return i2;
            }
            i2 = context.getResources().getDimensionPixelSize(i);
            xbr.put(i, i2);
            return i2;
        }
    }

    public static String ac(Context context, int i) {
        if (xbq != null) {
            return xbq.cdX();
        }
        if (context != null) {
            return context.getResources().getString(i);
        }
        x.e("MicroMsg.ResourceHelper", "get string, resId %d, but context is null", Integer.valueOf(i));
        return "";
    }

    public static float getDensity(Context context) {
        if (context == null) {
            context = ac.getContext();
        }
        if (density < 0.0f) {
            density = context.getResources().getDisplayMetrics().density;
        }
        return density;
    }

    public static int fromDPToPix(Context context, int i) {
        return Math.round(getDensity(context) * ((float) i));
    }

    public static int ad(Context context, int i) {
        return Math.round(((float) i) / getDensity(context));
    }

    public static float eu(Context context) {
        if (gOa == 0.0f) {
            if (context == null) {
                gOa = 1.0f;
            } else {
                gOa = context.getSharedPreferences(ac.cfs(), 0).getFloat("text_size_scale_key", 1.0f);
            }
        }
        return gOa;
    }

    public static int ev(Context context) {
        float eu = eu(context);
        if (eu == 0.875f) {
            return 1;
        }
        if (eu == 1.0f) {
            return 2;
        }
        if (eu == 1.125f) {
            return 3;
        }
        if (eu == 1.25f) {
            return 4;
        }
        if (eu == 1.375f) {
            return 5;
        }
        if (eu == 1.625f) {
            return 6;
        }
        if (eu == 1.875f) {
            return 7;
        }
        if (eu == 2.025f) {
            return 8;
        }
        return 2;
    }

    public static float ew(Context context) {
        if (ey(context)) {
            return 1.3f;
        }
        return 1.0f;
    }

    public static float ex(Context context) {
        if (ey(context)) {
            return 1.2f;
        }
        return 1.0f;
    }

    public static void h(Context context, float f) {
        Editor edit = context.getSharedPreferences(ac.cfs(), 0).edit();
        edit.putFloat("text_size_scale_key", f);
        edit.commit();
        gOa = f;
    }

    public static boolean ey(Context context) {
        float eu = eu(context);
        gOa = eu;
        return Float.compare(eu, 1.125f) > 0;
    }

    public static boolean ez(Context context) {
        float eu = eu(context);
        gOa = eu;
        if (eu == 0.875f) {
            return true;
        }
        return false;
    }

    public static int eA(Context context) {
        if (xbq != null) {
            return 0;
        }
        if (context != null) {
            return context.getResources().getDisplayMetrics().widthPixels;
        }
        x.e("MicroMsg.ResourceHelper", "get widthPixels but context is null");
        return 0;
    }

    public static int eB(Context context) {
        if (xbq != null) {
            return 0;
        }
        if (context != null) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }
        x.e("MicroMsg.ResourceHelper", "get heightPixels but context is null");
        return 0;
    }
}
