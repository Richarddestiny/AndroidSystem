package com.example.richard.first_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;
import com.example.richard.hardlibrary.*;

public class MainActivity extends AppCompatActivity {

    private Button button = null;
    private boolean ledon = false;
    private  int i;
    private CheckBox checkBoxLed1 = null;
    private CheckBox checkBoxLed2 = null;
    private CheckBox checkBoxLed3 = null;
    private CheckBox checkBoxLed4 = null;

    class MyButtonListerner implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            HardControl hardControl = new HardControl();

            ledon = !ledon;
            if (ledon) {
                button.setText("ALL OFF");
                checkBoxLed1.setChecked(true);
                checkBoxLed2.setChecked(true);
                checkBoxLed3.setChecked(true);
                checkBoxLed4.setChecked(true);
                Toast.makeText(getApplicationContext(), "ALL OFF",Toast.LENGTH_SHORT).show();

                for (i =0;i < 4; i++)
                    HardControl.ledCtrl(i,1);
            }
            else {
                button.setText("ALL ON");
                checkBoxLed1.setChecked(false);
                checkBoxLed2.setChecked(false);
                checkBoxLed3.setChecked(false);
                checkBoxLed4.setChecked(false);
                Toast.makeText(getApplicationContext(), "ALL ON",Toast.LENGTH_SHORT).show();

                for (i =0;i < 4; i++)
                    HardControl.ledCtrl(i,0);
            }
        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.LED1:
                if (checked) {
                    // Put some meat on the sandwich
                    Toast.makeText(getApplicationContext(), "LED1 on",Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(1, 1);
                }
                else {
                    Toast.makeText(getApplicationContext(), "LED1 off",Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(1, 0);
            }
                break;
            case R.id.LED2:
                if (checked) {
                    // Put some meat on the sandwich
                    Toast.makeText(getApplicationContext(), "LED2 on",Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(2, 1);
                }
                else {
                    Toast.makeText(getApplicationContext(), "LED2 off",Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(2, 0);
                }
                break;
            case R.id.LED3:
                if (checked) {
                    // Put some meat on the sandwich
                    Toast.makeText(getApplicationContext(), "LED3 on",Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(3, 1);
                }
                else {
                    Toast.makeText(getApplicationContext(), "LED3 off",Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(3, 0);
                }
                break;

            case R.id.LED4:
                if (checked) {
                    // Put some meat on the sandwich
                    Toast.makeText(getApplicationContext(), "LED4 on",Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(4, 1);
                }
                else {
                    Toast.makeText(getApplicationContext(), "LED4 off",Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(4, 0);
                }
                break;
            // TODO: Veggie sandwich
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.BUTTION);

        HardControl.ledOpen();

        checkBoxLed1 = (CheckBox) findViewById(R.id.LED1);
        checkBoxLed2 = (CheckBox) findViewById(R.id.LED2);
        checkBoxLed3 = (CheckBox) findViewById(R.id.LED3);
        checkBoxLed4 = (CheckBox) findViewById(R.id.LED4);

        button.setOnClickListener(new MyButtonListerner());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
