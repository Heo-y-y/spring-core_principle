package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//MemberServiceImpl 입장에서 생성자를 통해 어떤 구현 객체가 들어올지(주입될지)는 알 수 없다.
//MemberServiceImpl 은 이제부터 의존관계에 대한 고민은 외부에 맡기고 실행에만 집중하면 된다.
@Component
public class MemberServiceImpl implements MemberService{

    //설계 변경으로 MemberServiceImpl 은 MemoryMemberRepository 를 의존하지 않고, 단지 MemberRepository 인터페이스만 의존한다.
    private final MemberRepository memberRepository;

    //MemberServiceImpl 의 생성자를 통해서 어떤 구현 객체를 주입할지는 오직 외부( AppConfig )에서 결정된다.
    @Autowired //@Autowired 는 의존관계를 자동으로 주입해준다
    //getBean(MemberRepository.class) 와 동일하다고 이해하면 된다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
