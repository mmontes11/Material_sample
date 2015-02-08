package com.apm.mmontes.apm02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;


public class Add extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_add_to_do);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_to_do, menu);
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

    public void add(View v) {
        Log.e("onClick", "add");
        EditText et = (EditText) findViewById(R.id.name_editText);
        String name = et.getText().toString();
        getWindow().setExitTransition(new ChangeBounds());
        Intent result = new Intent();

        if (name.equals("")) {
            Log.e("add", "error");
            setResult(Activity.RESULT_CANCELED, result);
            Toast.makeText(this, R.string.error_name, Toast.LENGTH_SHORT).show();
        } else {
            Log.e("add", "success");
            result.putExtra("name", name);
            setResult(Activity.RESULT_OK, result);
            getWindow().setExitTransition(new Slide());
            finish();
        }
    }

    public void onAccept(View v) {
        Log.e("onAccept", "1");

    }
}
