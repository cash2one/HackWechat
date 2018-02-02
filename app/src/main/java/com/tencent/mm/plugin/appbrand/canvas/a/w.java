package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.tencent.mm.plugin.appbrand.canvas.f;
import org.json.JSONArray;
import org.json.JSONException;

public final class w implements d {
    public final String getMethod() {
        return "setGlobalCompositeOperation";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() <= 0) {
            return false;
        }
        try {
            Paint paint = fVar.iKP;
            String string = jSONArray.getString(0);
            boolean z = true;
            switch (string.hashCode()) {
                case -2120744511:
                    if (string.equals("luminosity")) {
                        z = true;
                        break;
                    }
                    break;
                case -1763725041:
                    if (string.equals("destination-out")) {
                        z = true;
                        break;
                    }
                    break;
                case -1698458601:
                    if (string.equals("source-in")) {
                        z = true;
                        break;
                    }
                    break;
                case -1427739212:
                    if (string.equals("hard-light")) {
                        z = true;
                        break;
                    }
                    break;
                case -1338968417:
                    if (string.equals("darken")) {
                        z = true;
                        break;
                    }
                    break;
                case -1247677005:
                    if (string.equals("soft-light")) {
                        z = true;
                        break;
                    }
                    break;
                case -1112602980:
                    if (string.equals("source-out")) {
                        z = true;
                        break;
                    }
                    break;
                case -1091287984:
                    if (string.equals("overlay")) {
                        z = true;
                        break;
                    }
                    break;
                case -230491182:
                    if (string.equals("saturation")) {
                        z = true;
                        break;
                    }
                    break;
                case -131372090:
                    if (string.equals("source-atop")) {
                        z = true;
                        break;
                    }
                    break;
                case -130953402:
                    if (string.equals("source-over")) {
                        z = false;
                        break;
                    }
                    break;
                case -120580883:
                    if (string.equals("color-dodge")) {
                        z = true;
                        break;
                    }
                    break;
                case 103672:
                    if (string.equals("hue")) {
                        z = true;
                        break;
                    }
                    break;
                case 118875:
                    if (string.equals("xor")) {
                        z = true;
                        break;
                    }
                    break;
                case 3059573:
                    if (string.equals("copy")) {
                        z = true;
                        break;
                    }
                    break;
                case 94842723:
                    if (string.equals("color")) {
                        z = true;
                        break;
                    }
                    break;
                case 170546239:
                    if (string.equals("lighten")) {
                        z = true;
                        break;
                    }
                    break;
                case 170546243:
                    if (string.equals("lighter")) {
                        z = true;
                        break;
                    }
                    break;
                case 653829668:
                    if (string.equals("multiply")) {
                        z = true;
                        break;
                    }
                    break;
                case 912936772:
                    if (string.equals("destination-in")) {
                        z = true;
                        break;
                    }
                    break;
                case 1158680499:
                    if (string.equals("destination-atop")) {
                        z = true;
                        break;
                    }
                    break;
                case 1159099187:
                    if (string.equals("destination-over")) {
                        z = true;
                        break;
                    }
                    break;
                case 1242982905:
                    if (string.equals("color-burn")) {
                        z = true;
                        break;
                    }
                    break;
                case 1686617550:
                    if (string.equals("exclusion")) {
                        z = true;
                        break;
                    }
                    break;
                case 1728361789:
                    if (string.equals("difference")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    paint.setXfermode(new PorterDuffXfermode(Mode.SRC_OVER));
                    break;
                case true:
                    paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
                    break;
                case true:
                    paint.setXfermode(new PorterDuffXfermode(Mode.SRC_OUT));
                    break;
                case true:
                    paint.setXfermode(new PorterDuffXfermode(Mode.SRC_ATOP));
                    break;
                case true:
                    paint.setXfermode(new PorterDuffXfermode(Mode.SRC_OVER));
                    break;
                case true:
                    paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
                    break;
                case true:
                    paint.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
                    break;
                case true:
                    paint.setXfermode(new PorterDuffXfermode(Mode.DST_ATOP));
                    break;
                case true:
                    paint.setXfermode(new PorterDuffXfermode(Mode.LIGHTEN));
                    break;
                case true:
                    paint.setXfermode(new PorterDuffXfermode(Mode.ADD));
                    break;
                case true:
                    paint.setXfermode(new PorterDuffXfermode(Mode.XOR));
                    break;
                case true:
                    paint.setXfermode(new PorterDuffXfermode(Mode.MULTIPLY));
                    break;
                case true:
                    paint.setXfermode(new PorterDuffXfermode(Mode.OVERLAY));
                    break;
                case true:
                    paint.setXfermode(new PorterDuffXfermode(Mode.DARKEN));
                    break;
                case true:
                    paint.setXfermode(new PorterDuffXfermode(Mode.LIGHTEN));
                    break;
            }
            return true;
        } catch (JSONException e) {
            return false;
        }
    }
}
