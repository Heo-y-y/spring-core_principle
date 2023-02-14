package hello.core;

import hello.core.member.Gradle;
import hello.core.member.Member;
import hello.core.member.MemberService;


public class MemberApp {
    public static void main(String[] args) { // psvm = 메인메서드 한번에 생성
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        //순수 자바코드
        //MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Gradle.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
