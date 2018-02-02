package com.tencent.liteav.videoencoder;

import android.opengl.GLES20;
import com.tencent.liteav.basic.d.c;

class TXCSWVideoEncoder$a extends c {
    private int r = -1;
    private int s = -1;

    public TXCSWVideoEncoder$a() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "\nprecision highp float;\nvarying highp vec2 textureCoordinate;\nuniform highp sampler2D inputImageTexture;\t\t\t// 原始纹理\nuniform float width;\t\t\t// 纹理宽\nuniform float height;\t\t\t// 纹理高\n\nvoid main(void) {\n\tvec3 offset = vec3(0.0625, 0.5, 0.5);\n\tvec3 ycoeff = vec3(0.256816, 0.504154, 0.0979137);\n\tvec3 ucoeff = vec3(-0.148246, -0.29102, 0.439266);\n\tvec3 vcoeff = vec3(0.439271, -0.367833, -0.071438);\n\n\tvec2 nowTxtPos = textureCoordinate;\n\tvec2 size = vec2(width, height);\n\n\tfloat uvlines = height / 16.0;   // 0.625:w*h/4(uv数据所占内存空间) / w*h*4(rgba总空间) = 0.625(u或v数据在当前fbo中所占比例);uvlines:uv数据需要多少行\n\tfloat uvlinesI = float(int(uvlines));\n\tvec2 uvPosOffset = vec2(0.0,0.0625);\n\tvec2 uMaxPos = uvPosOffset+vec2(0,0.25);\n\tvec2 vMaxPos = uvPosOffset+uMaxPos;\n\n\tvec2 yScale = vec2(4.0,4.0);\n\tvec2 uvScale = vec2(8.0,8.0);\n// y\n\n\tif(nowTxtPos.y<0.25){\n// y base postion\n       vec2 basePos = nowTxtPos * yScale * size;\n       float addY = float(int((basePos.x / width)));\n       basePos.x -= addY * width;\n       basePos.y += addY;\n// y1 y2 y3 y4\n\t\tfloat y1,y2,y3,y4;\n\t\n\tbasePos.x -= 0.2;\n\tbasePos.y -= 0.2;\n\t\tvec2 samplingPos = basePos / size;\n\t\tvec4 texel = texture2D(inputImageTexture, samplingPos);\n\t\ty1 = dot(texel.rgb, ycoeff);\n\t\ty1 += offset.x;\n\t\n\t\tbasePos.x+=1.0;\n\t\tsamplingPos = basePos/ size;\n\t\ttexel = texture2D(inputImageTexture, samplingPos);\n\t\ty2 = dot(texel.rgb, ycoeff);\n\t\ty2 += offset.x;\n\n\t\n\t\tbasePos.x+=1.0;\n\t\tsamplingPos = basePos/ size;\n\t\ttexel = texture2D(inputImageTexture, samplingPos);\n\t\ty3 = dot(texel.rgb, ycoeff);\n\t\ty3 += offset.x;\n\t\n\t\tbasePos.x+=1.0;\n\t\tsamplingPos = basePos/ size;\n\t\ttexel = texture2D(inputImageTexture, samplingPos);\n\t\ty4 = dot(texel.rgb, ycoeff);\n\t\ty4 += offset.x;\n\t\n\t\tgl_FragColor = vec4(y1, y2, y3, y4);\n\t\t//gl_FragColor = vec4(y4, y3, y2, y1);\n\t}\n// u\n\telse if(nowTxtPos.y<uMaxPos.y){\n       nowTxtPos.y -= 0.25;\n       highp vec2 basePos = nowTxtPos * uvScale * size;\n       highp float addY = float(int(basePos.x / width));\n       basePos.x -= addY * width;\n       basePos.y += addY;\n       basePos.y *= 2.0;\n       basePos -= clamp(uvScale * 0.5 - 2.0, vec2(0.0), uvScale);\n       basePos.y -= 2.0;\n\t\n\t\thighp vec4 sample = texture2D(inputImageTexture, basePos/ size).rgba;\n\t\thighp float u1 = dot(sample.rgb, ucoeff);\n\t\tu1 += offset.y;\n\t\n\t\tbasePos.x+=2.0;\n\t\tsample = texture2D(inputImageTexture, basePos/ size).rgba;\n\t\tfloat u2 = dot(sample.rgb, ucoeff);\n\t\tu2 += offset.y;\n\t\n\t\tbasePos.x+=2.0;\n\t\tsample = texture2D(inputImageTexture, basePos / size).rgba;\n\t\tfloat u3 = dot(sample.rgb, ucoeff);\n\t\tu3 += offset.y;\n\t\n\t\tbasePos.x+=2.0;\n\t\tsample = texture2D(inputImageTexture, basePos / size).rgba;\n\t\tfloat u4 = dot(sample.rgb, ucoeff);\n\t\tu4 += offset.y;\n\t\n\t\tgl_FragColor = vec4(u1, u2, u3, u4);\n\t\t//gl_FragColor = vec4(0.5, 0.5, 0.5, 0.5);\n\t}\n// v\n\telse if(nowTxtPos.y<vMaxPos.y){\n       nowTxtPos -= uMaxPos;\n       highp vec2 basePos = nowTxtPos * uvScale * size;\n       highp float addY = float(int(basePos.x / width));\n       basePos.x -= addY * width;\n       basePos.y += addY;\n       basePos.y *= 2.0;\n       basePos -= clamp(uvScale * 0.5 - 2.0, vec2(0.0), uvScale);\n       basePos.y -= 2.0;\n\t\n\t\thighp vec4 sample = texture2D(inputImageTexture, basePos / size).rgba;\n\t\thighp float v1 = dot(sample.rgb, vcoeff);\n\t\tv1 += offset.z;\n\t\n\t\tbasePos.x+=2.0;\n\t\tsample = texture2D(inputImageTexture, basePos / size).rgba;\n\t\tfloat v2 = dot(sample.rgb, vcoeff);\n\t\tv2 += offset.z;\n\t\n\t\tbasePos.x+=2.0;\n\t\tsample = texture2D(inputImageTexture, basePos / size).rgba;\n\t\tfloat v3 = dot(sample.rgb, vcoeff);\n\t\tv3 += offset.z;\n\t\n\t\tbasePos.x+=2.0;\n\t\tsample = texture2D(inputImageTexture, basePos / size).rgba;\n\t\tfloat v4 = dot(sample.rgb, vcoeff);\n\t\tv4 += offset.z;\n\t\n\t\tgl_FragColor = vec4(v1, v2, v3, v4);\n       //gl_FragColor = vec4(0.5, 0.5, 0.5, 0.5);\n\t}\n\t//else gl_FragColor = vec4(0.0, 0.0, 0.0, 0.0);\n}\n");
        a(true);
    }

    public boolean b() {
        boolean b = super.b();
        if (b) {
            this.r = GLES20.glGetUniformLocation(this.a, "width");
            this.s = GLES20.glGetUniformLocation(this.a, "height");
        }
        return b;
    }

    public void a(int i, int i2) {
        super.a(i, i2);
        GLES20.glUseProgram(this.a);
        GLES20.glUniform1f(this.r, (float) i);
        GLES20.glUniform1f(this.s, (float) i2);
    }
}
