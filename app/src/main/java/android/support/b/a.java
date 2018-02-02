package android.support.b;

import android.content.res.AssetManager.AssetInputStream;
import android.util.Pair;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.bk;
import com.tencent.mm.plugin.appbrand.jsapi.bo;
import com.tencent.mm.plugin.appbrand.jsapi.f.b$a;
import com.tencent.mm.plugin.appbrand.jsapi.f.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.i;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.b;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a {
    public static final String TAG_APERTURE_VALUE = "ApertureValue";
    public static final String TAG_ARTIST = "Artist";
    public static final String TAG_BITS_PER_SAMPLE = "BitsPerSample";
    public static final String TAG_BRIGHTNESS_VALUE = "BrightnessValue";
    public static final String TAG_CFA_PATTERN = "CFAPattern";
    public static final String TAG_COLOR_SPACE = "ColorSpace";
    public static final String TAG_COMPONENTS_CONFIGURATION = "ComponentsConfiguration";
    public static final String TAG_COMPRESSED_BITS_PER_PIXEL = "CompressedBitsPerPixel";
    public static final String TAG_COMPRESSION = "Compression";
    public static final String TAG_CONTRAST = "Contrast";
    public static final String TAG_COPYRIGHT = "Copyright";
    public static final String TAG_CUSTOM_RENDERED = "CustomRendered";
    public static final String TAG_DATETIME = "DateTime";
    public static final String TAG_DATETIME_DIGITIZED = "DateTimeDigitized";
    public static final String TAG_DATETIME_ORIGINAL = "DateTimeOriginal";
    public static final String TAG_DEFAULT_CROP_SIZE = "DefaultCropSize";
    public static final String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";
    public static final String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";
    public static final String TAG_DNG_VERSION = "DNGVersion";
    private static final String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
    public static final String TAG_EXIF_VERSION = "ExifVersion";
    public static final String TAG_EXPOSURE_BIAS_VALUE = "ExposureBiasValue";
    public static final String TAG_EXPOSURE_INDEX = "ExposureIndex";
    public static final String TAG_EXPOSURE_MODE = "ExposureMode";
    public static final String TAG_EXPOSURE_PROGRAM = "ExposureProgram";
    public static final String TAG_EXPOSURE_TIME = "ExposureTime";
    public static final String TAG_FILE_SOURCE = "FileSource";
    public static final String TAG_FLASH = "Flash";
    public static final String TAG_FLASHPIX_VERSION = "FlashpixVersion";
    public static final String TAG_FLASH_ENERGY = "FlashEnergy";
    public static final String TAG_FOCAL_LENGTH = "FocalLength";
    public static final String TAG_FOCAL_LENGTH_IN_35MM_FILM = "FocalLengthIn35mmFilm";
    public static final String TAG_FOCAL_PLANE_RESOLUTION_UNIT = "FocalPlaneResolutionUnit";
    public static final String TAG_FOCAL_PLANE_X_RESOLUTION = "FocalPlaneXResolution";
    public static final String TAG_FOCAL_PLANE_Y_RESOLUTION = "FocalPlaneYResolution";
    public static final String TAG_F_NUMBER = "FNumber";
    public static final String TAG_GAIN_CONTROL = "GainControl";
    public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
    public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
    public static final String TAG_GPS_AREA_INFORMATION = "GPSAreaInformation";
    public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
    public static final String TAG_GPS_DEST_BEARING = "GPSDestBearing";
    public static final String TAG_GPS_DEST_BEARING_REF = "GPSDestBearingRef";
    public static final String TAG_GPS_DEST_DISTANCE = "GPSDestDistance";
    public static final String TAG_GPS_DEST_DISTANCE_REF = "GPSDestDistanceRef";
    public static final String TAG_GPS_DEST_LATITUDE = "GPSDestLatitude";
    public static final String TAG_GPS_DEST_LATITUDE_REF = "GPSDestLatitudeRef";
    public static final String TAG_GPS_DEST_LONGITUDE = "GPSDestLongitude";
    public static final String TAG_GPS_DEST_LONGITUDE_REF = "GPSDestLongitudeRef";
    public static final String TAG_GPS_DIFFERENTIAL = "GPSDifferential";
    public static final String TAG_GPS_DOP = "GPSDOP";
    public static final String TAG_GPS_IMG_DIRECTION = "GPSImgDirection";
    public static final String TAG_GPS_IMG_DIRECTION_REF = "GPSImgDirectionRef";
    private static final String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
    public static final String TAG_GPS_LATITUDE = "GPSLatitude";
    public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
    public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
    public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
    public static final String TAG_GPS_MAP_DATUM = "GPSMapDatum";
    public static final String TAG_GPS_MEASURE_MODE = "GPSMeasureMode";
    public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
    public static final String TAG_GPS_SATELLITES = "GPSSatellites";
    public static final String TAG_GPS_SPEED = "GPSSpeed";
    public static final String TAG_GPS_SPEED_REF = "GPSSpeedRef";
    public static final String TAG_GPS_STATUS = "GPSStatus";
    public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
    public static final String TAG_GPS_TRACK = "GPSTrack";
    public static final String TAG_GPS_TRACK_REF = "GPSTrackRef";
    public static final String TAG_GPS_VERSION_ID = "GPSVersionID";
    private static final String TAG_HAS_THUMBNAIL = "HasThumbnail";
    public static final String TAG_IMAGE_DESCRIPTION = "ImageDescription";
    public static final String TAG_IMAGE_LENGTH = "ImageLength";
    public static final String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";
    public static final String TAG_IMAGE_WIDTH = "ImageWidth";
    private static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    public static final String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";
    public static final String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";
    public static final String TAG_LIGHT_SOURCE = "LightSource";
    public static final String TAG_MAKE = "Make";
    public static final String TAG_MAKER_NOTE = "MakerNote";
    public static final String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";
    public static final String TAG_METERING_MODE = "MeteringMode";
    public static final String TAG_MODEL = "Model";
    public static final String TAG_NEW_SUBFILE_TYPE = "NewSubfileType";
    public static final String TAG_OECF = "OECF";
    public static final String TAG_ORF_ASPECT_FRAME = "AspectFrame";
    private static final String TAG_ORF_CAMERA_SETTINGS_IFD_POINTER = "CameraSettingsIFDPointer";
    private static final String TAG_ORF_IMAGE_PROCESSING_IFD_POINTER = "ImageProcessingIFDPointer";
    public static final String TAG_ORF_PREVIEW_IMAGE_LENGTH = "PreviewImageLength";
    public static final String TAG_ORF_PREVIEW_IMAGE_START = "PreviewImageStart";
    public static final String TAG_ORF_THUMBNAIL_IMAGE = "ThumbnailImage";
    public static final String TAG_ORIENTATION = "Orientation";
    public static final String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";
    public static final String TAG_PIXEL_X_DIMENSION = "PixelXDimension";
    public static final String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";
    public static final String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";
    public static final String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";
    private static final d TAG_RAF_IMAGE_SIZE = new d(TAG_STRIP_OFFSETS, i.CTRL_INDEX, 3, (byte) 0);
    public static final String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";
    public static final String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";
    public static final String TAG_RESOLUTION_UNIT = "ResolutionUnit";
    public static final String TAG_ROWS_PER_STRIP = "RowsPerStrip";
    public static final String TAG_RW2_ISO = "ISO";
    public static final String TAG_RW2_JPG_FROM_RAW = "JpgFromRaw";
    public static final String TAG_RW2_SENSOR_BOTTOM_BORDER = "SensorBottomBorder";
    public static final String TAG_RW2_SENSOR_LEFT_BORDER = "SensorLeftBorder";
    public static final String TAG_RW2_SENSOR_RIGHT_BORDER = "SensorRightBorder";
    public static final String TAG_RW2_SENSOR_TOP_BORDER = "SensorTopBorder";
    public static final String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";
    public static final String TAG_SATURATION = "Saturation";
    public static final String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";
    public static final String TAG_SCENE_TYPE = "SceneType";
    public static final String TAG_SENSING_METHOD = "SensingMethod";
    public static final String TAG_SHARPNESS = "Sharpness";
    public static final String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";
    public static final String TAG_SOFTWARE = "Software";
    public static final String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";
    public static final String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";
    public static final String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";
    public static final String TAG_STRIP_OFFSETS = "StripOffsets";
    public static final String TAG_SUBFILE_TYPE = "SubfileType";
    public static final String TAG_SUBJECT_AREA = "SubjectArea";
    public static final String TAG_SUBJECT_DISTANCE = "SubjectDistance";
    public static final String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";
    public static final String TAG_SUBJECT_LOCATION = "SubjectLocation";
    public static final String TAG_SUBSEC_TIME = "SubSecTime";
    public static final String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";
    public static final String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";
    private static final String TAG_SUB_IFD_POINTER = "SubIFDPointer";
    private static final String TAG_THUMBNAIL_DATA = "ThumbnailData";
    public static final String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
    public static final String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";
    private static final String TAG_THUMBNAIL_LENGTH = "ThumbnailLength";
    private static final String TAG_THUMBNAIL_OFFSET = "ThumbnailOffset";
    public static final String TAG_TRANSFER_FUNCTION = "TransferFunction";
    public static final String TAG_USER_COMMENT = "UserComment";
    public static final String TAG_WHITE_BALANCE = "WhiteBalance";
    public static final String TAG_WHITE_POINT = "WhitePoint";
    public static final String TAG_X_RESOLUTION = "XResolution";
    public static final String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
    public static final String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
    public static final String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
    public static final String TAG_Y_RESOLUTION = "YResolution";
    private static final byte[] nA = new byte[]{(byte) 79, (byte) 76, (byte) 89, (byte) 77, (byte) 80, (byte) 85, (byte) 83, (byte) 0, (byte) 73, (byte) 73};
    private static SimpleDateFormat nB;
    private static final String[] nC = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};
    private static final int[] nD = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    private static final byte[] nE = new byte[]{(byte) 65, (byte) 83, (byte) 67, (byte) 73, (byte) 73, (byte) 0, (byte) 0, (byte) 0};
    private static final int[] nF = new int[]{8, 8, 8};
    private static final int[] nG = new int[]{4};
    private static final int[] nH = new int[]{8};
    private static final d[] nI = new d[]{new d(TAG_NEW_SUBFILE_TYPE, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i.CTRL_BYTE, 4, (byte) 0), new d(TAG_SUBFILE_TYPE, 255, 4, (byte) 0), new d(TAG_IMAGE_WIDTH, 256), new d(TAG_IMAGE_LENGTH, 257), new d(TAG_BITS_PER_SAMPLE, 258, 3, (byte) 0), new d(TAG_COMPRESSION, 259, 3, (byte) 0), new d(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3, (byte) 0), new d(TAG_IMAGE_DESCRIPTION, 270, 2, (byte) 0), new d(TAG_MAKE, b$a.CTRL_INDEX, 2, (byte) 0), new d(TAG_MODEL, e.CTRL_INDEX, 2, (byte) 0), new d(TAG_STRIP_OFFSETS, i.CTRL_INDEX), new d(TAG_ORIENTATION, 274, 3, (byte) 0), new d(TAG_SAMPLES_PER_PIXEL, 277, 3, (byte) 0), new d(TAG_ROWS_PER_STRIP, 278), new d(TAG_STRIP_BYTE_COUNTS, 279), new d(TAG_X_RESOLUTION, 282, 5, (byte) 0), new d(TAG_Y_RESOLUTION, bo.CTRL_INDEX, 5, (byte) 0), new d(TAG_PLANAR_CONFIGURATION, bk.CTRL_INDEX, 3, (byte) 0), new d(TAG_RESOLUTION_UNIT, 296, 3, (byte) 0), new d(TAG_TRANSFER_FUNCTION, 301, 3, (byte) 0), new d(TAG_SOFTWARE, 305, 2, (byte) 0), new d(TAG_DATETIME, 306, 2, (byte) 0), new d(TAG_ARTIST, com.tencent.mm.plugin.appbrand.jsapi.wifi.e.CTRL_INDEX, 2, (byte) 0), new d(TAG_WHITE_POINT, b.CTRL_INDEX, 5, (byte) 0), new d(TAG_PRIMARY_CHROMATICITIES, 319, 5, (byte) 0), new d(TAG_SUB_IFD_POINTER, 330, 4, (byte) 0), new d(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4, (byte) 0), new d(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4, (byte) 0), new d(TAG_Y_CB_CR_COEFFICIENTS, 529, 5, (byte) 0), new d(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3, (byte) 0), new d(TAG_Y_CB_CR_POSITIONING, 531, 3, (byte) 0), new d(TAG_REFERENCE_BLACK_WHITE, 532, 5, (byte) 0), new d(TAG_COPYRIGHT, 33432, 2, (byte) 0), new d(TAG_EXIF_IFD_POINTER, 34665, 4, (byte) 0), new d(TAG_GPS_INFO_IFD_POINTER, 34853, 4, (byte) 0), new d(TAG_RW2_SENSOR_TOP_BORDER, 4, 4, (byte) 0), new d(TAG_RW2_SENSOR_LEFT_BORDER, 5, 4, (byte) 0), new d(TAG_RW2_SENSOR_BOTTOM_BORDER, 6, 4, (byte) 0), new d(TAG_RW2_SENSOR_RIGHT_BORDER, 7, 4, (byte) 0), new d(TAG_RW2_ISO, 23, 3, (byte) 0), new d(TAG_RW2_JPG_FROM_RAW, 46, 7, (byte) 0)};
    private static final d[] nJ = new d[]{new d(TAG_EXPOSURE_TIME, 33434, 5, (byte) 0), new d(TAG_F_NUMBER, 33437, 5, (byte) 0), new d(TAG_EXPOSURE_PROGRAM, 34850, 3, (byte) 0), new d(TAG_SPECTRAL_SENSITIVITY, 34852, 2, (byte) 0), new d(TAG_ISO_SPEED_RATINGS, 34855, 3, (byte) 0), new d(TAG_OECF, 34856, 7, (byte) 0), new d(TAG_EXIF_VERSION, 36864, 2, (byte) 0), new d(TAG_DATETIME_ORIGINAL, 36867, 2, (byte) 0), new d(TAG_DATETIME_DIGITIZED, 36868, 2, (byte) 0), new d(TAG_COMPONENTS_CONFIGURATION, 37121, 7, (byte) 0), new d(TAG_COMPRESSED_BITS_PER_PIXEL, 37122, 5, (byte) 0), new d(TAG_SHUTTER_SPEED_VALUE, 37377, 10, (byte) 0), new d(TAG_APERTURE_VALUE, 37378, 5, (byte) 0), new d(TAG_BRIGHTNESS_VALUE, 37379, 10, (byte) 0), new d(TAG_EXPOSURE_BIAS_VALUE, 37380, 10, (byte) 0), new d(TAG_MAX_APERTURE_VALUE, 37381, 5, (byte) 0), new d(TAG_SUBJECT_DISTANCE, 37382, 5, (byte) 0), new d(TAG_METERING_MODE, 37383, 3, (byte) 0), new d(TAG_LIGHT_SOURCE, 37384, 3, (byte) 0), new d(TAG_FLASH, 37385, 3, (byte) 0), new d(TAG_FOCAL_LENGTH, 37386, 5, (byte) 0), new d(TAG_SUBJECT_AREA, 37396, 3, (byte) 0), new d(TAG_MAKER_NOTE, 37500, 7, (byte) 0), new d(TAG_USER_COMMENT, 37510, 7, (byte) 0), new d(TAG_SUBSEC_TIME, 37520, 2, (byte) 0), new d(TAG_SUBSEC_TIME_ORIGINAL, 37521, 2, (byte) 0), new d(TAG_SUBSEC_TIME_DIGITIZED, 37522, 2, (byte) 0), new d(TAG_FLASHPIX_VERSION, 40960, 7, (byte) 0), new d(TAG_COLOR_SPACE, 40961, 3, (byte) 0), new d(TAG_PIXEL_X_DIMENSION, 40962), new d(TAG_PIXEL_Y_DIMENSION, 40963), new d(TAG_RELATED_SOUND_FILE, 40964, 2, (byte) 0), new d(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4, (byte) 0), new d(TAG_FLASH_ENERGY, 41483, 5, (byte) 0), new d(TAG_SPATIAL_FREQUENCY_RESPONSE, 41484, 7, (byte) 0), new d(TAG_FOCAL_PLANE_X_RESOLUTION, 41486, 5, (byte) 0), new d(TAG_FOCAL_PLANE_Y_RESOLUTION, 41487, 5, (byte) 0), new d(TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3, (byte) 0), new d(TAG_SUBJECT_LOCATION, 41492, 3, (byte) 0), new d(TAG_EXPOSURE_INDEX, 41493, 5, (byte) 0), new d(TAG_SENSING_METHOD, 41495, 3, (byte) 0), new d(TAG_FILE_SOURCE, 41728, 7, (byte) 0), new d(TAG_SCENE_TYPE, 41729, 7, (byte) 0), new d(TAG_CFA_PATTERN, 41730, 7, (byte) 0), new d(TAG_CUSTOM_RENDERED, 41985, 3, (byte) 0), new d(TAG_EXPOSURE_MODE, 41986, 3, (byte) 0), new d(TAG_WHITE_BALANCE, 41987, 3, (byte) 0), new d(TAG_DIGITAL_ZOOM_RATIO, 41988, 5, (byte) 0), new d(TAG_FOCAL_LENGTH_IN_35MM_FILM, 41989, 3, (byte) 0), new d(TAG_SCENE_CAPTURE_TYPE, 41990, 3, (byte) 0), new d(TAG_GAIN_CONTROL, 41991, 3, (byte) 0), new d(TAG_CONTRAST, 41992, 3, (byte) 0), new d(TAG_SATURATION, 41993, 3, (byte) 0), new d(TAG_SHARPNESS, 41994, 3, (byte) 0), new d(TAG_DEVICE_SETTING_DESCRIPTION, 41995, 7, (byte) 0), new d(TAG_SUBJECT_DISTANCE_RANGE, 41996, 3, (byte) 0), new d(TAG_IMAGE_UNIQUE_ID, 42016, 2, (byte) 0), new d(TAG_DNG_VERSION, 50706, 1, (byte) 0), new d(TAG_DEFAULT_CROP_SIZE, 50720)};
    private static final d[] nK = new d[]{new d(TAG_GPS_VERSION_ID, 0, 1, (byte) 0), new d(TAG_GPS_LATITUDE_REF, 1, 2, (byte) 0), new d(TAG_GPS_LATITUDE, 2, 5, (byte) 0), new d(TAG_GPS_LONGITUDE_REF, 3, 2, (byte) 0), new d(TAG_GPS_LONGITUDE, 4, 5, (byte) 0), new d(TAG_GPS_ALTITUDE_REF, 5, 1, (byte) 0), new d(TAG_GPS_ALTITUDE, 6, 5, (byte) 0), new d(TAG_GPS_TIMESTAMP, 7, 5, (byte) 0), new d(TAG_GPS_SATELLITES, 8, 2, (byte) 0), new d(TAG_GPS_STATUS, 9, 2, (byte) 0), new d(TAG_GPS_MEASURE_MODE, 10, 2, (byte) 0), new d(TAG_GPS_DOP, 11, 5, (byte) 0), new d(TAG_GPS_SPEED_REF, 12, 2, (byte) 0), new d(TAG_GPS_SPEED, 13, 5, (byte) 0), new d(TAG_GPS_TRACK_REF, 14, 2, (byte) 0), new d(TAG_GPS_TRACK, 15, 5, (byte) 0), new d(TAG_GPS_IMG_DIRECTION_REF, 16, 2, (byte) 0), new d(TAG_GPS_IMG_DIRECTION, 17, 5, (byte) 0), new d(TAG_GPS_MAP_DATUM, 18, 2, (byte) 0), new d(TAG_GPS_DEST_LATITUDE_REF, 19, 2, (byte) 0), new d(TAG_GPS_DEST_LATITUDE, 20, 5, (byte) 0), new d(TAG_GPS_DEST_LONGITUDE_REF, 21, 2, (byte) 0), new d(TAG_GPS_DEST_LONGITUDE, 22, 5, (byte) 0), new d(TAG_GPS_DEST_BEARING_REF, 23, 2, (byte) 0), new d(TAG_GPS_DEST_BEARING, 24, 5, (byte) 0), new d(TAG_GPS_DEST_DISTANCE_REF, 25, 2, (byte) 0), new d(TAG_GPS_DEST_DISTANCE, 26, 5, (byte) 0), new d(TAG_GPS_PROCESSING_METHOD, 27, 7, (byte) 0), new d(TAG_GPS_AREA_INFORMATION, 28, 7, (byte) 0), new d(TAG_GPS_DATESTAMP, 29, 2, (byte) 0), new d(TAG_GPS_DIFFERENTIAL, 30, 3, (byte) 0)};
    private static final d[] nL = new d[]{new d(TAG_INTEROPERABILITY_INDEX, 1, 2, (byte) 0)};
    private static final d[] nM = new d[]{new d(TAG_NEW_SUBFILE_TYPE, com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i.CTRL_BYTE, 4, (byte) 0), new d(TAG_SUBFILE_TYPE, 255, 4, (byte) 0), new d(TAG_THUMBNAIL_IMAGE_WIDTH, 256), new d(TAG_THUMBNAIL_IMAGE_LENGTH, 257), new d(TAG_BITS_PER_SAMPLE, 258, 3, (byte) 0), new d(TAG_COMPRESSION, 259, 3, (byte) 0), new d(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3, (byte) 0), new d(TAG_IMAGE_DESCRIPTION, 270, 2, (byte) 0), new d(TAG_MAKE, b$a.CTRL_INDEX, 2, (byte) 0), new d(TAG_MODEL, e.CTRL_INDEX, 2, (byte) 0), new d(TAG_STRIP_OFFSETS, i.CTRL_INDEX), new d(TAG_ORIENTATION, 274, 3, (byte) 0), new d(TAG_SAMPLES_PER_PIXEL, 277, 3, (byte) 0), new d(TAG_ROWS_PER_STRIP, 278), new d(TAG_STRIP_BYTE_COUNTS, 279), new d(TAG_X_RESOLUTION, 282, 5, (byte) 0), new d(TAG_Y_RESOLUTION, bo.CTRL_INDEX, 5, (byte) 0), new d(TAG_PLANAR_CONFIGURATION, bk.CTRL_INDEX, 3, (byte) 0), new d(TAG_RESOLUTION_UNIT, 296, 3, (byte) 0), new d(TAG_TRANSFER_FUNCTION, 301, 3, (byte) 0), new d(TAG_SOFTWARE, 305, 2, (byte) 0), new d(TAG_DATETIME, 306, 2, (byte) 0), new d(TAG_ARTIST, com.tencent.mm.plugin.appbrand.jsapi.wifi.e.CTRL_INDEX, 2, (byte) 0), new d(TAG_WHITE_POINT, b.CTRL_INDEX, 5, (byte) 0), new d(TAG_PRIMARY_CHROMATICITIES, 319, 5, (byte) 0), new d(TAG_SUB_IFD_POINTER, 330, 4, (byte) 0), new d(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4, (byte) 0), new d(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4, (byte) 0), new d(TAG_Y_CB_CR_COEFFICIENTS, 529, 5, (byte) 0), new d(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3, (byte) 0), new d(TAG_Y_CB_CR_POSITIONING, 531, 3, (byte) 0), new d(TAG_REFERENCE_BLACK_WHITE, 532, 5, (byte) 0), new d(TAG_COPYRIGHT, 33432, 2, (byte) 0), new d(TAG_EXIF_IFD_POINTER, 34665, 4, (byte) 0), new d(TAG_GPS_INFO_IFD_POINTER, 34853, 4, (byte) 0), new d(TAG_DNG_VERSION, 50706, 1, (byte) 0), new d(TAG_DEFAULT_CROP_SIZE, 50720)};
    private static final d[] nN = new d[]{new d(TAG_ORF_THUMBNAIL_IMAGE, 256, 7, (byte) 0), new d(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 4, (byte) 0), new d(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 4, (byte) 0)};
    private static final d[] nO = new d[]{new d(TAG_ORF_PREVIEW_IMAGE_START, 257, 4, (byte) 0), new d(TAG_ORF_PREVIEW_IMAGE_LENGTH, 258, 4, (byte) 0)};
    private static final d[] nP = new d[]{new d(TAG_ORF_ASPECT_FRAME, 4371, 3, (byte) 0)};
    private static final d[] nQ = new d[]{new d(TAG_COLOR_SPACE, 55, 3, (byte) 0)};
    private static final d[][] nR = new d[][]{nI, nJ, nK, nL, nM, nI, nN, nO, nP, nQ};
    private static final d[] nS = new d[]{new d(TAG_SUB_IFD_POINTER, 330, 4, (byte) 0), new d(TAG_EXIF_IFD_POINTER, 34665, 4, (byte) 0), new d(TAG_GPS_INFO_IFD_POINTER, 34853, 4, (byte) 0), new d(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4, (byte) 0), new d(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 1, (byte) 0), new d(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 1, (byte) 0)};
    private static final d nT = new d(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4, (byte) 0);
    private static final d nU = new d(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4, (byte) 0);
    private static final HashMap[] nV = new HashMap[nR.length];
    private static final HashMap[] nW = new HashMap[nR.length];
    private static final HashSet<String> nX = new HashSet(Arrays.asList(new String[]{TAG_F_NUMBER, TAG_DIGITAL_ZOOM_RATIO, TAG_EXPOSURE_TIME, TAG_SUBJECT_DISTANCE, TAG_GPS_TIMESTAMP}));
    private static final HashMap nY = new HashMap();
    private static final Charset nZ = Charset.forName("US-ASCII");
    private static final byte[] ny = new byte[]{(byte) -1, (byte) -40, (byte) -1};
    private static final byte[] nz = new byte[]{(byte) 79, (byte) 76, (byte) 89, (byte) 77, (byte) 80, (byte) 0};
    private static final byte[] oa = "Exif\u0000\u0000".getBytes(nZ);
    private static final Pattern ot = Pattern.compile(".*[1-9].*");
    private static final Pattern ou = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
    private final String ob;
    private final AssetInputStream oc;
    private int od;
    private final HashMap[] oe = new HashMap[nR.length];
    private ByteOrder of = ByteOrder.BIG_ENDIAN;
    private boolean og;
    private int oh;
    private int oi;
    private byte[] oj;
    private int ok;
    private int ol;
    private int om;
    private int oo;
    private int oq;
    private int or;
    private boolean os;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        nB = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        for (int i = 0; i < nR.length; i++) {
            nV[i] = new HashMap();
            nW[i] = new HashMap();
            for (d dVar : nR[i]) {
                nV[i].put(Integer.valueOf(dVar.number), dVar);
                nW[i].put(dVar.name, dVar);
            }
        }
        nY.put(Integer.valueOf(nS[0].number), Integer.valueOf(5));
        nY.put(Integer.valueOf(nS[1].number), Integer.valueOf(1));
        nY.put(Integer.valueOf(nS[2].number), Integer.valueOf(2));
        nY.put(Integer.valueOf(nS[3].number), Integer.valueOf(3));
        nY.put(Integer.valueOf(nS[4].number), Integer.valueOf(7));
        nY.put(Integer.valueOf(nS[5].number), Integer.valueOf(8));
    }

    public a(String str) {
        Throwable th;
        if (str == null) {
            throw new IllegalArgumentException("filename cannot be null");
        }
        this.oc = null;
        this.ob = str;
        Closeable fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                b((InputStream) fileInputStream);
                b(fileInputStream);
            } catch (Throwable th2) {
                th = th2;
                b(fileInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            b(fileInputStream);
            throw th;
        }
    }

    public final String getAttribute(String str) {
        c cVar;
        for (int i = 0; i < nR.length; i++) {
            Object obj = this.oe[i].get(str);
            if (obj != null) {
                cVar = (c) obj;
                break;
            }
        }
        cVar = null;
        if (cVar == null) {
            return null;
        }
        if (!nX.contains(str)) {
            return cVar.c(this.of);
        }
        e[] eVarArr;
        if (!str.equals(TAG_GPS_TIMESTAMP)) {
            try {
                obj = cVar.a(this.of);
                if (obj == null) {
                    throw new NumberFormatException("NULL can't be converted to a double value");
                }
                double parseDouble;
                if (obj instanceof String) {
                    parseDouble = Double.parseDouble((String) obj);
                } else if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    if (jArr.length == 1) {
                        parseDouble = (double) jArr[0];
                    } else {
                        throw new NumberFormatException("There are more than one component");
                    }
                } else if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    if (iArr.length == 1) {
                        parseDouble = (double) iArr[0];
                    } else {
                        throw new NumberFormatException("There are more than one component");
                    }
                } else if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    if (dArr.length == 1) {
                        parseDouble = dArr[0];
                    } else {
                        throw new NumberFormatException("There are more than one component");
                    }
                } else if (obj instanceof e[]) {
                    eVarArr = (e[]) obj;
                    if (eVarArr.length == 1) {
                        e eVar = eVarArr[0];
                        parseDouble = ((double) eVar.oC) / ((double) eVar.oD);
                    } else {
                        throw new NumberFormatException("There are more than one component");
                    }
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
                return Double.toString(parseDouble);
            } catch (NumberFormatException e) {
                return null;
            }
        } else if (cVar.format == 5 || cVar.format == 10) {
            eVarArr = (e[]) cVar.a(this.of);
            if (eVarArr == null || eVarArr.length != 3) {
                new StringBuilder("Invalid GPS Timestamp array. array=").append(Arrays.toString(eVarArr));
                return null;
            }
            return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (((float) eVarArr[0].oC) / ((float) eVarArr[0].oD))), Integer.valueOf((int) (((float) eVarArr[1].oC) / ((float) eVarArr[1].oD))), Integer.valueOf((int) (((float) eVarArr[2].oC) / ((float) eVarArr[2].oD)))});
        } else {
            new StringBuilder("GPS Timestamp format is not rational. format=").append(cVar.format);
            return null;
        }
    }

    public final void setAttribute(String str, String str2) {
        if (str2 != null && nX.contains(str)) {
            if (str.equals(TAG_GPS_TIMESTAMP)) {
                Matcher matcher = ou.matcher(str2);
                if (matcher.find()) {
                    str2 = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
                } else {
                    new StringBuilder("Invalid value for ").append(str).append(" : ").append(str2);
                    return;
                }
            }
            try {
                str2 = ((long) (Double.parseDouble(str2) * 10000.0d)) + "/10000";
            } catch (NumberFormatException e) {
                new StringBuilder("Invalid value for ").append(str).append(" : ").append(str2);
                return;
            }
        }
        for (int i = 0; i < nR.length; i++) {
            if (i != 4 || this.og) {
                Object obj = nW[i].get(str);
                if (obj != null) {
                    if (str2 != null) {
                        int i2;
                        d dVar = (d) obj;
                        Pair j = j(str2);
                        if (dVar.oA == ((Integer) j.first).intValue() || dVar.oA == ((Integer) j.second).intValue()) {
                            i2 = dVar.oA;
                        } else if (dVar.oB != -1 && (dVar.oB == ((Integer) j.first).intValue() || dVar.oB == ((Integer) j.second).intValue())) {
                            i2 = dVar.oB;
                        } else if (dVar.oA == 1 || dVar.oA == 7 || dVar.oA == 2) {
                            i2 = dVar.oA;
                        } else {
                            String str3;
                            StringBuilder append = new StringBuilder("Given tag (").append(str).append(") value didn't match with one of expected formats: ").append(nC[dVar.oA]).append(dVar.oB == -1 ? "" : ", " + nC[dVar.oB]).append(" (guess: ").append(nC[((Integer) j.first).intValue()]);
                            if (((Integer) j.second).intValue() == -1) {
                                str3 = "";
                            } else {
                                str3 = ", " + nC[((Integer) j.second).intValue()];
                            }
                            append.append(str3).append(")");
                        }
                        String[] split;
                        int[] iArr;
                        String[] split2;
                        e[] eVarArr;
                        String[] split3;
                        switch (i2) {
                            case 1:
                                HashMap hashMap = this.oe[i];
                                if (str2.length() != 1 || str2.charAt(0) < '0' || str2.charAt(0) > '1') {
                                    byte[] bytes = str2.getBytes(nZ);
                                    obj = new c(1, bytes.length, bytes);
                                } else {
                                    obj = new c(1, 1, new byte[]{(byte) (str2.charAt(0) - 48)});
                                }
                                hashMap.put(str, obj);
                                break;
                            case 2:
                            case 7:
                                this.oe[i].put(str, c.k(str2));
                                break;
                            case 3:
                                split = str2.split(",");
                                iArr = new int[split.length];
                                for (i2 = 0; i2 < split.length; i2++) {
                                    iArr[i2] = Integer.parseInt(split[i2]);
                                }
                                this.oe[i].put(str, c.a(iArr, this.of));
                                break;
                            case 4:
                                split = str2.split(",");
                                long[] jArr = new long[split.length];
                                for (i2 = 0; i2 < split.length; i2++) {
                                    jArr[i2] = Long.parseLong(split[i2]);
                                }
                                this.oe[i].put(str, c.a(jArr, this.of));
                                break;
                            case 5:
                                split2 = str2.split(",");
                                eVarArr = new e[split2.length];
                                for (i2 = 0; i2 < split2.length; i2++) {
                                    split3 = split2[i2].split("/");
                                    eVarArr[i2] = new e((long) Double.parseDouble(split3[0]), (long) Double.parseDouble(split3[1]), (byte) 0);
                                }
                                this.oe[i].put(str, c.a(eVarArr, this.of));
                                break;
                            case 9:
                                split = str2.split(",");
                                iArr = new int[split.length];
                                for (i2 = 0; i2 < split.length; i2++) {
                                    iArr[i2] = Integer.parseInt(split[i2]);
                                }
                                this.oe[i].put(str, c.b(iArr, this.of));
                                break;
                            case 10:
                                split2 = str2.split(",");
                                eVarArr = new e[split2.length];
                                for (i2 = 0; i2 < split2.length; i2++) {
                                    split3 = split2[i2].split("/");
                                    eVarArr[i2] = new e((long) Double.parseDouble(split3[0]), (long) Double.parseDouble(split3[1]), (byte) 0);
                                }
                                this.oe[i].put(str, c.b(eVarArr, this.of));
                                break;
                            case 12:
                                split = str2.split(",");
                                double[] dArr = new double[split.length];
                                for (i2 = 0; i2 < split.length; i2++) {
                                    dArr[i2] = Double.parseDouble(split[i2]);
                                }
                                this.oe[i].put(str, c.a(dArr, this.of));
                                break;
                            default:
                                break;
                        }
                    }
                    this.oe[i].remove(str);
                }
            }
        }
    }

    private void removeAttribute(String str) {
        for (int i = 0; i < nR.length; i++) {
            this.oe[i].remove(str);
        }
    }

    private void b(InputStream inputStream) {
        int i = 0;
        while (i < nR.length) {
            try {
                this.oe[i] = new HashMap();
                i++;
            } catch (IOException e) {
                this.os = false;
            } finally {
                aF();
            }
        }
        InputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
        BufferedInputStream bufferedInputStream2 = (BufferedInputStream) bufferedInputStream;
        bufferedInputStream2.mark(5000);
        byte[] bArr = new byte[5000];
        if (bufferedInputStream2.read(bArr) != 5000) {
            throw new EOFException();
        }
        Object obj;
        c cVar;
        c cVar2;
        int[] iArr;
        int i2;
        bufferedInputStream2.reset();
        if (d(bArr)) {
            i = 4;
        } else if (e(bArr)) {
            i = 9;
        } else {
            a aVar = new a(bArr);
            this.of = c(aVar);
            aVar.ow = this.of;
            short readShort = aVar.readShort();
            aVar.close();
            obj = (readShort == (short) 20306 || readShort == (short) 21330) ? 1 : null;
            if (obj != null) {
                i = 7;
            } else {
                aVar = new a(bArr);
                this.of = c(aVar);
                aVar.ow = this.of;
                short readShort2 = aVar.readShort();
                aVar.close();
                i = (readShort2 == (short) 85 ? 1 : null) != null ? 10 : 0;
            }
        }
        this.od = i;
        a aVar2 = new a(bufferedInputStream);
        switch (this.od) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
                a(aVar2);
                break;
            case 4:
                a(aVar2, 0, 0);
                break;
            case 7:
                a(aVar2);
                cVar = (c) this.oe[1].get(TAG_MAKER_NOTE);
                if (cVar != null) {
                    a aVar3 = new a(cVar.oz);
                    aVar3.ow = this.of;
                    byte[] bArr2 = new byte[nz.length];
                    aVar3.readFully(bArr2);
                    aVar3.seek(0);
                    byte[] bArr3 = new byte[nA.length];
                    aVar3.readFully(bArr3);
                    if (Arrays.equals(bArr2, nz)) {
                        aVar3.seek(8);
                    } else if (Arrays.equals(bArr3, nA)) {
                        aVar3.seek(12);
                    }
                    b(aVar3, 6);
                    cVar = (c) this.oe[7].get(TAG_ORF_PREVIEW_IMAGE_START);
                    cVar2 = (c) this.oe[7].get(TAG_ORF_PREVIEW_IMAGE_LENGTH);
                    if (!(cVar == null || cVar2 == null)) {
                        this.oe[5].put(TAG_JPEG_INTERCHANGE_FORMAT, cVar);
                        this.oe[5].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, cVar2);
                    }
                    cVar = (c) this.oe[8].get(TAG_ORF_ASPECT_FRAME);
                    if (cVar != null) {
                        iArr = (int[]) cVar.a(this.of);
                        if (iArr != null && iArr.length == 4) {
                            if (iArr[2] > iArr[0] && iArr[3] > iArr[1]) {
                                i2 = (iArr[2] - iArr[0]) + 1;
                                i = (iArr[3] - iArr[1]) + 1;
                                if (i2 < i) {
                                    i2 += i;
                                    i = i2 - i;
                                    i2 -= i;
                                }
                                cVar2 = c.a(i2, this.of);
                                cVar = c.a(i, this.of);
                                this.oe[0].put(TAG_IMAGE_WIDTH, cVar2);
                                this.oe[0].put(TAG_IMAGE_LENGTH, cVar);
                                break;
                            }
                        }
                        new StringBuilder("Invalid aspect frame values. frame=").append(Arrays.toString(iArr));
                        break;
                    }
                }
                break;
            case 9:
                b(aVar2);
                break;
            case 10:
                a(aVar2);
                if (((c) this.oe[0].get(TAG_RW2_JPG_FROM_RAW)) != null) {
                    a(aVar2, this.or, 5);
                }
                cVar = (c) this.oe[0].get(TAG_RW2_ISO);
                cVar2 = (c) this.oe[1].get(TAG_ISO_SPEED_RATINGS);
                if (cVar != null && cVar2 == null) {
                    this.oe[1].put(TAG_ISO_SPEED_RATINGS, cVar);
                    break;
                }
        }
        HashMap hashMap = this.oe[4];
        cVar = (c) hashMap.get(TAG_COMPRESSION);
        if (cVar != null) {
            this.ok = cVar.b(this.of);
            switch (this.ok) {
                case 1:
                case 7:
                    cVar = (c) hashMap.get(TAG_BITS_PER_SAMPLE);
                    if (cVar != null) {
                        iArr = (int[]) cVar.a(this.of);
                        if (Arrays.equals(nF, iArr)) {
                            obj = 1;
                        } else if (this.od == 3) {
                            cVar2 = (c) hashMap.get(TAG_PHOTOMETRIC_INTERPRETATION);
                            if (cVar2 != null) {
                                i2 = cVar2.b(this.of);
                                if ((i2 == 1 && Arrays.equals(iArr, nH)) || (i2 == 6 && Arrays.equals(iArr, nF))) {
                                    i = 1;
                                }
                            }
                        }
                        if (obj != null) {
                            b(aVar2, hashMap);
                            break;
                        }
                    }
                    obj = null;
                    if (obj != null) {
                        b(aVar2, hashMap);
                    }
                    break;
                case 6:
                    a(aVar2, hashMap);
                    break;
            }
        }
        this.ok = 6;
        a(aVar2, hashMap);
        this.os = true;
    }

    public final void saveAttributes() {
        Closeable fileOutputStream;
        Throwable th;
        Closeable closeable = null;
        if (!this.os || this.od != 4) {
            throw new IOException("ExifInterface only supports saving attributes on JPEG formats.");
        } else if (this.ob == null) {
            throw new IOException("ExifInterface does not support saving attributes for the current input.");
        } else {
            byte[] aE = (this.ok == 6 || this.ok == 7) ? aE() : null;
            this.oj = aE;
            File file = new File(this.ob + ".tmp");
            if (new File(this.ob).renameTo(file)) {
                try {
                    Closeable fileInputStream = new FileInputStream(file);
                    try {
                        fileOutputStream = new FileOutputStream(this.ob);
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileInputStream;
                        b(fileOutputStream);
                        b(closeable);
                        file.delete();
                        throw th;
                    }
                    try {
                        a((InputStream) fileInputStream, (OutputStream) fileOutputStream);
                        b(fileInputStream);
                        b(fileOutputStream);
                        file.delete();
                        this.oj = null;
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        closeable = fileOutputStream;
                        fileOutputStream = fileInputStream;
                        b(fileOutputStream);
                        b(closeable);
                        file.delete();
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                    b(fileOutputStream);
                    b(closeable);
                    file.delete();
                    throw th;
                }
            }
            throw new IOException("Could not rename to " + file.getAbsolutePath());
        }
    }

    private byte[] aE() {
        Closeable closeable;
        Closeable closeable2;
        Throwable th;
        if (!this.og) {
            return null;
        }
        if (this.oj != null) {
            return this.oj;
        }
        try {
            if (this.oc != null) {
                closeable = this.oc;
                try {
                    if (closeable.markSupported()) {
                        closeable.reset();
                        closeable2 = closeable;
                    } else {
                        b(closeable);
                        return null;
                    }
                } catch (IOException e) {
                    b(closeable);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    closeable2 = closeable;
                    b(closeable2);
                    throw th;
                }
            }
            closeable2 = this.ob != null ? new FileInputStream(this.ob) : null;
            if (closeable2 == null) {
                try {
                    throw new FileNotFoundException();
                } catch (IOException e2) {
                    closeable = closeable2;
                    b(closeable);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    b(closeable2);
                    throw th;
                }
            } else if (closeable2.skip((long) this.oh) != ((long) this.oh)) {
                throw new IOException("Corrupted image");
            } else {
                byte[] bArr = new byte[this.oi];
                if (closeable2.read(bArr) != this.oi) {
                    throw new IOException("Corrupted image");
                }
                this.oj = bArr;
                b(closeable2);
                return bArr;
            }
        } catch (IOException e3) {
            closeable = null;
            b(closeable);
            return null;
        } catch (Throwable th4) {
            closeable2 = null;
            th = th4;
            b(closeable2);
            throw th;
        }
    }

    private static boolean d(byte[] bArr) {
        for (int i = 0; i < ny.length; i++) {
            if (bArr[i] != ny[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean e(byte[] bArr) {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i = 0; i < bytes.length; i++) {
            if (bArr[i] != bytes[i]) {
                return false;
            }
        }
        return true;
    }

    private void a(a aVar, int i, int i2) {
        aVar.ow = ByteOrder.BIG_ENDIAN;
        aVar.seek((long) i);
        byte readByte = aVar.readByte();
        if (readByte != (byte) -1) {
            throw new IOException("Invalid marker: " + Integer.toHexString(readByte & 255));
        }
        int i3 = i + 1;
        if (aVar.readByte() != (byte) -40) {
            throw new IOException("Invalid marker: " + Integer.toHexString(readByte & 255));
        }
        int i4 = i3 + 1;
        while (true) {
            byte readByte2 = aVar.readByte();
            if (readByte2 != (byte) -1) {
                throw new IOException("Invalid marker:" + Integer.toHexString(readByte2 & 255));
            }
            i4++;
            byte readByte3 = aVar.readByte();
            i3 = i4 + 1;
            if (readByte3 == (byte) -39 || readByte3 == (byte) -38) {
                aVar.ow = this.of;
                return;
            }
            i4 = aVar.readUnsignedShort() - 2;
            i3 += 2;
            if (i4 < 0) {
                throw new IOException("Invalid length");
            }
            byte[] bArr;
            switch (readByte3) {
                case (byte) -64:
                case (byte) -63:
                case (byte) -62:
                case (byte) -61:
                case (byte) -59:
                case (byte) -58:
                case (byte) -57:
                case (byte) -55:
                case (byte) -54:
                case (byte) -53:
                case (byte) -51:
                case (byte) -50:
                case (byte) -49:
                    if (aVar.skipBytes(1) == 1) {
                        this.oe[i2].put(TAG_IMAGE_LENGTH, c.a((long) aVar.readUnsignedShort(), this.of));
                        this.oe[i2].put(TAG_IMAGE_WIDTH, c.a((long) aVar.readUnsignedShort(), this.of));
                        i4 -= 5;
                        break;
                    }
                    throw new IOException("Invalid SOFx");
                case (byte) -31:
                    if (i4 >= 6) {
                        bArr = new byte[6];
                        if (aVar.read(bArr) == 6) {
                            i3 += 6;
                            i4 -= 6;
                            if (Arrays.equals(bArr, oa)) {
                                if (i4 > 0) {
                                    this.ol = i3;
                                    bArr = new byte[i4];
                                    if (aVar.read(bArr) == i4) {
                                        i4 += i3;
                                        a aVar2 = new a(bArr);
                                        a(aVar2, bArr.length);
                                        b(aVar2, i2);
                                        i3 = i4;
                                        i4 = 0;
                                        break;
                                    }
                                    throw new IOException("Invalid exif");
                                }
                                throw new IOException("Invalid exif");
                            }
                        }
                        throw new IOException("Invalid exif");
                    }
                    break;
                case (byte) -2:
                    bArr = new byte[i4];
                    if (aVar.read(bArr) == i4) {
                        if (getAttribute(TAG_USER_COMMENT) != null) {
                            i4 = 0;
                            break;
                        }
                        this.oe[1].put(TAG_USER_COMMENT, c.k(new String(bArr, nZ)));
                        i4 = 0;
                        break;
                    }
                    throw new IOException("Invalid exif");
            }
            if (i4 < 0) {
                throw new IOException("Invalid length");
            } else if (aVar.skipBytes(i4) != i4) {
                throw new IOException("Invalid JPEG segment");
            } else {
                i4 += i3;
            }
        }
    }

    private void a(a aVar) {
        a(aVar, aVar.available());
        b(aVar, 0);
        d(aVar, 0);
        d(aVar, 5);
        d(aVar, 4);
        i(0, 5);
        i(0, 4);
        i(5, 4);
        c cVar = (c) this.oe[1].get(TAG_PIXEL_X_DIMENSION);
        c cVar2 = (c) this.oe[1].get(TAG_PIXEL_Y_DIMENSION);
        if (!(cVar == null || cVar2 == null)) {
            this.oe[0].put(TAG_IMAGE_WIDTH, cVar);
            this.oe[0].put(TAG_IMAGE_LENGTH, cVar2);
        }
        if (this.oe[4].isEmpty() && h(this.oe[5])) {
            this.oe[4] = this.oe[5];
            this.oe[5] = new HashMap();
        }
        h(this.oe[4]);
        if (this.od == 8) {
            cVar = (c) this.oe[1].get(TAG_MAKER_NOTE);
            if (cVar != null) {
                a aVar2 = new a(cVar.oz);
                aVar2.ow = this.of;
                aVar2.seek(6);
                b(aVar2, 9);
                cVar = (c) this.oe[9].get(TAG_COLOR_SPACE);
                if (cVar != null) {
                    this.oe[1].put(TAG_COLOR_SPACE, cVar);
                }
            }
        }
    }

    private void b(a aVar) {
        aVar.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        aVar.read(bArr);
        aVar.skipBytes(4);
        aVar.read(bArr2);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        a(aVar, i, 5);
        aVar.seek((long) i2);
        aVar.ow = ByteOrder.BIG_ENDIAN;
        i2 = aVar.readInt();
        for (i = 0; i < i2; i++) {
            int readUnsignedShort = aVar.readUnsignedShort();
            int readUnsignedShort2 = aVar.readUnsignedShort();
            if (readUnsignedShort == TAG_RAF_IMAGE_SIZE.number) {
                short readShort = aVar.readShort();
                short readShort2 = aVar.readShort();
                c a = c.a(readShort, this.of);
                c a2 = c.a(readShort2, this.of);
                this.oe[0].put(TAG_IMAGE_LENGTH, a);
                this.oe[0].put(TAG_IMAGE_WIDTH, a2);
                return;
            }
            aVar.skipBytes(readUnsignedShort2);
        }
    }

    private void a(InputStream inputStream, OutputStream outputStream) {
        InputStream dataInputStream = new DataInputStream(inputStream);
        OutputStream bVar = new b(outputStream, ByteOrder.BIG_ENDIAN);
        if (dataInputStream.readByte() != (byte) -1) {
            throw new IOException("Invalid marker");
        }
        bVar.writeByte(-1);
        if (dataInputStream.readByte() != (byte) -40) {
            throw new IOException("Invalid marker");
        }
        bVar.writeByte(-40);
        bVar.writeByte(-1);
        bVar.writeByte(-31);
        a((b) bVar);
        byte[] bArr = new byte[Downloads.RECV_BUFFER_SIZE];
        while (dataInputStream.readByte() == (byte) -1) {
            byte readByte = dataInputStream.readByte();
            int readUnsignedShort;
            int read;
            switch (readByte) {
                case (byte) -39:
                case (byte) -38:
                    bVar.writeByte(-1);
                    bVar.writeByte(readByte);
                    b(dataInputStream, bVar);
                    return;
                case (byte) -31:
                    readUnsignedShort = dataInputStream.readUnsignedShort() - 2;
                    if (readUnsignedShort >= 0) {
                        byte[] bArr2 = new byte[6];
                        if (readUnsignedShort >= 6) {
                            if (dataInputStream.read(bArr2) == 6) {
                                if (Arrays.equals(bArr2, oa)) {
                                    if (dataInputStream.skipBytes(readUnsignedShort - 6) == readUnsignedShort - 6) {
                                        break;
                                    }
                                    throw new IOException("Invalid length");
                                }
                            }
                            throw new IOException("Invalid exif");
                        }
                        bVar.writeByte(-1);
                        bVar.writeByte(readByte);
                        bVar.writeShort((short) (readUnsignedShort + 2));
                        if (readUnsignedShort >= 6) {
                            readUnsignedShort -= 6;
                            bVar.write(bArr2);
                        }
                        while (readUnsignedShort > 0) {
                            read = dataInputStream.read(bArr, 0, Math.min(readUnsignedShort, Downloads.RECV_BUFFER_SIZE));
                            if (read < 0) {
                                break;
                            }
                            bVar.write(bArr, 0, read);
                            readUnsignedShort -= read;
                        }
                        break;
                    }
                    throw new IOException("Invalid length");
                default:
                    bVar.writeByte(-1);
                    bVar.writeByte(readByte);
                    readUnsignedShort = dataInputStream.readUnsignedShort();
                    bVar.writeShort((short) readUnsignedShort);
                    readUnsignedShort -= 2;
                    if (readUnsignedShort >= 0) {
                        while (readUnsignedShort > 0) {
                            read = dataInputStream.read(bArr, 0, Math.min(readUnsignedShort, Downloads.RECV_BUFFER_SIZE));
                            if (read < 0) {
                                break;
                            }
                            bVar.write(bArr, 0, read);
                            readUnsignedShort -= read;
                        }
                        break;
                    }
                    throw new IOException("Invalid length");
            }
        }
        throw new IOException("Invalid marker");
    }

    private void aF() {
        String attribute = getAttribute(TAG_DATETIME_ORIGINAL);
        if (attribute != null) {
            this.oe[0].put(TAG_DATETIME, c.k(attribute));
        }
        if (getAttribute(TAG_IMAGE_WIDTH) == null) {
            this.oe[0].put(TAG_IMAGE_WIDTH, c.a(0, this.of));
        }
        if (getAttribute(TAG_IMAGE_LENGTH) == null) {
            this.oe[0].put(TAG_IMAGE_LENGTH, c.a(0, this.of));
        }
        if (getAttribute(TAG_ORIENTATION) == null) {
            this.oe[0].put(TAG_ORIENTATION, c.a(0, this.of));
        }
        if (getAttribute(TAG_LIGHT_SOURCE) == null) {
            this.oe[1].put(TAG_LIGHT_SOURCE, c.a(0, this.of));
        }
    }

    private static ByteOrder c(a aVar) {
        short readShort = aVar.readShort();
        switch (readShort) {
            case (short) 18761:
                return ByteOrder.LITTLE_ENDIAN;
            case (short) 19789:
                return ByteOrder.BIG_ENDIAN;
            default:
                throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
        }
    }

    private void a(a aVar, int i) {
        this.of = c(aVar);
        aVar.ow = this.of;
        int readUnsignedShort = aVar.readUnsignedShort();
        if (this.od == 7 || this.od == 10 || readUnsignedShort == 42) {
            readUnsignedShort = aVar.readInt();
            if (readUnsignedShort < 8 || readUnsignedShort >= i) {
                throw new IOException("Invalid first Ifd offset: " + readUnsignedShort);
            }
            readUnsignedShort -= 8;
            if (readUnsignedShort > 0 && aVar.skipBytes(readUnsignedShort) != readUnsignedShort) {
                throw new IOException("Couldn't jump to first Ifd: " + readUnsignedShort);
            }
            return;
        }
        throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
    }

    private void b(a aVar, int i) {
        while (a.d(aVar) + 2 <= a.e(aVar)) {
            short readShort = aVar.readShort();
            if (a.d(aVar) + (readShort * 12) <= a.e(aVar)) {
                for (short s = (short) 0; s < readShort; s = (short) (s + 1)) {
                    int readUnsignedShort = aVar.readUnsignedShort();
                    int readUnsignedShort2 = aVar.readUnsignedShort();
                    int readInt = aVar.readInt();
                    long j = (long) (aVar.mPosition + 4);
                    d dVar = (d) nV[i].get(Integer.valueOf(readUnsignedShort));
                    long j2 = 0;
                    Object obj = null;
                    if (dVar != null && readUnsignedShort2 > 0 && readUnsignedShort2 < nD.length) {
                        j2 = ((long) readInt) * ((long) nD[readUnsignedShort2]);
                        if (j2 >= 0 && j2 <= 2147483647L) {
                            obj = 1;
                        }
                    }
                    if (obj == null) {
                        aVar.seek(j);
                    } else {
                        if (j2 > 4) {
                            int readInt2 = aVar.readInt();
                            if (this.od == 7) {
                                if (TAG_MAKER_NOTE.equals(dVar.name)) {
                                    this.om = readInt2;
                                } else if (i == 6 && TAG_ORF_THUMBNAIL_IMAGE.equals(dVar.name)) {
                                    this.oo = readInt2;
                                    this.oq = readInt;
                                    c a = c.a(6, this.of);
                                    c a2 = c.a((long) this.oo, this.of);
                                    c a3 = c.a((long) this.oq, this.of);
                                    this.oe[4].put(TAG_COMPRESSION, a);
                                    this.oe[4].put(TAG_JPEG_INTERCHANGE_FORMAT, a2);
                                    this.oe[4].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, a3);
                                }
                            } else if (this.od == 10 && TAG_RW2_JPG_FROM_RAW.equals(dVar.name)) {
                                this.or = readInt2;
                            }
                            if (((long) readInt2) + j2 <= ((long) a.e(aVar))) {
                                aVar.seek((long) readInt2);
                            } else {
                                aVar.seek(j);
                            }
                        }
                        obj = nY.get(Integer.valueOf(readUnsignedShort));
                        if (obj != null) {
                            j2 = -1;
                            switch (readUnsignedShort2) {
                                case 3:
                                    j2 = (long) aVar.readUnsignedShort();
                                    break;
                                case 4:
                                    j2 = aVar.aK();
                                    break;
                                case 8:
                                    j2 = (long) aVar.readShort();
                                    break;
                                case 9:
                                case 13:
                                    j2 = (long) aVar.readInt();
                                    break;
                            }
                            if (j2 > 0 && j2 < ((long) a.e(aVar))) {
                                aVar.seek(j2);
                                b(aVar, ((Integer) obj).intValue());
                            }
                            aVar.seek(j);
                        } else {
                            byte[] bArr = new byte[((int) j2)];
                            aVar.readFully(bArr);
                            c cVar = new c(readUnsignedShort2, readInt, bArr, (byte) 0);
                            this.oe[i].put(dVar.name, cVar);
                            if (TAG_DNG_VERSION.equals(dVar.name)) {
                                this.od = 3;
                            }
                            if (((TAG_MAKE.equals(dVar.name) || TAG_MODEL.equals(dVar.name)) && cVar.c(this.of).contains("PENTAX")) || (TAG_COMPRESSION.equals(dVar.name) && cVar.b(this.of) == 65535)) {
                                this.od = 8;
                            }
                            if (((long) aVar.mPosition) != j) {
                                aVar.seek(j);
                            }
                        }
                    }
                }
                if (aVar.mPosition + 4 <= a.e(aVar)) {
                    int readInt3 = aVar.readInt();
                    if (readInt3 > 8 && readInt3 < a.e(aVar)) {
                        aVar.seek((long) readInt3);
                        if (this.oe[4].isEmpty()) {
                            i = 4;
                        } else if (this.oe[5].isEmpty()) {
                            i = 5;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
    }

    private void c(a aVar, int i) {
        c cVar = (c) this.oe[i].get(TAG_IMAGE_WIDTH);
        if (((c) this.oe[i].get(TAG_IMAGE_LENGTH)) == null || cVar == null) {
            c cVar2 = (c) this.oe[i].get(TAG_JPEG_INTERCHANGE_FORMAT);
            if (cVar2 != null) {
                a(aVar, cVar2.b(this.of), i);
            }
        }
    }

    private void a(a aVar, HashMap hashMap) {
        c cVar = (c) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT);
        c cVar2 = (c) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        if (cVar != null && cVar2 != null) {
            int b = cVar.b(this.of);
            int min = Math.min(cVar2.b(this.of), aVar.available() - b);
            if (this.od == 4 || this.od == 9 || this.od == 10) {
                b += this.ol;
            } else if (this.od == 7) {
                b += this.om;
            }
            if (b > 0 && min > 0) {
                this.og = true;
                this.oh = b;
                this.oi = min;
                if (this.ob == null && this.oc == null) {
                    byte[] bArr = new byte[min];
                    aVar.seek((long) b);
                    aVar.readFully(bArr);
                    this.oj = bArr;
                }
            }
        }
    }

    private void b(a aVar, HashMap hashMap) {
        c cVar = (c) hashMap.get(TAG_STRIP_OFFSETS);
        c cVar2 = (c) hashMap.get(TAG_STRIP_BYTE_COUNTS);
        if (cVar != null && cVar2 != null) {
            long[] d = d(cVar.a(this.of));
            long[] d2 = d(cVar2.a(this.of));
            if (d != null && d2 != null) {
                long j = 0;
                for (long j2 : d2) {
                    j += j2;
                }
                Object obj = new byte[((int) j)];
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < d.length; i3++) {
                    int i4 = (int) d2[i3];
                    int i5 = ((int) d[i3]) - i2;
                    aVar.seek((long) i5);
                    i2 += i5;
                    Object obj2 = new byte[i4];
                    aVar.read(obj2);
                    i2 += i4;
                    System.arraycopy(obj2, 0, obj, i, obj2.length);
                    i += obj2.length;
                }
                this.og = true;
                this.oj = obj;
                this.oi = obj.length;
            }
        }
    }

    private boolean h(HashMap hashMap) {
        c cVar = (c) hashMap.get(TAG_IMAGE_LENGTH);
        c cVar2 = (c) hashMap.get(TAG_IMAGE_WIDTH);
        if (!(cVar == null || cVar2 == null)) {
            int b = cVar.b(this.of);
            int b2 = cVar2.b(this.of);
            if (b <= WXMediaMessage.TITLE_LENGTH_LIMIT && b2 <= WXMediaMessage.TITLE_LENGTH_LIMIT) {
                return true;
            }
        }
        return false;
    }

    private void d(a aVar, int i) {
        c cVar = (c) this.oe[i].get(TAG_DEFAULT_CROP_SIZE);
        c cVar2 = (c) this.oe[i].get(TAG_RW2_SENSOR_TOP_BORDER);
        c cVar3 = (c) this.oe[i].get(TAG_RW2_SENSOR_LEFT_BORDER);
        c cVar4 = (c) this.oe[i].get(TAG_RW2_SENSOR_BOTTOM_BORDER);
        c cVar5 = (c) this.oe[i].get(TAG_RW2_SENSOR_RIGHT_BORDER);
        if (cVar != null) {
            Object a;
            Object a2;
            if (cVar.format == 5) {
                e[] eVarArr = (e[]) cVar.a(this.of);
                if (eVarArr == null || eVarArr.length != 2) {
                    new StringBuilder("Invalid crop size values. cropSize=").append(Arrays.toString(eVarArr));
                    return;
                } else {
                    a = c.a(eVarArr[0], this.of);
                    a2 = c.a(eVarArr[1], this.of);
                }
            } else {
                int[] iArr = (int[]) cVar.a(this.of);
                if (iArr == null || iArr.length != 2) {
                    new StringBuilder("Invalid crop size values. cropSize=").append(Arrays.toString(iArr));
                    return;
                } else {
                    a = c.a(iArr[0], this.of);
                    a2 = c.a(iArr[1], this.of);
                }
            }
            this.oe[i].put(TAG_IMAGE_WIDTH, a);
            this.oe[i].put(TAG_IMAGE_LENGTH, a2);
        } else if (cVar2 == null || cVar3 == null || cVar4 == null || cVar5 == null) {
            c(aVar, i);
        } else {
            int b = cVar2.b(this.of);
            int b2 = cVar4.b(this.of);
            int b3 = cVar5.b(this.of);
            int b4 = cVar3.b(this.of);
            if (b2 > b && b3 > b4) {
                b = b2 - b;
                b2 = b3 - b4;
                cVar = c.a(b, this.of);
                cVar2 = c.a(b2, this.of);
                this.oe[i].put(TAG_IMAGE_LENGTH, cVar);
                this.oe[i].put(TAG_IMAGE_WIDTH, cVar2);
            }
        }
    }

    private int a(b bVar) {
        int size;
        int i;
        int i2;
        int[] iArr = new int[nR.length];
        int[] iArr2 = new int[nR.length];
        for (d dVar : nS) {
            removeAttribute(dVar.name);
        }
        removeAttribute(nT.name);
        removeAttribute(nU.name);
        for (i2 = 0; i2 < nR.length; i2++) {
            for (Object obj : this.oe[i2].entrySet().toArray()) {
                Entry entry = (Entry) obj;
                if (entry.getValue() == null) {
                    this.oe[i2].remove(entry.getKey());
                }
            }
        }
        if (!this.oe[1].isEmpty()) {
            this.oe[0].put(nS[1].name, c.a(0, this.of));
        }
        if (!this.oe[2].isEmpty()) {
            this.oe[0].put(nS[2].name, c.a(0, this.of));
        }
        if (!this.oe[3].isEmpty()) {
            this.oe[1].put(nS[3].name, c.a(0, this.of));
        }
        if (this.og) {
            this.oe[4].put(nT.name, c.a(0, this.of));
            this.oe[4].put(nU.name, c.a((long) this.oi, this.of));
        }
        for (i = 0; i < nR.length; i++) {
            i2 = 0;
            for (Entry entry2 : this.oe[i].entrySet()) {
                size = ((c) entry2.getValue()).size();
                if (size > 4) {
                    size += i2;
                } else {
                    size = i2;
                }
                i2 = size;
            }
            iArr2[i] = iArr2[i] + i2;
        }
        i2 = 8;
        for (size = 0; size < nR.length; size++) {
            if (!this.oe[size].isEmpty()) {
                iArr[size] = i2;
                i2 += (((this.oe[size].size() * 12) + 2) + 4) + iArr2[size];
            }
        }
        if (this.og) {
            this.oe[4].put(nT.name, c.a((long) i2, this.of));
            this.oh = i2 + 6;
            i2 += this.oi;
        }
        int i3 = i2 + 8;
        if (!this.oe[1].isEmpty()) {
            this.oe[0].put(nS[1].name, c.a((long) iArr[1], this.of));
        }
        if (!this.oe[2].isEmpty()) {
            this.oe[0].put(nS[2].name, c.a((long) iArr[2], this.of));
        }
        if (!this.oe[3].isEmpty()) {
            this.oe[1].put(nS[3].name, c.a((long) iArr[3], this.of));
        }
        bVar.writeShort((short) i3);
        bVar.write(oa);
        bVar.writeShort(this.of == ByteOrder.BIG_ENDIAN ? (short) 19789 : (short) 18761);
        bVar.ow = this.of;
        bVar.writeShort((short) 42);
        bVar.writeInt(8);
        for (int i4 = 0; i4 < nR.length; i4++) {
            if (!this.oe[i4].isEmpty()) {
                c cVar;
                bVar.writeShort((short) this.oe[i4].size());
                size = ((iArr[i4] + 2) + (this.oe[i4].size() * 12)) + 4;
                i = size;
                for (Entry entry22 : this.oe[i4].entrySet()) {
                    int i5 = ((d) nW[i4].get(entry22.getKey())).number;
                    cVar = (c) entry22.getValue();
                    i2 = cVar.size();
                    bVar.writeShort((short) i5);
                    bVar.writeShort((short) cVar.format);
                    bVar.writeInt(cVar.oy);
                    if (i2 > 4) {
                        bVar.writeInt((int) ((long) i));
                        i += i2;
                    } else {
                        bVar.write(cVar.oz);
                        if (i2 < 4) {
                            for (size = i2; size < 4; size++) {
                                bVar.writeByte(0);
                            }
                        }
                    }
                }
                if (i4 != 0 || this.oe[4].isEmpty()) {
                    bVar.writeInt(0);
                } else {
                    bVar.writeInt((int) ((long) iArr[4]));
                }
                for (Entry entry222 : this.oe[i4].entrySet()) {
                    cVar = (c) entry222.getValue();
                    if (cVar.oz.length > 4) {
                        bVar.write(cVar.oz, 0, cVar.oz.length);
                    }
                }
            }
        }
        if (this.og) {
            bVar.write(aE());
        }
        bVar.ow = ByteOrder.BIG_ENDIAN;
        return i3;
    }

    private static Pair<Integer, Integer> j(String str) {
        if (str.contains(",")) {
            String[] split = str.split(",");
            Pair<Integer, Integer> j = j(split[0]);
            if (((Integer) j.first).intValue() == 2) {
                return j;
            }
            int i = 1;
            while (i < split.length) {
                int intValue;
                int i2;
                Pair j2 = j(split[i]);
                if (((Integer) j2.first).equals(j.first) || ((Integer) j2.second).equals(j.first)) {
                    intValue = ((Integer) j.first).intValue();
                } else {
                    intValue = -1;
                }
                if (((Integer) j.second).intValue() == -1 || !(((Integer) j2.first).equals(j.second) || ((Integer) j2.second).equals(j.second))) {
                    i2 = -1;
                } else {
                    i2 = ((Integer) j.second).intValue();
                }
                if (intValue == -1 && i2 == -1) {
                    return new Pair(Integer.valueOf(2), Integer.valueOf(-1));
                }
                Pair<Integer, Integer> pair;
                if (intValue == -1) {
                    pair = new Pair(Integer.valueOf(i2), Integer.valueOf(-1));
                } else if (i2 == -1) {
                    pair = new Pair(Integer.valueOf(intValue), Integer.valueOf(-1));
                } else {
                    pair = j;
                }
                i++;
                j = pair;
            }
            return j;
        } else if (str.contains("/")) {
            String[] split2 = str.split("/");
            if (split2.length == 2) {
                try {
                    long parseDouble = (long) Double.parseDouble(split2[0]);
                    long parseDouble2 = (long) Double.parseDouble(split2[1]);
                    if (parseDouble < 0 || parseDouble2 < 0) {
                        return new Pair(Integer.valueOf(10), Integer.valueOf(-1));
                    }
                    if (parseDouble > 2147483647L || parseDouble2 > 2147483647L) {
                        return new Pair(Integer.valueOf(5), Integer.valueOf(-1));
                    }
                    return new Pair(Integer.valueOf(10), Integer.valueOf(5));
                } catch (NumberFormatException e) {
                }
            }
            return new Pair(Integer.valueOf(2), Integer.valueOf(-1));
        } else {
            try {
                Long valueOf = Long.valueOf(Long.parseLong(str));
                if (valueOf.longValue() >= 0 && valueOf.longValue() <= 65535) {
                    return new Pair(Integer.valueOf(3), Integer.valueOf(4));
                }
                if (valueOf.longValue() < 0) {
                    return new Pair(Integer.valueOf(9), Integer.valueOf(-1));
                }
                return new Pair(Integer.valueOf(4), Integer.valueOf(-1));
            } catch (NumberFormatException e2) {
                try {
                    Double.parseDouble(str);
                    return new Pair(Integer.valueOf(12), Integer.valueOf(-1));
                } catch (NumberFormatException e3) {
                    return new Pair(Integer.valueOf(2), Integer.valueOf(-1));
                }
            }
        }
    }

    private void i(int i, int i2) {
        if (!this.oe[i].isEmpty() && !this.oe[i2].isEmpty()) {
            c cVar = (c) this.oe[i].get(TAG_IMAGE_LENGTH);
            c cVar2 = (c) this.oe[i].get(TAG_IMAGE_WIDTH);
            c cVar3 = (c) this.oe[i2].get(TAG_IMAGE_LENGTH);
            c cVar4 = (c) this.oe[i2].get(TAG_IMAGE_WIDTH);
            if (cVar != null && cVar2 != null && cVar3 != null && cVar4 != null) {
                int b = cVar.b(this.of);
                int b2 = cVar2.b(this.of);
                int b3 = cVar3.b(this.of);
                int b4 = cVar4.b(this.of);
                if (b < b3 && b2 < b4) {
                    HashMap hashMap = this.oe[i];
                    this.oe[i] = this.oe[i2];
                    this.oe[i2] = hashMap;
                }
            }
        }
    }

    private static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    private static int b(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[8192];
        int i = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return i;
            }
            i += read;
            outputStream.write(bArr, 0, read);
        }
    }

    private static long[] d(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            Object obj2 = new long[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                obj2[i] = (long) iArr[i];
            }
            return obj2;
        } else if (obj instanceof long[]) {
            return (long[]) obj;
        } else {
            return null;
        }
    }
}
