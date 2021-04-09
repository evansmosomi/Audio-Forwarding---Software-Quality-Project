import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;

public class MainActivity extends Activity {

    private static final int REQUEST_CODE_PERMISSION_AUDIO = 1;
    private static final int REQUEST_CODE_START_CAPTURE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (checkSelfPermission(Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            System.out.println("Permission Denied");
            String[] permissions = {Manifest.permission.RECORD_AUDIO};
            requestPermissions(permissions, REQUEST_CODE_PERMISSION_AUDIO);
        }

        System.out.println("Permission Granted");
        MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) getSystemService(MEDIA_PROJECTION_SERVICE);
        Intent intent = mediaProjectionManager.createScreenCaptureIntent();
        startActivityForResult(intent, REQUEST_CODE_START_CAPTURE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_START_CAPTURE && resultCode == Activity.RESULT_OK) {
            System.out.println("Start Recording");
            RecordService.start(this, data);
        }
        finish();
    }
}
