package at.htlgkr.gaert;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import at.htlgkr.gaert.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private Dashboard dashboard;
    private Button[] btLeft;
    private Button[] btRight;

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public void registerForContextMenu(@NonNull View view) {
        super.registerForContextMenu(view);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);

        dashboard.setTemperature(20.1f);

        dashboard = new Dashboard();
        dashboard.addTemperatureConverter(value -> value + " °C");
        dashboard.addTemperatureConverter(value -> {

            return value + " °F";
        });

        btLeft = new Button[4];
        btLeft[0] = binding.btPressL;
        btLeft[1] = binding.btSpeedL;
        btLeft[2] = binding.btTempL;
        btLeft[3] = binding.btTimeL;

        btRight = new Button[4];
        btLeft[0] = binding.btPressR;
        btLeft[1] = binding.btSpeedR;
        btLeft[2] = binding.btTempR;
        btLeft[3] = binding.btTimeR;

        for (Button b : btLeft) {
            b.setOnClickListener(view -> {
                if (b.getId() == R.id.btTempL){
                    dashboard.reduceIndTemp();
                    dashboard.displayableTemperature();
                }else if (b.getId() == R.id.btPressL){
                    dashboard.reduceIndPress();
                    dashboard.displayablePressure();
                }else if (b.getId() == R.id.btTimeL){
                    dashboard.reduceIndTime();
                    dashboard.addIndTime();
                }else {
                    dashboard.reduceIndSpeed();
                    dashboard.displayableSpeed();
                }
            });
        }

        for (Button b : btRight) {
            b.setOnClickListener(view -> {
                if (b.getId() == R.id.btTempR){
                    dashboard.addIndTemp();
                    dashboard.displayableTemperature();
                }else if (b.getId() == R.id.btPressR){
                    dashboard.addIndPress();
                    dashboard.displayablePressure();
                }else if (b.getId() == R.id.btTimeR){
                    dashboard.addIndTime();
                    dashboard.displayableTime();
                }else {
                    dashboard.addIndSpeed();
                    dashboard.displayableSpeed();
                }
            });
        }

        return binding.getRoot();
    }
}