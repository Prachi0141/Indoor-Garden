package com.example.esp;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class MainActivity extends AppCompatActivity {
    EditText input;
    TextView result;
    TextView readt;
    TextView readm;
    TextView readh;


    String rep;
   // class DoneOnEditorActionListener implements TextView.OnEditorActionListener {
    //    @Override
    //    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
    //        if (actionId == EditorInfo.IME_ACTION_DONE) {
    //            InputMethodManager imm = (InputMethodManager)v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
     //           imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
       //         return true;
      //      }
       //     return false;
      //  }
    //}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // input = (EditText)findViewById(R.id.url);
       // input.setOnEditorActionListener(new DoneOnEditorActionListener());



        input = (EditText)findViewById(R.id.url);
        result = (TextView) findViewById(R.id.result);
        readt = (TextView) findViewById(R.id.readt);
        readh = (TextView) findViewById(R.id.readh);
        readm = (TextView) findViewById(R.id.readm);
        Button fan = (Button)findViewById(R.id.fan);
        Button pump = (Button)findViewById(R.id.pump);
        Button light = (Button)findViewById(R.id.light);
        Button temp = (Button)findViewById(R.id.temp);
        Button humidity = (Button)findViewById(R.id.humidity);
        Button moisture = (Button)findViewById(R.id.moisture);
        Button go = (Button)findViewById(R.id.go);
        ImageButton left = (ImageButton)findViewById(R.id.left);
        ImageButton right = (ImageButton)findViewById(R.id.right);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try  {
                    InputMethodManager imm = (InputMethodManager) getSystemService(
                          INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                }
                catch (Exception e) {
                    Log.d("Error","Error!");
                }
            }
        });



    fan.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View v) {

                                     String ip = input.getText().toString();
                                     String val1 = "11";
                                     String url = "http://" + ip + "/" + val1;
                                     StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                                     StrictMode.setThreadPolicy(policy);
                                        Log.i("URL:",url);
                                        // Instantiate the RequestQueue.
                                     RequestQueue queue;
                                     queue = Volley.newRequestQueue(MainActivity.this);
                                     ;


                                     // Request a string response from the provided URL.
                                     StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                                             new Response.Listener<String>() {
                                                 @Override
                                                 public void onResponse(String response) {
                                                     // Display the first 500 characters of the response string.

                                                     Log.i("fan:",response);
                                                     result.setText(response);
                                                 }
                                             }, new Response.ErrorListener() {
                                         @Override
                                         public void onErrorResponse(VolleyError error) {
                                             Log.i("error:",error.getMessage());
                                             result.setText("Fan not responding");
                                         }
                                     });
                                     // Add the request to the RequestQueue.
                                     queue.add(stringRequest);

                                 }
                             }
    );


                pump.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String ip = input.getText().toString();
                        String val1 = "00";
                        String url = "http://" + ip + "/" + val1;
                        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                        StrictMode.setThreadPolicy(policy);

                        // Instantiate the RequestQueue.
                        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                        ;


                        // Request a string response from the provided URL.
                        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        // Display the first 500 characters of the response string.
                                        result.setText(response);
                                    }
                                }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                result.setText("Pump not responding");
                            }
                        });
                        // Add the request to the RequestQueue.
                        queue.add(stringRequest);
                    }
                }
    );

        light.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {

                                       String ip = input.getText().toString();
                                       String val1 = "10";
                                       String url = "http://" + ip + "/" + val1;
                                       StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                                       StrictMode.setThreadPolicy(policy);

                                       // Instantiate the RequestQueue.
                                       RequestQueue queue;
                                       queue = Volley.newRequestQueue(MainActivity.this);
                                       ;


                                       // Request a string response from the provided URL.
                                       StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                                               new Response.Listener<String>() {
                                                   @Override
                                                   public void onResponse(String response) {
                                                       // Display the first 500 characters of the response string.
                                                       result.setText(response);
                                                   }
                                               }, new Response.ErrorListener() {
                                           @Override
                                           public void onErrorResponse(VolleyError error) {
                                               result.setText("Lights not responding");
                                           }
                                       });
                                       // Add the request to the RequestQueue.
                                       queue.add(stringRequest);
                                   }
                               }
        );

        temp.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {

                                       String ip = input.getText().toString();
                                       String val1 = "t";
                                       String url = "http://" + ip + "/" + "t";
                                       StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                                       StrictMode.setThreadPolicy(policy);

                                       // Instantiate the RequestQueue.
                                       RequestQueue queue;
                                       queue = Volley.newRequestQueue(MainActivity.this);
                                       ;


                                       // Request a string response from the provided URL.
                                       StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                                               new Response.Listener<String>() {
                                                   @Override
                                                   public void onResponse(String response) {
                                                       // Display the first 500 characters of the response string.
                                                       readt.setText(response);

                                                   }
                                               }, new Response.ErrorListener() {
                                           @Override
                                           public void onErrorResponse(VolleyError error) {
                                               result.setText("That didn't work!");
                                           }
                                       });
                                       // Add the request to the RequestQueue.
                                       queue.add(stringRequest);
                                   }
                               }
        );
        humidity.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {

                                       String ip = input.getText().toString();
                                       String val1 = "h";
                                       String url = "http://" + ip + "/" + val1;
                                       StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                                       StrictMode.setThreadPolicy(policy);

                                       // Instantiate the RequestQueue.
                                       RequestQueue queue;
                                       queue = Volley.newRequestQueue(MainActivity.this);
                                       ;


                                       // Request a string response from the provided URL.
                                       StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                                               new Response.Listener<String>() {
                                                   @Override
                                                   public void onResponse(String response) {
                                                       // Display the first 500 characters of the response string.
                                                       readh.setText(response);
                                                   }
                                               }, new Response.ErrorListener() {
                                           @Override
                                           public void onErrorResponse(VolleyError error) {
                                               result.setText("That didn't work");
                                           }
                                       });
                                       // Add the request to the RequestQueue.
                                       queue.add(stringRequest);
                                   }
                               }
        );

        moisture.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {

                                       String ip = input.getText().toString();
                                       String val1 = "m";
                                       String url = "http://" + ip + "/" + val1;
                                       StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                                       StrictMode.setThreadPolicy(policy);

                                       // Instantiate the RequestQueue.
                                       RequestQueue queue;
                                       queue = Volley.newRequestQueue(MainActivity.this);
                                       ;


                                       // Request a string response from the provided URL.
                                       StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                                               new Response.Listener<String>() {
                                                   @Override
                                                   public void onResponse(String response) {
                                                       // Display the first 500 characters of the response string.
                                                       readm.setText(response);
                                                   }
                                               }, new Response.ErrorListener() {
                                           @Override
                                           public void onErrorResponse(VolleyError error) {
                                               result.setText("That didn't work!");
                                           }
                                       });
                                       // Add the request to the RequestQueue.
                                       queue.add(stringRequest);
                                   }
                               }
        );


        left.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {

                                       String ip = input.getText().toString();
                                       String val1 = "l";
                                       String url = "http://" + ip + "/" + val1;
                                       StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                                       StrictMode.setThreadPolicy(policy);
                                       Log.i("URL:",url);
                                       // Instantiate the RequestQueue.
                                       RequestQueue queue;
                                       queue = Volley.newRequestQueue(MainActivity.this);
                                       ;


                                       // Request a string response from the provided URL.
                                       StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                                               new Response.Listener<String>() {
                                                   @Override
                                                   public void onResponse(String response) {
                                                       // Display the first 500 characters of the response string.

                                                       Log.i("Towards_left:",response);
                                                       result.setText(response);
                                                   }
                                               }, new Response.ErrorListener() {
                                           @Override
                                           public void onErrorResponse(VolleyError error) {
                                               Log.i("error:",error.getMessage());
                                               result.setText("Stepper motor not responding");
                                           }
                                       });
                                       // Add the request to the RequestQueue.
                                       queue.add(stringRequest);

                                   }
                               }
        );

        right.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        String ip = input.getText().toString();
                                        String val1 = "r";
                                        String url = "http://" + ip + "/" + val1;
                                        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                                        StrictMode.setThreadPolicy(policy);
                                        Log.i("URL:",url);
                                        // Instantiate the RequestQueue.
                                        RequestQueue queue;
                                        queue = Volley.newRequestQueue(MainActivity.this);
                                        ;


                                        // Request a string response from the provided URL.
                                        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                                                new Response.Listener<String>() {
                                                    @Override
                                                    public void onResponse(String response) {
                                                        // Display the first 500 characters of the response string.

                                                        Log.i("Towards_right:",response);
                                                        result.setText(response);
                                                    }
                                                }, new Response.ErrorListener() {
                                            @Override
                                            public void onErrorResponse(VolleyError error) {
                                                Log.i("error:",error.getMessage());
                                                result.setText("Stepper motor not responding");
                                            }
                                        });
                                        // Add the request to the RequestQueue.
                                        queue.add(stringRequest);

                                    }
                                }
        );



    }}
