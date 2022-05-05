package sg.edu.rp.c346.id21024120.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    //1 - create handles
    TextView amount;
    EditText editamount;
    TextView paxNo;
    EditText editPaxNo;
    ToggleButton tbSvs;
    ToggleButton tbGst;
    TextView discount;
    EditText editdiscount;
    RadioGroup rg;
    Button split;
    Button reset;
    TextView totalBill;
    TextView eachPays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2 - bridge UI with controller
        amount = findViewById(R.id.amount);
        editamount = findViewById(R.id.editamount);
        paxNo = findViewById(R.id.paxNo);
        editPaxNo = findViewById(R.id.editPaxNo);
        tbSvs = findViewById(R.id.tbSvs);
        tbGst = findViewById(R.id.tbGst);
        discount = findViewById(R.id.discount);
        editdiscount = findViewById(R.id.editdiscount);
        rg = findViewById(R.id.rg);
        split = findViewById(R.id.split);
        reset = findViewById(R.id.reset);
        totalBill = findViewById(R.id.totalBill);
        eachPays = findViewById(R.id.eachPays);

        split.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (editamount.getText().toString().length() != 0 && editPaxNo.getText().toString().length() == 0) {
                    //do nothing
                } else {
                    String data1 = editamount.getText().toString();
                    String data2 = editPaxNo.getText().toString();

                    double amount = Double.parseDouble(data1);
                    double newAmount = 0;
                    int paxNo = Integer.parseInt(data2);

                    if (tbGst.isChecked() == true && tbSvs.isChecked() == true) {
                         newAmount = amount * 1.10 * 1.07;
                    } else if (tbGst.isChecked() == false && tbSvs.isChecked() == true) {
                        newAmount = amount * 1.10;
                    } else if (tbGst.isChecked() == true && tbSvs.isChecked() == false) {
                        newAmount = amount * 1.07;
                    } else {
                        newAmount = amount;
                }

                    double eachPays = newAmount / paxNo;
                    totalBill.setText("$" + newAmount + "");

                    double msg = String.format("%.2f", eachPays);
                    tvEachPays.setText("Each pays: $" + msg + "");

            }
        });

        }

    }

}
