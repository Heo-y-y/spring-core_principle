package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

//OrderServiceImpl 입장에서 생성자를 통해 어떤 구현 객체가 들어올지(주입될지)는 알 수 없다.
//OrderServiceImpl 의 생성자를 통해서 어떤 구현 객체을 주입할지는 오직 외부( AppConfig )에서 결정한다.
//OrderServiceImpl 은 이제부터 실행에만 집중하면 된다.
public class OrderServiceImpl implements OrderService{
    //OrderServiceImpl 에는 MemoryMemberRepository , FixDiscountPolicy 객체의 의존관계가 주입된다.

    private final MemberRepository memberRepository;
    //설계 변경으로 OrderServiceImpl 은 FixDiscountPolicy 를 의존하지 않고, 단지 DiscountPolicy 인터페이스만 의존한다.
    private final DiscountPolicy discountPolicy; // 구체에 의존하지않고, 추상화 인터페이스에 의존하게 한다.

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
