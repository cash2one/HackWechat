package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.f.a.c;
import com.google.android.exoplayer2.f.c.a;
import com.google.android.exoplayer2.f.g.b;
import com.google.android.exoplayer2.f.g.g;

class g$1 implements g {
    g$1() {
    }

    public final boolean g(Format format) {
        String str = format.adV;
        return "text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str);
    }

    public final e k(Format format) {
        String str = format.adV;
        Object obj = -1;
        switch (str.hashCode()) {
            case -1351681404:
                if (str.equals("application/dvbsubs")) {
                    obj = 9;
                    break;
                }
                break;
            case -1026075066:
                if (str.equals("application/x-mp4-vtt")) {
                    obj = 2;
                    break;
                }
                break;
            case -1004728940:
                if (str.equals("text/vtt")) {
                    obj = null;
                    break;
                }
                break;
            case 691401887:
                if (str.equals("application/x-quicktime-tx3g")) {
                    obj = 5;
                    break;
                }
                break;
            case 822864842:
                if (str.equals("text/x-ssa")) {
                    obj = 1;
                    break;
                }
                break;
            case 930165504:
                if (str.equals("application/x-mp4-cea-608")) {
                    obj = 7;
                    break;
                }
                break;
            case 1566015601:
                if (str.equals("application/cea-608")) {
                    obj = 6;
                    break;
                }
                break;
            case 1566016562:
                if (str.equals("application/cea-708")) {
                    obj = 8;
                    break;
                }
                break;
            case 1668750253:
                if (str.equals("application/x-subrip")) {
                    obj = 4;
                    break;
                }
                break;
            case 1693976202:
                if (str.equals("application/ttml+xml")) {
                    obj = 3;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                return new g();
            case 1:
                return new a(format.adX);
            case 2:
                return new b();
            case 3:
                return new com.google.android.exoplayer2.f.e.a();
            case 4:
                return new com.google.android.exoplayer2.f.d.a();
            case 5:
                return new com.google.android.exoplayer2.f.f.a(format.adX);
            case 6:
            case 7:
                return new com.google.android.exoplayer2.f.a.a(format.adV, format.aem);
            case 8:
                return new c(format.aem);
            case 9:
                return new com.google.android.exoplayer2.f.b.a(format.adX);
            default:
                throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
        }
    }
}
