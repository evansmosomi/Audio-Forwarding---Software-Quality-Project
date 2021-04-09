import android.app.Activity;
import android.content.Intent;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

class MainActivityTest {

    MainActivity test_onActivityRequest = new MainActivity();
    @Test
    void StartActivityTest() {
        String expected = "Start Recording";
        int REQUEST_CODE_START_CAPTURE = 2;
        int RESULT_CODE = Activity.RESULT_OK;
        android.content.Intent data = new Intent();
        test_onActivityRequest.onActivityResult(REQUEST_CODE_START_CAPTURE, RESULT_CODE, data);
        assertEquals(expected, test_onActivityRequest.toString().trim());

    }

}