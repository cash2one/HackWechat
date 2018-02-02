package com.tencent.mm.plugin.api.recordView;

import android.opengl.GLES20;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public static int XZ() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        return iArr[0];
    }

    private static int ad(String str, int i) {
        int[] iArr = new int[1];
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        x.e("loadShader error, infoLog: %s", GLES20.glGetShaderInfoLog(glCreateShader));
        return 0;
    }

    public static int aI(String str, String str2) {
        int[] iArr = new int[1];
        int ad = ad(str, 35633);
        if (ad == 0) {
            x.e("MicroMsg.MMSightCameraGLUtil", "load vertex shader failed");
            return 0;
        }
        int ad2 = ad(str2, 35632);
        if (ad2 == 0) {
            x.e("MicroMsg.MMSightCameraGLUtil", "load fragment shader failed");
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, ad);
        GLES20.glAttachShader(glCreateProgram, ad2);
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] <= 0) {
            x.e("MicroMsg.MMSightCameraGLUtil", "link program failed");
            return 0;
        }
        GLES20.glDeleteShader(ad);
        GLES20.glDeleteShader(ad2);
        return glCreateProgram;
    }
}
