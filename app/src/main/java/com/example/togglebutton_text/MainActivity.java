package com.example.togglebutton_text;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.content.ContextCompat;

import com.example.togglebutton_text.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 예시: 버튼 클릭 시 setXMLToggle 호출
        binding.viewTv.setOnClickListener(v -> setXMLToggle(true));
        binding.subScriberTv.setOnClickListener(v -> setXMLToggle(false));
    }

    private void setXMLToggle(boolean isViewClicked) {
        if (isViewClicked) {
            binding.subScriberTv.setTextColor(ContextCompat.getColor(this, R.color.text));
            binding.subScriberTv.setBackgroundResource(0);
            binding.viewTv.setTextColor(ContextCompat.getColor(this, R.color.white));
            binding.viewTv.setBackgroundResource(R.drawable.item_bg_on);
        } else {
            binding.subScriberTv.setTextColor(ContextCompat.getColor(this, R.color.white));
            binding.subScriberTv.setBackgroundResource(R.drawable.item_bg_on);
            binding.viewTv.setTextColor(ContextCompat.getColor(this, R.color.text));
            binding.viewTv.setBackgroundResource(0);
        }
    }
}

