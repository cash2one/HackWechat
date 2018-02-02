package com.google.android.exoplayer2.e;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.util.Pair;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.i.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
@TargetApi(16)
public final class d {
    private static final a aqf = new a("OMX.google.raw.decoder", null, null, false, false);
    private static final Pattern aqg = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<a, List<a>> aqh = new HashMap();
    private static final SparseIntArray aqi;
    private static final SparseIntArray aqj;
    private static final Map<String, Integer> aqk;
    private static int aql = -1;

    @TargetApi(21)
    private static final class e implements c {
        private final int aqm;
        private MediaCodecInfo[] aqn;

        public e(boolean z) {
            this.aqm = z ? 1 : 0;
        }

        public final int getCodecCount() {
            jS();
            return this.aqn.length;
        }

        public final MediaCodecInfo getCodecInfoAt(int i) {
            jS();
            return this.aqn[i];
        }

        public final boolean jR() {
            return true;
        }

        public final boolean a(String str, CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported("secure-playback");
        }

        private void jS() {
            if (this.aqn == null) {
                this.aqn = new MediaCodecList(this.aqm).getCodecInfos();
            }
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        aqi = sparseIntArray;
        sparseIntArray.put(66, 1);
        aqi.put(77, 2);
        aqi.put(88, 4);
        aqi.put(100, 8);
        sparseIntArray = new SparseIntArray();
        aqj = sparseIntArray;
        sparseIntArray.put(10, 1);
        aqj.put(11, 4);
        aqj.put(12, 8);
        aqj.put(13, 16);
        aqj.put(20, 32);
        aqj.put(21, 64);
        aqj.put(22, FileUtils.S_IWUSR);
        aqj.put(30, 256);
        aqj.put(31, WXMediaMessage.TITLE_LENGTH_LIMIT);
        aqj.put(32, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        aqj.put(40, 2048);
        aqj.put(41, Downloads.RECV_BUFFER_SIZE);
        aqj.put(42, 8192);
        aqj.put(50, 16384);
        aqj.put(51, WXMediaMessage.THUMB_LENGTH_LIMIT);
        aqj.put(52, 65536);
        Map hashMap = new HashMap();
        aqk = hashMap;
        hashMap.put("L30", Integer.valueOf(1));
        aqk.put("L60", Integer.valueOf(4));
        aqk.put("L63", Integer.valueOf(16));
        aqk.put("L90", Integer.valueOf(64));
        aqk.put("L93", Integer.valueOf(256));
        aqk.put("L120", Integer.valueOf(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT));
        aqk.put("L123", Integer.valueOf(Downloads.RECV_BUFFER_SIZE));
        aqk.put("L150", Integer.valueOf(16384));
        aqk.put("L153", Integer.valueOf(65536));
        aqk.put("L156", Integer.valueOf(262144));
        aqk.put("L180", Integer.valueOf(1048576));
        aqk.put("L183", Integer.valueOf(4194304));
        aqk.put("L186", Integer.valueOf(16777216));
        aqk.put("H30", Integer.valueOf(2));
        aqk.put("H60", Integer.valueOf(8));
        aqk.put("H63", Integer.valueOf(32));
        aqk.put("H90", Integer.valueOf(FileUtils.S_IWUSR));
        aqk.put("H93", Integer.valueOf(WXMediaMessage.TITLE_LENGTH_LIMIT));
        aqk.put("H120", Integer.valueOf(2048));
        aqk.put("H123", Integer.valueOf(8192));
        aqk.put("H150", Integer.valueOf(WXMediaMessage.THUMB_LENGTH_LIMIT));
        aqk.put("H153", Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
        aqk.put("H156", Integer.valueOf(SQLiteGlobal.journalSizeLimit));
        aqk.put("H180", Integer.valueOf(2097152));
        aqk.put("H183", Integer.valueOf(8388608));
        aqk.put("H186", Integer.valueOf(33554432));
    }

    public static a jP() {
        return aqf;
    }

    public static a b(String str, boolean z) {
        List c = c(str, z);
        return c.isEmpty() ? null : (a) c.get(0);
    }

    private static synchronized List<a> c(String str, boolean z) {
        List<a> list;
        synchronized (d.class) {
            a aVar = new a(str, z);
            list = (List) aqh.get(aVar);
            if (list == null) {
                List a = a(aVar, t.SDK_INT >= 21 ? new e(z) : new d((byte) 0));
                if (z && a.isEmpty() && 21 <= t.SDK_INT && t.SDK_INT <= 23) {
                    List a2 = a(aVar, new d((byte) 0));
                    if (!a2.isEmpty()) {
                        new StringBuilder("MediaCodecList API didn't list secure decoder for: ").append(str).append(". Assuming: ").append(((a) a2.get(0)).name);
                    }
                    a = a2;
                }
                k(a);
                list = Collections.unmodifiableList(a);
                aqh.put(aVar, list);
            }
        }
        return list;
    }

    public static int jQ() {
        int i = 0;
        if (aql == -1) {
            a b = b("video/avc", false);
            if (b != null) {
                int i2 = 0;
                for (CodecProfileLevel codecProfileLevel : b.jJ()) {
                    switch (codecProfileLevel.level) {
                        case 1:
                            i = 25344;
                            break;
                        case 2:
                            i = 25344;
                            break;
                        case 8:
                            i = 101376;
                            break;
                        case 16:
                            i = 101376;
                            break;
                        case 32:
                            i = 101376;
                            break;
                        case 64:
                            i = 202752;
                            break;
                        case FileUtils.S_IWUSR /*128*/:
                            i = 414720;
                            break;
                        case 256:
                            i = 414720;
                            break;
                        case WXMediaMessage.TITLE_LENGTH_LIMIT /*512*/:
                            i = Downloads.SPLIT_RANGE_SIZE_NET;
                            break;
                        case WXMediaMessage.DESCRIPTION_LENGTH_LIMIT /*1024*/:
                            i = 1310720;
                            break;
                        case 2048:
                            i = 2097152;
                            break;
                        case Downloads.RECV_BUFFER_SIZE /*4096*/:
                            i = 2097152;
                            break;
                        case 8192:
                            i = 2228224;
                            break;
                        case 16384:
                            i = 5652480;
                            break;
                        case WXMediaMessage.THUMB_LENGTH_LIMIT /*32768*/:
                            i = 9437184;
                            break;
                        case 65536:
                            i = 9437184;
                            break;
                        default:
                            i = -1;
                            break;
                    }
                    i2 = Math.max(i, i2);
                }
                i = Math.max(i2, t.SDK_INT >= 21 ? 345600 : 172800);
            }
            aql = i;
        }
        return aql;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Pair<Integer, Integer> Q(String str) {
        int i = 0;
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\.");
        String str2 = split[0];
        switch (str2.hashCode()) {
            case 3006243:
                if (str2.equals("avc1")) {
                    i = 2;
                    break;
                }
            case 3006244:
                if (str2.equals("avc2")) {
                    i = 3;
                    break;
                }
            case 3199032:
                if (str2.equals("hev1")) {
                    break;
                }
            case 3214780:
                if (str2.equals("hvc1")) {
                    i = 1;
                    break;
                }
            default:
                i = -1;
                break;
        }
        switch (i) {
            case 0:
            case 1:
                if (split.length < 4) {
                    return null;
                }
                Matcher matcher = aqg.matcher(split[1]);
                if (!matcher.matches()) {
                    return null;
                }
                String group = matcher.group(1);
                if ("1".equals(group)) {
                    i = 1;
                } else if (!"2".equals(group)) {
                    return null;
                } else {
                    i = 2;
                }
                Integer num = (Integer) aqk.get(split[3]);
                if (num != null) {
                    return new Pair(Integer.valueOf(i), num);
                }
                new StringBuilder("Unknown HEVC level string: ").append(matcher.group(1));
                return null;
            case 2:
            case 3:
                return a(str, split);
            default:
                return null;
        }
    }

    private static List<a> a(a aVar, c cVar) {
        String name;
        try {
            List<a> arrayList = new ArrayList();
            String str = aVar.mimeType;
            int codecCount = cVar.getCodecCount();
            boolean jR = cVar.jR();
            loop0:
            for (int i = 0; i < codecCount; i++) {
                MediaCodecInfo codecInfoAt = cVar.getCodecInfoAt(i);
                name = codecInfoAt.getName();
                Object obj = (codecInfoAt.isEncoder() || (!jR && name.endsWith(".secure"))) ? null : (t.SDK_INT >= 21 || !("CIPAACDecoder".equals(name) || "CIPMP3Decoder".equals(name) || "CIPVorbisDecoder".equals(name) || "CIPAMRNBDecoder".equals(name) || "AACDecoder".equals(name) || "MP3Decoder".equals(name))) ? (t.SDK_INT >= 18 || !"OMX.SEC.MP3.Decoder".equals(name)) ? (t.SDK_INT < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(name) && ("a70".equals(t.DEVICE) || ("Xiaomi".equals(t.MANUFACTURER) && t.DEVICE.startsWith("HM")))) ? null : (t.SDK_INT == 16 && "OMX.qcom.audio.decoder.mp3".equals(name) && ("dlxu".equals(t.DEVICE) || "protou".equals(t.DEVICE) || "ville".equals(t.DEVICE) || "villeplus".equals(t.DEVICE) || "villec2".equals(t.DEVICE) || t.DEVICE.startsWith("gee") || "C6602".equals(t.DEVICE) || "C6603".equals(t.DEVICE) || "C6606".equals(t.DEVICE) || "C6616".equals(t.DEVICE) || "L36h".equals(t.DEVICE) || "SO-02E".equals(t.DEVICE))) ? null : (t.SDK_INT == 16 && "OMX.qcom.audio.decoder.aac".equals(name) && ("C1504".equals(t.DEVICE) || "C1505".equals(t.DEVICE) || "C1604".equals(t.DEVICE) || "C1605".equals(t.DEVICE))) ? null : (t.SDK_INT >= 24 || !(("OMX.SEC.aac.dec".equals(name) || "OMX.Exynos.AAC.Decoder".equals(name)) && t.MANUFACTURER.equals("samsung") && (t.DEVICE.startsWith("zeroflte") || t.DEVICE.startsWith("zerolte") || t.DEVICE.startsWith("zenlte") || t.DEVICE.equals("SC-05G") || t.DEVICE.equals("marinelteatt") || t.DEVICE.equals("404SC") || t.DEVICE.equals("SC-04G") || t.DEVICE.equals("SCV31")))) ? (t.SDK_INT <= 19 && "OMX.SEC.vp8.dec".equals(name) && "samsung".equals(t.MANUFACTURER) && (t.DEVICE.startsWith("d2") || t.DEVICE.startsWith("serrano") || t.DEVICE.startsWith("jflte") || t.DEVICE.startsWith("santos") || t.DEVICE.startsWith("t0"))) ? null : (t.SDK_INT <= 19 && t.DEVICE.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(name)) ? null : 1 : null : null : null;
                if (obj != null) {
                    for (String str2 : codecInfoAt.getSupportedTypes()) {
                        if (str2.equalsIgnoreCase(str)) {
                            CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(str2);
                            boolean a = cVar.a(str, capabilitiesForType);
                            boolean z = t.SDK_INT <= 22 && ((t.MODEL.equals("ODROID-XU3") || t.MODEL.equals("Nexus 10")) && ("OMX.Exynos.AVC.Decoder".equals(name) || "OMX.Exynos.AVC.Decoder.secure".equals(name)));
                            if ((!jR || aVar.apo != a) && (jR || aVar.apo)) {
                                if (!jR && a) {
                                    arrayList.add(a.a(name + ".secure", str, capabilitiesForType, z, true));
                                    break loop0;
                                }
                            }
                            arrayList.add(a.a(name, str, capabilitiesForType, z, false));
                        }
                    }
                    continue;
                }
            }
            return arrayList;
        } catch (Exception e) {
            if (t.SDK_INT > 23 || arrayList.isEmpty()) {
                new StringBuilder("Failed to query codec ").append(name).append(" (").append(str2).append(")");
                throw e;
            }
            new StringBuilder("Skipping codec ").append(name).append(" (failed to query capabilities)");
        } catch (Throwable e2) {
            throw new b(e2, (byte) 0);
        }
    }

    private static void k(List<a> list) {
        int i = 1;
        if (t.SDK_INT < 26 && list.size() > 1 && "OMX.MTK.AUDIO.DECODER.RAW".equals(((a) list.get(0)).name)) {
            while (i < list.size()) {
                a aVar = (a) list.get(i);
                if ("OMX.google.raw.decoder".equals(aVar.name)) {
                    list.remove(i);
                    list.add(0, aVar);
                    return;
                }
                i++;
            }
        }
    }

    private static Pair<Integer, Integer> a(String str, String[] strArr) {
        if (strArr.length < 2) {
            return null;
        }
        try {
            Integer valueOf;
            Integer valueOf2;
            if (strArr[1].length() == 6) {
                valueOf = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                valueOf2 = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
            } else if (strArr.length < 3) {
                return null;
            } else {
                valueOf = Integer.valueOf(Integer.parseInt(strArr[1]));
                valueOf2 = Integer.valueOf(Integer.parseInt(strArr[2]));
            }
            Integer valueOf3 = Integer.valueOf(aqi.get(valueOf.intValue()));
            if (valueOf3 == null) {
                new StringBuilder("Unknown AVC profile: ").append(valueOf);
                return null;
            }
            Integer valueOf4 = Integer.valueOf(aqj.get(valueOf2.intValue()));
            if (valueOf4 != null) {
                return new Pair(valueOf3, valueOf4);
            }
            new StringBuilder("Unknown AVC level: ").append(valueOf2);
            return null;
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
