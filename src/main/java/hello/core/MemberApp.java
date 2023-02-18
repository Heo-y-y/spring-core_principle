package hello.core;

import hello.core.member.Gradle;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MemberApp {
    public static void main(String[] args) { // psvm = 메인메서드 한번에 생성
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
        //순수 자바코드
        //MemberService memberService = new MemberServiceImpl();
        //ApplicationContext 를 스프링 컨테이너라 한다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //스프링 빈은 applicationContext.getBean() 메서드를 사용해서 찾을 수 있다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Gradle.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
