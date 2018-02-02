package com.tencent.liteav;

import android.graphics.Bitmap;
import com.tencent.liteav.audio.c;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.f.e;

public class f implements Cloneable {
    public float A = 0.0f;
    public float B = 0.0f;
    public float C = -1.0f;
    public boolean D = true;
    public boolean E = false;
    public boolean F = true;
    public int G = 1;
    public boolean H = false;
    public int I = 0;
    public boolean J = false;
    public boolean K = true;
    public int a = 0;
    public int b = 0;
    public int c = 400;
    public int d = 600;
    public int e = 300;
    public int f = 5;
    public boolean g = true;
    public int h = 20;
    public int i = 1;
    public int j = 2;
    public int k = 1;
    public int l = 1;
    public boolean m = true;
    public boolean n = true;
    public int o = 3;
    public int p = 3;
    public int q = c.a;
    public int r = c.b;
    public boolean s = true;
    public Bitmap t = null;
    public int u = 300;
    public int v = 10;
    public int w = 1;
    public Bitmap x = null;
    public int y = 0;
    public int z = 0;

    public boolean a() {
        switch (this.k) {
            case 0:
                this.a = 368;
                this.b = 640;
                return false;
            case 1:
                this.a = 544;
                this.b = 960;
                return false;
            case 2:
                this.a = 720;
                this.b = 1280;
                return false;
            case 3:
                this.a = 640;
                this.b = 368;
                return true;
            case 4:
                this.a = 960;
                this.b = 544;
                return true;
            case 5:
                this.a = 1280;
                this.b = 720;
                return true;
            case 6:
                this.a = 320;
                this.b = 480;
                return false;
            case 7:
                this.a = ar.CTRL_INDEX;
                this.b = 320;
                return false;
            case 8:
                this.a = e.CTRL_INDEX;
                this.b = 480;
                return false;
            case 11:
                this.a = 240;
                this.b = 320;
                return false;
            case 12:
                this.a = 368;
                this.b = 480;
                return false;
            case 13:
                this.a = 480;
                this.b = 640;
                return false;
            case 17:
                this.a = 480;
                this.b = 480;
                return false;
            case 18:
                this.a = e.CTRL_INDEX;
                this.b = e.CTRL_INDEX;
                return false;
            case 19:
                this.a = JsApiSetBackgroundAudioState.CTRL_INDEX;
                this.b = JsApiSetBackgroundAudioState.CTRL_INDEX;
                return false;
            default:
                this.a = 368;
                this.b = 640;
                return false;
        }
    }

    protected Object clone() {
        return (f) super.clone();
    }
}
