package tw.org.iii.brad.brad08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Page3Activity extends AppCompatActivity {
    private SwitchCompat soundSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        soundSwitch = findViewById(R.id.soundOnOff);

    }

//    @Override
//    public void finish() {
//        Intent intent = new Intent(); //此處不是從哪跳到哪的觀念
//        intent.putExtra("sound",soundSwitch.isChecked());
////        setResult(123);
//        setResult(123,intent);
//        super.finish();
//    }

    public void gotoMain(View view) {
        Intent intent = new Intent(); //此處不是從哪跳到哪的觀念
        intent.putExtra("sound",soundSwitch.isChecked());
        setResult(123,intent);
        finish();
    }
}
