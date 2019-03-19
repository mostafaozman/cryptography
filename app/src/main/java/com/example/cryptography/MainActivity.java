package com.example.cryptography;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    Button Encrypt;
    Button Decrypt;

    TextView original;
    AlertDialog dialog;
    EditText editText;

    TextView shift;
    AlertDialog dialog1;
    EditText editText1;

    TextView Encrypted;

    RadioButton ButtonScytle;
    RadioButton ButtonCaesar;
    RadioButton ButtonVingeare;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Encrypt = (Button) this.findViewById(R.id.button);
        Encrypt.setOnClickListener(this);
        Decrypt = (Button) this.findViewById(R.id.button2);
        Decrypt.setOnClickListener(this);
        ButtonScytle = (RadioButton) this.findViewById(R.id.ButtonScytle);
        ButtonCaesar = (RadioButton) this.findViewById(R.id.ButtonCaesar);
        ButtonVingeare = (RadioButton) this.findViewById(R.id.ButtonVingeare);
        Encrypted = (TextView) findViewById(R.id.Encrypted);

        original = (TextView) findViewById(R.id.original);
        dialog = new AlertDialog.Builder(this).create();
        editText = new EditText(this);
        dialog.setTitle("Edit The Text");
        dialog.setView(editText);
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Save Text", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                original.setText(editText.getText());
            }
        });

        original.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                editText.setText(original.getText());
                dialog.show();
            }
        });



        shift = (TextView) findViewById(R.id.shift);
        dialog1 = new AlertDialog.Builder(this).create();
        editText1 = new EditText(this);
        dialog1.setTitle("Edit The Text");
        dialog1.setView(editText1);
        dialog1.setButton(DialogInterface.BUTTON_POSITIVE, "Save Text", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                shift.setText(editText1.getText());
            }
        });

        shift.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                editText1.setText(shift.getText());
                dialog1.show();
            }
        });


    }


    @Override
    public void onClick(View v)
    {

        if (v.equals(Encrypt) && ButtonCaesar.isChecked())
        {
            String Toriginal = original.getText().toString();
            int Tshift = Integer.parseInt(shift.getText().toString());

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Parameters");
            alertDialogBuilder
                    .setMessage(Toriginal + " " + Tshift)
                    .setCancelable(false)
                    .setPositiveButton("OK",new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog,int id)
                        {
                            dialog.dismiss();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

                String Tencrypted = "";
                int len = Toriginal.length();
                Toriginal = Toriginal.toUpperCase();
                /*Toriginal = Toriginal.replaceAll("\\s", "");
                Toriginal = Toriginal.replaceAll(".", "");
                Toriginal = Toriginal.replaceAll("!", "");
                Toriginal = Toriginal.replaceAll("\\?", "");
                Toriginal = Toriginal.replaceAll("@", "");
                Toriginal = Toriginal.replaceAll("\\*", "");
                */
            for(int i = 0; i < len; i++)
                {
                    char c = (char)(Toriginal.charAt(i) + Tshift);
                    if (c > 'z')
                    {
                        Tencrypted += (char)(Toriginal.charAt(i) - (26 - Tshift));
                    }
                    else
                    {
                        Tencrypted += (char)(Toriginal.charAt(i) + Tshift);
                    }
                }

                Encrypted.setText(Tencrypted);


        }

    }


}
