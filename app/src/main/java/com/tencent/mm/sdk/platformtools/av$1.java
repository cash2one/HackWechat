package com.tencent.mm.sdk.platformtools;

import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;

class av$1 extends ContentObserver {
    private long xhI;

    av$1(Handler handler) {
        super(handler);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onChange(boolean z, Uri uri) {
        Cursor query;
        long currentTimeMillis;
        Cursor cursor;
        Exception exception;
        Throwable th;
        x.d("MicroMsg.ScreenShotUtil", "summerscreenshot onChange: " + z + ", uri:" + uri.toString());
        if (av.cfV() == null || av.cfV().get() == null) {
            x.i("MicroMsg.ScreenShotUtil", "summerscreenshot unregisterContentObserver callback is null 1 mCallbackWeakRef[%s]", new Object[]{av.cfV()});
            ac.getContext().getContentResolver().unregisterContentObserver(this);
            av.cfW();
            if (av.cfV() != null) {
                av.cfV().clear();
                av.cfX();
            }
        } else if (uri.toString().matches(av.aqF()) || uri.toString().contains(av.aqF())) {
            String string;
            try {
                query = ac.getContext().getContentResolver().query(uri, av.bQH(), null, null, "date_added DESC limit 1");
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            string = query.getString(query.getColumnIndex("_data"));
                            long j = query.getLong(query.getColumnIndex("date_added"));
                            currentTimeMillis = System.currentTimeMillis() / 1000;
                            x.d("MicroMsg.ScreenShotUtil", "summerscreenshot path: " + string + ", dateAdded: " + j + ", currentTime: " + currentTimeMillis);
                            if (Math.abs(currentTimeMillis - j) <= 10 && currentTimeMillis - this.xhI > 1 && !bh.ov(string) && (string.toLowerCase().contains("screenshot") || string.contains("截屏") || string.contains("截图"))) {
                                this.xhI = currentTimeMillis;
                                currentTimeMillis = j;
                                if (query != null) {
                                    query.close();
                                }
                                if (!bh.ov(string)) {
                                    x.i("MicroMsg.ScreenShotUtil", "summerscreenshot added path: " + string + ", time: " + currentTimeMillis);
                                    if (av.cfV() != null || av.cfV().get() == null) {
                                        ac.getContext().getContentResolver().unregisterContentObserver(this);
                                        av.cfW();
                                        if (av.cfV() != null) {
                                            av.cfV().clear();
                                            av.cfX();
                                        }
                                        x.i("MicroMsg.ScreenShotUtil", "summerscreenshot unregisterContentObserver callback is null 2");
                                    } else {
                                        ((av$a) av.cfV().get()).alG();
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        cursor = query;
                        string = null;
                        exception = e;
                        currentTimeMillis = 0;
                        try {
                            x.w("MicroMsg.ScreenShotUtil", "summerscreenshot fail e:" + exception.getMessage());
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (bh.ov(string)) {
                                x.i("MicroMsg.ScreenShotUtil", "summerscreenshot added path: " + string + ", time: " + currentTimeMillis);
                                if (av.cfV() != null) {
                                }
                                ac.getContext().getContentResolver().unregisterContentObserver(this);
                                av.cfW();
                                if (av.cfV() != null) {
                                    av.cfV().clear();
                                    av.cfX();
                                }
                                x.i("MicroMsg.ScreenShotUtil", "summerscreenshot unregisterContentObserver callback is null 2");
                            }
                            super.onChange(z, uri);
                        } catch (Throwable th2) {
                            th = th2;
                            query = cursor;
                            if (query != null) {
                                query.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
                currentTimeMillis = 0;
                string = null;
                if (query != null) {
                    query.close();
                }
            } catch (Exception e2) {
                exception = e2;
                cursor = null;
                string = null;
                currentTimeMillis = 0;
                x.w("MicroMsg.ScreenShotUtil", "summerscreenshot fail e:" + exception.getMessage());
                if (cursor != null) {
                    cursor.close();
                }
                if (bh.ov(string)) {
                    x.i("MicroMsg.ScreenShotUtil", "summerscreenshot added path: " + string + ", time: " + currentTimeMillis);
                    if (av.cfV() != null) {
                    }
                    ac.getContext().getContentResolver().unregisterContentObserver(this);
                    av.cfW();
                    if (av.cfV() != null) {
                        av.cfV().clear();
                        av.cfX();
                    }
                    x.i("MicroMsg.ScreenShotUtil", "summerscreenshot unregisterContentObserver callback is null 2");
                }
                super.onChange(z, uri);
            } catch (Throwable th4) {
                th = th4;
                query = null;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
            if (bh.ov(string)) {
                x.i("MicroMsg.ScreenShotUtil", "summerscreenshot added path: " + string + ", time: " + currentTimeMillis);
                if (av.cfV() != null) {
                }
                ac.getContext().getContentResolver().unregisterContentObserver(this);
                av.cfW();
                if (av.cfV() != null) {
                    av.cfV().clear();
                    av.cfX();
                }
                x.i("MicroMsg.ScreenShotUtil", "summerscreenshot unregisterContentObserver callback is null 2");
            }
        }
        super.onChange(z, uri);
    }
}
