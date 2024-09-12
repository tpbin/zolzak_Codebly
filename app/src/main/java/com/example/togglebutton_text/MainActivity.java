package com.example.togglebutton_text;

import android.os.Bundle;
import android.view.ViewTreeObserver;
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

        // 알림과 공지사항 텍스트뷰를 LinearLayout의 가로 길이에 맞추기
        ViewTreeObserver viewTreeObserver = binding.xmlLinear.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                // LinearLayout의 너비를 얻어와서 알림과 공지사항 텍스트뷰에 적용
                int linearWidth = binding.xmlLinear.getWidth();
                binding.viewContent.setWidth(linearWidth);
                binding.subscriberContent.setWidth(linearWidth);

                // 리스너 제거 (한 번만 실행)
                binding.xmlLinear.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });

        // 기본으로 알림 텍스트뷰를 보이게 설정
        binding.viewContent.setVisibility(TextView.VISIBLE);

        // 예시: 버튼 클릭 시 setXMLToggle 호출
        binding.viewTv.setOnClickListener(v -> setXMLToggle(true));
        binding.subScriberTv.setOnClickListener(v -> setXMLToggle(false));
    }

    private void setXMLToggle(boolean isViewClicked) {
        if (isViewClicked) {
            // 알림 선택 시
            binding.subScriberTv.setTextColor(ContextCompat.getColor(this, R.color.text));
            binding.subScriberTv.setBackgroundResource(0);
            binding.viewTv.setTextColor(ContextCompat.getColor(this, R.color.white));
            binding.viewTv.setBackgroundResource(R.drawable.item_bg_on);

            // 알림 텍스트뷰 보이기
            binding.viewContent.setVisibility(TextView.VISIBLE);
            binding.subscriberContent.setVisibility(TextView.GONE);
        } else {
            // 공지사항 선택 시
            binding.subScriberTv.setTextColor(ContextCompat.getColor(this, R.color.white));
            binding.subScriberTv.setBackgroundResource(R.drawable.item_bg_on);
            binding.viewTv.setTextColor(ContextCompat.getColor(this, R.color.text));
            binding.viewTv.setBackgroundResource(0);

            // 공지사항 텍스트뷰 보이기
            binding.viewContent.setVisibility(TextView.GONE);
            binding.subscriberContent.setVisibility(TextView.VISIBLE);
        }
    }
}

