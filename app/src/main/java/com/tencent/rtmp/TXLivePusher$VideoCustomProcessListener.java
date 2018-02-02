package com.tencent.rtmp;

public interface TXLivePusher$VideoCustomProcessListener {
    void onDetectFacePoints(float[] fArr);

    int onTextureCustomProcess(int i, int i2, int i3);

    void onTextureDestoryed();
}
