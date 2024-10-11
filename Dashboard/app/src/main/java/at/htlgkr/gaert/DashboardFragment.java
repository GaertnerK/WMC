package at.htlgkr.gaert;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import at.htlgkr.gaert.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private Dashboard dashboard;
    private Button[] btLeft;
    private Button[] btRight;
    private TextView tvTemp;
    private TextView tvPressure;
    private TextView tvSpeed;
    private TextView tvTime;

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
        dashboard = new Dashboard();

        tvTemp = binding.tvTemp;
        tvPressure = binding.tvPress;
        tvSpeed = binding.tvSpeed;
        tvTime = binding.tvTime;

        dashboard.addTemperatureConverter(value -> value + " °C");
        dashboard.addTemperatureConverter(value -> {
            float temp = (float) ((value * 1.8) + 32);
            return temp + " °F";
        });
        dashboard.addTemperatureConverter(value -> {
            value = value + 273.15f;
            return value + "K";
        });

        btLeft = new Button[4];
        btLeft[0] = binding.btPressL;
        btLeft[1] = binding.btSpeedL;
        btLeft[2] = binding.btTempL;
        btLeft[3] = binding.btTimeL;

        btRight = new Button[4];
        btRight[0] = binding.btPressR;
        btRight[1] = binding.btSpeedR;
        btRight[2] = binding.btTempR;
        btRight[3] = binding.btTimeR;

        dashboard.setTemperature(20.1f);
        tvTemp.setText(dashboard.displayableTemperature());

        for (Button b : btLeft) {
            b.setOnClickListener(view -> {
                if (b.getId() == R.id.btTempL){
                    dashboard.reduceIndTemp();
                    tvTemp.setText(dashboard.displayableTemperature());
                }else if (b.getId() == R.id.btPressL){
                    dashboard.reduceIndPress();
                    tvPressure.setText(dashboard.displayablePressure());
                }else if (b.getId() == R.id.btTimeL){
                    dashboard.reduceIndTime();
                    tvTime.setText(dashboard.displayableTime());
                }else {
                    dashboard.reduceIndSpeed();
                    tvSpeed.setText(dashboard.displayableSpeed());
                }
            });
        }

        for (Button b : btRight) {
            b.setOnClickListener(view -> {
                if (b.getId() == R.id.btTempR){
                    dashboard.addIndTemp();
                    tvTemp.setText(dashboard.displayableTemperature());
                }else if (b.getId() == R.id.btPressR){
                    dashboard.addIndPress();
                    tvPressure.setText(dashboard.displayablePressure());
                }else if (b.getId() == R.id.btTimeR){
                    dashboard.addIndTime();
                    tvTime.setText(dashboard.displayableTime());
                }else {
                    dashboard.addIndSpeed();
                    tvSpeed.setText(dashboard.displayableSpeed());
                }
            });
        }

        return binding.getRoot();
    }
}