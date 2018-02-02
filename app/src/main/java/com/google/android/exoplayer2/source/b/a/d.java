package com.google.android.exoplayer2.source.b.a;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.d.b;
import com.google.android.exoplayer2.h.s.a;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.source.n;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ai;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.az;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.j;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class d implements a<c> {
    private static final Pattern auY = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    private static final Pattern auZ = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    private static final Pattern ava = Pattern.compile("CODECS=\"(.+?)\"");
    private static final Pattern avb = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    private static final Pattern avc = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    private static final Pattern avd = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    private static final Pattern ave = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    private static final Pattern avf = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    private static final Pattern avh = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    private static final Pattern avi = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    private static final Pattern avj = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    private static final Pattern avk = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    private static final Pattern avl = Pattern.compile("METHOD=(NONE|AES-128)");
    private static final Pattern avm = Pattern.compile("URI=\"(.+?)\"");
    private static final Pattern avn = Pattern.compile("IV=([^,.*]+)");
    private static final Pattern avo = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final Pattern avp = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern avq = Pattern.compile("NAME=\"(.+?)\"");
    private static final Pattern avr = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    private static final Pattern avs = R("AUTOSELECT");
    private static final Pattern avt = R("DEFAULT");
    private static final Pattern avu = R("FORCED");

    public final /* synthetic */ Object b(Uri uri, InputStream inputStream) {
        return a(uri, inputStream);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static c a(Uri uri, InputStream inputStream) {
        Closeable bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        Queue linkedList = new LinkedList();
        if (a(bufferedReader)) {
            String readLine;
            c b;
            while (true) {
                readLine = bufferedReader.readLine();
                if (readLine != null) {
                    readLine = readLine.trim();
                    if (!readLine.isEmpty()) {
                        if (readLine.startsWith("#EXT-X-STREAM-INF")) {
                            break;
                        }
                        try {
                            if (readLine.startsWith("#EXT-X-TARGETDURATION") || readLine.startsWith("#EXT-X-MEDIA-SEQUENCE") || readLine.startsWith("#EXTINF") || readLine.startsWith("#EXT-X-KEY") || readLine.startsWith("#EXT-X-BYTERANGE") || readLine.equals("#EXT-X-DISCONTINUITY") || readLine.equals("#EXT-X-DISCONTINUITY-SEQUENCE") || readLine.equals("#EXT-X-ENDLIST")) {
                                linkedList.add(readLine);
                                b = b(new a(linkedList, bufferedReader), uri.toString());
                            } else {
                                linkedList.add(readLine);
                            }
                        } finally {
                            t.b(bufferedReader);
                        }
                        return b;
                    }
                } else {
                    t.b(bufferedReader);
                    throw new o("Failed to parse the playlist, could not identify any tags.");
                }
            }
            linkedList.add(readLine);
            b = b(new a(linkedList, bufferedReader), uri.toString());
            return b;
        }
        b.e("ExoPlayer", "parse, not the #EXTM3U header, uri:%s, reader:%s", new Object[]{uri.toString(), bufferedReader.readLine()});
        throw new n("Input does not start with the #EXTM3U header.", uri);
    }

    private static boolean a(BufferedReader bufferedReader) {
        int read = bufferedReader.read();
        if (read == ai.CTRL_BYTE) {
            if (bufferedReader.read() != az.CTRL_BYTE || bufferedReader.read() != j.CTRL_BYTE) {
                return false;
            }
            read = bufferedReader.read();
        }
        char a = a(bufferedReader, true, read);
        for (read = 0; read < 7; read++) {
            if (a != "#EXTM3U".charAt(read)) {
                return false;
            }
            a = bufferedReader.read();
        }
        return t.cY(a(bufferedReader, false, a));
    }

    private static int a(BufferedReader bufferedReader, boolean z, int i) {
        while (i != -1 && Character.isWhitespace(i) && (z || !t.cY(i))) {
            i = bufferedReader.read();
        }
        return i;
    }

    private static a a(a aVar, String str) {
        List emptyList;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        List list = null;
        int i = 0;
        Format format = null;
        while (aVar.hasNext()) {
            String next = aVar.next();
            b.i("master ExoPlayer", next, new Object[0]);
            if (next.startsWith("#EXT")) {
                arrayList4.add(next);
            }
            int i2;
            String d;
            String e;
            if (next.startsWith("#EXT-X-MEDIA")) {
                i2 = ((f(next, avu) ? 2 : 0) | (f(next, avt) ? 1 : 0)) | (f(next, avs) ? 4 : 0);
                d = d(next, avm);
                e = e(next, avq);
                String d2 = d(next, avp);
                String e2 = e(next, avo);
                Object obj = -1;
                switch (e2.hashCode()) {
                    case -959297733:
                        if (e2.equals("SUBTITLES")) {
                            obj = 1;
                            break;
                        }
                        break;
                    case -333210994:
                        if (e2.equals("CLOSED-CAPTIONS")) {
                            obj = 2;
                            break;
                        }
                        break;
                    case 62628790:
                        if (e2.equals("AUDIO")) {
                            obj = null;
                            break;
                        }
                        break;
                }
                switch (obj) {
                    case null:
                        Format a = Format.a(e, "application/x-mpegURL", i2, d2);
                        if (d != null) {
                            arrayList2.add(new a.a(d, a));
                            break;
                        }
                        format = a;
                        break;
                    case 1:
                        arrayList3.add(new a.a(d, Format.a(e, "application/x-mpegURL", "text/vtt", i2, d2)));
                        break;
                    case 2:
                        int parseInt;
                        String e3 = e(next, avr);
                        if (e3.startsWith("CC")) {
                            d = "application/cea-608";
                            parseInt = Integer.parseInt(e3.substring(2));
                        } else {
                            d = "application/cea-708";
                            parseInt = Integer.parseInt(e3.substring(7));
                        }
                        if (list == null) {
                            list = new ArrayList();
                        }
                        list.add(Format.a(e, null, d, null, -1, i2, d2, parseInt));
                        break;
                    default:
                        break;
                }
            } else if (next.startsWith("#EXT-X-STREAM-INF")) {
                int i3;
                int b = b(next, auZ);
                e = d(next, auY);
                if (e != null) {
                    b = Integer.parseInt(e);
                }
                d = d(next, ava);
                e = d(next, avb);
                int contains = i | next.contains("CLOSED-CAPTIONS=NONE");
                if (e != null) {
                    String[] split = e.split("x");
                    int parseInt2 = Integer.parseInt(split[0]);
                    int parseInt3 = Integer.parseInt(split[1]);
                    if (parseInt2 <= 0 || parseInt3 <= 0) {
                        parseInt2 = -1;
                        parseInt3 = -1;
                    }
                    i2 = parseInt3;
                    i3 = parseInt2;
                } else {
                    i3 = -1;
                    i2 = -1;
                }
                String next2 = aVar.next();
                if (hashSet.add(next2)) {
                    arrayList.add(new a.a(next2, Format.a(Integer.toString(arrayList.size()), "application/x-mpegURL", d, b, i3, i2)));
                }
                i = contains;
            }
        }
        if (i != 0) {
            emptyList = Collections.emptyList();
        } else {
            emptyList = list;
        }
        return new a(str, arrayList4, arrayList, arrayList2, arrayList3, format, emptyList);
    }

    private static b b(a aVar, String str) {
        List arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        long j = 0;
        long j2 = -1;
        boolean z = false;
        String str2 = null;
        long j3 = 0;
        long j4 = -9223372036854775807L;
        int i = 0;
        long j5 = -9223372036854775807L;
        int i2 = 0;
        int i3 = 0;
        boolean z2 = false;
        String str3 = null;
        b$a com_google_android_exoplayer2_source_b_a_b_a = null;
        int i4 = 1;
        long j6 = 0;
        int i5 = 0;
        boolean z3 = false;
        boolean z4 = false;
        int i6 = 0;
        long j7 = 0;
        while (aVar.hasNext()) {
            String next = aVar.next();
            b.i("ExoPlayer", next, new Object[0]);
            if (next.startsWith("#EXT")) {
                arrayList2.add(next);
            }
            String e;
            int i7;
            if (next.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                e = e(next, ave);
                if ("VOD".equals(e)) {
                    i2 = 1;
                } else {
                    if ("EVENT".equals(e)) {
                        i7 = 2;
                    } else {
                        i7 = i2;
                    }
                    i2 = i7;
                }
            } else if (next.startsWith("#EXT-X-START")) {
                j5 = (long) (c(next, avi) * 1000000.0d);
            } else if (next.startsWith("#EXT-X-MAP")) {
                long parseLong;
                String e2 = e(next, avm);
                e = d(next, avk);
                if (e != null) {
                    r2 = e.split("@");
                    parseLong = Long.parseLong(r2[0]);
                    if (r2.length > 1) {
                        j = Long.parseLong(r2[1]);
                    }
                } else {
                    parseLong = j2;
                }
                b$a com_google_android_exoplayer2_source_b_a_b_a2 = new b$a(e2, j, parseLong);
                j = 0;
                j2 = -1;
                com_google_android_exoplayer2_source_b_a_b_a = com_google_android_exoplayer2_source_b_a_b_a2;
            } else if (next.startsWith("#EXT-X-TARGETDURATION")) {
                j4 = ((long) b(next, avc)) * 1000000;
            } else if (next.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                i7 = b(next, avf);
                i6 = i7;
                i = i7;
            } else if (next.startsWith("#EXT-X-VERSION")) {
                i4 = b(next, avd);
            } else if (next.startsWith("#EXTINF")) {
                j3 = (long) (c(next, avh) * 1000000.0d);
            } else if (next.startsWith("#EXT-X-KEY")) {
                z = "AES-128".equals(e(next, avl));
                if (z) {
                    str2 = e(next, avm);
                    str3 = d(next, avn);
                } else {
                    str2 = null;
                    str3 = null;
                }
            } else if (next.startsWith("#EXT-X-BYTERANGE")) {
                r2 = e(next, avj).split("@");
                j2 = Long.parseLong(r2[0]);
                if (r2.length > 1) {
                    r2 = Long.parseLong(r2[1]);
                } else {
                    r2 = j;
                }
                j = r2;
            } else if (next.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                i3 = Integer.parseInt(next.substring(next.indexOf(58) + 1));
                z2 = true;
            } else if (next.equals("#EXT-X-DISCONTINUITY")) {
                i5++;
            } else if (next.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                if (j6 == 0) {
                    j6 = com.google.android.exoplayer2.b.k(t.aj(next.substring(next.indexOf(58) + 1))) - j7;
                }
            } else if (!next.startsWith("#")) {
                String str4;
                long j8;
                if (!z) {
                    str4 = null;
                } else if (str3 != null) {
                    str4 = str3;
                } else {
                    str4 = Integer.toHexString(i6);
                }
                int i8 = i6 + 1;
                if (j2 == -1) {
                    j8 = 0;
                } else {
                    j8 = j;
                }
                arrayList.add(new b$a(next, j3, i5, j7, z, str2, str4, j8, j2));
                j = j7 + j3;
                if (j2 != -1) {
                    r2 = j8 + j2;
                } else {
                    r2 = j8;
                }
                j2 = -1;
                i6 = i8;
                j7 = j;
                j3 = 0;
                j = r2;
            } else if (next.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                z4 = true;
            } else if (next.equals("#EXT-X-ENDLIST")) {
                z3 = true;
            }
        }
        return new b(i2, str, arrayList2, j5, j6, z2, i3, i, i4, j4, z4, z3, j6 != 0, com_google_android_exoplayer2_source_b_a_b_a, arrayList);
    }

    private static int b(String str, Pattern pattern) {
        return Integer.parseInt(e(str, pattern));
    }

    private static double c(String str, Pattern pattern) {
        return Double.parseDouble(e(str, pattern));
    }

    private static String d(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? matcher.group(1) : null;
    }

    private static String e(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find() && matcher.groupCount() == 1) {
            return matcher.group(1);
        }
        throw new o("Couldn't match " + pattern.pattern() + " in " + str);
    }

    private static boolean f(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1).equals("YES");
        }
        return false;
    }

    private static Pattern R(String str) {
        return Pattern.compile(str + "=(NO|YES" + ")");
    }
}
