package com.tencent.mapsdk.rastercore.d;

import android.os.Handler;
import android.util.DisplayMetrics;
import com.tencent.mapsdk.rastercore.tile.MapTile$MapSource;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public /* synthetic */ class a$1 {
    protected float a = 0.9f;
    protected int b = 0;
    final Handler c = new d(this);
    private MapTile$MapSource d = MapTile$MapSource.TENCENT;
    private int e = 256;
    private boolean f = true;
    private boolean g = true;
    private boolean h = false;
    private boolean i = true;
    private int j = 0;
    private int k = 0;
    private e l;

    protected a$1(e eVar) {
        this.l = eVar;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        int i = e.a().getResources().getDisplayMetrics().densityDpi;
        if (i <= 120) {
            this.b = 1;
            this.a = 0.5f;
        } else if (i <= JsApiSetBackgroundAudioState.CTRL_INDEX) {
            this.b = 2;
            this.a = 0.8f;
        } else if (i <= 240) {
            this.b = 3;
            this.a = 0.87f;
        } else if (i <= 320) {
            this.a = 1.0f;
            this.b = 4;
        } else if (i <= 480) {
            this.a = DownloadHelper.SAVE_FATOR;
            this.b = 5;
        } else {
            this.a = 1.8f;
            this.b = 6;
        }
    }

    public int a() {
        return this.b;
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(MapTile$MapSource mapTile$MapSource) {
        this.d = mapTile$MapSource;
        this.l.p();
    }

    public void a(boolean z) {
        this.h = z;
        this.c.obtainMessage(1).sendToTarget();
    }

    public float b() {
        return this.a;
    }

    public void b(int i) {
        this.j = i;
        this.l.b(i);
    }

    public void b(boolean z) {
        this.f = z;
    }

    public MapTile$MapSource c() {
        return this.d;
    }

    public void c(int i) {
        this.k = i;
        this.l.c(i);
    }

    public void c(boolean z) {
        this.g = z;
    }

    public int d() {
        return this.e;
    }

    public void d(boolean z) {
        c(z);
        b(z);
    }

    public void e(boolean z) {
        this.i = z;
    }

    public boolean e() {
        return this.d == MapTile$MapSource.BING;
    }

    public int f() {
        return this.k;
    }

    public boolean g() {
        return this.h;
    }

    public boolean h() {
        return this.f;
    }

    public boolean i() {
        return this.g;
    }

    public int j() {
        return this.j;
    }

    public boolean k() {
        return this.i;
    }
}
