package tw.org.iii.brad.brad08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Page2Activity extends AppCompatActivity {
    private TextView tv;
    private MainApp mainApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        mainApp = (MainApp)getApplication();
        Log.v("brad", "a = " + mainApp.a);
        Log.v("brad", "b = " + mainApp.b);

        mainApp.a = 99;
        mainApp.b = "xOKx";

        tv = findViewById(R.id.page2_tv);

        Intent intent = getIntent();        //此處intent是Main的gotoPage2裡面的,故不用new
        String name = intent.getStringExtra("name");
        int lottery = intent.getIntExtra("lottery",000);//第二參數為找不到第一參數時的預設值(物件型別的預設為null(如上行),基本型別可指定同此處為000)
        tv.setText(name + ":" + lottery);
    }

    public void gotoMain(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
