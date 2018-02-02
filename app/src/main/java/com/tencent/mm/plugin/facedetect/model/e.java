package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.z.aq;

public final class e {
    private static long mgc = -1;
    private static long mgd = -1;
    private static float mge = -1.0f;

    public static void cR(long j) {
        mgc = j;
    }

    public static boolean aGu() {
        return Boolean.parseBoolean(aq.hfP.H("last_login_face_use_debug_mode", "false"));
    }

    public static boolean aGv() {
        return Boolean.parseBoolean(aq.hfP.H("last_login_face_is_force_upload_face", "false"));
    }

    public static boolean aGw() {
        return Boolean.parseBoolean(aq.hfP.H("last_login_face_save_correct_debug_mode", "false"));
    }

    public static boolean aGx() {
        return Boolean.parseBoolean(aq.hfP.H("last_login_face_save_final_debug_mode", "false"));
    }

    public static boolean aGy() {
        return Boolean.parseBoolean(aq.hfP.H("last_login_face_save_lip_reading", "false"));
    }

    public static boolean aGz() {
        return Boolean.parseBoolean(aq.hfP.H("last_login_face_save_final_voice", "false"));
    }

    public static void eN(boolean z) {
        aq.hfP.S("last_login_face_use_debug_mode", String.valueOf(z));
    }

    public static void eO(boolean z) {
        aq.hfP.S("last_login_face_save_correct_debug_mode", String.valueOf(z));
    }

    public static void eP(boolean z) {
        aq.hfP.S("last_login_face_save_final_debug_mode", String.valueOf(z));
    }

    public static void eQ(boolean z) {
        aq.hfP.S("last_login_face_save_lip_reading", String.valueOf(z));
    }

    public static void eR(boolean z) {
        aq.hfP.S("last_login_face_save_final_voice", String.valueOf(z));
    }

    public static void eS(boolean z) {
        aq.hfP.S("last_login_face_is_force_upload_face", String.valueOf(z));
    }
}
