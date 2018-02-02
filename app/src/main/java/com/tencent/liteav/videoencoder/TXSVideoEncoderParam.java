package com.tencent.liteav.videoencoder;

import javax.microedition.khronos.egl.EGLContext;

public class TXSVideoEncoderParam {
    public boolean annexb = false;
    public boolean appendSpsPps = true;
    public boolean enableBFrame = false;
    public int encoderMode = 1;
    public int encoderProfile = 1;
    public int fps = 15;
    public EGLContext glContext = null;
    public int gop = 3;
    public int height = 640;
    public boolean needEdit = false;
    public boolean realTime = false;
    public int width = 360;
}
