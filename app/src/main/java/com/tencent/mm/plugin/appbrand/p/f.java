package com.tencent.mm.plugin.appbrand.p;

import android.graphics.Color;
import android.util.DisplayMetrics;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f {
    private static DisplayMetrics jRI = ac.getContext().getResources().getDisplayMetrics();

    public static int i(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() < 3) {
            return 0;
        }
        if (jSONArray.length() == 3) {
            return Color.rgb(jSONArray.optInt(0) & 255, jSONArray.optInt(1) & 255, jSONArray.optInt(2) & 255);
        }
        return Color.argb(jSONArray.optInt(3) & 255, jSONArray.optInt(0) & 255, jSONArray.optInt(1) & 255, jSONArray.optInt(2) & 255);
    }

    public static int aP(String str, int i) {
        try {
            i = uA(str);
        } catch (Exception e) {
        }
        return i;
    }

    public static int uA(String str) {
        int i = 0;
        if (str == null || str.length() == 0) {
            return i;
        }
        if (str.charAt(i) == '#') {
            long parseLong;
            if (str.length() == 7) {
                parseLong = Long.parseLong(str.substring(1), 16) | -16777216;
            } else if (str.length() != 9) {
                throw new IllegalArgumentException("Unknown color");
            } else {
                parseLong = Long.parseLong(str.substring(1, 7), 16) | (Long.parseLong(str.substring(7, 9), 16) << 24);
            }
            return (int) parseLong;
        }
        try {
            return Color.parseColor(str);
        } catch (IllegalArgumentException e) {
            return i;
        }
    }

    public static int lH(int i) {
        return jRI == null ? i : (int) (((float) i) / jRI.density);
    }

    public static float ab(float f) {
        return jRI == null ? f : f / jRI.density;
    }

    public static int lI(int i) {
        return jRI == null ? i : (int) (jRI.density * ((float) i));
    }

    public static float ac(float f) {
        return jRI == null ? f : f * jRI.density;
    }

    public static int b(JSONObject jSONObject, String str) {
        return a(jSONObject, str, 0);
    }

    public static int a(JSONObject jSONObject, String str, int i) {
        if (jSONObject != null) {
            try {
                i = Math.round(ac((float) jSONObject.getDouble(str)));
            } catch (Exception e) {
            }
        }
        return i;
    }

    public static int c(JSONObject jSONObject, String str) {
        return Math.round(ac((float) jSONObject.getDouble(str)));
    }

    public static float d(JSONObject jSONObject, String str) {
        return a(jSONObject, str, 0.0f);
    }

    public static float a(JSONObject jSONObject, String str, float f) {
        if (jSONObject != null) {
            try {
                f = ac((float) jSONObject.optDouble(str, (double) f));
            } catch (Exception e) {
            }
        }
        return f;
    }

    public static int a(JSONArray jSONArray, int i) {
        return b(jSONArray, i);
    }

    private static int b(JSONArray jSONArray, int i) {
        int i2 = 0;
        if (jSONArray != null) {
            try {
                i2 = Math.round(ac((float) jSONArray.getDouble(i)));
            } catch (Exception e) {
            }
        }
        return i2;
    }

    public static int j(JSONArray jSONArray) {
        return Math.round(ac((float) jSONArray.getDouble(0)));
    }

    public static float e(JSONObject jSONObject, String str) {
        return ac((float) jSONObject.getDouble(str));
    }

    public static float c(JSONArray jSONArray, int i) {
        return ac((float) jSONArray.getDouble(i));
    }

    public static float d(JSONArray jSONArray, int i) {
        return e(jSONArray, i);
    }

    private static float e(JSONArray jSONArray, int i) {
        float f = 0.0f;
        if (jSONArray != null) {
            try {
                f = ac((float) jSONArray.getDouble(i));
            } catch (Exception e) {
            }
        }
        return f;
    }

    public static float alE() {
        if (jRI == null) {
            return 1.0f;
        }
        return jRI.density;
    }
}
