package com.tencent.mm.modelcontrol;

import com.tencent.mm.sdk.platformtools.x;

public final class a {
    private static f[] htR;

    static {
        htR = null;
        r8 = new f[2];
        htR = r8;
        r8[0] = new f(0, 120, 540, 960, 30, 1200000, 1200000);
        htR[1] = new f(120, 300, 360, 640, 24, 544000, 544000);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(f[] fVarArr, VideoTransPara videoTransPara, VideoTransPara videoTransPara2) {
        if (fVarArr != null) {
            try {
            } catch (Exception e) {
                x.e("MicroMsg.BitrateCalculator", "do calc bitrate error: " + e.toString());
                return 0;
            }
        }
        fVarArr = htR;
        int length = fVarArr.length;
        videoTransPara2.width = videoTransPara.width;
        videoTransPara2.height = videoTransPara.height;
        videoTransPara2.fps = videoTransPara.fps;
        videoTransPara2.videoBitrate = videoTransPara.videoBitrate;
        videoTransPara2.duration = videoTransPara.duration;
        Object obj = videoTransPara.width > videoTransPara.height ? 1 : null;
        int i = obj != null ? videoTransPara.width : videoTransPara.height;
        int i2 = obj != null ? videoTransPara.height : videoTransPara.width;
        int i3 = videoTransPara.duration;
        if (videoTransPara2.duration < fVarArr[length - 1].huj || videoTransPara2.duration < htR[1].huj) {
            int i4;
            int i5 = 0;
            while (i5 < length) {
                if (i3 < fVarArr[i5].hui || i3 >= fVarArr[i5].huj) {
                    i5++;
                } else {
                    length = fVarArr[i5].huk;
                    i4 = fVarArr[i5].hul;
                    if (i > length || i2 > i4) {
                        if ((i * i4 > i2 * length ? 1 : null) != null) {
                            i4 = (i2 * length) / i;
                        } else {
                            length = (i * i4) / i2;
                        }
                        length = ((length + 8) >> 4) << 4;
                        i4 = ((i4 + 8) >> 4) << 4;
                    } else {
                        i4 = i2;
                        length = i;
                    }
                    videoTransPara2.width = obj != null ? length : i4;
                    if (obj == null) {
                        i4 = length;
                    }
                    videoTransPara2.height = i4;
                    videoTransPara2.fps = videoTransPara2.fps > fVarArr[i5].hum ? fVarArr[i5].hum : videoTransPara2.fps;
                    videoTransPara2.videoBitrate = (int) ((((((double) (((((fVarArr[i5].hun * fVarArr[i5].huj) + (fVarArr[i5].huo * videoTransPara2.duration)) - (fVarArr[i5].hun * videoTransPara2.duration)) - (fVarArr[i5].huo * fVarArr[i5].hui)) / (fVarArr[i5].huj - fVarArr[i5].hui))) * Math.sqrt((1.0d * ((double) (videoTransPara2.width * videoTransPara2.height))) / ((double) (fVarArr[i5].huk * fVarArr[i5].hul)))) * ((double) videoTransPara2.fps)) / ((double) fVarArr[i5].hum)) * (1.0d + (((double) (fVarArr[i5].hum - videoTransPara2.fps)) * 0.015d)));
                    return videoTransPara2.videoBitrate;
                }
            }
            i5 = 0;
            while (i5 < 2) {
                if (i3 < htR[i5].hui || i3 >= htR[i5].huj) {
                    i5++;
                } else {
                    length = htR[i5].huk;
                    i4 = htR[i5].hul;
                    if (i > length || i2 > i4) {
                        if ((i * i4 > i2 * length ? 1 : null) != null) {
                            i4 = (i2 * length) / i;
                        } else {
                            length = (i * i4) / i2;
                        }
                        length = ((length + 8) >> 4) << 4;
                        i4 = ((i4 + 8) >> 4) << 4;
                    } else {
                        i4 = i2;
                        length = i;
                    }
                    videoTransPara2.width = obj != null ? length : i4;
                    if (obj == null) {
                        i4 = length;
                    }
                    videoTransPara2.height = i4;
                    videoTransPara2.fps = videoTransPara2.fps > htR[i5].hum ? htR[i5].hum : videoTransPara2.fps;
                    videoTransPara2.videoBitrate = (int) ((((((double) (((((htR[i5].hun * htR[i5].huj) + (htR[i5].huo * videoTransPara2.duration)) - (htR[i5].hun * videoTransPara2.duration)) - (htR[i5].huo * htR[i5].hui)) / (htR[i5].huj - htR[i5].hui))) * Math.sqrt((1.0d * ((double) (videoTransPara2.width * videoTransPara2.height))) / ((double) (htR[i5].huk * htR[i5].hul)))) * ((double) videoTransPara2.fps)) / ((double) htR[i5].hum)) * (1.0d + (((double) (htR[i5].hum - videoTransPara2.fps)) * 0.015d)));
                    return videoTransPara2.videoBitrate;
                }
            }
        }
        return 0;
    }
}
