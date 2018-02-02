package com.tencent.mm.plugin.music.model.g;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.k;
import com.tencent.mm.sdk.platformtools.x;

public final class h {
    public static int tI(int i) {
        x.i("MicroMsg.PlayerErrorHandler", "getErrCodeType, errorCode: %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 53:
            case 54:
                return 10003;
            case 55:
            case 63:
            case 64:
            case 101:
            case 701:
            case 703:
            case 705:
                return 10004;
            case 62:
            case 66:
            case 67:
            case 69:
            case 70:
            case 74:
            case 102:
            case 500:
            case HardCoderJNI.SCENE_DB /*501*/:
            case 502:
            case 503:
            case 504:
            case 600:
            case 601:
            case 602:
            case 603:
            case 604:
            case 605:
            case 702:
            case 704:
            case 706:
            case 707:
                return 10001;
            case 80:
                return 10002;
            default:
                return -1;
        }
    }

    public static String tJ(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("errCode:" + i + ", err:");
        switch (i) {
            case 53:
                stringBuilder.append("file not found");
                break;
            case 54:
                stringBuilder.append("file can not read");
                break;
            case 55:
                stringBuilder.append("unknow format");
                break;
            case 62:
                stringBuilder.append("load or init native decode so fail");
                break;
            case 63:
                stringBuilder.append("get audio info fail");
                break;
            case 64:
                stringBuilder.append("invalid audio info");
                break;
            case 66:
                stringBuilder.append("create AudioTrack fail");
                break;
            case 67:
                stringBuilder.append("decode audio fail");
                break;
            case 69:
                stringBuilder.append("so file not found");
                break;
            case 70:
                stringBuilder.append("create temp file fail");
                break;
            case 74:
                stringBuilder.append("invalid seek or seek fail");
                break;
            case 80:
                stringBuilder.append("connect network fail");
                break;
            case 101:
                stringBuilder.append("recognition audio format error");
                break;
            case 102:
                stringBuilder.append("write AudioTrack data fail");
                break;
            case 500:
                stringBuilder.append("error URL format");
                break;
            case HardCoderJNI.SCENE_DB /*501*/:
                stringBuilder.append("error player to prepare");
                break;
            case 502:
                stringBuilder.append("error player to start");
                break;
            case 503:
                stringBuilder.append("error player to pause");
                break;
            case 504:
                stringBuilder.append("error player to stop");
                break;
            case 600:
                stringBuilder.append("error create player fail, exceed max count audio players");
                break;
            case 601:
                stringBuilder.append("error, not found audioId");
                break;
            case 602:
                stringBuilder.append("error, not found param");
                break;
            case 603:
                stringBuilder.append("error, ready exist audioId");
                break;
            case 604:
                stringBuilder.append("error, invalid audioID");
                break;
            case 605:
                stringBuilder.append("error, invalid param");
                break;
            case 701:
                stringBuilder.append("error, invalid param");
                break;
            case 702:
                stringBuilder.append("error, mmplayer set source occur error");
                break;
            case 703:
                stringBuilder.append("error, mmplayer media format error");
                break;
            case 704:
                stringBuilder.append("error, mmplayer create MediaCode error");
                break;
            case 705:
                stringBuilder.append("error, mmplayer get audio info error");
                break;
            case 706:
                stringBuilder.append("error, mmplayer decode error");
                break;
            case 707:
                stringBuilder.append("error, mmplayer create audio track orror");
                break;
            default:
                stringBuilder.append("unknow exception");
                break;
        }
        return stringBuilder.toString();
    }

    public static int tK(int i) {
        x.i("MicroMsg.PlayerErrorHandler", "getQQMusicPlayerErrIdKey, errCode:" + i);
        switch (i) {
            case 53:
                return 17;
            case 54:
                return 18;
            case 55:
                return 19;
            case 62:
                return 20;
            case 63:
                return 21;
            case 64:
                return 22;
            case 66:
                return 23;
            case 67:
                return 24;
            case 69:
                return 25;
            case 70:
                return 36;
            case 74:
                return 26;
            case 80:
                return 27;
            case 101:
                return 28;
            case 102:
                return 29;
            case 500:
                return 31;
            case HardCoderJNI.SCENE_DB /*501*/:
                return 32;
            case 502:
                return 33;
            case 503:
                return 34;
            case 504:
                return 35;
            case 700:
                return 37;
            case 701:
                return 38;
            default:
                return 30;
        }
    }

    public static int tL(int i) {
        x.i("MicroMsg.PlayerErrorHandler", "getMusicPlayerErrIdKey, errCode:" + i);
        switch (i) {
            case 700:
                return 45;
            case 701:
                return 48;
            case 702:
                return 39;
            case 703:
                return 40;
            case 704:
                return 41;
            case 705:
                return 42;
            case 706:
                return 43;
            case 707:
                return 44;
            default:
                return k.CTRL_BYTE;
        }
    }

    public static int Gw(String str) {
        if ("audio/3gpp".equalsIgnoreCase(str)) {
            return 1;
        }
        if ("audio/amr-wb".equalsIgnoreCase(str)) {
            return 2;
        }
        if ("audio/mpeg".equalsIgnoreCase(str) || "audio/mp3".equalsIgnoreCase(str)) {
            return 3;
        }
        if ("audio/mp4a-latm".equalsIgnoreCase(str) || str.startsWith("audio/mp4")) {
            return 4;
        }
        if ("audio/qcelp".equalsIgnoreCase(str)) {
            return 5;
        }
        if ("audio/vorbis".equalsIgnoreCase(str)) {
            return 6;
        }
        if ("audio/opus".equalsIgnoreCase(str)) {
            return 7;
        }
        if ("audio/g711-alaw".equalsIgnoreCase(str)) {
            return 8;
        }
        if ("audio/g711-mlaw".equalsIgnoreCase(str)) {
            return 9;
        }
        if ("audio/raw".equalsIgnoreCase(str)) {
            return 10;
        }
        if ("audio/flac".equalsIgnoreCase(str)) {
            return 11;
        }
        if ("audio/gsm".equalsIgnoreCase(str)) {
            return 12;
        }
        if ("audio/ac3".equalsIgnoreCase(str)) {
            return 13;
        }
        if ("audio/eac3".equalsIgnoreCase(str)) {
            return 14;
        }
        if ("audio/x-ms-wma".equalsIgnoreCase(str)) {
            return 15;
        }
        if ("audio/x-wav".equalsIgnoreCase(str)) {
            return 16;
        }
        if ("audio/x-ape".equalsIgnoreCase(str) || "application/x-ape".equalsIgnoreCase(str)) {
            return 17;
        }
        return 0;
    }
}
