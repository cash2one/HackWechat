package com.tencent.mm.plugin.appbrand.share;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import com.tencent.mm.modelappbrand.a.b.e;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class a implements e {
    private int mHeight;
    private int mWidth;

    public a(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    public final Bitmap f(InputStream inputStream) {
        try {
            if (!inputStream.markSupported()) {
                if (inputStream instanceof FileInputStream) {
                    inputStream = new j((FileInputStream) inputStream);
                } else if (!inputStream.markSupported()) {
                    inputStream = new BufferedInputStream(inputStream);
                }
            }
            Options options = new Options();
            options.inJustDecodeBounds = true;
            inputStream.mark(8388608);
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            inputStream.reset();
            if (decodeStream != null) {
                decodeStream.recycle();
            }
            if (options.outHeight <= 0 || options.outWidth <= 0) {
                x.e("MicroMsg.AppBrand.BitmapDecoderImpl", "decode[%s] error, outHeight[%d] outWidth[%d]", new Object[]{inputStream, Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth)});
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                    }
                }
                return null;
            }
            int i;
            int i2;
            options.inSampleSize = (int) ((((double) options.outWidth) * 1.0d) / ((double) this.mWidth));
            if (options.inSampleSize <= 1) {
                options.inSampleSize = 1;
            }
            while (((options.outHeight * options.outWidth) / options.inSampleSize) / options.inSampleSize > 2764800) {
                options.inSampleSize++;
            }
            options.inJustDecodeBounds = false;
            options.inMutable = true;
            if (((float) options.outWidth) / ((float) options.outHeight) > ((float) this.mWidth) / ((float) this.mHeight)) {
                i = options.outHeight;
                i2 = (int) (((((float) options.outHeight) * 1.0f) * ((float) this.mWidth)) / ((float) this.mHeight));
            } else {
                i2 = options.outWidth;
                i = (int) (((((float) options.outWidth) * 1.0f) * ((float) this.mHeight)) / ((float) this.mWidth));
            }
            decodeStream = BitmapRegionDecoder.newInstance(inputStream, false).decodeRegion(new Rect(0, 0, i2, i), options);
            if (inputStream == null) {
                return decodeStream;
            }
            try {
                inputStream.close();
                return decodeStream;
            } catch (IOException e2) {
                return decodeStream;
            }
        } catch (IOException e3) {
            x.e("MicroMsg.AppBrand.BitmapDecoderImpl", "%s", new Object[]{e3});
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                }
            }
            return null;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
        }
    }

    public final String Jo() {
        return String.format("Decoder_w%s_h%s", new Object[]{Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight)});
    }
}
