package com.example.MobMaster;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class noteCreate extends AppCompatActivity{
    TextInputEditText title,body;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.note_create);

        Button btn = (Button)findViewById(R.id.noteSaveButton);
        assert btn != null;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        spinner = (Spinner)findViewById(R.id.pinSpinner);
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, AppBase.divisions);
        assert spinner != null;
        spinner.setAdapter(adapterSpinner);
    }

    private void saveData() {
        title = (TextInputEditText)findViewById(R.id.noteTitle);
        body = (TextInputEditText)findViewById(R.id.noteBody);
        TextInputEditText sub = (TextInputEditText)findViewById(R.id.subjectNote);
        String qu = " INSERT INTO NOTES(title,body,cls,sub) VALUES('" + title.getText().toString() + "','" + body.getText().toString() +"'," +
                "'" + spinner.getSelectedItem().toString() + "','" + sub.getText().toString().toUpperCase() + "')";
        if(AppBase.handler.execAction(qu))
        {
            Toast.makeText(getBaseContext(),"Note Saved",Toast.LENGTH_LONG).show();
            this.finish();
        }
    }

}
