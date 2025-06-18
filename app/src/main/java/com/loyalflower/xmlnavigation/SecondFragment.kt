package com.loyalflower.xmlnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.loyalflower.xmlnavigation.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    // ViewBinding 객체를 저장하는 nullable 변수
    // Fragment 뷰 라이프사이클에 맞춰 안전하게 접근하기 위함
    private var _binding: FragmentSecondBinding? = null

    // non-nullable한 binding 프로퍼티, _binding이 null일 땐 예외 발생
    // 편리하게 binding 객체에 접근하기 위해 사용
    private val binding get() = _binding!!

    // Fragment의 뷰를 생성하는 메서드
    override fun onCreateView(
        inflater: LayoutInflater,  // XML을 View 객체로 만드는 역할
        container: ViewGroup?,     // 부모 ViewGroup
        savedInstanceState: Bundle?
    ): View {
        // FragmentSecondBinding을 이용해 레이아웃을 inflate(부풀림)
        // container는 부모 뷰로 지정하고 attachToParent는 false
        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        // inflate된 root 뷰를 반환하여 Fragment에 보여줌
        return binding.root
    }

    // Fragment 뷰가 파괴될 때 호출되는 메서드
    override fun onDestroyView() {
        super.onDestroyView()
        // 메모리 누수를 방지하기 위해 binding 참조를 null로 초기화
        _binding = null
    }
}
