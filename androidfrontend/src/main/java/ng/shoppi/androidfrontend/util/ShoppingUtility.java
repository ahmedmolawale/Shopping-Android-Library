package ng.shoppi.androidfrontend.util;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

/**
 * An Utility Class for managing internet and permissions.<br/>
 * Note: The required permission must be specified in the manifest file as usual.<br/>
 *
 * Check the sample app for usage details.
 *
 * @author Olawale
 * @version 1.0.0
 */

public class ShoppingUtility {

    //GROUP: CALENDAR
    public static final int REQUEST_READ_CALENDAR_PERMISSION = 100;
    public static final int REQUEST_WRITE_CALENDAR_PERMISSION = 150;

    //GROUP: CAMERA
    public static final int REQUEST_CAMERA_PERMISSION = 200;

    //GROUP: CONTACTS
    public static final int REQUEST_READ_CONTACTS_PERMISSION = 300;
    public static final int REQUEST_WRITE_CONTACTS_PERMISSION = 350;
    public static final int REQUEST_GET_ACCOUNTS_PERMISSION = 375;

    //GROUP: LOCATION
    public static final int REQUEST_LOCATION_PERMISSION = 400;

    //GROUP: MICROPHONE
    public static final int REQUEST_RECORD_AUDIO_PERMISSION = 500;

    //GROUP: PHONE
    public static final int REQUEST_READ_PHONE_STATE_PERMISSION = 610;
    public static final int REQUEST_CALL_PHONE_PERMISSION = 620;
    public static final int REQUEST_READ_CALL_LOG_PERMISSION = 630;
    public static final int REQUEST_WRITE_CALL_LOG_PERMISSION = 640;
    public static final int REQUEST_ADD_VOICEMALL_PERMISSION = 650;
    public static final int REQUEST_USE_SIP_PERMISSION = 660;
    public static final int REQUEST_PROCESS_OUTGOING_CALLS_PERMISSION = 670;

    //GROUP: SENSORS
    public static final int REQUEST_BODY_SENSORS_PERMISSION = 700;

    //GROUP: SMS
    public static final int REQUEST_SEND_SMS_PERMISSION = 820;
    public static final int REQUEST_RECEIVE_SMS_PERMISSION = 840;
    public static final int REQUEST_READ_SMS_PERMISSION = 850;
    public static final int REQUEST_RECEIVE_WAP_PUSH_PERMISSION = 860;
    public static final int REQUEST_RECEIVE_MMS_PERMISSION = 870;


    //GROUP: STORAGE
    public static final int REQUEST_WRITE_EXTERNAL_STORAGE_PERMISSION = 940;
    public static final int REQUEST_READ_EXTERNAL_STORAGE_PERMISSION = 980;

    /**
     * Call to check whether the device is connected to the internet.
     *
     * @param context {@link Context}
     * @return true if the the device is online
     */
    public static boolean isOnline(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    //Group: Calendar

    /**
     * Call to check for Read Calendar permission
     *
     * @param context {@link Context}
     * @return true if this permission is available
     */
    public static boolean hasReadCalendarPermission(Context context) {
        //We check if we have permission to read calendar
        return (ContextCompat.checkSelfPermission(context,
                Manifest.permission.READ_CALENDAR) == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Call to request for Read Calendar permission
     *
     * @param context {@link Context}
     */
    public static void requestReadCalendarPermission(final Context context) {

        if (ActivityCompat.shouldShowRequestPermissionRationale((AppCompatActivity) context,
                Manifest.permission.READ_CALENDAR)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Permission to access the Calendar is required for this app to work.")
                    .setTitle("Permission required");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    //make request
                    ActivityCompat.requestPermissions((AppCompatActivity) context,
                            new String[]{Manifest.permission.READ_CALENDAR},
                            REQUEST_READ_CALENDAR_PERMISSION);
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        } else {
            //make request
            ActivityCompat.requestPermissions((AppCompatActivity) context,
                    new String[]{Manifest.permission.READ_CALENDAR},
                    REQUEST_READ_CALENDAR_PERMISSION);
        }
    }

    /**
     * Call to check for Write Calendar permission
     *
     * @param context {@link Context}
     * @return true if this permission is available
     */
    public static boolean hasWriteCalendarPermission(Context context) {
        //We check if we have permission to read calendar
        return (ContextCompat.checkSelfPermission(context,
                Manifest.permission.READ_CALENDAR) == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Call to request for Write Calendar permission
     *
     * @param context {@link Context}
     */
    public static void requestWriteCalendarPermission(final Context context) {
        if (ActivityCompat.shouldShowRequestPermissionRationale((AppCompatActivity) context,
                Manifest.permission.WRITE_CALENDAR)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Permission to access the Calendar is required for this app to work.")
                    .setTitle("Permission required");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    //make request
                    ActivityCompat.requestPermissions((AppCompatActivity) context,
                            new String[]{Manifest.permission.WRITE_CALENDAR},
                            REQUEST_WRITE_CALENDAR_PERMISSION);
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        } else {
            //make request
            ActivityCompat.requestPermissions((AppCompatActivity) context,
                    new String[]{Manifest.permission.WRITE_CALENDAR},
                    REQUEST_WRITE_CALENDAR_PERMISSION);
        }
    }

    //for the Camera Group

    /**
     * Call to check for Camera permission
     *
     * @param context {@link Context}
     * @return true if this permission is available
     */
    public static boolean hasCameraPermission(Context context) {
        //We check if we have permission to read calendar
        return (ContextCompat.checkSelfPermission(context,
                Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Call to request for Camera permission
     *
     * @param context {@link Context}
     */
    public static void requestCameraPermission(final Context context) {
        if (ActivityCompat.shouldShowRequestPermissionRationale((AppCompatActivity) context,
                Manifest.permission.CAMERA)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Permission to access the Camera is required for this app to work.")
                    .setTitle("Permission required");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    //make request
                    ActivityCompat.requestPermissions((AppCompatActivity) context,
                            new String[]{Manifest.permission.CAMERA},
                            REQUEST_CAMERA_PERMISSION);
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        } else {
            //make request
            ActivityCompat.requestPermissions((AppCompatActivity) context,
                    new String[]{Manifest.permission.CAMERA},
                    REQUEST_CAMERA_PERMISSION);
        }
    }

    //for the Contact Group

    /**
     * Call to check for Read Contact permission
     *
     * @param context {@link Context}
     * @return true if this permission is available
     */
    public static boolean hasReadContactsPermission(Context context) {
        //We check if we have permission to read contact
        return (ContextCompat.checkSelfPermission(context,
                Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Call to request for Read Contacts permission
     *
     * @param context {@link Context}
     */
    public static void requestReadContactsPermission(final Context context) {

        if (ActivityCompat.shouldShowRequestPermissionRationale((AppCompatActivity) context,
                Manifest.permission.READ_CONTACTS)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Permission to access the Contacts is required for this App to work.")
                    .setTitle("Permission required");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    //make request
                    ActivityCompat.requestPermissions((AppCompatActivity) context,
                            new String[]{Manifest.permission.READ_CONTACTS},
                            REQUEST_READ_CONTACTS_PERMISSION);
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        } else {
            //make request
            ActivityCompat.requestPermissions((AppCompatActivity) context,
                    new String[]{Manifest.permission.READ_CONTACTS},
                    REQUEST_READ_CONTACTS_PERMISSION);
        }
    }

    /**
     * Call to check for Write Contacts permission
     *
     * @param context {@link Context}
     * @return true if this permission is available
     */
    public static boolean hasWriteContactsPermission(Context context) {
        //We check if we have permission to write contact
        return (ContextCompat.checkSelfPermission(context,
                Manifest.permission.WRITE_CONTACTS) == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Call to request for Write Contacts permission
     *
     * @param context {@link Context}
     */
    public static void requestWriteContactsPermission(final Context context) {

        if (ActivityCompat.shouldShowRequestPermissionRationale((AppCompatActivity) context,
                Manifest.permission.WRITE_CONTACTS)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Permission to access the Contacts is required for this App to work.")
                    .setTitle("Permission required");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    //make request
                    ActivityCompat.requestPermissions((AppCompatActivity) context,
                            new String[]{Manifest.permission.WRITE_CONTACTS},
                            REQUEST_WRITE_CONTACTS_PERMISSION);
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        } else {
            //make request
            ActivityCompat.requestPermissions((AppCompatActivity) context,
                    new String[]{Manifest.permission.WRITE_CONTACTS},
                    REQUEST_WRITE_CONTACTS_PERMISSION);
        }
    }

    /**
     * Call to check for Get Accounts permission
     *
     * @param context {@link Context}
     * @return true if this permission is available
     */
    public static boolean hasGetAccountsPermission(Context context) {
        //We check if we have permission to get accounts
        return (ContextCompat.checkSelfPermission(context,
                Manifest.permission.GET_ACCOUNTS) == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Call to request for Get Accounts permission
     *
     * @param context {@link Context}
     */
    public static void requestGetAccountsPermission(final Context context) {

        if (ActivityCompat.shouldShowRequestPermissionRationale((AppCompatActivity) context,
                Manifest.permission.GET_ACCOUNTS)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Permission to access the Contacts is required for this App to work.")
                    .setTitle("Permission required");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    //make request
                    ActivityCompat.requestPermissions((AppCompatActivity) context,
                            new String[]{Manifest.permission.GET_ACCOUNTS},
                            REQUEST_GET_ACCOUNTS_PERMISSION);
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        } else {
            //make request
            ActivityCompat.requestPermissions((AppCompatActivity) context,
                    new String[]{Manifest.permission.GET_ACCOUNTS},
                    REQUEST_GET_ACCOUNTS_PERMISSION);
        }
    }

    //Group: Location

    /**
     * Call to check for Location permission
     *
     * @param context {@link Context}
     * @return true if this permission is available
     */
    public static boolean hasLocationPermission(Context context) {
        //We check if we have permission to request location
        return (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Call to request for Location permission
     *
     * @param context {@link Context}
     */
    public static void requestLocationPermission(final Context context) {
        if (ActivityCompat.shouldShowRequestPermissionRationale((AppCompatActivity) context,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
            builder.setMessage("Permission to get location is required by this app.")
                    .setTitle("Permission required");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    //make request
                    ActivityCompat.requestPermissions((AppCompatActivity) context,
                            new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                            REQUEST_LOCATION_PERMISSION);
                }
            });

            android.app.AlertDialog dialog = builder.create();
            dialog.show();

        } else {
            //make request
            ActivityCompat.requestPermissions((AppCompatActivity) context,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION_PERMISSION);
        }
    }

    //for the Record Audio

    /**
     * Call to check for Record Audio permission
     *
     * @param context {@link Context}
     * @return true if this permission is available
     */
    public static boolean hasRecordAudioPermission(Context context) {
        //We check if we have permission to record audio
        return (ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Call to request for Record Audio permission
     *
     * @param context {@link Context}
     */
    public static void requestRecordAudioPermission(final Context context) {

        if (ActivityCompat.shouldShowRequestPermissionRationale((AppCompatActivity) context,
                Manifest.permission.RECORD_AUDIO)) {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
            builder.setMessage("Permission to record audio is required by this app.")
                    .setTitle("Permission required");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    //make request
                    ActivityCompat.requestPermissions((AppCompatActivity) context,
                            new String[]{Manifest.permission.RECORD_AUDIO},
                            REQUEST_RECORD_AUDIO_PERMISSION);
                }
            });

            android.app.AlertDialog dialog = builder.create();
            dialog.show();

        } else {
            //make request
            ActivityCompat.requestPermissions((AppCompatActivity) context,
                    new String[]{Manifest.permission.RECORD_AUDIO},
                    REQUEST_RECORD_AUDIO_PERMISSION);
        }
    }

    //Group: Phone

    /**
     * Call to check for Read Phone State permission
     *
     * @param context {@link Context}
     * @return true if this permission is available
     */
    public static boolean hasReadPhoneStatePermission(Context context) {
        //We check if we have permission to read phone state
        return (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Call to request for Read Phone State permission
     *
     * @param context {@link Context}
     */
    public static void requestReadPhoneStatePermission(final Context context) {

        if (ActivityCompat.shouldShowRequestPermissionRationale((AppCompatActivity) context,
                Manifest.permission.READ_PHONE_STATE)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Permission to read phone state is required by this app.")
                    .setTitle("Permission required");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    //make request
                    ActivityCompat.requestPermissions((AppCompatActivity) context,
                            new String[]{Manifest.permission.READ_PHONE_STATE},
                            REQUEST_READ_PHONE_STATE_PERMISSION);
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        } else {
            //make request
            ActivityCompat.requestPermissions((AppCompatActivity) context,
                    new String[]{Manifest.permission.READ_PHONE_STATE},
                    REQUEST_READ_PHONE_STATE_PERMISSION);
        }
    }

    /**
     * Call to check for Call Phone permission
     *
     * @param context {@link Context}
     * @return true if this permission is available
     */
    public static boolean hasCallPhonePermission(Context context) {
        //We check if we have permission to call Phone
        return (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Call to request for Call Phone permission
     *
     * @param context {@link Context}
     */
    public static void requestCallPhonePermission(final Context context) {

        if (ActivityCompat.shouldShowRequestPermissionRationale((AppCompatActivity) context,
                Manifest.permission.CALL_PHONE)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Permission to Call Phone is required by this app.")
                    .setTitle("Permission required");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    //make request
                    ActivityCompat.requestPermissions((AppCompatActivity) context,
                            new String[]{Manifest.permission.CALL_PHONE},
                            REQUEST_CALL_PHONE_PERMISSION);
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        } else {
            //make request
            ActivityCompat.requestPermissions((AppCompatActivity) context,
                    new String[]{Manifest.permission.CALL_PHONE},
                    REQUEST_CALL_PHONE_PERMISSION);
        }
    }

    /**
     * Call to check for Read Call Log permission
     *
     * @param context {@link Context}
     * @return true if this permission is available
     */
    public static boolean hasReadCallLogPermission(Context context) {
        //We check if we have permission to read call log
        return (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_CALL_LOG) == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Call to check for Read Call Log permission.<br/>
     * Call to this method requires API level 16
     *
     * @param context {@link Context}
     */
    public static void requestReadCallLogPermission(final Context context) {
        if (ActivityCompat.shouldShowRequestPermissionRationale((AppCompatActivity) context,
                Manifest.permission.READ_CALL_LOG)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Permission to Read Call Log is required by this app.")
                    .setTitle("Permission required");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    //make request
                    ActivityCompat.requestPermissions((AppCompatActivity) context,
                            new String[]{Manifest.permission.READ_CALL_LOG},
                            REQUEST_READ_CALL_LOG_PERMISSION);
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        } else {
            //make request
            ActivityCompat.requestPermissions((AppCompatActivity) context,
                    new String[]{Manifest.permission.READ_CALL_LOG},
                    REQUEST_READ_CALL_LOG_PERMISSION);
        }
    }

    /**
     * Call to check for Write Call Log permission
     *
     * @param context {@link Context}
     * @return true if this permission is available
     */
    public static boolean hasWriteCallLogPermission(Context context) {
        //We check if we have permission to write call log
        return (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_CALL_LOG) == PackageManager.PERMISSION_GRANTED);
    }


    /**
     * Call to check for Write Call Log permission.<br/>
     * Call to this method requires API level 16
     *
     * @param context {@link Context}
     */
    public static void requestWriteCallLogPermission(final Context context) {
        if (ActivityCompat.shouldShowRequestPermissionRationale((AppCompatActivity) context,
                Manifest.permission.WRITE_CALL_LOG)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Permission to Write Call Log is required by this app.")
                    .setTitle("Permission required");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    //make request
                    ActivityCompat.requestPermissions((AppCompatActivity) context,
                            new String[]{Manifest.permission.WRITE_CALL_LOG},
                            REQUEST_WRITE_CALL_LOG_PERMISSION);
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        } else {
            //make request
            ActivityCompat.requestPermissions((AppCompatActivity) context,
                    new String[]{Manifest.permission.WRITE_CALL_LOG},
                    REQUEST_WRITE_CALL_LOG_PERMISSION);
        }
    }

    /**
     * Call to check for Add Voice mail permission
     *
     * @param context {@link Context}
     * @return true if this permission is available
     */
    public static boolean hasAddVoicemailPermission(Context context) {
        //We check if we have permission to write call log
        return (ContextCompat.checkSelfPermission(context, Manifest.permission.ADD_VOICEMAIL) == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Call to request for Add Voice Mail permission
     *
     * @param context {@link Context}
     */
    public static void requestAddVoicemailPermission(final Context context) {
        if (ActivityCompat.shouldShowRequestPermissionRationale((AppCompatActivity) context,
                Manifest.permission.ADD_VOICEMAIL)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Permission to Add Voice mail is required by this app.")
                    .setTitle("Permission required");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    //make request
                    ActivityCompat.requestPermissions((AppCompatActivity) context,
                            new String[]{Manifest.permission.ADD_VOICEMAIL},
                            REQUEST_ADD_VOICEMALL_PERMISSION);
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        } else {
            //make request
            ActivityCompat.requestPermissions((AppCompatActivity) context,
                    new String[]{Manifest.permission.ADD_VOICEMAIL},
                    REQUEST_ADD_VOICEMALL_PERMISSION);
        }
    }

    /**
     * Call to check for Use SIP permission
     *
     * @param context {@link Context}
     * @return true if this permission is available
     */
    public static boolean hasUseSIPPermission(Context context) {
        //We check if we have permission to use sip
        return (ContextCompat.checkSelfPermission(context, Manifest.permission.USE_SIP) == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Call to request for Use Sip permission
     *
     * @param context {@link Context}
     */
    public static void requestUseSIPPermission(final Context context) {
        if (ActivityCompat.shouldShowRequestPermissionRationale((AppCompatActivity) context,
                Manifest.permission.USE_SIP)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Permission to Use SIP is required by this app.")
                    .setTitle("Permission required");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    //make request
                    ActivityCompat.requestPermissions((AppCompatActivity) context,
                            new String[]{Manifest.permission.USE_SIP},
                            REQUEST_USE_SIP_PERMISSION);
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        } else {
            //make request
            ActivityCompat.requestPermissions((AppCompatActivity) context,
                    new String[]{Manifest.permission.USE_SIP},
                    REQUEST_USE_SIP_PERMISSION);
        }
    }

    /**
     * Call to check for Process Outgoing Calls permission
     *
     * @param context {@link Context}
     * @return true if this permission is available
     */
    public static boolean hasProcessOutgoingCallsPermission(Context context) {
        //We check if we have permission to process outgoing calls
        return (ContextCompat.checkSelfPermission(context, Manifest.permission.PROCESS_OUTGOING_CALLS) == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Call to request for Process Outgoing Calls permission
     *
     * @param context {@link Context}
     */
    public static void requestProcessOutgoingCallsPermission(final Context context) {
        if (ActivityCompat.shouldShowRequestPermissionRationale((AppCompatActivity) context,
                Manifest.permission.PROCESS_OUTGOING_CALLS)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Permission to Process Outgoing Calls is required by this app.")
                    .setTitle("Permission required");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    //make request
                    ActivityCompat.requestPermissions((AppCompatActivity) context,
                            new String[]{Manifest.permission.PROCESS_OUTGOING_CALLS},
                            REQUEST_PROCESS_OUTGOING_CALLS_PERMISSION);
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        } else {
            //make request
            ActivityCompat.requestPermissions((AppCompatActivity) context,
                    new String[]{Manifest.permission.PROCESS_OUTGOING_CALLS},
                    REQUEST_PROCESS_OUTGOING_CALLS_PERMISSION);
        }
    }

    //GROUP: BODY SENSORS

    /**
     * Call to check for Body Sensor permission
     *
     * @param context This call requires API Level 21 and above
     * @return true if there is permission to body sensors
     */
    public static boolean hasBodySensorsPermission(Context context) {
        //We check if we have permission to use body sensors
        return (ContextCompat.checkSelfPermission(context, Manifest.permission.BODY_SENSORS) == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Call to request for Call Phone permission.<br/>
     * This call requires API Level 21 and above
     *
     * @param context {@link Context}
     */
    public static void requestBodySensorsPermission(final Context context) {
        if (ActivityCompat.shouldShowRequestPermissionRationale((AppCompatActivity) context,
                Manifest.permission.BODY_SENSORS)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Permission to use Body Sensors is required by this app.")
                    .setTitle("Permission required");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    //make request
                    ActivityCompat.requestPermissions((AppCompatActivity) context,
                            new String[]{Manifest.permission.BODY_SENSORS},
                            REQUEST_BODY_SENSORS_PERMISSION);
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        } else {
            //make request
            ActivityCompat.requestPermissions((AppCompatActivity) context,
                    new String[]{Manifest.permission.BODY_SENSORS},
                    REQUEST_BODY_SENSORS_PERMISSION);
        }
    }
    //GROUP: SMS

    /**
     * Call to check for Send SMS permission
     *
     * @param context {@link Context}
     * @return true if this permission is available
     */
    public static boolean hasSendSMSPermission(Context context) {
        //We check if we have permission to send SMS
        return (ContextCompat.checkSelfPermission(context,
                Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Call to request for Send SMS permission
     *
     * @param context {@link Context}
     */
    public static void requestSendSMSPermission(final Context context) {

        if (ActivityCompat.shouldShowRequestPermissionRationale((AppCompatActivity) context,
                Manifest.permission.SEND_SMS)) {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
            builder.setMessage("Permission to send sms is required by this app.")
                    .setTitle("Permission required");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    //make request
                    ActivityCompat.requestPermissions((AppCompatActivity) context,
                            new String[]{Manifest.permission.SEND_SMS},
                            REQUEST_SEND_SMS_PERMISSION);
                }
            });

            android.app.AlertDialog dialog = builder.create();
            dialog.show();

        } else {
            //make request
            ActivityCompat.requestPermissions((AppCompatActivity) context,
                    new String[]{Manifest.permission.SEND_SMS},
                    REQUEST_SEND_SMS_PERMISSION);
        }

    }

    /**
     * Call to check for Receive SMS permission
     *
     * @param context {@link Context}
     * @return true if this permission is available
     */
    public static boolean hasReceiveSMSPermission(Context context) {
        //We check if we have permission to Receive SMS
        return (ContextCompat.checkSelfPermission(context,
                Manifest.permission.RECEIVE_SMS) == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Call to request for Receive SMS permission
     *
     * @param context {@link Context}
     */
    public static void requestReceiveSMSPermission(final Context context) {

        if (ActivityCompat.shouldShowRequestPermissionRationale((AppCompatActivity) context,
                Manifest.permission.RECEIVE_SMS)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Permission to Receive SMS is required by this app.")
                    .setTitle("Permission required");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    //make request
                    ActivityCompat.requestPermissions((AppCompatActivity) context,
                            new String[]{Manifest.permission.RECEIVE_SMS},
                            REQUEST_RECEIVE_SMS_PERMISSION);
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        } else {
            //make request
            ActivityCompat.requestPermissions((AppCompatActivity) context,
                    new String[]{Manifest.permission.RECEIVE_SMS},
                    REQUEST_RECEIVE_SMS_PERMISSION);
        }

    }

    /**
     * Call to check for Read SMS permission
     *
     * @param context {@link Context}
     * @return true if this permission is available
     */
    public static boolean hasReadSMSPermission(Context context) {
        //We check if we have permission to Read SMS
        return (ContextCompat.checkSelfPermission(context,
                Manifest.permission.READ_SMS) == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Call to request for Read SMS permission
     *
     * @param context {@link Context}
     */
    public static void requestReadSMSPermission(final Context context) {

        if (ActivityCompat.shouldShowRequestPermissionRationale((AppCompatActivity) context,
                Manifest.permission.READ_SMS)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Permission to Read SMS is required by this app.")
                    .setTitle("Permission required");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    //make request
                    ActivityCompat.requestPermissions((AppCompatActivity) context,
                            new String[]{Manifest.permission.READ_SMS},
                            REQUEST_READ_SMS_PERMISSION);
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        } else {
            //make request
            ActivityCompat.requestPermissions((AppCompatActivity) context,
                    new String[]{Manifest.permission.READ_SMS},
                    REQUEST_READ_SMS_PERMISSION);
        }

    }

    /**
     * Call to check for Receive Wap Push permission
     *
     * @param context {@link Context}
     * @return true if this permission is available
     */
    public static boolean hasReceiveWapPushPermission(Context context) {
        //We check if we have permission to Read SMS
        return (ContextCompat.checkSelfPermission(context,
                Manifest.permission.RECEIVE_WAP_PUSH) == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Call to request for Receive Wap Push permission
     *
     * @param context {@link Context}
     */
    public static void requestReceiveWapPushPermission(final Context context) {

        if (ActivityCompat.shouldShowRequestPermissionRationale((AppCompatActivity) context,
                Manifest.permission.RECEIVE_WAP_PUSH)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Permission to Receive Wap Push is required by this app.")
                    .setTitle("Permission required");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    //make request
                    ActivityCompat.requestPermissions((AppCompatActivity) context,
                            new String[]{Manifest.permission.RECEIVE_WAP_PUSH},
                            REQUEST_RECEIVE_WAP_PUSH_PERMISSION);
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        } else {
            //make request
            ActivityCompat.requestPermissions((AppCompatActivity) context,
                    new String[]{Manifest.permission.RECEIVE_WAP_PUSH},
                    REQUEST_RECEIVE_WAP_PUSH_PERMISSION);
        }

    }

    /**
     * Call to check for ReceiveMMS permission
     *
     * @param context {@link Context}
     * @return true if this permission is available
     */
    public static boolean hasReceiveMMSPermission(Context context) {
        //We check if we have permission to Receive MMS
        return (ContextCompat.checkSelfPermission(context,
                Manifest.permission.RECEIVE_MMS) == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Call to request for Receive MMS permission
     *
     * @param context {@link Context}
     */
    public static void requestReceiveMMSPermission(final Context context) {

        if (ActivityCompat.shouldShowRequestPermissionRationale((AppCompatActivity) context,
                Manifest.permission.RECEIVE_MMS)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Permission to Receive MMS is required by this app.")
                    .setTitle("Permission required");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    //make request
                    ActivityCompat.requestPermissions((AppCompatActivity) context,
                            new String[]{Manifest.permission.RECEIVE_MMS},
                            REQUEST_RECEIVE_MMS_PERMISSION);
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        } else {
            //make request
            ActivityCompat.requestPermissions((AppCompatActivity) context,
                    new String[]{Manifest.permission.RECEIVE_MMS},
                    REQUEST_RECEIVE_MMS_PERMISSION);
        }

    }

    //GROUP: STORAGE

    /**
     * Call to check for Write Storage permission
     *
     * @param context {@link Context}
     * @return true if this permission is available
     */
    public static boolean hasWriteStoragePermission(Context context) {
        //We check if we have permission to write to SD
        return (ContextCompat.checkSelfPermission(context,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Call to request for Write Storage permission
     *
     * @param context {@link Context}
     */
    public static void requestWriteStoragePermission(final Context context) {

        if (ActivityCompat.shouldShowRequestPermissionRationale((AppCompatActivity) context,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Permission to write to storage is required for this app to work.")
                    .setTitle("Permission required");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    //make request
                    ActivityCompat.requestPermissions((AppCompatActivity) context,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            REQUEST_WRITE_EXTERNAL_STORAGE_PERMISSION);
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        } else {
            //make request
            ActivityCompat.requestPermissions((AppCompatActivity) context,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_WRITE_EXTERNAL_STORAGE_PERMISSION);
        }
    }

    /**
     * Call to check for Read Storage permission
     *
     * @param context This call requires API Level 16 and above
     * @return true if there is permission to Read Storage
     */
    public static boolean hasReadStoragePermission(Context context) {
        //We check if we have permission to read to SD
        return (ContextCompat.checkSelfPermission(context,
                Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
    }

    /**
     * Call to request for Use Sip permission.<br/>
     * This call requires API Level 16 and above
     *
     * @param context {@link Context}
     */
    public static void requestReadStoragePermission(final Context context) {

        if (ActivityCompat.shouldShowRequestPermissionRationale((AppCompatActivity) context,
                Manifest.permission.READ_EXTERNAL_STORAGE)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Permission to read storage is required for this app to work.")
                    .setTitle("Permission required");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    //make request
                    ActivityCompat.requestPermissions((AppCompatActivity) context,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                            REQUEST_READ_EXTERNAL_STORAGE_PERMISSION);
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        } else {
            //make request
            ActivityCompat.requestPermissions((AppCompatActivity) context,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    REQUEST_READ_EXTERNAL_STORAGE_PERMISSION);
        }
    }

    /**
     * @return true if the requested permission is granted
     */
    public static boolean permissionGranted(int[] grantResults) {
        if (grantResults.length > 0 && (grantResults[0] == PackageManager.PERMISSION_GRANTED))
            return true;
        else
            return false;
    }

}
