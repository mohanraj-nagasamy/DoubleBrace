import java.util.*;

/**
 * Created by mohanraj.nagasamy on 8/8/13.
 */
public class DoubleBraceMain {
    final static Set<OrderStatus> VALID_ORDER_STATUSES = new HashSet<OrderStatus>();

    static {
        VALID_ORDER_STATUSES.add(new OrderStatus("01", "Order Placed"));
        VALID_ORDER_STATUSES.add(new OrderStatus("02", "Order Processed"));
        VALID_ORDER_STATUSES.add(new OrderStatus("03", "Order Cancelled"));
        VALID_ORDER_STATUSES.add(new OrderStatus("04", "Order Failed"));
    }


    final static Set<OrderStatus> VALID_ORDER_STATUSES_WITH_DOUBLE_BRACE = new HashSet<OrderStatus>() { {
            add(new OrderStatus("01", "Order Placed"));
            add(new OrderStatus("02", "Order Processed"));
            add(new OrderStatus("03", "Order Cancelled"));
            add(new OrderStatus("04", "Order Failed"));
        } };

    private static OrderStatus INVALID_ORDER_STATUS = new OrderStatus() { {
            setCode("XX");
            setDescription("Invalid");
        } };

    private static OrderStatus INVALID_ORDER_STATUS_2 = new OrderStatus() { {
            setCode("XX");
            setDescription("Invalid");
        } };


    public static void main(String[] args) {
        OrderStatus INVALID_ORDER_STATUS_3 = new OrderStatus();
        INVALID_ORDER_STATUS_3.setCode("XX");
        INVALID_ORDER_STATUS_3.setDescription("Invalid");

        System.out.println("INVALID_ORDER_STATUS.equals(INVALID_ORDER_STATUS_2) = " + INVALID_ORDER_STATUS.equals(INVALID_ORDER_STATUS_2));
        System.out.println("INVALID_ORDER_STATUS.equals(INVALID_ORDER_STATUS_3) = " + INVALID_ORDER_STATUS.equals(INVALID_ORDER_STATUS_3));

        boolean contains = VALID_ORDER_STATUSES_WITH_DOUBLE_BRACE.contains(new OrderStatus("01", "Order Placed"));
        System.out.println("contains = " + contains);

        Action action = new Action() { {
                step1();
                step2();
            } };
        String result = action.result();
        System.out.println("action result = " + result);

    }

}
