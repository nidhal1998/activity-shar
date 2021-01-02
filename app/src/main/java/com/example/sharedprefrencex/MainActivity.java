package com.example.sharedprefrencex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;
    private EditText mName, mPassword;
    private CheckBox mCheckbox;
    private Button btnlogin;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mName = (EditText) findViewById(R.id.etName);
        mPassword = (EditText) findViewById(R.id.etPassword);
        btnlogin = (Button) findViewById(R.id.btnLogin);
        mCheckbox = (CheckBox) findViewById(R.id.checkbox);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();

        checkSharedPreferences();
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCheckbox.isChecked()){

                mEditor.putString(getString(R.string.checkbox),"true");
                mEditor.commit();
                //save the name
                String name=mName.getText().toString();
                mEditor.putString(getString(R.string.name),name);
                mEditor.commit();
                //save password
                String password =mPassword.getText().toString();
                mEditor.putString(getString(R.string.password),name);
                mEditor.commit();
            }else{
                    mEditor.putString(getString(R.string.checkbox),"false");
                    mEditor.commit();
                    //save the name

                    mEditor.putString(getString(R.string.name),"");
                    mEditor.commit();
                    //save password

                    mEditor.putString(getString(R.string.password),"");
                    mEditor.commit();

                }


            }
        });

    }
        private void checkSharedPreferences(){
        String checkBox = mPreferences.getString(getString(R.string.checkbox), "False");
        String name = mPreferences.getString(getString(R.string.name), "");
        String password = mPreferences.getString(getString(R.string.password), "");
        mName.setText(name);
        mPassword.setText(password);


            if (checkBox.equals("True")){
                mCheckbox.setChecked(true);
            }
            else
                mCheckbox.setChecked(false);


    }
}
