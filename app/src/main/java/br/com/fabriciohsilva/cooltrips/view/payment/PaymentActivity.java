package br.com.fabriciohsilva.cooltrips.view.payment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.fabriciohsilva.cooltrips.R;
import br.com.fabriciohsilva.cooltrips.model.Package;
import br.com.fabriciohsilva.cooltrips.util.CurrencyUtil;
import br.com.fabriciohsilva.cooltrips.view.PurchaseSummary.PurchaseSummaryActivity;

import static br.com.fabriciohsilva.cooltrips.Interfaces.Constants.KEY_PACKAGE;

public class PaymentActivity extends AppCompatActivity {

    public static final String APPBAR_TITLE = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        setTitle(APPBAR_TITLE);

        getReceivedPckg();

    }

    private void getReceivedPckg() {
        Intent intent = getIntent();
        if (intent.hasExtra(KEY_PACKAGE)) {
            final Package pckg = (Package) intent.getSerializableExtra(KEY_PACKAGE);

            showPrice(pckg);

            configButton(pckg);
        }
    }

    private void configButton(final Package pckg) {
        Button btnPaymentFinish = findViewById(R.id.payment_finish);

        btnPaymentFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPurchaseSummary(pckg);
            }
        });
    }

    private void goToPurchaseSummary(Package pckg) {
        Intent intent = new Intent(PaymentActivity.this, PurchaseSummaryActivity.class);
        intent.putExtra("package", pckg);
        startActivity(intent);
    }

    private void showPrice(Package pckg) {
        TextView price = findViewById(R.id.payment_pkg_price);
        String brasilianCurrency = CurrencyUtil.formatBrasilianString(pckg.getPrice());
        price.setText(brasilianCurrency);
    }
}
