package us.mifeng.budgedemo;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import us.mifeng.budgedemo.budge.AppShortCutUtil;
import us.mifeng.budgedemo.budge.BadgeUtil;

public class MainActivity extends AppCompatActivity {

    private Button budge;
    private EditText etNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
    }

    private void findView() {
        budge = (Button) findViewById(R.id.budge);
        etNum = (EditText) findViewById(R.id.emNum);
        budge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setBudgeCount();
                AppShortCutUtil.addNumShortCut(MainActivity.this,MainActivity.class,true,etNum.getText().toString(),true);
            }
        });
        Button delete = (Button) findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppShortCutUtil.deleteShortCut(MainActivity.this,MainActivity.class);
            }
        });
    }

    private void setBudgeCount() {
        Toast.makeText(getApplicationContext(), "厂商："+ Build.MANUFACTURER, Toast.LENGTH_SHORT).show();
        int count;
        try {
            count = Integer.valueOf(etNum.getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "请输入整数", Toast.LENGTH_SHORT).show();
            return;
        }
        if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")){
            BadgeUtil.setBadgeCount(MainActivity.this, count, BadgeUtil.Platform.mi);
        }else if(Build.MANUFACTURER.equalsIgnoreCase("samsung")){
            BadgeUtil.setBadgeCount(MainActivity.this, count, BadgeUtil.Platform.samsung);
        }else if(Build.MANUFACTURER.equalsIgnoreCase("htc")){
            BadgeUtil.setBadgeCount(MainActivity.this, count, BadgeUtil.Platform.htc);
        }else if(Build.MANUFACTURER.equalsIgnoreCase("lg")){
            BadgeUtil.setBadgeCount(MainActivity.this, count, BadgeUtil.Platform.lg);
        }else if(Build.MANUFACTURER.equalsIgnoreCase("sony")){
            BadgeUtil.setBadgeCount(MainActivity.this, count, BadgeUtil.Platform.sony);
        }
    }
}
