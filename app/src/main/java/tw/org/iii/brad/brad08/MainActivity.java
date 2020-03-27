package tw.org.iii.brad.brad08;
//activity之間的參數傳遞
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText input;
    private MainApp mainApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainApp = (MainApp)getApplication();//取得activity所在的Application物件實體
        Log.v("brad", "a = " + mainApp.a);
        Log.v("brad", "b = " + mainApp.b);

        input = findViewById(R.id.input);
    }

    public void gotoPage2(View view) {
        Intent intent = new Intent(this, Page2Activity.class); //e.g.按網頁上的電話,會跳到手機原生的撥號程式,也是用intent,但此處不是此種intent
        intent.putExtra("name",input.getText().toString());
        intent.putExtra("lottery",(int)(Math.random()*49+1));
//        startActivity(intent);
        startActivityForResult(intent,2); //29行建構時已知要去Page2,此處又告知其requestCode為2,回來時看下方onActivityResult
    }

    public void gotoPage3(View view) {
        Intent intent = new Intent(this,Page3Activity.class);
        startActivityForResult(intent,3); //第二參數為識別用,從這裡出去時帶的參數,
    }

    @Override
    protected void onActivityResult(int requestCode,        //回傳
                                    int resultCode,
                                    @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.v("brad","requestCode = " + requestCode);
        Log.v("brad","resultCode = " + resultCode);
        if (requestCode == 3) {
            boolean isSoundOnOff = data.getBooleanExtra("sound",false);
            Log.v("brad","sound:" + (isSoundOnOff?"On":"Off"));
        }
    }

    @Override
    protected void onRestart() {
        Log.v("brad","onRestart()");
        Log.v("brad", "a = " + mainApp.a);
        Log.v("brad", "b = " + mainApp.b);
        super.onRestart();
    }
}
