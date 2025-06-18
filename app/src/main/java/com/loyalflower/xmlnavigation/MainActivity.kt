package com.loyalflower.xmlnavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController

// MainActivity는 AppCompatActivity를 상속하여 액티비티의 생명주기와 UI를 관리
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // activity_main.xml 레이아웃을 이 액티비티에 표시
        setContentView(R.layout.activity_main)

        // FragmentContainerView에서 NavHostFragment를 찾아 가져옴
        // NavHostFragment는 Navigation Component의 호스트 역할을 함
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment

        // supportFragmentManager = 현재 액티비티 안에 있는 프래그먼트들을 관리하는 객체

        // NavController는 현재 탐색 상태를 제어하는 객체
        val navController = navHostFragment.navController

        // 액션바(툴바)와 NavController를 연결하여 뒤로가기 버튼 및 타이틀 자동 설정
        setupActionBarWithNavController(navController)
    }

    // 액션바의 뒤로가기 버튼 눌렀을 때의 동작 정의
    override fun onSupportNavigateUp(): Boolean {
        // NavController를 다시 가져와 현재 네비게이션 상태를 추적
        val navController =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container)!!
                .findNavController()

        // NavController에 현재 백스택을 따라 뒤로 가도록 요청하거나,
        // 더 이상 뒤로 갈 수 없으면 기본 뒤로가기 동작 수행
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
