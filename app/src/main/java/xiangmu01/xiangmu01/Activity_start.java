package xiangmu01.xiangmu01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import static java.lang.Thread.sleep;

/**
 * Created by Administrator on 2016/10/25.
 */

public class Activity_start extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Toast.makeText(Activity_start.this, "加载中。。。", Toast.LENGTH_SHORT).show();
        run();
    }

    private void run() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(Activity_start.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }).start();

    }
}



