package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.util.Log;
import com.tencent.mm.modelappbrand.a.b.e;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

final class a implements e {
    private int iKu;
    private int iKv;
    private int mHeight;
    private int mWidth;

    public a(int i, int i2, int i3, int i4) {
        this.iKu = i;
        this.iKv = i2;
        this.mWidth = i3;
        this.mHeight = i4;
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
            options.inSampleSize = (int) ((((double) options.outWidth) * 1.0d) / ((double) this.mWidth));
            if (options.inSampleSize <= 1) {
                options.inSampleSize = 1;
            }
            while (((options.outHeight * options.outWidth) / options.inSampleSize) / options.inSampleSize > 2764800) {
                options.inSampleSize++;
            }
            options.inJustDecodeBounds = false;
            options.inMutable = true;
            int i2 = this.iKu;
            int i3 = this.iKv;
            if (this.iKu < 0) {
                i = 0;
            } else if (this.iKu > options.outWidth) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                    }
                }
                return null;
            } else {
                i = i2;
            }
            if (this.iKv < 0) {
                i2 = 0;
            } else if (this.iKv > options.outHeight) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                    }
                }
                return null;
            } else {
                i2 = i3;
            }
            int i4 = (this.mWidth + this.iKu) - i;
            i3 = (this.mHeight + this.iKv) - i2;
            if (i + i4 > options.outWidth) {
                i4 = options.outWidth - i;
            }
            if (i2 + i3 > options.outHeight) {
                i3 = options.outHeight - i2;
            }
            if (i4 <= 0 || i3 <= 0) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                    }
                }
                return null;
            }
            decodeStream = BitmapRegionDecoder.newInstance(inputStream, false).decodeRegion(new Rect(i, i2, i4 + i, i3 + i2), options);
            if (inputStream == null) {
                return decodeStream;
            }
            try {
                inputStream.close();
                return decodeStream;
            } catch (IOException e5) {
                return decodeStream;
            }
        } catch (Throwable e6) {
            x.e("MicroMsg.AppBrand.BitmapDecoderImpl", "%s", new Object[]{Log.getStackTraceString(e6)});
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e7) {
                }
            }
            return null;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e8) {
                }
            }
        }
    }

    public final String Jo() {
        return String.format("Decoder_x%s_y%s_w%s_h%s", new Object[]{Integer.valueOf(this.iKu), Integer.valueOf(this.iKv), Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight)});
    }
}
