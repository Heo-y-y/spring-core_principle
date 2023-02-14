package hello.core.order;

// 최족 Order 결과를 반환을 함
public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
