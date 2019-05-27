package br.com.fabriciohsilva.cooltrips.view.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import br.com.fabriciohsilva.cooltrips.R;
import br.com.fabriciohsilva.cooltrips.dao.PackageDAO;
import br.com.fabriciohsilva.cooltrips.model.Package;

public class PackageListActivity extends AppCompatActivity {

    public static final String APPBAR_TITLE = "Packages";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_list);

        setTitle(APPBAR_TITLE);
        configList();
    }

    private void configList() {
        ListView packageList = findViewById(R.id.package_list_listview);
        List<Package> packages = new PackageDAO().lista();
        packageList.setAdapter(new PackageListAdapter(packages, this));
    }
}
