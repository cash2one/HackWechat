package org.xwalk.core;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcelable;
import android.webkit.ValueCallback;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class XWalkFileChooser {
    private static final String ALL_AUDIO_TYPES = "audio/*";
    private static final String ALL_IMAGE_TYPES = "image/*";
    private static final String ALL_VIDEO_TYPES = "video/*";
    private static final String ANY_TYPES = "*/*";
    private static final String AUDIO_TYPE = "audio/";
    private static final String IMAGE_TYPE = "image/";
    public static final int INPUT_FILE_REQUEST_CODE = 1;
    private static final String PATH_PREFIX = "file:";
    private static final String SPLIT_EXPRESSION = ",";
    private static final String TAG = "XWalkFileChooser";
    private static final String VIDEO_TYPE = "video/";
    private static final String WRITE_EXTERNAL_STORAGE = "android.permission.WRITE_EXTERNAL_STORAGE";
    private Activity mActivity;
    private String mCameraPhotoPath;
    private ValueCallback<Uri> mFilePathCallback;

    public XWalkFileChooser(Activity activity) {
        this.mActivity = activity;
    }

    public boolean showFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        this.mFilePathCallback = valueCallback;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(this.mActivity.getPackageManager()) != null) {
            File createImageFile = createImageFile();
            if (createImageFile != null) {
                this.mCameraPhotoPath = new StringBuilder(PATH_PREFIX).append(createImageFile.getAbsolutePath()).toString();
                intent.putExtra("PhotoPath", this.mCameraPhotoPath);
                intent.putExtra("output", Uri.fromFile(createImageFile));
            } else {
                intent = null;
            }
        }
        Intent intent2 = new Intent("android.media.action.VIDEO_CAPTURE");
        Intent intent3 = new Intent("android.provider.MediaStore.RECORD_SOUND");
        Parcelable intent4 = new Intent("android.intent.action.GET_CONTENT");
        intent4.addCategory("android.intent.category.OPENABLE");
        ArrayList arrayList = new ArrayList();
        if (!(str.contains(SPLIT_EXPRESSION) || str.contains(ANY_TYPES))) {
            if (str2.equals("true")) {
                if (!str.startsWith(IMAGE_TYPE)) {
                    if (str.startsWith(VIDEO_TYPE)) {
                        this.mActivity.startActivityForResult(intent2, 1);
                        Log.d(TAG, "Started camcorder");
                    } else if (str.startsWith(AUDIO_TYPE)) {
                        this.mActivity.startActivityForResult(intent3, 1);
                        Log.d(TAG, "Started sound recorder");
                    }
                    return true;
                } else if (intent != null) {
                    this.mActivity.startActivityForResult(intent, 1);
                    Log.d(TAG, "Started taking picture");
                    return true;
                }
            } else if (str.startsWith(IMAGE_TYPE)) {
                if (intent != null) {
                    arrayList.add(intent);
                }
                intent4.setType(ALL_IMAGE_TYPES);
            } else if (str.startsWith(VIDEO_TYPE)) {
                arrayList.add(intent2);
                intent4.setType(ALL_VIDEO_TYPES);
            } else if (str.startsWith(AUDIO_TYPE)) {
                arrayList.add(intent3);
                intent4.setType(ALL_AUDIO_TYPES);
            }
        }
        if (arrayList.isEmpty() && canWriteExternalStorage()) {
            if (intent != null) {
                arrayList.add(intent);
            }
            arrayList.add(intent2);
            arrayList.add(intent3);
            intent4.setType(ANY_TYPES);
        }
        intent2 = new Intent("android.intent.action.CHOOSER");
        intent2.putExtra("android.intent.extra.INTENT", intent4);
        if (!arrayList.isEmpty()) {
            intent2.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Intent[0]));
        }
        this.mActivity.startActivityForResult(intent2, 1);
        Log.d(TAG, "Started chooser");
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && this.mFilePathCallback != null) {
            Uri uri;
            Log.d(TAG, "Activity result: " + i2);
            if (-1 != i2) {
                if (i2 == 0) {
                    deleteImageFile();
                }
                uri = null;
            } else if (intent == null || (intent.getAction() == null && intent.getData() == null)) {
                if (this.mCameraPhotoPath != null) {
                    uri = Uri.parse(this.mCameraPhotoPath);
                }
                uri = null;
            } else {
                String dataString = intent.getDataString();
                if (dataString != null) {
                    uri = Uri.parse(dataString);
                } else {
                    uri = null;
                }
                deleteImageFile();
            }
            if (uri != null) {
                Log.d(TAG, "Received file: " + uri.toString());
            }
            this.mFilePathCallback.onReceiveValue(uri);
            this.mFilePathCallback = null;
        }
    }

    private boolean canWriteExternalStorage() {
        try {
            return Arrays.asList(this.mActivity.getPackageManager().getPackageInfo(this.mActivity.getPackageName(), Downloads.RECV_BUFFER_SIZE).requestedPermissions).contains(WRITE_EXTERNAL_STORAGE);
        } catch (NameNotFoundException e) {
            return false;
        } catch (NullPointerException e2) {
            return false;
        }
    }

    private File createImageFile() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            String str = "JPEG_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + "_";
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            if (!externalStoragePublicDirectory.exists()) {
                externalStoragePublicDirectory.mkdirs();
            }
            try {
                File createTempFile = File.createTempFile(str, ".jpg", externalStoragePublicDirectory);
                Log.d(TAG, "Created image file: " + createTempFile.getAbsolutePath());
                return createTempFile;
            } catch (IOException e) {
                Log.e(TAG, "Unable to create Image File, please make sure permission 'WRITE_EXTERNAL_STORAGE' was added.");
                return null;
            }
        }
        Log.e(TAG, "External storage is not mounted.");
        return null;
    }

    private boolean deleteImageFile() {
        if (this.mCameraPhotoPath == null || !this.mCameraPhotoPath.contains(PATH_PREFIX)) {
            return false;
        }
        String str = this.mCameraPhotoPath.split(PATH_PREFIX)[1];
        boolean delete = new File(str).delete();
        Log.d(TAG, "Delete image file: " + str + " result: " + delete);
        return delete;
    }
}
