package com.kh.myapp3;

import com.kh.myapp3.web.form.LoginForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/")
public class HomeController {

  @GetMapping
  public String home() {
    //세션이 존재하면 로그인 후 화면 이동
    //세션이 없으면 로그인 전 화면 이동
    return "beforeLogin";
  }

  //로그인 화면
  @GetMapping("/login")
  public String loginForm(@ModelAttribute("form") LoginForm loginForm){

    return "login";
  }

  //로그인 처리
  @PostMapping("/login")
  public String login(@Valid @ModelAttribute("form") LoginForm loginForm,
                      BindingResult bindingResult){
    //기본 검증
    if (bindingResult.hasErrors()) {
      log.info("bindingResult={}",bindingResult);
      return "login";
    }

    //회원유무


    //회원인경우
    //세션에 회원정보 저장


    return "afterLogin";
  }
}
