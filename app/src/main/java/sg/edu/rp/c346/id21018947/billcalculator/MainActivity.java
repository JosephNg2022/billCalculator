package sg.edu.rp.c346.id21018947.billcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {

    TextView tvAmt;
    TextView tvPax;
    TextView tvDiscount;
    TextView tvTotalBill;
    TextView tvEachPays;
    EditText etAmt;
    EditText etPax;
    EditText etDiscount;
    ToggleButton tbSVS;
    ToggleButton tbGST;
    RadioGroup rgPayment;
    Button btnSplit;
    Button btnReset;
    RadioButton radioCash;
    RadioButton radioPayNow;
    String totalBill = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAmt = findViewById(R.id.textViewAmt);
        tvPax = findViewById(R.id.textViewPax);
        tvDiscount = findViewById(R.id.textViewDiscount);
        tvTotalBill = findViewById(R.id.textViewTotal);
        tvEachPays = findViewById(R.id.textViewEach);
        etAmt = findViewById(R.id.editTextAmt);
        etPax = findViewById(R.id.editTextPax);
        etDiscount = findViewById(R.id.editTextDiscount);
        tbSVS = findViewById(R.id.toggleButtonSVS);
        tbGST = findViewById(R.id.toggleButtonGST);
        btnSplit = findViewById(R.id.buttonSplit);
        btnReset = findViewById(R.id.buttonReset);
        rgPayment = findViewById(R.id.radioGroupPayment);
        radioCash = findViewById(R.id.radioButtonCash);
        radioPayNow = findViewById(R.id.radioButtonPayNow);
        totalBill = etAmt.getText().toString();

        tbSVS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tbSVS.isEnabled()) {
                    int amt = Integer.valueOf(etAmt.getText().toString());
                    totalBill = String.valueOf(amt * 110);
                    tvTotalBill.setText(totalBill);
                } else {
                    tvTotalBill.setText(String.valueOf(etAmt));
                }
            }
        });

        tbGST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tbSVS.isEnabled()) {
                    int amt = Integer.valueOf(etAmt.getText().toString());
                    totalBill = String.valueOf(amt * 110);
                    tvTotalBill.setText(totalBill);
                } else {
                    tvTotalBill.setText(String.valueOf(etAmt));
                }
            }
        });

        etDiscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int discount = 100 - Integer.valueOf(etDiscount.getText().toString());
                tvTotalBill.setText(String.valueOf(new Integer(tvTotalBill.getText().toString()) * discount));
            }
        });

        btnSplit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int checkRadioID = rgPayment.getCheckedRadioButtonId();
                if (checkRadioID == R.id.radioButtonCash) {
                    tvTotalBill.setText("Total Bill: $" + totalBill);

                    int pax = Integer.valueOf(etPax.getText().toString());
                    String each = String.valueOf(new Integer(tvTotalBill.getText().toString()) / pax);
                    tvEachPays.setText("Each Pays: $" + each + " in cash");
                } else if (checkRadioID == R.id.radioButtonPayNow) {
                    tvTotalBill.setText("Total Bill: $" + totalBill);

                    int pax = Integer.valueOf(etPax.getText().toString());
                    String each = String.valueOf(new Integer(tvTotalBill.getText().toString()) / pax);
                    tvEachPays.setText("Each Pays: $" + each + " via PayNow to 912345678");
                }
            }
        });
    }


}