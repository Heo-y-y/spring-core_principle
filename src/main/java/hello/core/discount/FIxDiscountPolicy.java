package hello.core.discount;

import hello.core.member.Gradle;
import hello.core.member.Member;

public class FIxDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGradle() == Gradle.VIP) { // 이넘 타입은 == 쓰는게 맞음
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
