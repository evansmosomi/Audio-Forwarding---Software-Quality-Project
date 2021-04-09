import android.content.Context;
import android.content.Intent;
import static org.junit.Assert.assertEquals;
class RecordServiceTest {

    private static final short START_NOT_STICKY = 0;
    private static final String ACTION_STOP = "com.rom1v.sndcpy.STOP";
    private Object Runnable;

    RecordService startTest = new RecordService();
    @org.junit.jupiter.api.Test
    void start() {
        String expected= "Start Application";
        android.content.Intent data = new Intent();
        Context context = startTest.getApplicationContext();
        startTest.start(context, data);
        assertEquals(expected, startTest.toString().trim());
    }

    RecordService onStartTest = new RecordService();
    @org.junit.jupiter.api.Test
    void onStartCommandActionStop() {
        android.content.Intent intent = new Intent();
        onStartTest.onStartCommand(intent, 1, 1);
        if (ACTION_STOP.equals(intent.getAction())) {
            assertEquals("stop", startTest.toString().trim());
        }
    }

    @org.junit.jupiter.api.Test
    double onBind() {
        assertEquals(null, onBind());
        return 0;
    }

    RecordService destroyTest = new RecordService();
    @org.junit.jupiter.api.Test
    void onDestroy() {
        destroyTest.onDestroy();
        assertEquals("destroy", destroyTest.toString().trim());
    }
}