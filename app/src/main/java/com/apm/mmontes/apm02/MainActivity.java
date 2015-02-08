package com.apm.mmontes.apm02;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_main);
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

    public void logIn(View v){
        EditText et_username = (EditText)findViewById(R.id.username);
        EditText et_password = (EditText)findViewById(R.id.password);
        String username = et_username.getText().toString();
        String password = et_password.getText().toString();

        if (username.equals("")){
            Toast.makeText(this,R.string.usernameMandatory, Toast.LENGTH_LONG).show();
            return;
        }
        if (password.equals("")){
            Toast.makeText(this,R.string.passwordMandatory, Toast.LENGTH_LONG).show();
            return;
        }
        getWindow().setExitTransition(new Slide());
        Intent intent = new Intent(this,ListActivity.class);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
}
