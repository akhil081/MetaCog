package com.metacog.pc.metacog2k18;

import android.app.ProgressDialog;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    final String myTag = "DocsUpload";
    EditText et1,et2,et3,et4, et5;
    Button but;
    ProgressDialog progressDialog;
    com.android.volley.RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et1=(EditText)findViewById(R.id.pName) ;
        et2=(EditText)findViewById(R.id.pEmail) ;
        et3=(EditText)findViewById(R.id.pCollege) ;
        et4=(EditText)findViewById(R.id.pPhone) ;
        et5=(EditText) findViewById(R.id.pEvent) ;
        but=(Button)findViewById(R.id.send) ;
        queue = Volley.newRequestQueue(getApplicationContext());
        Log.i(myTag, "OnCreate()");
        et5.setText(getIntent().getStringExtra("EventName"));
        //et5.setEditableFactory();

        progressDialog= new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Setting you Up...");

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((et1.getText().toString().isEmpty())||(et2.getText().toString().isEmpty())||(et3.getText().toString().isEmpty())
                        ||(et4.getText().toString().isEmpty())|| (et5.getText().toString().isEmpty())){
                    Snackbar.make(but, "Fields Left Empty", Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    postData(et1.getText().toString(),et2.getText().toString(),et3.getText().toString()
                            ,et4.getText().toString(),et5.getText().toString());}
            }
        });
    }

    public void postData(final String name, final String email, final String college
            ,final String phone, final String event) {

        progressDialog.show();
        final String fullUrl =
                "https://docs.google.com/forms/d/e/1FAIpQLSc8ECMznANTKHjC7Ga8TTjxmjRGm-YD1lWSdfgI_Wz-Ar-QFw/formResponse";
        StringRequest request = new StringRequest(
                Request.Method.POST,
                fullUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("TAG", "Response: " + response);
                        if (response.length() > 0) {
                            Snackbar.make(but, "Successfully Posted", Snackbar.LENGTH_LONG).show();
                            Toast.makeText(Register.this, "Successfully Posted", Toast.LENGTH_SHORT).show();
                            et1.setText("");
                            et2.setText("");
                            et3.setText("");
                            et4.setText("");
                            et5.setText("");

                            //Dialog Code

                            finish();
                        } else {
                            Snackbar.make(but, "Try Again", Snackbar.LENGTH_LONG).show();
                            Toast.makeText(Register.this, "Try Again", Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Snackbar.make(but, "Error while Posting Data", Snackbar.LENGTH_LONG).show();
                Toast.makeText(Register.this, "Error while Posting Data", Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("entry.979232226", name);
                params.put("entry.1239318206", email);
                params.put("entry.1925872911", phone);
                params.put("entry.920357251", college);
                params.put("entry.1802325401",event);
                return params;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(
                50000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);
    }
}

