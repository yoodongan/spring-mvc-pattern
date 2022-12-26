package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.v3.ModelView;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public ModelView process(Map<String, String> paramMap) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();
        // ModelView : model 도 직접 만들고(HttpServletRequest 의존 제거), viewName 도 논리명으로 변경(view path 중복 제거)
        ModelView mv = new ModelView("members");
        mv.getModel().put("members", members);
        return mv;
    }
}
